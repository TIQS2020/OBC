package br.com.whitemartins.obc.global;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.dao.CustomerDao;
import br.com.whitemartins.obc.dao.GeneralDao;
import br.com.whitemartins.obc.dao.RouteDao;
import br.com.whitemartins.obc.dao._StaticDao;
import br.com.whitemartins.obc.enumeration.CecType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.CustomerListType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.General;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.model.Patient;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.model.Route;
import br.com.whitemartins.obc.model._StaticTable;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.service.InvoiceBackgroundService;
import br.com.whitemartins.obc.service.InvoiceImageBackgroundService;
import br.com.whitemartins.obc.util.Constants;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public class GLOBAL {
  private static GLOBAL _self;
  private final InvoiceBackgroundService invoiceBackgroundService;
  private final InvoiceImageBackgroundService invoiceImageBackgroundService;
  //Quando for true, sinaliza que foi emitida uma nota fiscal e não permite que o sistema mostre a
  //tela de motivo de saida do cliente, caso não tenha sido emitido pedido
  private boolean pedidoRealizado;
  private boolean transfer;
  //Quando for true, houve um boot no momento do envio/consulta de nota fiscal e será necessário o
  //envio/consulta seja feito no Contuinuar Viagem em Andamento
  private boolean automaticSend;
  private _StaticTable _staticTable;
  private Customer customer;
  private Customer customerService;
  private Patient patient;
  private General general;
  private Route route;
  private SuperOperation operation;
  private String versao;
  private TypeItemType tipoItem;
  private String imei;
  private String tipoRcl;
  private PreOrder preOrder;
  private String invoiceVOR;
  private final List<ItemPrice> prices;
  private Invoice invoice;
  private Activity globalActivity;
  private CustomerListType customerListType;

  public GLOBAL() {
    imei = "";
    tipoItem = TypeItemType.GAS;
    prices = new ArrayList<>();
    preOrder = PreOrder.newInstance();
    invoiceVOR = "";

    invoiceImageBackgroundService = new InvoiceImageBackgroundService();
    invoiceBackgroundService = new InvoiceBackgroundService();
  }

  public static GLOBAL self() {
    if (_self == null)
      _self = new GLOBAL();

    _self.versao = Constants.APP_VERSION;

    return _self;
  }

  public InvoiceImageBackgroundService getInvoiceImageBackgroundService() {
    return invoiceImageBackgroundService;
  }

  public InvoiceBackgroundService getInvoiceBackgroundService() {
    return invoiceBackgroundService;
  }

  public Invoice getInvoice() {
    return invoice;
  }

  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
  }

  public boolean isPedidoRealizado() {
    return pedidoRealizado;
  }

  public void setPedidoRealizado(boolean pedidoRealizado) {
    this.pedidoRealizado = pedidoRealizado;
  }

  public Activity getGlobalActivity() {
    return globalActivity;
  }

  public void setGlobalActivity(Activity globalActivity) {
    this.globalActivity = globalActivity;
  }

  public CustomerListType getCustomerListType() {
    return customerListType;
  }

  public void setCustomerListType(CustomerListType customerListType) {
    this.customerListType = customerListType;
  }

  public boolean isTransfer() {
    return transfer;
  }

  public void setTransfer(boolean transfer) {
    this.transfer = transfer;
  }

  public boolean isAutomaticSend() {
    return automaticSend;
  }

  public void setAutomaticSend(boolean automaticSend) {
    this.automaticSend = automaticSend;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Customer getCustomerService() {
    return customerService;
  }

  public void setCustomerService(Customer customerService) {
    this.customerService = customerService;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Patient isPaciente(Long codigo) {
    setPatient(null);
    Patient p = Patient.newInstance();
    p.setCdPaciente(codigo);
    p = p.isPaciente();

    if (p != null) {
      setPatient(p);
      CustomerDao customerDao = DatabaseApp.self().getDatabase().customerDao();
      Customer c = customerDao.findById(p.getCdJDEOperadora());
      setCustomer(c);
    }

    return p;
  }

  public General getGeneral() {
    if (general == null) {
      GeneralDao dao = DatabaseApp.self().getDatabase().generalDao();
      general = dao.getGeneral();

      if (general == null)
        general = new General();
    }

    return general;
  }

  public void setGeneral(General general) {
    this.general = general;
  }

  public _StaticTable getStaticTable() {
    if (_staticTable == null) {
      _StaticDao dao = DatabaseApp.self().getStaticDatabase().staticDao();
      _staticTable = dao.find();

      if (_staticTable == null)
        _staticTable = _StaticTable.newInstance();
    }

    return _staticTable;
  }

  public Route getRoute() {
    if (route == null) {
      RouteDao dao = DatabaseApp.self().getDatabase().routeDao();
      route = dao.getRoute();
    }
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
  }

  public SuperOperation getOperation() {
    return operation;
  }

  public void setOperation(SuperOperation operation) {
    this.operation = operation;

    if (operation.getOperationType().equals(OperationType.RPS)) {
      customerService = customer;
      GLOBAL.self().setCustomerService(GLOBAL.self().getCustomer());

      customer = DatabaseApp.self().getDatabase().customerDao()
          .findById(UtilHelper.convertToLongDef(GLOBAL.self().getRoute().getCdCompanhia(), 0));
    } else {
      if (customerService != null)
        customer = customerService;

      customerService = null;
    }
  }

  public String getVersao() {
    return versao;
  }

  public TypeItemType getTipoItem() {
    return tipoItem;
  }

  public void setTipoItem(TypeItemType tipoItem) {
    this.tipoItem = tipoItem;
  }

  public String getTipoRcl() {
    return tipoRcl;
  }

  public void setTipoRcl(String tipoRcl) {
    this.tipoRcl = tipoRcl;
  }

  public List<ItemPrice> getPrices() {
    return prices;
  }

  public String getImei() {
    return imei;
  }

  public String getPlataforma() {
    return "ANDROID";
  }

  public String getModeloEquipamento() {
    return Build.DEVICE;
  }

  public Double getQtdTotal() {
    Double t = 0d;

    for (ItemPrice p : getPrices())
      t += p.getQuantidadeVendida();

    return t;
  }

  public Double getTotalPedido() {
    double t = 0D;

    for (ItemPrice p : getPrices())
      if (!getOperation().getOperationType().equals(OperationType.CPL))
        t += p.getTotalItem(getOperation(), getCustomer());

    return UtilHelper.formatDouble(t, 2);
  }

  public boolean isCiaLegal() {
    return ("35820448".equals(getRoute().getCnpj().substring(0, 8)) ||
        "34597955".equals(getRoute().getCnpj().substring(0, 8)) ||
        "24380578".equals(getRoute().getCnpj().substring(0, 8)) ||
        "13553312".equals(getRoute().getCnpj().substring(0, 8)));
  }

  public boolean isFamex() {
    return ("07836548".equals(getRoute().getCnpj().substring(0, 8)) ||
        "05483332".equals(getRoute().getCnpj().substring(0, 8)));
  }

  public boolean isGama() {
    return "72819618".equals(getRoute().getCnpj().substring(0, 8));
  }

  public boolean isPagtoAtivado() {
    return ConstantsEnum.YES.getValue().equalsIgnoreCase(getRoute().getTipoPagamento());
  }

  public boolean isHomecare() {
    return Integer.valueOf(6).equals(getRoute().getTipoCargaVeiculo());
  }

  public boolean isPackeged() {
    return Integer.valueOf(0).equals(getRoute().getTipoCargaVeiculo());
  }

  public boolean isLiquido() {
    return Integer.valueOf(1).equals(getRoute().getTipoCargaVeiculo());
  }

  public boolean isMultipla() {
    return ConstantsEnum.YES.getValue().equalsIgnoreCase(getRoute().getViagemMultipla());
  }

  public boolean isIntercompany(Customer customer) {

    if (ConstantsEnum.YES.getValue().equalsIgnoreCase(customer.getFlFilialWm())) {
      return !customer.getCnpj().substring(0, 8)
          .equalsIgnoreCase(getRoute().getCnpj().substring(0, 8));

    } else
      return false;
  }

  public PreOrder getPreOrder() {
    return preOrder;
  }

  public void setPreOrder(PreOrder preOrder) {


    this.preOrder = preOrder;
  }

  public String getInvoiceVOR() {
    return invoiceVOR;
  }

  public void setInvoiceVOR(String invoiceVOR) {
    this.invoiceVOR = invoiceVOR;
  }

  @RequiresApi(api = Build.VERSION_CODES.Q)
  public void init(Activity activity) {
    if (_self.imei == null || _self.imei.isEmpty())
      _self.imei = getDeviceImei(activity);

    setPreOrder(PreOrder.newInstance());
    invoiceVOR = "";
  }


  @RequiresApi(api = Build.VERSION_CODES.O)
  @SuppressLint("HardwareIds")
  private String getDeviceImei(Activity activity) {

    try {
      TelephonyManager telephonyManager = (TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE);
      if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
        return "";
      }

      final TelephonyManager mTelephony = (TelephonyManager) globalActivity.getSystemService(Context.TELEPHONY_SERVICE);

      String imei = null;
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        imei = Settings.Secure.getString(
            globalActivity.getApplicationContext().getContentResolver(),
            Settings.Secure.ANDROID_ID);
      } else {
//        final TelephonyManager mTelephony = (TelephonyManager) globalActivity.getSystemService(Context.TELEPHONY_SERVICE);
        if (mTelephony.getImei() != null) {
          imei = mTelephony.getImei();
        } else {
          imei = Settings.Secure.getString(
              globalActivity.getApplicationContext().getContentResolver(),
              Settings.Secure.ANDROID_ID);
        }
      }

      //String imei = telephonyManager.getDeviceId();

      if (imei != null && !imei.isEmpty()) {
        return imei;
      } else {
        return Build.SERIAL;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "not_found";
  }

  public CecType getCecDanfe(SuperOperation operation, Boolean isAvista) {

    if (operation.getOperationType().equals(OperationType.RPS))
      return CecType.REC_SEM;

    if (getRoute() != null) {
      CecType cecType = CecType.getByValue(getRoute().getModeloCec());

      if (isAvista)
        if (CecType.DANFE_SEM.equals(cecType) || CecType.DANFE_COM.equals(cecType))
          cecType = CecType.DANFE_COM;
        else
          cecType = CecType.CEC_COM;
      return cecType;
    }

    return CecType.CEC_COM;
  }

  public void startBackgroudServices(Activity activity) {
    try {
      LogHelper.self().info(activity.getClass().getSimpleName() + " startBackgroudServices",
          "Iniciando threads");

      try {
        invoiceBackgroundService.setActivity(globalActivity).start();
        invoiceImageBackgroundService.setActivity(globalActivity).start();

      } catch (Exception e) {
        e.printStackTrace();
      }

    } catch (Exception e) {
      e.printStackTrace();
      LogHelper.self().error("startBackgroudServices", "Erro ao iniciar threads");
    }
  }

  public void sum12HourRoute() {
    //Adiconando 12 horas na hora do Route pra que não dê problema de conversão com fuso de Manaus
    String dataStr = UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
        ConstantsEnum.ddMMyyyy.getValue());

    GLOBAL.self().getRoute().setDataViagem(UtilHelper.convertToDate(dataStr,
        ConstantsEnum.ddMMyyyy.getValue()));

    GLOBAL.self().getRoute().setDataViagem(UtilHelper.sumHoursToDate(
        GLOBAL.self().getRoute().getDataViagem(), 12));
    GLOBAL.self().getRoute().save();
  }


}
