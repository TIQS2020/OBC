package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Abastecimento;

@Dao
public interface AbastecimentoDao {

  @Query("SELECT * FROM Abastecimento")
  List<Abastecimento> getAll();

  @Query("SELECT * FROM Abastecimento WHERE codigo = :codigo")
  List<Abastecimento> findById(Long codigo);

  @Query("SELECT * FROM Abastecimento WHERE cdCustomer = :cdCustomer AND idNota IS NULL")
  List<Abastecimento> find(Long cdCustomer);

  @Query("SELECT * FROM Abastecimento WHERE cdCustomer = :cdCustomer AND idNota = :idNota")
  List<Abastecimento> find(Long cdCustomer, Long idNota);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(Abastecimento abastecimento);

  @Delete()
  void delete(Abastecimento abastecimento);

  @Delete()
  void deleteAll(List<Abastecimento> abastecimentos);
}
