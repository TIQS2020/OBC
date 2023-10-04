package br.com.whitemartins.obc.xml;

import android.app.Activity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Field;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.util.Constants;
import br.com.whitemartins.obc.util.PathHelper;

public class XmlConfig {
  @MappingIn(suppress = true)
  private static XmlConfig _self;
  @MappingIn(suppress = true)
  private Activity activity;

  private String AmbienteJDE;
  //  private String UrlServidor;
  private String UrlServidorContingencia;
  private String UrlServidorNFe;
  private String TempoTotal;
  private String IntervaloTempo;
  private String IntervaloTempoDPEC;
  private String NumTentativas;
  private String TimeOut1;
  private String TimeOut2;
  private String ativarLog;
  private String servletCarga;
  private String servletAtualiza;
  private String servletRestaura;

  public XmlConfig() {
//    AmbienteJDE = "QA7333";
//    UrlServidorContingencia = "http://contingenciaobc.whitemartins.com.br/qa/MediadorOBCWMRESTful/";
//    UrlServidorNFe = "https://app.whitemartins.com.br/qa/MediadorOBCWMRESTful/";
//    TempoTotal = "2";
//    IntervaloTempo = "10";
//    IntervaloTempoDPEC = "300";
//    NumTentativas = "3";
//    TimeOut1 = "120";
//    TimeOut2 = "2";
//    ativarLog = "0";
//    servletCarga = "OBCMobileCast";
//    servletRestaura = "OBCRestauraCfg";
//    servletAtualiza = "OBCAtualizaVersao_1";
  }

  public static XmlConfig self() {
    if (_self == null)
      _self = new XmlConfig();

    return _self;
  }

  public static void createNode(Document document, Element rootElement, String nodename,
                                String nodeValue) {
    Node node = document.createElement(nodename);
    node.appendChild(document.createTextNode(nodeValue));
    rootElement.appendChild(node);
  }

  public static void createCDataNode(Document document, Element rootElement, String nodename,
                                     String nodeValue) {
    Node node = document.createElement(nodename);
    node.appendChild(document.createCDATASection(nodeValue));
    rootElement.appendChild(node);
  }

  public String getAmbienteJDE() {
    return AmbienteJDE;
  }

  public void setAmbienteJDE(String ambienteJDE) {
    this.AmbienteJDE = ambienteJDE;
  }

  public String getUrlServidorContingencia() {
    return UrlServidorContingencia;
  }

  public void setUrlServidorContingencia(String urlServidorContingencia) {
    this.UrlServidorContingencia = urlServidorContingencia;
  }

  public String getUrlServidorNFe() {
    return UrlServidorNFe;
  }

  public void setUrlServidorNFe(String urlServidorNFe) {
    this.UrlServidorNFe = urlServidorNFe;
  }

  public String getTempoTotal() {
    return TempoTotal;
  }

  public void setTempoTotal(String tempoTotal) {
    this.TempoTotal = tempoTotal;
  }

  public String getIntervaloTempo() {
    return IntervaloTempo;
  }

  public void setIntervaloTempo(String intervaloTempo) {
    this.IntervaloTempo = intervaloTempo;
  }

  public String getIntervaloTempoDPEC() {
    return IntervaloTempoDPEC;
  }

  public void setIntervaloTempoDPEC(String intervaloTempoDPEC) {
    this.IntervaloTempoDPEC = intervaloTempoDPEC;
  }

  public String getNumTentativas() {
    return NumTentativas;
  }

  public void setNumTentativas(String numTentativas) {
    this.NumTentativas = numTentativas;
  }

  public String getTimeOut1() {
    return TimeOut1;
  }

  public void setTimeOut1(String timeOut1) {
    this.TimeOut1 = timeOut1;
  }

  public String getTimeOut2() {
    return TimeOut2;
  }

  public void setTimeOut2(String timeOut2) {
    this.TimeOut2 = timeOut2;
  }

  public String getAtivarLog() {
    return ativarLog;
  }

