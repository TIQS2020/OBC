package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.PressureType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.MoneyTextWatcherHelper;
import br.com.whitemartins.obc.util.SaldoHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class AddItemActivity extends BaseActivity {

  final int REQUEST_VOLUME = 2;
  final int REQUEST_CILINDER_PP = 1;
  ItemPrice itemPrice = null;
  Customer customer;
  Integer position = -1;
  EditText edtQtd;
  EditText edtPrecoItem;
  EditText edtFreteItem;
  EditText edtCertificadoItem;
  ImageButton btnConfirmar;
  String precoAlterado = ConstantsEnum.N.getValue();
  Double saldo;


  private View.OnClickListener confirmClickListener = new View.OnClickListener() {
    public void onClick(View v) {

      UtilHelper.setButtonStatus(AddItemActivity.this, btnConfirmar, false);

      boolean isRCL = GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCLNF) ||
          GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCLHC)
          || GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCL);

      boolean isCPL = GLOBAL.self().getOperation().getOperationType().equals(OperationType.CPL);

      Double qtdInformada = UtilHelper.convertToDoubleDef(edtQtd.getText().toString(), 0);

      if (itemPrice.getItem().getIndRequerFator().equals(PressureType.ALTA.getValue()))
        qtdInformada *= itemPrice.getItem().getFatorPcs();

      if (qtdInformada == 0)
        DialogHelper.showInformationMessage(AddItemActivity.this, R.string.informar_text,
            R.string.empty_data, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                UtilHelper.setButtonStatus(AddItemActivity.this, btnConfirmar, true);
              }
            });
      else if ((!isRCL && !isCPL) && saldo < qtdInformada) {
        DialogHelper.showInformationMessage(AddItemActivity.this,
            R.string.informar_text, R.string.invalid_quantity,
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                UtilHelper.setButtonStatus(AddItemActivity.this, btnConfirmar, true);
              }
            });
      } else {
        finalizar();
      }
    }
  };

  private View.OnClickListener editarClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      DialogHelper.showInputPasswordDialog(AddItemActivity.this, R.string.update_price_password,
          new UtilHelper.OnOkListener() {
            @Override
            public boolean onOkClick(String value) {
              edtPrecoItem.setEnabled(true);
              edtFreteItem.setEnabled(true);
              edtCertificadoItem.setEnabled(true);
              //precoAlterado = ConstantsEnum.S.getValue();
              return true;
            }
          }, false);
    }
  };

  private View.OnClickListener calcularVolumeClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      calcularVolume();
    }
  };

  private Integer validarItem(ItemPrice price) {

    List<ItemPrice> prices = GLOBAL.self().getPrices();

    for (ItemPrice itemPrice : prices) {
      if (!price.getCondicaoPagamento().equalsIgnoreCase(itemPrice.getCondicaoPagamento()))
        return R.string.cond_pagto_error;

      //Critica de cilindro PP e WM na mesma nota somente serve para APL e RCLNF e itens Gas
      boolean blockPP = (GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCLNF)
          || (GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCLHC))
          || (GLOBAL.self().getOperation().getOperationType().equals(OperationType.APL))
          || (GLOBAL.self().getOperation().getOperationType().equals(OperationType.APLHC)));

      if (blockPP
          && itemPrice.getItem().getTipoItem().equals(TypeItemType.GAS.getValue())
          && !price.getItem().getTipoPropriedade().equalsIgnoreCase(itemPrice.getItem().getTipoPropriedade())
      )
        return R.string.pp_wm_error;
    }
    return -1;
  }

  private void internalFinalizar() {
    final Double quantidade = UtilHelper.convertToDoubleDef(edtQtd.getText().toString(), 0);
    Integer idErro = validarItem(itemPrice);

    if (!idErro.equals(-1))
      DialogHelper.showErrorMessage(this, R.string.erro_text, idErro,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

              UtilHelper.setButtonStatus(AddItemActivity.this, btnConfirmar, true);
            }
          });
    else {
      boolean isRcl = (GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCLHC));

      if (GLOBAL.self().getTipoItem().equals(TypeItemType.EQUIPAMENTO)) {

        if (isRcl) {
          DialogHelper.showQuestionMessage(AddItemActivity.this, R.string.confirmar_text,
              R.string.equipamento_at, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  itemPrice.setAssistTecnica(ConstantsEnum.YES.getValue());
                  itemPrice.setQuantidadeVendida(quantidade);

                  if (position != -1)
                    GLOBAL.self().getPrices().set(position, itemPrice);
                  else
                    GLOBAL.self().getPrices().add(itemPrice);

                  UtilHelper.setButtonStatus(AddItemActivity.this, btnConfirmar, true);
                  setResult(CommonStatusCodes.SUCCESS);
                  finish();

                }
              }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  itemPrice.setAssistTecnica(ConstantsEnum.NO.getValue());
                  itemPrice.setQuantidadeVendida(quantidade);

                  if (position != -1)
                    GLOBAL.self().getPrices().set(position, itemPrice);
                  else
                    GLOBAL.self().getPrices().add(itemPrice);

                  UtilHelper.setButtonStatus(AddItemActivity.this, btnConfirmar, true);

                  setResult(CommonStatusCodes.SUCCESS);
                  finish();
                }
              });
        } else {
          itemPrice.setAssistTecnica(ConstantsEnum.NO.getValue());
          itemPrice.setQuantidadeVendida(quantidade);

          if (position != -1)
            GLOBAL.self().getPrices().set(position, itemPrice);
          else
            GLOBAL.self().getPrices().add(itemPrice);

          UtilHelper.setButtonStatus(AddItemActivity.this, btnConfirmar, true);
          setResult(CommonStatusCodes.SUCCESS);
          finish();
        }
      } else {
        itemPrice.setAssistTecnica(ConstantsEnum.NO.getValue());
        itemPrice.setQuantidadeVendida(quantidade);

        if (position != -1)
          GLOBAL.self().getPrices().set(position, itemPrice);
        else {
          LogHelper.self().info("Total de itens na lista de preços: "
              + GLOBAL.self().getPrices().size());

          //Tratamento para evitar duplicidade na quantidade nas viagens de liquidos
          //não foi possivel simular a situacao
          if (GLOBAL.self().isLiquido())
            GLOBAL.self().getPrices().clear();

          LogHelper.self().info("Total de itens na lista de preços: "
              + GLOBAL.self().getPrices().size());

          GLOBAL.self().getPrices().add(itemPrice);
        }
        UtilHelper.setButtonStatus(AddItemActivity.this, btnConfirmar, true);
        setResult(CommonStatusCodes.SUCCESS);
        finish();
      }
    }
  }

  private void finalizar() {

    final Double newPrice = UtilHelper.formatDouble(edtPrecoItem.getText().toString(), 4);
    final Double newDesp = UtilHelper.formatDouble(edtCertificadoItem.getText().toString(), 4);
    final Double newFrete = UtilHelper.formatDouble(edtFreteItem.getText().toString(), 4);

    if (itemPrice.getPrice() != null) {

      if (edtPrecoItem.isEnabled()
          && itemPrice.getPrice().getPrecoUnitario().equals(newPrice)
          && itemPrice.getPrice().getValorDespesas().equals(newDesp)
          && itemPrice.getPrice().getValorFrete().equals(newFrete)
      ) {
        DialogHelper.showQuestionMessage(this, R.string.confirmar_text,
            R.string.preco_n_alterado,
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                itemPrice.setAltPreco(ConstantsEnum.NO.getValue());
                internalFinalizar();
              }
            }, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                UtilHelper.setButtonStatus(AddItemActivity.this, btnConfirmar, true);
              }
            });

      } else {
        itemPrice.getPrice().setPrecoUnitario(newPrice);
        itemPrice.getPrice().setValorDespesas(newDesp);
        itemPrice.getPrice().setValorFrete(newFrete);
        itemPrice.setAltPreco(ConstantsEnum.N.getValue());
        internalFinalizar();
      }
    } else
      internalFinalizar();
  }

  private void calcularVolume() {

    Intent it = new Intent(AddItemActivity.this, VolumeInformationActivity.class);

    if (itemPrice.getPrice() != null) {

      it.putExtra("cdCustomer", itemPrice.getPrice().getCdCustomer());

      if (itemPrice.getItem() != null)
        it.putExtra("item", itemPrice.getItem());

      startActivityForResult(it, REQUEST_VOLUME);
    }
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_item);

    LogHelper.self().info("AddItem onCreate");

    if (getIntent().getExtras() != null && getIntent().getExtras().get("price") != null)
      itemPrice = (ItemPrice) getIntent().getExtras().get("price");

    itemPrice.setSuperOperation(GLOBAL.self().getOperation());

    if (getIntent().getExtras().get("position") != null)
      position = (Integer) getIntent().getExtras().get("position");

    customer = GLOBAL.self().getCustomer();

    TextView txtItem = findViewById(R.id.txtItem);
    txtItem.setText(itemPrice.toString());
    PreOrder preOrder = GLOBAL.self().getPreOrder();

    preOrder = DatabaseApp.self().getDatabase().preOrderDao().find(itemPrice.getItem().getCdItem(),
        preOrder.getNumeroNotaOrigem());

    if (preOrder == null)
      preOrder = new PreOrder();

    GLOBAL.self().setPreOrder(preOrder);

    saldo = SaldoHelper.self().getSaldoByOperation(itemPrice.getItem().getCdItem(),
        itemPrice.getItem().getCapacidadeProduto(), preOrder.getNumeroNotaOrigem(),
        GLOBAL.self().getOperation(), GLOBAL.self().getRoute().getNumeroViagem());

    TextView txtSaldo = findViewById(R.id.txtSaldo);
    txtSaldo.setText(String.format(Locale.getDefault(), getString(R.string.saldo_disponivel),
        UtilHelper.formatDoubleString(saldo, 0)));

    TextView txtFrete = findViewById(R.id.txtFrete);
    txtFrete.setText(R.string.frete);

    TextView txtDepesasAcessorias = findViewById(R.id.txtDepesasAcessorias);
    txtDepesasAcessorias.setText(R.string.certificado);

    edtQtd = findViewById(R.id.edtQtdItem);
    edtPrecoItem = findViewById(R.id.edtPrecoItem);
    edtPrecoItem.addTextChangedListener(new MoneyTextWatcherHelper(edtPrecoItem, 4));
    edtFreteItem = findViewById(R.id.edtFreteItem);
    edtFreteItem.addTextChangedListener(new MoneyTextWatcherHelper(edtFreteItem, 4));
    edtCertificadoItem = findViewById(R.id.edtCertificadoItem);
    edtCertificadoItem.addTextChangedListener(new MoneyTextWatcherHelper(edtCertificadoItem, 4));

    edtPrecoItem.setText(UtilHelper.formatDoubleString(itemPrice.getValorUnitario(), 4));
    edtFreteItem.setText(UtilHelper.formatDoubleString(itemPrice.getFrete(), 4));
    edtCertificadoItem.setText(UtilHelper.formatDoubleString(itemPrice.getDespesas(), 4));

    edtPrecoItem.setEnabled(false);
    edtFreteItem.setEnabled(false);
    edtCertificadoItem.setEnabled(false);

    if (!preOrder.getCdPreOrder().equals(0L)) {
      edtPrecoItem.setText(UtilHelper.formatDoubleString(preOrder.getPreco(), 4));
      precoAlterado = ConstantsEnum.S.getValue();
    }

    if (itemPrice.getQuantidadeVendida() > 0) {
      String t = UtilHelper.convertToIntegerDef(itemPrice.getQuantidadeVendida().toString(), 0).toString();
      edtQtd.setText(t);
    }

    btnConfirmar = findViewById(R.id.btnConfimarAddItem);
    btnConfirmar.setOnClickListener(confirmClickListener);

    ImageButton btnEditarPrecoItem = findViewById(R.id.btnEditarPrecoItem);
    btnEditarPrecoItem.setOnClickListener(editarClickListener);
    btnEditarPrecoItem.setVisibility(View.INVISIBLE);

    if ((GLOBAL.self().getOperation().getOperationType().equals(OperationType.VND)) &&
        (GLOBAL.self().getRoute().getAlterarPrecoObc().equalsIgnoreCase(ConstantsEnum.YES.getValue())))
      btnEditarPrecoItem.setVisibility(View.VISIBLE);

    ImageButton btnCalculoVolumeAddItem = findViewById(R.id.btnCalculoVolumeAddItem);
    btnCalculoVolumeAddItem.setOnClickListener(calcularVolumeClickListener);

    edtQtd.requestFocus();

    // Inicio do comentário
    // Forçado YES, para que nunca entre no calculo do volume, que nunca foi testado em produção
    // Para habilitar o calculo do volume as linhas deve ser RETIRADA, assim obedecendo o que
    // vier no arquivo de item
    itemPrice.getItem().setIndFatorConvPolegadas(ConstantsEnum.NO.getValue());
    btnCalculoVolumeAddItem.setVisibility(View.INVISIBLE);
    // Fim do comentário

    if (ConstantsEnum.YES.getValue().equalsIgnoreCase(itemPrice.getItem().getIndFatorConvPolegadas())
        && GLOBAL.self().getOperation().isCalculaVolume()) {
      calcularVolume();
    }
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    if (requestCode == 0) {
      if (resultCode == CommonStatusCodes.SUCCESS) {
        if (intent != null) {
          Barcode barcode = intent.getParcelableExtra("barcode");
          if (barcode != null) {
            DialogHelper.showInformationMessage(AddItemActivity.this, R.string.informar_text,
                R.string.bar_code_msg, null);
          }
        }
      }
    } else if (requestCode == REQUEST_CILINDER_PP) {
      String PPs = intent.getStringExtra("PPs");
      itemPrice.setInfCilindroPP(PPs);
      finalizar();
    } else if (requestCode == REQUEST_VOLUME) {

      if (intent.getExtras() != null && intent.getExtras().get("volume") != null) {
        Double qtdVolume = intent.getDoubleExtra("volume", 0D);
        edtQtd.setText(UtilHelper.formatDoubleString(qtdVolume, 4));
      }
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    ActivityHelper.events(this, item);
    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_app, menu);
    return true;
  }
}