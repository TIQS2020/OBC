package br.com.whitemartins.obc.views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.OptionType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.service.LoadService;
import br.com.whitemartins.obc.service.ValidateDeviceService;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.FileHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.PathHelper;
import br.com.whitemartins.obc.util.PermissionHelper;
import br.com.whitemartins.obc.util.SeedHelper;
import br.com.whitemartins.obc.util.UpgradeHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;
import br.com.whitemartins.obc.xml.XmlRetorno;


public class LoadTravelActivity extends BaseActivity {

  private static final int REQUEST_ACTIVATION = 1;

  ProgressBar progressBar;
  TextView textProgress;
  EditText edtVeiculo;
  EditText edtFilial;
  XmlConfig config;
  ImageButton btnConfirmarCarga;
  ImageButton btnEditarCarga;
  ImageButton btnLoadTravel;
  ImageButton btnConfigConnection;
  String zipFileName = "";
  String dtFileName = "";
  String travelNumber, travelDateStr = "";
  Date travelDate;

  private View.OnClickListener settingsClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {

      startActivity(new Intent(LoadTravelActivity.this, ConfigActivity.class));
      UtilHelper.hideKeyboardFrom(LoadTravelActivity.this, getCurrentFocus());
    }
  };

  private View.OnClickListener btnConfirmarClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      confirm();
    }
  };

  private View.OnClickListener btnEditarClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      openFields(true);
    }
  };

  private MyCallbackInterface.CallbackBooleanInterface
    finishCharge = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      String PATH = PathHelper.self().getFilePathDownload();
      File file = new File(PATH);
      file.mkdirs();
      File outputFile = new File(file, zipFileName);

      loadZipFile(outputFile);
    }
  };

  private MyCallbackInterface.CallbackBooleanInterface
    performCharge2 = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      textProgress.setText("");
      if (success) {
        readDtFile();
        showInputDialog(LoadTravelActivity.this);
      } else {
        textProgress.setText("");
        UtilHelper.setButtonStatus(LoadTravelActivity.this, btnLoadTravel, true);
      }
    }
  };

  private MyCallbackInterface.CallbackBooleanInterface
    performCharge = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      downloadDtFile();
      UtilHelper.hideKeyboardFrom(LoadTravelActivity.this, getCurrentFocus());
    }
  };

  private View.OnClickListener loadTravelClickListener = new View.OnClickListener() {
    public void onClick(View v) {

      if (UtilHelper.checkSimCard(LoadTravelActivity.this)) {
        DialogHelper.showErrorMessage(LoadTravelActivity.this, R.string.erro_text,
          R.string.no_sim_card, null);
      } else {
        PathHelper.self().clearPaths();
        textProgress.setText("");
        UtilHelper.setButtonStatus(LoadTravelActivity.this, btnLoadTravel, false);

        confirm();

        dtFileName = String.format(Locale.getDefault(), "DT%1$5s",
          GLOBAL.self().getStaticTable().getCdVeiculo()).replace(' ', '0');

        zipFileName = String.format(Locale.getDefault(), "E%1$5s",
          GLOBAL.self().getStaticTable().getCdVeiculo())
          .replace(' ', '0');

        if (!SeedHelper.isActive()) {
          DialogHelper.showInformationMessage(LoadTravelActivity.this, R.string.informar_text,
            R.string.dispositivo_nao_validado, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                activateDevice();
              }
            });

        } else
          validateSeed();
      }
    }
  };

  private void openFields(boolean open) {
    edtFilial.setEnabled(open);
    edtVeiculo.setEnabled(open);
  }

  private void confirm() {

    GLOBAL.self().getInvoiceBackgroundService().clearInvoiceList();
    GLOBAL.self().getInvoiceImageBackgroundService().clearImageList();

    if (edtFilial.getText().toString().isEmpty()) {
      DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.informar_filial,
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            edtFilial.requestFocus();
          }
        });
    } else if (edtVeiculo.getText().toString().isEmpty()) {
      DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.informar_veiculo,
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            edtVeiculo.requestFocus();
          }
        });
    } else {
      GLOBAL.self().getStaticTable().setCdFilial(edtFilial.getText().toString().toUpperCase());
      GLOBAL.self().getStaticTable().setCdVeiculo(edtVeiculo.getText().toString());
      GLOBAL.self().getStaticTable().save();

      openFields(false);
    }
  }

  private void activateDevice() {
    Intent intent = new Intent(LoadTravelActivity.this,
      ActivateDeviceActivity.class);

    startActivityForResult(intent, REQUEST_ACTIVATION);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (resultCode == CommonStatusCodes.SUCCESS) {
      if (requestCode == REQUEST_ACTIVATION) {
        processUpdate();
//        performCharge.execute(true);
      }
    } else if (resultCode == CommonStatusCodes.ERROR) {
      textProgress.setText("");
      UtilHelper.setButtonStatus(this, btnLoadTravel, true);
    }
    super.onActivityResult(requestCode, resultCode, data);
  }

  private void validateSeed() {

    new ValidateDeviceService()
      .setActivity(this)
      .setFinishExecuteCallback(new MyCallbackInterface.CallbackStringInterface() {
        @Override
        public void execute(String msgErro) {

          if (msgErro.isEmpty())
//            performCharge.execute(true);
            processUpdate();
          else
            DialogHelper.showErrorMessage(LoadTravelActivity.this,
              getString(R.string.erro_text), msgErro, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  textProgress.setText("");

                  if (XmlRetorno.self().getCodigoRetorno() != null
                    && XmlRetorno.self().getCodigoRetorno() != 0)
                    activateDevice();
                  else {
                    textProgress.setText("");
                    UtilHelper.setButtonStatus(LoadTravelActivity.this, btnLoadTravel,
                      true);
                  }
                }
              });
        }
      })
      .setTxtStatus(textProgress)
      .execute();
  }

  private void readDtFile() {
    try {
      String fileName = dtFileName;
      File file = new File(PathHelper.self().getFilePathDownload());
      File outputFile = new File(file, fileName);

      FileInputStream fis = new FileInputStream(outputFile.getPath());
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis,
        getString(R.string.app_file_encoding)));
      String line = bufferedReader.readLine();

      travelNumber = line.substring(0, 5);
      travelDateStr = line.substring(5, 13);
      travelDate = UtilHelper.convertToDate(travelDateStr, ConstantsEnum.ddMMyyyy.getValue());

    } catch (IOException e) {
      e.printStackTrace();
      LogHelper.self().error("readDtFile", e);
      DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.erro_zip_file,
        null);
    }
  }

  private void showInputDialog(final Context context) {
    final AlertDialog.Builder builder = new AlertDialog.Builder(context);
    builder.setTitle(context.getString(R.string.num_viagem_manifesto));

    final View viewInflated = LayoutInflater.from(context)
      .inflate(R.layout.activity_input_numero_viagem, null, false);

    final EditText input = viewInflated.findViewById(R.id.input);
    builder.setView(viewInflated);
    builder.setCancelable(false);

    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {

        String travelNumberScreen = input.getText().toString();

        int tnScreen = UtilHelper.convertToIntegerDef(travelNumberScreen, 0);
        int tn = UtilHelper.convertToIntegerDef(travelNumber, 0);

        if (tnScreen == tn) {
          int msg = -1;

          if (UtilHelper.currentDateTime(ConstantsEnum.ddMMyyyy.getValue()).compareTo(travelDate) < 0)
            msg = R.string.erro_data_pos;
          else if (UtilHelper.currentDateTime(ConstantsEnum.ddMMyyyy.getValue()).compareTo(travelDate) > 0)
            msg = R.string.erro_data_ant;

          if (msg != -1) {
            DialogHelper.showQuestionMessage(LoadTravelActivity.this, R.string.informar_text, msg,
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  downloadZipFile();
                  dialog.dismiss();
                }
              }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  progressBar.setProgress(0);
                  textProgress.setText("");
                  UtilHelper.setButtonStatus(LoadTravelActivity.this, btnLoadTravel, true);
                }
              });
          } else {
            downloadZipFile();
            dialog.dismiss();
          }
        } else {
          DialogHelper.showInformationMessage(context,
            context.getString(R.string.erro_text),
            context.getString(R.string.travel_icorrect), new DialogInterface.OnClickListener() {

              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                showInputDialog(context);
              }
            });
        }
      }
    });
    builder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
        progressBar.setProgress(0);
        textProgress.setText("");
        UtilHelper.setButtonStatus(LoadTravelActivity.this, btnLoadTravel, true);
      }
    });

    builder.show();
  }

  private void loadZipFile(File outputFile) {
    try {
      UtilHelper.unzip(outputFile);

      FileHelper.self(this)
        .setOptionType(OptionType.CRIAR_BASE)
        .setProgressbar(progressBar)
        .setTextProgress(textProgress)
        .setTargetDirectory(outputFile.getParent())
        .setPostExecuteCallback(new MyCallbackInterface.CallbackBooleanInterface() {
          @Override
          public void execute(Boolean success) {
            if (success) {
              startActivity(new Intent(LoadTravelActivity.this,
                ConfirmTravelDataActivity.class));

              PathHelper.self().clearPath(PathHelper.self().getFilePathDownload());
            } else {
              DialogHelper.showErrorMessage(LoadTravelActivity.this, R.string.erro_text,
                R.string.charge_error, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                    textProgress.setText("");
                    UtilHelper.setButtonStatus(LoadTravelActivity.this, btnLoadTravel, true);
                    PathHelper.self().clearPath(PathHelper.self().getFilePathDownload());
                  }
                });
            }
          }
        })
        .execute();
    } catch (Throwable e) {
      e.printStackTrace();
      UtilHelper.setButtonStatus(LoadTravelActivity.this, btnLoadTravel, true);
      LogHelper.self().error("loadZipFile", e);
      DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.erro_zip_file,
        null);
    }
  }

  private void processUpdate() {
    UtilHelper.setButtonStatus(LoadTravelActivity.this, btnLoadTravel, true);
    textProgress.setText("");

    if (edtFilial.getText().toString().isEmpty()) {
      DialogHelper.showInformationMessage(LoadTravelActivity.this,
        R.string.informar_text, R.string.error_unidade, null);
      edtFilial.requestFocus();
    } else if (edtVeiculo.getText().toString().isEmpty()) {
      DialogHelper.showInformationMessage(LoadTravelActivity.this,
        R.string.informar_text, R.string.error_veiculo, null);
      edtVeiculo.requestFocus();
    } else {
      UpgradeHelper.self(LoadTravelActivity.this)
        .setPostExecuteCallback(performCharge)
        .downloadUpdagradeFile();
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                         @NonNull int[] grantResults) {

    config = XmlConfig.self();
    config.read();
    edtFilial.setText(GLOBAL.self().getStaticTable().getCdFilial().toUpperCase());
    edtVeiculo.setText(GLOBAL.self().getStaticTable().getCdVeiculo());
  }

  private void downloadDtFile() {
    UtilHelper.hideKeyboardFrom(LoadTravelActivity.this, getCurrentFocus());

    new LoadService()
      .setFileName(dtFileName)
      .setFileExtension(getString(R.string.txt_extension))
      .setPostExecuteCallback(performCharge2)
      .setActivity(this)
      .setpBarStatus(progressBar)
      .setTxtStatus(textProgress)
      .execute();
  }

  private void downloadZipFile() {
    String fileName = String.format(Locale.getDefault(), "E%1$5s",
      GLOBAL.self().getStaticTable().getCdVeiculo())
      .replace(' ', '0');

    UtilHelper.hideKeyboardFrom(LoadTravelActivity.this, getCurrentFocus());

    new LoadService()
      .setFileName(fileName)
      .setFileExtension(getString(R.string.zip_extension))
      .setPostExecuteCallback(finishCharge)
      .setActivity(this)
      .setpBarStatus(progressBar)
      .setTxtStatus(textProgress)
      .execute();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_load_travel);

    TextView txtVersao = findViewById(R.id.txtVersao);
    txtVersao.setText(String.format(getString(R.string.system_version), GLOBAL.self().getVersao()));

    progressBar = findViewById(R.id.pbar1);
    textProgress = findViewById(R.id.textProgress);
    btnLoadTravel = findViewById(R.id.btnRefazerViagem);
    btnLoadTravel.setOnClickListener(loadTravelClickListener);

    btnConfigConnection = findViewById(R.id.btConfigConnection);
    btnConfigConnection.setOnClickListener(settingsClickListener);

    btnEditarCarga = findViewById(R.id.btnEditarCarga);
    btnEditarCarga.setOnClickListener(btnEditarClickListener);

    btnConfirmarCarga = findViewById(R.id.btnConfimarCarga);
    btnConfirmarCarga.setOnClickListener(btnConfirmarClickListener);


    edtVeiculo = findViewById(R.id.edtNumVeiculoCarga);
    edtFilial = findViewById(R.id.edtFilialCarga);

    edtFilial.setEnabled(false);
    edtVeiculo.setEnabled(false);

    PermissionHelper.self(LoadTravelActivity.this).requestPermission();

    addScreenClickHideKeyboard(findViewById(R.id.screen2));
    addScreenClickHideKeyboard(findViewById(R.id.screen));
  }
}
