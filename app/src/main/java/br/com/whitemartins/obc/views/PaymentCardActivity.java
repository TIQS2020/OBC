package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.adapters.PaymentsAdapter;
import br.com.whitemartins.obc.dao.PaymentDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.PaymentModeType;
import br.com.whitemartins.obc.interafce.adapterListener;
import br.com.whitemartins.obc.model.Code;
import br.com.whitemartins.obc.model.Payment;
import br.com.whitemartins.obc.model.PaymentCard;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.MoneyTextWatcherHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class PaymentCardActivity extends BaseActivity {
  Double valorCredito, valorDebito, valorPendente;
  List<Code> codes;
  List<PaymentCard> paymentCards;
  List<Payment> payments = new ArrayList<>();
  ListView lstPayments;
  Spinner spnCredenciadora, spnBandeira;
  EditText edtAutorizacaoPagamentoCartao, edtValorPagoPagamentoCartao;
  TextView txtValorPedentePagamentoCartao, txtValorTotalPagamentoCartao;
  ImageButton btnConfirmarPagamentoCartao, btnFinalizarPagamentoCartao;

  Payment payment;
  PaymentsAdapter paymentsAdapter;
  PaymentModeType paymentModeTypeGlobal;
  int idxClicked = -1;

  PaymentDao paymentDao = DatabaseApp.self().getDatabase().paymentDao();

  private View.OnClickListener btnFinalizarListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      if (payments.isEmpty()) {
        DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.confirmar_text,
          R.string.no_payments, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
          });
      } else if (!getValorPendente().equals(0D)) {
        DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.confirmar_text,
          R.string.valor_total_invalido, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
          });
      } else
        DialogHelper.showQuestionMessage(PaymentCardActivity.this, R.string.confirmar_text,
          R.string.finalizar_pagamento, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              finalizar();
            }
          }, null);
    }
  };

  private View.OnClickListener btnConfirmarListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      if (validar()) {
        confirmar();

        idxClicked = -1;

        if (getValorPendente().equals(0D))
          btnFinalizarListener.onClick(view);
      }
    }
  };
  private adapterListener adpListener = new adapterListener() {
    @Override
    public void onBtnClick(int position) {

    }

    @Override
    public void onUpdateLabels() {
      clear(false);
    }
  };


  private AdapterView.OnItemClickListener listPaymentsItemClick = new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

      idxClicked = i;
      payment = payments.get(i);

      spnBandeira.setSelection(getSelectedSpinner(payment.getNomeBandeira(), spnBandeira));
      spnCredenciadora.setSelection(getSelectedSpinner(payment.getCredenciadora(), spnCredenciadora));
      edtAutorizacaoPagamentoCartao.setText(payment.getNumeroAutorizacao());
      edtValorPagoPagamentoCartao.setText(
        UtilHelper.formatDoubleString(payment.getValor(), 2));
    }
  };

  private int getSelectedSpinner(String value, Spinner spinner) {
    int ret = -1;
    for (int i = 0; i < spinner.getAdapter().getCount(); i++) {
      if (value.equalsIgnoreCase(spinner.getItemAtPosition(i).toString()))
        return i;
    }
    return ret;
  }


  private void confirmar() {

    PaymentCard paymentCard = paymentCards.get(spnCredenciadora.getSelectedItemPosition() - 1);
    Code code = codes.get(spnBandeira.getSelectedItemPosition() - 1);

    payment = Payment.newInstance();
    payment.setCredenciadora(paymentCard.getNomeEmpresa());
    payment.setCnpj(paymentCard.getCnpj());
    payment.setTipoIntegracao(paymentCard.getTipoIntegracao());
    payment.setBandeira(UtilHelper.padLeft(code.getCodigo().toString(), '0', 2));
    payment.setNomeBandeira(code.getDescricao());
    payment.setNumeroAutorizacao(edtAutorizacaoPagamentoCartao.getText().toString());
    payment.setValor(
      UtilHelper.convertToDoubleDef(edtValorPagoPagamentoCartao.getText().toString(), 0));
    payment.setModalidade(paymentModeTypeGlobal.getValue());

    if (idxClicked != -1) {
      payments.set(idxClicked, payment);
    } else
      payments.add(payment);

    paymentsAdapter.notifyDataSetChanged();
    idxClicked = -1;

    clear(false);
  }

  private void finalizar() {

//    if ((edtValorPagoPagamentoCartao.getText().toString().trim().length() > 0)
//      && (spnCredenciadora.getSelectedItemPosition() > 0)
//      && (spnBandeira.getSelectedItemPosition() > 0))

//    if (validar()) {
//      //confirmar();
    Double v = UtilHelper.formatDouble(edtValorPagoPagamentoCartao.getText().toString(), 2);

    if (!getValorPendente().equals(v)) {
      DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
        R.string.valor_total_invalido, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            clear(false);
          }
        });
    } else if (getValorPendente().equals(0D)) {

      if (v > 0) {
        DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
          R.string.valor_total_invalido, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              clear(false);
            }
          });

        return;
      }

      clear(false);

      if (payments.size() == 0) {
        DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
          R.string.erro_sem_pagamento, null);
      } else if (getValorPendente() > 0) {
        DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
          R.string.erro_valor_informado, null);
      } else if (paymentModeTypeGlobal.equals(PaymentModeType.CREDITO)) {
        if (salvar()) {
          internalInit(PaymentModeType.DEBITO);

          if (valorDebito <= 0)
            finish();
        }
      } else {
        if (salvar())
          finish();
      }
    } else {
      if (validar())
        clear(false);
    }
  }

  private boolean salvar() {
    try {
      Double sum = 0D, valor;

      if (paymentModeTypeGlobal.equals(PaymentModeType.CREDITO))
        valor = valorCredito;
      else
        valor = valorDebito;

      for (Payment payment : payments)
        sum += payment.getValor();

      sum = UtilHelper.formatDouble(sum, 2);
      valor = UtilHelper.formatDouble(valor, 2);

      if (!sum.equals(valor)) {
        DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.valor_total_invalido,
          null);

        return false;
      } else
        payments.forEach(payment -> payment.save());

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }


  private boolean validar() {

    boolean ret = true;

    Double valor = UtilHelper.formatDouble(edtValorPagoPagamentoCartao.getText().toString(), 2);

    if (spnCredenciadora.getSelectedItemPosition() == 0) {
      ret = false;
      DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
        R.string.selecionar_cred, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            spnCredenciadora.requestFocus();
          }
        });
    } else if (spnBandeira.getSelectedItemPosition() == 0) {
      ret = false;
      DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
        R.string.selecionar_band, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            spnBandeira.requestFocus();
          }
        });
    } else if (edtAutorizacaoPagamentoCartao.getText().toString().isEmpty()) {
      ret = false;
      DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
        R.string.informar_autorizacao, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            edtAutorizacaoPagamentoCartao.requestFocus();
          }
        });
    } else if (edtValorPagoPagamentoCartao.getText().toString().isEmpty()) {
      ret = false;
      DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
        R.string.informar_valor, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            edtValorPagoPagamentoCartao.requestFocus();
          }
        });
    } else if (valor <= 0) {
      ret = false;
      DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
        R.string.valor_total_invalido, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            edtValorPagoPagamentoCartao.requestFocus();
          }
        });
    } else if ((getValorPendente() - valor) < 0) {
      ret = false;
      DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
        R.string.valor_total_invalido, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            edtValorPagoPagamentoCartao.requestFocus();
          }
        });
    } else if (getValorPendente() < valor) {
      ret = false;
      DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
        R.string.valor_total_invalido, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            edtValorPagoPagamentoCartao.requestFocus();
          }
        });
    } else {
      Payment peyBuff = paymentDao.find(edtAutorizacaoPagamentoCartao.getText().toString());

      if (peyBuff != null) {
        ret = false;
        DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
          R.string.autorizacao_informada, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              edtAutorizacaoPagamentoCartao.requestFocus();
            }
          });
      }

      String numero = edtAutorizacaoPagamentoCartao.getText().toString();
      int i = findAutorizacaoInPayments(numero);

      if (idxClicked != i && i != -1) {
        ret = false;
        DialogHelper.showErrorMessage(PaymentCardActivity.this, R.string.erro_text,
          R.string.autorizacao_informada, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              edtAutorizacaoPagamentoCartao.requestFocus();
            }
          });
      }
    }

    return ret;
  }

  private Double getValorPendente() {
    Double valor, total = 0D;
    List<Payment> pags = payments;

    if (paymentModeTypeGlobal.equals(PaymentModeType.CREDITO))
      valor = valorCredito;
    else
      valor = valorDebito;

    Double valorSelecionado = 0D;

    if (idxClicked != -1 && !payments.isEmpty())
      valorSelecionado = (payments.get(idxClicked).getValor());

    for (Payment pay : pags)
      total += pay.getValor();

    total -= valorSelecionado;

    return UtilHelper.formatDouble(valor - total, 2);
  }

  private void clear(boolean clearItems) {
    spnBandeira.setSelection(0);
    spnCredenciadora.setSelection(0);
    edtAutorizacaoPagamentoCartao.setText("");
    edtValorPagoPagamentoCartao.setText("");

    if (clearItems) {
      payments.clear();
      if (paymentsAdapter != null)
        paymentsAdapter.notifyDataSetChanged();
    }

    payment = null;

    Double valorPendente = getValorPendente();

    txtValorPedentePagamentoCartao.setText(String.format(getString(R.string.valor_pendente),
      UtilHelper.formatDoubleString(valorPendente, 2)));
    edtValorPagoPagamentoCartao.setText(UtilHelper.formatDoubleString(valorPendente, 2));
  }

  private Integer findAutorizacaoInPayments(String numero) {

    for (int i = 0; i < payments.size(); i++) {
      Payment p = payments.get(i);
      if (p.getNumeroAutorizacao().equalsIgnoreCase(numero)) {
        return i;
      }
    }

    return -1;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_payment_card);

    valorCredito = getIntent().getDoubleExtra("valorCredito", 0D);
    valorDebito = getIntent().getDoubleExtra("valorDebito", 0D);

    spnCredenciadora = findViewById(R.id.spnCredenciadora);
    spnBandeira = findViewById(R.id.spnBandeira);
    edtAutorizacaoPagamentoCartao = findViewById(R.id.edtAutorizacaoPagamentoCartao);
    edtValorPagoPagamentoCartao = findViewById(R.id.edtValorPagoPagamentoCartao);
    txtValorTotalPagamentoCartao = findViewById(R.id.txtValorTotalPagamentoCartao);
    txtValorPedentePagamentoCartao = findViewById(R.id.txtValorPedentePagamentoCartao);

    btnConfirmarPagamentoCartao = findViewById(R.id.btnConfirmarPagamentoCartao);
    btnFinalizarPagamentoCartao = findViewById(R.id.btnFinalizarPagamentoCartao);

    btnConfirmarPagamentoCartao.setOnClickListener(btnConfirmarListener);
    btnFinalizarPagamentoCartao.setOnClickListener(btnFinalizarListener);
    lstPayments = findViewById(R.id.lstPayments);

    codes = DatabaseApp.self().getDatabase().codeDao().find(ConstantsEnum.Y.getValue());
    List<String> bandeiras = new ArrayList<>();
    bandeiras.add(getString(R.string.selecionar_band));

    for (Code code : codes)
      bandeiras.add(code.getDescricao());

    ArrayAdapter<String> bandeiraAdapter = new ArrayAdapter<String>(this,
      android.R.layout.test_list_item, bandeiras);

    spnBandeira.setAdapter(bandeiraAdapter);

    paymentCards = DatabaseApp.self().getDatabase().payCardDao().getAll();
    List<String> credenciadoras = new ArrayList<>();
    credenciadoras.add(getString(R.string.selecionar_cred));

    for (PaymentCard paymentCard : paymentCards)
      credenciadoras.add(paymentCard.getNomeEmpresa());

    ArrayAdapter<String> credenciadoraAdapter = new ArrayAdapter<>(this,
      android.R.layout.test_list_item, credenciadoras);

    spnCredenciadora.setAdapter(credenciadoraAdapter);

    if (valorCredito > 0)
      internalInit(PaymentModeType.CREDITO);
    else
      internalInit(PaymentModeType.DEBITO);

    paymentsAdapter = new PaymentsAdapter(PaymentCardActivity.this, payments, adpListener);
    lstPayments.setAdapter(paymentsAdapter);
    lstPayments.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    lstPayments.setOnItemClickListener(listPaymentsItemClick);

    edtValorPagoPagamentoCartao.addTextChangedListener(new MoneyTextWatcherHelper(edtValorPagoPagamentoCartao, 2));
  }

  private void internalInit(PaymentModeType paymentModeType) {
    paymentModeTypeGlobal = paymentModeType;

    clear(true);

    if (PaymentModeType.CREDITO.equals(paymentModeType)) {
      txtValorTotalPagamentoCartao.setText(String.format(getString(R.string.valor_cartao_credito),
        UtilHelper.formatDoubleString(valorCredito, 2)));
      valorPendente = valorCredito;
    } else if (PaymentModeType.DEBITO.equals(paymentModeType)) {
      txtValorTotalPagamentoCartao.setText(String.format(getString(R.string.valor_cartao_debito),
        UtilHelper.formatDoubleString(valorDebito, 2)));
      valorPendente = valorDebito;
    }
    txtValorPedentePagamentoCartao.setText(String.format(getString(R.string.valor_pendente),
      UtilHelper.formatDoubleString(valorPendente, 2)));

    edtValorPagoPagamentoCartao.setText(UtilHelper.formatDoubleString(valorPendente, 2));
  }

}
