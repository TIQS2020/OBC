package br.com.whitemartins.obc.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;
import java.util.Locale;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.util.UtilHelper;

public class WantedClient {

  private Long cdCustomer;
  private String numeroViagem;
  private Date dataViagem;

  public static WantedClient newInstace() {
    return new WantedClient();
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public String getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(String numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public Date getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(Date dataViagem) {
    this.dataViagem = dataViagem;
  }

  @Override
  public boolean equals(@Nullable Object obj) {
    WantedClient o = (WantedClient) obj;
    return this.getCdCustomer().equals(o.getCdCustomer());
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }

  @NonNull
  @Override
  public String toString() {
    return String.format(Locale.getDefault(), "%d %s %s", cdCustomer, numeroViagem,
      UtilHelper.formatDateStr(dataViagem, ConstantsEnum.ddMMyyyy_barra.getValue()));
  }
}
