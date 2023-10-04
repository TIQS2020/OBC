package br.com.whitemartins.obc.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import br.com.whitemartins.obc.dao.AbastecimentoDao;
import br.com.whitemartins.obc.dao.AnswerDao;
import br.com.whitemartins.obc.dao.AssetDao;
import br.com.whitemartins.obc.dao.CodeDao;
import br.com.whitemartins.obc.dao.ConversionLQDao;
import br.com.whitemartins.obc.dao.CustomerDao;
import br.com.whitemartins.obc.dao.DailyDao;
import br.com.whitemartins.obc.dao.ExceptyDao;
import br.com.whitemartins.obc.dao.GeneralDao;
import br.com.whitemartins.obc.dao.InvoiceDao;
import br.com.whitemartins.obc.dao.InvoiceImageDao;
import br.com.whitemartins.obc.dao.InvoiceItemDao;
import br.com.whitemartins.obc.dao.InvoiceMessageDao;
import br.com.whitemartins.obc.dao.InvoiceNumberDao;
import br.com.whitemartins.obc.dao.ItemDao;
import br.com.whitemartins.obc.dao.LotePatrimonioDao;
import br.com.whitemartins.obc.dao.MessageDao;
import br.com.whitemartins.obc.dao.PatientDao;
import br.com.whitemartins.obc.dao.PaymentCardDao;
import br.com.whitemartins.obc.dao.PaymentDao;
import br.com.whitemartins.obc.dao.PreOrderDao;
import br.com.whitemartins.obc.dao.PriceDao;
import br.com.whitemartins.obc.dao.QuestionsDao;
import br.com.whitemartins.obc.dao.RastreabilidadeDao;
import br.com.whitemartins.obc.dao.RouteDao;
import br.com.whitemartins.obc.dao.SaldoDao;
import br.com.whitemartins.obc.dao.SearchDao;
import br.com.whitemartins.obc.dao.TaxDao;
import br.com.whitemartins.obc.dao.TravelDao;
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
import br.com.whitemartins.obc.util.Constants;

@Database(entities = {
  Daily.class,
  Customer.class,
  Item.class,
  Price.class,
  Route.class,
  Asset.class,
  Patient.class,
  InvoiceNumber.class,
  PaymentCard.class,
  Tax.class,
  Code.class,
  Questions.class,
  ConversaoLQ.class,
  Message.class,
  Travel.class,
  PreOrder.class,
  General.class,
  Rastreabilidade.class,
  Invoice.class,
  InvoiceItem.class,
  InvoiceMessage.class,
  Search.class,
  Answer.class,
  Payment.class,
  Saldo.class,
  LotePatrimonio.class,
  Abastecimento.class,
  Excepty.class,
  InvoiceImage.class
},
  version = Constants.DB_VERSION,
  exportSchema = false)

@TypeConverters({DateTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

  public abstract DailyDao dailyDao();

  public abstract CustomerDao customerDao();

  public abstract RouteDao routeDao();

  public abstract PriceDao priceDao();

  public abstract ItemDao itemDao();

  public abstract AssetDao assetDao();

  public abstract InvoiceNumberDao invoiceNumberDao();

  public abstract PaymentCardDao payCardDao();

  public abstract TaxDao taxDao();

  public abstract CodeDao codeDao();

  public abstract QuestionsDao questionsDao();

  public abstract ConversionLQDao conversionLQDao();

  public abstract MessageDao messageDao();

  public abstract TravelDao travelDao();

  public abstract PreOrderDao preOrderDao();

  public abstract GeneralDao generalDao();

  public abstract PatientDao patientDao();

  public abstract RastreabilidadeDao rastreabilidadeDao();

  public abstract InvoiceDao invoiceDao();

  public abstract InvoiceItemDao invoiceItemDao();

  public abstract InvoiceMessageDao invoiceMessageDao();

  public abstract SearchDao searchDao();

  public abstract AnswerDao answerDao();

  public abstract PaymentDao paymentDao();

  public abstract SaldoDao saldoDao();

  public abstract LotePatrimonioDao lotePatrimonioDao();

  public abstract AbastecimentoDao abastecimentoDao();

  public abstract ExceptyDao exceptDao();

  public abstract InvoiceImageDao invoiceImageDao();
}

