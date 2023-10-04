package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.adapters.ItemPriceListAdapter;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.LotePatrimonioType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.adapterListener;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.model.Message;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DataGetHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

import static br.com.whitemartins.obc.util.UtilHelper.convertToLongDef;

public class InvoiceActivity extends BaseActivity implements BarcodeReader.BarcodeListener,
    BarcodeReader.TriggerListener {

  final Integer REQUEST_LOTE_PATRIMONIO = 1;
  final Integer REQUEST_VOR = 2;
  final Integer REQUEST_ADD_ITEM = 3;
  private Customer customer;
  private Customer customerService;
  private TextView txtQtdItem;
  private TextView txtQtdPedido;
  private TextView txtListTitulo;
  private TextView txtTipoPedido;
  private EditText txtCodigoItemPedido;
  private AidcManager manager;
  private BarcodeReader barcodeReader;
  private ImageButton btnFinishOrder;

  private View.OnClickListener confirmOrderClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      confirmar();
    }
  };

  private View.OnClickListener itemListClickListener = new View.OnClickListener() {
    public void onClick(View v) {

      Long cdPreOrder = GLOBAL.self().getPreOrder().getCdPreOrder();
      String numeroNotaOrigem = GLOBAL.self().getPreOrder().getNumeroNotaOrigem();
      Long cdCustomer = null;
      String flNovoFaturamento = "";

      if (customer != null) {
        cdCustomer = customer.getCdCustomer();
        flNovoFaturamento = customer.getFlNovoFaturamento();
      }

      //Caso o paciente tenha preço diferenciado, será usado o código do paciente ao invés do
      //código da operadora para buscar o preço
      if (GLOBAL.self().getPatient() != null
          && ConstantsEnum.YES.getValue().equals(GLOBAL.self().getPatient().getPrecoDiferente())) {
        cdCustomer = GLOBAL.self().getPatient().getCdPaciente();
      }

      List<ItemPrice> itp = DataGetHelper.getItemsPrice(cdCustomer, null, numeroNotaOrigem,
          GLOBAL.self().getTipoItem(), flNovoFaturamento);

      if (itp.size() > 0) {
        Intent intent = new Intent(InvoiceActivity.this, ItemListActivity.class);
        startActivity(intent);
      } else {
        txtCodigoItemPedido.setText("");
        DialogHelper.showInformationMessage(InvoiceActivity.this, R.string.informar_text,
            R.string.no_items, null);
      }
    }
  };

  private View.OnClickListener finalizarClickListener = new View.OnClickListener() {

    public void onClick(View v) {
      UtilHelper.setButtonStatus(InvoiceActivity.this, btnFinishOrder, false);

      if (GLOBAL.self().getPrices().size() == 0) {
        DialogHelper.showInformationMessage(InvoiceActivity.this, R.string.informar_text,
            R.string.pedido_sem_item, null);
      } else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.CPL))
        lotePatrtimonio();
      else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.VOR))
        vor();
      else if (Double.valueOf(1) > GLOBAL.self().getTotalPedido()) {
        DialogHelper.showErrorMessage(InvoiceActivity.this, R.string.informar_text,
            R.string.erro_fim_pedido, null);
      } else {
        lotePatrtimonio();
      }

      UtilHelper.setButtonStatus(InvoiceActivity.this, btnFinishOrder, true);
    }
  };

  private adapterListener adpListener = new adapterListener() {
    @Override
    public void onBtnClick(int position) {

    }

    @Override
    public void onUpdateLabels() {

      txtQtdItem = findViewById(R.id.qtdItem);
      txtQtdItem.setText(String.format(Locale.getDefault(), "%s %s",
          getString(R.string.qtd_itens),
          UtilHelper.formatDoubleString(GLOBAL.self().getQtdTotal(), 2)));

      txtQtdPedido = findViewById(R.id.qtdItemPedido);
      txtQtdPedido.setText(String.format(Locale.getDefault(), "%s %d",
          getString(R.string.qtd_itens_pedido), GLOBAL.self().getPrices().size()));
    }
  };

  private void confirmar() {
    Intent addItemActivity = new Intent(InvoiceActivity.this, AddItemActivity.class);
    String codigoItem = txtCodigoItemPedido.getText().toString();

    if (codigoItem == null || codigoItem.isEmpty()) {
      DialogHelper.showErrorMessage(InvoiceActivity.this, R.string.erro_text,
          R.string.empty_product_code_msg, null);
    } else {

      Long cdCustomer = null;
      String flNovoFaturamento = "";

      if (customer != null) {
        cdCustomer = customer.getCdCustomer();
        flNovoFaturamento = customer.getFlNovoFaturamento();
      }

      //Caso o paciente tenha preço diferenciado, será usado o código do paciente ao invés do
      //código da operadora para buscar o preço
      if (GLOBAL.self().getPatient() != null
          && ConstantsEnum.YES.getValue().equals(GLOBAL.self().getPatient().getPrecoDiferente())) {
        cdCustomer = GLOBAL.self().getPatient().getCdPaciente();
      }

      List<ItemPrice> items = DataGetHelper.getItemsPrice(cdCustomer,
          convertToLongDef(codigoItem, 0), GLOBAL.self().getPreOrder().getNumeroNotaOrigem(),
          GLOBAL.self().getTipoItem(), flNovoFaturamento);

      ItemPrice itemPrice = null;

      if (items.size() > 0)
        itemPrice = items.get(0);

      if (itemPrice != null) {
        int pos = GLOBAL.self().getPrices().indexOf(itemPrice);

        if (pos != -1)
          itemPrice = GLOBAL.self().getPrices().get(pos);

        addItemActivity.putExtra("position", pos);
        addItemActivity.putExtra("price", itemPrice);

        //startActivity(addItemActivity);
        startActivityForResult(addItemActivity, REQUEST_ADD_ITEM);
        txtCodigoItemPedido.setText("");
      } else {
        DialogHelper.showInformationMessage(InvoiceActivity.this, R.string.erro_text,
            R.string.invalid_product_code_msg, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                txtCodigoItemPedido.requestFocus();
                txtCodigoItemPedido.setText("");
              }
            });
      }
    }
  }

  private void finalizar() {

    boolean isRastreavel = false;

    //Verificando itens com rastreabilidade
    for (ItemPrice itPrice : GLOBAL.self().getPrices()) {
      if (ConstantsEnum.YES.getValue().equalsIgnoreCase(itPrice.getItem().getIndRastreavel())) {
        isRastreavel = true;
      }
    }

    if (!GLOBAL.self().getOperation().getOperationType().equals(OperationType.CPL)) {
      if (GLOBAL.self().getOperation().isRastreavel() && isRastreavel) {
        Intent finishOrder = new Intent(InvoiceActivity.this, InvoiceRastreabActivity.class);
        startActivity(finishOrder);
      } else {
        Intent finishOrder = new Intent(InvoiceActivity.this, InvoiceFinishActivity.class);
        startActivity(finishOrder);
      }
    } else {
      Intent finishOrder = new Intent(InvoiceActivity.this, InvoiceFinishActivity.class);
      startActivity(finishOrder);
    }

    finish();
  }

  private void informarLotePatrimonio() {
    DialogHelper.showQuestionMessage(InvoiceActivity.this, R.string.confirmar_text,
        R.string.informar_lote_pat, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {

            Intent it = new Intent(InvoiceActivity.this, LotePatActivity.class);
            it.putExtra("lotePatType", LotePatrimonioType.LOTE.getValue());
            startActivityForResult(it, REQUEST_LOTE_PATRIMONIO);
          }
        }, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            finalizar();
          }
        });
  }

  private void vor() {
    if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.VOR)) {
      Message message = DatabaseApp.self().getDatabase().messageDao()
          .findByType(ConstantsEnum.S.getValue());

      if (message != null) {
        String msg = String.format(getString(R.string.vor_message), message.getMensagem());

        DialogHelper.showInformationMessage(this, getString(R.string.informar_text), msg,
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                Intent it = new Intent(InvoiceActivity.this, InvoiceVorActivity.class);
                startActivityForResult(it, REQUEST_VOR);
              }
            });
      } else
        LogHelper.self().error("VOR", "Não encontrada a mensagem S no MESSAGE.TXT");
    }
  }

  private void lotePatrtimonio() {

    boolean consumivel = false;
    boolean equipamento = false;

    for (ItemPrice price : GLOBAL.self().getPrices()) {
      if (!consumivel)
        consumivel = (price.getItem().getTipoItem().equals(TypeItemType.CONSUMIVEL.getValue()));

      if (!equipamento)
        equipamento = (price.getItem().getTipoItem().equals(TypeItemType.EQUIPAMENTO.getValue()));
    }

    if (equipamento) {
      Intent it = new Intent(InvoiceActivity.this, LotePatActivity.class);
      it.putExtra("lotePatType", LotePatrimonioType.PATRIMONIO.getValue());
      startActivityForResult(it, REQUEST_LOTE_PATRIMONIO);
    } else if (consumivel) {
      informarLotePatrimonio();
    } else
      finalizar();
  }

  @Override
  protected void onResume() {
    super.onResume();
    txtQtdItem = findViewById(R.id.qtdItem);
    txtQtdItem.setText(String.format(Locale.getDefault(), "%s %s",
        getString(R.string.qtd_itens),
        UtilHelper.formatDoubleString(GLOBAL.self().getQtdTotal(), 0)));

    txtQtdPedido = findViewById(R.id.qtdItemPedido);
    txtQtdPedido.setText(String.format(Locale.getDefault(), "%s %d",
        getString(R.string.qtd_itens_pedido), GLOBAL.self().getPrices().size()));

    final ListView itemPriceList = findViewById(R.id.listItemPedido);
    final ArrayAdapter adapter = ((ArrayAdapter) itemPriceList.getAdapter());

    runOnUiThread(new Runnable() {
      public void run() {
        adapter.notifyDataSetChanged();
      }
    });
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    LogHelper.self().info("InvoiceActivity onCreate");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_invoice);

    initScanner();

    customer = GLOBAL.self().getCustomer();
    customerService = GLOBAL.self().getCustomerService();

    txtCodigoItemPedido = findViewById(R.id.txtCodigoItemPedido);

    ItemPriceListAdapter itemPriceListAdapter = new ItemPriceListAdapter(this,
        GLOBAL.self().getPrices(), adpListener);

    txtTipoPedido = findViewById(R.id.txtTipoPedido);
    txtTipoPedido.setText(GLOBAL.self().getOperation().getOperationType().getName());

    final ListView itemPriceList = findViewById(R.id.listItemPedido);

    itemPriceList.setAdapter(itemPriceListAdapter);

    ImageButton confirmOrderSell = findViewById(R.id.btnConfirmarPedido);
    confirmOrderSell.setOnClickListener(confirmOrderClickListener);

    ImageButton btnListItens = findViewById(R.id.btnListarItens);
    btnListItens.setOnClickListener(itemListClickListener);

    btnFinishOrder = findViewById(R.id.btnFinalizarPedido);
    btnFinishOrder.setOnClickListener(finalizarClickListener);

    if (GLOBAL.self().isLiquido()) {
      Item item = DatabaseApp.self().getDatabase().itemDao().getAll().get(0);
      txtCodigoItemPedido.setText(String.valueOf(item.getCdItem()));

      Long cdPreOrder = GLOBAL.self().getPreOrder().getCdPreOrder();
      String numeroNotaOrigem = GLOBAL.self().getPreOrder().getNumeroNotaOrigem();
      Long cdCustomer = null;
      String flNovoFaturamento = "";

      if (customer != null) {
        cdCustomer = customer.getCdCustomer();
        flNovoFaturamento = customer.getFlNovoFaturamento();
      }

      if (customerService != null) {
        cdCustomer = customerService.getCdCustomer();
        flNovoFaturamento = customerService.getFlNovoFaturamento();
      }

      //Caso o paciente tenha preço diferenciado, será usado o código do paciente ao invés do
      //código da operadora para buscar o preço
      if (GLOBAL.self().getPatient() != null
          && ConstantsEnum.YES.getValue().equals(GLOBAL.self().getPatient().getPrecoDiferente())) {
        cdCustomer = GLOBAL.self().getPatient().getCdPaciente();
      }

      List<ItemPrice> itp = DataGetHelper.getItemsPrice(cdCustomer, null, numeroNotaOrigem,
          GLOBAL.self().getTipoItem(), flNovoFaturamento);

      if (OperationType.RPS.equals(GLOBAL.self().getOperation().getOperationType())) {
        itp = DataGetHelper.getItemsPrice(customer.getCdCustomer(), null, numeroNotaOrigem,
            GLOBAL.self().getTipoItem(), customer.getFlNovoFaturamento());
      }

      if (itp.size() > 0) {
        confirmOrderSell.performClick();
      } else {
        txtCodigoItemPedido.setText("");
        DialogHelper.showInformationMessage(InvoiceActivity.this, R.string.informar_text,
            R.string.no_items, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                UtilHelper.hideKeyboardFrom(InvoiceActivity.this, getCurrentFocus());
                finish();
              }
            });
      }
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    LogHelper.self().info("onActivityResult" + resultCode);

    if (resultCode == CommonStatusCodes.SUCCESS) {
      if (requestCode == REQUEST_LOTE_PATRIMONIO)
        finalizar();
      else if (requestCode == REQUEST_VOR)
        lotePatrtimonio();
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    ActivityHelper.events(this, item);
    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_client_detail_menu, menu);
    getMenuInflater().inflate(R.menu.menu_app, menu);
    return true;
  }

  @Override
  public void onBarcodeEvent(BarcodeReadEvent event) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        // update UI to reflect the data
        String barCode = event.getBarcodeData();
        txtCodigoItemPedido.setText(barCode);
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
          barcodeReader = manager.createBarcodeReader();
          // register bar code event listener
          barcodeReader.addBarcodeListener(InvoiceActivity.this);
          // set the trigger mode to client control
          barcodeReader.setProperty(BarcodeReader.PROPERTY_TRIGGER_CONTROL_MODE,
              BarcodeReader.TRIGGER_CONTROL_MODE_AUTO_CONTROL);
          // register trigger state change listener
          barcodeReader.addTriggerListener(InvoiceActivity.this);

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

}
