package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.AbastecimentoDao;
import br.com.whitemartins.obc.dao.ConversionLQDao;
import br.com.whitemartins.obc.enumeration.CalculoVolumeType;
import br.com.whitemartins.obc.model.Abastecimento;
import br.com.whitemartins.obc.model.ConversaoLQ;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class VolumeInformationActivity extends BaseActivity {

  int pos;
  TextView txtTanque, txtCapPol, txtCapM3Kg, txtFatorConv, txtTotalDescarregado, txtTituloVolume,
    txtSelecione, txtItemVolume, txtFatorConvPeso, txtDiferencaPeso;
  EditText edtNivelAntes, edtNivelDepois, edtPesoAntes, edtPesoDepois;
  ImageButton btnConfimarVolume, btnFinalizarVolume;
  RadioButton radioPesagem, radioDifNivel;
  ListView lstVolumes;
  List<ConversaoLQ> conversoes;
  ConversaoLQ conversaoLQ;
  List<Abastecimento> abastecimentos = new ArrayList<>();

  Item item;
  Long cdCustomer;

  View pnlPeso, pnlDifNivel;

  ConversionLQDao conversionLQDao = DatabaseApp.self().getDatabase().conversionLQDao();
  AbastecimentoDao abastecimentoDao = DatabaseApp.self().getDatabase().abastecimentoDao();
  ArrayAdapter<ConversaoLQ> adapter;
  View lastSelectedView;
  AdapterView<?> parentView;

  private View.OnClickListener btnConfirmarListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {
      if (conversaoLQ == null) {
        DialogHelper.showErrorMessage(VolumeInformationActivity.this, R.string.erro_text,
          R.string.selecionar_tanque, null);
      } else {

        Double antes = UtilHelper.convertToDoubleDef(edtNivelAntes.getText().toString(), 0);
        Double depois = UtilHelper.convertToDoubleDef(edtNivelDepois.getText().toString(), 0);
        Double diferenca = UtilHelper.formatDouble(depois - antes, 2);

        if (conversaoLQ.getCapacidadePol() < antes)
          DialogHelper.showErrorMessage(VolumeInformationActivity.this, R.string.erro_text,
            R.string.nivel_antes_maior, null);
        else if (conversaoLQ.getCapacidadePol() < depois)
          DialogHelper.showErrorMessage(VolumeInformationActivity.this, R.string.erro_text,
            R.string.nivel_depois_maior, null);
        else if (depois < antes)
          DialogHelper.showErrorMessage(VolumeInformationActivity.this, R.string.erro_text,
            R.string.nivel_depois_menos_nivel_antes, null);
        else {

          conversaoLQ.setPesoAntes(antes);
          conversaoLQ.setPesoDepois(depois);
          conversaoLQ.setDiferenca(diferenca);
          conversaoLQ.setTotalDescarga(
            UtilHelper.formatDouble(diferenca * conversaoLQ.getFatorConversao(), 2));

          txtTotalDescarregado.setText(String.format(Locale.getDefault(),
            getString(R.string.total_descarregado), getTotalM3()));

          edtNivelAntes.setText("");
          edtNivelDepois.setText("");

          pos += 1;

          if (pos >= lstVolumes.getAdapter().getCount())
            pos = lstVolumes.getAdapter().getCount() - 1;

          conversaoLQ = (ConversaoLQ) lstVolumes.getAdapter().getItem(pos);
          lstVolumes.setItemChecked(pos, true);
          edtNivelAntes.requestFocus();

          adapter.notifyDataSetChanged();
        }
      }
    }
  };

  private View.OnClickListener btnFinalizarListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {
      finalizar();
    }
  };

  private View.OnClickListener radioPesagemListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {
      DialogHelper.showQuestionMessage(VolumeInformationActivity.this, R.string.confirmar_text,
        R.string.perda_info_dif_nivel, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            UtilHelper.setButtonStatus(VolumeInformationActivity.this, btnConfimarVolume,
              false);

            txtSelecione.setVisibility(View.GONE);
            pnlDifNivel.setVisibility(View.GONE);
            pnlPeso.setVisibility(View.VISIBLE);
            btnConfimarVolume.setVisibility(View.GONE);

            txtItemVolume = pnlPeso.findViewById(R.id.txtItemVolume);
            txtFatorConvPeso = pnlPeso.findViewById(R.id.txtFatorConvPeso);
            edtPesoAntes = pnlPeso.findViewById(R.id.edtPesoAntes);
            edtPesoDepois = pnlPeso.findViewById(R.id.edtPesoDepois);
            txtDiferencaPeso = pnlPeso.findViewById(R.id.txtDiferencaPeso);
            txtDiferencaPeso.setText(String.format(Locale.getDefault(),
              getString(R.string.diferenca), 0D));

            edtPesoAntes.setOnFocusChangeListener(new View.OnFocusChangeListener() {
              @Override
              public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus)
                  setPesos();
              }
            });

            edtPesoDepois.setOnFocusChangeListener(new View.OnFocusChangeListener() {
              @Override
              public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus)
                  setPesos();
              }
            });

            edtPesoDepois.addTextChangedListener(new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

              }

              @Override
              public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setPesos();
              }

              @Override
              public void afterTextChanged(Editable editable) {

              }
            });

            txtItemVolume.setText(String.format(Locale.getDefault(), getString(R.string.item_),
              item.toString()));

            txtFatorConvPeso.setText(String.format(Locale.getDefault(),
              getString(R.string.fator_conv), item.getFatorConversao()));
          }
        }, null);

    }
  };


  private View.OnClickListener radioDifNivelListener = new View.OnClickListener() {

    @Override
    public void onClick(final View view) {

      DialogHelper.showQuestionMessage(VolumeInformationActivity.this, R.string.confirmar_text,
        R.string.perda_info_peso, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            UtilHelper.setButtonStatus(VolumeInformationActivity.this, btnConfimarVolume,
              true);

            txtSelecione.setVisibility(View.GONE);
            pnlPeso.setVisibility(View.GONE);
            pnlDifNivel.setVisibility(View.VISIBLE);
            btnConfimarVolume.setVisibility(View.VISIBLE);

            conversoes = conversionLQDao.find(cdCustomer);

            if (conversoes.size() == 0) {
              DialogHelper.showInformationMessage(VolumeInformationActivity.this,
                R.string.informar_text, R.string.erro_volume,
                null);
            }

            adapter = new ArrayAdapter<>(VolumeInformationActivity.this,
//              android.R.layout.test_list_item,
              R.layout.list_view_item,
              conversoes);

            txtSelecione = findViewById(R.id.txtSelecione);
            txtTituloVolume = pnlDifNivel.findViewById(R.id.txtTituloVolume);

            txtTituloVolume.setText(String.format(Locale.getDefault(), "%s %s %s %s %s",
              UtilHelper.padRight(getString(R.string.tanque), ' ', 6),
              UtilHelper.padLeft(getString(R.string.antes), ' ', 8),
              UtilHelper.padLeft(getString(R.string.depois), ' ', 8),
              UtilHelper.padLeft(getString(R.string.vol_pol), ' ', 8),
              UtilHelper.padLeft(getString(R.string.vol_m3_kg), ' ', 8)));

            txtTanque = pnlDifNivel.findViewById(R.id.txtTanque);
            txtCapPol = pnlDifNivel.findViewById(R.id.txtCapPol);
            txtCapM3Kg = pnlDifNivel.findViewById(R.id.txtCapM3Kg);
            txtFatorConv = pnlDifNivel.findViewById(R.id.txtFatorConv);

            edtNivelAntes = pnlDifNivel.findViewById(R.id.edtNivelAntes);
            edtNivelDepois = pnlDifNivel.findViewById(R.id.edtNivelDepois);
            lstVolumes = pnlDifNivel.findViewById(R.id.lstVolumes);

            lstVolumes.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

            txtTotalDescarregado = findViewById(R.id.txtTotalDescarregado);
            radioPesagem = findViewById(R.id.radioPesagem);
            radioDifNivel = findViewById(R.id.radioDifNivel);
            btnConfimarVolume = findViewById(R.id.btnConfimarVolume);
            btnConfimarVolume.setOnClickListener(btnConfirmarListener);
            btnFinalizarVolume = findViewById(R.id.btnFinalizarVolume);
            btnFinalizarVolume.setOnClickListener(btnFinalizarListener);

            lstVolumes.setAdapter(adapter);
//            lstVolumes.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            //lstVolumes.setSelector(R.color.pressed_color);
            lstVolumes.setOnItemClickListener(new AdapterView.OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentView = parent;
                pos = position;
                conversaoLQ = conversoes.get(pos);
                setValues(conversaoLQ);
              }
            });
          }
        }, null);
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_volume_information);

    radioPesagem = findViewById(R.id.radioPesagem);
    radioDifNivel = findViewById(R.id.radioDifNivel);

    pnlDifNivel = findViewById(R.id.pnlDifNivel);
    pnlPeso = findViewById(R.id.pnlPeso);

    btnConfimarVolume = findViewById(R.id.btnConfimarVolume);
    btnConfimarVolume.setOnClickListener(btnConfirmarListener);
    btnFinalizarVolume = findViewById(R.id.btnFinalizarVolume);
    btnFinalizarVolume.setOnClickListener(btnFinalizarListener);

    txtSelecione = findViewById(R.id.txtSelecione);
    txtTotalDescarregado = findViewById(R.id.txtTotalDescarregado);
    txtTotalDescarregado.setText(String.format(Locale.getDefault(),
      getString(R.string.total_descarregado), 0D));

    radioPesagem.setOnClickListener(radioPesagemListener);
    radioDifNivel.setOnClickListener(radioDifNivelListener);

    cdCustomer = getIntent().getExtras().getLong("cdCustomer");

    item = (Item) getIntent().getExtras().getSerializable("item");
  }

  private void setValues(ConversaoLQ conversaoLQ) {
    txtTanque.setText(String.format(Locale.getDefault(), getString(R.string.num_tanque),
      conversaoLQ.getNumeroSerieTanque()));

    txtCapPol.setText(String.format(Locale.getDefault(), getString(R.string.capacidade_pol),
      UtilHelper.formatDouble(conversaoLQ.getCapacidadePol(), 2)));

    txtCapM3Kg.setText(String.format(Locale.getDefault(), getString(R.string.capacidade_m3_kg),
      UtilHelper.formatDouble(conversaoLQ.getCapacidadeKG(), 2)));

    txtFatorConv.setText(String.format(Locale.getDefault(), getString(R.string.fator_conv),
      UtilHelper.formatDouble(conversaoLQ.getFatorConversao(), 2)));

    edtNivelAntes.setText("");
    if (conversaoLQ.getPesoAntes() > 0)
      edtNivelAntes.setText(conversaoLQ.getPesoAntes().toString());

    edtNivelDepois.setText("");
    if (conversaoLQ.getPesoDepois() > 0)
      edtNivelDepois.setText(conversaoLQ.getPesoDepois().toString());
  }

  private void setPesos() {

    Double antes = UtilHelper.convertToDoubleDef(edtPesoAntes.getText().toString(), 0);
    Double depois = UtilHelper.convertToDoubleDef(edtPesoDepois.getText().toString(), 0);
    Double diferenca = antes - depois;

    txtDiferencaPeso.setText(String.format(Locale.getDefault(), getString(R.string.diferenca),
      diferenca));

    txtTotalDescarregado.setText(String.format(Locale.getDefault(),
      getString(R.string.total_descarregado), diferenca / item.getFatorConversao()));
  }

  boolean validarVazios() {
    int countErro = 0;

    for (ConversaoLQ conversao : conversoes)
      if (conversao.getPesoAntes().equals(0D) && conversao.getPesoDepois().equals(0D))
        countErro++;

    return countErro == conversoes.size();
  }

  Double getTotalM3() {
    Double acumulado = 0D;

    for (Abastecimento abastecimento : abastecimentos)
      acumulado += abastecimento.getTotalDescarga();

    return acumulado;
  }

  boolean validar() {
    boolean ret = false;

    for (ConversaoLQ conversao : conversoes) {
      if (conversao.getPesoDepois() > 0)
        ret = true;
      else
        return false;
    }

    return ret;
  }

  private void finalizar() {

    abastecimentos.clear();

    if ((!radioDifNivel.isChecked()) && (!radioPesagem.isChecked())) {
      DialogHelper.showErrorMessage(this, R.string.erro_text,
        R.string.erro_volume_selecao, null);
      return;
    }

    if (radioDifNivel.isChecked()) {
      if (validarVazios()) {
        DialogHelper.showQuestionMessage(VolumeInformationActivity.this,
          R.string.confirmar_text, R.string.sem_volume_informado,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

              boolean validado = true;

              if (!validar()) {
                DialogHelper.showErrorMessage(VolumeInformationActivity.this,
                  R.string.erro_text, R.string.tanques_informar_todos, null);

                validado = false;
              }

              if (validado) {
                abastecimentoDao.deleteAll(abastecimentoDao.find(cdCustomer));

                for (ConversaoLQ conversao : conversoes)
                  salvarAbastecimento(conversao);
              }
            }
          },
          null);
      } else {
        abastecimentoDao.deleteAll(abastecimentoDao.find(cdCustomer));

        for (ConversaoLQ conversao : conversoes)
          salvarAbastecimento(conversao);
      }
    }

    if (radioPesagem.isChecked()) {

      abastecimentoDao.deleteAll(abastecimentoDao.find(cdCustomer));

      if (edtPesoAntes.getText().toString().trim().length() == 0
        && edtPesoDepois.getText().toString().trim().length() > 0) {
        DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.peso_antes_invalido,
          null);
        return;
      }

      if (edtPesoAntes.getText().toString().trim().length() > 0
        && edtPesoDepois.getText().toString().trim().length() == 0) {
        DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.peso_depois_invalido,
          null);
        return;
      }

      final Double antes = UtilHelper.convertToDoubleDef(edtPesoAntes.getText().toString(), 0);
      final Double depois = UtilHelper.convertToDoubleDef(edtPesoDepois.getText().toString(), 0);
      final Double diferenca = antes - depois;

      if (diferenca < 0) {
        DialogHelper.showErrorMessage(this, R.string.erro_text,
          R.string.erro_peso, null);
        return;
      }

      if ((antes.equals(0D) || depois.equals(0D))) {

        DialogHelper.showQuestionMessage(VolumeInformationActivity.this,
          R.string.confirmar_text, R.string.peso_0,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

              if (diferenca.equals(0D)) {
                DialogHelper.showQuestionMessage(VolumeInformationActivity.this,
                  R.string.confirmar_text, R.string.pesos_iguais,
                  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      salvarAbastecimento(antes, depois);
                    }
                  },
                  null);
              } else
                salvarAbastecimento(antes, depois);

            }
          },
          null);

      } else if (antes.equals(0D) && depois.equals(0D))
        DialogHelper.showErrorMessage(this, R.string.erro_text,
          R.string.peso_0, null);

      else
        salvarAbastecimento(antes, depois);
    }

    Intent intent = new Intent();
    intent.putExtra("volume", getTotalM3());
    setResult(CommonStatusCodes.SUCCESS, intent);
    finish();
  }

  private void salvarAbastecimento(Double antes, Double depois) {
    Double diferenca = antes - depois;

    Abastecimento abastecimento = Abastecimento.newInstance();

    abastecimento.setNivelAntes(0D);
    abastecimento.setPesoDepois(0D);
    abastecimento.setCdCustomer(cdCustomer);
    abastecimento.setCapacidadePol(0D);
    abastecimento.setCapacidadeKG(0D);
    abastecimento.setNumeroSerieTanque("");
    abastecimento.setPesoAntes(antes);
    abastecimento.setPesoDepois(depois);
    abastecimento.setTotalDescarga(diferenca / item.getFatorConversao());
    abastecimento.setTotalCalulado(diferenca / item.getFatorConversao());
    abastecimento.setFatorConversao(item.getFatorConversao());
    abastecimento.setTipoCalculo(CalculoVolumeType.PESO.getValue());
    abastecimento.save();

    abastecimentos.add(abastecimento);
  }


  private void salvarAbastecimento(ConversaoLQ conversao) {
    Abastecimento abastecimento = Abastecimento.newInstance();

    abastecimento.setNumWM(conversao.getNumeroWM());
    abastecimento.setNumeroSerieTanque(conversao.getNumeroSerieTanque());
    abastecimento.setNivelAntes(conversao.getPesoAntes());
    abastecimento.setNivelDepois(conversao.getPesoDepois());
    abastecimento.setPesoAntes(0D);
    abastecimento.setPesoDepois(0D);
    abastecimento.setTipoCalculo(CalculoVolumeType.NIVEL.getValue());
    abastecimento.setTotalDescarga(conversao.getTotalDescarga());
    abastecimento.setTotalCalulado(getTotalM3());
    abastecimento.setFatorConversao(conversao.getFatorConversao());
    abastecimento.setCapacidadeKG(conversao.getCapacidadeKG());
    abastecimento.setCapacidadePol(conversao.getCapacidadePol());
    abastecimento.setCdCustomer(cdCustomer);
    abastecimento.save();

    abastecimentos.add(abastecimento);
  }
}


