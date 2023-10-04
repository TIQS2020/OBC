package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import br.com.whitemartins.obc.dao.LotePatrimonioDao;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

@Entity
public class LotePatrimonio extends MockRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  private static final String NODE_INFO_LOTE_PATRIMONIO_NAME = "inf_lote_fab";

  @PrimaryKey(autoGenerate = true)
  private Long codigo;
  private Long idNota;
  private String cdFilial;
  private Long cdItem;
  private Double capacidade;
  @XmlMapping(xmlTagName = "lote", xmlParentTagName = NODE_INFO_LOTE_PATRIMONIO_NAME)
  private String numeroLote;
  private String numeroVeiuclo;
  private Long numeroViagem;
  private Date dataViagem;
  private Long cdCustomer;
  private Integer tipo;
  private String liberado;

  public LotePatrimonio() {
    codigo = null;
    idNota = null;
  }

  public static LotePatrimonio newInstance() {
    return new LotePatrimonio();
  }

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public Long getIdNota() {
    return idNota;
  }

  public void setIdNota(Long idNota) {
    this.idNota = idNota;
  }

  public String getCdFilial() {
    return cdFilial;
  }

  public void setCdFilial(String cdFilial) {
    this.cdFilial = cdFilial;
  }

  public Long getCdItem() {
    return cdItem;
  }

  public void setCdItem(Long cdItem) {
    this.cdItem = cdItem;
  }

  public Double getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(Double capacidade) {
    this.capacidade = capacidade;
  }

  public String getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(String numeroLote) {
    this.numeroLote = numeroLote;
  }

  public String getNumeroVeiuclo() {
    return numeroVeiuclo;
  }

  public void setNumeroVeiuclo(String numeroVeiuclo) {
    this.numeroVeiuclo = numeroVeiuclo;
  }

  public Long getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(Long numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public Date getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(Date dataViagem) {
    this.dataViagem = dataViagem;
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public Integer getTipo() {
    return tipo;
  }

  public void setTipo(Integer tipo) {
    this.tipo = tipo;
  }

  public String getLiberado() {
    return liberado;
  }

  public void setLiberado(String liberado) {
    this.liberado = liberado;
  }

  @Override
  public void parseLine(String line) {

  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    if (isValid())
      DatabaseApp.self().getDatabase().lotePatrimonioDao().insert(this);
  }

  @Override
  public void deleteAll() {
    LotePatrimonioDao dao = DatabaseApp.self().getDatabase().lotePatrimonioDao();
    dao.deleteAll(dao.getAll());
  }

  public Document createXmlLote(Document document, Element infLoteFabElement) {

    try {
      Field[] fields = getClass().getDeclaredFields();

      for (Field field : fields) {

        if (field.isAnnotationPresent(XmlMapping.class)) {

          field.setAccessible(true);
          XmlMapping annotation = field.getAnnotation(XmlMapping.class);
          
          Object value = field.get(this);

          if (value == null)
            value = "";

          XmlConfig.createNode(document, infLoteFabElement, annotation.xmlTagName(),
            value.toString());
        }
      }

    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return document;
  }

  public Document createXmlPatrimonio(Document document, Element infPatrimonioFabElement) {
    try {
      Field[] fields = getClass().getDeclaredFields();

      for (Field field : fields) {

        if (field.isAnnotationPresent(XmlMapping.class)) {

          field.setAccessible(true);
          XmlMapping annotation = field.getAnnotation(XmlMapping.class);

          NodeList nodes = document.getElementsByTagName(annotation.xmlParentTagName());

          Element parentElement;

          if (nodes.getLength() == 0) {
            parentElement = document.createElement(annotation.xmlParentTagName());
          } else
            parentElement = (Element) nodes.item(0);

          Object value = field.get(this);

          if (value == null)
            value = "";

          XmlConfig.createNode(document, parentElement, annotation.xmlTagName(), value.toString());
        }
      }

    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return document;
  }
}
