package br.com.whitemartins.obc.global;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.FinishTripType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceImage;
import br.com.whitemartins.obc.model.Payment;
import br.com.whitemartins.obc.model.Saldo;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.print.PrintReports;
import br.com.whitemartins.obc.print.ReportInvoices;
import br.com.whitemartins.obc.print.ReportPaymentCard;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.views.CountCylinderActivity;
import br.com.whitemartins.obc.views.CountHCActivity;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.views.DeleteBaseActivity;
import br.com.whitemartins.obc.views.FinishTravelActivity;
import br.com.whitemartins.obc.views.InvoiceImagePendentActivity;
import br.com.whitemartins.obc.views.InvoicePendentActivity;
import br.com.whitemartins.obc.views.NextTripActivity;
import br.com.whitemartins.obc.views.ReportActivity;

public class TRIP {

  private static TRIP _self;
  private List<Invoice> invoices;
  private List<InvoiceImage> invoiceImages;

  private WeakReference<Activity> weakReference;
  private MyCallbackInterface.CallbackVoidInterface callbackOdometro = new MyCallbackInterface.CallbackVoidInterface() {
    @Override
    public void execute() {

      if (GLOBAL.self().isLiquido())
        finish(FinishTripType.SINCRONISMO_NOTAS);
      else
        finish(FinishTripType.CONTAGEM_CILINDROS);
    }
  };
  private MyCallbackInterface.CallbackBooleanInterface notifyFinishprintInvoiceReport = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      if (success) {
        TRIP.self()
            .setWeakReference(weakReference.get())
            .finish(FinishTripType.APAGAR_BASE);
      } else {

        DialogHelper.showQuestionMessage(weakReference.get(),
            weakReference.get().getString(R.string.confirmar_text),
            String.format(weakReference.get().getString(R.string.send_data_printer_fail),
                weakReference.get().getString(R.string.relatorio)),
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                printReport();
              }
            }, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                TRIP.self()
                    .setWeakReference(weakReference.get())
                    .finish(FinishTripType.APAGAR_BASE);
              }
            });
      }
    }
  };

  public static TRIP self() {
    if (_self == null)
      _self = new TRIP();
    return _self;
  }

  private void printReport() {

    if (GLOBAL.self().isLiquido()) {
      List<Payment> payments = DatabaseApp.self().getDatabase().paymentDao().getAll();

      PrintReports printReports = new PrintReports(weakReference.get());
      printReports.addReport(new ReportInvoices().setParcial(""));

      if (!payments.isEmpty())
        printReports.addReport(new ReportPaymentCard().setParcial(""));

      printReports
          .setNotifyFinish(notifyFinishprintInvoiceReport)
          .execute();

    } else {
      Intent it = new Intent(weakReference.get(), ReportActivity.class);
      it.putExtra("finishingTravel", true);
      it.putExtra("parcial", "");
      weakReference.get().startActivity(it);
    }
  }

  private Boolean hasPendentInvoices() {
    invoices = DatabaseApp.self().getDatabase().invoiceDao()
        .find(StatusNFeType.build(StatusNFeType.PROCESSANDO, StatusNFeType.PENDENTE_ENVIO,
            StatusNFeType.PENDENTE_CANCELAMENTO));

    return !invoices.isEmpty();
  }

  private Boolean hasPendentImages() {
    invoiceImages = DatabaseApp.self().getDatabase().invoiceImageDao()
        .find(StatusNFeType.build(StatusNFeType.PROCESSANDO, StatusNFeType.PENDENTE_ENVIO,
            StatusNFeType.PENDENTE_CANCELAMENTO));

    return !invoiceImages.isEmpty();
  }

  private Boolean hasCilinders() {
    List<Integer> tipoItem = new ArrayList<>();
    tipoItem.add(TypeItemType.GAS.getValue());

    List<Saldo> itens = DatabaseApp.self().getDatabase().saldoDao().findAll(tipoItem,
        GLOBAL.self().getRoute().getNumeroViagem());

    return !itens.isEmpty();
  }

  public TRIP setWeakReference(Activity activity) {
    this.weakReference = new WeakReference<>(activity);
    return this;
  }

  public void finish(FinishTripType step) {
    Travel travel = null;

    if (GLOBAL.self().isMultipla())
      travel = DatabaseApp.self().getDatabase().travelDao().findNext();

    if (travel != null) {
      DialogHelper.showInputOdometroDialog(weakReference.get(), true, new MyCallbackInterface.CallbackVoidInterface() {
        @Override
        public void execute() {
          weakReference.get().startActivity(new Intent(weakReference.get(), NextTripActivity.class));
        }
      });
    } else {
      if (step.equals(FinishTripType.ODOMETRO))
        DialogHelper.showInputOdometroDialog(weakReference.get(), true, callbackOdometro);
      else if (step.equals(FinishTripType.SINCRONISMO_NOTAS)) {
        if (hasPendentInvoices())
          weakReference.get().startActivity(new Intent(weakReference.get(),
              InvoicePendentActivity.class));
        else {
          TRIP.self()
              .setWeakReference(weakReference.get())
              .finish(FinishTripType.SINCRONISMO_CECS);
        }
      } else if (step.equals(FinishTripType.SINCRONISMO_CECS)) {
        if (hasPendentImages())
          weakReference.get().startActivity(new Intent(weakReference.get(),
              InvoiceImagePendentActivity.class));
        else {
          TRIP.self()
              .setWeakReference(weakReference.get())
              .finish(FinishTripType.GERAR_ARQUIVOS);
        }
      } else if (step.equals(FinishTripType.CONTAGEM_CILINDROS))
        if (hasCilinders())
          weakReference.get().startActivity(new Intent(weakReference.get(),
              CountCylinderActivity.class));
        else
          TRIP.self()
              .setWeakReference(weakReference.get())
              .finish(FinishTripType.CONTAGEM_HC);
      else if (step.equals(FinishTripType.CONTAGEM_HC))
        weakReference.get().startActivity(new Intent(weakReference.get(), CountHCActivity.class));
      else if (step.equals(FinishTripType.GERAR_ARQUIVOS))
        weakReference.get().startActivity(new Intent(weakReference.get(),
            FinishTravelActivity.class));
      else if (step.equals(FinishTripType.EMISSAO_RELATORIO)) {
        if (GLOBAL.self().isLiquido()) {
          DialogHelper.showQuestionMessage(weakReference.get(), R.string.confirmar_text,
              R.string.print_invoice_report, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  printReport();
                }
              }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  TRIP.self()
                      .setWeakReference(weakReference.get())
                      .finish(FinishTripType.APAGAR_BASE);
                }
              });
        } else {
          DialogHelper.showQuestionMessage(weakReference.get(), R.string.confirmar_text,
              R.string.print_reports, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  printReport();
                }
              }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  TRIP.self()
                      .setWeakReference(weakReference.get())
                      .finish(FinishTripType.APAGAR_BASE);
                }
              });
        }
      } else if (step.equals(FinishTripType.APAGAR_BASE))
        weakReference.get().startActivity(new Intent(weakReference.get(), DeleteBaseActivity.class));
    }
  }
}
