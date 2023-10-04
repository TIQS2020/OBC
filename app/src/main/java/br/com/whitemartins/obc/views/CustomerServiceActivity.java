package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.BeginTravelType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.CustomerListType;
import br.com.whitemartins.obc.enumeration.FinishTripType;
import br.com.whitemartins.obc.enumeration.OptionType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.global.TRIP;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.model.sync.NotasFiscais;
import br.com.whitemartins.obc.service.ParseSyncService;
import br.com.whitemartins.obc.timer.SyncTimer;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.FileHelper;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;

public class CustomerServiceActivity extends BaseActivity {

  private static final int REQUEST_INVOICES = 1;
  private static final int REQUEST_RECOVERY_CLIENTS = 2;
  ProgressBar progressBar;
  TextView textProgress;
  ImageButton btnRefazerViagem, btnFimViagem, btnCustomerService, btnTransfEsqtoque;

  private View.OnClickListener customerServiceClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      GLOBAL.self().setTransfer(false);
      Intent it = new Intent(CustomerServiceActivity.this, CustomerStopActivity.class);
//      it.putExtra("type", CustomerListType.INTERCOMPANY);
      GLOBAL.self().setCustomerListType(CustomerListType.INTERCOMPANY);
      startActivity(it);
    }
  };

  private View.OnClickListener consultNFeClickListener = new View.OnClickListener() {
    public void onClick(View v) {

      Long c = null;

      List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao().find(c,
        UtilHelper.padLeft(GLOBAL.self().getRoute().getNumeroViagem().toString(), '0', 6));

      if (invoices.size() > 0) {
        Intent it = new Intent(CustomerServiceActivity.this, InvoiceViewActivity.class);
//        it.putExtra("type", CustomerListType.INTERCOMPANY);
//        GLOBAL.self().setCustomerListType(CustomerListType.INTERCOMPANY);
        Long cdCustomer = null;
        it.putExtra("cdCustomer", cdCustomer);
        startActivity(it);
      } else
        DialogHelper.showInformationMessage(CustomerServiceActivity.this,
          R.string.informar_text, R.string.no_invoices, null);
    }
  };

  private View.OnClickListener reimpressaoCecClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao().getAll();

      if (invoices.size() > 0) {
        Intent it = new Intent(CustomerServiceActivity.this, ReprintCecActivity.class);
        Long cdCustomer = null;
        it.putExtra("cdCustomer", cdCustomer);
        startActivity(it);
      } else
        DialogHelper.showInformationMessage(CustomerServiceActivity.this,
          R.string.informar_text, R.string.no_invoices, null);
    }
  };

  private View.OnClickListener RecoveyClientClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      ActivityHelper.showRecoveryClient(CustomerServiceActivity.this);
    }
  };

  private View.OnClickListener consultTravelDataListener = new View.OnClickListener() {
    public void onClick(View v) {
      ActivityHelper.showTravelData(CustomerServiceActivity.this);
    }
  };

  private View.OnClickListener transfEstoqueListener = new View.OnClickListener() {
    public void onClick(View v) {
      GLOBAL.self().setTransfer(true);
      startActivity(new Intent(CustomerServiceActivity.this, TransferActivity.class));
    }
  };

  private View.OnClickListener emissaoRelatorioListener = new View.OnClickListener() {
    public void onClick(View v) {
      Intent it = new Intent(CustomerServiceActivity.this, ReportActivity.class);
      it.putExtra("finishingTravel", false);
      it.putExtra("parcial", getString(R.string.parcial));
      startActivity(it);
    }
  };

  private View.OnClickListener finalizarViagemListener = new View.OnClickListener() {
    public void onClick(View v) {

      DialogHelper.showQuestionMessage(CustomerServiceActivity.this, R.string.confirmar_text,
        R.string.fim_viagem, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {

            TRIP.self()
              .setWeakReference(CustomerServiceActivity.this)
              .finish(FinishTripType.ODOMETRO);

          }
        }, null
      );
    }
  };

  private MyCallbackInterface.CallbackListInterface callbackListInterface = new MyCallbackInterface.CallbackListInterface() {
    @Override
    public void execute(List<NotasFiscais> notasFiscais) {

      enableButtons();

      if (!notasFiscais.isEmpty()) {
        GLOBAL.self().getGeneral().setFlIndOriginalRefeita(ConstantsEnum.YES.getValue());
        GLOBAL.self().getGeneral().save();

        parse(notasFiscais);
      }

//      parse(notasFiscais);
    }
  };

  private View.OnClickListener rafazerViagemListener = new View.OnClickListener() {
    public void onClick(View v) {
      refazer();
    }
  };

  private void refazer() {
    DialogHelper.showInputPasswordDialog(CustomerServiceActivity.this,
      R.string.liberar_refazer, new UtilHelper.OnOkListener() {
        @Override
        public boolean onOkClick(String value) {
          DialogHelper.showQuestionMessage(CustomerServiceActivity.this, R.string.confirmar_text,

            R.string.liberar_refazer_2, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                sync();
              }
            }, null
          );
          return true;
        }
      }, true);
  }

  private void sync() {
    Long timeout = UtilHelper.convertToLongDef(XmlConfig.self().getTimeOut1(),
      120) * 1000;

    new SyncTimer(this, timeout, 1000)
      .setFinishCallback(callbackListInterface)
      .start();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == REQUEST_RECOVERY_CLIENTS) {

      Travel ft = DatabaseApp.self().getDatabase().travelDao().findFirst();

      GLOBAL.self().getRoute().setDataViagem(ft.getDataViagem());
      GLOBAL.self().getRoute().setNumeroViagem(ft.getNumeroViagem());

      sync();
    } else if (requestCode == REQUEST_INVOICES)
      InvoiceHelper.self()
        .setActivity(this)
        .showLostInvoices(true);
  }

  private void sair() {

    DialogHelper.showQuestionMessageStyled(this, R.string.attention,
      R.string.exit_message, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          DialogHelper.showInputPasswordDialog(CustomerServiceActivity.this,
            R.string.exit_title, new UtilHelper.OnOkListener() {
              @Override
              public boolean onOkClick(String value) {
                textProgress.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                FileHelper.self(CustomerServiceActivity.this)
                  .setOptionType(OptionType.APAGAR_BASE)
                  .setTextProgress(textProgress)
                  .setProgressbar(progressBar)
                  .setPostExecuteCallback(new MyCallbackInterface.CallbackBooleanInterface() {
                    @Override
                    public void execute(Boolean success) {
                      finishAffinity();
                      System.exit(0);

                    }
                  })
                  .execute();
                return true;
              }
            }, false);
        }
      }, null);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    //Relatório não permitido para viagens HC
    if (!GLOBAL.self().isHomecare())
      getMenuInflater().inflate(R.menu.menu_report, menu);

    getMenuInflater().inflate(R.menu.menu_config_printer, menu);
    //Retirado do meu para verificação posterior
    getMenuInflater().inflate(R.menu.menu_exit, menu);

    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_exit:
        sair();
        break;

      default:
        ActivityHelper.events(this, item);
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_customer_service);

    progressBar = findViewById(R.id.pbar1);
    textProgress = findViewById(R.id.textProgress);
    textProgress.setVisibility(View.INVISIBLE);
    progressBar.setVisibility(View.INVISIBLE);

    btnCustomerService = findViewById(R.id.btnAtend);
    btnCustomerService.setOnClickListener(customerServiceClickListener);

    ImageButton btnConsultaNfe = findViewById(R.id.btnConsultaNfe);
    btnConsultaNfe.setOnClickListener(consultNFeClickListener);

    ImageButton btnReimpressaoCec = findViewById(R.id.btnReimpressaoCec);
    btnReimpressaoCec.setOnClickListener(reimpressaoCecClickListener);

    ImageButton btnConsultTravelData = findViewById(R.id.btnConsultTravelData);
    btnConsultTravelData.setOnClickListener(consultTravelDataListener);

    btnTransfEsqtoque = findViewById(R.id.btnTransfEsqtoque);
    btnTransfEsqtoque.setOnClickListener(transfEstoqueListener);
    //Viagens HC não tem transferencia de estoque nem complemento de carga
    UtilHelper.setButtonStatus(this, btnTransfEsqtoque, !GLOBAL.self().isHomecare());

    ImageButton btnEmissaoRelatorio = findViewById(R.id.btnEmissaoRelatorio);
    btnEmissaoRelatorio.setOnClickListener(emissaoRelatorioListener);

    btnFimViagem = findViewById(R.id.btnFimViagem);
    btnFimViagem.setOnClickListener(finalizarViagemListener);
    UtilHelper.setButtonStatus(this, btnFimViagem, GLOBAL.self().getInvoice() == null);

    btnRefazerViagem = findViewById(R.id.btnRefazerViagem);
    btnRefazerViagem.setOnClickListener(rafazerViagemListener);

    blockSync();

    ImageButton btnRecuperaCliente = findViewById(R.id.btnRecuperaCliente);
    btnRecuperaCliente.setOnClickListener(RecoveyClientClickListener);

    InvoiceHelper.self()
      .setActivity(this)
      .showLostInvoices(false);

    if (BeginTravelType.REFAZER_VIAGEM.getValue().equalsIgnoreCase(GLOBAL.self().getGeneral().getBeginTravelType())) {
      UtilHelper.setButtonStatus(this, btnCustomerService, false);
      UtilHelper.setButtonStatus(this, btnTransfEsqtoque, false);
      UtilHelper.setButtonStatus(this, btnFimViagem, false);
      UtilHelper.setButtonStatus(this, btnRefazerViagem, true);
    }
  }


  private void enableButtons() {
    if (BeginTravelType.SUCESSO.getValue().equalsIgnoreCase(GLOBAL.self().getGeneral().getBeginTravelType())) {
      UtilHelper.setButtonStatus(this, btnFimViagem, GLOBAL.self().getInvoice() == null);
      UtilHelper.setButtonStatus(this, btnCustomerService, true);
      UtilHelper.setButtonStatus(this, btnTransfEsqtoque, !GLOBAL.self().isHomecare());
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    enableButtons();

    blockSync();
  }

  private void blockSync() {
    List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao().getAll();

    boolean enabled = invoices.isEmpty();

    Travel firstTravel = DatabaseApp.self().getDatabase().travelDao().findFirst();

    if (!firstTravel.getNumeroViagem().equals(GLOBAL.self().getRoute().getNumeroViagem()))
      enabled = false;

    UtilHelper.setButtonStatus(this, btnRefazerViagem, enabled);
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    GLOBAL.self().setAutomaticSend(false);
    GLOBAL.self().setPedidoRealizado(false);
    GLOBAL.self().setInvoice(null);

    GLOBAL.self().setCustomer(null);
    GLOBAL.self().setCustomerService(null);
    GLOBAL.self().setPatient(null);
  }

  private void parse(final List<NotasFiscais> notasFiscais) {
    new ParseSyncService()
      .setActivity(this)
      .setCallbackFinish(new MyCallbackInterface.CallbackBooleanInterface() {
        @Override
        public void execute(Boolean success) {
          if (success) {
            showInvoices();
          } else
            DialogHelper.showErrorMessage(CustomerServiceActivity.this, R.string.erro_text,
              R.string.sync_error, null);
        }
      })
      .setNotasFiscais(notasFiscais)
      .execute();
  }

  private void showInvoices() {
    DialogHelper.showOkMessage(this, R.string.informar_text,
      R.string.sync_finished, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          final int REQUEST_INVOICES = 1;
          Intent it = new Intent(CustomerServiceActivity.this, InvoiceSyncActivity.class);
          startActivityForResult(it, REQUEST_INVOICES);
        }
      });
  }
}
