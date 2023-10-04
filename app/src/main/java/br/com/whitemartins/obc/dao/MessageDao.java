package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import br.com.whitemartins.obc.model.Message;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MessageDao {
  @Query("SELECT * FROM Message")
  List<Message> getAll();

  @Query("SELECT * FROM Message WHERE cdCustomer = ifnull(:cdCustomer, cdCustomer) AND tipoMensagem = :tipoMensagem  ORDER BY id")
  List<Message> find(@NonNull String tipoMensagem, @Nullable Long cdCustomer);

  @Query("SELECT * FROM Message WHERE cdCustomer = :cdCustomer")
  List<Message> find(@Nullable Long cdCustomer);

  @Query("SELECT * FROM Message WHERE tipoMensagem = :tipoMensagem ORDER BY id")
  List<Message> find(@NonNull String tipoMensagem);

  @Query("SELECT * FROM Message WHERE tipoMensagem = :tipoMensagem ORDER BY id")
  Message findByType(@NonNull String tipoMensagem);

  @Insert
  void insertAll(List<Message> messages);

  @Insert(onConflict = REPLACE)
  void insert(Message message);

  @Delete
  void delete(Message message);

  @Delete
  void deleteAll(List<Message> messages);

  @Update
  void update(Message message);
}