  public void setAtivarLog(String ativarLog) {
    this.ativarLog = ativarLog;
  }

  public String getServletCarga() {
    return servletCarga;
  }

  public void setServletCarga(String servletCarga) {
    this.servletCarga = servletCarga;
  }

  public String getServletAtualiza() {
    return servletAtualiza;
  }

  public void setServletAtualiza(String servletAtualiza) {
    this.servletAtualiza = servletAtualiza;
  }

  public String getServletRestaura() {
    return servletRestaura;
  }

  public void setServletRestaura(String servletRestaura) {
    this.servletRestaura = servletRestaura;
  }


  private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException, IllegalAccessException {
    int eventType = parser.getEventType();

    while (eventType != XmlPullParser.END_DOCUMENT) {
      String eltName = "";

      switch (eventType) {
        case XmlPullParser.START_TAG:
          eltName = parser.getName();

          try {

            if (!eltName.equalsIgnoreCase("AppConfig")) {

              Field field = getClass().getDeclaredField(eltName);

              if (field != null) {
                String value = parser.nextText();
                if (field.getGenericType().equals(Integer.class))
                  field.set(this, Integer.parseInt(value));
                else if (field.getGenericType().equals(String.class))
                  field.set(this, value);
                else if (field.getGenericType().equals(Long.class))
                  field.set(this, Long.parseLong(value));
                else if (field.getGenericType().equals(Float.class))
                  field.set(this, Float.parseFloat(value));
                else if (field.getGenericType().equals(Long.class))
                  field.set(this, Long.parseLong(value));
                else if (field.getGenericType().equals(Double.class))
                  field.set(this, Double.parseDouble(value));
                else
                  field.set(this, value);
              }
            }
          } catch (NoSuchFieldException e) {
            e.printStackTrace();
          }
          break;

      }

      eventType = parser.next();
    }
  }

  public void parseXML(InputStream is) {
    XmlPullParserFactory parserFactory;
    try {
      parserFactory = XmlPullParserFactory.newInstance();
      XmlPullParser parser = parserFactory.newPullParser();
      parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
      parser.setInput(is, null);

      processParsing(parser);

    } catch (XmlPullParserException | IllegalAccessException e) {

    } catch (IOException e) {
    }
  }

  public XmlConfig read() {
    try {
      File file = new File(PathHelper.self().getFilePathConfig(), Constants.OBC_NET_CONFIG);

      if (!file.exists())
        save();

      parseXML(new FileInputStream(file.getPath()));

    } catch (IOException e) {
      e.printStackTrace();
    }

    return this;
  }

  public void save() {
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    try {
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
      Document document = documentBuilder.newDocument();
      Element rootElement = document.createElement(Constants.ROOT_ELEMENT_CONFIG);

      Field[] fields = getClass().getDeclaredFields();

      for (Field field : fields) {
        if (field.isAnnotationPresent(MappingIn.class)) {
          MappingIn annotation = field.getAnnotation(MappingIn.class);
          if (annotation.suppress())
            continue;
        }

        Object value = field.get(this);

        Element element = document.createElement(field.getName());
        element.appendChild(document.createTextNode(value.toString()));
        rootElement.appendChild(element);
      }

      document.appendChild(rootElement);

      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      StringWriter writer = new StringWriter();
      StreamResult result = new StreamResult(writer);
      transformer.transform(new DOMSource(document), result);

      File dir = new File(PathHelper.self().getFilePathConfig());
      File file = new File(dir, Constants.OBC_NET_CONFIG);
      if (!dir.exists())
        dir.mkdir();

      BufferedWriter buf = new BufferedWriter(new FileWriter(file, false));
      buf.append(writer.toString());
      buf.newLine();
      buf.close();

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerConfigurationException e2) {
      e2.printStackTrace();
    } catch (TransformerException e3) {
      e3.printStackTrace();
    } catch (IOException e4) {
      e4.printStackTrace();
    } catch (IllegalAccessException e5) {
      e5.printStackTrace();
    }
  }

}
