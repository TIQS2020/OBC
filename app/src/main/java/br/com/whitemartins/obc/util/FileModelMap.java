package br.com.whitemartins.obc.util;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.model.Abastecimento;
import br.com.whitemartins.obc.model.Answer;
import br.com.whitemartins.obc.model.Asset;
import br.com.whitemartins.obc.model.Code;
import br.com.whitemartins.obc.model.ConversaoLQ;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Daily;
import br.com.whitemartins.obc.model.Excepty;
import br.com.whitemartins.obc.model.General;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceImage;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.InvoiceMessage;
import br.com.whitemartins.obc.model.InvoiceNumber;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.LotePatrimonio;
import br.com.whitemartins.obc.model.Message;
import br.com.whitemartins.obc.model.Patient;
import br.com.whitemartins.obc.model.Payment;
import br.com.whitemartins.obc.model.PaymentCard;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.model.Price;
import br.com.whitemartins.obc.model.Questions;
import br.com.whitemartins.obc.model.Rastreabilidade;
import br.com.whitemartins.obc.model.Route;
import br.com.whitemartins.obc.model.Saldo;
import br.com.whitemartins.obc.model.Search;
import br.com.whitemartins.obc.model.Tax;
import br.com.whitemartins.obc.model.Travel;

/**
 * Created by Rodolfo on 31/01/2018.
 */

public class FileModelMap {

  private static List<FileModelMapClass> FileModelMapClassList;

  private static FileModelMap _self;

  public FileModelMap() {
    internalAdd();
  }

  public static FileModelMap self() {

    if (_self == null)
      _self = new FileModelMap();

    return _self;
  }

  public List<FileModelMapClass> getFileModelMapClassList() {
    return FileModelMapClassList;
  }

  private void internalAdd() {
    FileModelMapClassList = new ArrayList<>();

    //Tabelas populadas pelos arquivos de carga
    FileModelMapClassList.add(new FileModelMapClass(Customer.class, "CUSTOMER.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(Asset.class, "ATIVOS.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(Item.class, "ITEM.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(Price.class, "WMPRICE.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(Patient.class, "PACIENTE.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(InvoiceNumber.class, "INVCNO.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(PaymentCard.class, "PAG_CARTAO.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(Tax.class, "NEWTAX.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(Code.class, "CODES.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(ConversaoLQ.class, "CONVLQ.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(Questions.class, "PESQUISA.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(Message.class, "MESSAGE.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(Travel.class, "VIAGEM.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(PreOrder.class, "PREORDER.TXT"));
    FileModelMapClassList.add(new FileModelMapClass(Route.class, "ROUTE.TXT"));

    //Tabelas que são populadas durante a viagem
    FileModelMapClassList.add(new FileModelMapClass(General.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(Daily.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(Rastreabilidade.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(Invoice.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(InvoiceItem.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(InvoiceImage.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(InvoiceMessage.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(Answer.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(Payment.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(Search.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(Saldo.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(LotePatrimonio.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(Abastecimento.class, ""));
    FileModelMapClassList.add(new FileModelMapClass(Excepty.class, ""));
  }

  public class FileModelMapClass {
    private Class klass;
    private String fileName;

    public FileModelMapClass(Class klass, String fileName) {
      this.klass = klass;
      this.fileName = fileName;
    }

    public Class getKlass() {
      return klass;
    }

    public String getFileName() {
      return fileName;
    }
  }
}


