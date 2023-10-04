package br.com.whitemartins.obc.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
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

public class CountCylinderActivity extends BaseActivity {
  private int currentId = 0;
  private TextView txtItemContagemFisica, edtCheioContagemFisica, edtVazioContagemFisica,
      edtTotalVazioContagemFisica, edtTotalCheioContagemFisica;
  private List<Saldo> itens;

  private ItemDao itemDao = DatabaseApp.self().getDatabase().itemDao();

  private UtilHelper.OnOkListener okListener = new UtilHelper.OnOkListener() {
    @Override
    public boolean onOkClick(String value) {
      if (!GLOBAL.self().isHomecare())
        TRIP.self()
            .setWeakReference(CountCylinderActivity.this)
            .finish(FinishTripType.SINCRONISMO_NOTAS);
      else
        TRIP.self()
            .setWeakReference(CountCylinderActivity.this)
            .finish(FinishTripType.CONTAGEM_HC);

      finish();

      return true;
    }
  };

  private View.OnClickListener finalizarClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {

      Saldo saldo = GenericDao.self().sumSaldoGas();

      Double tGeralCheios = saldo.getQtdCheiosCont();
      Double tGeralVazios = saldo.getQtdVaziosCont();

      DialogHelper.showInputConfirmCount(CountCylinderActivity.this, tGeralCheios,
          tGeralVazios, false, new MyCallbackInterface.CallbackBooleanInterface() {
            @Override
            public void execute(Boolean success) {
              if (!validateCount())
                DialogHelper.showInputPasswordDialog(CountCylinderActivity.this,
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


  private View.OnClickListener confirmarClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {

      Double cheios, vazios;

      Saldo item = itens.get(currentId);

      Saldo saldo = DatabaseApp.self().getDatabase().saldoDao().find(item.getCdItem(),
          item.getCapacidade(), GLOBAL.self().getRoute().getNumeroViagem());

      Double tCheios = saldo.getQtdCheiosCont();
      Double tVazios = saldo.getQtdVaziosCont();

      cheios = UtilHelper.convertToDoubleDef(edtCheioContagemFisica.getText().toString(), 0);
      vazios = UtilHelper.convertToDoubleDef(edtVazioContagemFisica.getText().toString(), 0);

      tCheios += cheios;
      tVazios += vazios;

      //Atualizando o saldo dos itens contados
      saldo.setQtdCheiosCont(tCheios);
      saldo.setQtdVaziosCont(tVazios);
      saldo.save();

      tCheios = 0D;
      tVazios = 0D;

      edtTotalCheioContagemFisica.setText(UtilHelper.formatDoubleString(saldo.getQtdCheiosCont(),
          0));
      edtTotalVazioContagemFisica.setText(UtilHelper.formatDoubleString(saldo.getQtdVaziosCont(),
          0));

      edtVazioContagemFisica.setText("");
      edtCheioContagemFisica.setText("");
    }
  };

  private Boolean validateCount() {

    Boolean valid = true;
    List<Integer> tipoItem = new ArrayList<>();
    tipoItem.add(TypeItemType.GAS.getValue());

    List<Saldo> saldos = DatabaseApp.self().getDatabase().saldoDao().find(tipoItem,
        GLOBAL.self().getRoute().getNumeroViagem());

    for (Saldo saldo : saldos) {

      Double qtdCheioCont = saldo.getQtdCheiosCont();
      Double qtdCheioAtual = saldo.getQtdAtualCheios();
      Double qtdVazioCont = saldo.getQtdVaziosCont();
      Double qtdVazioAtual = saldo.getQtdAtualVazios();

      if (!qtdCheioCont.equals(qtdCheioAtual) || !qtdVazioCont.equals(qtdVazioAtual)) {
        valid = false;
        break;
      }
    }

    return valid;
  }

  protected void show(int curIdx) {
    currentId += curIdx;

    if (currentId >= itens.size())
      currentId = itens.size() - 1;

    if (currentId < 0)
      currentId = 0;

    txtItemContagemFisica.setText(String.format("%s\n%s %s", itens.get(currentId).getCdItem(),
        itens.get(currentId).getNomeItem(), itens.get(currentId).getCapacidade()));

    Saldo item = itens.get(currentId);

    Saldo saldo = DatabaseApp.self().getDatabase().saldoDao().find(item.getCdItem(),
        item.getCapacidade(), GLOBAL.self().getRoute().getNumeroViagem());

    edtCheioContagemFisica.setText("");
    edtVazioContagemFisica.setText("");

    edtTotalCheioContagemFisica.setText(UtilHelper.formatDoubleString(saldo.getQtdCheiosCont(),
        0));
    edtTotalVazioContagemFisica.setText(UtilHelper.formatDoubleString(saldo.getQtdVaziosCont(),
        0));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_count_cylinder);

    List<Integer> tipoItem = new ArrayList<>();
    tipoItem.add(TypeItemType.GAS.getValue());

    itens = DatabaseApp.self().getDatabase().saldoDao().findAll(tipoItem,
        GLOBAL.self().getRoute().getNumeroViagem());

    txtItemContagemFisica = findViewById(R.id.txtItemContagemFisica);
    edtCheioContagemFisica = findViewById(R.id.edtCheioContagemFisica);
    edtVazioContagemFisica = findViewById(R.id.edtVazioContagemFisica);
    edtTotalCheioContagemFisica = findViewById(R.id.edtTotalCheioContagemFisica);
    edtTotalVazioContagemFisica = findViewById(R.id.edtTotalVazioContagemFisica);

    ImageButton btnAnteriorContagemFisica = findViewById(R.id.btnAnteriorContagemFisica);
    btnAnteriorContagemFisica.setOnClickListener(anteriorClickListener);

    ImageButton btnPosteriorContagemFisica = findViewById(R.id.btnPosteriorContagemFisica);
    btnPosteriorContagemFisica.setOnClickListener(posteriorClickListener);

    ImageButton btnConfirmarContagemFisica = findViewById(R.id.btnConfirmarContagemFisica);
    btnConfirmarContagemFisica.setOnClickListener(confirmarClickListener);

    ImageButton btnFinalizarContagemFIsica = findViewById(R.id.btnFinalizarContagemFIsica);
    btnFinalizarContagemFIsica.setOnClickListener(finalizarClickListener);

    show(0);
  }

}
