package br.com.whitemartins.obc.timer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.BeginTravelType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.model.WantedClient;
import br.com.whitemartins.obc.model.sync.NotasFiscais;
import br.com.whitemartins.obc.service.SyncService;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.views.RecoveryClientViewActivity;

public class SyncTimer extends BaseTimer {

  private int pos = 0;
  private List<Travel> travels;

  private List<WantedClient> wantedClients = new ArrayList<>();
  private List<NotasFiscais> notasFiscais = new ArrayList<>();

  private MyCallbackInterface.CallbackListInterface finishCallback;
  private MyCallbackInterface.CallbackListInterface syncInterface = new MyCallbackInterface.CallbackListInterface() {
    @Override
    public void execute(List<NotasFiscais> notas) {
      SyncTimer.this.notasFiscais.addAll(notas);
    }
  };

  private MyCallbackInterface.CallbackStringInterface finishExecute = new MyCallbackInterface.CallbackStringInterface() {
    @Override
    public void execute(String mensagem) {
      running = false;

      if (!mensagem.isEmpty()) {
        DialogHelper.showErrorMessage(activity.get(),
            activity.get().getString(R.string.erro_text), mensagem, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                dismissDialog();
              }
            });

        stop();
      } else {
        pos++;

        if (pos >= travels.size()) {
          if (wantedClients.size() > 0) {

            ArrayList<String> cust = new ArrayList<>();

            for (WantedClient wantedClient : wantedClients)
              cust.add(wantedClient.toString());

            Intent intent = new Intent(activity.get(), RecoveryClientViewActivity.class);
            intent.putStringArrayListExtra("customers", cust);
            stop();
            int REQUEST_RECOVERY_CLIENTS = 2;
            activity.get().startActivityForResult(intent, REQUEST_RECOVERY_CLIENTS);

            dismissDialog();
          } else {
            stop();

            GLOBAL.self().getGeneral().setBeginTravelType(BeginTravelType.SUCESSO.getValue());
            GLOBAL.self().getGeneral().save();

            if (notasFiscais.size() == 0) {

              //Voltando para viagem inicial
              Travel travel = DatabaseApp.self().getDatabase().travelDao().findFirst();

              GLOBAL.self().getRoute().setNumeroViagem(travel.getNumeroViagem());
              GLOBAL.self().getRoute().setDataViagem(travel.getDataViagem());
              GLOBAL.self().getRoute().save();

              DialogHelper.showInformationMessage(activity.get(),
                  activity.get().getString(R.string.informar_text),
                  activity.get().getString(R.string.no_invoices_recovery),
                  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      dismissDialog();
                      finishCallback.execute(notasFiscais);
                    }
                  }
              );

            } else {
              dismissDialog();
              finishCallback.execute(notasFiscais);
            }
          }
        } else {
          GLOBAL.self().getRoute().setNumeroViagem(travels.get(pos).getNumeroViagem());
          GLOBAL.self().getRoute().setDataViagem(travels.get(pos).getDataViagem());
          GLOBAL.self().getRoute().save();

          updateMessageStatus();
        }
      }
    }
  };

  private MyCallbackInterface.CallbackWantedClientsInterface finishWantedClientsInterface
      = new MyCallbackInterface.CallbackWantedClientsInterface() {
    @Override
    public void execute(List<WantedClient> cust) {
      running = false;
      pos++;

      for (WantedClient s : cust) {
        if (!wantedClients.contains(s))
          wantedClients.add(s);
      }

      if (travels.size() == 1) {
        GLOBAL.self().getRoute().setDataViagem(travels.get(0).getDataViagem());
        GLOBAL.self().getRoute().setNumeroViagem(travels.get(0).getNumeroViagem());

        finishExecute.execute("");
      } else {
        if (pos < travels.size()) {
          GLOBAL.self().getRoute().setDataViagem(travels.get(pos).getDataViagem());
          GLOBAL.self().getRoute().setNumeroViagem(travels.get(pos).getNumeroViagem());

          updateMessageStatus();
        } else {
          finishExecute.execute("");
        }
      }
    }
  };

  public SyncTimer(Activity activity, long startTime, long interval) {
    super(activity, startTime, interval);

    updateMessageStatus();
  }

  public SyncTimer setFinishCallback(MyCallbackInterface.CallbackListInterface finishCallback) {
    this.finishCallback = finishCallback;
    return this;
  }

  private void stop() {
    cancel();
  }

  @Override
  protected void finishTickCallback(Boolean sucesso) {
    if (!sucesso) {
      dismissDialog();
      DialogHelper.showErrorMessage(activity.get(), R.string.erro_text, R.string.erro_sync, null);
    } else
      dismissDialog();
  }

  @Override
  protected void tickCallback(Long ml) {
    String hms = UtilHelper.formatCounterTimeText(ml);

    chrono.setText(hms);

    if (!running) {
      running = true;

      new SyncService()
          .setActivity(activity.get())
          .setFinishExecuteCallback(finishExecute)
          .setFinishWantedClientCallback(finishWantedClientsInterface)
          .setSyncInvoincesInterface(syncInterface)
          .execute();
    }
  }

  @Override
  protected String getIdMessageHeader() {
    return activity.get().getString(R.string.sync_warning_1);
  }

  @Override
  protected String getIdMessageStatus() {

    travels = DatabaseApp.self().getDatabase().travelDao().getAll();

    int idMessage = R.string.sync_travel;
    int p = pos;

    if (travels.size() == 1)
      p = 0;

    String m = String.format(activity.get().getString(idMessage), travels.get(p).getNumeroViagem(),
        UtilHelper.formatDateStr(travels.get(p).getDataViagem(), ConstantsEnum.ddMMyyyy_barra.getValue()));

    return m;
  }

  @Override
  protected String getIdMessageFooter() {
    return activity.get().getString(R.string.sync_warning_2);
  }
}
