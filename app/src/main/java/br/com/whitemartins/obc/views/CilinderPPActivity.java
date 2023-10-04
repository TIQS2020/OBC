package br.com.whitemartins.obc.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class CilinderPPActivity extends BaseActivity {

  EditText edt1, edt2, edt3, edt4, edt5, edt6;
  List<String> values = new ArrayList<>();
  private View.OnClickListener confirmOrderClickListener = new View.OnClickListener() {
    public void onClick(View v) {

      if (!values.contains(UtilHelper.padLeft(edt1.getText().toString(), getChar(edt1.isEnabled()), 15)) && edt1.isEnabled())
        values.add(UtilHelper.padLeft(edt1.getText().toString(), getChar(edt1.isEnabled()), 15));

      if (!values.contains(UtilHelper.padLeft(edt2.getText().toString(), getChar(edt2.isEnabled()), 15)) && edt2.isEnabled())
        values.add(UtilHelper.padLeft(edt2.getText().toString(), getChar(edt2.isEnabled()), 15));

      if (!values.contains(UtilHelper.padLeft(edt3.getText().toString(), getChar(edt3.isEnabled()), 15)) && edt3.isEnabled())
        values.add(UtilHelper.padLeft(edt3.getText().toString(), getChar(edt1.isEnabled()), 15));

      if (!values.contains(UtilHelper.padLeft(edt4.getText().toString(), getChar(edt4.isEnabled()), 15)) && edt4.isEnabled())
        values.add(UtilHelper.padLeft(edt4.getText().toString(), getChar(edt4.isEnabled()), 15));

      if (!values.contains(UtilHelper.padLeft(edt5.getText().toString(), getChar(edt5.isEnabled()), 15)) && edt5.isEnabled())
        values.add(UtilHelper.padLeft(edt5.getText().toString(), getChar(edt5.isEnabled()), 15));

      if (!values.contains(UtilHelper.padLeft(edt6.getText().toString(), getChar(edt6.isEnabled()), 15)) && edt6.isEnabled())
        values.add(UtilHelper.padLeft(edt6.getText().toString(), getChar(edt6.isEnabled()), 15));

      String serial = UtilHelper.padLeft(edt1.getText().toString(), getChar(edt1.isEnabled()), 15) +
        UtilHelper.padLeft(edt2.getText().toString(), getChar(edt2.isEnabled()), 15) +
        UtilHelper.padLeft(edt3.getText().toString(), getChar(edt3.isEnabled()), 15) +
        UtilHelper.padLeft(edt4.getText().toString(), getChar(edt4.isEnabled()), 15) +
        UtilHelper.padLeft(edt5.getText().toString(), getChar(edt5.isEnabled()), 15) +
        UtilHelper.padLeft(edt6.getText().toString(), getChar(edt6.isEnabled()), 15);

      if (isValid(serial)) {
        Intent intent = new Intent();
        intent.putExtra("PPs", serial);
        setResult(CommonStatusCodes.SUCCESS, intent);
        finish();
      } else
        DialogHelper.showErrorMessage(CilinderPPActivity.this, R.string.erro_text,
          R.string.pp_invalidos, null);
    }
  };

  private char getChar(Boolean isEnabled) {
    return isEnabled ? '0' : ' ';
  }

  private Boolean isValid(String serial) {

    if (
      (edt1.isEnabled() && edt1.getText().toString().isEmpty()) ||
        (edt2.isEnabled() && edt2.getText().toString().isEmpty()) ||
        (edt3.isEnabled() && edt3.getText().toString().isEmpty()) ||
        (edt4.isEnabled() && edt4.getText().toString().isEmpty()) ||
        (edt5.isEnabled() && edt5.getText().toString().isEmpty()) ||
        (edt6.isEnabled() && edt6.getText().toString().isEmpty())
    ) {
      DialogHelper.showErrorMessage(CilinderPPActivity.this, R.string.erro_text,
        R.string.informar_pps, null);
      return false;
    } else if (values.size() != serial.trim().length() / 15) {
      return false;
    } else {
      for (String s : values) {
        if (Double.parseDouble(s) == 0d)
          return false;
      }
    }

    return true;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cilinder_pp);

    Double quantidade = getIntent().getDoubleExtra("quantidade", 0d);

    edt1 = findViewById(R.id.edt1);
    edt2 = findViewById(R.id.edt2);
    edt3 = findViewById(R.id.edt3);
    edt4 = findViewById(R.id.edt4);
    edt5 = findViewById(R.id.edt5);
    edt6 = findViewById(R.id.edt6);

    edt1.setEnabled(false);
    edt2.setEnabled(false);
    edt3.setEnabled(false);
    edt4.setEnabled(false);
    edt5.setEnabled(false);
    edt6.setEnabled(false);

    List<EditText> edits = new ArrayList<>();

    edits.add(edt1);
    edits.add(edt2);
    edits.add(edt3);
    edits.add(edt4);
    edits.add(edt5);
    edits.add(edt6);

    for (EditText edt : edits) {
      edt.setEnabled(UtilHelper.convertToDoubleDef(edt.getTag().toString(), 0) <= quantidade);
    }

    ImageButton btnConfirmarMensagemAdicional = findViewById(R.id.btnConfirmarMensagemAdicional);
    btnConfirmarMensagemAdicional.setOnClickListener(confirmOrderClickListener);

    edt1.requestFocus();
  }

}
