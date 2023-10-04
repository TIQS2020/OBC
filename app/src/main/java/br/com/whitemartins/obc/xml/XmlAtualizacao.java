package br.com.whitemartins.obc.xml;

import android.app.Activity;
import android.support.annotation.Nullable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.util.Constants;
import br.com.whitemartins.obc.util.PathHelper;

public class XmlAtualizacao {

  @MappingIn(suppress = true)
  private static XmlAtualizacao _self;
  @MappingIn(suppress = true)
  private Activity activity;

  private String Piloto;
  //  private String Filial;
  private String VersaoProd;
  private String VersaoPiloto;
  private String PathVersaoProd;
  private String PathVersaoPiloto;
  private List<String> Filial;
  private List<String> Objeto;
  private List<String> Veiculo;

  public XmlAtualizacao(Activity activity) {
    this.activity = activity;
    Objeto = new ArrayList<>();
  }

  public static XmlAtualizacao self(Activity activity) {
    if (_self == null)
      _self = new XmlAtualizacao(activity);

    return _self;
  }

  public String getPiloto() {
    return Piloto;
  }

  public void setPiloto(String piloto) {
    Piloto = piloto;
  }

//  public String getFilial() {
//    return Filial;
//  }
//
//  public void setFilial(String androidFiliaisPiloto) {
//    Filial = androidFiliaisPiloto;
//  }

  public String getVersaoProd() {
    return VersaoProd;
  }

  public void setVersaoProd(String versaoProd) {
    VersaoProd = versaoProd;
  }

  public String getVersaoPiloto() {
    return VersaoPiloto;
  }

  public void setVersaoPiloto(String versaoPiloto) {
    VersaoPiloto = versaoPiloto;
  }

  public String getPathVersaoProd() {
    return PathVersaoProd;
  }

  public void setPathVersaoProd(String pathVersaoProd) {
    PathVersaoProd = pathVersaoProd;
  }

  public String getPathVersaoPiloto() {
    return PathVersaoPiloto;
  }

  public void setPathVersaoPiloto(String pathVersaoPiloto) {
    PathVersaoPiloto = pathVersaoPiloto;
  }

//  public List<String> getAndroidObjetos() {
//    return Objeto;
//  }
//
//  public void setAndroidObjetos(List<String> androidObjeto) {
//    Objeto = androidObjeto;
//  }

  public List<String> getFilial() {
    return Filial;
  }

  public void setFilial(List<String> filial) {
    Filial = filial;
  }

  public List<String> getObjeto() {
    return Objeto;
  }

  public void setObjeto(List<String> objeto) {
    Objeto = objeto;
  }

  public List<String> getVeiculo() {
    return Veiculo;
  }

  public void setVeiculo(List<String> veiculo) {
    Veiculo = veiculo;
  }

  @Nullable
  private List<String> getNodeListValueByName(Element elem, String nodeName) {
    List<String> retorno = new ArrayList<>();
    try {
      NodeList nodes = elem.getElementsByTagName(nodeName);

      for (int i = 0; i < nodes.getLength(); i++) {
        Node node = nodes.item(i);

        if (!node.getTextContent().isEmpty())
          retorno.add(node.getTextContent().trim());
      }

      return retorno;
    } catch (Exception ex) {
      // MessageBox.Show(ex.Message);
      return null;
    }
  }

  @Nullable
  private Method getMethod(Class klass, String name) {
    Method[] methods = klass.getDeclaredMethods();
    for (Method method : methods) {
      // Test any other things about it beyond the name...
      if (method.getName().equals("addAll")) {
        return method;
      }
    }
    return null;
  }

  public XmlAtualizacao read() {
    File file = new File(PathHelper.self().getFilePathDownload(), Constants.OBC_NET_UPDATE);

    try {
      FileInputStream fis = new FileInputStream(file.getPath());
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fis);

      Node rootNode = doc.getDocumentElement().getElementsByTagName("ObcAndroid").item(0);
      Field[] fields = getClass().getDeclaredFields();
      for (Field field : fields) {
        if (field.isAnnotationPresent(MappingIn.class)) {
          MappingIn annotation = field.getAnnotation(MappingIn.class);
          if (annotation.suppress())
            continue;
        }

        NodeList ndoes = doc.getDocumentElement().getElementsByTagName(field.getName());

        if (field.getType().equals(List.class)) {

          List<String> lista = getNodeListValueByName(doc.getDocumentElement(), field.getName());
          if (field.getName().equals("Objeto")) {
            setObjeto(lista);
          }

          if (field.getName().equals("Filial")) {
            setFilial(lista);
          }

          if (field.getName().equals("Veiculo")) {
            setVeiculo(lista);
          }
        } else {
          if (ndoes.getLength() > 0) {
            String value = "";
            if (doc.getDocumentElement().getElementsByTagName(field.getName()).item(0).getChildNodes().getLength() > 0) {
              value = doc.getDocumentElement().getElementsByTagName(field.getName()).item(0).getChildNodes().item(0).getNodeValue();
              if (value == null)
                value = "";
            } else
              value = "";

            field.set(this, value);
          }
        }
      }
    } catch (IOException | IllegalAccessException | ParserConfigurationException | SAXException e) {
      e.printStackTrace();
    }

    return this;
  }
}
