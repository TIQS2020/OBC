package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

import br.com.whitemartins.obc.model.Search;

@Dao
public interface SearchDao {

  @Query("SELECT * FROM Search")
  List<Search> getAll();

  @Query("SELECT * FROM Search WHERE idNota = :idNota")
  Search findById(Long idNota);

  @Query("SELECT * FROM Search WHERE idNota IS NULL")
  List<Search> find();

  @Query("SELECT * FROM Search WHERE idNota IS NULL")
  Search findOne();

  @Query("SELECT * FROM Search WHERE cdCustomer = :cdCustomer " +
    "        AND date(dtPesquisa/1000, 'unixepoch') = :dtPesquisa " +
    "      ORDER BY dtPesquisa DESC LIMIT 1")
  Search findByCustomer(Long cdCustomer, String dtPesquisa);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  Long insert(Search search);

  @Delete
  void deleteAll(List<Search> searches);
}
