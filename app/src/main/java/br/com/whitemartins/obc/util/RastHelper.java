package br.com.whitemartins.obc.util;

import android.app.Activity;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.RastreabilidadeDao;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Rastreabilidade;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.views.InvoiceRastreabActivity;

public class RastHelper {

  private static RastHelper _self;

  private RastreabilidadeDao dao;

  private RastHelper() {
    dao = DatabaseApp.self().getDatabase().rastreabilidadeDao();
  }

  public static RastHelper self() {
    if (_self == null)
      _self = new RastHelper();

    return _self;
  }

  private boolean validaDigVerificadorCilindro(String p) {
    Integer Calc;
    Integer DV;

    int
      n1 = Integer.parseInt(String.valueOf(p.charAt(0))),
      n2 = Integer.parseInt(String.valueOf(p.charAt(1))),
      n3 = Integer.parseInt(String.valueOf(p.charAt(2))),
      n4 = Integer.parseInt(String.valueOf(p.charAt(3))),
      n5 = Integer.parseInt(String.valueOf(p.charAt(4))),
      n6 = Integer.parseInt(String.valueOf(p.charAt(5))),
      n7 = Integer.parseInt(String.valueOf(p.charAt(6))),
      n8 = Integer.parseInt(String.valueOf(p.charAt(7)));

    Calc = n1 + n3 + n5 + n7;
    Calc = (Calc * 3);

    Calc = (Calc + n2 + n4 + n6 + n8);

    Calc = (Calc % 10);
    Calc = (10 - Calc);

    Calc = Integer.parseInt(Calc.toString().substring(Calc.toString().length() - 1
    ));

    DV = Integer.parseInt(String.valueOf(p.charAt(8)));

    return Calc == DV;
  }

  public boolean validateJulianDate(String lote) {
    boolean ret = true;
    Integer ano = 0;
    Integer diaJuliano = 0;

    try {
      diaJuliano = Integer.parseInt(lote.substring(7, 10));
      ano = Integer.parseInt(lote.substring(5, 7));
    } catch (Exception e) {
      ret = false;
    }

    if (ret) {
      if (!(diaJuliano >= 1 && diaJuliano <= 366))
        ret = false;

      Integer anoCorrente = Calendar.getInstance(Locale.getDefault()).get(Calendar.YEAR);
      Integer diaCorrente = Calendar.getInstance(Locale.getDefault()).get(Calendar.DAY_OF_YEAR);

      anoCorrente = UtilHelper.convertToIntegerDef(anoCorrente.toString().substring(2, 4), 0);

      if (ano > anoCorrente)
        ret = false;

      String dataCorrenteJuliano = anoCorrente.toString() + UtilHelper.padLeft(diaCorrente.toString(), '0', 3);
      String dataLoteJuliano = ano.toString() + UtilHelper.padLeft(diaJuliano.toString(), '0', 3);

      Integer a = UtilHelper.convertToIntegerDef(dataLoteJuliano, 0);
      Integer b = UtilHelper.convertToIntegerDef(dataCorrenteJuliano, 0);

      if (a > b)
        ret = false;
    }

    return ret;
  }

  public RastHelper init() {
    List<Rastreabilidade> rastreabilidades = dao.findByCustomer(GLOBAL.self().getCustomer().getCdCustomer());
    dao.deleteAll(rastreabilidades);
    return this;
  }

  private List<InvoiceRastreabActivity.LoteCil> filter(List<InvoiceRastreabActivity.LoteCil> loteCils,
                                                       String cdCilindro, InvoiceRastreabActivity.LoteCil editedItem) {
    List<InvoiceRastreabActivity.LoteCil> lotes;
    if (editedItem == null)
      lotes = loteCils.stream()
        .filter(line -> line.getCdCilindro().equalsIgnoreCase(cdCilindro))
        .collect(Collectors.toList());
    else
      lotes = loteCils.stream()
        .filter(line -> line.getCdCilindro().equalsIgnoreCase(cdCilindro)
          //&& (line.getNumeroLote().equals(editedItem.getNumeroLote()))
        )
        .collect(Collectors.toList());

    return lotes;
  }

  public boolean validaCilindro(Activity activity, String cdCilindro, List<InvoiceRastreabActivity.LoteCil> loteCils,
                                InvoiceRastreabActivity.LoteCil editedItem) {
    try {
      //Viagem de liquido nao tem cilindros
      if (GLOBAL.self().isLiquido())
        return true;

      //Validando o tamanho do campo
      if (cdCilindro.length() != 9)
        throw new Exception(activity.getString(R.string.cilindro_invalido));

      if (!validaDigVerificadorCilindro(cdCilindro))
        throw new Exception(activity.getString(R.string.cilindro_invalido));

      //Verificando cilindro já informado na nota
      List<InvoiceRastreabActivity.LoteCil> filtered = filter(loteCils, cdCilindro, editedItem);

      if (!filtered.isEmpty())
        throw new Exception(activity.getString(R.string.cilindro_informado));

      //Verificando cilindro já informado na viagem
      if (dao.find(cdCilindro) != null)
        throw new Exception(activity.getString(R.string.cilindro_informado));

    } catch (Exception ex) {
      DialogHelper.showErrorMessage(activity, activity.getString(R.string.erro_text), ex.getMessage(), null);
      return false;
    }

    return true;
  }

  public boolean validaLote(Activity activity, String numeroLote) {
    try {
      if (numeroLote.isEmpty() || numeroLote.length() != 13) {
        DialogHelper.showErrorMessage(activity, R.string.erro_text, R.string.lote_invalido,
          null);
        return false;
      }

      if (!validateJulianDate(numeroLote)) {
        DialogHelper.showErrorMessage(activity, R.string.erro_text, R.string.lote_invalido,
          null);
        return false;
      }

    } catch (Exception ex) {
      return false;
    }

    return true;
  }
}
