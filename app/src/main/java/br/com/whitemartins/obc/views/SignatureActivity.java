package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.CecType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.PrintStatusType;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.print.PrintCEC;
import br.com.whitemartins.obc.print.PrintREC;
import br.com.whitemartins.obc.util.CanvasView;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.ImageHelper;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class SignatureActivity extends BaseActivity {
  private static final int REQUEST_FOR_PAIR_CODE = 1;

  Invoice invoice;
  Bitmap bitmap;
  int tentativas = 1;
  private EditText txtNome, txtRG;
  private CanvasView canvasView;
  ImageButton confirmSignature;

  private View.OnClickListener btnLimparClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      canvasView.clearCanvas();
    }
  };

  private MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback =
    new MyCallbackInterface.CallbackBooleanInterface() {

      @Override
      public void execute(Boolean success) {

        try {
          //Finalinzando o step de emissão da nota
          invoice.setStepEmissao(StepEmissaoType.FINALIZAR.getValue());
          invoice.setStatusImpressaoCec(PrintStatusType.NAO_IMPRESSO.getValue());
          invoice.save();

          //Adicionando nota na lista para que e thread possa enviar
          if (!invoice.isFinalStatus())
            GLOBAL.self().getInvoiceBackgroundService().addInvoiceToList(invoice);

          if (success) {
            invoice.setStatusImpressaoCec(PrintStatusType.IMPRESSO.getValue());
            invoice.save();

            if (tentativas <= 2)
              confirmar();
            else {
              GLOBAL.self().getPrices().clear();

              if (GLOBAL.self().isAutomaticSend() || GLOBAL.self().getInvoice() != null)
                startActivity(new Intent(SignatureActivity.this,
                  CustomerServiceActivity.class));
              else if (!InvoiceHelper.self().setActivity(SignatureActivity.this).showLostInvoices(false))
                startActivity(new Intent(SignatureActivity.this,
                  OperationsActivity.class));

              finish();
            }
          } else {

            boolean aVista = invoice.getValorFatura() == 0;

            DialogHelper.showQuestionMessage(SignatureActivity.this,
              getString(R.string.confirmar_text),
              String.format(getString(R.string.send_data_printer_fail),
                GLOBAL.self().getCecDanfe(GLOBAL.self().getOperation(), aVista).getName()),
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  tentativas--;
                  print();
                }
              }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  if (GLOBAL.self().isAutomaticSend() || GLOBAL.self().getInvoice() != null)
                    startActivity(new Intent(SignatureActivity.this,
                      CustomerServiceActivity.class));
                  else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.TRF))
                    startActivity(new Intent(SignatureActivity.this,
                      TransferActivity.class));
                  else
                    startActivity(new Intent(SignatureActivity.this,
                      OperationsActivity.class));

                  finish();
                }
              }
            );
          }
        } catch (Exception e) {
          LogHelper.self().error(TAG, e);
          e.printStackTrace();
        }
      }
    };

  private View.OnClickListener confirmSignatureClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      preConfirmar();
    }
  };

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

    if (requestCode == REQUEST_FOR_PAIR_CODE)
      print();

    super.onActivityResult(requestCode, resultCode, data);
  }

  private void preConfirmar() {
    SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());
    CecType cecType = GLOBAL.self().getCecDanfe(operation, false);
    final String m = cecType.getName().toUpperCase();

    if (txtNome.getText().toString().trim().isEmpty() || txtRG.getText().toString().trim().isEmpty()) {
      DialogHelper.showErrorMessage(SignatureActivity.this, R.string.erro_text,
        R.string.informar_nome_rg_assinatura, null);
    } else if (!canvasView.isSigned())
      DialogHelper.showQuestionMessage(SignatureActivity.this, getString(R.string.confirmar_text),
        String.format(Locale.getDefault(), getString(R.string.no_signature), m),
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            confirmar();
          }
        }, null);
    else
      confirmar();
  }

  private void confirmar() {

    GLOBAL.self().setPedidoRealizado(true);

    SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());
    CecType cecType = GLOBAL.self().getCecDanfe(operation, false);
    final String m = cecType.getName().toUpperCase();

    DialogHelper.showInformationMessage(SignatureActivity.this,
      getString(R.string.informar_text),
      String.format(getString(R.string.prepare_print), tentativas, m),
      new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

          if (GLOBAL.self().getStaticTable().getMacAddress().isEmpty())
            DialogHelper.showErrorMessage(SignatureActivity.this, R.string.erro_text,
              R.string.pair_info,
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  Intent intent = new Intent(SignatureActivity.this,
                    PrinterDiscoverActivity.class);
                  startActivityForResult(intent, REQUEST_FOR_PAIR_CODE);
                }
              });
          else
            print();
        }
      });
  }

  private void print() {
    try {
      tentativas++;

      SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());
      CecType cecType = GLOBAL.self().getCecDanfe(operation, false);
      String m = cecType.getName().toUpperCase();

      LogHelper.self().info(TAG, "Salvando nome/RG na nota.");

      invoice.setNomeAssinadorCec(txtNome.getText().toString());
      invoice.setRgAssinadorCec(txtRG.getText().toString());
      invoice.setStepEmissao(StepEmissaoType.IMPRIMIR.getValue());
      invoice.save();

      LogHelper.self().info(TAG, "Nome/RG salvos na nota.");

      LogHelper.self().info(TAG, "Salvando a assinatura.");
      //Gerando imagem da assinatura
      if (!canvasView.isSigned()) {
        Bitmap bitmap = ImageHelper.self().doTextSignature(
          "CLIENTE NÃO CONCORDOU\nEM ASSINAR O " + m,
          canvasView.getmBitmap().getWidth(), canvasView.getmBitmap().getHeight());

        ImageHelper.self().saveBitmap(invoice, bitmap, false);
      } else
        ImageHelper.self().saveBitmap(invoice, canvasView.getmBitmap(), false);

      LogHelper.self().info(TAG, "Assinatura salva no disco.");

      bitmap = BitmapFactory.decodeFile(UtilHelper.getSignFileName(invoice));

      PrintCEC pCEC;

      if (SuperOperation.getOperation(invoice.getTipoTransacao()).getOperationType()
        .equals(OperationType.RPS))
        pCEC = new PrintREC(SignatureActivity.this);
      else
        pCEC = new PrintCEC(SignatureActivity.this);

      pCEC.setInvoice(invoice)
        .setFinishExecuteCallback(finishExecuteCallback)
        .setReprint(false)
        .setSignature(bitmap)
        .execute();

    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signature);

    canvasView = findViewById(R.id.canvas);
    txtNome = findViewById(R.id.edtNomeAssinatura);
    txtRG = findViewById(R.id.edtRGAssinatura);

    canvasView.setActivity(this);
     confirmSignature = findViewById(R.id.btnConfimar);
    confirmSignature.setOnClickListener(confirmSignatureClickListener);

    ImageButton btnLimpar = findViewById(R.id.btnLimpar);
    btnLimpar.setOnClickListener(btnLimparClickListener);

    invoice = (Invoice) getIntent().getSerializableExtra("invoice");

    View v = findViewById(R.id.screen);
    if (v != null)
      addScreenClickHideKeyboard(v);

    if (invoice != null)
      invoice.setItens(DatabaseApp.self().getDatabase().invoiceItemDao()
        .findByIdNota(invoice.getId()));
  }
}
