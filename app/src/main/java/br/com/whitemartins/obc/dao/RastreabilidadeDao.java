package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.whitemartins.obc.model.Rastreabilidade;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface RastreabilidadeDao {

  @Query("SELECT * FROM Rastreabilidade ORDER BY numeroLote, cdCilindro")
  List<Rastreabilidade> getAll();

  @Query("SELECT * FROM Rastreabilidade WHERE cdCilindro = :cdCilindro AND liberado = 'N' LIMIT 1")
  Rastreabilidade find(String cdCilindro);

  @Query("SELECT * FROM Rastreabilidade WHERE cdCustomer = :cdCustomer AND idNota IS NULL " +
    "ORDER BY numeroLote, cdCilindro")
  List<Rastreabilidade> findByCustomer(Long cdCustomer);

  @Query("SELECT * FROM Rastreabilidade WHERE cdItem = :cdItem and idNota = :idNota " +
    "ORDER BY numeroLote, cdCilindro")
  List<Rastreabilidade> findByItem(Long idNota, Long cdItem);

  @Query("SELECT DISTINCT idNota, cdItem, cdCilindro, numeroLote FROM Rastreabilidade " +
    "WHERE Rastreabilidade.idNota = :idNota " +
    "  AND Rastreabilidade.numeroViagem = :numeroViagem " +
    "  AND Rastreabilidade.cdCustomer = :cdCustomer ORDER BY numeroLote, cdCilindro")
  List<Rastreabilidade> find(Long idNota, Long numeroViagem, Long cdCustomer);

  @Query("SELECT * FROM Rastreabilidade WHERE idNota = :idNota ORDER BY numeroLote, cdCilindro")
  List<Rastreabilidade> findByNota(Long idNota);

  @Insert
  void insert(Rastreabilidade rastreabilidade);

  @Update
  void update(Rastreabilidade rastreabilidade);

  @Insert(onConflict = REPLACE)
  void insertAll(List<Rastreabilidade> rastreabilidades);

  @Delete
  void delete(Rastreabilidade rastreabilidade);

  @Delete
  void deleteAll(List<Rastreabilidade> rastreabilidades);

}
