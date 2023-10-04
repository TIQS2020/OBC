package br.com.whitemartins.obc.views;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import java.util.Locale;
import java.util.Map;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.AssetDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Asset;
import br.com.whitemartins.obc.model.AssetDistinct;
import br.com.whitemartins.obc.model.Message;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

import static android.content.DialogInterface.OnClickListener;
import static android.view.View.GONE;

public class ChargeCheckActivity extends BaseActivity implements BarcodeReader.BarcodeListener,
  BarcodeReader.TriggerListener {

  private static final int REQUEST_CODE_BAR_SCAN = 1;

  Long cdItemError = 0L;
  ArrayAdapter adapter;
  TextView txtItemDescricao, txtPatrimoniosCheck, txtItemCheck;
  EditText edtPatrimonio;
  ListView listPatrimonio;
  ImageButton btnAnteriorCheck, btnPosteriorCheck, btnConfirmar, btnFinalizar, btnBarcode;
  List<AssetDistinct> assetsDistinct;
  List<Patrimonio> informados;
  List<Asset> assets;
  int currentId = 0;
  AssetDao dao;
  Integer total = 0;

  private AidcManager manager;
  private BarcodeReader barcodeReader;

  private View.OnClickListener btnScanBarCodeClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      Intent intent = new Intent(ChargeCheckActivity.this, BarCodeActivity.class);

      intent.putExtra("titulo", getString(R.string.patrimonio_cod_bar));

      startActivityForResult(intent, REQUEST_CODE_BAR_SCAN);
    }
  };

  private View.OnClickListener btnAnteriorClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      show(-1, true, false);
      edtPatrimonio.setText("");
    }
  };

  private View.OnClickListener btnPosteriorClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      show(1, true, true);
      edtPatrimonio.setText("");
    }
  };

  private View.OnClickListener btnConfirmarClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      addAsset(edtPatrimonio.getText().toString());
    }
  };

  private MyCallbackInterface.CallbackVoidInterface callback = new MyCallbackInterface.CallbackVoidInterface() {
    @Override
    public void execute() {
      confirm();
    }
  };

  private OnClickListener finalizarCheck = new OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
      DialogHelper.showInputOdometroDialog(ChargeCheckActivity.this, false,
        callback);
    }
  };

  private View.OnClickListener btnFinalizarClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      String msg = validarPreenchimento(true);

      if (msg.isEmpty()) {

        DialogHelper.showQuestionMessage(ChargeCheckActivity.this,
          R.string.informar_text, R.string.fim_check_carga, finalizarCheck, null);
      } else
        DialogHelper.showInformationMessage(ChargeCheckActivity.this,
          getString(R.string.informar_text), msg, null);
    }
  };

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

    if (requestCode == REQUEST_CODE_BAR_SCAN) {
      if (resultCode == CommonStatusCodes.SUCCESS) {
        String barCode = intent.getExtras().get("barcode").toString();
        edtPatrimonio.setText(barCode);
        addAsset(edtPatrimonio.getText().toString());
      }
    }
  }

  @Override
  public void onBarcodeEvent(BarcodeReadEvent event) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        // update UI to reflect the data
        String barCode = event.getBarcodeData();
        edtPatrimonio.setText(barCode);
        addAsset(edtPatrimonio.getText().toString());
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
          btnBarcode.setVisibility(GONE);

          barcodeReader = manager.createBarcodeReader();
          // register bar code event listener
          barcodeReader.addBarcodeListener(ChargeCheckActivity.this);
          // set the trigger mode to client control
          barcodeReader.setProperty(BarcodeReader.PROPERTY_TRIGGER_CONTROL_MODE,
            BarcodeReader.TRIGGER_CONTROL_MODE_AUTO_CONTROL);
          // register trigger state change listener
          barcodeReader.addTriggerListener(ChargeCheckActivity.this);

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

  private void confirm() {
    StringBuilder msg = new StringBuilder();

    List<Message> messages = DatabaseApp.self().getDatabase().messageDao()
      .find(ConstantsEnum.M.getValue());

    for (Message m : messages)
      msg.append(m.getMensagem()).append("\n");

    if (!messages.isEmpty())

      DialogHelper.showInformationMessage(this,
        getString(R.string.driver_message), msg.toString(), new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            startActivity(new Intent(ChargeCheckActivity.this,
              CustomerServiceActivity.class));
          }
        });
    else
      startActivity(new Intent(ChargeCheckActivity.this,
        CustomerServiceActivity.class));
  }

  //===============================================================================================
  @SuppressLint("SetTextI18n")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_charge_check);
    initScanner();

    informados = new ArrayList<>();

    dao = DatabaseApp.self().getDatabase().assetDao();

    txtItemDescricao = findViewById(R.id.txtDescricaoItemCheck);
    txtItemCheck = findViewById(R.id.txtItemCheck);
    listPatrimonio = findViewById(R.id.listPatrimonios);
    txtPatrimoniosCheck = findViewById(R.id.txtPatrimoniosCheck);
    edtPatrimonio = findViewById(R.id.edtPatrimonio);

    btnPosteriorCheck = findViewById(R.id.btnPosteriorCheck);
    btnPosteriorCheck.setOnClickListener(btnPosteriorClickListener);
    btnAnteriorCheck = findViewById(R.id.btnAnteriorCheck);
    btnAnteriorCheck.setOnClickListener(btnAnteriorClickListener);
    btnConfirmar = findViewById(R.id.btnConfimarCheckCarga);
    btnConfirmar.setOnClickListener(btnConfirmarClickListener);
    btnFinalizar = findViewById(R.id.btnFinalizarCheckCarga);
    btnFinalizar.setOnClickListener(btnFinalizarClickListener);
    btnBarcode = findViewById(R.id.btnBarcodeRastreabilidade);
    btnBarcode.setOnClickListener(btnScanBarCodeClickListener);

    String text = UtilHelper.padRight(getString(R.string.patrimonio), ' ', 20) +
      UtilHelper.padRight(getString(R.string.serie_patrimonio), ' ', 20);

    TextView txtHeaderCheckCarga = findViewById(R.id.txtHeaderCheckCarga);
    txtHeaderCheckCarga.setText(text);

    assetsDistinct = dao.getDistinct();

    txtPatrimoniosCheck.setText(
      String.format(Locale.getDefault(), "%s %d/%d", getString(R.string.patrimonio), currentId + 1,
        assetsDistinct.size()));

    if (assetsDistinct.size() > 0)
      txtItemDescricao.setText(assetsDistinct.get(currentId).getCdItem() +
        assetsDistinct.get(currentId).getDescricao());

    assets = dao.getAll();

    for (Asset asset : assets) {
      if (ConstantsEnum.YES.getValue().equals(asset.getChecado())) {
        informados.add(new Patrimonio(asset.getCdItem(), asset.getNumeroPatrimonio(),
          asset.getNumeroSerie()));
      }
    }
    show(currentId, false, false);
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

  private void show(int curIdx, boolean validate, boolean next) {
    currentId += curIdx;

    Long cdItem = assetsDistinct.get(currentId).getCdItem();
    txtItemDescricao.setText(String.format(Locale.getDefault(), "%s%s %s", getString(R.string.item),
      getString(R.string.dois_pontos), assetsDistinct.get(currentId).toString()));

    List<Asset> objts = dao.findByCdItem(cdItem);
    total = objts.size();

    List<Patrimonio> pats = new ArrayList<>();
    for (Patrimonio pat : informados) {
      if (pat.getCdItem().equals(cdItem))
        pats.add(pat);
    }

    adapter = new ArrayAdapter<>(this, android.R.layout.test_list_item, pats);
    listPatrimonio.setAdapter(adapter);

    txtItemCheck.setText(String.format(Locale.getDefault(), "%s%s %d/%d",
      getString(R.string.item), getString(R.string.dois_pontos), currentId + 1,
      assetsDistinct.size()));

    int tCil = pats.size() + 1;
    if (tCil > total)
      tCil = total;

    txtPatrimoniosCheck.setText(String.format(Locale.getDefault(), "%s %d/%d",
      getString(R.string.patrimonio), tCil, total));

    UtilHelper.setButtonStatus(this, btnAnteriorCheck, currentId > 0);
    UtilHelper.setButtonStatus(this, btnPosteriorCheck, currentId < assetsDistinct.size() - 1);

    edtPatrimonio.setEnabled(total != pats.size());

    UtilHelper.setButtonStatus(this, btnConfirmar, (total != pats.size()));

    if ((curIdx != -1) && (pats.size() == total) && btnPosteriorCheck.isEnabled() && !next)
      btnPosteriorCheck.callOnClick();
    else {
      if (!btnPosteriorCheck.isEnabled() && validate) {
        String msg = validarPreenchimento(false);

        if (msg.isEmpty())
          btnFinalizar.callOnClick();
      }
    }
  }

  private String validarLista(String patrimonio) {
    Asset asset = dao.findById(assetsDistinct.get(currentId).getCdItem(), patrimonio);

    if (asset == null) {
      edtPatrimonio.setText("");
      return getString(R.string.patrimonio_invalido_item);
    }

    List<Patrimonio> pats = new ArrayList<>();
    for (Patrimonio pat : informados) {
      if (pat.getNumPatrimonio().equals(patrimonio))
        pats.add(pat);
    }

    if (pats.size() > 0)
      return String.format(getString(R.string.patrimonio_ja_informado), patrimonio);

    return "";
  }

  private void addAsset(String patrimonio) {

    String msg = validarLista(patrimonio);

    if (!msg.isEmpty()) {
      DialogHelper.showInformationMessage(ChargeCheckActivity.this,
        getString(R.string.informar_text), msg, null);

      return;
    }

    Asset asset = dao.findById(assetsDistinct.get(currentId).getCdItem(), patrimonio);
    asset.setChecado(ConstantsEnum.YES.getValue());
    dao.update(asset);

    Patrimonio pat = new Patrimonio(assetsDistinct.get(currentId).getCdItem(), patrimonio,
      asset.getNumeroSerie());

    pat.setNumPatrimonio(patrimonio);
    informados.add(pat);

    edtPatrimonio.setText("");

    show(0, true, false);
  }

  private String validarPreenchimento(boolean finalizar) {
    cdItemError = 0L;
    int idx = 0;

    if (finalizar) {
      for (Asset asset : assets) {
        if (ConstantsEnum.NO.getValue().equals(asset.getChecado())) {
          cdItemError = asset.getCdItem();
          break;
        }
      }

      for (AssetDistinct assetDistinct : assetsDistinct) {
        idx++;
        if (assetDistinct.getCdItem().equals(cdItemError))
          break;
      }

      if (cdItemError > 0) {
        currentId = 0;
        show(idx, false, false);
        return getString(R.string.check_carga_error);
      }
    }

    for (Patrimonio pat : informados) {
      if (pat.getNumPatrimonio().isEmpty()) {
        cdItemError = pat.getCdItem();
        return getString(R.string.check_carga_error);
      }
    }

    if (assets.size() != informados.size())
      return getString(R.string.check_carga_error);

    return "";
  }

  //======================================================
  private class Patrimonio {
    private Long cdItem;
    private String numPatrimonio;
    private String serie;

    Patrimonio(Long cd_item, String pat, String serie) {
      this.cdItem = cd_item;
      this.numPatrimonio = pat;
      this.serie = serie;
    }

    public Long getCdItem() {
      return cdItem;
    }

    public void setCdItem(Long cdItem) {
      this.cdItem = cdItem;
    }

    String getNumPatrimonio() {
      return numPatrimonio;
    }

    void setNumPatrimonio(String numPatrimonio) {
      this.numPatrimonio = numPatrimonio;
    }

    public String getSerie() {
      return serie;
    }

    public void setSerie(String serie) {
      this.serie = serie;
    }

    @Override
    public String toString() {
      return UtilHelper.padRight(numPatrimonio, ' ', 20) +
        UtilHelper.padRight(serie, ' ', 20);
    }
  }

}
