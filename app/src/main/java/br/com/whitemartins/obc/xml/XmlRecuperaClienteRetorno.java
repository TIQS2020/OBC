package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Root;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.model.ConversaoLQ;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.Message;
import br.com.whitemartins.obc.model.Patient;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.model.Price;
import br.com.whitemartins.obc.model.Tax;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.PathHelper;
import br.com.whitemartins.obc.util.SaldoHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

@Root(name = "CLIENTESRESPONSE")
public class XmlRecuperaClienteRetorno extends XmlBase {

  public static final String fileName = "XmlRecuperaClienteRetorno";
  private static final String NODE_CLIENTESRESPONSE = "CLIENTESRESPONSE";

  private final String TAG = "XmlRecuperaClienteRetorno";
  @XmlMapping(xmlTagName = "CUSTOMER", xmlParentTagName = NODE_CLIENTESRESPONSE)
//  @Element(name = "CUSTOMER")
  public List<String> customer;
  @XmlMapping(xmlTagName = "WMPRICE", xmlParentTagName = NODE_CLIENTESRESPONSE)
  public List<String> wmprice;
  @XmlMapping(xmlTagName = "MESSAGE", xmlParentTagName = NODE_CLIENTESRESPONSE)
  public List<String> message;
  @XmlMapping(xmlTagName = "PREORDER", xmlParentTagName = NODE_CLIENTESRESPONSE)
  public List<String> preorder;
  @XmlMapping(xmlTagName = "CONVERSAO", xmlParentTagName = NODE_CLIENTESRESPONSE)
  public List<String> conversao;
  @XmlMapping(xmlTagName = "NEWTAX", xmlParentTagName = NODE_CLIENTESRESPONSE)
  public List<String> newtax;
  @XmlMapping(xmlTagName = "STATUS", xmlParentTagName = NODE_CLIENTESRESPONSE)
  public String status;
  @XmlMapping(xmlTagName = "MENSAGEMEXPLICATIVA", xmlParentTagName = NODE_CLIENTESRESPONSE)
  public String mensagemExplicativa;
  @XmlMapping(xmlTagName = "guid", xmlParentTagName = NODE_CLIENTESRESPONSE)
  private String guid;
  @XmlMapping(xmlTagName = "CODIGOFILIAL", xmlParentTagName = NODE_CLIENTESRESPONSE)
  private String cdFilial;
  @XmlMapping(xmlTagName = "DATAVIAGEM", xmlParentTagName = NODE_CLIENTESRESPONSE)
  private String dataViagem;
  @XmlMapping(xmlTagName = "NUMVIAGEM", xmlParentTagName = NODE_CLIENTESRESPONSE)
  private String numeroViagem;
  @XmlMapping(xmlTagName = "TIPOVIAGEM", xmlParentTagName = NODE_CLIENTESRESPONSE)
  private String tipoViagem;
  @XmlMapping(xmlTagName = "CODIGOCLIENTE", xmlParentTagName = NODE_CLIENTESRESPONSE)
  private String cdCustomer;
  @XmlMapping(xmlTagName = "IMEI", xmlParentTagName = NODE_CLIENTESRESPONSE)
  private String imei;
  @XmlMapping(xmlTagName = "PACIENTE", xmlParentTagName = NODE_CLIENTESRESPONSE)
  private String paciente;

  public XmlRecuperaClienteRetorno() {
    customer = new ArrayList<>();
    wmprice = new ArrayList<>();
    message = new ArrayList<>();
    preorder = new ArrayList<>();
    conversao = new ArrayList<>();
    newtax = new ArrayList<>();
    status = ConstantsEnum.NO.getValue();
    mensagemExplicativa = "";
  }

  public static XmlRecuperaClienteRetorno newInstance() {
    return new XmlRecuperaClienteRetorno();
  }

  public List<String> getCustomer() {
    return customer;
  }

  public void setCustomer(List<String> customer) {
    this.customer = customer;
  }

  public List<String> getWmprice() {
    return wmprice;
  }

  public void setWmprice(List<String> wmprice) {
    this.wmprice = wmprice;
  }

  public List<String> getMessage() {
    return message;
  }

  public void setMessage(List<String> message) {
    this.message = message;
  }

