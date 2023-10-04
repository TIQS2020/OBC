package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Invoice;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface InvoiceDao {

  @Query("SELECT * FROM Invoice ORDER BY numero")
  List<Invoice> getAll();

  @Query("SELECT * FROM Invoice WHERE numeroViagem = :numeroViagem ORDER BY numero, cdCustomer")
  List<Invoice> findInvoiceReport(String numeroViagem);

  @Query("SELECT * FROM Invoice WHERE id = :id LIMIT 1")
  Invoice findById(Long id);

  @Query("SELECT * FROM Invoice WHERE cdCustomer = ifnull(:cdCustomer, cdCustomer) " +
    "AND numeroViagem = :numeroViagem ORDER BY numero")
  List<Invoice> find(Long cdCustomer, String numeroViagem);

  @Query("SELECT * FROM Invoice WHERE numeroFutEntrega = :numeroFutEntrega")
  List<Invoice> find(String numeroFutEntrega);

  @Query("SELECT * FROM Invoice WHERE status IN (:statusNFe) ORDER BY numero")
  List<Invoice> find(List<Integer> statusNFe);

  @Query("SELECT * FROM Invoice WHERE stepEmissao NOT IN (:stepEmissao) ORDER BY numero")
  List<Invoice> find(Integer stepEmissao);

  @Query("SELECT * FROM Invoice WHERE status IN (:statusNFe) AND stepEmissao = :stepEmissao ORDER BY numero")
  List<Invoice> find(List<Integer> statusNFe, Integer stepEmissao);

  @Query("SELECT * FROM Invoice WHERE tipoNota = :tipoNota ORDER BY numero DESC LIMIT 1")
  Invoice findByTipoNota(String tipoNota);

  @Query("SELECT * FROM Invoice WHERE tipoNota = :tipoNota ORDER BY numero")
  List<Invoice> findAllByTipoNota(String tipoNota);

  @Query("SELECT * FROM Invoice WHERE numero < :numero AND tiponota = :tipoNota" +
    " ORDER BY Invoice.dataMovimento DESC LIMIT 1")
  Invoice findPriorInvoice(Long numero, String tipoNota);

  @Query("SELECT * FROM Invoice WHERE numero > :numero AND tiponota = :tipoNota" +
    " ORDER BY Invoice.dataMovimento ASC LIMIT 1")
  Invoice findNextInvoice(Long numero, String tipoNota);

  @Insert
  Long[] insertAll(List<Invoice> invoices);

  @Insert(onConflict = REPLACE)
  Long insert(Invoice invoice);

  @Delete
  void delete(Invoice invoice);

  @Delete
  void deleteAll(List<Invoice> invoices);
}
