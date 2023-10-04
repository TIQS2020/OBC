package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.FinishTripType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.global.TRIP;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Payment;
import br.com.whitemartins.obc.print.PrintReports;
import br.com.whitemartins.obc.print.ReportCharge;
import br.com.whitemartins.obc.print.ReportCount;
import br.com.whitemartins.obc.print.ReportCountHc;
import br.com.whitemartins.obc.print.ReportInvoices;
import br.com.whitemartins.obc.print.ReportMovementConsumable;
import br.com.whitemartins.obc.print.ReportMovementEquipment;
import br.com.whitemartins.obc.print.ReportMovementHc;
import br.com.whitemartins.obc.print.ReportPaymentCard;
import br.com.whitemartins.obc.print.ReportVolumeInformation;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.BluetoohHelper;
import br.com.whitemartins.obc.util.DialogHelper;

public class ReportActivity extends BaseActivity {

  final int REQUEST_FOR_PAIR_CODE = 1;
  private String parcial = "";
  private Boolean finishingTravel = false;
  private Switch swtNota, swtContagemHC, swtVolumeDescarregado, swtContgem, swtMovimentacaoHC,
    swtSimiplesHC, swtSituacao;
  private MyCallbackInterface.CallbackBooleanInterface notifyFinish = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      if (success) {
        if (finishingTravel)
          TRIP.self()
            //.setActivity(ReportActivity.this)
            .finish(FinishTripType.APAGAR_BASE);

        finish();
      } else {
        DialogHelper.showQuestionMessage(ReportActivity.this,
          getString(R.string.confirmar_text),
          String.format(getString(R.string.send_data_printer_fail), getString(R.string.relatorio)),
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              print();
            }
          }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              if (finishingTravel)
                TRIP.self()
                  //.setActivity(ReportActivity.this)
                  .finish(FinishTripType.APAGAR_BASE);

              finish();
            }
          });
      }
    }
  };

  private View.OnClickListener confirmarClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      if (GLOBAL.self().getStaticTable().getMacAddress().isEmpty())
        DialogHelper.showErrorMessage(ReportActivity.this, R.string.erro_text, R.string.pair_info,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              Intent intent = new Intent(ReportActivity.this, PrinterDiscoverActivity.class);
              startActivityForResult(intent, REQUEST_FOR_PAIR_CODE);
            }
          });
      else
        print();
    }
  };

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

    if (resultCode == CommonStatusCodes.SUCCESS)
      if (requestCode == REQUEST_FOR_PAIR_CODE)
        print();

    super.onActivityResult(requestCode, resultCode, data);
  }

  private void print() {
    DialogHelper.showInformationMessage(this, R.string.informar_text, R.string.prepare_print_2,
      new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          BluetoohHelper.self()
            .setActivity(ReportActivity.this)
            .enable();

          boolean ok =
            swtNota.isChecked()
              || swtContagemHC.isChecked()
              || swtContgem.isChecked()
              || swtVolumeDescarregado.isChecked()
              || swtSimiplesHC.isChecked()
              || swtMovimentacaoHC.isChecked()
              || swtSituacao.isChecked();

          if (ok) {

            PrintReports printReports = new PrintReports(ReportActivity.this);

            if (swtNota.isChecked()) {
              printReports.addReport(new ReportInvoices().setParcial(parcial));
              List<Payment> payments = DatabaseApp.self().getDatabase().paymentDao().getAll();

              if (!payments.isEmpty())
                printReports.addReport(new ReportPaymentCard().setParcial(parcial));
            }
            if (swtContagemHC.isChecked())
              printReports.addReport(new ReportCountHc().setParcial(parcial));
            if (swtContgem.isChecked())
              printReports.addReport(new ReportCount().setParcial(parcial));
            if (swtVolumeDescarregado.isChecked())
              printReports.addReport(new ReportVolumeInformation().setParcial(parcial));
            if (swtMovimentacaoHC.isChecked())
              printReports.addReport(new ReportMovementHc().setParcial(parcial));
            if (swtSimiplesHC.isChecked()) {
              printReports.addReport(new ReportMovementConsumable().setParcial(parcial));
              printReports.addReport(new ReportMovementEquipment().setParcial(parcial));
            }
            if (swtSituacao.isChecked())
              printReports.addReport(new ReportCharge().setParcial(parcial));

            printReports
              .setNotifyFinish(notifyFinish)
              .execute();
          } else
            DialogHelper.showInformationMessage(ReportActivity.this, R.string.informar_text,
              R.string.select_report, null);
        }
      });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    if (!finishingTravel)
      getMenuInflater().inflate(R.menu.menu_app, menu);

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    ActivityHelper.events(this, item);
    return true;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_report);

    swtNota = findViewById(R.id.swtNota);
    swtContagemHC = findViewById(R.id.swtContagemHC);
    swtContgem = findViewById(R.id.swtContgem);
    swtMovimentacaoHC = findViewById(R.id.swtMovimentacaoHC);
    swtSimiplesHC = findViewById(R.id.swtSimiplesHC);
    swtSituacao = findViewById(R.id.swtSituacao);
    swtVolumeDescarregado = findViewById(R.id.swtVolumeDescarregado);

    swtVolumeDescarregado.setVisibility(View.GONE);

    swtContgem.setEnabled(!GLOBAL.self().isLiquido());
    swtSituacao.setEnabled(GLOBAL.self().isPackeged());
    swtContagemHC.setEnabled(GLOBAL.self().isHomecare());
    swtMovimentacaoHC.setEnabled(GLOBAL.self().isHomecare());
    swtSimiplesHC.setEnabled(GLOBAL.self().isHomecare());

    ImageButton btnConfirmarReport = findViewById(R.id.btnConfirmarReport);
    btnConfirmarReport.setOnClickListener(confirmarClickListener);

    finishingTravel = getIntent().getExtras().getBoolean("finishingTravel", false);
    parcial = getIntent().getExtras().getString("parcial", "");
  }

}
