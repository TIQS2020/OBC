package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.honeywell.aidc.AidcManager;
import com.honeywell.aidc.BarcodeFailureEvent;
import com.honeywell.aidc.BarcodeReadEvent;
import com.honeywell.aidc.BarcodeReader;
import com.honeywell.aidc.TriggerStateChangeEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.AssetDao;
import br.com.whitemartins.obc.dao.InvoiceDao;
import br.com.whitemartins.obc.dao.LotePatrimonioDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.LotePatrimonioType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Asset;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.model.LotePatrimonio;
import br.com.whitemartins.obc.operations.AplHc;
import br.com.whitemartins.obc.operations.RclHc;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

import static android.view.View.GONE;

public class LotePatActivity extends BaseActivity implements BarcodeReader.BarcodeListener,
  BarcodeReader.TriggerListener {

  private final int REQUEST_BAR_CODE = 1;
  ItemPrice currentItem;
  ImageButton btnAnteriorLoteFabricacao, btnPosteriorLoteFabricacao, btnConfirmarLoteFabricacao,
    btnBarcodeLotPat, btnFinalizarLoteFabricacao;
  EditText edtNumLoteFabricacao;
  TextView txtDescricaoItemLoteFabricacao, txtContadorLoteFabricacao, txtTipoItemLoteFabricacao;
  Integer currentId = 0;
  List<ItemPrice> itens;
  LotePatrimonioType lotePatrimonioType;
  AssetDao assetDao = DatabaseApp.self().getDatabase().assetDao();
  LotePatrimonioDao lotePatrimonioDao = DatabaseApp.self().getDatabase().lotePatrimonioDao();
  InvoiceDao invoiceDao = DatabaseApp.self().getDatabase().invoiceDao();
  InfoItem infoItem = new InfoItem();
  private Integer total = 0;
  private AidcManager manager;
  private BarcodeReader barcodeReader;

  private View.OnClickListener btnAnterior = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      show(-1);
    }
  };

  private View.OnClickListener btnPosterior = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      show(1);
    }
  };

  private View.OnClickListener btnConfirmar = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      confirmar();
    }
  };

  private View.OnClickListener btnScanBarCodeClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      Intent intent = new Intent(LotePatActivity.this, BarCodeActivity.class);
      intent.putExtra("titulo", getString(R.string.cod_barra));
      startActivityForResult(intent, REQUEST_BAR_CODE);
    }
  };

  private View.OnClickListener btnFinalizarLoteFabricacaoClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      finalizar();
    }
  };

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
    if (resultCode == CommonStatusCodes.SUCCESS) {
      if (requestCode == REQUEST_BAR_CODE) {
        String barCode = intent.getExtras().get("barcode").toString();
        edtNumLoteFabricacao.setText(barCode);
        confirmar();
      }
    }
  }

  private void pos() {
    infoItem.getLotes().set(currentId, edtNumLoteFabricacao.getText().toString());

    show(1);
  }

  private void pre() {
    infoItem.getLotes().set(currentId, edtNumLoteFabricacao.getText().toString());
    //show(-1);
  }

  private void finalizar() {

    infoItem.getLotes().set(currentId, edtNumLoteFabricacao.getText().toString());

    if (!validarGeral())
      DialogHelper.showInformationMessage(LotePatActivity.this,
        R.string.informar_text, R.string.patrimonios_nao_informado, null);
    else if (validar(false)) {
      DialogHelper.showQuestionMessage(LotePatActivity.this,
        getString(R.string.confirmar_text),
        String.format(getString(R.string.finalizar_lote_patrimonio), lotePatrimonioType.getName()),

        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            save();
          }
        }, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            infoItem.getLotes().set(currentId, "");
          }
        });
    }
  }

  private void confirmar() {
    if (!validar(true))
      return;

    pos();

    if (validarGeral())
      finalizar();
  }

  public ItemPrice getCurrentItem() {
    currentItem = infoItem.itens.get(currentId);
    return currentItem;
  }

  private void clear() {
    List<LotePatrimonio> lotePatrimonios = lotePatrimonioDao.find();
    lotePatrimonioDao.deleteAll(lotePatrimonios);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lote_pat);

    initScanner();

    Integer lotePatType = getIntent().getIntExtra("lotePatType", -1);

    if (lotePatType.equals(LotePatrimonioType.LOTE.getValue()))
      lotePatrimonioType = LotePatrimonioType.LOTE;
    else
      lotePatrimonioType = LotePatrimonioType.PATRIMONIO;

    itens = GLOBAL.self().getPrices();

    txtDescricaoItemLoteFabricacao = findViewById(R.id.txtDescricaoItemLoteFabricacao);
    edtNumLoteFabricacao = findViewById(R.id.edtNumLoteFabricacao);
    txtContadorLoteFabricacao = findViewById(R.id.txtContadorLoteFabricacao);
    btnConfirmarLoteFabricacao = findViewById(R.id.btnConfirmarLoteFabricacao);
    btnBarcodeLotPat = findViewById(R.id.btnBarcodeLotPat);
    btnAnteriorLoteFabricacao = findViewById(R.id.btnAnteriorLoteFabricacao);
    btnPosteriorLoteFabricacao = findViewById(R.id.btnPosteriorLoteFabricacao);
    txtTipoItemLoteFabricacao = findViewById(R.id.txtTipoItemLoteFabricacao);

    btnFinalizarLoteFabricacao = findViewById(R.id.btnFinalizarLoteFabricacao);

    btnAnteriorLoteFabricacao.setOnClickListener(btnAnterior);
    btnPosteriorLoteFabricacao.setOnClickListener(btnPosterior);
    btnConfirmarLoteFabricacao.setOnClickListener(btnConfirmar);
    btnBarcodeLotPat.setOnClickListener(btnScanBarCodeClickListener);
    btnFinalizarLoteFabricacao.setOnClickListener(btnFinalizarLoteFabricacaoClickListener);

    if (lotePatrimonioType.equals(LotePatrimonioType.LOTE))
      txtTipoItemLoteFabricacao.setText(R.string.lot_fab);
    else
      txtTipoItemLoteFabricacao.setText(R.string.patrimonio);

    clear();

    populateInfoItens();

    show(0);
  }

  private boolean validar(boolean antes) {
    if (lotePatrimonioType.equals(LotePatrimonioType.PATRIMONIO))
      return validarPatrimonio(antes);
    else
      return true;
  }

  private void save() {
    int idx = -1;
    for (String numeroPat : infoItem.lotes) {

      ItemPrice itemPrice = infoItem.itens.get(++idx);

      LotePatrimonio lotePatrimonio = LotePatrimonio.newInstance();

      lotePatrimonio.setNumeroLote(numeroPat);
      lotePatrimonio.setCdCustomer(GLOBAL.self().getCustomer().getCdCustomer());
      lotePatrimonio.setCdFilial(GLOBAL.self().getRoute().getCdFilial());
      lotePatrimonio.setDataViagem(GLOBAL.self().getRoute().getDataViagem());
      lotePatrimonio.setNumeroVeiuclo(GLOBAL.self().getRoute().getNumVeiculo());
      lotePatrimonio.setNumeroViagem(GLOBAL.self().getRoute().getNumeroViagem());
      lotePatrimonio.setCdItem(itemPrice.getItem().getCdItem());
      lotePatrimonio.setCapacidade(itemPrice.getItem().getCapacidadeProduto());
      lotePatrimonio.setTipo(lotePatrimonioType.getValue());
      lotePatrimonio.setLiberado(ConstantsEnum.NO.getValue());

      lotePatrimonio.save();
    }

    finish();
  }

  private void populateInfoItens() {
    infoItem.itens.clear();
    infoItem.lotes.clear();

    for (ItemPrice itemPrice : GLOBAL.self().getPrices()) {
      if (lotePatrimonioType.equals(LotePatrimonioType.PATRIMONIO)
        && !itemPrice.getItem().getTipoItem().equals(TypeItemType.EQUIPAMENTO.getValue()))
        continue;

      total += itemPrice.getQuantidadeVendida().intValue();

      for (int i = 0; i < itemPrice.getQuantidadeVendida(); i++) {
        infoItem.itens.add(itemPrice);
        infoItem.lotes.add("");
      }
    }
  }

  private boolean validarGeral() {
    int idx = 0, buffer = currentId;
    currentId = 0;

    for (String numeroPat : infoItem.lotes) {

      if (numeroPat.isEmpty()) {
        show(idx);
        return false;
      }

      idx++;
    }

    currentId = buffer;

    return true;
  }

  private boolean validarPatrimonio(boolean antes) {
    //Validando se patrimonio já foi utilizado em algum recolhimento
    //Somente aplicado para PATRIMONIOS

    if (edtNumLoteFabricacao.getText().toString().trim().isEmpty()) {
      DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.informar_patrimonio,
        null);
      return false;
    }

    if (antes) {
      Long loteInformado = UtilHelper.convertToLongDef(edtNumLoteFabricacao.getText().toString().trim(), 0);

      List<String> buffer = infoItem.lotes.stream()
        .filter(line -> line.equals(loteInformado))
        .collect(Collectors.toList());

      if (!buffer.isEmpty()) {
        DialogHelper.showErrorMessage(this, getString(R.string.erro_text),
          String.format(getString(R.string.patrimonio_ja_informado), loteInformado.toString()),
          null);

        edtNumLoteFabricacao.setText("");
        edtNumLoteFabricacao.requestFocus();

        return false;
      }

      Asset asset = assetDao.findByNumeroPatrimonio(edtNumLoteFabricacao.getText().toString().trim());

      if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.APLHC)) {
        if (asset == null || !asset.getCdItem().equals(currentItem.getItem().getCdItem())) {
          DialogHelper.showInformationMessage(LotePatActivity.this,
            R.string.informar_text,
            R.string.patrimonio_invalido_item, null);

          edtNumLoteFabricacao.setText("");
          edtNumLoteFabricacao.requestFocus();

          return false;
        }
      }
    } else {

      int idx = -1;

      if (lotePatrimonioType.equals(LotePatrimonioType.PATRIMONIO)) {

        for (String numeroPat : infoItem.lotes) {
          idx++;

          currentItem = infoItem.itens.get(idx);
          //Verificando se patrimonio está no ativos
          Asset asset = assetDao.findByNumeroPatrimonio(numeroPat.toString());

          if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.APLHC)) {

            if (asset == null || !asset.getCdItem().equals(currentItem.getItem().getCdItem())) {
              DialogHelper.showInformationMessage(LotePatActivity.this,
                R.string.informar_text,
                R.string.patrimonio_invalido_item, null);

              currentId = 0;
              show(idx);
              edtNumLoteFabricacao.setText("");
              edtNumLoteFabricacao.requestFocus();

              return false;
            }
          }

          LotePatrimonio lotePatrimonio = lotePatrimonioDao.find(numeroPat,
            ConstantsEnum.NO.getValue());

          if (lotePatrimonio != null) {

            Invoice invoice = invoiceDao.findById(lotePatrimonio.getIdNota());

            if (invoice != null) {
              SuperOperation operationInvoice = SuperOperation.getOperation(invoice.getTipoTransacao());

              if (GLOBAL.self().isHomecare()) {
                if (GLOBAL.self().getTipoItem().equals(TypeItemType.EQUIPAMENTO)) {
                  if (OperationType.RCLNF.equals(operationInvoice.getOperationType()))
                    operationInvoice = RclHc.newInstance();
                  else if (OperationType.APL.equals(operationInvoice.getOperationType()))
                    operationInvoice = AplHc.newInstance();
                }
              }

              if (OperationType.RCLHC.equals(operationInvoice.getOperationType())
                && OperationType.RCLHC.equals(GLOBAL.self().getOperation().getOperationType())) {

                DialogHelper.showInformationMessage(LotePatActivity.this,
                  R.string.informar_text, R.string.patrimonio_informado_nota_rcl,
                  null);

                currentId = 0;
                show(idx);
                edtNumLoteFabricacao.setText("");
                edtNumLoteFabricacao.requestFocus();
                return false;
              }

              if (OperationType.APLHC.equals(operationInvoice.getOperationType())
                && OperationType.APLHC.equals(GLOBAL.self().getOperation().getOperationType())) {

                DialogHelper.showInformationMessage(LotePatActivity.this,
                  R.string.informar_text, R.string.patrimonio_informado_nota_apl,
                  null);

                currentId = 0;
                show(idx);
                edtNumLoteFabricacao.setText("");
                edtNumLoteFabricacao.requestFocus();
                return false;
              }

              if ((asset != null)
                && OperationType.RCLHC.equals(operationInvoice.getOperationType())
                && OperationType.APLHC.equals(GLOBAL.self().getOperation().getOperationType())) {

                DialogHelper.showInformationMessage(LotePatActivity.this,
                  R.string.informar_text, R.string.patrimonio_nao_aplicado,
                  null);

                currentId = 0;
                show(idx);
                edtNumLoteFabricacao.setText("");
                edtNumLoteFabricacao.requestFocus();
                return false;
              }
            } else {
              if (asset != null
                && OperationType.RCLHC.equals(GLOBAL.self().getOperation().getOperationType())) {

                DialogHelper.showInformationMessage(LotePatActivity.this,
                  R.string.informar_text, R.string.patrimonio_nao_aplicado,
                  null);

                currentId = 0;
                show(idx);
                edtNumLoteFabricacao.setText("");
                edtNumLoteFabricacao.requestFocus();
                return false;
              }
            }
          }
        }
      }
    }

    return true;
  }

  private void show(Integer value) {

    currentId += value;
    if (currentId > total - 1)
      currentId = total - 1;

    UtilHelper.setButtonStatus(this, btnAnteriorLoteFabricacao, currentId > 0);
    UtilHelper.setButtonStatus(this, btnPosteriorLoteFabricacao, currentId < total - 1);

    txtDescricaoItemLoteFabricacao.setText(String.format(Locale.getDefault(),
      "Item: %d - %s", getCurrentItem().getItem().getCdItem(),
      getCurrentItem().getItem().getDescricaoProduto()));

    txtContadorLoteFabricacao.setText(String.format(Locale.getDefault(),
      "%d/%d", currentId + 1, total));

    if (!infoItem.lotes.get(currentId).isEmpty())
      edtNumLoteFabricacao.setText(infoItem.lotes.get(currentId).toString());
    else
      edtNumLoteFabricacao.setText("");

    edtNumLoteFabricacao.requestFocus();
  }

  @Override
  public void onBarcodeEvent(BarcodeReadEvent event) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        String barCode = event.getBarcodeData();
        edtNumLoteFabricacao.setText(barCode);
        confirmar();
      }
    });
  }

  @Override
  public void onFailureEvent(BarcodeFailureEvent barcodeFailureEvent) {

  }

  @Override
  public void onTriggerEvent(TriggerStateChangeEvent triggerStateChangeEvent) {

  }

  private void initScanner() {
    AidcManager.create(this, new AidcManager.CreatedCallback() {

      @Override
      public void onCreated(AidcManager aidcManager) {
        manager = aidcManager;
        try {
          btnBarcodeLotPat.setVisibility(GONE);

          barcodeReader = manager.createBarcodeReader();
          // register bar code event listener
          barcodeReader.addBarcodeListener(LotePatActivity.this);
          // set the trigger mode to client control
          barcodeReader.setProperty(BarcodeReader.PROPERTY_TRIGGER_CONTROL_MODE,
            BarcodeReader.TRIGGER_CONTROL_MODE_AUTO_CONTROL);
          // register trigger state change listener
          barcodeReader.addTriggerListener(LotePatActivity.this);

          Map<String, Object> properties = new HashMap<String, Object>();
          // Set Symbologies On/Off
          properties.put(BarcodeReader.PROPERTY_CODE_128_ENABLED, true);
          properties.put(BarcodeReader.PROPERTY_GS1_128_ENABLED, true);
          properties.put(BarcodeReader.PROPERTY_QR_CODE_ENABLED, true);
          properties.put(BarcodeReader.PROPERTY_CODE_39_ENABLED, true);
          properties.put(BarcodeReader.PROPERTY_DATAMATRIX_ENABLED, true);
          properties.put(BarcodeReader.PROPERTY_UPC_A_ENABLE, true);
          properties.put(BarcodeReader.PROPERTY_EAN_13_ENABLED, false);
          properties.put(BarcodeReader.PROPERTY_AZTEC_ENABLED, false);
          properties.put(BarcodeReader.PROPERTY_CODABAR_ENABLED, false);
          properties.put(BarcodeReader.PROPERTY_INTERLEAVED_25_ENABLED, false);
          properties.put(BarcodeReader.PROPERTY_PDF_417_ENABLED, false);
          // Set Max Code 39 barcode length
          properties.put(BarcodeReader.PROPERTY_CODE_39_MAXIMUM_LENGTH, 10);
          // Turn on center decoding
          properties.put(BarcodeReader.PROPERTY_CENTER_DECODE, true);
          // Enable bad read response
          properties.put(BarcodeReader.PROPERTY_NOTIFICATION_BAD_READ_ENABLED, true);
          // Apply the settings
          barcodeReader.setProperties(properties);

          barcodeReader.claim();
        } catch (Exception e) {
          LogHelper.self().error("initScanner", e);
        }
      }
    });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    if (barcodeReader != null) {
      barcodeReader.removeBarcodeListener(this);
      barcodeReader.removeTriggerListener(this);
      barcodeReader.release();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_app, menu);

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {
      case R.id.action_back:
        DialogHelper.showQuestionMessage(LotePatActivity.this, R.string.confirmar_text,
          R.string.fechar_sem_salvar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              clear();
              setResult(CommonStatusCodes.ERROR);
              finish();
            }
          }, null);

        break;
    }
    return super.onOptionsItemSelected(item);
  }

  private class InfoItem {
    private List<ItemPrice> itens;

    private List<String> lotes;

    public InfoItem() {
      itens = new ArrayList<>();
      lotes = new ArrayList<>();
    }

    public List<ItemPrice> getItens() {
      return itens;
    }

    public void setItens(List<ItemPrice> itens) {
      this.itens = itens;
    }

    public List<String> getLotes() {
      return lotes;
    }

    public void setLotes(List<String> lotes) {
      this.lotes = lotes;
    }
  }
}
