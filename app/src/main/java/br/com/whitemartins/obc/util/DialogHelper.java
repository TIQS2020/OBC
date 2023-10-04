package br.com.whitemartins.obc.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.ikovac.timepickerwithseconds.MyTimePickerDialog;
import com.ikovac.timepickerwithseconds.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.BuildConfig;
import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Code;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Daily;
import br.com.whitemartins.obc.model.Excepty;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.Patient;
import br.com.whitemartins.obc.model.Search;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.views.DatabaseApp;

public class DialogHelper {

  public static void showOkMessage(Context context, String title, String message,
                                   DialogInterface.OnClickListener positiveButtonListener) {

    new AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setIcon(R.drawable.ic_ok_color)
        .setCancelable(false)
        .setPositiveButton(android.R.string.ok, positiveButtonListener)
        .show();
  }

  public static void showOkMessage(Context context, int idTitle, int idMessage,
                                   DialogInterface.OnClickListener positiveButtonListener) {

    showOkMessage(context,
        context.getString(idTitle),
        context.getString(idMessage),
        positiveButtonListener);
  }

  public static void showInformationMessage(Context context, String title, String message,
                                            DialogInterface.OnClickListener positiveButtonListener) {

    new AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setIcon(R.drawable.ic_information_color)
        .setCancelable(false)
        .setPositiveButton(android.R.string.ok, positiveButtonListener)
        .show();
  }


  public static void showInformationMessage(Context context, int idTitle, int idMessage,
                                            DialogInterface.OnClickListener positiveButtonListener) {

    showInformationMessage(context,
        context.getString(idTitle),
        context.getString(idMessage),
        positiveButtonListener);
  }

  public static void showErrorMessage(Context context, String title, String message,
                                      DialogInterface.OnClickListener positiveButtonListener) {

    new AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setIcon(R.drawable.ic_error_color)
        .setCancelable(false)
        .setPositiveButton(android.R.string.ok, positiveButtonListener)
        .show();
  }

  public static void showErrorMessage(Context context, int idTitle, int idMessage,
                                      DialogInterface.OnClickListener positiveButtonListener) {
    showErrorMessage(context, context.getString(idTitle), context.getString(idMessage),
        positiveButtonListener);
  }

  public static void showErrorMessageStyled(Context context, String title, String message,
                                            DialogInterface.OnClickListener positiveButtonListener) {
    new AlertDialog.Builder(context, R.style.AlertDialogStyle)
        .setTitle(title)
        .setMessage(message)
        .setIcon(R.drawable.ic_error_color)
        .setCancelable(false)
        .setPositiveButton(android.R.string.ok, positiveButtonListener)
        .show();
  }

  public static void showQuestionMessage(Context context, String title, String message,
                                         DialogInterface.OnClickListener positiveButtonListener,
                                         DialogInterface.OnClickListener negativeButtonListener) {

    new AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(false)
        .setIcon(R.drawable.ic_question_color)
        .setPositiveButton(R.string.yes, positiveButtonListener)
        .setNegativeButton(R.string.no, negativeButtonListener).show();

  }

  public static void showQuestionMessage(Context activity, int idTitle, int idMessage,
                                         DialogInterface.OnClickListener positiveButtonListener,
                                         DialogInterface.OnClickListener negativeButtonListener) {


    showQuestionMessage(activity, activity.getString(idTitle),
        activity.getString(idMessage), positiveButtonListener, negativeButtonListener);
  }

  public static void showQuestionMessageStyled(Context activity, int idTitle, int idMessage,
                                               DialogInterface.OnClickListener positiveButtonListener,
                                               DialogInterface.OnClickListener negativeButtonListener) {


    new AlertDialog.Builder(activity, R.style.AlertDialogStyle)
        .setTitle(activity.getString(idTitle))
        .setMessage(activity.getString(idMessage))
        .setCancelable(false)
        .setIcon(R.drawable.ic_question_color)
        .setPositiveButton(R.string.yes, positiveButtonListener)
        .setNegativeButton(R.string.no, negativeButtonListener).show();
  }

