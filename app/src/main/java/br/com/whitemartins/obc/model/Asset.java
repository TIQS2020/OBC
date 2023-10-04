package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import br.com.whitemartins.obc.dao.AssetDao;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

@Entity(primaryKeys = {"cdItem", "numeroPatrimonio"})
@FileInfo(lineLength = 150)
public class Asset extends MockRecord implements Serializable {

  public static final long serialVersionUID = 1L;
  private static final String NODE_INFO_PATRIMONIO_NAME = "inf_patrimonio";

  @NonNull
  @MappingIn(initialPos = 0, finalPos = 8)
  private Long cdItem;
  @MappingIn(initialPos = 8, finalPos = 38)
  private String descricao;
  @MappingIn(initialPos = 38, finalPos = 53)
  @NonNull
  @XmlMapping(xmlTagName = "num_patrimonio", xmlParentTagName = NODE_INFO_PATRIMONIO_NAME)
  private String numeroPatrimonio;
  @MappingIn(initialPos = 53, finalPos = 78)
  @XmlMapping(xmlTagName = "serie_patrimonio", xmlParentTagName = NODE_INFO_PATRIMONIO_NAME)
  private String numeroSerie;
  @MappingIn(initialPos = 78, finalPos = 86)
  @XmlMapping(xmlTagName = "cod_ativo", xmlParentTagName = NODE_INFO_PATRIMONIO_NAME)
  private String cdAtivo;
  @MappingIn(initialPos = 86, finalPos = 116)
  @XmlMapping(xmlTagName = "desc_ativo", xmlParentTagName = NODE_INFO_PATRIMONIO_NAME)
  private String descricaoAtivo;
  private String checado;

  public Asset() {
    cdItem = 0L;
    numeroPatrimonio = "";
    numeroSerie = "";
    cdAtivo = "";
    descricaoAtivo = "";
    descricao = "";
  }

  public static Asset newInstace() {
    return new Asset();
  }

  public Long getCdItem() {
    return cdItem;
  }

  public void setCdItem(Long cdItem) {
    this.cdItem = cdItem;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getNumeroPatrimonio() {
    return numeroPatrimonio;
  }

  public void setNumeroPatrimonio(String numeroPatrimonio) {
    this.numeroPatrimonio = numeroPatrimonio;
  }

  public String getNumeroSerie() {
    return numeroSerie;
  }

  public void setNumeroSerie(String numeroSerie) {
    this.numeroSerie = numeroSerie;
  }

  public String getCdAtivo() {
    return cdAtivo;
  }

  public void setCdAtivo(String cdAtivo) {
    this.cdAtivo = cdAtivo;
  }

  public String getDescricaoAtivo() {
    return descricaoAtivo;
  }

  public void setDescricaoAtivo(String descricaoAtivo) {
    this.descricaoAtivo = descricaoAtivo;
  }

  public String getChecado() {
    return checado;
  }

  public void setChecado(String checado) {
    this.checado = checado;
  }

  @Override
  public void parseLine(String line) {
    this.automaticParseIn(line);
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    DatabaseApp.self().getDatabase().assetDao().insert(this);
  }

  @Override
  public void deleteAll() {
    AssetDao dao = DatabaseApp.self().getDatabase().assetDao();
    List<Asset> assets = dao.getAll();
    dao.deleteAll(assets);
  }

  @Override
  public String toString() {
    return this.getNumeroPatrimonio() + " " + this.getNumeroSerie();
  }

  public Document createXml(Document document, Element documentElement) {

    try {
      Field[] fields = getClass().getDeclaredFields();

      Element downloaderDetalhe = (Element) documentElement.getElementsByTagName("downloader_Detalhe").item(0);
      Element parentElement = document.createElement(NODE_INFO_PATRIMONIO_NAME);
      downloaderDetalhe.appendChild(parentElement);

      for (Field field : fields) {

        if (field.isAnnotationPresent(XmlMapping.class)) {

          field.setAccessible(true);
          XmlMapping annotation = field.getAnnotation(XmlMapping.class);

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
