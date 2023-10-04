package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import br.com.whitemartins.obc.BuildConfig;
import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.DailyDao;
import br.com.whitemartins.obc.enumeration.OptionType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Daily;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.timer.SendInvoiceTimer;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.FileHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;

public class BeginTravelActivity extends BaseActivity {

  private ProgressBar pbarDelete;
  private TextView textProgressDelete;
  private MyCallbackInterface.CallbackBooleanInterface finishCallback =
      new MyCallbackInterface.CallbackBooleanInterface() {
        @Override
        public void execute(Boolean success) {
          DailyDao dailyDao = DatabaseApp.self().getDatabase().dailyDao();
          Daily daily = dailyDao.findByNumViagem(GLOBAL.self().getRoute().getNumeroViagem());

          if (success) {
            if (daily == null || daily.getOdometroInicial().equals(-1L))
              startActivity(new Intent(BeginTravelActivity.this,
                  ConfirmTravelDataActivity.class));
            else
              startActivity(new Intent(BeginTravelActivity.this,
                  CustomerServiceActivity.class));


            finish();
          }
        }
      };

  private View.OnClickListener btnContinuarViagemClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      //Buscando notas que não foram impressas, última etapa do processo de emissão de nota fiscal
      List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao()
          .find(StepEmissaoType.FINALIZAR.getValue());

      if (invoices.isEmpty())
        finishCallback.execute(true);
      else {
        GLOBAL.self().setAutomaticSend(true);

        Invoice invoice = invoices.get(0);
        invoice.setItens(DatabaseApp.self().getDatabase().invoiceItemDao().findByIdNota(invoice.getId()));
        GLOBAL.self().setOperation(SuperOperation.getOperation(invoice.getTipoTransacao()));

        if (StatusNFeType.isFinalStatus(invoice.getStatus())) {
          Intent intent = new Intent(BeginTravelActivity.this, CecActivity.class);
          intent.putExtra("invoice", invoice);
          startActivity(intent);
        } else if (invoice.getStepEmissao().equals(StepEmissaoType.IMPRIMIR.getValue())) {
          Intent intent = new Intent(BeginTravelActivity.this, SignatureActivity.class);
          intent.putExtra("invoice", invoice);
          startActivity(intent);
        } else if (invoice.getStepEmissao() < StepEmissaoType.IMPRIMIR.getValue()) {
          long timeout = UtilHelper.convertToLongDef(XmlConfig.self().getTimeOut1(), 0) * 1000;

          new SendInvoiceTimer(BeginTravelActivity.this, timeout, 1000)
              .setInvoice(invoice)
              .start();
        }
      }

    }
  };

  private View.OnClickListener btnIniciarNovaViagemClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      int idMessage;

      List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao().getAll();
      boolean exists = invoices.size() > 0;

      if (exists)
        idMessage = R.string.invoice_exists;
      else
        idMessage = R.string.cancel_travel;

      DialogHelper.showQuestionMessage(BeginTravelActivity.this, R.string.confirmar_text,
          idMessage, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              DialogHelper.showInputPasswordDialog(BeginTravelActivity.this,
                  R.string.viagem_interrompida, new UtilHelper.OnOkListener() {
                    @Override
                    public boolean onOkClick(String value) {

                      FileHelper.self(BeginTravelActivity.this)
                          .setOptionType(OptionType.APAGAR_BASE)
                          .setTextProgress(textProgressDelete)
                          .setProgressbar(pbarDelete)
                          .execute();

                      return true;
                    }
                  }
                  , true);
            }
          }, null);
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_begin_travel);

    ImageButton btnContinuarViagem = findViewById(R.id.btnContinuarViagem);
    btnContinuarViagem.setOnClickListener(btnContinuarViagemClickListener);

    ImageButton btnIniciarNovaViagem = findViewById(R.id.btnIniciarNovaViagem);
    btnIniciarNovaViagem.setOnClickListener(btnIniciarNovaViagemClickListener);

    List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao().find(
        StatusNFeType.build(StatusNFeType.AUTORIZADA, StatusNFeType.DENEGADA,
            StatusNFeType.REJEITADA, StatusNFeType.PROCESSAMENTO_REJEITADO));

    if (!BuildConfig.DEBUG)
      UtilHelper.setButtonStatus(this, btnIniciarNovaViagem, invoices.isEmpty());

    textProgressDelete = findViewById(R.id.textProgressDelete);
    pbarDelete = findViewById(R.id.pbarDelete);

    XmlConfig.self().read();
  }
}
