package br.com.whitemartins.obc.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.PaymentCard;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface PaymentCardDao {

  @Query("SELECT * FROM PaymentCard")
  List<PaymentCard> getAll();

  @Query("SELECT * FROM PaymentCard WHERE cnpj = :cnpj LIMIT 1")
  PaymentCard findByCnpj(String cnpj);

  @Insert(onConflict = REPLACE)
  void insert(PaymentCard paymentCard);

  @Delete
  void delete(PaymentCard paymentCard);

  @Delete
  void deleteAll(List<PaymentCard> paymentCards);
}
