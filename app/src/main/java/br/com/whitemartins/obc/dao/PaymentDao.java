package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Payment;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface PaymentDao {

  @Query("SELECT * FROM Payment")
  List<Payment> getAll();

  @Query("SELECT * FROM Payment WHERE numeroAutorizacao = :numeroAutorizacao LIMIT 1")
  Payment find(String numeroAutorizacao);

  @Query("SELECT * FROM Payment WHERE idNota = :idNota")
  List<Payment> find(Long idNota);

  @Query("SELECT * FROM Payment WHERE idNota IS NULL")
  List<Payment> find();

  @Insert(onConflict = REPLACE)
  void insert(Payment payment);

  @Delete
  void delete(Payment payment);

  @Delete
  void deleteAll(List<Payment> payments);
}
