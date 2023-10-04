package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.ConversaoLQ;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ConversionLQDao {
  @Query("SELECT * FROM ConversaoLQ")
  List<ConversaoLQ> getAll();

  @Query("SELECT * FROM ConversaoLQ WHERE numeroWM = :numeroWM LIMIT 1")
  ConversaoLQ findById(Long numeroWM);

  @Query("SELECT * FROM ConversaoLQ WHERE cdJDECliente = :cdJDECliente")
  List<ConversaoLQ> find(Long cdJDECliente);


  @Query("SELECT * FROM ConversaoLQ WHERE cdJDECliente = :cdJDECliente AND numeroWM = :numeroWM" +
    " AND numeroSerieTanque = :numeroSerieTanque LIMIT 1")
  ConversaoLQ find(Long cdJDECliente, Long numeroWM, String numeroSerieTanque);

  @Insert(onConflict = REPLACE)
  void insert(ConversaoLQ conversaoLQ);

  @Delete
  void delete(ConversaoLQ conversaoLQ);

  @Delete
  void deleteAll(List<ConversaoLQ> conversaoLQS);

}
