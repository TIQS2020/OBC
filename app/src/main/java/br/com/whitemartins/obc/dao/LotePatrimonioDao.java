package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.LotePatrimonio;

@Dao
public interface LotePatrimonioDao {

  @Query("SELECT * FROM LotePatrimonio")
  List<LotePatrimonio> getAll();

//  @Query("SELECT * FROM LotePatrimonio WHERE numeroLote = :numeroLote AND liberado = 'N' LIMIT 1")
//  LotePatrimonio find(Long numeroLote);

  @Query("SELECT * FROM LotePatrimonio WHERE idNota IS NULL")
  List<LotePatrimonio> find();

  @Query("SELECT * FROM LotePatrimonio WHERE idNota = :idNota")
  List<LotePatrimonio> findById(Long idNota);

  @Query("SELECT * FROM LotePatrimonio WHERE numeroLote = :numeroLote AND liberado = :liberado LIMIT 1")
  LotePatrimonio find(String numeroLote, String liberado);

//  @Query("SELECT * FROM LotePatrimonio WHERE idNota = :idNota AND cdCustomer = :cdCustomer " +
//    "AND cdItem =:cdItem AND capacidade = :capacidade")
//  List<LotePatrimonio> find(Long idNota, Long cdCustomer, Long cdItem, Double capacidade);

  @Query("SELECT * FROM LotePatrimonio WHERE idNota = :idNota AND cdItem = :cdItem " +
    "AND capacidade = :capacidade")
  List<LotePatrimonio> find(Long idNota, Long cdItem, Double capacidade);

  @Query("SELECT * FROM LotePatrimonio WHERE tipo = :tipo")
  List<LotePatrimonio> find(Integer tipo);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(LotePatrimonio lotePatrimonio);

  @Delete
  void deleteAll(List<LotePatrimonio> lotePatrimonios);
}
