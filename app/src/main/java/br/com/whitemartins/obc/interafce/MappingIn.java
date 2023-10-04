package br.com.whitemartins.obc.interafce;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface MappingIn {
  int initialPos() default 0;

  int finalPos() default 0;

  int decimals() default 0;

  String defaultValue() default "";

  String dateFormat() default "";

  boolean suppress() default false;

}
