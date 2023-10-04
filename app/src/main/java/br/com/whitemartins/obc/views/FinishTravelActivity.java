package br.com.whitemartins.obc.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.FinishTripType;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.global.TRIP;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.timer.FinishTravelTimer;
import br.com.whitemartins.obc.util.FileOutHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;
import br.com.whitemartins.obc.xml.XmlFimViagem;

public class FinishTravelActivity extends BaseActivity {

  ProgressBar pbarFinishTrip;
  TextView txtStatusFinishTrip;

  private MyCallbackInterface.CallbackBooleanInterface finishCallback = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      if (success) {
        TRIP.self()
          .setWeakReference(FinishTravelActivity.this)
          .finish(FinishTripType.EMISSAO_RELATORIO);
      }
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_finish_travel);

    pbarFinishTrip = findViewById(R.id.pbarFinishTrip);
    txtStatusFinishTrip = findViewById(R.id.txtStatusFinishTrip);
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    generateFilesAndFinishTravel();
  }

  private void publishProgress(final int prog, final String text) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        pbarFinishTrip.setProgress(prog);
        txtStatusFinishTrip.setText(text);
      }
    });
  }

  private void generateFilesAndFinishTravel() {

    try {
      int prog = -1;
      pbarFinishTrip.setProgress(++prog);
      pbarFinishTrip.setMax(9);

      XmlFimViagem xmlFimViagem = XmlFimViagem.newInstance();

      Travel travel = DatabaseApp.self().getDatabase().travelDao().findFirst();
      //xmlFimViagem.setNumeroViagem(GLOBAL.self().getRoute().getNumeroViagem());

      xmlFimViagem.setNumeroViagem(travel.getNumeroViagem());

      xmlFimViagem.setDataViagem(UtilHelper.formatDateStr(travel.getDataViagem(),
        ConstantsEnum.yyyyMMdd.getValue()));

      xmlFimViagem.setDaily(FileOutHelper.self().daily());
      publishProgress(++prog, "Diário");

      xmlFimViagem.setNotas(FileOutHelper.self().notas());
      publishProgress(++prog, "Notas Fiscais");

      xmlFimViagem.setExcept(FileOutHelper.self().excepty());
      publishProgress(++prog, "Except");


      if (GLOBAL.self().isPackeged()) {
        xmlFimViagem.setMovimentacao(FileOutHelper.self().movimentacao());
        publishProgress(++prog, "Movimentação");

        xmlFimViagem.setSituacaoCarga(FileOutHelper.self().situacaoCarga());
        publishProgress(++prog, "Situação de Carga");

        xmlFimViagem.setContagemFisica(FileOutHelper.self().contagemFisica());
        publishProgress(++prog, "Contagem Física");
      }

      if (GLOBAL.self().isHomecare()) {
        xmlFimViagem.setContagemFisica(FileOutHelper.self().contagemFisica());
        publishProgress(++prog, "Contagem Física");

        xmlFimViagem.setMovimentacaoHc(FileOutHelper.self().movimentacaoHC());
        publishProgress(++prog, "Movimentação Homecare");

        xmlFimViagem.setContagemFisicaHC(FileOutHelper.self().contagemFisicaHC());
        publishProgress(++prog, "Contagem Física Homecare");

        xmlFimViagem.setItemComp(FileOutHelper.self().itemCompHC());
        publishProgress(++prog, "Item Complementar Homecare");
      }

      xmlFimViagem.setTalonario(FileOutHelper.self().talonario());
      publishProgress(++prog, "Talonário");

      publishProgress(pbarFinishTrip.getMax(), "");

      Long timeout = UtilHelper.convertToLongDef(XmlConfig.self().getTimeOut1(), 0) * 1000;

      new FinishTravelTimer(this, timeout, 1000)
        .setXmlFimViagem(xmlFimViagem)
        .setStep(StepEmissaoType.ENVIAR.getValue())
        .setNotifyCallback(finishCallback)
        .start();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