  public List<String> getPreorder() {
    return preorder;
  }

  public void setPreorder(List<String> preorder) {
    this.preorder = preorder;
  }

  public List<String> getConversao() {
    return conversao;
  }

  public void setConversao(List<String> conversao) {
    this.conversao = conversao;
  }

  public List<String> getNewtax() {
    return newtax;
  }

  public void setNewtax(List<String> newtax) {
    this.newtax = newtax;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMensagemExplicativa() {
    return mensagemExplicativa;
  }

  public void setMensagemExplicativa(String mensagemExplicativa) {
    this.mensagemExplicativa = mensagemExplicativa;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public String getCdFilial() {
    return cdFilial;
  }

  public void setCdFilial(String cdFilial) {
    this.cdFilial = cdFilial;
  }

  public String getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(String dataViagem) {
    this.dataViagem = dataViagem;
  }

  public String getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(String numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public String getTipoViagem() {
    return tipoViagem;
  }

  public void setTipoViagem(String tipoViagem) {
    this.tipoViagem = tipoViagem;
  }

  public String getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(String cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public String getImei() {
    return imei;
  }

  public void setImei(String imei) {
    this.imei = imei;
  }

  public String getPaciente() {
    return paciente;
  }

  public void setPaciente(String paciente) {
    this.paciente = paciente;
  }

  public void parseAndSaveOnDb() {
    LogHelper.self().info("parseAndSaveOnDb iniciado.");

    try {
      parse(new File(PathHelper.self().getFilePathDownload(), fileName
        + "_" + GLOBAL.self().getRoute().getNumeroViagem() + ".xml"));

      Customer customer = Customer.newInstance();
      for (String s : getCustomer()) {
        customer.parseLine(s);
        customer.save();
      }

      LogHelper.self().info("parseAndSaveOnDb Customer.");

      if (!getPaciente().trim().isEmpty()) {
        Patient patient = Patient.newInstance();
        patient.parseLine(getPaciente());
        patient.save();
      }
      LogHelper.self().info("parseAndSaveOnDb Patient.");

      Price p = Price.newInstance();
      for (String s : getWmprice()) {
        p.parseLine(s);
        p.save();
      }
      LogHelper.self().info("parseAndSaveOnDb Price.");

      Tax tax = Tax.newInstance();
      for (String s : getNewtax()) {
        tax.parseLine(s);
        tax.save();
      }
      LogHelper.self().info("parseAndSaveOnDb Tax.");

      PreOrder preOrder = PreOrder.newInstance();
      for (String s : getPreorder()) {
        preOrder.parseLine(s);
        preOrder.save();

        List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao()
          .find(preOrder.getNumeroNotaOrigem());

        invoices.forEach(invoice -> {
          if (!invoice.isCanceled()) {
            invoice.setItens(DatabaseApp.self().getDatabase().invoiceItemDao()
              .findByIdNota(invoice.getId()));

            //Atualizando a preordem do cliente
            for (InvoiceItem invoiceItem : invoice.getItens()) {
              SaldoHelper.self().atualizarSaldoPreOrder(invoiceItem.getCdItem(),
                invoiceItem.getQuantidadeCilindroVendida(), preOrder.getNumeroNotaOrigem());
            }
          }
        });
      }

      LogHelper.self().info("parseAndSaveOnDb PreOrder.");

      List<Message> messages = DatabaseApp.self().getDatabase().messageDao().find(customer.getCdCustomer());
      messages.forEach(message1 -> message1.delete());

      Message message = Message.newInstance();
      for (String s : getMessage()) {
        message.parseLine(s);
        message.save();
      }

      LogHelper.self().info("parseAndSaveOnDb Message.");

      ConversaoLQ conversaoLQ = ConversaoLQ.newInstance();
      for (String s : getConversao()) {
        conversaoLQ.parseLine(s);
        conversaoLQ.save();
      }

      LogHelper.self().info("parseAndSaveOnDb ConversaoLQ.");


      LogHelper.self().info("parseAndSaveOnDb finalizado.");

    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
    }
  }

  @Override
  public String getName() {
    return getClass().getSimpleName() + "_" + getNumeroViagem();
  }

}
