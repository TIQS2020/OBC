package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceImage;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface InvoiceImageDao {

  @Query("SELECT * FROM InvoiceImage")
  List<InvoiceImage> getAll();

  @Query("SELECT * FROM InvoiceImage WHERE idNota = :idNota LIMIT 1")
  InvoiceImage find(Long idNota);

  @Query("SELECT * FROM InvoiceImage WHERE status IN (:status)")
  List<InvoiceImage> find(List<Integer> status);

  @Insert(onConflict = REPLACE)
  void insert(InvoiceImage invoiceImage);

  @Delete
  void delete(InvoiceImage invoiceImage);

  @Delete
  void deleteAll(List<InvoiceImage> invoiceImages);
}
