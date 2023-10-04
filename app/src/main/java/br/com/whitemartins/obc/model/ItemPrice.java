package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

import br.com.whitemartins.obc.enumeration.ClasseContribType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.CstType;
import br.com.whitemartins.obc.enumeration.CustomerType;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.PressureType;
import br.com.whitemartins.obc.enumeration.TaxingType;
import br.com.whitemartins.obc.enumeration.UfType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.UtilHelper;

public class ItemPrice implements Serializable {

  private static final long serialVersionUID = 1L;

  @Ignore
  private SuperOperation superOperation;

  @Embedded
  private Price price;
  @Embedded(prefix = "it_")
  private Item item;
  @Embedded(prefix = "rt_")
  private Route route;

  private Double quantidadeVendida;
  private String infCilindroPP;
  private Double valorUnitario;
  private Double frete;
  private Double despesas;
  private String condicaoPagamento;
  //  private Double percIpi;
//  private Double percPis;
//  private Double percCofins;
  private String pedidoCustomer;
  private String itemPedidoCustomer;
  private String assistTecnica;
  private String altPreco;

  public ItemPrice() {
    quantidadeVendida = 0D;
    infCilindroPP = "";
    pedidoCustomer = "";
    itemPedidoCustomer = "";
    frete = 0D;
    despesas = 0D;
    valorUnitario = 0D;
    altPreco = ConstantsEnum.NO.getValue();
    assistTecnica = ConstantsEnum.NO.getValue();
  }

  public static int getTipoIcmsInvoice(@NonNull SuperOperation operation, @NonNull Customer customer) {
    if (OperationType.APL.equals(operation.getOperationType())
        || OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
        || (CustomerType.ORGAO_PUBLICO.getValue().equals(customer.getDescontoIcmsOrgaoPublico()))
    )
      return TaxingType.ISENTO.getValue();
    else
      return customer.getSituacaoTributariaIcms();
  }

  public static int getTipoIpiInvoice(@NonNull SuperOperation operation, @NonNull Customer customer) {
    if (OperationType.APL.equals(operation.getOperationType())
        || OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
    )
      return TaxingType.ISENTO.getValue();
    else if (OperationType.FUT.equals(operation.getOperationType()))
      return TaxingType.OUTROS.getValue();
    else
      return customer.getSituacaoTributariaIpi();
  }

  public SuperOperation getSuperOperation() {
    return superOperation;
  }

