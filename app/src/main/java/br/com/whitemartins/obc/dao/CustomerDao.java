package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Patient;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface CustomerDao {

  @Query("SELECT * FROM Customer")
  List<Customer> getAll();

  @Query("SELECT * FROM Customer WHERE cdCustomer = :cdCustomer LIMIT 1")
  Customer findById(Long cdCustomer);

  @Query(
    "SELECT cdCustomer, nome, Customer.cnpj as cnpj FROM Customer" +
      "  JOIN Route" +
      " WHERE cdcustomer <> (:cdCia) " +
      "   AND cdcustomer = ifnull(:cdCustomer, cdcustomer)" +
      "   AND (   (:type=1 AND substr(Route.cnpj, 0, 9) = substr(Customer.cnpj, 0, 9)) " + //--TRANSFERENCIA
      "        OR (:type=2 AND substr(Route.cnpj, 0, 9) <> substr(Customer.cnpj, 0, 9))" + //--INTERCOMPANY
      "       )" +
    "UNION " +
    "SELECT cdPaciente as cdCustomer, nome, cnpj FROM Patient " +
      " WHERE cdPaciente = ifnull(:cdCustomer, cdPaciente)")
  List<Customer> getCustomersAndPatients(Integer type, Long cdCia, Long cdCustomer);

  @Query(
    "SELECT cdCustomer, nome, Customer.cnpj as cnpj FROM Customer" +
      "  JOIN Route" +
      " WHERE cdcustomer <> (:cdCia) " +
      "   AND cdcustomer = ifnull(:cdCustomer, cdcustomer)" +
      "   AND (   (:type=1 AND substr(Route.cnpj, 0, 9) = substr(Customer.cnpj, 0, 9)) " + //--TRANSFERENCIA
      "        OR (:type=2 AND substr(Route.cnpj, 0, 9) <> substr(Customer.cnpj, 0, 9))" + //--INTERCOMPANY
      "       )" +
      "UNION " +
      "SELECT cdPaciente as cdCustomer, nome, cnpj FROM Patient " +
      " WHERE cdPaciente = ifnull(:cdCustomer, cdPaciente)")
  List<Patient> getCustomersPatients(Integer type, Long cdCia, Long cdCustomer);

  @Insert(onConflict = REPLACE)
  void insert(Customer customer);

  @Delete
  void delete(Customer customer);

  @Delete
  void deleteAll(List<Customer> customers);
}
