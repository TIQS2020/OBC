package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.FinishTripType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.global.TRIP;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.InvoiceImage;
import br.com.whitemartins.obc.service.ImageService;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class InvoiceImagePendentActivity extends BaseActivity {

  TextView txtTituloInvoicePendent, txtStatus;
  List<InvoiceImage> invoiceImages = new ArrayList<>();
  ListView lstInvoicePendent;
  ArrayAdapter<InvoiceImage> adapter;
  ProgressBar progressBar;
  ImageButton btnConfirmarInvoicePendent;
  List<InvoiceImage> invoicesErrors = new ArrayList<>();

  int idx = -1;
//  int totalInvoices = 0;

  private DialogInterface.OnClickListener positiveClickListener = new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
      finish();
    }
  };

  private MyCallbackInterface.CallbackBooleanInterface finishCallback =
    new MyCallbackInterface.CallbackBooleanInterface() {
      @Override
      public void execute(Boolean success) {

        ++idx;

        progressBar.setProgress(progressBar.getProgress() + 1, false);
        adapter.notifyDataSetChanged();

        if (success) {
          if (idx + 1 == invoiceImages.size()) {

            if (invoicesErrors.isEmpty()) {
              TRIP.self()
                .setWeakReference(GLOBAL.self().getGlobalActivity())
                .finish(FinishTripType.GERAR_ARQUIVOS);
              finish();
            } else {
              DialogHelper.showErrorMessage(InvoiceImagePendentActivity.this, R.string.erro_text,
                R.string.erro_enviar_cecs, positiveClickListener);
            }
          }
        } else {
          if (idx <= invoiceImages.size())
            invoicesErrors.add(invoiceImages.get(idx));

          if (idx + 1 == invoiceImages.size())
            DialogHelper.showErrorMessage(InvoiceImagePendentActivity.this, R.string.erro_text,
              R.string.erro_enviar_cecs, positiveClickListener);
        }
      }
    };

  private View.OnClickListener btnConfirmarListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {
      UtilHelper.setButtonStatus(InvoiceImagePendentActivity.this,
        btnConfirmarInvoicePendent, false);

      //sendAndConsult(invoiceImages, true);
    }
  };

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    sendAndConsult(invoiceImages, true);
    UtilHelper.hideKeyboardFrom(this, getCurrentFocus());

    super.onPostCreate(savedInstanceState);
  }

  private void getInvoices() {
    invoiceImages = DatabaseApp.self().getDatabase().invoiceImageDao().find(StatusNFeType.build(
      StatusNFeType.PENDENTE_ENVIO, StatusNFeType.PROCESSANDO));

//    invoiceImages = DatabaseApp.self().getDatabase().invoiceImageDao().getAll();

    invoiceImages.forEach(invoiceImage -> {
      invoiceImage.setStatus(StatusNFeType.PENDENTE_ENVIO.getValue());
      invoiceImage.save();
    });
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_image_pendent);

    //Limpando a lista da thread para que não haja concorrencia
    GLOBAL.self().getInvoiceImageBackgroundService().clearImageList();

    txtTituloInvoicePendent = findViewById(R.id.txtTituloInvoicePendent);
    lstInvoicePendent = findViewById(R.id.lstInvoicePendent);
    progressBar = findViewById(R.id.pbarSendInvoice);
    txtStatus = findViewById(R.id.txtStatus);

    btnConfirmarInvoicePendent = findViewById(R.id.btnConfirmarInvoicePendent);
    btnConfirmarInvoicePendent.setOnClickListener(btnConfirmarListener);
    btnConfirmarInvoicePendent.setVisibility(View.GONE);

    String msg = String.format("%s%s",
      UtilHelper.padRight(getString(R.string.nota), ' ', 6),
      getString(R.string.status_));

    txtTituloInvoicePendent.setText(msg);

    getInvoices();

    progressBar.setMax(invoiceImages.size());
    adapter = new ArrayAdapter<>(this, android.R.layout.test_list_item, invoiceImages);
    lstInvoicePendent.setAdapter(adapter);
  }

  private void sendAndConsult(List<InvoiceImage> images, boolean zerar) {
    invoicesErrors.clear();

    adapter = new ArrayAdapter<>(this, android.R.layout.test_list_item, images);
    lstInvoicePendent.setAdapter(adapter);
    adapter.notifyDataSetChanged();

    for (InvoiceImage invoiceImage : images) {

      LogHelper.self().info(TAG, "CEC INICIADO: " + invoiceImage.toString());

      //Não enviar CECs com a assinatura nula ou branca
      new ImageService()
        .setInvoiceImage(invoiceImage)
        .setFinishExecuteCallback(finishCallback)
        .setTxtStatus(txtStatus)
        .setActivity(this).execute();

      LogHelper.self().info("CEC FINALIZADO: " + invoiceImage.toString());
    }
  }
}
