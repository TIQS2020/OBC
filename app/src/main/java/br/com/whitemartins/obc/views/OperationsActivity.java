package br.com.whitemartins.obc.views;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Excepty;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.operations.Apl;
import br.com.whitemartins.obc.operations.AplHc;
import br.com.whitemartins.obc.operations.Fut;
import br.com.whitemartins.obc.operations.Rcl;
import br.com.whitemartins.obc.operations.RclHc;
import br.com.whitemartins.obc.operations.RclNf;
import br.com.whitemartins.obc.operations.Rfh;
import br.com.whitemartins.obc.operations.Rps;
import br.com.whitemartins.obc.operations.Trc;
import br.com.whitemartins.obc.operations.Vnd;
import br.com.whitemartins.obc.operations.Vor;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class OperationsActivity extends BaseActivity {
  List<PreOrder> preOrders;
  private Customer customer;

  private MyCallbackInterface.CallbackBooleanInterface
    performPositiveClick = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      if (OperationType.APL.equals(GLOBAL.self().getOperation().getOperationType()))
        if (GLOBAL.self().getTipoItem().equals(TypeItemType.GAS))
          DialogHelper.showQuestionMessage(OperationsActivity.this, R.string.confirmar_text,
            R.string.msg_apl, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                openOperation();
              }
            }, null);
        else
          openOperation();
      else
        openOperation();
    }
  };

  private MyCallbackInterface.CallbackBooleanInterface
    performFutPositiveClick = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      Intent it = new Intent(OperationsActivity.this, FutViewActivity.class);
      it.putExtra("customer", customer);
      startActivity(it);
    }
  };

  private View.OnClickListener VndClickListener = new View.OnClickListener() {
    public void onClick(View v) {

      LogHelper.self().info("VndClickListener");

      GLOBAL.self().init(OperationsActivity.this);
      GLOBAL.self().getPrices().clear();
      //Inciando um operação de Venda
      GLOBAL.self().setOperation(Vnd.newInstance());

      if (!GLOBAL.self().isHomecare()) {
        if (!GLOBAL.self().isLiquido()) {
          if (ConstantsEnum.YES.getValue().equalsIgnoreCase(GLOBAL.self().getCustomer().getFlSimplesFaturamento())
            && ConstantsEnum.NO.getValue().equalsIgnoreCase(GLOBAL.self().getCustomer().getFlPaciente())
          )
            DialogHelper.showQuestionMessage(OperationsActivity.this, R.string.confirmar_text,
              R.string.pergunta_operadora, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  startActivity(new Intent(OperationsActivity.this, InvoiceActivity.class));
                }
              }, null);
          else if (ConstantsEnum.YES.getValue().equalsIgnoreCase(GLOBAL.self().getCustomer().getFlSimplesFaturamento())
            && ConstantsEnum.YES.getValue().equalsIgnoreCase(GLOBAL.self().getCustomer().getFlPaciente()))
            DialogHelper.showErrorMessage(OperationsActivity.this, R.string.confirmar_text,
              R.string.venda_invalida_paciente, null);
          else
            startActivity(new Intent(OperationsActivity.this, InvoiceActivity.class));
        } else {
          startActivity(new Intent(OperationsActivity.this, InvoiceActivity.class));
        }
      } else {
        //Viagens Homecare
        if (ConstantsEnum.YES.getValue().equalsIgnoreCase(GLOBAL.self().getCustomer().getFlSimplesFaturamento())
          && ConstantsEnum.NO.getValue().equalsIgnoreCase(GLOBAL.self().getCustomer().getFlPaciente())
          && GLOBAL.self().getPatient() == null
        ) {
          DialogHelper.showQuestionMessage(OperationsActivity.this, R.string.confirmar_text,
            R.string.pergunta_operadora, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {

                //Apresentando a tela de seleção de tipo de item
                DialogHelper.showInputTipoItemDialog(OperationsActivity.this,
                  GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
                  GLOBAL.self().getPatient(), performPositiveClick);

//                startActivity(new Intent(OperationsActivity.this, InvoiceActivity.class));
              }
            }, null);

        } else if (ConstantsEnum.YES.getValue().equalsIgnoreCase(GLOBAL.self().getCustomer().getFlSimplesFaturamento())
          && ConstantsEnum.YES.getValue().equalsIgnoreCase(GLOBAL.self().getCustomer().getFlPaciente())
        ) {
          DialogHelper.showErrorMessage(OperationsActivity.this, R.string.confirmar_text,
            R.string.venda_invalida_paciente, null);
        } else if (ConstantsEnum.YES.getValue().equalsIgnoreCase(GLOBAL.self().getCustomer().getFlSimplesFaturamento())
          && GLOBAL.self().getPatient() != null) {
          DialogHelper.showErrorMessage(OperationsActivity.this, R.string.confirmar_text,
            R.string.venda_invalida_paciente, null);
        } else {
          //Apresentando a tela de seleção de tipo de item
          DialogHelper.showInputTipoItemDialog(OperationsActivity.this,
            GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
            GLOBAL.self().getPatient(), performPositiveClick);
        }
      }
    }
  };

  private View.OnClickListener RfhClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      GLOBAL.self().getPrices().clear();
      GLOBAL.self().init(OperationsActivity.this);
      GLOBAL.self().setOperation(Rfh.newInstance());

      if (GLOBAL.self().isHomecare())
        DialogHelper.showInputTipoItemDialog(OperationsActivity.this,
          GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
          GLOBAL.self().getPatient(), performPositiveClick);
      else
        performPositiveClick.execute(true);
    }
  };

  private View.OnClickListener AplClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      GLOBAL.self().getPrices().clear();
      GLOBAL.self().init(OperationsActivity.this);
      GLOBAL.self().setOperation(Apl.newInstance());

      if (GLOBAL.self().isHomecare()) {
        DialogHelper.showInputTipoItemDialog(OperationsActivity.this,
          GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
          GLOBAL.self().getPatient(), performPositiveClick);
      } else
        performPositiveClick.execute(true);
    }
  };

  private View.OnClickListener RclClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      GLOBAL.self().getPrices().clear();
      GLOBAL.self().init(OperationsActivity.this);
      GLOBAL.self().setOperation(RclNf.newInstance());

      DialogHelper.showInputTipoRclDialog(OperationsActivity.this,
        GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
        GLOBAL.self().getPatient(), new MyCallbackInterface.CallbackBooleanInterface() {
          @Override
          public void execute(Boolean success) {
            if (GLOBAL.self().getTipoRcl().equalsIgnoreCase("WM"))
              GLOBAL.self().setOperation(RclNf.newInstance());
            else
              GLOBAL.self().setOperation(Rcl.newInstance());

            if (GLOBAL.self().isHomecare())
              DialogHelper.showInputTipoItemDialog(OperationsActivity.this,
                GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
                GLOBAL.self().getPatient(), performPositiveClick);
            else
              performPositiveClick.execute(true);
          }
        });
    }
  };

  private View.OnClickListener FutClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      GLOBAL.self().getPrices().clear();
      GLOBAL.self().init(OperationsActivity.this);
      GLOBAL.self().setOperation(Fut.newInstance());

      if (GLOBAL.self().isHomecare()) {
        DialogHelper.showInputTipoItemDialog(OperationsActivity.this,
          GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
          GLOBAL.self().getPatient(), performFutPositiveClick);
      } else
        performFutPositiveClick.execute(true);
    }
  };

  private View.OnClickListener VorClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      GLOBAL.self().getPrices().clear();
      GLOBAL.self().init(OperationsActivity.this);
      GLOBAL.self().setOperation(Vor.newInstance());

      if (GLOBAL.self().isHomecare())
        DialogHelper.showInputTipoItemDialog(OperationsActivity.this,
          GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
          GLOBAL.self().getPatient(), performPositiveClick);
      else
        performPositiveClick.execute(true);
    }
  };

  private View.OnClickListener TrcClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      GLOBAL.self().getPrices().clear();
      GLOBAL.self().init(OperationsActivity.this);
      GLOBAL.self().setOperation(Trc.newInstance());

      if (GLOBAL.self().isHomecare())
        DialogHelper.showInputTipoItemDialog(OperationsActivity.this,
          GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
          GLOBAL.self().getPatient(), performPositiveClick);
      else {
        DialogHelper.showInputPasswordDialog(OperationsActivity.this,
          R.string.libera_operacao_s8,
          new UtilHelper.OnOkListener() {
            @Override
            public boolean onOkClick(String value) {
              performPositiveClick.execute(true);
              return true;
            }
          }, false);

      }
    }
  };

  private View.OnClickListener RpsClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      GLOBAL.self().getPrices().clear();
      GLOBAL.self().init(OperationsActivity.this);
      GLOBAL.self().setOperation(Rps.newInstance());

