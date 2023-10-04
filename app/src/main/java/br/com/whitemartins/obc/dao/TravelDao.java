package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Travel;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface TravelDao {

  @Query("SELECT * FROM Travel ORDER BY sequencia ASC")
  List<Travel> getAll();

  @Query("SELECT * FROM Travel WHERE numeroViagem = :numeroViagem LIMIT 1")
  Travel findById(long numeroViagem);

  @Query("SELECT * FROM Travel ORDER BY sequencia ASC LIMIT 1 ")
  Travel findFirst();

  @Query("SELECT * FROM Travel WHERE indViagemUsada = 'N' ORDER BY dataViagem LIMIT 1")
  Travel findNext();

  @Query("SELECT * FROM Travel WHERE indViagemUsada = 'Y' " +
    " AND numeroViagem < :numeroViagem ORDER BY sequencia LIMIT 1")
  Travel findPrior(long numeroViagem);

  @Insert(onConflict = REPLACE)
  void insert(Travel travel);

  @Delete
  void delete(Travel travel);

  @Delete
  void deleteAll(List<Travel> travels);
}
