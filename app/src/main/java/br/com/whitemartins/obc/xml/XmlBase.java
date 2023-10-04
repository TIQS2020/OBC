package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.PathHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public abstract class XmlBase {

  private final String TAG = getClass().getSimpleName();

  public String getName() {
    return getClass().getSimpleName();
  }

  public String serialize() {

    Serializer serializer = new Persister();

    File file = new File(PathHelper.self().getFilePathDownload() +
      getName() + ".xml");

    String line = "";

    try {
      serializer.write(this, file);

      BufferedReader bufReader = new BufferedReader(new FileReader(file));

      StringBuilder sb = new StringBuilder();
      line = bufReader.readLine();

      while (line != null) {
        sb.append(line);
        line = bufReader.readLine();
      }

      bufReader.close();

      saveFile(sb.toString());
      return sb.toString();

    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
    }

    return "";
  }

  public XmlBase read(String xml) throws Exception {
    Serializer serializer = new Persister();
    return serializer.read(this.getClass(), xml);
  }

  public void saveFile() throws IOException {
    FileOutputStream outputStream = null;
    File outputFile;
    try {
      File dir = new File(PathHelper.self().getFilePathDownload());
      outputFile = new File(dir, getName() + ".xml");
      outputStream = new FileOutputStream(outputFile);
      outputStream.write(serialize().getBytes());

    } finally {
      if (outputStream != null) {
        outputStream.flush();
        outputStream.close();
      }
    }
  }

  public void saveFile(String input) throws IOException {
    FileOutputStream outputStream = null;
    File outputFile = null;
    try {
      File dir = new File(PathHelper.self().getFilePathDownload());
      outputFile = new File(dir, getName() + ".xml");
      outputStream = new FileOutputStream(outputFile);
      outputStream.write(input.getBytes());

    } finally {
      if (outputStream != null) {
        outputStream.flush();
        outputStream.close();
      }
    }
  }


  public XmlBase parse(File file) {
    try {
      FileInputStream fis = new FileInputStream(file.getPath());
      parse(fis);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return this;
  }

  public void parse(InputStream is) {
    XmlPullParserFactory parserFactory;
    try {
      parserFactory = XmlPullParserFactory.newInstance();
      XmlPullParser parser = parserFactory.newPullParser();
      parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
      parser.setInput(is, null);

      processParsing(parser);

    } catch (XmlPullParserException | IllegalAccessException | IOException e) {
      e.printStackTrace();
    }
  }

  public XmlBase parse(String xml) {
    InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
    parse(is);
    return this;
  }

  private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException,
    IllegalAccessException {
    int eventType = parser.getEventType();

    List list = new ArrayList<>();
    String buffeEltName = "";
    while (eventType != XmlPullParser.END_DOCUMENT) {
      String eltName;

      switch (eventType) {
        case XmlPullParser.START_TAG:
          eltName = parser.getName();

          if (!buffeEltName.equals(eltName)) {
            buffeEltName = eltName;
            list = new ArrayList<>();
          }

          Field[] fields = getClass().getDeclaredFields();

          for (Field field : fields) {
            if (field.isAnnotationPresent(XmlMapping.class)) {
              XmlMapping annotation = field.getAnnotation(XmlMapping.class);
              if (annotation.xmlTagName().equalsIgnoreCase(eltName)) {
                String value = parser.nextText();

                field.setAccessible(true);

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
                } else if (field.getType().equals(List.class)) {
//                  try {
                  list.add(value);
//                    Method execute = field.getType().getDeclaredMethod("execute", Object.class);
//                    execute.invoke(this, list);
                  field.set(this, list);
//                  } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                  } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                  }
                }

                break;
              }
            }
          }

          break;
      }

      eventType = parser.next();
    }
  }
}
