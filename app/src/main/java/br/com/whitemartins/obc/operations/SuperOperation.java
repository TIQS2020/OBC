package br.com.whitemartins.obc.operations;

import java.io.Serializable;

import br.com.whitemartins.obc.dao.CodeDao;
import br.com.whitemartins.obc.enumeration.Cfop3Type;
import br.com.whitemartins.obc.enumeration.Cfop4Type;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Code;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public abstract class SuperOperation implements Serializable {


  protected OperationType operationType;
  //Identifica o tipo de nota Vnd = 2
  protected Integer tipoTransacao;
  protected String tax1;
  protected String tax2;
  //Informa o tipo de nota E-Entrada ou S-Saida
  protected InvoiceType tipoNota;
  protected String returnCode;
  protected LoadType loadType;
  String codigoDocumento;
  boolean finalizaPedido;
  boolean condicaoPagamento;
  String[] codigoMensagens;
  boolean cilindroPP;
  boolean calculaVolume = true;
  Integer[] cfop4Type;
  Integer[] cfop3Type;
  boolean unidadeFixa;
  //Codigo Interno da nota Vnd = 90
  String codigoInterno;
  boolean recursivoUPC;
  boolean permiteNegativo;
  boolean imprimeIcmsRodape;

  public static SuperOperation getOperation(Integer tipoTransacao) {

    if (tipoTransacao.equals(OperationType.VND.getValue()))
      return Vnd.newInstance();
    else if (tipoTransacao.equals(OperationType.APL.getValue())) {
      if (GLOBAL.self().isHomecare())
        return AplHc.newInstance();

      return Apl.newInstance();
    } else if (tipoTransacao.equals(OperationType.RCLNF.getValue())) {
      if (GLOBAL.self().isHomecare())
        return RclHc.newInstance();

      return RclNf.newInstance();
    } else if (tipoTransacao.equals(OperationType.VOR.getValue()))
      return Vor.newInstance();
    else if (tipoTransacao.equals(OperationType.FUT.getValue()))
      return Fut.newInstance();
    else if (tipoTransacao.equals(OperationType.TRC.getValue()))
      return Trc.newInstance();
    else if (tipoTransacao.equals(OperationType.RPS.getValue()))
      return Rps.newInstance();
    else if (tipoTransacao.equals(OperationType.RFH.getValue()))
      return Rfh.newInstance();
    else if (tipoTransacao.equals(OperationType.TRF.getValue()))
      return Trf.newInstance();
    else
      return null;
  }

  public Boolean isRastreavel() {
    CodeDao dao = DatabaseApp.self().getDatabase().codeDao();
    Code code = dao.find(UtilHelper.convertToIntegerDef(codigoInterno.substring(1), 0));

    return code != null
      && ConstantsEnum.YES.getValue().equalsIgnoreCase(code.getIndRastreabilidade());
  }

  public String getTax1() {
    return tax1;
  }

  public String getTax2() {
    return tax2;
  }

  public OperationType getOperationType() {
    return operationType;
  }

  public String getCodigoInterno() {
    return codigoInterno;
  }

  public boolean isRecursivoUPC() {
    return recursivoUPC;
  }

  public boolean isPermiteNegativo() {
    return permiteNegativo;
  }

  public String getReturnCode() {
    return returnCode;
  }

  public boolean getUnidadeFixa() {
    return unidadeFixa;
  }

  public Integer getTipoTransacao() {
    return tipoTransacao;
  }

  public String getCodigoMovimento(Invoice invoice, Customer customer) {
    if (this.codigoInterno.length() < 2) {
      return ConstantsEnum._0.getValue();
    } else {
      return this.codigoInterno.substring(1, 3);
    }
  }

  public String getCodigoDocumento(Customer customer) {
    return codigoDocumento;
  }

  public boolean isFinalizaPedido() {
    return finalizaPedido;
  }

  public boolean isCondicaoPagamento() {
    return condicaoPagamento;
  }

  public boolean isImprimeIcmsRodape() {
    return imprimeIcmsRodape;
  }

  public String[] getCodigoMensagens() {
    return codigoMensagens;
  }

  public boolean isCilindroPP() {
    return cilindroPP;
  }

  public LoadType getLoadType() {
    return loadType;
  }

  public boolean isCalculaVolume() {
    return calculaVolume;
  }

  public InvoiceType getTipoNota() {
    return tipoNota;
  }

  public Integer getCfop(Customer customer, ItemPrice itemPrice) {
    if (customer.getUf().equalsIgnoreCase(GLOBAL.self().getRoute().getUf())) {
      if (ConstantsEnum.YES.getValue().equalsIgnoreCase(itemPrice.getItem().getIndProducao()))
        return cfop4Type[Cfop4Type.INTERNO_MANUF.ordinal()];
      else
        return cfop4Type[Cfop4Type.INTERNO_NAO_MANUF.ordinal()];
    } else {
      if (ConstantsEnum.YES.getValue().equalsIgnoreCase(itemPrice.getItem().getIndProducao()))
        return cfop4Type[Cfop4Type.EXTERNO_MANUF.ordinal()];
      else
        return cfop4Type[Cfop4Type.EXTERNO_NAO_MANUF.ordinal()];
    }
  }

  public Integer getOldCfop(Customer customer, ItemPrice itemPrice) {
    if (customer.getUf().equalsIgnoreCase(GLOBAL.self().getRoute().getUf())) {
      if (ConstantsEnum.YES.getValue().equalsIgnoreCase(itemPrice.getItem().getIndProducao()))
        return cfop3Type[Cfop3Type.INTERNO_MANUF.ordinal()];
      else
        return cfop3Type[Cfop3Type.INTERNO_NAO_MANUF.ordinal()];
    } else {
      if (ConstantsEnum.YES.getValue().equalsIgnoreCase(itemPrice.getItem().getIndProducao()))
        return cfop3Type[Cfop3Type.EXTERNO_MANUF.ordinal()];
      else
        return cfop3Type[Cfop3Type.EXTERNO_NAO_MANUF.ordinal()];
    }
  }
}
