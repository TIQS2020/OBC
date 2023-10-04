package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.CustomerListType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Message;
import br.com.whitemartins.obc.model.Patient;
import br.com.whitemartins.obc.util.DialogHelper;

public class ConfirmCustomerActivity extends BaseActivity {

  EditText edtClientNumber, edtClientName, edtClientAddress, edtClientCnpjCpf;
  Customer customer;
  Patient patient;
  CustomerListType type = null;

  private View.OnClickListener confirmClickListener = new View.OnClickListener() {
    public void onClick(View v) {

      Long cdCustomer;
      StringBuilder msg = new StringBuilder();

      if (patient != null)
        cdCustomer = patient.getCdPaciente();
      else
        cdCustomer = customer.getCdCustomer();

      List<Message> messages = DatabaseApp.self().getDatabase().messageDao()
        .find(ConstantsEnum.H.getValue(), cdCustomer);

      for (Message m : messages)
        msg.append(m.getMensagem()).append("\n");

      if (!messages.isEmpty())

        DialogHelper.showInformationMessage(ConfirmCustomerActivity.this,
          getString(R.string.customer_message), msg.toString(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              confirmCustomrer();
            }
          });
      else
        confirmCustomrer();
    }
  };

  private View.OnClickListener cancelClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      clear();
      Intent it = new Intent(ConfirmCustomerActivity.this, CustomerStopActivity.class);
      GLOBAL.self().setCustomerListType(type);
//      it.putExtra("type", type);
      startActivity(it);
      finish();
    }
  };

  private void confirmCustomrer() {
    GLOBAL.self().getPrices().clear();

    Intent it = null;
    if (GLOBAL.self().isTransfer())
      it = new Intent(this, TransferMenuActivity.class);
    else
      it = new Intent(this, OperationsActivity.class);

    startActivity(it);
    clear();
    finish();
  }

  private void clear() {
    edtClientNumber.setText("");
    edtClientName.setText("");
    edtClientAddress.setText("");
    edtClientCnpjCpf.setText("");
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_confirm_client);

//    if (getIntent().getExtras() != null && getIntent().getExtras().get("type") != null)
//      type = (CustomerListType) getIntent().getExtras().get("type");

    type = GLOBAL.self().getCustomerListType();


    edtClientNumber = findViewById(R.id.confirm_client_number);
    edtClientName = findViewById(R.id.confirm_client_name);
    edtClientAddress = findViewById(R.id.confirm_client_address);
    edtClientCnpjCpf = findViewById(R.id.confirm_client_cnpj_cpf);

    if (GLOBAL.self().getPatient() != null) {
      patient = GLOBAL.self().getPatient();

      edtClientNumber.setText(patient.getCdPaciente().toString());
      edtClientName.setText(patient.getNome());
      edtClientAddress.setText(patient.getEndereco());
      edtClientCnpjCpf.setText(patient.getCnpj());
    } else {
      customer = GLOBAL.self().getCustomer();

      edtClientNumber.setText(customer.getCdCustomer().toString());
      edtClientName.setText(customer.getNome());
      edtClientAddress.setText(customer.getEndereco());
      edtClientCnpjCpf.setText(customer.getCnpj());
    }
    ImageButton confirmClient = findViewById(R.id.btnConfimarCliente);
    confirmClient.setOnClickListener(confirmClickListener);

    ImageButton cancelClient = findViewById(R.id.btnCancelarCliente);
    cancelClient.setOnClickListener(cancelClickListener);
  }
}
