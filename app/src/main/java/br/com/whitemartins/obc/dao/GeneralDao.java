package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.whitemartins.obc.model.General;
import br.com.whitemartins.obc.model.Rastreabilidade;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface GeneralDao {

  @Query("SELECT * FROM General")
  List<General> getAll();

  @Query("SELECT * FROM General WHERE numeroViagem = :numeroViagem LIMIT 1")
  General findById(Long numeroViagem);

  @Query("SELECT * FROM General LIMIT 1")
  General getGeneral();

  @Insert
  void insertAll(List<General> generals);

  @Insert(onConflict = REPLACE)
  void insert(General general);

  @Update
  void update(General general);

  @Delete
  void delete(General general);

  @Delete
  void deleteAll(List<General> generals);

}
