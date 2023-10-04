package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.OptionType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.FileHelper;

public class DeleteBaseActivity extends BaseActivity {

  ProgressBar pbarFinishTrip;
  TextView txtStatusFinishTrip;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_finish_travel);

    pbarFinishTrip = findViewById(R.id.pbarFinishTrip);
    txtStatusFinishTrip = findViewById(R.id.txtStatusFinishTrip);
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    deleteTables();
  }

  private void deleteTables() {

    try {
      pbarFinishTrip.setVisibility(View.VISIBLE);
      FileHelper.self(this)
        .setPostExecuteCallback(new MyCallbackInterface.CallbackBooleanInterface() {
          @Override
          public void execute(Boolean success) {
            DialogHelper.showOkMessage(DeleteBaseActivity.this,
              R.string.informar_text, R.string.finish_travel_text,
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  startActivity(new Intent(DeleteBaseActivity.this,
                    LoadTravelActivity.class));
                }
              });
          }
        })
        .setOptionType(OptionType.APAGAR_BASE)
        .setProgressbar(pbarFinishTrip)
        .setTextProgress(txtStatusFinishTrip)
        .execute();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
