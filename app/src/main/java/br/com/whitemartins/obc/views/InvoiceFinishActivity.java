package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.PaymentDao;
import br.com.whitemartins.obc.dao.SearchDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.FinishTripType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.global.TRIP;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.model.Payment;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.model.Search;
import br.com.whitemartins.obc.model.Tax;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.timer.SendInvoiceTimer;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.MoneyTextWatcherHelper;
import br.com.whitemartins.obc.util.SaldoHelper;
import br.com.whitemartins.obc.util.SearchHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;

public class InvoiceFinishActivity extends BaseActivity {

  final Integer REQUEST_MENSAGEM_ADICIONAL = 1;
  final Integer REQUEST_PEDIDO_CLIENTE = 2;
  final Integer REQUEST_PESQUISA = 3;
  final Integer REQUEST_PAGTO_CARTAO = 4;

  Double valorDinheiro = 0D;
  Double valorTroco = 0D;
  Double valorCheque = 0D;
  Double valorCredito = 0D;
  Double valorDebito = 0D;
  Double valorFatura = 0D;
  Double valorTotalPedido = 0D;
  String numeroCheque = "";

  Invoice invoice;

  boolean faturado = false;
  ImageButton finishOrder;
  Double totalPedido = 0D;
  TextView tvTotalPedidoFim, edtClientePrazo;
  EditText edtDinheiroFim, edtTrocoFim, edtChequeFim, edtNumChequeFim,
      edtDebitoFim, edtCreditoFim, edtFaturaFim;

