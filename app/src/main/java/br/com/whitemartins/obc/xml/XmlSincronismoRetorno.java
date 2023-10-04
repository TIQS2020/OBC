package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Patient;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.model.WantedClient;
import br.com.whitemartins.obc.model.sync.NotasFiscais;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;


@Root
public class XmlSincronismoRetorno extends XmlBase {

  @Element(name = "cd_filial", required = false)
  private String cdFilial;
  @Element(name = "dt_viagem", required = false)
  private String dataViagem;
  @Element(name = "num_viagem", required = false)
  private String numeroViagem;
  @Element(name = "status", required = false)
  private String status;
  @ElementList(name = "notasFiscais", inline = true, required = false)
  private List<NotasFiscais> notasFiscais;

  private XmlSincronismoRetorno() {
    status = "";
    notasFiscais = new ArrayList<>();
  }

  public static XmlSincronismoRetorno newInstance() {
    return new XmlSincronismoRetorno();
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<NotasFiscais> getNotasFiscais() {
    return notasFiscais;
  }

  public void setNotasFiscais(List<NotasFiscais> notasFiscais) {
    this.notasFiscais = notasFiscais;
  }

  public List<WantedClient> validateCustomer() {
    List<WantedClient> cdCustomers = new ArrayList<>();

    for (NotasFiscais nota : notasFiscais) {
      Long cdCustomer = nota.getCabecalhoNFe().getCdCustomer();

      WantedClient wantedClient = WantedClient.newInstace();
      wantedClient.setCdCustomer(cdCustomer);
      wantedClient.setNumeroViagem(getNumeroViagem());
      wantedClient.setDataViagem(UtilHelper.convertToDate(getDataViagem(),
        ConstantsEnum.yyyyMMdd.getValue()));

      Customer customer = DatabaseApp.self().getDatabase().customerDao().findById(cdCustomer);
      Patient patient = DatabaseApp.self().getDatabase().patientDao().findById(cdCustomer);

      if (customer == null && patient == null)
        cdCustomers.add(wantedClient);

      if (!"".equalsIgnoreCase(nota.getCabecalhoNFe().getDownloaderNFe().getNumeroFutEntrega())) {

        List<PreOrder> preOrders = DatabaseApp.self().getDatabase().preOrderDao().find(cdCustomer);

        if (preOrders.isEmpty())
          cdCustomers.add(wantedClient);
      }
    }

    return cdCustomers;
  }

  @Override
  public String getName() {
    return getClass().getSimpleName() + "_" + getNumeroViagem();
  }
}