//      GLOBAL.self().setCustomerService(GLOBAL.self().getCustomer());
//
//      Customer customer = DatabaseApp.self().getDatabase().customerDao()
//        .findById(UtilHelper.convertToLongDef(GLOBAL.self().getRoute().getCdCompanhia(), 0));
//
//      GLOBAL.self().setCustomer(customer);

      if (GLOBAL.self().isHomecare())
        DialogHelper.showInputTipoItemDialog(OperationsActivity.this,
          GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
          GLOBAL.self().getPatient(), performPositiveClick);
      else
        performPositiveClick.execute(true);
    }
  };

  private View.OnClickListener ConsultaNfeClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {

      Long cdCustomer = GLOBAL.self().getCustomer().getCdCustomer();

      if (GLOBAL.self().getPatient() != null)
        cdCustomer = GLOBAL.self().getPatient().getCdPaciente();

      List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao()
        .find(cdCustomer, UtilHelper.padLeft(GLOBAL.self().getRoute().getNumeroViagem().toString(),
          '0', 6));

      if (invoices.size() > 0) {
        Intent intent = new Intent(OperationsActivity.this, InvoiceViewActivity.class);
        intent.putExtra("cdCustomer", cdCustomer);
        startActivity(intent);
      } else
        DialogHelper.showInformationMessage(OperationsActivity.this, R.string.informar_text,
          R.string.no_invoices_customer, null);
    }
  };

  private void openOperation() {
    if (GLOBAL.self().isHomecare()) {
      if (GLOBAL.self().getTipoItem().equals(TypeItemType.EQUIPAMENTO)) {
        if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCLNF))
          GLOBAL.self().setOperation(RclHc.newInstance());
        else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.APL))
          GLOBAL.self().setOperation(AplHc.newInstance());
      }
    }
    startActivity(new Intent(OperationsActivity.this, InvoiceActivity.class));

  }

  @SuppressLint("SetTextI18n")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_operartions);
    GLOBAL.self().getPrices().clear();

    ImageButton btnVND = findViewById(R.id.btnVND);
    btnVND.setOnClickListener(VndClickListener);

    ImageButton btnAPL = findViewById(R.id.btnAPL);
    btnAPL.setOnClickListener(AplClickListener);

    ImageButton btnRCL = findViewById(R.id.btnRCL);
    btnRCL.setOnClickListener(RclClickListener);

    ImageButton btnTRC = findViewById(R.id.btnTRC);
    btnTRC.setOnClickListener(TrcClickListener);

    ImageButton btnFUT = findViewById(R.id.btnFUT);
    btnFUT.setOnClickListener(FutClickListener);

    ImageButton btnRFH = findViewById(R.id.btnRFH);
    btnRFH.setOnClickListener(RfhClickListener);

    ImageButton btnVOR = findViewById(R.id.btnVOR);
    btnVOR.setOnClickListener(VorClickListener);

    ImageButton btnRPS = findViewById(R.id.btnRPS);
    btnRPS.setOnClickListener(RpsClickListener);

    ImageButton btnConsultaNfeCliente = findViewById(R.id.btnConsultaNfeCliente);
    btnConsultaNfeCliente.setOnClickListener(ConsultaNfeClickListener);

    TextView txtCdClienteOperacao = findViewById(R.id.txtCdClienteOperacao);
    TextView txtDescClienteOperacao = findViewById(R.id.txtDescClienteOperacao);

    customer = GLOBAL.self().getCustomer();

    if (GLOBAL.self().getCustomerService() != null)
      customer = GLOBAL.self().getCustomerService();

    if (customer != null) {
      if (GLOBAL.self().getPatient() == null) {
        txtCdClienteOperacao.setText(customer.getCdCustomer().toString());
        txtDescClienteOperacao.setText(customer.getNome());
      } else {
        txtCdClienteOperacao.setText(GLOBAL.self().getPatient().getCdPaciente().toString());
        txtDescClienteOperacao.setText(GLOBAL.self().getPatient().getNome());
      }

      boolean isInterCo = GLOBAL.self().isIntercompany(customer);

      UtilHelper.setButtonStatus(OperationsActivity.this, btnAPL, !isInterCo);
      UtilHelper.setButtonStatus(OperationsActivity.this, btnRCL, !isInterCo);
      UtilHelper.setButtonStatus(OperationsActivity.this, btnTRC, !isInterCo);

      //FUT somente permitido para clientes que tenham PreOrder
      preOrders = DatabaseApp.self().getDatabase().preOrderDao().find(customer.getCdCustomer());
      UtilHelper.setButtonStatus(OperationsActivity.this, btnFUT, !preOrders.isEmpty());

      //Habilita somente para clientes que podem fazer Vor e não for viagem HC
      boolean VOR = customer.getCdCiaFiscal() > 0 && !GLOBAL.self().isHomecare();

      UtilHelper.setButtonStatus(OperationsActivity.this, btnVOR, VOR);
      //Habilita somente para viagens de liquido
      UtilHelper.setButtonStatus(OperationsActivity.this, btnRPS, false);

      //Dependendo do tipo de faturamento do cliente, permite ou não as operações abaixo
      if ((GLOBAL.self().isLiquido())
        && (customer.getFlNovoFaturamento().equalsIgnoreCase(ConstantsEnum._02.getValue()))
      ) {
        UtilHelper.setButtonStatus(OperationsActivity.this, btnVND, false);
        UtilHelper.setButtonStatus(OperationsActivity.this, btnRPS, true);
      }

      //Desabilitar operações em caso de liquido
      if (GLOBAL.self().isLiquido()) {
        UtilHelper.setButtonStatus(OperationsActivity.this, btnAPL, false);
        UtilHelper.setButtonStatus(OperationsActivity.this, btnRCL, false);
        UtilHelper.setButtonStatus(OperationsActivity.this, btnRFH, false);
      }

      if (GLOBAL.self().isPackeged()) {
        if (ConstantsEnum.YES.getValue().equalsIgnoreCase(customer.getFlSimplesFaturamento()))
          UtilHelper.setButtonStatus(OperationsActivity.this, btnRFH, true);
        else
          UtilHelper.setButtonStatus(OperationsActivity.this, btnRFH, false);
      }

      if (GLOBAL.self().isHomecare()) {
        if (ConstantsEnum.YES.getValue().equalsIgnoreCase(customer.getFlSimplesFaturamento()))
          UtilHelper.setButtonStatus(OperationsActivity.this, btnRFH, true);
        else
          UtilHelper.setButtonStatus(OperationsActivity.this, btnRFH, false);
      }

      if (GLOBAL.self().getInvoice() != null) {
        boolean invoiceIn = GLOBAL.self().getInvoice().getTipoNota()
          .equalsIgnoreCase(InvoiceType.ENTRADA.getValue());

        if (!GLOBAL.self().isLiquido()) {
          UtilHelper.setButtonStatus(OperationsActivity.this, btnRCL, invoiceIn);

          if (invoiceIn) {
            UtilHelper.setButtonStatus(OperationsActivity.this, btnAPL, !invoiceIn);
            UtilHelper.setButtonStatus(OperationsActivity.this, btnVND, !invoiceIn);
            UtilHelper.setButtonStatus(OperationsActivity.this, btnVOR, !invoiceIn);
            UtilHelper.setButtonStatus(OperationsActivity.this, btnRPS, !invoiceIn);
            UtilHelper.setButtonStatus(OperationsActivity.this, btnRFH, !invoiceIn);
            UtilHelper.setButtonStatus(OperationsActivity.this, btnTRC, !invoiceIn);
          }
        }
      }
    }
  }

  private void voltar() {
    if (!GLOBAL.self().isPedidoRealizado())
      DialogHelper.showInputMotiveDialog(this, GLOBAL.self().getCustomer(),
        GLOBAL.self().getPatient(), new MyCallbackInterface.CallbackStringInterface() {
          @Override
          public void execute(String choice) {

            String[] choices = choice.split("-");

            Excepty.newInstance().insere(GLOBAL.self().getCustomer().getCdCustomer(),
              UtilHelper.convertToLongDef(choices[0], 0),
              UtilHelper.currentDateTime(""), ConstantsEnum.N.getValue(), 0L,
              UtilHelper.currentDateTime(""), GLOBAL.self().getRoute().getNumeroViagem(),
              GLOBAL.self().getRoute().getDataViagem());

            startActivity(new Intent(OperationsActivity.this, CustomerServiceActivity.class));
            finish();
          }
        });
    else {
      startActivity(new Intent(OperationsActivity.this, CustomerServiceActivity.class));
      finish();
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_back: {
        voltar();
        break;
      }
      case R.id.travel_data: {
        ActivityHelper.showTravelData(OperationsActivity.this);
      }
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_client_detail_menu, menu);
    getMenuInflater().inflate(R.menu.menu_app, menu);
    return true;
  }

}