  View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View view, boolean hasFocus) {
      EditText editText = ((EditText) view);
      editText.setSelection(editText.getText().toString().length());

      valorFatura = UtilHelper.formatDouble(edtFaturaFim.getText().toString(), 2);
      if (valorFatura > 0) {
        if (hasFocus)
          DialogHelper.showInformationMessage(InvoiceFinishActivity.this, R.string.confirmar_text,
              R.string.confirmar_a_vista, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
              });
      }
    }
  };

  private void clearField(EditText editText) {
    editText.setText(R.string.zero);
  }

  private View.OnClickListener finishOrderClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      UtilHelper.setButtonStatus(InvoiceFinishActivity.this, finishOrder, false);

      GLOBAL.self().setPedidoRealizado(true);

      if (!GLOBAL.self().getOperation().getOperationType().equals(OperationType.CPL)
          && !GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCL)) {
        valorDinheiro = UtilHelper.formatDouble(edtDinheiroFim.getText().toString(), 2);
        valorTroco = UtilHelper.formatDouble(edtTrocoFim.getText().toString(), 2);
        valorCheque = UtilHelper.formatDouble(edtChequeFim.getText().toString(), 2);
        valorCredito = UtilHelper.formatDouble(edtCreditoFim.getText().toString(), 2);
        valorDebito = UtilHelper.formatDouble(edtDebitoFim.getText().toString(), 2);
        valorFatura = UtilHelper.formatDouble(edtFaturaFim.getText().toString(), 2);
        valorTotalPedido = UtilHelper.formatDouble(GLOBAL.self().getTotalPedido(), 2);

        numeroCheque = edtNumChequeFim.getText().toString();

        Double sum = UtilHelper.formatDouble(
            valorDinheiro + valorCheque + valorCredito + valorDebito + valorFatura, 2);

        if (((valorFatura + valorDinheiro + valorCheque + valorDebito + valorCredito)
            - valorTotalPedido) < valorDinheiro)
          valorTroco = (valorFatura + valorDinheiro + valorCheque + valorDebito + valorCredito)
              - valorTotalPedido;

        if (valorTroco < 0)
          valorTroco = Math.abs(valorTroco);

        valorTroco = UtilHelper.formatDouble(valorTroco, 2);

        if (!sum.equals(UtilHelper.formatDouble(valorTotalPedido + valorTroco, 2))) {
          DialogHelper.showErrorMessage(InvoiceFinishActivity.this, R.string.informar_text,
              R.string.erro_valor_pedido, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  UtilHelper.setButtonStatus(InvoiceFinishActivity.this, finishOrder,
                      true);
                }
              });
        } else if (valorCheque > 0 && numeroCheque.isEmpty()) {
          DialogHelper.showErrorMessage(InvoiceFinishActivity.this, R.string.informar_text,
              R.string.numero_cheque_obrigatorio, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  UtilHelper.setButtonStatus(InvoiceFinishActivity.this, finishOrder, true);
                }
              });
        } else {
          InvoiceHelper.self()
              .setValorDinheiro(valorDinheiro)
              .setValorTroco(valorTroco)
              .setValorCheque(valorCheque)
              .setNumeroCheque(edtNumChequeFim.getText().toString())
              .setValorDebito(valorDebito)
              .setValorCredito(valorCredito)
              .setValorFatura(valorFatura);

          pagamentoCartao();
        }
      } else {
        SuperOperation operation = GLOBAL.self().getOperation();

        for (ItemPrice itemPrice : GLOBAL.self().getPrices()) {
          SaldoHelper.self().atualizarSaldoOperation(itemPrice.getItem().getCdItem(),
              itemPrice.getItem().getCapacidadeProduto(), operation, itemPrice.getQuantidadeVendida(),
              PreOrder.newInstance().getNumeroNotaOrigem(), GLOBAL.self().getRoute().getNumeroViagem(),
              false);
        }

        if (operation.getOperationType().equals(OperationType.RCL)) {
          DialogHelper.showInformationMessage(InvoiceFinishActivity.this,
              R.string.informar_text, R.string.rcl_done, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  startActivity(new Intent(InvoiceFinishActivity.this,
                      OperationsActivity.class));

                  finish();
                }
              });
        } else {
          startActivity(new Intent(InvoiceFinishActivity.this,
              CustomerServiceActivity.class));
        }
      }
    }
  };

  private void mensagemAdicional() {
    //Informando as mensagens adicionais
    DialogHelper.showQuestionMessage(InvoiceFinishActivity.this, R.string.confirmar_text,
        R.string.pergunta_msg_adiconal, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {

            Intent intent = new Intent(InvoiceFinishActivity.this,
                AddMessageActivity.class);
            startActivityForResult(intent, REQUEST_MENSAGEM_ADICIONAL);

          }
        }, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            pedidoCliente();
          }
        });
  }

  private void pedidoCliente() {
    //Informando o pedido do cliente
    DialogHelper.showQuestionMessage(InvoiceFinishActivity.this, R.string.confirmar_text,
        R.string.informar_pedido_cliente,
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(InvoiceFinishActivity.this,
                CustomerOrderActivity.class);
            startActivityForResult(intent, REQUEST_PEDIDO_CLIENTE);
          }
        }, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            createInvoice("pedidoCliente");
          }
        });
  }

  private void perguntarPesquisa() {
    boolean canSearch = SearchHelper.self().podePesquisar(
        GLOBAL.self().getCustomer().getCdCustomer(), GLOBAL.self().getOperation().getOperationType());

    if (GLOBAL.self().getCustomerService() != null)
      canSearch = SearchHelper.self().podePesquisar(
          GLOBAL.self().getCustomerService().getCdCustomer(), GLOBAL.self().getOperation().getOperationType());

    if (canSearch) {

      DialogHelper.showQuestionMessage(this, R.string.confirmar_text,
          R.string.realizar_pesquisa, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              pesquisaSatifacao(false);
            }
          }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              pesquisaSatifacao(true);
            }
          });
    } else
      mensagemAdicional();
  }

  private void pesquisaSatifacao(final Boolean abortar) {

    //Apagando possível lixo na pesquisa
    SearchDao searchDao = DatabaseApp.self().getDatabase().searchDao();
    List<Search> searches = searchDao.find();
    searchDao.deleteAll(searches);

    Invoice fakeInvoice = Invoice.newInstance();
    //Simulando objeto invoice para que seja criada a pesquisa de satisfação
    fakeInvoice.setNumero(GLOBAL.self().getGeneral().getNumeroNotaSaida());
    fakeInvoice.setSerie(GLOBAL.self().getGeneral().getSerieNotaSaida());
    fakeInvoice.setCdCustomer(GLOBAL.self().getCustomer().getCdCustomer());

    if (GLOBAL.self().getCustomerService() != null)
      fakeInvoice.setCdCustomerService(GLOBAL.self().getCustomerService().getCdCustomer());

    DialogHelper.showBeginSearchDialog(InvoiceFinishActivity.this, fakeInvoice,
        new MyCallbackInterface.CallbackSearchInterface() {
          @Override
          public void execute(Search search) {
            if (!abortar) {
              Intent it = new Intent(InvoiceFinishActivity.this, SearchActivity.class);
              it.putExtra("search", search);
              startActivityForResult(it, REQUEST_PESQUISA);
            } else
              mensagemAdicional();
          }
        }, new MyCallbackInterface.CallbackSearchInterface() {
          @Override
          public void execute(Search search) {
            mensagemAdicional();
          }
        }, abortar);
//    } else
//      mensagemAdicional();
  }

  private void pagamentoCartao() {

    if (valorCredito > 0 || valorDebito > 0) {
      PaymentDao paymentDao = DatabaseApp.self().getDatabase().paymentDao();
      List<Payment> payments = paymentDao.find();
      paymentDao.deleteAll(payments);

      Intent it = new Intent(this, PaymentCardActivity.class);
      it.putExtra("valorCredito", valorCredito);
      it.putExtra("valorDebito", valorDebito);
      startActivityForResult(it, REQUEST_PAGTO_CARTAO);
    } else
      perguntarPesquisa();
  }

  private void createInvoice(String origem) {
    try {
      LogHelper.self().info(TAG, "Origem: " + origem);

      //Buscando nota não finalizada na tentativa de proteger erro ocorrido quando cria 2 notas iguais
      List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao()
          .find(StepEmissaoType.FINALIZAR.getValue());

      if (!invoices.isEmpty()) {
        String stepName = StepEmissaoType.getByValue(invoices.get(0).getStepEmissao()).getName();

        LogHelper.self().info("NOTA NÃO FINALIZADA ENCONTRADA " + invoices.get(0).toString()
            + " " + stepName);

        DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.erro_inesperado,
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
                System.exit(0);
              }
            });
      } else {
        invoice = InvoiceHelper.self()
            .setActivity(InvoiceFinishActivity.this)
            .create(GLOBAL.self().getOperation(),
                GLOBAL.self().getCustomer(),
                GLOBAL.self().getPrices(),
                GLOBAL.self().getPreOrder(),
                GLOBAL.self().getCustomerService());

        if (invoice != null)
          sendAndConsult(invoice);
        else {
          DialogHelper.showErrorMessage(this, R.string.erro_text,
              R.string.create_invoice_error, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  UtilHelper.setButtonStatus(InvoiceFinishActivity.this, finishOrder, true);
                }
              });
        }
      }
    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
    }
  }

  private void sendAndConsult(final Invoice invoice) {

    long timeout = UtilHelper.convertToLongDef(XmlConfig.self().getTimeOut1(), 0) * 1000;

    new SendInvoiceTimer(this, timeout, 1000)
        .setInvoice(invoice)
        .start();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_MENSAGEM_ADICIONAL)
      pedidoCliente();
    else if (requestCode == REQUEST_PESQUISA)
      mensagemAdicional();
    else if (requestCode == REQUEST_PAGTO_CARTAO)
      perguntarPesquisa();
    else if (requestCode == REQUEST_PEDIDO_CLIENTE)
      createInvoice("onActivityResult");
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_invoice_finish);

    totalPedido = UtilHelper.formatDouble(GLOBAL.self().getTotalPedido(), 2);

    finishOrder = findViewById(R.id.btnConfirmarFimPedido);
    finishOrder.setOnClickListener(finishOrderClickListener);

    tvTotalPedidoFim = findViewById(R.id.tvTotalPedidoFim);
    edtDinheiroFim = findViewById(R.id.edtDinheiroFim);
    edtTrocoFim = findViewById(R.id.edtTrocoFim);
    edtChequeFim = findViewById(R.id.edtChequeFim);
    edtNumChequeFim = findViewById(R.id.edtNumChequeFim);
    edtDebitoFim = findViewById(R.id.edtDebitoFim);
    edtCreditoFim = findViewById(R.id.edtCreditoFim);
    edtFaturaFim = findViewById(R.id.edtFaturaFim);
    edtClientePrazo = findViewById(R.id.edtClientePrazo);

    edtDinheiroFim.setText(R.string.zero);
    edtTrocoFim.setText(R.string.zero);
    edtChequeFim.setText(R.string.zero);
    edtDebitoFim.setText(R.string.zero);
    edtCreditoFim.setText(R.string.zero);
    edtFaturaFim.setText(R.string.zero);

    if (!GLOBAL.self().getOperation().getOperationType().equals(OperationType.CPL))
      tvTotalPedidoFim.setText(String.format(Locale.getDefault(),
          "%s %s", getString(R.string.total_order), UtilHelper.formatDoubleString(totalPedido, 2)));

    if (!GLOBAL.self().getOperation().isFinalizaPedido()) {
      if (!GLOBAL.self().getOperation().getOperationType().equals(OperationType.CPL))
        edtFaturaFim.setText(UtilHelper.formatDoubleString(totalPedido, 2));

      finishOrderClickListener.onClick(finishOrder);
    } else {
      //Para clientes com condição de pagamento faturado, o valor vai direto no campo vl fatura
      Tax tax = DatabaseApp.self().getDatabase().taxDao().find(GLOBAL.self().getPrices().get(0).getCondicaoPagamento());
      if (tax != null && tax.getIndCondPagto().equalsIgnoreCase(ConstantsEnum.NO.getValue())) {
        faturado = true;
        edtFaturaFim.setText(UtilHelper.formatDoubleString(GLOBAL.self().getTotalPedido(),
            2));
        edtClientePrazo.setVisibility(View.VISIBLE);
      } else {
        faturado = false;
        edtClientePrazo.setVisibility(View.INVISIBLE);

        if (GLOBAL.self().getCustomer().getCdCustomer().toString().length() == 4) {
          edtFaturaFim.setText(R.string.zero);
          edtDinheiroFim.setText(UtilHelper.formatDoubleString(totalPedido, 2));

        }
      }
    }

    edtDinheiroFim.addTextChangedListener(new MoneyTextWatcherHelper(edtDinheiroFim, 2));
    edtChequeFim.addTextChangedListener(new MoneyTextWatcherHelper(edtChequeFim, 2));
    edtDebitoFim.addTextChangedListener(new MoneyTextWatcherHelper(edtDebitoFim, 2));
    edtCreditoFim.addTextChangedListener(new MoneyTextWatcherHelper(edtCreditoFim, 2));

    edtDinheiroFim.setOnFocusChangeListener(onFocusChangeListener);
    edtChequeFim.setOnFocusChangeListener(onFocusChangeListener);
    edtDebitoFim.setOnFocusChangeListener(onFocusChangeListener);
    edtCreditoFim.setOnFocusChangeListener(onFocusChangeListener);

    edtDinheiroFim.addTextChangedListener(new TextWtc());
    edtChequeFim.addTextChangedListener(new TextWtc());
    edtDebitoFim.addTextChangedListener(new TextWtc());
    edtCreditoFim.addTextChangedListener(new TextWtc());


    if (GLOBAL.self().getCustomer() != null) {
      edtChequeFim.setEnabled(ConstantsEnum.YES.getValue().equals(GLOBAL.self().getCustomer().getPermitirCheque()));
      edtNumChequeFim.setEnabled(edtChequeFim.isEnabled());
      if (ConstantsEnum.NO.getValue().equals(GLOBAL.self().getCustomer().getPermitirFatura())) {
        edtFaturaFim.setText(R.string.zero);
        edtClientePrazo.setVisibility(View.INVISIBLE);
      }
    }

    edtClientePrazo.setVisibility(View.INVISIBLE);

    View scroll = findViewById(R.id.scroll);
    addScreenClickHideKeyboard(scroll);
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    edtFaturaFim.setEnabled(false);

    View scroll = findViewById(R.id.scroll);
    scroll.requestFocus();
    edtDinheiroFim.setEnabled(true);

    UtilHelper.hideKeyboardFrom(this, getCurrentFocus());

    TextView tvTotalPedidoFim = findViewById(R.id.tvTotalPedidoFim);
    tvTotalPedidoFim.requestFocus();

  }

  private void setEditValues() {
    edtTrocoFim.setText(R.string.zero);

    Double totalNF = totalPedido;
    Double dinheiro = UtilHelper.formatDouble(edtDinheiroFim.getText().toString(), 2);
    Double cheque = UtilHelper.formatDouble(edtChequeFim.getText().toString(), 2);
    Double credito = UtilHelper.formatDouble(edtCreditoFim.getText().toString(), 2);
    Double debito = UtilHelper.formatDouble(edtDebitoFim.getText().toString(), 2);
    Double fatura = 0D;//UtilHelper.formatDouble(edtFaturaFim.getText().toString(), 2);

    Double diferenca = totalNF - dinheiro - cheque - credito - debito;
    fatura = diferenca;

    if (fatura < 0)
      fatura = 0D;

    if (ConstantsEnum.NO.getValue().equals(GLOBAL.self().getCustomer().getPermitirFatura()))
      fatura = 0D;

    diferenca = Math.abs(diferenca);

    if ((totalNF < dinheiro + cheque + credito + debito) && (diferenca < dinheiro))
      edtTrocoFim.setText(UtilHelper.formatDoubleString(diferenca, 2));

    if (faturado)
      edtFaturaFim.setText(UtilHelper.formatDoubleString(fatura, 2));
  }

  private class TextWtc implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
      setEditValues();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
  }

}
