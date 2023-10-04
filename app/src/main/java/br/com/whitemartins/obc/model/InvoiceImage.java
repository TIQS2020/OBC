package br.com.whitemartins.obc.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Locale;

import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
public class InvoiceImage extends MockRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  @PrimaryKey
  private Long idNota;
  private Integer status;
  private String cec;
  private String assinatura;

  public static InvoiceImage newInstance() {
    return new InvoiceImage();
  }

  public Long getIdNota() {
    return idNota;
  }

  public void setIdNota(Long idNota) {
    this.idNota = idNota;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getCec() {
    return cec;
  }

  public void setCec(String cec) {
    this.cec = cec;
  }

  public String getAssinatura() {
    return assinatura;
  }

  public void setAssinatura(String assinatura) {
    this.assinatura = assinatura;
  }

  @Override
  public void parseLine(String line) {

  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    if (isValid())
      DatabaseApp.self().getDatabase().invoiceImageDao().insert(this);
  }

  @Override
  public void deleteAll() {
    DatabaseApp.self().getDatabase().invoiceImageDao()
      .deleteAll(DatabaseApp.self().getDatabase().invoiceImageDao().getAll());
  }

  @Override
  public String toString() {
    Invoice invoice = DatabaseApp.self().getDatabase().invoiceDao().findById(idNota);

    return String.format(Locale.getDefault(), "%s%s",
      UtilHelper.padRight(invoice.getNumero().toString(), ' ', 6),
      StatusNFeType.getNameByValue(getStatus()));
  }
}
