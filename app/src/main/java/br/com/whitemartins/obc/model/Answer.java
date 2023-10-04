package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import br.com.whitemartins.obc.dao.AnswerDao;
import br.com.whitemartins.obc.dao.CustomerDao;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

@Entity(primaryKeys = {"id", "idPesquisa"})
public class Answer extends MockRecord implements Serializable {
  public static final long serialVersionUID = 1L;

  @NonNull
  @XmlMapping(xmlTagName = "sequencial", xmlParentTagName = "respostas")
  private Long id;
  @NonNull
  private Long idPesquisa;
  @XmlMapping(xmlTagName = "pergunta", xmlParentTagName = "respostas")
  private String pergunrta;
  @XmlMapping(xmlTagName = "resposta", xmlParentTagName = "respostas")
  private String resposta;
  @XmlMapping(xmlTagName = "categorizada", xmlParentTagName = "respostas")
  private String categorizada;

  public static Answer newInstance() {
    return new Answer();
  }

  @NonNull
  public Long getId() {
    return id;
  }

  public void setId(@NonNull Long id) {
    this.id = id;
  }

  @NonNull
  public Long getIdPesquisa() {
    return idPesquisa;
  }

  public void setIdPesquisa(@NonNull Long idPesquisa) {
    this.idPesquisa = idPesquisa;
  }

  public String getPergunrta() {
    return pergunrta;
  }

  public void setPergunrta(String pergunrta) {
    this.pergunrta = pergunrta;
  }

  public String getResposta() {
    return resposta;
  }

  public void setResposta(String resposta) {
    this.resposta = resposta;
  }

  public String getCategorizada() {
    return categorizada;
  }

  public void setCategorizada(String categorizada) {
    this.categorizada = categorizada;
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
    DatabaseApp.self().getDatabase().answerDao().insert(this);
  }

  @Override
  public void deleteAll() {
    AnswerDao dao = DatabaseApp.self().getDatabase().answerDao();
    dao.deleteAll(dao.getAll());
  }

  public Document createXml(Document document, Element nfeElement) {

    try {
      Element respostaElement = document.createElement("respostas");
      Element pesquisaElement = (Element) document.getDocumentElement().getElementsByTagName("pesquisa").item(0);
      pesquisaElement.appendChild(respostaElement);

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

          XmlConfig.createNode(document, respostaElement, annotation.xmlTagName(),
            value.toString());
        }
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return document;
  }
}
