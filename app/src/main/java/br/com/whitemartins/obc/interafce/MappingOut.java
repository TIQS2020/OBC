package br.com.whitemartins.obc.interafce;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import br.com.whitemartins.obc.enumeration.OrientationType;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface MappingOut {
  int initialPos() default 0;

  int finalPos() default 0;

  OrientationType orientation() default OrientationType.RIGHT;

  String dateFormat() default "ddMMyyyyHHmmss";

  char charComplete() default ' ';

  int decimals() default 2;
}
