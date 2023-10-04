package br.com.whitemartins.obc.service;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.enumeration.MovimentoIntegracaoType;
import br.com.whitemartins.obc.enumeration.SevereErrorsType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceImage;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public class InvoiceBackgroundService extends Thread {

  private final String TAG = "InvoiceBackgroundService";
  private final Object monitor = new Object();

  protected WeakReference<Activity> activity;
  private List<Invoice> invoices = new ArrayList<>();
  private boolean ready = false;


  private MyCallbackInterface.CallbackBooleanInterface finishCallback =
    new MyCallbackInterface.CallbackBooleanInterface() {
      @Override
      public void execute(Boolean success) {

        try {
          if (success) {
            LogHelper.self().info(TAG, "Nota enviada com sucesso.");

            if (!invoices.isEmpty()
              //            && (StatusNFeType.isFinalStatus(invoices.get(0).getStatus())
              && invoices.get(0).isFinalStatus()
              || SevereErrorsType.isSevereStatus(invoices.get(0).getStatusGravacaoJde())) {

              //Caso a nota seja autorizada, colocar na lista da thread do cec
              InvoiceImage invoiceImage = DatabaseApp.self().getDatabase().invoiceImageDao()
                .find(invoices.get(0).getId());

              if (MovimentoIntegracaoType.EMISSAO.getValue().equals(invoices.get(0).getTipoMovimentoIntegracao()))
                GLOBAL.self().getInvoiceImageBackgroundService().addImageToList(invoiceImage);

              invoices.remove(0);
            }
          } else
            LogHelper.self().info(TAG, "Erro ao enviar nota.");

          ready = true;
          synchronized (monitor) {
            monitor.notifyAll();
          }
        } catch (Exception e) {
          LogHelper.self().error(TAG, e);
          e.printStackTrace();
        }
      }
    };

  public void addInvoiceToList(Invoice invoice) {
    if (!invoice.isFinalStatus()) {
      invoices.add(invoice);
      LogHelper.self().info("NOTA ADICIONADA NA THREAD: " + invoice.toString());
    }
  }

  public void clearInvoiceList() {
    invoices.clear();
  }

  private void pre() {
    invoices = DatabaseApp.self().getDatabase().invoiceDao()
      .find(StatusNFeType.build(StatusNFeType.PENDENTE_ENVIO, StatusNFeType.PROCESSANDO,
        StatusNFeType.PENDENTE_CANCELAMENTO), StepEmissaoType.FINALIZAR.getValue());
  }

  @Override
  public void run() {
    try {
      pre();
      int idx = -1;

      while (true) {
        LogHelper.self().info("NOTAS PENDENTES: " + invoices.size());

        if (!invoices.isEmpty()) {
          ++idx;

          if (idx >= invoices.size())
            idx = invoices.size() - 1;

          Invoice invoice = invoices.get(idx);

          if (invoice.isFinalStatus()) {
            LogHelper.self().error(TAG, "Removendo da lista da Thread: " + invoices.get(0).toString());
            invoices.remove(idx);
            continue;
          }

          LogHelper.self().info("ENVIANDO NOTA: " + invoice.toString());

          if (invoice.getTipoMovimentoIntegracao().equals(MovimentoIntegracaoType.EVENTO_CANCELAMENTO.getValue()))
            new CancelInvoiceService()
              .setActivity(activity.get())
              .setInvoice(invoice)
              .setFinishExecuteCallback(finishCallback)
              .execute();
          else
            new SendInvoiceService()
              .setInvoice(invoice)
              .setFinishExecuteCallback(finishCallback)
              .setActivity(activity.get())
              .execute();

          synchronized (monitor) {
            while (!ready) {
              try {
                monitor.wait();
              } catch (InterruptedException e) {

              }
            }
          }
          ready = false;
          LogHelper.self().info("NOTA FINALIZADA: " + invoice.toString());
        }
        sleep(30000);
      }
    } catch (Throwable e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
    }
  }

  public InvoiceBackgroundService setActivity(Activity activity) {
    this.activity = new WeakReference<>(activity);
    return this;
  }
}
