package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import br.com.whitemartins.obc.dao.InvoiceMessageDao;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

@Entity(primaryKeys = {"idNota", "cdCustomer", "sequencia", "linha"})
public class InvoiceMessage extends MockRecord implements Serializable {

  private static final long serialVersionUID = 1L;

  @NonNull
  private Long idNota;
  private Integer tipoTransacao;
  private Long numeroNota;
  private Long serieNota;
  @NonNull
  private Long cdCustomer;
  private Integer cdRota;
  private String numeroFutEntrega;
  @TypeConverters(DateTypeConverter.class)
  private Date dataEmissao;
  @NonNull
  @XmlMapping(xmlTagName = "seq_obs", xmlParentTagName = "NFe")
  private Integer sequencia;
  @NonNull
  @XmlMapping(xmlTagName = "seq_linha_obs", xmlParentTagName = "NFe")
  private Integer linha;
  @XmlMapping(xmlTagName = "descricao_obs", xmlParentTagName = "NFe")
  private String mensagem;
  private String mostrarMsg;

  public static InvoiceMessage newInstance() {
    return new InvoiceMessage();
  }

  public Long getIdNota() {
    return idNota;
  }

  public void setIdNota(Long idNota) {
    this.idNota = idNota;
  }

  public Integer getTipoTransacao() {
    return tipoTransacao;
  }

  public void setTipoTransacao(Integer tipoTransacao) {
    this.tipoTransacao = tipoTransacao;
  }

  public Long getNumeroNota() {
    return numeroNota;
  }

  public void setNumeroNota(Long numeroNota) {
    this.numeroNota = numeroNota;
  }

  public Long getSerieNota() {
    return serieNota;
  }

  public void setSerieNota(Long serieNota) {
    this.serieNota = serieNota;
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public Integer getCdRota() {
    return cdRota;
  }

  public void setCdRota(Integer cdRota) {
    this.cdRota = cdRota;
  }

  public String getNumeroFutEntrega() {
    return numeroFutEntrega;
  }

  public void setNumeroFutEntrega(String numeroFutEntrega) {
    this.numeroFutEntrega = numeroFutEntrega;
  }

  public Date getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(Date dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public Integer getSequencia() {
    return sequencia;
  }

  public void setSequencia(Integer sequencia) {
    this.sequencia = sequencia;
  }

  public Integer getLinha() {
    return linha;
  }

  public void setLinha(Integer linha) {
    this.linha = linha;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public String getMostrarMsg() {
    return mostrarMsg;
  }

  public void setMostrarMsg(String mostrarMsg) {
    this.mostrarMsg = mostrarMsg;
  }

  @Override
  public void parseLine(String line) {

  }

  @Override
  public void deleteAll() {
    InvoiceMessageDao dao = DatabaseApp.self().getDatabase().invoiceMessageDao();
    dao.deleteAll(dao.getAll());
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    DatabaseApp.self().getDatabase().invoiceMessageDao().insert(this);
  }


  public Document createXml(Document document, Element nfeElement) {

    //Element nfeElement = parentDocument.getDocumentElement();

    try {
      Element element = document.createElement("observacao");
      nfeElement.appendChild(element);

      Field[] fields = getClass().getDeclaredFields();

      for (Field field : fields) {

        if (field.isAnnotationPresent(XmlMapping.class)) {

          field.setAccessible(true);
          XmlMapping annotation = field.getAnnotation(XmlMapping.class);

          Object value = field.get(this);

          if (value == null)
            value = "";

          XmlConfig.createNode(document, element, annotation.xmlTagName(),
            value.toString());
        }
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return document;
  }

}
