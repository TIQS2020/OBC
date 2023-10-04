package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.InvoiceItem;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface InvoiceItemDao {

  @Query("SELECT * FROM InvoiceItem")
  List<InvoiceItem> getAll();

  @Query("SELECT * FROM InvoiceItem ORDER BY cdItem")
  List<InvoiceItem> find();

  @Query("SELECT * FROM InvoiceItem WHERE idNota = :idNota ORDER BY seqItem")
  List<InvoiceItem> findByIdNota(Long idNota);

  @Insert
  void insertAll(List<InvoiceItem> invoiceItems);

  @Insert(onConflict = REPLACE)
  void insert(InvoiceItem invoiceItem);

  @Delete
  void delete(InvoiceItem invoiceItem);

  @Delete
  void deleteAll(List<InvoiceItem> invoiceItems);

  @Query("SELECT * FROM InvoiceItem WHERE InvoiceItem.tipoItem IN (:tipoItem) ORDER BY cdItem")
  List<InvoiceItem> find(List<Integer> tipoItem);

  @Query("SELECT * FROM InvoiceItem WHERE InvoiceItem.cdItem IN (:cdItem)")
  InvoiceItem find(Long cdItem);
}
