package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.whitemartins.obc.dao.RastreabilidadeDao;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

@FileInfo(lineLength = 110)
@Entity(indices = {@Index(
  name = "uk_cilindro",
  value = {"idNota", "cdCilindro", "cdItem", "capacidadeItem"},
  unique = true)
})

public class Rastreabilidade extends MockRecord implements Serializable {

  private static final long serialVersionUID = 1L;
  @PrimaryKey
  private Long id;

  private String cdFilial;
  @XmlMapping(xmlTagName = "cd_cilindro", xmlParentTagName = "rastreabilidade")
  private String cdCilindro;
  @XmlMapping(xmlTagName = "num_lote", xmlParentTagName = "rastreabilidade")
  private String numeroLote;
  private Long idNota;
  private Long numeroNota;
  private Long cdItem;
  private String numeroVeiculo;
  private Long numeroViagem;
  private Date dataViagem;
  private Double capacidadeItem;
  private Long cdCustomer;
  private String liberado;

  public Rastreabilidade() {
    cdCilindro = "0";
  }

  public static Rastreabilidade newInstance() {
    return new Rastreabilidade();
  }

  @Override
  public void parseLine(String line) {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCdFilial() {
    return cdFilial;
  }

  public void setCdFilial(String cdFilial) {
    this.cdFilial = cdFilial;
  }

  @NonNull
  public String getCdCilindro() {
    return cdCilindro;
  }

  public void setCdCilindro(@NonNull String cdCilindro) {
    this.cdCilindro = cdCilindro;
  }

  public String getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(String numeroLote) {
    this.numeroLote = numeroLote;
  }

  public Long getIdNota() {
    return idNota;
  }

  public void setIdNota(Long idNota) {
    this.idNota = idNota;
  }

  public Long getNumeroNota() {
    return numeroNota;
  }

  public void setNumeroNota(Long numeroNota) {
    this.numeroNota = numeroNota;
  }

  @NonNull
  public Long getCdItem() {
    return cdItem;
  }

  public void setCdItem(@NonNull Long cdItem) {
    this.cdItem = cdItem;
  }

  public String getNumeroVeiculo() {
    return numeroVeiculo;
  }

  public void setNumeroVeiculo(String numeroVeiculo) {
    this.numeroVeiculo = numeroVeiculo;
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

  public Double getCapacidadeItem() {
    return capacidadeItem;
  }

  public void setCapacidadeItem(Double capacidadeItem) {
    this.capacidadeItem = capacidadeItem;
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public String getLiberado() {
    return liberado;
  }

  public void setLiberado(String liberado) {
    this.liberado = liberado;
  }

  @Override
  public boolean isValid() {
    return true;
  }

  public void save() {
    RastreabilidadeDao dao = DatabaseApp.self().getDatabase().rastreabilidadeDao();
    dao.insert(this);
  }

  public void update() {
    RastreabilidadeDao dao = DatabaseApp.self().getDatabase().rastreabilidadeDao();
    dao.update(this);
  }


  public void deleteAll() {
    RastreabilidadeDao dao = DatabaseApp.self().getDatabase().rastreabilidadeDao();
    dao.deleteAll(dao.getAll());
  }

  public Document createXml(Document document, Element documentElement) {
    Map<String, String> tags = new HashMap<>();
    tags.put("rastreabilidade", "downloader_Detalhe");

    try {
      Element parentElement = (Element) documentElement.getElementsByTagName("downloader_Detalhe").item(0);
      Element rastElement = document.createElement("rastreabilidade");
      parentElement.appendChild(rastElement);

      Field[] fields = getClass().getDeclaredFields();

      for (Field field : fields) {

        if (field.isAnnotationPresent(XmlMapping.class)) {

          field.setAccessible(true);
          XmlMapping annotation = field.getAnnotation(XmlMapping.class);

          Object value = field.get(this);

          if (value == null)
            value = "";

          NodeList nodes = parentElement.getElementsByTagName(annotation.xmlParentTagName());
          rastElement = (Element) nodes.item(nodes.getLength() - 1);

          XmlConfig.createNode(document, rastElement, annotation.xmlTagName(), value.toString());
        }
      }

    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return document;
  }
}
