package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.util.List;

import br.com.whitemartins.obc.BuildConfig;
import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.AssetDao;
import br.com.whitemartins.obc.enumeration.BeginTravelType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.OptionType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Asset;
import br.com.whitemartins.obc.model.Daily;
import br.com.whitemartins.obc.model.InvoiceNumber;
import br.com.whitemartins.obc.model.Message;
import br.com.whitemartins.obc.model.Route;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.service.BeginTravelService;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.FileHelper;
import br.com.whitemartins.obc.util.SaldoHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class ConfirmTravelDataActivity extends BaseActivity {
  private final int REQUEST_PAIR = 1;
  private int SHOW_BUTTONS = View.VISIBLE;
  private Boolean fimViagem = false;
  private EditText travelNumber, travelDate, vehicleNumber, unit, routeNumber, printerName;
  private TextView txtStatus;
  private ImageButton buttonConfirm, buttonCancel;

  private MyCallbackInterface.CallbackVoidInterface callback = new MyCallbackInterface.CallbackVoidInterface() {
    @Override
    public void execute() {
      confirm();
    }
  };

  private void beforeConfirm() {
    Travel travel = DatabaseApp.self().getDatabase().travelDao()
        .findById(GLOBAL.self().getRoute().getNumeroViagem());

    if (travel.getSequencia() == 1)
      SaldoHelper.self().updateSaldos();

    if (GLOBAL.self().isHomecare()) {
      AssetDao dao = DatabaseApp.self().getDatabase().assetDao();
      List<Asset> assets = dao.getOpenAssets();

//          TODO: RETIRAR ESSA LINHA
      if (BuildConfig.DEBUG)
        assets.clear();

      if (!assets.isEmpty())
        startActivity(new Intent(ConfirmTravelDataActivity.this,
            ChargeCheckActivity.class));
      else {
        DialogHelper.showInputOdometroDialog(ConfirmTravelDataActivity.this,
            fimViagem, callback);
      }
    } else
      DialogHelper.showInputOdometroDialog(ConfirmTravelDataActivity.this,
          fimViagem, callback);
  }


  private MyCallbackInterface.CallbackBeginTravelInterface callbackStringInterface = new MyCallbackInterface.CallbackBeginTravelInterface() {
    @Override
    public void execute(BeginTravelType beginTravelType) {
      enabled(true);

      GLOBAL.self().getGeneral().setBeginTravelType(beginTravelType.getValue());
      GLOBAL.self().getGeneral().save();

      if (BeginTravelType.SUCESSO.equals(beginTravelType)
          || BeginTravelType.REFAZER_VIAGEM.equals(beginTravelType)) {

        if (BeginTravelType.REFAZER_VIAGEM.equals(beginTravelType)) {
          DialogHelper.showInformationMessage(ConfirmTravelDataActivity.this,
              ConfirmTravelDataActivity.this.getString(R.string.informar_text),
              beginTravelType.getDescription(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  beforeConfirm();
                }
              });
        } else
          beforeConfirm();
      } else if (BeginTravelType.INSUCESSO.equals(beginTravelType)) {
        DialogHelper.showErrorMessage(ConfirmTravelDataActivity.this,
            ConfirmTravelDataActivity.this.getString(R.string.erro_text),
            beginTravelType.getDescription(), null);
      } else if (BeginTravelType.FECHAR_VIAGEM.equals(beginTravelType)) {

        DialogHelper.showErrorMessage(ConfirmTravelDataActivity.this,
            getString(R.string.erro_text), BeginTravelType.FECHAR_VIAGEM.getDescription(),
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                ProgressBar progressBar = findViewById(R.id.confirm_travel_progressbar);
                progressBar.setVisibility(View.VISIBLE);

                FileHelper.self(ConfirmTravelDataActivity.this)
                    .setOptionType(OptionType.APAGAR_BASE)
                    .setProgressbar(progressBar)
                    .execute();

                enabled(true);
              }
            });
      }
    }
  };

  private View.OnClickListener confirmClickListener = new View.OnClickListener() {
    public void onClick(View v) {

      enabled(false);

      if (BuildConfig.DEBUG)
        GLOBAL.self().getStaticTable().setMacAddress("Mac fake");

      if (GLOBAL.self().getStaticTable().getMacAddress().isEmpty())
        DialogHelper.showErrorMessage(ConfirmTravelDataActivity.this, R.string.erro_text,
            R.string.pair_info, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ConfirmTravelDataActivity.this,
                    PrinterDiscoverActivity.class);
                startActivityForResult(intent, REQUEST_PAIR);
                enabled(true);
              }
            });
      else
        initializeTravel();
    }
  };

  private View.OnClickListener cancelClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      enabled(false);

      DialogHelper.showQuestionMessage(ConfirmTravelDataActivity.this,
          R.string.confirmar_text, R.string.exit_confirm_travel_msg,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              ProgressBar progressBar = findViewById(R.id.confirm_travel_progressbar);
              progressBar.setVisibility(View.VISIBLE);

              FileHelper.self(ConfirmTravelDataActivity.this)
                  .setOptionType(OptionType.APAGAR_BASE)
                  .setProgressbar(progressBar)
                  .execute();
              enabled(true);
            }
          }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              enabled(true);
            }
          });
    }
  };

  private void enabled(boolean status) {
    UtilHelper.setButtonStatus(this, buttonConfirm, status);
    UtilHelper.setButtonStatus(this, buttonCancel, status);
    UtilHelper.hideKeyboardFrom(this, getCurrentFocus());
  }

  private void confirm() {
    StringBuilder msg = new StringBuilder();

    List<Message> messages = DatabaseApp.self().getDatabase().messageDao()
        .find(ConstantsEnum.M.getValue());

    for (Message m : messages)
      msg.append(m.getMensagem()).append("\n");

    if (!messages.isEmpty())

      DialogHelper.showInformationMessage(this,
          getString(R.string.driver_message), msg.toString(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              startActivity(new Intent(ConfirmTravelDataActivity.this,
                  CustomerServiceActivity.class));
            }
          });
    else
      startActivity(new Intent(ConfirmTravelDataActivity.this,
          CustomerServiceActivity.class));
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (resultCode == CommonStatusCodes.SUCCESS)
      if (requestCode == REQUEST_PAIR) {

        printerName.setText(GLOBAL.self().getStaticTable().getNomeImpressora()
            .concat("\r\n")
            .concat(GLOBAL.self().getStaticTable().getMacAddress()));

        initializeTravel();
      }
  }

  private void useTravel() {
    GLOBAL.self().getRoute().save();

    Travel travel = DatabaseApp.self().getDatabase().travelDao()
        .findById(GLOBAL.self().getRoute().getNumeroViagem());

    if (travel != null) {
      travel.setIndViagemUsada(ConstantsEnum.YES.getValue());
      travel.save();
    } else {
      travel = Travel.newInstance();

      if (!GLOBAL.self().isMultipla()) {
        travel.setNumeroViagem(GLOBAL.self().getRoute().getNumeroViagem());
        travel.setDataViagem(GLOBAL.self().getRoute().getDataViagem());
        travel.setSequencia(1);
        travel.setIndViagemUsada(ConstantsEnum.YES.getValue());
        travel.save();
      }
    }

    //Salando a daily referente a viagem que esta sendo iniciada
    Daily daily = Daily.newInstance();
    daily.setDataHoraInicio(UtilHelper.currentDateTime(ConstantsEnum.ddMMyyyy.getValue()));
    daily.setRota(GLOBAL.self().getRoute().getCdRota());
    daily.setVersao(GLOBAL.self().getVersao());
    daily.setVeiculo(GLOBAL.self().getRoute().getNumVeiculo());
    daily.setFilial(GLOBAL.self().getRoute().getCdFilial());
    daily.setNumeroViagem(GLOBAL.self().getRoute().getNumeroViagem());
    daily.setDataViagem(UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
        ConstantsEnum.yyyyMMdd.getValue()));
    daily.setModeloDocViagem(UtilHelper.convertToIntegerDef(
        GLOBAL.self().getRoute().getModeloDoc(), 0));

    daily.save();
  }

  private void initializeTravel() {

    useTravel();

    Travel travel = DatabaseApp.self().getDatabase().travelDao()
        .findById(GLOBAL.self().getRoute().getNumeroViagem());

    if (travel.getSequencia() == 1 &&
        (BeginTravelType.INSUCESSO.getValue().equalsIgnoreCase(GLOBAL.self().getGeneral().getBeginTravelType())
            || GLOBAL.self().getGeneral().getBeginTravelType() == null))
      new BeginTravelService()
          .setActivity(this)
          .setFinishExecuteCallback(callbackStringInterface)
          .setTxtStatus(txtStatus)
          .execute();
    else
      callbackStringInterface.execute(BeginTravelType.getByValue(GLOBAL.self().getGeneral().getBeginTravelType()));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_confirm_travel_data);

    TextView txtVersao = findViewById(R.id.txtVersao);
    buttonConfirm = findViewById(R.id.btnConfimarViagem);
    buttonCancel = findViewById(R.id.btnCancelarViagem);
    buttonConfirm.setOnClickListener(confirmClickListener);
    buttonCancel.setOnClickListener(cancelClickListener);

    travelDate = findViewById(R.id.travel_date);
    travelNumber = findViewById(R.id.travel_number);
    vehicleNumber = findViewById(R.id.vehicle_number);
    unit = findViewById(R.id.unit);
    routeNumber = findViewById(R.id.route_number);
    txtStatus = findViewById(R.id.txtStatusConfirma);
    printerName = findViewById(R.id.printer_name);
    ProgressBar progressBar = findViewById(R.id.confirm_travel_progressbar);

    txtVersao.setText(String.format(getString(R.string.system_version), GLOBAL.self().getVersao()));

    Route route = GLOBAL.self().getRoute();

    long numeroViagem = getIntent().getLongExtra("numeroViagem", 0);
    String dataViagem = getIntent().getStringExtra("dataViagem");
    fimViagem = getIntent().getBooleanExtra("fimViagem", false);
    SHOW_BUTTONS = getIntent().getIntExtra("showButtons", View.VISIBLE);

    InvoiceNumber invoiceNumber = DatabaseApp.self().getDatabase().invoiceNumberDao().getFirst();

    GLOBAL.self().getGeneral().setNumeroViagem(route.getNumeroViagem());
    GLOBAL.self().getGeneral().setContadorSenha(1);
    GLOBAL.self().getGeneral().setNumeroNotaEntrada(invoiceNumber.getNumeroNotaFiscalEntrada());
    GLOBAL.self().getGeneral().setSerieNotaEntrada(invoiceNumber.getNumeroSerieEntrada());
    GLOBAL.self().getGeneral().setNumeroNotaSaida(invoiceNumber.getNuemroNotaFiscalSaida());
    GLOBAL.self().getGeneral().setSerieNotaSaida(invoiceNumber.getNumeroSerieSaida());
    GLOBAL.self().getGeneral().save();

    travelDate.setText(UtilHelper.formatDateStr(route.getDataViagem(),
        ConstantsEnum.ddMMyyyy_barra.getValue()));
    travelNumber.setText(String.valueOf(route.getNumeroViagem()));
    vehicleNumber.setText(route.getNumVeiculo());
    unit.setText(route.getCdFilialJde());
    routeNumber.setText(String.valueOf(route.getCdRota()));

    printerName.setText(GLOBAL.self().getStaticTable().getNomeImpressora()
        .concat("\r\n")
        .concat(GLOBAL.self().getStaticTable().getMacAddress()));

    progressBar.setVisibility(View.INVISIBLE);

    Travel firstTravel = DatabaseApp.self().getDatabase().travelDao().findFirst();

    if (SHOW_BUTTONS == View.INVISIBLE || firstTravel == null) {
      buttonConfirm.setVisibility(SHOW_BUTTONS);
      buttonCancel.setVisibility(SHOW_BUTTONS);
    } else {
      if (!firstTravel.getNumeroViagem().equals(route.getNumeroViagem()) || numeroViagem > 0) {
        buttonCancel.setVisibility(View.GONE);

        Travel travel = DatabaseApp.self().getDatabase().travelDao().findById(numeroViagem);

        if (travel != null) {
          route.setNumeroViagem(travel.getNumeroViagem());
          route.setDataViagem(travel.getDataViagem());

          dataViagem = UtilHelper.formatDateStr(travel.getDataViagem(),
              ConstantsEnum.ddMMyyyy_barra.getValue());

          travelNumber.setText(String.valueOf(travel.getNumeroViagem()));
          travelDate.setText(dataViagem);
        }
      }

      if (dataViagem != null && !dataViagem.isEmpty())
        travelDate.setText(dataViagem);

      if (SHOW_BUTTONS != View.VISIBLE)
        setTitle(R.string.show_travel_data);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    if (View.INVISIBLE == SHOW_BUTTONS)
      getMenuInflater().inflate(R.menu.menu_app, menu);

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    ActivityHelper.events(this, item);
    return super.onOptionsItemSelected(item);
  }
}
