package br.com.whitemartins.obc.service;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceImage;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public class InvoiceImageBackgroundService extends Thread {

  private final Object monitor = new Object();
  private final String TAG = "InvoiceImageBackgroundService";
  protected WeakReference<Activity> activity;
  private List<InvoiceImage> invoiceImages = new ArrayList<>();

  //  private Integer timeout;
  private boolean ready = false;
  private boolean stopped = false;

  private MyCallbackInterface.CallbackBooleanInterface finishCallback =
    new MyCallbackInterface.CallbackBooleanInterface() {
      @Override
      public void execute(Boolean success) {
        try {
          ready = true;
          synchronized (monitor) {
            monitor.notifyAll();
          }

          if (success)
            LogHelper.self().info(TAG, "Imagens enviadas com sucesso.");
          else
            LogHelper.self().error(TAG, "Erro ao enviar imagens.");
        } catch (Exception e) {
          LogHelper.self().error(TAG, e);
          e.printStackTrace();
        }
      }
    };

  public InvoiceImageBackgroundService() {
//    timeout = UtilHelper.convertToIntegerDef(XmlConfig.self().getTimeOut1(), 0) * 1000;
  }

  public void addImageToList(InvoiceImage invoiceImage) {
    invoiceImages.add(invoiceImage);
    LogHelper.self().error(TAG, "CEC ADICIONADO NA THREAD:" + invoiceImage.toString());
  }

  public void clearImageList() {
    invoiceImages.clear();
  }

  @Override
  public void run() {
    try {
      pre();

      int idx = -1;

      while (true) {
        sleep(30000);

        if (!invoiceImages.isEmpty()) {

          ++idx;

          if (idx > (invoiceImages.size() - 1))
            idx = invoiceImages.size() - 1;

          InvoiceImage invoiceImage = invoiceImages.get(idx);

          Invoice invoice = DatabaseApp.self().getDatabase().invoiceDao()
            .findById(invoiceImage.getIdNota());

          if (invoice == null)
            continue;

          final int i = idx;
          if (invoice.getStatus() > StatusNFeType.PROCESSANDO.getValue()) {

            LogHelper.self().info("CEC INICIADO: " + invoiceImage.toString());

            //Não enviar CECs com a assinatura nula ou branca
            if (invoiceImage.getAssinatura() == null || invoiceImage.getAssinatura().isEmpty()) {
              continue;
            }

            ImageService imageService = new ImageService();
            imageService
              .setFinishExecuteCallback(new MyCallbackInterface.CallbackBooleanInterface() {
                @Override
                public void execute(Boolean success) {

                  if (success)
                    if (!invoiceImages.isEmpty()) {
                      LogHelper.self().error(TAG, "Removendo da lista da Thread: " +
                        invoiceImage.toString());
                      invoiceImages.remove(i);
                    }

                  ready = true;
                  synchronized (monitor) {
                    monitor.notifyAll();
                  }
                }
              })
              .setInvoiceImage(invoiceImage)
              .setActivity(GLOBAL.self().getGlobalActivity())
              .execute();

            synchronized (monitor) {
              while (!ready) {
                try {
                  monitor.wait();
                } catch (InterruptedException e) {
                  LogHelper.self().error(TAG, e);
                }
              }
            }
            ready = false;

            LogHelper.self().info("CEC FINALIZADO: " + invoiceImage.toString());
          }
        }
      }
    } catch (Throwable e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
    }
  }

  private void pre() {
    invoiceImages = DatabaseApp.self().getDatabase().invoiceImageDao().find(StatusNFeType.build(
      StatusNFeType.PENDENTE_ENVIO, StatusNFeType.PROCESSANDO));
  }

  public InvoiceImageBackgroundService setActivity(Activity activity) {
//    this.activity = new WeakReference<>(activity);
    return this;
  }
}
