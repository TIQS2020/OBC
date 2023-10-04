package br.com.whitemartins.obc.enumeration;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;

public enum StatusNFeType {
  PENDENTE_ENVIO(0, "Pend. Envio", R.color.appTextColor),
  AGUARDANDO_PROCESSAMENTO(1, "Aguardando Processamento", R.color.appTextColor),
  PROCESSANDO(2, "Processando", R.color.appTextColor),
  PROCESSAMENTO_REJEITADO(3, "Proc. Rejeitado", R.color.red),
  PROCESSAMENTO_USUARIO(4, "Proc. Usuário", R.color.appTextColor),
  AUTORIZADA(5, "Autorizada", R.color.pressed_color),
  REJEITADA(6, "Rejeitada", R.color.red),
  DENEGADA(7, "Denegada", R.color.red),
  RECEBIDA_PROCESSADA(8, "Recebida Processada", R.color.appTextColor),
  PENDENTE_CANCELAMENTO(9, "Pend. Canc.", R.color.appTextColor),
  IMAGEM_ENVIADA(98, "Imagem enviada", R.color.appTextColor),
  STATUS_INVALIDO(99, "", R.color.appTextColor);

  private Integer value;
  private String name;
  private int color;

  StatusNFeType(final Integer value, final String name, int color) {
    this.value = value;
    this.name = name;
    this.color = color;
  }

  public static String getNameByValue(Integer value) {
    return getByValue(value).getName();
  }

  public static StatusNFeType getByValue(Integer value) {

    for (StatusNFeType st : values())
      if (st.getValue().equals(value))
        return st;

    return PENDENTE_ENVIO;
  }

  public static List<Integer> build(StatusNFeType... statusNFeTypes) {
    List<Integer> types = new ArrayList<>();

    for (StatusNFeType statusNFeType : statusNFeTypes) {
      types.add(statusNFeType.getValue());
    }

    return types;
  }

  public static boolean isFinalStatus(Integer status) {
    return (status.equals(AUTORIZADA.getValue())
        || status.equals(REJEITADA.getValue())
        || status.equals(PROCESSAMENTO_REJEITADO.getValue())
        || status.equals(DENEGADA.getValue()));
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public int getColor() {
    return color;
  }
}
