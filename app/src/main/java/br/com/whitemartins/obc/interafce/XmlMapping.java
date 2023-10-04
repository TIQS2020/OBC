package br.com.whitemartins.obc.interafce;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface XmlMapping {
  String xmlTagName();
  String xmlParentTagName();
  String dateFormat() default "";
  boolean cdatatag() default false;
  boolean suppress() default false;

//  String separator() default ";";

}
