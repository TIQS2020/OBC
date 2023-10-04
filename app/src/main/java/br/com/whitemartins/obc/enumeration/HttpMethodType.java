package br.com.whitemartins.obc.enumeration;

public enum HttpMethodType {
  POST("POST"),
  GET("GET");

  private String value;

  HttpMethodType(final String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
