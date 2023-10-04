package br.com.whitemartins.obc.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.interafce.adapterListener;
import br.com.whitemartins.obc.model.Payment;
import br.com.whitemartins.obc.util.DialogHelper;

public class PaymentsAdapter extends ArrayAdapter<Payment> {
  private Activity context;
  private List<Payment> payments;
  private adapterListener mClickListener;
  private boolean showButtons = true;

  public PaymentsAdapter(Activity context, List<Payment> payments, adapterListener listener) {
    super(context, 0, payments);
    this.context = context;
    this.payments = payments;
    this.mClickListener = listener;
  }

  @Override
  public int getCount() {
    return payments.size();
  }

  @Override
  public Payment getItem(int position) {
    return payments.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  public void setTrashButtonVisibility(boolean show) {
    showButtons = show;
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {

    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.payment_list_adapter, null);
    }

    final View finalConvertView = convertView;
    ImageButton btnDeletePayment = convertView.findViewById(R.id.btnDeletePayment);
    btnDeletePayment.setFocusable(false);
    btnDeletePayment.setFocusableInTouchMode(false);

    if (showButtons) {
      btnDeletePayment.setVisibility(View.VISIBLE);
    } else {
      btnDeletePayment.setVisibility(View.GONE);
    }

    btnDeletePayment.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Payment p = getItem(position);
        String e = finalConvertView.getResources().getString(R.string.excluir_item_pagamento);
        String m = String.format(Locale.getDefault(), e, "");

        DialogHelper.showQuestionMessage(finalConvertView.getContext(),
          finalConvertView.getResources().getString(R.string.confirmar_text), m,
          new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
              payments.remove(position);
              notifyDataSetChanged();

              if (mClickListener != null)
                mClickListener.onUpdateLabels();

            }
          }, null);
      }
    });

    Payment payment = getItem(position);

    TextView item_name = convertView.findViewById(R.id.item_name);
    item_name.setFocusable(false);

    if (item_name != null)
      item_name.setText(payment.toString());

    return convertView;
  }

}
