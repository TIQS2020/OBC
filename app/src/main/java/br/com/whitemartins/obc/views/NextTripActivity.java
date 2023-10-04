package br.com.whitemartins.obc.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.util.UtilHelper;

public class NextTripActivity extends AppCompatActivity {
  Travel travel = null;

  private View.OnClickListener listener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      Intent intent = new Intent(NextTripActivity.this, ConfirmTravelDataActivity.class);
      intent.putExtra("fimViagem", false);
      intent.putExtra("numeroViagem", travel.getNumeroViagem());
      intent.putExtra("dataViagem", UtilHelper.formatDateStr(travel.getDataViagem(),
        ConstantsEnum.ddMMyyyy_barra.getValue()));
      startActivity(intent);

      finish();
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_next_trip);

    travel = DatabaseApp.self().getDatabase().travelDao().findNext();
    List<Travel> travels = DatabaseApp.self().getDatabase().travelDao().getAll();

    TextView txtSeqNextTrip = findViewById(R.id.txtSeqNextTrip);

    String s = String.format(getString(R.string.sequencia), travel.getSequencia(), travels.size());

    txtSeqNextTrip.setText(s);
    TextView txtNumeroViagemNextTrip = findViewById(R.id.txtNumeroViagemNextTrip);

    s = String.format(getString(R.string.numero_viagem), travel.getNumeroViagem());
    txtNumeroViagemNextTrip.setText(s);

    ImageButton btnConfirmarNextTrip = findViewById(R.id.btnConfirmarNextTrip);
    btnConfirmarNextTrip.setOnClickListener(listener);
  }
}
