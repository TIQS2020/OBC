package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
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
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.model.Rastreabilidade;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.RastHelper;
import br.com.whitemartins.obc.util.UtilHelper;

import static android.view.View.GONE;

public class InvoiceRastreabActivity extends BaseActivity implements BarcodeReader.BarcodeListener,
  BarcodeReader.TriggerListener {

  //  static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
//  private static final int CAMERA_PERMISSION_CAMERA = 0x000000;
  Integer currentId;
  TextView lblCilindro;
  EditText txtCilindro;
  EditText txtLote;
  TextView txtDescricaoItemRastreab, txtContadorRastreabItens, txtContadorCilindros;
  ListView itemList;
  RastHelper rastHelper;
  List<LoteCil> informados;
  LoteCil editingLoteCil;

  ImageButton btnAnteriorRastreab;
  ImageButton btnPosteriorRastreab;
  ImageButton btnBarcode;
  int editIdx = -1;
  Double totalItens;
  List<ItemPrice> itens = new ArrayList<>();
  ArrayAdapter<LoteCil> adapter;
  private AidcManager manager;
  private BarcodeReader barcodeReader;

  private View.OnClickListener confirmOrderClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      confirmar();
    }
  };

  private View.OnClickListener btnScanBarCodeClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      Intent intent = new Intent(InvoiceRastreabActivity.this, BarCodeActivity.class);

      if (txtCilindro.hasFocus())
        intent.putExtra("titulo", getString(R.string.cilindro_cod_barra));
      else
        intent.putExtra("titulo", getString(R.string.lote_cod_barra));

      startActivityForResult(intent, 0);
    }
  };

  private View.OnClickListener btnAnteriorClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      show(-1, false);
    }
  };
  private View.OnClickListener btnPosteriorClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      show(1, true);
    }
  };

  @Override
  public void onBarcodeEvent(final BarcodeReadEvent event) {

    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        // update UI to reflect the data
        String barCode = event.getBarcodeData();

        if (event.getBarcodeData().length() == 9) {
          txtCilindro.setText(barCode);

          LoteCil loteCil = null;

          if (editIdx != -1)
            loteCil = filter().get(editIdx);

          if (rastHelper.validaCilindro(InvoiceRastreabActivity.this, barCode, informados, loteCil))
            txtLote.requestFocus();
          else
            txtCilindro.setText("");
        }

        if (event.getBarcodeData().length() == 13) {
          txtLote.setText(barCode);
          if (rastHelper.validaLote(InvoiceRastreabActivity.this, barCode))
            txtCilindro.requestFocus();
          else
            txtLote.setText("");
        }

        if (txtCilindro.getText().toString().length() == 9
          && txtLote.getText().toString().length() == 13) {

          LoteCil loteCil = new LoteCil(
            itens.get(currentId).getItem().getCdItem(),
            itens.get(currentId).getItem().getCapacidadeProduto(),
            txtLote.getText().toString(),
            txtCilindro.getText().toString());

          addCylinder(loteCil, editIdx);
          editIdx = -1;
        }
      }
    });
  }

  @Override
  public void onFailureEvent(BarcodeFailureEvent barcodeFailureEvent) {
  }

  @Override
  public void onTriggerEvent(TriggerStateChangeEvent event) {
  }

  private void updateListView(List<LoteCil> lotes) {
    if (lotes == null)
      lotes = filter();

    adapter = new ArrayAdapter<>(this, R.layout.list_view_item, lotes);
    itemList.setAdapter(adapter);
    adapter.notifyDataSetChanged();

//    show(0, false);
  }


  private void confirmar() {
    if (informados.size() == totalItens
      && (txtCilindro.getVisibility() == View.VISIBLE && txtCilindro.getText().toString().isEmpty())
      && txtLote.getText().toString().isEmpty()) {

      finalizar();

    } else {
      LoteCil loteCil = new LoteCil(
        itens.get(currentId).getItem().getCdItem(),
        itens.get(currentId).getItem().getCapacidadeProduto(),
        txtLote.getText().toString(),
        txtCilindro.getText().toString());

      addCylinder(loteCil, editIdx);
    }
  }

  private void finalizar() {

    updateListView(null);

    DialogHelper.showQuestionMessage(this, R.string.confirmar_text,
      R.string.encerrar_rastreab, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

          for (LoteCil lote : informados) {

            Rastreabilidade r = Rastreabilidade.newInstance();
            r.setIdNota(null);
            r.setCdItem(lote.getCdItem());
            r.setCapacidadeItem(lote.getCapacidade());
            r.setCdCilindro(lote.getCdCilindro());
            r.setNumeroLote(lote.getNumeroLote());
            r.setCdFilial(GLOBAL.self().getStaticTable().getCdFilial());
            r.setDataViagem(GLOBAL.self().getRoute().getDataViagem());
            r.setCdCustomer(GLOBAL.self().getCustomer().getCdCustomer());
            r.setNumeroVeiculo(GLOBAL.self().getStaticTable().getCdVeiculo());
            r.setNumeroViagem(GLOBAL.self().getRoute().getNumeroViagem());
            r.setLiberado(ConstantsEnum.NO.getValue());

            r.save();
          }

          startActivity(new Intent(InvoiceRastreabActivity.this,
            InvoiceFinishActivity.class));

          finish();

        }
      }, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          if (GLOBAL.self().isLiquido())
            informados.clear();

          txtLote.setText("");
          txtCilindro.setText("");
        }
      });
  }

  private void addCylinder(LoteCil loteCil, int idx) {

    if (!rastHelper.validaCilindro(this, loteCil.getCdCilindro(), informados, loteCil)) {
      txtCilindro.requestFocus();
      return;
    }

    if (!rastHelper.validaLote(this, loteCil.getNumeroLote())) {
      txtLote.requestFocus();
      return;
    }

    if (GLOBAL.self().isLiquido()) {
      if (!informados.isEmpty())
        informados.remove(0);

      informados.add(loteCil);
      finalizar();

    } else if (idx != -1) {
//      setNewItem(loteCil);
      informados.add(loteCil);
      updateListView(informados);
      txtCilindro.setText("");
      txtLote.setText("");
      editingLoteCil = null;
      editIdx = -1;

      if (informados.size() == totalItens)
        finalizar();
    } else {

      List<LoteCil> lotes = filter();

      if (itens.get(currentId).getQuantidadeVendida() > lotes.size()) {
        informados.add(loteCil);

        if (informados.size() == totalItens)
          finalizar();
        else
          show(0, false);
      } else
        DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.all_informed,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              txtLote.setText("");
              txtCilindro.setText("");
              show(0, false);
            }
          });
    }
  }

  private List<LoteCil> filter() {
    ItemPrice itemPrice = itens.get(currentId);

    return informados.stream()
      .filter(line -> line.getCdItem().equals(itemPrice.getItem().getCdItem())
        && line.getCapacidade().equals(itemPrice.getItem().getCapacidadeProduto()))
      .collect(Collectors.toList());
  }

  private void show(int curIdx, boolean next) {

    currentId += curIdx;

    if (currentId >= itens.size() - 1)
      currentId = itens.size() - 1;

    ItemPrice itemPrice = itens.get(currentId);

    List<LoteCil> lotes = filter();

    txtDescricaoItemRastreab.setText(itemPrice.toString());

    UtilHelper.setButtonStatus(this, btnAnteriorRastreab, currentId > 0);
    UtilHelper.setButtonStatus(this, btnPosteriorRastreab, currentId < itens.size() - 1);

    adapter = new ArrayAdapter<>(InvoiceRastreabActivity.this,
      R.layout.list_view_item, lotes);

    itemList.setAdapter(adapter);

    txtCilindro.setText("");
    txtLote.setText("");

    int tCil = lotes.size() + 1;
    if (tCil > itens.get(currentId).getQuantidadeVendida())
      tCil = UtilHelper.convertToIntegerDef(itens.get(currentId).getQuantidadeVendida().toString(),
        0);

    txtContadorRastreabItens.setText(String.format("Itens: %s/%s", currentId + 1, itens.size()));
    txtContadorCilindros.setText(String.format("Cilindros: %s/%s", tCil,
      UtilHelper.formatDoubleString(itens.get(currentId).getQuantidadeVendida(), 0)));

    if (curIdx != -1 && (!next && itens.get(currentId).getQuantidadeVendida() == lotes.size())) {
      btnPosteriorRastreab.callOnClick();
    }

    if (txtCilindro.isFocusable())
      txtCilindro.requestFocus();
  }

  private void initScanner() {
    AidcManager.create(this, new AidcManager.CreatedCallback() {

      @Override
      public void onCreated(AidcManager aidcManager) {
        manager = aidcManager;
        try {
          btnBarcode.setVisibility(GONE);

          barcodeReader = manager.createBarcodeReader();
          // register bar code event listener
          barcodeReader.addBarcodeListener(InvoiceRastreabActivity.this);
          // set the trigger mode to client control
          barcodeReader.setProperty(BarcodeReader.PROPERTY_TRIGGER_CONTROL_MODE,
            BarcodeReader.TRIGGER_CONTROL_MODE_AUTO_CONTROL);
          // register trigger state change listener
          barcodeReader.addTriggerListener(InvoiceRastreabActivity.this);

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
  public void onDestroy() {
    super.onDestroy();
    if (barcodeReader != null) {
      // unregister barcode event listener
      barcodeReader.removeBarcodeListener(this);

      // unregister trigger state change listener
      barcodeReader.removeTriggerListener(this);

      barcodeReader.release();
    }
  }

  private void init() {
    for (ItemPrice itPrice : GLOBAL.self().getPrices()) {
      if (ConstantsEnum.YES.getValue().equalsIgnoreCase(itPrice.getItem().getIndRastreavel())) {
        itens.add(itPrice);
        totalItens += itPrice.getQuantidadeVendida();
      }
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_invoice_rastreab);

    informados = new ArrayList<>();
    totalItens = 0D;

    initScanner();

    init();

    EditText txtQtd = findViewById(R.id.txtQtd);

    if (GLOBAL.self().isLiquido())
      totalItens = 1D;

    txtQtd.setText(UtilHelper.formatDoubleString(totalItens, 0));

    currentId = 0;

    itemList = findViewById(R.id.item_list);
    itemList.setChoiceMode(ListView.FOCUSABLES_TOUCH_MODE);

    if (GLOBAL.self().isLiquido())
      itemList.setVisibility(GONE);
    else
      itemList.setVisibility(View.VISIBLE);

    itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        editIdx = i;
        editingLoteCil = filter().get(i);
        txtCilindro.setText("");
        txtLote.setText("");

        DialogHelper.showQuestionMessage(InvoiceRastreabActivity.this,
          R.string.confirmar_text, R.string.edit_cilindro,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              informados.remove(informados.indexOf(editingLoteCil));
              updateListView(null);
              editIdx = -1;
              editingLoteCil = null;
            }
          }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              updateListView(null);
              editIdx = -1;
              editingLoteCil = null;
            }
          });
      }
    });

    ImageButton buttonConfirm = findViewById(R.id.btnConfirmarRastreabilidade);
    buttonConfirm.setOnClickListener(confirmOrderClickListener);

    btnPosteriorRastreab = findViewById(R.id.btnPosteriorRastreab);
    btnPosteriorRastreab.setOnClickListener(btnPosteriorClickListener);

    btnAnteriorRastreab = findViewById(R.id.btnAnteriorRastreab);
    btnAnteriorRastreab.setOnClickListener(btnAnteriorClickListener);
    txtLote = findViewById(R.id.txtLote);
    lblCilindro = findViewById(R.id.lblCilindro);
    txtCilindro = findViewById(R.id.txtCilindro);
    txtCilindro.requestFocus();
    txtDescricaoItemRastreab = findViewById(R.id.txtDescricaoItemRastreab);
    txtContadorRastreabItens = findViewById(R.id.txtContadorRastreabItens);
    txtContadorCilindros = findViewById(R.id.txtContadorCilindros);

    if (GLOBAL.self().isLiquido()) {
      lblCilindro.setVisibility(GONE);
      txtCilindro.setVisibility(GONE);
      txtContadorCilindros.setVisibility(GONE);
      txtLote.requestFocus();
    }

    btnBarcode = findViewById(R.id.btnBarcodeRastreabilidade);
    btnBarcode.setOnClickListener(btnScanBarCodeClickListener);

    show(0, false);

    rastHelper = RastHelper.self().init();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

    if (requestCode == 0) {
      if (resultCode == CommonStatusCodes.SUCCESS) {
        String barCode = intent.getExtras().get("barcode").toString();

        LoteCil loteCil = null;

        //TODO: RETESTAR ESSA FUNÇÃO
        if (txtCilindro.hasFocus()) {
          if (rastHelper.validaCilindro(InvoiceRastreabActivity.this, barCode, informados,
            loteCil)) {
            txtCilindro.setText(barCode);
            txtLote.requestFocus();
            btnBarcode.performClick();
          }
        } else if (txtLote.hasFocus()) {
          if (rastHelper.validaLote(InvoiceRastreabActivity.this, barCode)) {
            txtLote.setText(barCode);

            confirmar();
          }
        }
      }
    }
  }

  public class LoteCil {
    private Long cdItem;
    private Double capacidade;
    private String cdCilindro;
    private String numeroLote;

    private LoteCil(Long cdItem, Double capacidade, String numeroLote, String cdCilindro) {
      this.cdItem = cdItem;
      this.capacidade = capacidade;
      if (cdCilindro == null || cdCilindro.isEmpty())

        this.cdCilindro = "0";
      else
        this.cdCilindro = cdCilindro;

      this.numeroLote = numeroLote;
    }

    public Long getCdItem() {
      return cdItem;
    }

    public void setCdItem(Long cdItem) {
      this.cdItem = cdItem;
    }

    public String getCdCilindro() {
      return cdCilindro;
    }

    public void setCdCilindro(String cdCilindro) {
      this.cdCilindro = cdCilindro;
    }

    public Double getCapacidade() {
      return capacidade;
    }

    public void setCapacidade(Double capacidade) {
      this.capacidade = capacidade;
    }

    public String getNumeroLote() {
      return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
      this.numeroLote = numeroLote;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      LoteCil loteCil = (LoteCil) o;
      return Objects.equals(cdItem, loteCil.cdItem)
        && Objects.equals(capacidade, loteCil.capacidade)
        && Objects.equals(cdCilindro, loteCil.cdCilindro)
        && Objects.equals(numeroLote, loteCil.numeroLote);
    }

    @Override
    public int hashCode() {
      return Objects.hash(cdItem, capacidade);
    }

    @Override
    public String toString() {
      return String.format("Cilindro: %s\nLote: %s",
        UtilHelper.padRight(cdCilindro, ' ', 9),
        UtilHelper.padRight(numeroLote, ' ', 13)
      );
    }
  }
}
