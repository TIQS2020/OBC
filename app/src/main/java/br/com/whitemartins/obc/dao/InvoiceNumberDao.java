package br.com.whitemartins.obc.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.InvoiceNumber;

@Dao
public interface InvoiceNumberDao {
  @Query("SELECT * FROM InvoiceNumber")
  List<InvoiceNumber> getAll();

  @Query("SELECT * FROM InvoiceNumber LIMIT 1")
  InvoiceNumber getFirst();

  @Insert
  void insertAll(List<InvoiceNumber> invoiceNumbers);

  @Insert
  void insert(InvoiceNumber invoiceNumbers);

  @Delete
  void delete(InvoiceNumber invoiceNumber);

  @Delete
  void deleteAll(List<InvoiceNumber> invoiceNumbers);
}
