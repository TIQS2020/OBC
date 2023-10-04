package br.com.whitemartins.obc.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.GenericDao;
import br.com.whitemartins.obc.dao.ItemDao;
import br.com.whitemartins.obc.enumeration.FinishTripType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.global.TRIP;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Saldo;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class CountHCActivity extends BaseActivity {

  private Double tApl = 0D, tRcl = 0D;
  private int currentId = 0;
  private TextView txtItemHC, edtAplicadoHC, edtRecolhidoHC,
    edtTotalRecolhidoHC, edtTotalAplicadoHC;
  private List<Saldo> itens;
  private ItemDao itemDao = DatabaseApp.self().getDatabase().itemDao();

  private UtilHelper.OnOkListener okListener = new UtilHelper.OnOkListener() {
    @Override
    public boolean onOkClick(String value) {
      TRIP.self()
        .setWeakReference(CountHCActivity.this)
        .finish(FinishTripType.SINCRONISMO_NOTAS);

      finish();

      return true;
    }
  };

  private View.OnClickListener confirmarClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {

      Double apls, rcls;

      Saldo item = itens.get(currentId);
      Saldo saldo = DatabaseApp.self().getDatabase().saldoDao().find(item.getCdItem(),
        item.getCapacidade(), GLOBAL.self().getRoute().getNumeroViagem());

      tApl = saldo.getQtdAplicadosHCCont();
      tRcl = saldo.getQtdRecolhidosHCCont();

      apls = UtilHelper.convertToDoubleDef(edtAplicadoHC.getText().toString(), 0);
      rcls = UtilHelper.convertToDoubleDef(edtRecolhidoHC.getText().toString(), 0);

      tApl += apls;
      tRcl += rcls;

      //Atualizando o saldo dos itens contados
      saldo.setQtdAplicadosHCCont(tApl);
      saldo.setQtdRecolhidosHCCont(tRcl);
      saldo.save();

      tApl = 0D;
      tRcl = 0D;

      edtTotalAplicadoHC.setText(UtilHelper.formatDoubleString(saldo.getQtdAplicadosHCCont(),
        0));
      edtTotalRecolhidoHC.setText(UtilHelper.formatDoubleString(saldo.getQtdRecolhidosHCCont(),
        0));

      edtRecolhidoHC.setText("");
      edtAplicadoHC.setText("");
    }
  };

  private View.OnClickListener finalizarClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {

      Saldo saldo = GenericDao.self().sumSaldoEquipamento();

      Double tApl = saldo.getQtdAplicadosHCCont();
      Double tRcl = saldo.getQtdRecolhidosHCCont();

      DialogHelper.showInputConfirmCount(CountHCActivity.this, tApl, tRcl, true,
        new MyCallbackInterface.CallbackBooleanInterface() {
          @Override
          public void execute(Boolean success) {
            if (!validateCount())
              DialogHelper.showInputPasswordDialog(CountHCActivity.this,
                R.string.invalid_counter, okListener, true);
            else
              okListener.onOkClick("");
          }
        });
    }
  };

  private View.OnClickListener anteriorClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      show(-1);
    }
  };

  private View.OnClickListener posteriorClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      show(1);
    }
  };

  private Boolean validateCount() {

    boolean valid = true;
    List<Integer> tipoItem = TypeItemType.build(TypeItemType.EQUIPAMENTO, TypeItemType.MISCELANIA);

    List<Saldo> saldos = DatabaseApp.self().getDatabase().saldoDao().find(tipoItem,
      GLOBAL.self().getRoute().getNumeroViagem());

    for (Saldo saldo : saldos) {

      Double qtdAplHCCont = saldo.getQtdAplicadosHCCont();
      Double qtdRclHCCont = saldo.getQtdRecolhidosHCCont();

      Double qtdAplHC = saldo.getQtdAplicadosHC();
      Double qtdRclHC = saldo.getQtdRecolhidosHC();

      if (!qtdAplHCCont.equals(qtdAplHC) || !qtdRclHCCont.equals(qtdRclHC)) {
        valid = false;
        break;
      }
    }

    return valid;
  }

  private void show(int curIdx) {
    currentId += curIdx;

    if (currentId >= itens.size())
      currentId = itens.size() - 1;

    if (currentId < 0)
      currentId = 0;

    Saldo item = itens.get(currentId);

    txtItemHC.setText(String.format("%s\n%s", itens.get(currentId).getCdItem(),
      itens.get(currentId).getNomeItem()));

    Saldo saldo = DatabaseApp.self().getDatabase().saldoDao().find(item.getCdItem(),
      item.getCapacidade(), GLOBAL.self().getRoute().getNumeroViagem());

    edtRecolhidoHC.setText("");
    edtAplicadoHC.setText("");

    edtTotalAplicadoHC.setText(UtilHelper.formatDoubleString(saldo.getQtdAplicadosHCCont(),
      0));
    edtTotalRecolhidoHC.setText(UtilHelper.formatDoubleString(saldo.getQtdRecolhidosHCCont(),
      0));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_count_hc);

    List<Integer> tipoItem = TypeItemType.build(TypeItemType.EQUIPAMENTO, TypeItemType.MISCELANIA);

    itens = DatabaseApp.self().getDatabase().saldoDao().findAll(tipoItem,
      GLOBAL.self().getRoute().getNumeroViagem());

    txtItemHC = findViewById(R.id.txtItemHC);
    edtAplicadoHC = findViewById(R.id.edtAplicadoHC);
    edtRecolhidoHC = findViewById(R.id.edtRecolhidoHC);
    edtTotalAplicadoHC = findViewById(R.id.edtTotalAplicadoHC);
    edtTotalRecolhidoHC = findViewById(R.id.edtTotalRecolhidoHC);

    ImageButton btnAnteriorHC = findViewById(R.id.btnAnteriorHC);
    btnAnteriorHC.setOnClickListener(anteriorClickListener);

    ImageButton btnPosteriorHC = findViewById(R.id.btnPosteriorHC);
    btnPosteriorHC.setOnClickListener(posteriorClickListener);

    ImageButton btnConfirmarHC = findViewById(R.id.btnConfirmarHC);
    btnConfirmarHC.setOnClickListener(confirmarClickListener);

    ImageButton btnFinalizarHC = findViewById(R.id.btnFinalizarHC);
    btnFinalizarHC.setOnClickListener(finalizarClickListener);

    show(0);
  }

}
