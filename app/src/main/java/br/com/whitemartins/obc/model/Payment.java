package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Locale;

import br.com.whitemartins.obc.dao.PaymentDao;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

@Entity
public class Payment extends MockRecord implements Serializable {

  @PrimaryKey(autoGenerate = true)
  private Long id;
  private Long idNota;
  @XmlMapping(xmlTagName = "tipo_integracao", xmlParentTagName = "cartao")
  private Integer tipoIntegracao;
  @XmlMapping(xmlTagName = "cnpj", xmlParentTagName = "cartao")
  private String cnpj;
  @XmlMapping(xmlTagName = "num_autorizacao", xmlParentTagName = "cartao")
  private String numeroAutorizacao;
  @XmlMapping(xmlTagName = "valor", xmlParentTagName = "cartao")
  private Double valor;
  private String credenciadora;
  @XmlMapping(xmlTagName = "bandeira", xmlParentTagName = "cartao")
  private String bandeira;
  private String nomeBandeira;
  @XmlMapping(xmlTagName = "modalidade", xmlParentTagName = "cartao")
  private Integer modalidade;

  public static Payment newInstance() {
    return new Payment();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getIdNota() {
    return idNota;
  }

  public void setIdNota(Long idNota) {
    this.idNota = idNota;
  }

  public Integer getTipoIntegracao() {
    return tipoIntegracao;
  }

  public void setTipoIntegracao(Integer tipoIntegracao) {
    this.tipoIntegracao = tipoIntegracao;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getNumeroAutorizacao() {
    return numeroAutorizacao;
  }

  public void setNumeroAutorizacao(String numeroAutorizacao) {
    this.numeroAutorizacao = numeroAutorizacao;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String getCredenciadora() {
    return credenciadora;
  }

  public void setCredenciadora(String credenciadora) {
    this.credenciadora = credenciadora;
  }

  public String getBandeira() {
    return bandeira;
  }

  public void setBandeira(String bandeira) {
    this.bandeira = bandeira;
  }

  public String getNomeBandeira() {
    return nomeBandeira;
  }

  public void setNomeBandeira(String nomeBandeira) {
    this.nomeBandeira = nomeBandeira;
  }

  public Integer getModalidade() {
    return modalidade;
  }

  public void setModalidade(Integer modalidade) {
    this.modalidade = modalidade;
  }

  public boolean isValid() {

    return (tipoIntegracao > 0
      && !numeroAutorizacao.isEmpty()
      && !cnpj.isEmpty()
      && !credenciadora.isEmpty()
      && !bandeira.isEmpty()
      && modalidade > 0
      && valor > 0
    );
  }

  @Override
  public void parseLine(String line) {

  }

  @Override
  public void save() {
    DatabaseApp.self().getDatabase().paymentDao().insert(this);
  }

  @Override
  public void deleteAll() {
    PaymentDao dao = DatabaseApp.self().getDatabase().paymentDao();
    dao.deleteAll(dao.getAll());
  }

  @NonNull
  @Override
  public String toString() {
    return String.format(Locale.getDefault(),
      "Credenciadora: %s\nBandeira: %s \nAutorização: %s \nValor: %s",
      credenciadora, nomeBandeira, numeroAutorizacao,
      UtilHelper.formatDoubleString(valor, 2));
  }

  public Document createXml(Document document) {

    try {
      Element downloaderNFe = (Element) document.getDocumentElement().getElementsByTagName("downloader_NFe").item(0);
      Element pagamentoCartaoElement = (Element) document.getDocumentElement().getElementsByTagName("pagamento_cartao").item(0);

      if (pagamentoCartaoElement == null) {
        pagamentoCartaoElement = document.createElement("pagamento_cartao");
        downloaderNFe.appendChild(pagamentoCartaoElement);
      }

      Element cartaoElement = document.createElement("cartao");
      pagamentoCartaoElement.appendChild(cartaoElement);

      Field[] fields = getClass().getDeclaredFields();

      for (Field field : fields) {

        if (field.isAnnotationPresent(XmlMapping.class)) {

          field.setAccessible(true);
          XmlMapping annotation = field.getAnnotation(XmlMapping.class);

          Object value = field.get(this);

          if (value == null)
            value = "";

          if (field.getGenericType().equals(Date.class)) {
            if (!value.toString().isEmpty()) {
              value = UtilHelper.formatDateStr(value, annotation.dateFormat());
            }
          }

          XmlConfig.createNode(document, cartaoElement, annotation.xmlTagName(),
            value.toString());
        }
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return document;
  }
}
