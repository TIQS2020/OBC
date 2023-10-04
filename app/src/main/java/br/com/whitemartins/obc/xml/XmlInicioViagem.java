package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

@Root(name = "obcInicioViagem")
public class XmlInicioViagem extends XmlBase {

  @Element(name = "codigoFilial", required = false)
  private String codigoFilial;

  @Element(name = "modeloEquipamento", required = false)
  private String modeloEquipamento;

  @Element(name = "versaoApp", required = false)
  private String versao;

  @Element(name = "versaoSO", required = false)
  private String plataforma;

  @Element(name = "imei", required = false)
  private String imei;


  @ElementList(name = "viagem", required = false, inline = true)
  private List<XmlViagem> xmlViagens;

  public XmlInicioViagem() {
    xmlViagens = new ArrayList<>();
  }

  public static XmlInicioViagem newInstance() {
    return new XmlInicioViagem();
  }

  public String getCodigoFilial() {
    return codigoFilial;
  }

  public void setCodigoFilial(String codigoFilial) {
    this.codigoFilial = codigoFilial;
  }

  public String getModeloEquipamento() {
    return modeloEquipamento;
  }

  public void setModeloEquipamento(String modeloEquipamento) {
    this.modeloEquipamento = modeloEquipamento;
  }

  public String getVersao() {
    return versao;
  }

  public void setVersao(String versao) {
    this.versao = versao;
  }

  public String getPlataforma() {
    return plataforma;
  }

  public void setPlataforma(String plataforma) {
    this.plataforma = plataforma;
  }

  public String getImei() {
    return imei;
  }

  public void setImei(String imei) {
    this.imei = imei;
  }

  public List<XmlViagem> getXmlViagens() {
    return xmlViagens;
  }

  public void setXmlViagens(List<XmlViagem> xmlViagens) {
    this.xmlViagens = xmlViagens;
  }

  @Override
  public String serialize() {

    versao = GLOBAL.self().getVersao();
    plataforma = GLOBAL.self().getPlataforma();
    modeloEquipamento = GLOBAL.self().getModeloEquipamento();
    codigoFilial = GLOBAL.self().getRoute().getCdFilialJde();
    imei = GLOBAL.self().getImei();

    List<Travel> travels = DatabaseApp.self().getDatabase().travelDao().getAll();

    if (travels.size() == 0) {
      XmlViagem xmlViagem = XmlViagem.newInstance();

      xmlViagem.setDataViagemCorrente(UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
        ConstantsEnum.yyyyMMdd.getValue()));

      xmlViagem.setDataViagemPricipal(UtilHelper
        .formatDateStr(GLOBAL.self().getRoute().getDataViagem(), ConstantsEnum.yyyyMMdd.getValue()));

      xmlViagem.setNumeroViagemCorrente(GLOBAL.self().getRoute().getNumeroViagem());
      xmlViagem.setNumeroViagemPrincipal(GLOBAL.self().getRoute().getNumeroViagem());

      xmlViagens.add(xmlViagem);

    } else {
      Travel mainTravel = travels.get(0);

      for (Travel travel : travels) {

        XmlViagem xmlViagem = XmlViagem.newInstance();

        xmlViagem.setNumeroViagemPrincipal(mainTravel.getNumeroViagem());
        xmlViagem.setDataViagemPricipal(UtilHelper.formatDateStr(mainTravel.getDataViagem(),
          ConstantsEnum.yyyyMMdd.getValue()));
        xmlViagem.setDataViagemCorrente(UtilHelper.formatDateStr(travel.getDataViagem(),
          ConstantsEnum.yyyyMMdd.getValue()));
        xmlViagem.setNumeroViagemCorrente(travel.getNumeroViagem());

        xmlViagens.add(xmlViagem);
      }
    }


    return super.serialize();
  }
}