  public void setSuperOperation(SuperOperation superOperation) {
    this.superOperation = superOperation;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Route getRoute() {
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
  }

  public Double getQuantidadeVendida() {
    return quantidadeVendida;
  }

  public void setQuantidadeVendida(Double quantidadeVendida) {
    this.quantidadeVendida = quantidadeVendida;
  }

  public Double getQuantidade(SuperOperation operation) {
    if (operation.getUnidadeFixa())
      return getQuantidadeVendida();
    else
      return getVolume(operation);
  }

  public Double getVolume(SuperOperation operation) {
    Double v;
    if (operation.getUnidadeFixa())
      v = 1 * getQuantidadeVendida();
    else
      v = getItem().getCapacidadeProduto() * getQuantidadeVendida();

    return UtilHelper.formatDouble(v, 2);
  }

  public String getInfCilindroPP() {
    return infCilindroPP;
  }

  public void setInfCilindroPP(String infCilindroPP) {
    this.infCilindroPP = infCilindroPP;
  }

  public String getAssistTecnica() {
    return assistTecnica;
  }

  public void setAssistTecnica(String assistTecnica) {
    this.assistTecnica = assistTecnica;
  }

  public String getAltPreco() {
    return altPreco;
  }

  public void setAltPreco(String altPreco) {
    this.altPreco = altPreco;
  }

  public String getUnidadeMedida(SuperOperation operation) {

    if (operation.getUnidadeFixa())
      return ConstantsEnum.UN.getValue();
    else
      return getItem().getUnidadeMedida();
  }

  public Double getValorUnitario() {

    valorUnitario = getItem().getValorIndenizacao();

    if (price != null)
      valorUnitario = price.getPrecoUnitario();
    else if (PressureType.ALTA.getValue().equals(item.getTipoPressao()))
      valorUnitario = GLOBAL.self().getRoute().getValorIndenizacaoAlta();
    else if (PressureType.BAIXA.getValue().equals(item.getTipoPressao()))
      valorUnitario = GLOBAL.self().getRoute().getValorIndenizacaoBaixa();

    if (superOperation != null && OperationType.CPL.equals(superOperation.getOperationType()))
      return 0D;

    return UtilHelper.formatDouble(valorUnitario, 4);
  }

  public void setValorUnitario(Double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public Double getFrete() {
    frete = 0D;

    if (OperationType.CPL.equals(superOperation.getOperationType()))
      return 0D;

    if (price != null)
      frete = UtilHelper.formatDouble(price.getValorFrete(), 4);

    return frete;
  }

  public void setFrete(Double frete) {
    this.frete = frete;
  }

  public Double getDespesas() {
    despesas = 0D;

    if (OperationType.CPL.equals(superOperation.getOperationType()))
      return 0D;

    if (price != null)
      despesas = UtilHelper.formatDouble(price.getValorDespesas(), 4);

    return despesas;
  }

  public void setDespesas(Double despesas) {
    this.despesas = despesas;
  }

  public String getCondicaoPagamento() {
    condicaoPagamento = "0";

    if (price != null)
      condicaoPagamento = getPrice().getCondicaoFaturamento();

    return condicaoPagamento;
  }

  public void setCondicaoPagamento(String condicaoPagamento) {
    this.condicaoPagamento = condicaoPagamento;
  }

  public String getCondicaoPagamento(SuperOperation operation) {
    condicaoPagamento = ConstantsEnum._0.getValue();

    if ((operation.getOperationType().equals(OperationType.FUT))
        || (operation.getOperationType().equals(OperationType.APL))
        || (operation.getOperationType().equals(OperationType.RCL))
        || (operation.getOperationType().equals(OperationType.APLHC))
        || (operation.getOperationType().equals(OperationType.RCLNF))
        || (operation.getOperationType().equals(OperationType.RCLHC))
    )
      return "";

    if (operation.getOperationType().equals(OperationType.VOR))
      return ConstantsEnum._990.getValue();

    if (price != null)
      condicaoPagamento = price.getCondicaoFaturamento();

    return condicaoPagamento;
  }

  public String getPedidoCustomer() {
    return pedidoCustomer;
  }

  public void setPedidoCustomer(String pedidoCustomer) {
    this.pedidoCustomer = pedidoCustomer;
  }

  public String getItemPedidoCustomer() {
    return itemPedidoCustomer;
  }

  public void setItemPedidoCustomer(String itemPedidoCustomer) {
    this.itemPedidoCustomer = itemPedidoCustomer;
  }

  public Double getValorTotalProduto(SuperOperation operation) {
    Double v = getValorUnitario() * getVolume(operation);
    return UtilHelper.formatDouble(v, 2);
  }

  public Double getValorTotalFrete(@NonNull SuperOperation operation) {
    double v = 0D;

    if (price != null)
      v = price.getValorFrete() * getQuantidade(operation);
    return UtilHelper.formatDouble(v, 2);
  }

  public Double getValorTotalDespesa(@NonNull SuperOperation operation) {
    //Retorna 0 para as operações diferentes de Vnd
    double v = 0d;

    if ((operation.getOperationType().equals(OperationType.VND))
        || (operation.getOperationType().equals(OperationType.RFH)))
      v = getDespesas() * (GLOBAL.self().isLiquido() ? 1 : getQuantidadeVendida());

    return UtilHelper.formatDouble(v, 2);
  }

  public String getTipoFaturamento(@NonNull SuperOperation operation, @NonNull Customer customer) {
    //Retorna 0 para as operações diferentes de Vnd
    String f = "";

    if (operation.getOperationType().equals(OperationType.RFH))
      f = customer.getFlNovoFaturamento();
    else if (price != null)
      f = price.getFlNovoFaturamento();

    if (f.equalsIgnoreCase(ConstantsEnum._00.getValue()))
      f = "";

    return f;
  }

  //  IMPOSTOS------------------------------------------------------------------------
  public Double getBaseCalculoIpi(@NonNull SuperOperation operation, @NonNull Customer customer) {
    double v = 0d;

    if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaIpi()))
      v = getValorTotalProduto(operation)
          + getValorTotalFrete(operation)
          + getValorTotalDespesa(operation);

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getValorIpi(@NonNull SuperOperation operation, @NonNull Customer customer) {
    Double v = getBaseCalculoIpi(operation, customer) * getAliquotaIpi(operation, customer) / 100;
    return UtilHelper.formatDouble(v, 2);
  }

  public Integer getTipoIcms(@NonNull SuperOperation operation, @NonNull Customer customer) {

    if (OperationType.APL.equals(operation.getOperationType())
        || OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
        || OperationType.VOR.equals(operation.getOperationType())
    )
      return TaxingType.ISENTO.getValue();
    else if (CustomerType.ORGAO_PUBLICO.getValue().equals(customer.getDescontoIcmsOrgaoPublico()))
      return TaxingType.DESCONTO_ORGAO_PUBLICO.getValue();
    else
      return customer.getSituacaoTributariaIcms();
  }

  public Integer getTipoIpi(@NonNull SuperOperation operation, @NonNull Customer customer) {

    if (OperationType.APL.equals(operation.getOperationType())
        || OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
        || OperationType.VOR.equals(operation.getOperationType())
    )
      return TaxingType.ISENTO.getValue();
    else if (OperationType.FUT.equals(operation.getOperationType()))
      return TaxingType.OUTROS.getValue();
    else
      return customer.getSituacaoTributariaIcms();
  }

  public String getCstBIcms(@NonNull SuperOperation operation, @NonNull InvoiceItem invoiceItem,
                            @NonNull Customer customer) {

    String cstBIcms = CstType._90.getValue();

    if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaIcms())) {
      if (invoiceItem.getValorIcms().equals(0d))
        cstBIcms = CstType._40.getValue();
      else {
        if (price.getPercReducaoIcms().equals(0d))
          cstBIcms = CstType._00.getValue();
        else {
          if (customer.getUf().equalsIgnoreCase(UfType.PR.getValue())) {
            if (OperationType.VND.equals(operation.getOperationType())
                || OperationType.RFH.equals(operation.getOperationType())
                || OperationType.FUT.equals(operation.getOperationType()))
              cstBIcms = CstType._90.getValue();

            if (OperationType.TRC.equals(operation.getOperationType())
                || OperationType.TRF.equals(operation.getOperationType()))
              cstBIcms = CstType._20.getValue();
          } else
            cstBIcms = CstType._20.getValue();
        }
      }
    } else if (TaxingType.ISENTO.getValue().equals(customer.getSituacaoTributariaIcms()))
      cstBIcms = CstType._40.getValue();
    else if (TaxingType.OUTROS.getValue().equals(customer.getSituacaoTributariaIcms()))
      cstBIcms = CstType._50.getValue();

