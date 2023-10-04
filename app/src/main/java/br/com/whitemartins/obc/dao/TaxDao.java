package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

import br.com.whitemartins.obc.model.Tax;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface TaxDao {

  @Query("SELECT * FROM Tax")
  List<Tax> getAll();

  @Query("SELECT * FROM Tax WHERE condPagto = :condPagto and dtEmissao = :dtEmissao")
  List<Tax> findByCondPagtoEmissao(String condPagto, Date dtEmissao);

  @Query("SELECT * FROM Tax WHERE condPagto = :condPagto LIMIT 1")
  Tax find(String condPagto);

  @Insert(onConflict = REPLACE)
  void insert(Tax tax);

  @Delete
  void delete(Tax tax);

  @Delete
  void deleteAll(List<Tax> taxes);
}
