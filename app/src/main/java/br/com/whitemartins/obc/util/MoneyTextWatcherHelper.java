package br.com.whitemartins.obc.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class MoneyTextWatcherHelper implements TextWatcher {
  private final WeakReference<EditText> editTextWeakReference;
  private Integer decimals;

  public MoneyTextWatcherHelper(EditText editText, Integer decimals) {
    editTextWeakReference = new WeakReference<EditText>(editText);
    this.decimals = decimals;
  }

  @Override
  public void beforeTextChanged(CharSequence s, int start, int count, int after) {
  }

  @Override
  public void onTextChanged(CharSequence s, int start, int before, int count) {
  }

  @Override
  public void afterTextChanged(Editable editable) {
    EditText editText = editTextWeakReference.get();

    if (editText == null) return;
    String s = editable.toString();
    if (s.isEmpty()) return;
    editText.removeTextChangedListener(this);
    //String cleanString = s.replaceAll("[,.]", "");

    String cleanString = s.replaceAll("[$,.]", "");
    int divisor = decimals > 0 ? (int) Math.pow(10, decimals) : 1;

    BigDecimal parsed = new BigDecimal(cleanString).setScale(decimals,
      BigDecimal.ROUND_FLOOR).divide(new BigDecimal(divisor), BigDecimal.ROUND_FLOOR);

    String formatted = NumberFormat.getNumberInstance().format(parsed);
    //formatted = formatted.substring(1);
    formatted = UtilHelper.formatDoubleString(parsed.doubleValue(), decimals);
    editText.setText(formatted);
    editText.setSelection(formatted.length());
    editText.addTextChangedListener(this);
  }
}