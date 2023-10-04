package br.com.whitemartins.obc.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.model.Saldo;


public class ChargeConsultListAdapter extends ArrayAdapter<Saldo> {
  private Activity context;
  private List<Saldo> saldos;

  public ChargeConsultListAdapter(Activity context, List<Saldo> saldos) {
    super(context, 0, saldos);
    this.context = context;
    this.saldos = saldos;
  }

  @Override
  public int getCount() {
    return saldos.size();
  }

  @Override
  public Saldo getItem(int position) {
    return saldos.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @NonNull
  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.list_view_charge_consult_adapter, null);
    }

    TextView tvItem = convertView.findViewById(R.id.tvItem);
    TextView tvSaldo = convertView.findViewById(R.id.tvSaldo);
    TextView tvManifestado = convertView.findViewById(R.id.tvManifestado);

    Saldo saldo = getItem(position);

    tvItem.setText(String.format(Locale.getDefault(), "%s: %s %s: %s\n%s",
      context.getString(R.string.item), saldo.getCdItem(), context.getString(R.string.capacidade),
      saldo.getCapacidade(), saldo.getNomeItem()));

    tvManifestado.setText(String.format(Locale.getDefault(), "%s: %s",
      context.getString(R.string.total_manifestado), saldo.getQtdCarregadaCheios().intValue()));

    tvSaldo.setText(String.format(Locale.getDefault(), "%s: %s",
      context.getString(R.string.saldo), saldo.getQtdAtualCheios().intValue()));

    return convertView;
  }
}