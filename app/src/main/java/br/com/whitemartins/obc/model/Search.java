package br.com.whitemartins.obc.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

@Entity
public class Search extends MockRecord implements Serializable {
  public static final long serialVersionUID = 1L;

  @PrimaryKey(autoGenerate = true)
  private Long id;
  private Long cdCustomer;
  @TypeConverters(DateTypeConverter.class)
  @XmlMapping(xmlTagName = "dt_pesquisa", xmlParentTagName = "pesquisa", dateFormat = "yyyyMMdd HHmmss")
  private Date dtPesquisa;
  @XmlMapping(xmlTagName = "motorista", xmlParentTagName = "pesquisa")
  private String motorista;
  @XmlMapping(xmlTagName = "contato", xmlParentTagName = "pesquisa")
  private String contato;
  @XmlMapping(xmlTagName = "cargo", xmlParentTagName = "pesquisa")
  private String cargo;
  @XmlMapping(xmlTagName = "telefone", xmlParentTagName = "pesquisa")
  private String telefone;
  @XmlMapping(xmlTagName = "fl_rejeitada", xmlParentTagName = "pesquisa")
  private String rejeitada;
  private Long idNota;

  public Search() {
    motorista = "";
    contato = "";
    cargo = "";
    telefone = "";
    rejeitada = "";
    idNota = null;
    cdCustomer = 0L;
    dtPesquisa = null;
  }

  public static Search newInstance() {
    return new Search();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public Date getDtPesquisa() {
    return dtPesquisa;
  }

  public void setDtPesquisa(Date dtPesquisa) {
    this.dtPesquisa = dtPesquisa;
  }

  public String getMotorista() {
    return motorista;
  }

  public void setMotorista(String motorista) {
    this.motorista = motorista;
  }

  public String getContato() {
    return contato;
  }

  public void setContato(String contato) {
    this.contato = contato;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getRejeitada() {
    return rejeitada;
  }

  public void setRejeitada(String rejeitada) {
    this.rejeitada = rejeitada;
  }

  public Long getIdNota() {
    return idNota;
  }

  public void setIdNota(Long idNota) {
    this.idNota = idNota;
  }

  @Override
  public void parseLine(String line) {

  }

  public boolean isValid() {
    return (!motorista.isEmpty()
      && !cargo.isEmpty()
//      && !telefone.isEmpty()
      && !contato.isEmpty()
    );
  }

  @Override
  public void save() {
    if (isValid()) {
      Long id = DatabaseApp.self().getDatabase().searchDao().insert(this);
      setId(id);
    }
  }

  @Override
  public void deleteAll() {
    DatabaseApp.self().getDatabase().searchDao().deleteAll(DatabaseApp.self().getDatabase()
      .searchDao().getAll());
  }

  public Document createXml(Document document, Element nfeElement) {

    try {
      Element element = document.createElement("pesquisa");
      nfeElement.appendChild(element);

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
