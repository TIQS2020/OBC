package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.AnswerDao;
import br.com.whitemartins.obc.dao.SearchDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.model.Answer;
import br.com.whitemartins.obc.model.Questions;
import br.com.whitemartins.obc.model.Search;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class SearchActivity extends BaseActivity {

  static final String TAG = "PagerActivity";
  List<Answer> answers = new ArrayList<>();
  RadioGroup radioGroup;
  ImageButton mNextBtn;
  ImageButton mSkipBtn, mFinishBtn;
  ImageView zero, one, two;
  ImageView[] indicators;
  List<Questions> questions = new ArrayList<>();
  CoordinatorLayout mCoordinator;
  Search search;
  TextView txtPergunta;
  int page = 0;   //  to track page position

  public void addOption(String resposta) {
    Answer answer = Answer.newInstance();
    answer.setIdPesquisa(search.getId());
    answer.setPergunrta(txtPergunta.getText().toString());
    answer.setResposta(resposta);
    answer.setCategorizada(resposta.length() > 1 ? ConstantsEnum.YES.getValue() : ConstantsEnum.NO.getValue());
    answers.add(answer);
  }

  public void removeOption(int idx) {
    if (answers.size() > 0)
      answers.remove(idx);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);

    radioGroup = findViewById(R.id.rdgRespostas);

    search = (Search) getIntent().getSerializableExtra("search");

    questions = DatabaseApp.self().getDatabase().questionsDao().getAll();

    mNextBtn = findViewById(R.id.intro_btn_next);
    mSkipBtn = findViewById(R.id.intro_btn_skip);
    mFinishBtn = findViewById(R.id.intro_btn_finish);

    zero = findViewById(R.id.intro_indicator_0);
    one = findViewById(R.id.intro_indicator_1);
    two = findViewById(R.id.intro_indicator_2);

    mCoordinator = findViewById(R.id.main_content);
    indicators = new ImageView[]{zero, one, two};

    updateIndicators(page);

    init(page);

    answers.clear();

    mNextBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Integer resposta = getChecked(radioGroup);

        if (resposta == -1)
          DialogHelper.showErrorMessage(SearchActivity.this, R.string.erro_text,
            R.string.selecionar_opcao_pesquisa, null);
        else {
          page += 1;

          if (page > questions.size())
            page = questions.size() - 1;

          addOption(resposta.toString());

          radioGroup.removeAllViewsInLayout();
          Integer t = totalizarPontos();

          if (t <= 6)
            init(page);

          if (answers.size() >= 2 && t > 6) {
            DialogHelper.showInformationMessage(SearchActivity.this, R.string.confirmar_text,
              R.string.finalizar_pesquisa, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  save();
                  finish();
                }
              });
          } else {
            updateIndicators(page);
          }
        }
      }
    });

    mSkipBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        page -= 1;
        if (page < 0)
          page = 0;

        init(page);
        removeOption(page);
        updateIndicators(page);
      }
    });

    mFinishBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String resposta = getMultIdChecked(radioGroup);
        addOption(resposta);

        DialogHelper.showInformationMessage(SearchActivity.this, R.string.confirmar_text,
          R.string.finalizar_pesquisa, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              save();
              finish();
            }
          });
      }
    });
  }

  private void save() {
    Long id = 0L;
    for (Answer answer : answers) {
      answer.setIdPesquisa(search.getId());
      answer.setId(++id);
      answer.save();
    }
  }

  private String getMultIdChecked(RadioGroup radioGroup) {

    StringBuilder resposta = new StringBuilder();

    for (int i = 0; i < radioGroup.getChildCount(); i++) {
      CheckBox button = (CheckBox) radioGroup.getChildAt(i);

      if (button.isChecked())
        resposta.append(String.valueOf(i + 1));
//      else
//        resposta.append(ConstantsEnum.NO.getValue());
    }

    return resposta.toString();
  }

  private Integer getChecked(RadioGroup radioGroup) {

    for (int i = 0; i < radioGroup.getChildCount(); i++) {
      RadioButton button = (RadioButton) radioGroup.getChildAt(i);
      if (button.isChecked()) {
        return (Integer) button.getTag();
      }
    }

    return -1;
  }

  private Integer totalizarPontos() {
    Integer total = 0;

    for (Answer answer : answers)
      total += UtilHelper.convertToIntegerDef(answer.getResposta(), 0);

    return total;
  }

  void updateIndicators(int position) {
    for (int i = 0; i < indicators.length; i++) {
      indicators[i].setBackgroundResource(
        i == position ? R.drawable.indicator_selected : R.drawable.indicator_unselected
      );

      mNextBtn.setVisibility(position == questions.size() - 1 ? View.GONE : View.VISIBLE);
      mFinishBtn.setVisibility(position == questions.size() - 1 ? View.VISIBLE : View.GONE);
    }
  }

  private RadioButton newRadioButton(View rootView, Integer tag, String text) {
    final RadioButton button = new RadioButton(rootView.getContext());
    button.setTag(tag);
    button.setText(String.format(Locale.getDefault(), "%d. %s", tag, text));
    button.setGravity(Gravity.START);
    button.setChecked(false);

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
      LinearLayout.LayoutParams.MATCH_PARENT,
      LinearLayout.LayoutParams.WRAP_CONTENT);

    button.setLayoutParams(params);
    button.setPadding(10, 10, 10, 10);
    return button;
  }

  private CheckBox newCheckbox(View rootView, Integer tag, String text) {
    CheckBox button = new CheckBox(rootView.getContext());
    button.setTag(tag);
    button.setText(String.format(Locale.getDefault(), "%d. %s", tag, text));
    button.setGravity(Gravity.START);
    button.setChecked(false);

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
      LinearLayout.LayoutParams.MATCH_PARENT,
      LinearLayout.LayoutParams.WRAP_CONTENT);

    button.setLayoutParams(params);
    button.setPadding(10, 10, 10, 10);

    return button;
  }

  private void init(int page) {

    List<Questions> questions = DatabaseApp.self().getDatabase().questionsDao().getAll();

    LinearLayout linearLayout = findViewById(R.id.layoutRespostas);

    if (linearLayout != null) {
      txtPergunta = findViewById(R.id.txtPerguntaPesquisa);

      radioGroup.removeAllViews();

      if (!questions.isEmpty()) {
        Questions question = questions.get(page);

        txtPergunta.setText(question.getPergunta());
        if (ConstantsEnum.NO.getValue().equalsIgnoreCase(question.getCategorizar())) {
          radioGroup.addView(newRadioButton(radioGroup, question.getNumeroResposta1(),
            question.getResposta1()));
          radioGroup.addView(newRadioButton(radioGroup, question.getNumeroResposta2(),
            question.getResposta2()));
          radioGroup.addView(newRadioButton(radioGroup, question.getNumeroResposta3(),
            question.getResposta3()));
          radioGroup.addView(newRadioButton(radioGroup, question.getNumeroResposta4(),
            question.getResposta4()));
          radioGroup.addView(newRadioButton(radioGroup, question.getNumeroResposta5(),
            question.getResposta5()));
        } else {
          radioGroup.addView(newCheckbox(radioGroup, question.getNumeroResposta1(),
            question.getResposta1()));
          radioGroup.addView(newCheckbox(radioGroup, question.getNumeroResposta2(),
            question.getResposta2()));
          radioGroup.addView(newCheckbox(radioGroup, question.getNumeroResposta3(),
            question.getResposta3()));
          radioGroup.addView(newCheckbox(radioGroup, question.getNumeroResposta4(),
            question.getResposta4()));
          radioGroup.addView(newCheckbox(radioGroup, question.getNumeroResposta5(),
            question.getResposta5()));
        }
      }
    }
  }
}
