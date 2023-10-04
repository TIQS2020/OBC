package br.com.whitemartins.obc.model;


import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

import br.com.whitemartins.obc.enumeration.OrientationType;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.interafce.MappingOut;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

/**
 * Created by Rodolfo on 06/02/2018.
 */

public abstract class MockRecord {
  public abstract void parseLine(String line) throws IllegalAccessException;

  public void automaticParseIn(String line) {
    try {
      if (getClass().isAnnotationPresent(FileInfo.class)) {
        FileInfo an = getClass().getAnnotation(FileInfo.class);

        if (an.lineLength() != line.length()) {
          new Exception("Tamanho linha do arquivo " + this.getClass().getSimpleName() + " inválida");
        }
      }
    } catch (Exception e) {
      LogHelper.self().error(getClass().getSimpleName(), e);
      throw e;
    }

    Field[] fields = getClass().getDeclaredFields();

    for (Field field : fields) {
      if (field.isAnnotationPresent(MappingIn.class)) {
        MappingIn annotation = field.getAnnotation(MappingIn.class);

        int ini = annotation.initialPos();
        int fim = annotation.finalPos();
        int decimais = annotation.decimals();
        double divisor = decimais > 0 ? Math.pow(10, decimais) : 1;

        if (line.isEmpty())
          continue;

        String value = "";
        try {
          value = line.substring(ini, fim).trim();
        } catch (Exception aa) {
          LogHelper.self().error(getClass().getSimpleName(), aa);
          new Exception(line);
        }

        try {
          field.setAccessible(true);

          if (value.isEmpty())
            value = annotation.defaultValue();

          if (field.getGenericType().equals(Integer.class))
            field.set(this, Integer.parseInt(value));
          else if (field.getGenericType().equals(String.class))
            field.set(this, value);
          else if (field.getGenericType().equals(BigDecimal.class))
            field.set(this, new BigDecimal(value).divide(new BigDecimal(divisor)));
          else if (field.getGenericType().equals(Long.class))
            field.set(this, Long.parseLong(value));
          else if (field.getGenericType().equals(Float.class))
            field.set(this, Float.parseFloat(value) / divisor);
          else if (field.getGenericType().equals(Long.class))
            field.set(this, Long.parseLong(value) / divisor);
          else if (field.getGenericType().equals(Double.class))
            field.set(this, Double.parseDouble(value) / divisor);
          else if (field.getGenericType().equals(Date.class)) {
            if (value.isEmpty())
              value = annotation.defaultValue();

            if (!value.isEmpty()) {
              Date d = UtilHelper.convertToDate(value, annotation.dateFormat());
              //Desprezando data invalida que veio com inconsistencia na carga do preorder
              if (d.after(new Date(0)))
                field.set(this, d);
            }
          }
        } catch (IllegalAccessException x) {
          System.out.println(field.getName() + " | " + line);
          x.printStackTrace();
        } catch (Exception a) {
          System.out.println(field.getName() + " | " + line);
          a.printStackTrace();
          throw a;
        }
      }
    }
  }

  public String automaticParseOut() {
    StringBuilder sb = new StringBuilder();

    sb.append(UtilHelper.padLeft("", ' ', 500));

    Field[] fields = getClass().getDeclaredFields();

    for (Field field : fields) {
      if (field.isAnnotationPresent(MappingOut.class)) {
        MappingOut annotation = field.getAnnotation(MappingOut.class);

        field.setAccessible(true);
        int ini = annotation.initialPos();
        int fim = annotation.finalPos();
        String dtFormat = annotation.dateFormat();
        char charComplete = annotation.charComplete();

        OrientationType orientationType = annotation.orientation();

        try {
          Object value = field.get(this);

          if (value == null)
            value = "";

          if (field.getGenericType().equals(Date.class))
            value = UtilHelper.formatDateStr(value, dtFormat);

          if (field.getGenericType().equals(Double.class)) {
            value = UtilHelper.formatDoubleString(UtilHelper.convertToDoubleDef(
              value.toString(), 0), annotation.decimals());
          }

          value = value.toString().replace(".", "");

          if (orientationType.equals(OrientationType.LEFT))
            value = UtilHelper.padLeft(value.toString(), charComplete, (fim - ini));
          else
            value = UtilHelper.padRight(value.toString(), charComplete, (fim - ini));

          sb.replace(ini, fim, value.toString());
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }

    return sb.toString().trim();
  }


  public abstract boolean isValid();

  public abstract void save();

  public abstract void deleteAll();
}