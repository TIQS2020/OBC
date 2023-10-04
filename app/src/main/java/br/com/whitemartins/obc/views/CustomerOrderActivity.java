package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;

public class CustomerOrderActivity extends BaseActivity {

  ItemPrice currentItem;
  ImageButton btnAnteriorPedidoCliente, btnPosteriorPedidoCliente, btnConfirmarPedidoCliente;
  EditText edtPedidoCliente, edtItemPedidoCliente;
  TextView txtDescricaoItemPedidoCliente, txtContadorPedidoCliente;
  int currentId = 0;
  List<ItemPrice> itens;
  List<PedidoCliente> pedidos = new ArrayList<>();
  List<PedidoCliente> vazios = new ArrayList<>();

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
      if (edtPedidoCliente.getText().toString().isEmpty() || edtItemPedidoCliente.getText().toString().isEmpty())
        DialogHelper.showErrorMessage(CustomerOrderActivity.this, R.string.erro_text,
          R.string.incompleto_pedido_cliente, null);
      else {
        PedidoCliente pedidoCliente = new PedidoCliente(getCurrentItem().getItem().getCdItem(),
          edtPedidoCliente.getText().toString(),
          edtItemPedidoCliente.getText().toString());

        add(pedidoCliente);
      }
    }
  };

  public ItemPrice getCurrentItem() {
    currentItem = itens.get(currentId);
    return currentItem;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_customer_order);

    itens = GLOBAL.self().getPrices();

    txtDescricaoItemPedidoCliente = findViewById(R.id.txtDescricaoItemPedidoCliente);
    edtPedidoCliente = findViewById(R.id.edtPedidoCliente);
    edtItemPedidoCliente = findViewById(R.id.edtItemPedidoCliente);
    txtContadorPedidoCliente = findViewById(R.id.txtContadorPedidoCliente);
    btnConfirmarPedidoCliente = findViewById(R.id.btnConfirmarPedidoCliente);
    btnAnteriorPedidoCliente = findViewById(R.id.btnAnteriorPedidoCliente);
    btnPosteriorPedidoCliente = findViewById(R.id.btnPosteriorPedidoCliente);

    btnAnteriorPedidoCliente.setOnClickListener(btnAnterior);
    btnPosteriorPedidoCliente.setOnClickListener(btnPosterior);
    btnConfirmarPedidoCliente.setOnClickListener(btnConfirmar);

    addScreenClickHideKeyboard(findViewById(R.id.screen));
    addScreenClickHideKeyboard(findViewById(R.id.screen2));

    show(0);
  }

  private void add(PedidoCliente pedidoCliente) {

    String textos = pedidoCliente.getPedidoCustomer() + pedidoCliente.getItemPedidoCustomer();

    if (!textos.isEmpty()) {

      try {
        if (!pedidos.isEmpty())
          pedidos.remove(currentId);
      } catch (IndexOutOfBoundsException e) {
        LogHelper.self().error("TAG", e);
      }

      int idx = pedidos.indexOf(pedidoCliente);
      if (idx == -1) {
        pedidos.add(pedidoCliente);

        int i = indexOfItem(vazios, getCurrentItem().getItem().getCdItem());
        if (i != -1)
          vazios.remove(i);

        getCurrentItem().setPedidoCustomer(pedidoCliente.getPedidoCustomer());
        getCurrentItem().setItemPedidoCustomer(pedidoCliente.getItemPedidoCustomer());

        show(1);
      } else {
        int i = indexOfItem(pedidos, getCurrentItem().getItem().getCdItem());
        //Não manda a mensagem para o mesmo item
        if (i != -1) {
          if (!pedidos.get(i).getCdItem().equals(pedidoCliente.getCdItem()))
            DialogHelper.showErrorMessage(CustomerOrderActivity.this, R.string.erro_text,
              R.string.repeticao_pedido_cliente, null);
        } else
          DialogHelper.showErrorMessage(CustomerOrderActivity.this, R.string.erro_text,
            R.string.repeticao_pedido_cliente, null);
      }
    } else {
      //Apaga o vazio para que não fique acumulando, sempre acrescentando
      int i = indexOfItem(vazios, getCurrentItem().getItem().getCdItem());
      if (i != -1)
        vazios.remove(i);

      vazios.add(pedidoCliente);

      i = indexOfItem(pedidos, getCurrentItem().getItem().getCdItem());
      if (i != -1)
        pedidos.remove(i);

      getCurrentItem().setPedidoCustomer(pedidoCliente.getPedidoCustomer());
      getCurrentItem().setItemPedidoCustomer(pedidoCliente.getItemPedidoCustomer());

      show(1);
    }

    if (pedidos.size() == itens.size()) {
      DialogHelper.showQuestionMessage(CustomerOrderActivity.this, R.string.confirmar_text,
        R.string.finalizar_pedido_cliente, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            finish();
          }
        },
        null);
    }

    if (vazios.size() == itens.size()) {
      DialogHelper.showQuestionMessage(CustomerOrderActivity.this, R.string.confirmar_text,
        R.string.finalizar_pedido_cliente_vazio, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            finishAffinity();
          }
        }, null);
    }
  }

  private Integer indexOfItem(List<PedidoCliente> list, Long cdItem) {

    for (Integer i = 0; i <= list.size() - 1; i++) {
      PedidoCliente p = list.get(i);

      if (p.getCdItem().equals(cdItem))
        return i;
    }

    return -1;
  }

  private void show(Integer value) {

    currentId += value;
    if (currentId > itens.size() - 1)
      currentId = itens.size() - 1;

    btnAnteriorPedidoCliente.setEnabled(currentId > 0);
    btnPosteriorPedidoCliente.setEnabled(currentId < itens.size() - 1);

    if (getCurrentItem() != null)
      txtDescricaoItemPedidoCliente.setText(String.format(Locale.getDefault(),
        "Item: %d - %s", getCurrentItem().getItem().getCdItem(),
        getCurrentItem().getItem().getDescricaoProduto()));
    else
      txtDescricaoItemPedidoCliente.setText("");

    txtContadorPedidoCliente.setText(String.format(Locale.getDefault(),
      "%d/%d", currentId + 1, itens.size()));

    edtPedidoCliente.setText(getCurrentItem().getPedidoCustomer());
    edtItemPedidoCliente.setText(getCurrentItem().getItemPedidoCustomer());
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
        DialogHelper.showQuestionMessage(CustomerOrderActivity.this, R.string.confirmar_text,
          R.string.fechar_sem_salvar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              finish();
            }
          },
          null);

        break;
    }
    return super.onOptionsItemSelected(item);
  }

  private class PedidoCliente {
    Long cdItem;
    String pedidoCustomer;
    String itemPedidoCustomer;

    public PedidoCliente(Long cdItem, String pedidoCustomer, String itemPedidoCustomer) {
      this.cdItem = cdItem;
      this.pedidoCustomer = pedidoCustomer;
      this.itemPedidoCustomer = itemPedidoCustomer;
    }

    public Long getCdItem() {
      return cdItem;
    }

    public void setCdItem(Long cdItem) {
      this.cdItem = cdItem;
    }

    public String getPedidoCustomer() {
      return pedidoCustomer;
    }

    public String getItemPedidoCustomer() {
      return itemPedidoCustomer;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;

      if (o == null || getClass() != o.getClass()) return false;

      PedidoCliente that = (PedidoCliente) o;

      return Objects.equals(pedidoCustomer, that.pedidoCustomer) &&
        Objects.equals(itemPedidoCustomer, that.itemPedidoCustomer);
    }

    @Override
    public int hashCode() {
      return Objects.hash(cdItem, pedidoCustomer, itemPedidoCustomer);
    }
  }
}