    return cstBIcms;
  }

  public Double getAliquotaIcms(@NonNull SuperOperation operation, @NonNull Customer customer) {
    // será impressa na nota fiscal
    Double v = 0d;

    if (OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.APL.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
        || OperationType.VOR.equals(operation.getOperationType())
    )
      return v;

    //Devido a recepção do JDE recuperar os dados a partir da area de integração foi necessário
    //atribuir o valor para esta aliquota, independente da situacao tributaria do cliente
    v = price.getPercentualIcms();

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getAliquotaIpi(@NonNull SuperOperation operation, @NonNull Customer customer) {
    Double v = 0d;

    if (OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.APL.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
        || OperationType.VOR.equals(operation.getOperationType())
    )
      return v;

    //Ipi somente calulado para tipo 1 Tributável
    if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaIpi()))
      v = price.getPercentualIpi();

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getAliquotaPis(@NonNull SuperOperation operation, @NonNull Customer customer) {
    // será impressa na nota fiscal
    Double v = 0d;

    if (OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.APL.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
        || OperationType.VOR.equals(operation.getOperationType())
    )
      return v;

    // situação a) Isento
    if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaPis())) {
      v = price.getPercentualPis();
      // situação d) Desconto - Órgão Público
//      if (CustomerType.ORGAO_PUBLICO.getValue().equals(customer.getDescontoIcmsOrgaoPublico()))
//        return 0d;
    }

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getAliquotaCofins(@NonNull SuperOperation operation, @NonNull Customer customer) {
    // será impressa na nota fiscal
    Double v = 0d;

    if (OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.APL.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
        || OperationType.VOR.equals(operation.getOperationType())
    )
      return v;

    // situação a) Isento
    if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaCofins())) {
      v = price.getPercentualCofins();
      // situação d) Desconto - Órgão Público
//      if (CustomerType.ORGAO_PUBLICO.getValue().equals(customer.getDescontoIcmsOrgaoPublico()))
//        return 0d;
    }

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getBaseCalculoIcms(@NonNull SuperOperation operation, @NonNull Customer customer) {
    // para gravar no arquivo e também para totalizar na nota
    Double v = getValorTotalProduto(operation)
        + getValorTotalFrete(operation)
        + getValorTotalDespesa(operation);
    //+ getValorIpi(operation, customer);

    if (TaxingType.ISENTO.getValue().equals(customer.getSituacaoTributariaIcms()))
      v = getValorBaseIsentoIcms(operation, customer);
      //return 0d;
    else if (TaxingType.OUTROS.getValue().equals(customer.getSituacaoTributariaIcms()))
      v = getValorBaseIsentoIcms(operation, customer);
      //return 0d;
    else if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaIcms())) {
      // situação d) Desconto - Órgão Público
      if (CustomerType.ORGAO_PUBLICO.getValue().equals(customer.getDescontoIcmsOrgaoPublico()))
        v = getValorBaseDescontoIcms(operation, customer);
        //return 0d;
        // situação e) Redução na Base
      else if (price != null && price.getPercReducaoIcms() > 0) {
        v *= 1 - price.getPercReducaoIcms() / 100;
      }
    }

    //Dependendo da classe do cotribuinte, o IPI entra na base de cálculo
    if (!ClasseContribType.CONTRIB_NAO_CONSUMIDOR.getValue().equals(customer.getClasseContrib()))
      v += getValorIpi(operation, customer);

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getValorBaseDescontoIcms(@NonNull SuperOperation operation,
                                         @NonNull Customer customer) {
    Double v = getValorTotalProduto(operation)
        + getValorTotalFrete(operation)
        + getValorTotalDespesa(operation);

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getValorBaseReducaoIcms(@NonNull SuperOperation operation,
                                        @NonNull Customer customer) {
    Double v = 0d;

    if (OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.APL.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
        || price.getPercReducaoIcms() == 0
    )
      return v;

    //Somente calcula desconto para o clientes orgão publico
    //if (CustomerType.DESCONTO_ORGAO_PUBLICO.getValue().equals(customer.getDescontoIcmsOrgaoPublico())) {
    v = getValorTotalProduto(operation)
        + getValorTotalFrete(operation)
        + getValorTotalDespesa(operation);

    if (price.getPercReducaoIcms() > 0)
      v = v * (price.getPercReducaoIcms() / 100);

    //Dependendo da classe do cotribuinte, o IPI entra na base de cálculo
//    if (!ClasseContribType.CONTRIB_NAO_CONSUMIDOR.getValue().equals(customer.getClasseContrib()))
//      v += getValorIpi(operation, customer);

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getTotalItem(@NonNull SuperOperation operation, @NonNull Customer customer) {
    Double v = getValorTotalProduto(operation)
        + getValorTotalFrete(operation)
        + getValorIpi(operation, customer)
        + getValorTotalDespesa(operation)
        - getValorDescontoIcms(operation, customer);

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getValorDescontoIcms(@NonNull SuperOperation operation,
                                     @NonNull Customer customer) {

    Double v = 0d;
//
//    if (OperationType.RCLNF.equals(operation.getOperationType())
//      || OperationType.RCLHC.equals(operation.getOperationType())
//      || OperationType.RCL.equals(operation.getOperationType())
//      || OperationType.APL.equals(operation.getOperationType())
//      || OperationType.APLHC.equals(operation.getOperationType())
//    )
//      return v;

    if (OperationType.VND.equals(operation.getOperationType())
        || OperationType.FUT.equals(operation.getOperationType())
    ) {
      if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaIcms())) {
        // situação d) Desconto - Órgão Público
        if (CustomerType.ORGAO_PUBLICO.getValue().equals(customer.getDescontoIcmsOrgaoPublico()))
          v = getValorBaseDescontoIcms(operation, customer) * price.getPercentualIcms() / 100;
          //return 0d;
          // situação e) Redução na Base
        else v = 0d;
      }
    } else
      return v;

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getValorIcms(@NonNull SuperOperation operation, @NonNull Customer customer) {
    Double v = 0d;

    if (OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.APL.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
    )
      return v;

    if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaIcms())) {
      if (CustomerType.ORGAO_PUBLICO.getValue().equals(customer.getDescontoIcmsOrgaoPublico()))
        v = 0d;
      else
        v = getBaseCalculoIcms(operation, customer) * (getAliquotaIcms(operation, customer)) / 100;
    }

    return UtilHelper.formatDouble(v, 2);
  }

  private Double getValorBaseIsentoIcms(@NonNull SuperOperation operation,
                                        @NonNull Customer customer) {

    if (OperationType.RCLNF.equals(operation.getOperationType())
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.APL.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType())
    )
      return 0d;

    Double v = (1 - price.getPercReducaoIcms() / 100) * (getValorTotalProduto(operation) +
        getValorTotalFrete(operation) + getValorTotalDespesa(operation));

    //Dependendo da classe do cotribuinte, o IPI entra na base de cálculo
    if (!ClasseContribType.CONTRIB_NAO_CONSUMIDOR.getValue().equals(customer.getClasseContrib()))
      v += getValorIpi(operation, customer);

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getValorLiquido(@NonNull SuperOperation operation, @NonNull Customer customer) {

    Double v = getValorTotalProduto(operation)
        - getValorDescontoIcms(operation, customer);
//      - getValorIpi(operation, customer);

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getBaseCofins(@NonNull SuperOperation operation, @NonNull Customer customer) {

    Double v = getValorTotalProduto(operation)
        + getValorTotalFrete(operation)
        + getValorTotalDespesa(operation);

    if (!ClasseContribType.CONTRIB_NAO_CONSUMIDOR.getValue().equals(customer.getClasseContrib()))
      v += getValorIpi(operation, customer);

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getValorCofins(@NonNull SuperOperation operation, @NonNull Customer customer) {
    Double v = getBaseCofins(operation, customer) * getAliquotaCofins(operation, customer) / 100;

    return UtilHelper.formatDouble(v, 2);
  }

  public String getCstCofins(@NonNull SuperOperation operation, @NonNull Customer customer) {
    if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaCofins())) {
      if (operation.getOperationType().equals(OperationType.VND)) {
        return price.getCstCofins();
      } else if (InvoiceType.ENTRADA.equals(operation.getTipoNota()))
        return CstType._98.getValue();
      else
        return CstType._99.getValue();
    } else {
      return InvoiceType.ENTRADA.equals(operation.getTipoNota()) ?
          customer.getCstCofinsE() : customer.getCstCofinsS();
    }
  }

  public Double getBasePis(@NonNull SuperOperation operation, @NonNull Customer customer) {
    Double v = getValorTotalProduto(operation)
        + getValorTotalFrete(operation)
        + getValorTotalDespesa(operation);

    if (!ClasseContribType.CONTRIB_NAO_CONSUMIDOR.getValue().equals(customer.getClasseContrib()))
      v += getValorIpi(operation, customer);

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getValorPis(@NonNull SuperOperation operation, @NonNull Customer customer) {
    Double v = getBasePis(operation, customer) * getAliquotaPis(operation, customer) / 100;

    return UtilHelper.formatDouble(v, 2);
  }

  public String getCstPis(@NonNull SuperOperation operation, @NonNull Customer customer) {
    if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaPis())) {
      if (operation.getOperationType().equals(OperationType.VND)) {
        return price.getCstPis();
      } else if (InvoiceType.ENTRADA.equals(operation.getTipoNota()))
        return CstType._98.getValue();
      else
        return CstType._99.getValue();
    } else {
      return InvoiceType.ENTRADA.equals(operation.getTipoNota()) ?
          customer.getCstPisE() : customer.getCstPisS();
    }
  }

//IMPOSTOS FIM-----------------------------------------------------------------------

  public Long getNcm(@NonNull SuperOperation operation) {

    if (operation.getOperationType().equals(OperationType.APL)
        || operation.getOperationType().equals(OperationType.RCLNF)
        || OperationType.RCL.equals(operation.getOperationType())
        || OperationType.RCLHC.equals(operation.getOperationType())
        || OperationType.APLHC.equals(operation.getOperationType()))

      return getItem().getClasseNcmCilindro();
    else
      return getItem().getClasseNcmGas();
  }

  @Override
  public String toString() {
    return String.format(Locale.getDefault(), "Item: %d Capacidade: %s\n%s",
        getItem().getCdItem(),
        getItem().getCapacidadeProduto(),
        getItem().getDescricaoProduto());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ItemPrice itemPrice = (ItemPrice) o;
    return (item.getCdItem().equals(itemPrice.item.getCdItem())
        && (item.getCapacidadeProduto().equals(itemPrice.item.getCapacidadeProduto())));
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, item);
  }


}
