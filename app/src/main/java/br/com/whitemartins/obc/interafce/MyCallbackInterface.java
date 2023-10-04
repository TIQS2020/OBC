package br.com.whitemartins.obc.interafce;

import java.util.List;
import java.util.Map;

import br.com.whitemartins.obc.enumeration.BeginTravelType;
import br.com.whitemartins.obc.model.Search;
import br.com.whitemartins.obc.model.WantedClient;
import br.com.whitemartins.obc.model.sync.NotasFiscais;
import br.com.whitemartins.obc.xml.XmlInicioViagemRetorno;
import br.com.whitemartins.obc.xml.XmlRecuperaClienteRetorno;

public class MyCallbackInterface {

  public interface CallbackVoidInterface {
    void execute();
  }

//  public interface CallbackTickInterface {
//    void execute(Long millisUntilFinished);
//  }

  public interface CallbackBooleanInterface {
    void execute(Boolean success);
  }

  public interface CallbackSearchInterface {
    void execute(Search search);
  }

  public interface CallbackStringInterface {
    void execute(String choice);
  }

  public interface CallbackBeginTravelInterface {
    void execute(BeginTravelType beginTravelType);
  }


  public interface CallbackWantedClientsInterface {
    void execute(List<WantedClient> customers);
  }

  public interface CallbackXmlRetornoClienteInterface {
    void execute(boolean success, XmlRecuperaClienteRetorno xmlRecuperaClienteRetorno);
  }

  public interface CallbackListInterface {
    void execute(List<NotasFiscais> objects);
  }

  public interface OnOkListener {
    boolean onOkClick(String value);
  }

}

