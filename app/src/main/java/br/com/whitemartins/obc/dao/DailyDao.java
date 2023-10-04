package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Daily;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface DailyDao {

  @Query("SELECT * FROM Daily")
  List<Daily> getAll();

  @Query("SELECT * FROM Daily WHERE numeroViagem = :numeroViagem LIMIT 1")
  Daily findByNumViagem(Long numeroViagem);

  @Query("SELECT * FROM Daily WHERE numeroViagem < :numeroViagem ORDER BY numeroViagem DESC LIMIT 1")
  Daily findPrior(Long numeroViagem);

  @Insert
  void insertAll(List<Daily> dailies);

  @Insert(onConflict = REPLACE)
  void insert(Daily daily);

  @Delete
  void delete(Daily daily);

  @Delete
  void deleteAll(List<Daily> clients);
}
