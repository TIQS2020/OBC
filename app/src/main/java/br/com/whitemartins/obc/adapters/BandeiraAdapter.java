package br.com.whitemartins.obc.adapters;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.List;

import br.com.whitemartins.obc.interafce.adapterListener;
import br.com.whitemartins.obc.model.Code;
import br.com.whitemartins.obc.model.ItemPrice;

public class BandeiraAdapter extends ArrayAdapter<Code> {

  private Activity context;
  private List<ItemPrice> prices;
  private adapterListener mClickListener;
  private boolean showButtons = true;

  public BandeiraAdapter(Activity context, List<Code> codes, adapterListener listener) {
    super(context, 0, codes);
    this.context = context;
    this.prices = prices;
    this.mClickListener = listener;
  }

}
