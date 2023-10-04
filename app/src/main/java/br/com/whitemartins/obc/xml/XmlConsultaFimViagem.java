package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

@Root(name = "OBCFimViagemConsultaRequest")
public class XmlConsultaFimViagem extends XmlBase {

  @Element(name = "codigoFilial", required = false)
  private String codigoFilial;

  @Element(name = "dataViagemPrincipal", required = false)
  private String dataViagemPrincipal;

  @Element(name = "numeroViagemPrincipal", required = false)
  private String numeroViagemPrincipal;

  @Element(name = "dataViagemCorrente", required = false)
  private String dataViagemCorrente;

  @Element(name = "numeroViagemCorrente", required = false)
  private String numeroViagemCorrente;

  public String getCodigoFilial() {
    return codigoFilial;
  }

  public void setCodigoFilial(String codigoFilial) {
    this.codigoFilial = codigoFilial;
  }

  public String getDataViagemPrincipal() {
    return dataViagemPrincipal;
  }

  public void setDataViagemPrincipal(String dataViagemPrincipal) {
    this.dataViagemPrincipal = dataViagemPrincipal;
  }

  public String getNumeroViagemPrincipal() {
    return numeroViagemPrincipal;
  }

  public void setNumeroViagemPrincipal(String numeroViagemPrincipal) {
    this.numeroViagemPrincipal = numeroViagemPrincipal;
  }

  public String getDataViagemCorrente() {
    return dataViagemCorrente;
  }

  public void setDataViagemCorrente(String dataViagemCorrente) {
    this.dataViagemCorrente = dataViagemCorrente;
  }

  public String getNumeroViagemCorrente() {
    return numeroViagemCorrente;
  }

  public void setNumeroViagemCorrente(String numeroViagemCorrente) {
    this.numeroViagemCorrente = numeroViagemCorrente;
  }

  public static XmlConsultaFimViagem newInstance() {
    return new XmlConsultaFimViagem();
  }

  @Override
  public String toString() {
    return "OBCFimViagemConsultaRequest [codigoFilial=" + codigoFilial
      + ", dataViagemPrincipal=" + dataViagemPrincipal
      + ", numeroViagemPrincipal=" + numeroViagemPrincipal
      + ", dataViagemCorrente=" + dataViagemCorrente
      + ", numeroViagemCorrente=" + numeroViagemCorrente + "]";
  }

  @Override
  public String serialize() {
    Travel mainTravel = DatabaseApp.self().getDatabase().travelDao().findFirst();

    codigoFilial = GLOBAL.self().getRoute().getCdFilialJde();
    numeroViagemCorrente = mainTravel.getNumeroViagem().toString();
    dataViagemCorrente = UtilHelper.formatDateStr(mainTravel.getDataViagem(),
      ConstantsEnum.yyyyMMdd.getValue());

    numeroViagemPrincipal = mainTravel.getNumeroViagem().toString();
    dataViagemPrincipal = UtilHelper.formatDateStr(mainTravel.getDataViagem(),
      ConstantsEnum.yyyyMMdd.getValue());

    return super.serialize();
  }
}
