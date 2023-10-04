package br.com.whitemartins.obc.model;

import org.json.JSONException;
import org.json.JSONObject;


public class HttpResponse {
  private static HttpResponse _self;
  //    { code: 2, desc: 'Chave de Ativação Inválida!'}
  private Integer code;
  private String desc;

  public HttpResponse() {
    code = 0;
    desc = "";
  }

  public static HttpResponse self() {
    if (_self == null)
      _self = new HttpResponse();

    return _self;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public void readJson(String json) throws JSONException {
    JSONObject reader = new JSONObject(json);
    code = reader.getInt("code");
    desc = reader.getString("desc");
  }
}