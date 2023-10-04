package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import br.com.whitemartins.obc.dao.PreOrderDao;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity(primaryKeys = {"cdPreOrder", "cdCustomer", "cdItem"})
@FileInfo(lineLength = 147)
public class PreOrder extends MockRecord implements Serializable {

  public static final Long serialVersionUID = 1L;
  @NonNull
  @MappingIn(initialPos = 0, finalPos = 8)
  private Long cdPreOrder;
  @MappingIn(initialPos = 8, finalPos = 16, dateFormat = "ddMMyyyy")
  @TypeConverters({DateTypeConverter.class})
  private Date dataEmissaoNota;
  @MappingIn(initialPos = 16, finalPos = 24)
  @NonNull
  private Long cdCustomer;
  @MappingIn(initialPos = 24, finalPos = 46)
  private String numeroNotaOrigem;
  @MappingIn(initialPos = 64, finalPos = 74)
  @NonNull
  private Long cdItem;
  @MappingIn(initialPos = 74, finalPos = 79, decimals = 2)
  private Double capacidadeProduto;
  @MappingIn(initialPos = 99, finalPos = 109, decimals = 2)
  private Double saldo;
  @MappingIn(initialPos = 109, finalPos = 123, decimals = 4)
  private Double preco;
  @MappingIn(initialPos = 142, finalPos = 147, decimals = 2)
  private Double ajusteICMS;

  public PreOrder() {
    cdPreOrder = 0L;
    cdCustomer = 0L;
    preco = 0D;
    capacidadeProduto = 0D;
    ajusteICMS = 0D;
    numeroNotaOrigem = null;
  }

  public static PreOrder newInstance() {
    return new PreOrder();
  }

  public Long getCdPreOrder() {
    return cdPreOrder;
  }

  public void setCdPreOrder(Long cdPreOrder) {
    this.cdPreOrder = cdPreOrder;
  }

  public Date getDataEmissaoNota() {
    return dataEmissaoNota;
  }

  public void setDataEmissaoNota(Date dataEmissaoNota) {
    this.dataEmissaoNota = dataEmissaoNota;
  }

  @NonNull
  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(@NonNull Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public String getNumeroNotaOrigem() {
    return numeroNotaOrigem;
  }

  public void setNumeroNotaOrigem(String numeroNotaOrigem) {
    this.numeroNotaOrigem = numeroNotaOrigem;
  }

  public Long getCdItem() {
    return cdItem;
  }

  public void setCdItem(Long cdItem) {
    this.cdItem = cdItem;
  }

  public Double getCapacidadeProduto() {
    return capacidadeProduto;
  }

  public void setCapacidadeProduto(Double capacidadeProduto) {
    this.capacidadeProduto = capacidadeProduto;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public Double getAjusteICMS() {
    return ajusteICMS;
  }

  public void setAjusteICMS(Double ajusteICMS) {
    this.ajusteICMS = ajusteICMS;
  }

  @Override
  public String toString() {
    String dt = "";
    if (dataEmissaoNota != null)
      dt = UtilHelper.formatDateStr(dataEmissaoNota, ConstantsEnum.ddMMyyyy_barra.getValue());

    return String.format(Locale.getDefault(), "Seq: %s Data: %s\nNota: %s",
      UtilHelper.padRight(cdPreOrder.toString(), ' ', 4),
      dt, UtilHelper.padRight(numeroNotaOrigem, ' ', 24)
    );
  }

  @Override
  public void parseLine(String line) {
    this.automaticParseIn(line);
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    DatabaseApp.self().getDatabase().preOrderDao().insert(this);
  }

  @Override
  public void deleteAll() {
    PreOrderDao dao = DatabaseApp.self().getDatabase().preOrderDao();
    dao.deleteAll(dao.getAll());
  }
}
