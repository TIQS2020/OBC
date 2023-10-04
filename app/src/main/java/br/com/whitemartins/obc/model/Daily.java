package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import br.com.whitemartins.obc.dao.DailyDao;
import br.com.whitemartins.obc.enumeration.OrientationType;
import br.com.whitemartins.obc.interafce.MappingOut;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

@Entity
public class Daily extends MockRecord {

  @PrimaryKey
  @MappingOut(initialPos = 57, finalPos = 63, orientation = OrientationType.LEFT, charComplete = '0')
  private Long numeroViagem;
  @MappingOut(initialPos = 0, finalPos = 14, orientation = OrientationType.LEFT, charComplete = '0')
  private Date dataHoraInicio;
  @MappingOut(initialPos = 15, finalPos = 21, orientation = OrientationType.LEFT, charComplete = '0')
  private Long odometroInicial;
  @MappingOut(initialPos = 21, finalPos = 35, orientation = OrientationType.LEFT, charComplete = '0')
  private Date dataHoraFim;
  @MappingOut(initialPos = 35, finalPos = 42, orientation = OrientationType.LEFT, charComplete = '0')
  private Long odometroFinal;
  @MappingOut(initialPos = 42, finalPos = 48, orientation = OrientationType.LEFT, charComplete = '0')
  private Integer rota;
  @MappingOut(initialPos = 48, finalPos = 53, orientation = OrientationType.LEFT, charComplete = '0')
  private String veiculo;
  @MappingOut(initialPos = 53, finalPos = 57, orientation = OrientationType.LEFT, charComplete = '0')
  private String filial;
  @MappingOut(initialPos = 63, finalPos = 67, orientation = OrientationType.LEFT, charComplete = '0')
  private String versao;
  @MappingOut(initialPos = 67, finalPos = 68, orientation = OrientationType.LEFT, charComplete = '0')
  private Integer modeloDocViagem;
  @MappingOut(initialPos = 68, finalPos = 76, orientation = OrientationType.LEFT, charComplete = '0')
  private String dataViagem;

  public Daily() {
    odometroInicial = -1L;
    odometroFinal = 0L;
  }

  public static Daily newInstance() {
    return new Daily();
  }

  public Date getDataHoraInicio() {
    return dataHoraInicio;
  }

  public void setDataHoraInicio(Date dataHoraInicio) {
    this.dataHoraInicio = dataHoraInicio;
  }

  public Long getOdometroInicial() {
    return odometroInicial;
  }

  public void setOdometroInicial(Long odometroInicial) {
    this.odometroInicial = odometroInicial;
  }

  public Date getDataHoraFim() {
    return dataHoraFim;
  }

  public void setDataHoraFim(Date dataHoraFim) {
    this.dataHoraFim = dataHoraFim;
  }

  public Long getOdometroFinal() {
    return odometroFinal;
  }

  public void setOdometroFinal(Long odometroFinal) {
    this.odometroFinal = odometroFinal;
  }

  public Integer getRota() {
    return rota;
  }

  public void setRota(Integer rota) {
    this.rota = rota;
  }

  public String getVeiculo() {
    return veiculo;
  }

  public void setVeiculo(String veiculo) {
    this.veiculo = veiculo;
  }

  public String getFilial() {
    return filial;
  }

  public void setFilial(String unidade) {
    this.filial = unidade;
  }

  public Long getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(Long numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public String getVersao() {
    return versao;
  }

  public void setVersao(String versao) {
    this.versao = versao;
  }

  public Integer getModeloDocViagem() {
    return modeloDocViagem;
  }

  public void setModeloDocViagem(Integer modeloDocViagem) {
    this.modeloDocViagem = modeloDocViagem;
  }

  public String getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(String dataViagem) {
    this.dataViagem = dataViagem;
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
    DailyDao dao = DatabaseApp.self().getDatabase().dailyDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    DailyDao dao = DatabaseApp.self().getDatabase().dailyDao();
    List<Daily> clients = dao.getAll();
    dao.deleteAll(clients);
  }

  public String createXml() {
    String xmlString = "";

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    Document document = null;
    try {
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
      document = documentBuilder.newDocument();

      Field[] fields = getClass().getDeclaredFields();

      for (Field field : fields) {

        if (field.isAnnotationPresent(XmlMapping.class)) {

          field.setAccessible(true);
          XmlMapping annotation = field.getAnnotation(XmlMapping.class);

          NodeList nodes = document.getElementsByTagName(annotation.xmlParentTagName());

          Element parentElement;

          if (nodes.getLength() == 0) {
            parentElement = document.createElement(annotation.xmlParentTagName());
            document.appendChild(parentElement);
          } else
            parentElement = (Element) nodes.item(0);

          Object value = field.get(this);

          if (value == null)
            value = "";

          XmlConfig.createNode(document, parentElement, annotation.xmlTagName(),
            value.toString());
        }
      }

      StringWriter sw = new StringWriter();
      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer transformer = tf.newTransformer();
      transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
      transformer.setOutputProperty(OutputKeys.METHOD, "xml");

      transformer.transform(new DOMSource(document), new StreamResult(sw));
      xmlString = sw.toString();

    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerException e) {
      e.printStackTrace();
    }

    return xmlString;
  }

}
