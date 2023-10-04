package br.com.whitemartins.obc.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.adapterListener;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.AddItemActivity;


public class ItemPriceListAdapter extends ArrayAdapter<ItemPrice> {
  private Activity context;
  private List<ItemPrice> prices;
  private adapterListener mClickListener;
  private boolean showButtons = true;

  public ItemPriceListAdapter(Activity context, List<ItemPrice> prices, adapterListener listener) {
    super(context, 0, prices);
    this.context = context;
    this.prices = prices;
    this.mClickListener = listener;
  }

  @Override
  public int getCount() {
    return prices.size();
  }

  @Override
  public ItemPrice getItem(int position) {
    return prices.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  public void setTrashButtonVisibility(boolean show) {
    showButtons = show;
  }

  @NonNull
  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    Integer desclength;

    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.item_price_list_adapter, null);
    }

    final View finalConvertView = convertView;
    ImageButton btnDeleteItemPedido = convertView.findViewById(R.id.btnDeleteItemPedido);
    ImageButton btnEditItemPedido = convertView.findViewById(R.id.btnEditItemPedido);

    if (showButtons) {
      btnDeleteItemPedido.setVisibility(View.VISIBLE);
      desclength = 13;
    } else {
      btnDeleteItemPedido.setVisibility(View.GONE);
      desclength = 20;
    }
    btnEditItemPedido.setVisibility(btnDeleteItemPedido.getVisibility());

    btnEditItemPedido.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        ItemPrice price = GLOBAL.self().getPrices().get(position);

        Intent addItemActivity = new Intent(context, AddItemActivity.class);

        addItemActivity.putExtra("price", price);
        addItemActivity.putExtra("position", position);
        context.startActivity(addItemActivity);
      }
    });

    btnDeleteItemPedido.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ItemPrice p = GLOBAL.self().getPrices().get(position);
        String e = finalConvertView.getResources().getString(R.string.excluir_item_pedido);
        String m = String.format(Locale.getDefault(), e,
          p.getItem().getCdItem().toString() + " " + p.getItem().getDescricaoProduto());

        DialogHelper.showQuestionMessage(finalConvertView.getContext(),
          finalConvertView.getResources().getString(R.string.confirmar_text), m,
          new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
              GLOBAL.self().getPrices().remove(position);
              notifyDataSetChanged();
              mClickListener.onUpdateLabels();

            }
          }, null);
      }
    });

    TextView tvValores = convertView.findViewById(R.id.item_name);
    TextView tvItem = convertView.findViewById(R.id.item_descricao);

    ItemPrice price = getItem(position);

    String format = "%s %s\n%s %s";

    if (tvValores != null && tvItem != null) {
      String text = String.format(format,
        context.getString(R.string.quantidadeVendida),
        UtilHelper.formatDoubleString(price.getQuantidadeVendida(), 0),
        context.getString(R.string.preco_unitario),
        UtilHelper.formatDoubleString(price.getValorUnitario(), 4)
      );

      tvValores.setText(text);

      String item = String.format(Locale.getDefault(), "%s: %s %s: %s\n%s",
        context.getString(R.string.item),
        price.getItem().getCdItem(),
        context.getString(R.string.capacidade),
        price.getItem().getCapacidadeProduto(),
        price.getItem().getDescricaoProduto());

      tvItem.setText(item);

      if (position % 2 == 0) {
        tvItem.setTextColor(context.getColor(R.color.pressed_color));
        tvValores.setTextColor(context.getColor(R.color.pressed_color));
      } else {
        tvItem.setTextColor(context.getColor(R.color.appTextColor));
        tvValores.setTextColor(context.getColor(R.color.appTextColor));
      }
    }

    return convertView;
  }
}
