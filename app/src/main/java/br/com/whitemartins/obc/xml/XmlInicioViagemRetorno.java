package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "inicioViagemResponse")
public class XmlInicioViagemRetorno extends XmlBase {

  @Element(name = "cd_filial", required = false)
  private String cdFilial;
  @Element(name = "dt_viagem", required = false)
  private String dataViagem;
  @Element(name = "num_viagem", required = false)
  private String numeroViagem;
  @Element(name = "descricao", required = false)
  private String descricao;
  @Element(name = "status", required = false)
  private String status;

  private XmlInicioViagemRetorno() {
    status = "";
  }

  public static XmlInicioViagemRetorno newInstance() {
    return new XmlInicioViagemRetorno();
  }

  public String getCdFilial() {
    return cdFilial;
  }

  public void setCdFilial(String cdFilial) {
    this.cdFilial = cdFilial;
  }

  public String getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(String dataViagem) {
    this.dataViagem = dataViagem;
  }

  public String getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(String numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


//  public XmlBase read() throws Exception {
//    Serializer serializer = new Persister();
//    saveFile(XmlRetorno.self().getConteudoConsulta());
//
//    XmlSincronismoRetorno xmlSyncReturn = serializer.read(XmlSincronismoRetorno.class, XmlRetorno.self().getConteudoConsulta());
//
//    for (NotasFiscais notas : xmlSyncReturn.notasFiscais) {
//      notas.getCabecalhoNFe().setNumeroViagemCorrente(getNumeroViagemCorrente());
//      notas.getCabecalhoNFe().setDataViagemCorrente(getDataViagemCorrente());
//    }
//
//    return xmlSyncReturn;
//  }

}
