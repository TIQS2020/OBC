package br.com.whitemartins.obc.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;

import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.util.UtilHelper;

public class XmlRetorno {
  public static XmlRetorno _self;

  @XmlMapping(xmlTagName = "codigoRetorno", xmlParentTagName = "mensagem")
  private Integer codigoRetorno;
  @XmlMapping(xmlTagName = "mensagemRetorno", xmlParentTagName = "mensagem")
  private String mensagemRetorno;
  @XmlMapping(xmlTagName = "conteudoConsulta", xmlParentTagName = "mensagem")
  private String conteudoConsulta;

  public static XmlRetorno self() {
    if (_self == null)
      _self = new XmlRetorno();

    return _self;
  }

  public void clearFields() {
    codigoRetorno = 1;
    mensagemRetorno = "Favor verificar a conexão com a internet.";
    conteudoConsulta = "";
  }

  public Integer getCodigoRetorno() {
    return codigoRetorno;
  }

  public void setCodigoRetorno(Integer codigoRetorno) {
    this.codigoRetorno = codigoRetorno;
  }

  public String getMensagemRetorno() {
    return mensagemRetorno;
  }

  public void setMensagemRetorno(String mensagemRetorno) {
    this.mensagemRetorno = mensagemRetorno;
  }

  public String getConteudoConsulta() {
    return conteudoConsulta;
  }

  public void setConteudoConsulta(String conteudoConsulta) {
    this.conteudoConsulta = conteudoConsulta;
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

  private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException, IllegalAccessException {
    int eventType = parser.getEventType();

    while (eventType != XmlPullParser.END_DOCUMENT) {
      String eltName = "";

      switch (eventType) {
        case XmlPullParser.START_TAG:
          eltName = parser.getName();

          Field[] fields = getClass().getDeclaredFields();

          for (Field field : fields) {
            if (field.isAnnotationPresent(XmlMapping.class)) {
              XmlMapping annotation = field.getAnnotation(XmlMapping.class);

              if (annotation.xmlTagName().equalsIgnoreCase(eltName)) {
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
                else if (field.getGenericType().equals(Date.class)) {
                  if (value == null || value.isEmpty())
                    value = "";

                  if (value != null && !value.isEmpty()) {
                    Date d = UtilHelper.convertToDate(value, annotation.dateFormat());
                    field.set(this, d);
                  }
                }
              }
            }
          }

          break;
      }

      eventType = parser.next();
    }
  }
}
