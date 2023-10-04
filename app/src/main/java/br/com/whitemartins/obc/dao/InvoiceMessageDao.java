package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.InvoiceMessage;

@Dao
public interface InvoiceMessageDao {

  @Query("SELECT * FROM InvoiceMessage")
  List<InvoiceMessage> getAll();

  @Query("SELECT * FROM InvoiceMessage WHERE idNota = :id")
  List<InvoiceMessage> findById(Long id);

  @Query("SELECT * FROM InvoiceMessage WHERE idNota = :id AND mostrarMsg = :mostrarMsg")
  List<InvoiceMessage> find(Long id, String mostrarMsg);

  @Insert
  Long[] insertAll(List<InvoiceMessage> invoiceMessages);

  @Insert
  Long insert(InvoiceMessage invoiceMessage);

  @Delete
  void delete(InvoiceMessage invoiceMessage);

  @Delete
  void deleteAll(List<InvoiceMessage> invoiceMessages);
}