  public static void showInputTipoItemDialog(final Context context, final SuperOperation operation,
                                             Customer customer, Patient patient,
                                             final MyCallbackInterface.CallbackBooleanInterface positiveCallback) {

    View viewInflated = LayoutInflater.from(context).inflate(R.layout.activity_input_tipo_item,
        null, false);

    final AlertDialog.Builder builder = new AlertDialog.Builder(context);

    builder.setView(viewInflated);
    builder.setCancelable(false);

    final RadioButton rbtn1 = viewInflated.findViewById(R.id.rbtn1);
    final RadioButton rbtn2 = viewInflated.findViewById(R.id.rbtn2);

    rbtn1.setText(context.getString(R.string.gas));
    rbtn2.setText(context.getString(R.string.consumivel));

    //Indica se a ditribuidora do patient é diferente da filial da viagem
    boolean distDif = !ConstantsEnum.YES.getValue().equalsIgnoreCase(customer.getFlDistribGas());

    if (patient != null)
      distDif = !ConstantsEnum.YES.getValue().equalsIgnoreCase(patient.getFlDistribGas());

    //Inicializando os botôes conforme as operações
    if (operation.getOperationType().equals(OperationType.APL)
        || operation.getOperationType().equals(OperationType.APLHC)
        || operation.getOperationType().equals(OperationType.RCLNF)
        || operation.getOperationType().equals(OperationType.RCL)
        || operation.getOperationType().equals(OperationType.RCLHC)) {

      rbtn1.setEnabled(distDif);
      rbtn1.setText(context.getString(R.string.cilindro));
      rbtn2.setText(context.getString(R.string.equipamento));
      rbtn2.setChecked(true);

    } else if (operation.getOperationType().equals(OperationType.RFH)) {
      rbtn1.setEnabled(distDif);

      if (rbtn1.isEnabled())
        rbtn1.setChecked(true);
      else
        rbtn2.setChecked(true);

    } else if (operation.getOperationType().equals(OperationType.TRC)) {
      rbtn1.setEnabled(distDif);
      rbtn1.setChecked(false);
      rbtn2.setChecked(true);
    } else if (operation.getOperationType().equals(OperationType.VND)) {
      rbtn1.setEnabled(distDif);
      rbtn1.setChecked(distDif);

      rbtn2.setChecked(true);

      if (!rbtn1.isChecked())
        rbtn2.setChecked(true);
    } else {
      rbtn1.setChecked(true);
      rbtn2.setChecked(false);
    }

    builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {

        if (rbtn1.isChecked())
          GLOBAL.self().setTipoItem(TypeItemType.GAS);
        else if (rbtn2.isChecked())
          GLOBAL.self().setTipoItem(TypeItemType.CONSUMIVEL);

        if (GLOBAL.self().isHomecare()) {
          if (operation.getOperationType().equals(OperationType.APL)
              || operation.getOperationType().equals(OperationType.APLHC)
              || operation.getOperationType().equals(OperationType.RCLNF)
              || operation.getOperationType().equals(OperationType.RCL)
              || operation.getOperationType().equals(OperationType.RCLHC)) {
            if (rbtn1.isChecked())
              GLOBAL.self().setTipoItem(TypeItemType.GAS);
            else if (rbtn2.isChecked())
              GLOBAL.self().setTipoItem(TypeItemType.EQUIPAMENTO);
          }
        }

        if (positiveCallback != null)
          positiveCallback.execute(true);
      }
    });

    builder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
      }
    });

    builder.show();
  }

  public static void showInputTipoRclDialog(final Context context, final SuperOperation operation,
                                            Customer customer, Patient patient,
                                            final MyCallbackInterface.CallbackBooleanInterface positiveCallback) {

    View viewInflated = LayoutInflater.from(context).inflate(R.layout.activity_input_tipo_rcl,
        null, false);

    final AlertDialog.Builder builder = new AlertDialog.Builder(context);

    builder.setView(viewInflated);
    builder.setCancelable(false);

    final RadioButton rbtn1 = viewInflated.findViewById(R.id.rbtn1);
    final RadioButton rbtn2 = viewInflated.findViewById(R.id.rbtn2);
    rbtn1.setChecked(true);

    builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {

        if (rbtn1.isChecked())
          GLOBAL.self().setTipoRcl("WM");
        else if (rbtn2.isChecked())
          GLOBAL.self().setTipoRcl("CLI");

        if (positiveCallback != null)
          positiveCallback.execute(true);
      }
    });

    builder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
      }
    });

    builder.show();
  }

  public static void showInputOdometroDialog(final Context context, final boolean fimViagem,
                                             final MyCallbackInterface.CallbackVoidInterface callback) {

    View viewInflated = LayoutInflater.from(context).inflate(R.layout.activity_input_odometro,
        null, false);

    final AlertDialog.Builder builder = new AlertDialog.Builder(context);

    builder.setView(viewInflated);
    builder.setCancelable(false);

    final EditText inputOdometro = viewInflated.findViewById(R.id.inputOdometro);

    builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {

        Long odometro = UtilHelper.convertToLongDef(inputOdometro.getText().toString(), 0);
        if (odometro <= 0) {
          showInformationMessage(context, R.string.confirmar_text,
              R.string.informar_horometro, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  showInputOdometroDialog(context, fimViagem, callback);
                }
              });
        } else {
          Daily daily = DatabaseApp.self().getDatabase().dailyDao().findByNumViagem(
              GLOBAL.self().getRoute().getNumeroViagem());

          if (daily == null)
            daily = Daily.newInstance();

          if (fimViagem) {
            if (odometro < daily.getOdometroInicial()) {
              String msg = String.format(context.getString(R.string.odometro_invalido),
                  daily.getOdometroInicial());

              showInformationMessage(context, context.getString(R.string.erro_text),
                  msg, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      showInputOdometroDialog(context, fimViagem, callback);
                    }
                  });
            } else {
              daily.setDataHoraFim(new Date());
              daily.setOdometroFinal(odometro);
              daily.save();

              Excepty.newInstance().insere(0L, 0L,
                  UtilHelper.currentDateTime(""), "9", odometro,
                  UtilHelper.currentDateTime(""), GLOBAL.self().getRoute().getNumeroViagem(),
                  GLOBAL.self().getRoute().getDataViagem());

              if (callback != null)
                callback.execute();
            }
          } else {
            Long odometroPrior = 0L;

            Daily dailyPrior = DatabaseApp.self().getDatabase().dailyDao().findPrior(
                GLOBAL.self().getRoute().getNumeroViagem());

            if (dailyPrior != null) {
              dailyPrior.setDataHoraFim(new Date());
              dailyPrior.setOdometroFinal(odometro);
              dailyPrior.save();
              odometroPrior = dailyPrior.getOdometroFinal();
            }

            if (odometro < odometroPrior) {
              String msg = String.format(context.getString(R.string.odometro_invalido),
                  odometroPrior);

              showInformationMessage(context, context.getString(R.string.erro_text),
                  msg, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      showInputOdometroDialog(context, fimViagem, callback);
                    }
                  });
            } else {
              daily.setOdometroInicial(odometro);
              daily.save();

              Excepty.newInstance().insere(0L, 0L,
                  UtilHelper.currentDateTime(""), "1", odometro,
                  UtilHelper.currentDateTime(""), GLOBAL.self().getRoute().getNumeroViagem(),
                  GLOBAL.self().getRoute().getDataViagem());

              if (callback != null)
                callback.execute();
            }
          }
        }
      }
    });

    builder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
      }
    });

    builder.show();
  }

  @SuppressLint("SetTextI18n")
  public static void showInputPickTravel(final Context context,
                                         final MyCallbackInterface.CallbackVoidInterface callback) {

    View viewInflated = LayoutInflater.from(context).inflate(R.layout.activity_input_pick_travel,
        null, false);

    final AlertDialog.Builder builder = new AlertDialog.Builder(context);

    builder.setView(viewInflated);
    builder.setCancelable(false);

    final Spinner spnNumeroViagem = viewInflated.findViewById(R.id.spnNumeroViagem);
    final TextView txtData = viewInflated.findViewById(R.id.txtData);
    final TextView txtHora = viewInflated.findViewById(R.id.txtHora);
    final TextView txtNext = viewInflated.findViewById(R.id.txtNext);


    final List<Travel> travels = DatabaseApp.self().getDatabase().travelDao().getAll();

    final Calendar c = Calendar.getInstance();
    final int mYear = c.get(Calendar.YEAR);
    final int mMonth = c.get(Calendar.MONTH);
    final int mDay = c.get(Calendar.DAY_OF_MONTH);
    final int mHour = c.get(Calendar.HOUR_OF_DAY);
    final int mMinute = c.get(Calendar.MINUTE);


    txtData.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
            new DatePickerDialog.OnDateSetListener() {

              @Override
              public void onDateSet(DatePicker view, int year,
                                    int monthOfYear, int dayOfMonth) {

                txtData.setText(dayOfMonth + "/" +
                    UtilHelper.padLeft(String.valueOf((monthOfYear + 1)), '0', 2) +
                    "/" + year);
              }
            }, mYear, mMonth, mDay);

        datePickerDialog.show();
      }
    });

    txtHora.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        MyTimePickerDialog mTimePicker = new MyTimePickerDialog(context,
            new MyTimePickerDialog.OnTimeSetListener() {
              @Override
              public void onTimeSet(TimePicker view, int hourOfDay, int minute, int seconds) {
                txtHora.setText(
                    UtilHelper.padLeft(String.valueOf(hourOfDay), '0', 2) + ":" +
                        UtilHelper.padLeft(String.valueOf(minute), '0', 2) + ":" +
                        UtilHelper.padLeft(String.valueOf(seconds), '0', 2));
              }
            }, mHour, mMinute, 0, true);

        mTimePicker.show();
      }
    });

    ArrayAdapter<Travel> adapter = new ArrayAdapter<>(context,
        android.R.layout.simple_list_item_1, travels);

    spnNumeroViagem.setAdapter(adapter);
    final Travel travel = travels.get(spnNumeroViagem.getSelectedItemPosition());

    Date max, min;
    min = travel.getDataViagem();
    min = UtilHelper.sumHoursToDate(min, -12);
    System.out.println(min);

    max = new Date();

    Invoice prior = DatabaseApp.self().getDatabase().invoiceDao().findPriorInvoice(
        GLOBAL.self().getInvoice().getNumero(), GLOBAL.self().getInvoice().getTipoNota());

    Invoice next = DatabaseApp.self().getDatabase().invoiceDao().findNextInvoice(
        GLOBAL.self().getInvoice().getNumero(), GLOBAL.self().getInvoice().getTipoNota());

    if (prior != null)
      min = prior.getDataMovimento();

    if (next != null)
      max = next.getDataMovimento();

    final Date dMax = max, dMin = min;

    String nextIinvoiceDate = String.format(context.getString(R.string.next_invoice),
        UtilHelper.formatDateStr(min.getTime(), ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue()),
        UtilHelper.formatDateStr(max.getTime(), ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue()));

    txtNext.setText(nextIinvoiceDate);

    txtData.setText(UtilHelper.formatDateStr(max.getTime(), ConstantsEnum.ddMMyyyy_barra.getValue()));
    txtHora.setText(UtilHelper.formatDateStr(max.getTime(), ConstantsEnum.HHmmss_ponto.getValue()));

    builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {

        String data = txtData.getText().toString() + " " + txtHora.getText().toString();

        Date dataMovimento = UtilHelper.convertToDate(data,
            ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue());

        Date dtEmissao = UtilHelper.convertToDate(
            UtilHelper.formatDateStr(dataMovimento, ConstantsEnum.ddMMyyyy.getValue()),
            ConstantsEnum.ddMMyyyy.getValue());

        if (dataMovimento.getTime() > dMax.getTime() || dataMovimento.getTime() < dMin.getTime()) {
          String msg = String.format(context.getString(R.string.data_invalida),
              UtilHelper.formatDateStr(dMin, ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue()),
              UtilHelper.formatDateStr(dMax, ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue()));

          showErrorMessage(context, context.getString(R.string.erro_text), msg,
              null);
        } else {
          //Travel travel = travels.get(spnNumeroViagem.getSelectedItemPosition());
          GLOBAL.self().getRoute().setNumeroViagem(travel.getNumeroViagem());

          if (GLOBAL.self().getInvoice() != null) {
            GLOBAL.self().getInvoice().setNumeroViagem(UtilHelper.padLeft(
                travel.getNumeroViagem().toString(), '0', 6));
            GLOBAL.self().getInvoice().setDataEmissao(dtEmissao);
            GLOBAL.self().getInvoice().setDataMovimento(dataMovimento);

          }

          ((Activity) context).finish();
        }
      }
    });

    builder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
      }
    });

    builder.show();
  }

  @SuppressLint("SetTextI18n")
  public static void showInputPasswordDialog(final Context context, final String descricao,
                                             final UtilHelper.OnOkListener positiveButtonListener,
                                             final boolean isGlobal) {

    View viewInflated = LayoutInflater.from(context).inflate(R.layout.activity_input_password,
        null, false);

    final AlertDialog.Builder builder = new AlertDialog.Builder(context);

    builder.setView(viewInflated);
    builder.setCancelable(false);

    final TextView txtTituloSenha = viewInflated.findViewById(R.id.txtTituloSenha);
    txtTituloSenha.setText(context.getString(R.string.titulo_senha));

    final TextView txtDataSenha = viewInflated.findViewById(R.id.txtDataSenha);
    txtDataSenha.setText(UtilHelper.formatDateStr(new Date(),
        ConstantsEnum.ddMMyy_barra.getValue()));

    final EditText edtNumeroSenha = viewInflated.findViewById(R.id.edtNumeroSenha);
    final EditText edtSenha = viewInflated.findViewById(R.id.edtSenha);
    final TextView txtDescricaoSenha = viewInflated.findViewById(R.id.txtDescricaoSenha);

    edtSenha.requestFocus();

    edtNumeroSenha.setText(String.valueOf(GLOBAL.self().getGeneral().getContadorSenha()));

    //TODO:RETIRAR ESSA LINHA
    if (BuildConfig.DEBUG)
      edtSenha.setText(generatePasword(UtilHelper.convertToIntegerDef(
          edtNumeroSenha.getText().toString(), UtilHelper.convertToIntegerDef(
              edtNumeroSenha.getText().toString(), 1)), isGlobal).toString());

    txtDescricaoSenha.setText(descricao);

    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {

        String senha = edtSenha.getText().toString();
        int tentativas = UtilHelper.convertToIntegerDef(edtNumeroSenha.getText().toString(), 1);

        if (validatePass(context, senha, tentativas, isGlobal)) {
          if (positiveButtonListener.onOkClick(edtSenha.getText().toString())) {
            dialog.dismiss();

            GLOBAL.self().getGeneral().setContadorSenha(GLOBAL.self().getGeneral().getContadorSenha() + 1);
            GLOBAL.self().getGeneral().save();
          }
        } else {
          edtSenha.setText("");
          showErrorMessage(context, R.string.erro_text, R.string.password_error, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              showInputPasswordDialog(context, descricao, positiveButtonListener, isGlobal);
            }
          });
        }
      }
    });

    builder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
      }
    });

    builder.show();
  }

  public static void showInputPasswordDialog(final Context context, final int idDescricao,
                                             final UtilHelper.OnOkListener positiveButtonListener,
                                             final boolean isGlobal) {
    showInputPasswordDialog(context, context.getString(idDescricao), positiveButtonListener,
        isGlobal);
  }

  public static void showBeginSearchDialog(final Activity activity, final Invoice invoice,
                                           final MyCallbackInterface.CallbackSearchInterface positiveCallback,
                                           final MyCallbackInterface.CallbackSearchInterface negativeCallback,
                                           final Boolean abortar) {

    final View viewInflated = LayoutInflater.from(activity).inflate(R.layout.activity_begin_search,
        null, false);


    final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//    builder.setTitle(activity.getString(R.string.avaliacao));

    final TextView txtDescricaoPesquisa = viewInflated.findViewById(R.id.txtDescricaoPesquisa);
    txtDescricaoPesquisa.setText(activity.getString(R.string.avaliacao));

    builder.setView(viewInflated);
    builder.setCancelable(false);

    Customer customer = InvoiceHelper.self().getInvoiceCustomer(invoice);

    final EditText edtMotoristaPesquisa = viewInflated.findViewById(R.id.edtMotoristaPesquisa);
    final EditText edtContatoPesquisa = viewInflated.findViewById(R.id.edtContatoPesquisa);
    final EditText edtCargoPesquisa = viewInflated.findViewById(R.id.edtCargoPesquisa);
    final EditText edtTelefonePesquisa = viewInflated.findViewById(R.id.edtTelefonePesquisa);

    View screen = viewInflated.findViewById(R.id.screen);

    if (screen != null)
      screen.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          edtMotoristaPesquisa.requestFocus();
          UtilHelper.hideKeyboardFrom(activity, edtMotoristaPesquisa);
        }
      });

    edtMotoristaPesquisa.setText(customer.getNomeMotorista());
    edtContatoPesquisa.setText(customer.getNomeContato());
    edtCargoPesquisa.setText(customer.getCargoContato());
    edtTelefonePesquisa.setText(customer.getTelefoneContato());

    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {

        if (edtMotoristaPesquisa.getText().toString().isEmpty())
          showInformationMessage(activity, R.string.informar_text, R.string.informar_motorista,
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  showBeginSearchDialog(activity, invoice, positiveCallback, negativeCallback, abortar);
                  edtMotoristaPesquisa.requestFocus();
                }
              });
        else if (edtContatoPesquisa.getText().toString().isEmpty())
          showInformationMessage(activity, R.string.informar_text, R.string.informar_contato,
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  showBeginSearchDialog(activity, invoice, positiveCallback, negativeCallback, abortar);
                  edtContatoPesquisa.requestFocus();
                }
              });
        else if (edtCargoPesquisa.getText().toString().isEmpty())
          showInformationMessage(activity, R.string.informar_text, R.string.informar_cargo,
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  showBeginSearchDialog(activity, invoice, positiveCallback, negativeCallback, abortar);
                  edtCargoPesquisa.requestFocus();
                }
              });
        else if (edtTelefonePesquisa.getText().toString().isEmpty())
          showInformationMessage(activity, R.string.informar_text, R.string.informar_telefone,
              new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  showBeginSearchDialog(activity, invoice, positiveCallback, negativeCallback, abortar);
                  edtTelefonePesquisa.requestFocus();
                }
              });
        else {
          Search search = Search.newInstance();
          search.setMotorista(edtMotoristaPesquisa.getText().toString());
          search.setCdCustomer(InvoiceHelper.self().getInvoiceCustomer(invoice).getCdCustomer());
          search.setContato(edtContatoPesquisa.getText().toString());
          search.setCargo(edtCargoPesquisa.getText().toString());
          search.setTelefone(edtTelefonePesquisa.getText().toString());
          search.setIdNota(invoice.getId());
          if (abortar)
            search.setRejeitada(ConstantsEnum.YES.getValue());
          else
            search.setRejeitada(ConstantsEnum.NO.getValue());
          search.setDtPesquisa(UtilHelper.currentDateTime(ConstantsEnum.ddMMyyyy_HHmmss.getValue()));
          search.save();

          if (positiveCallback != null)
            positiveCallback.execute(search);
        }
      }
    });

    builder.show();
  }


  public static void showInputMotiveItemDialog(final Context context, Customer customer,
                                               Patient patient,
                                               final MyCallbackInterface.CallbackStringInterface positiveCallback) {

    View viewInflated = LayoutInflater.from(context).inflate(R.layout.activity_input_motive_cancel,
        null, false);

    final AlertDialog.Builder builder = new AlertDialog.Builder(context);

    final TextView txtCustomerNameMotive = viewInflated.findViewById(R.id.txtCustomerNameMotive);
    final Spinner spnMotivos = viewInflated.findViewById(R.id.spnMotivos);

    final List<Code> codes = DatabaseApp.self().getDatabase().codeDao().find(ConstantsEnum.C.getValue());
    List<String> motivos = new ArrayList<>();

    for (Code code : codes)
      motivos.add(code.getDescricao());

    ArrayAdapter<String> motivosAdapter = new ArrayAdapter<>(context,
        android.R.layout.simple_selectable_list_item, motivos);

    spnMotivos.setAdapter(motivosAdapter);
    txtCustomerNameMotive.setText(String.format(Locale.getDefault(), "Cliente: %d - %s",
        customer.getCdCustomer(), UtilHelper.capitalize(customer.getNome().toLowerCase())));

    if (patient != null)
      txtCustomerNameMotive.setText(String.format(Locale.getDefault(), "Cliente: %d - %s",
          patient.getCdPaciente(), UtilHelper.capitalize(patient.getNome().toLowerCase())));

    builder.setView(viewInflated);
    builder.setCancelable(false);

    builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {

        Code code = codes.get(spnMotivos.getSelectedItemPosition());

        if (positiveCallback != null)
          positiveCallback.execute(code.getCodigo() + "-" + code.getDescricao());
      }
    });

    builder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
      }
    });

    builder.show();
  }

  public static void showInputMotiveDialog(final Context context, Customer customer,
                                           Patient patient,
                                           final MyCallbackInterface.CallbackStringInterface positiveCallback) {

    View viewInflated = LayoutInflater.from(context).inflate(R.layout.activity_input_motive_cancel,
        null, false);

    final AlertDialog.Builder builder = new AlertDialog.Builder(context);

    final TextView txtCustomerNameMotive = viewInflated.findViewById(R.id.txtCustomerNameMotive);
    final Spinner spnMotivos = viewInflated.findViewById(R.id.spnMotivos);

    final List<Code> codes = DatabaseApp.self().getDatabase().codeDao().find(ConstantsEnum.N.getValue());
    List<String> motivos = new ArrayList<>();

    for (Code code : codes)
      motivos.add(code.getDescricao());

//    simple_spinner_dropdown_item
//    simple_spinner_item
//    simple_list_item_1
//    select_dialog_item
    ArrayAdapter<String> motivosAdapter = new ArrayAdapter<>(context,
        android.R.layout.simple_selectable_list_item, motivos);

    spnMotivos.setAdapter(motivosAdapter);
    txtCustomerNameMotive.setText(customer.getCdCustomer().toString() + " - " + UtilHelper.capitalize(customer.getNome().toLowerCase()));

    if (patient != null)
      txtCustomerNameMotive.setText(patient.getCdPaciente().toString() + " - " + UtilHelper.capitalize(patient.getNome().toLowerCase()));

    builder.setView(viewInflated);
    builder.setCancelable(false);

    builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {

        Code code = codes.get(spnMotivos.getSelectedItemPosition());

        if (positiveCallback != null)
          positiveCallback.execute(code.getCodigo() + "-" + code.getDescricao());
      }
    });

    builder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
      }
    });

    builder.show();
  }

  public static void showInputConfirmCount(final Context context, Double cheios, Double vazios,
                                           boolean isHomecare,
                                           final MyCallbackInterface.CallbackBooleanInterface positiveCallback) {

    View viewInflated = LayoutInflater.from(context)
        .inflate(R.layout.activity_confirm_count_cylinder, null, false);

    final AlertDialog.Builder builder = new AlertDialog.Builder(context);

    final TextView txtCheiosConfirmar = viewInflated.findViewById(R.id.txtCheiosConfirmar);
    final TextView txtVaziosConfirmar = viewInflated.findViewById(R.id.txtVaziosConfirmar);
    final TextView txtTitiloConfirmar = viewInflated.findViewById(R.id.txtTitiloConfirmar);

    int idCheios = R.string.cheios;
    int idVazios = R.string.vazios;
    int idTitulo = R.string.title_activity_confirm_count_cylinder;

    if (isHomecare) {
      idCheios = R.string.aplicado;
      idVazios = R.string.recolhido;
      idTitulo = R.string.title_activity_confirm_count_hc;
    }

    txtTitiloConfirmar.setText(idTitulo);

    txtCheiosConfirmar.setText(String.format(Locale.getDefault(), "%s %s",
        context.getString(idCheios), UtilHelper.formatDoubleString(cheios, 0)));

    txtVaziosConfirmar.setText(String.format(Locale.getDefault(), "%s %2s",
        context.getString(idVazios), UtilHelper.formatDoubleString(vazios, 0)));

    builder.setView(viewInflated);
    builder.setCancelable(false);

    builder.setPositiveButton(R.string.confirmar, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {

        if (positiveCallback != null)
          positiveCallback.execute(true);
      }
    });

    builder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.cancel();
      }
    });

    builder.show();
  }

  private static Integer generatePasword(int tentativas, boolean isGlobal) {
    Integer AuxGlob, AuxUnit;
    Integer ValDvGlob, ValDvUnit;
    Integer DiaSem;
    Integer DiaMes;

    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    DiaSem = c.get(Calendar.DAY_OF_WEEK);
    DiaMes = c.get(Calendar.DAY_OF_MONTH);
    Integer veiculo = UtilHelper.convertToIntegerDef(GLOBAL.self().getStaticTable().getCdVeiculo(), 0);

    Integer nSenhaGlob = 2161 + DiaMes + DiaSem;
    Integer nSenhaUnit = veiculo + DiaMes + DiaSem + tentativas;

    ValDvGlob = Module11Senha(UtilHelper.padLeft(nSenhaGlob.toString(), '0', 11));
    ValDvUnit = Module11Senha(UtilHelper.padLeft(nSenhaUnit.toString(), '0', 11));

    AuxGlob = ((nSenhaGlob * ValDvGlob) - ValDvGlob);
    AuxUnit = ((nSenhaUnit * ValDvUnit) - ValDvUnit);

    nSenhaGlob = AuxGlob;
    nSenhaUnit = AuxUnit;

    // Cria Senha Global
    String ConvSenha = UtilHelper.padLeft(nSenhaGlob.toString(), '0', 5);
    ConvSenha = "186" + ConvSenha.substring(0, 5);
    nSenhaGlob = UtilHelper.convertToIntegerDef(ConvSenha, 0);

    // Cria Senha Unital
    ConvSenha = UtilHelper.padLeft(nSenhaUnit.toString(), '0', 5);
    ConvSenha = "184" + ConvSenha.substring(0, 5);
    nSenhaUnit = UtilHelper.convertToIntegerDef(ConvSenha, 0);

    if (isGlobal)
      return nSenhaGlob;
    else
      return nSenhaUnit;

  }

  private static boolean validatePass(final Context context, String inputedPass, int tentativas,
                                      boolean isGlobal) {
    Integer AuxGlob, AuxUnit;
    Integer ValDvGlob, ValDvUnit;
    Integer DiaSem;
    Integer DiaMes;

    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    DiaSem = c.get(Calendar.DAY_OF_WEEK);
    DiaMes = c.get(Calendar.DAY_OF_MONTH);
    Integer veiculo = UtilHelper.convertToIntegerDef(GLOBAL.self().getStaticTable().getCdVeiculo(), 0);

    Integer nSenhaGlob = 2161 + DiaMes + DiaSem;
    Integer nSenhaUnit = veiculo + DiaMes + DiaSem + tentativas;

    ValDvGlob = Module11Senha(UtilHelper.padLeft(nSenhaGlob.toString(), '0', 11));
    ValDvUnit = Module11Senha(UtilHelper.padLeft(nSenhaUnit.toString(), '0', 11));

    AuxGlob = ((nSenhaGlob * ValDvGlob) - ValDvGlob);
    AuxUnit = ((nSenhaUnit * ValDvUnit) - ValDvUnit);

    nSenhaGlob = AuxGlob;
    nSenhaUnit = AuxUnit;

    // Cria Senha Global
    String ConvSenha = UtilHelper.padLeft(nSenhaGlob.toString(), '0', 5);
    ConvSenha = "186" + ConvSenha.substring(0, 5);
    nSenhaGlob = UtilHelper.convertToIntegerDef(ConvSenha, 0);

    // Cria Senha Unital
    ConvSenha = UtilHelper.padLeft(nSenhaUnit.toString(), '0', 5);
    ConvSenha = "184" + ConvSenha.substring(0, 5);
    nSenhaUnit = UtilHelper.convertToIntegerDef(ConvSenha, 0);

    if (isGlobal)
      return UtilHelper.convertToIntegerDef(inputedPass, 0).equals(nSenhaGlob)
          || UtilHelper.convertToIntegerDef(inputedPass, 0).equals(nSenhaUnit);
    else
      return UtilHelper.convertToIntegerDef(inputedPass, 0).equals(nSenhaUnit);
  }

  private static int Module11Senha(String N) {
    if (N.length() != 11) return -1;

    int y = 2;
    int nDV = 0;
    int temp = 0;
    for (int x = 10; x >= 0; x--) {
      temp = UtilHelper.convertToIntegerDef(N.substring(x, x + 1), 0);
      nDV += temp * y;
      y++;
    }

    int AuxDV = (nDV % 11);

    AuxDV = (nDV % 11);
    if (AuxDV == 0)
      nDV = 10;
    else
      nDV = AuxDV;

    return nDV;
  }

}
