package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Saldo;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface SaldoDao {
  @Query("SELECT * FROM Saldo")
  List<Saldo> getAll();

  @Insert(onConflict = REPLACE)
  void insertAll(List<Saldo> saldos);

  @Insert(onConflict = REPLACE)
  void insert(Saldo saldo);

  @Delete
  void delete(Saldo Saldo);

  @Delete
  void deleteAll(List<Saldo> saldos);

  @Query("SELECT * FROM Saldo WHERE cdItem = :cdItem AND capacidade = :capacidade  " +
    "AND numeroViagem = :numeroViagem LIMIT 1")
  Saldo find(Long cdItem, Double capacidade, Long numeroViagem);

  @Query("SELECT * FROM Saldo where tipoItem IN (:tipoItem) " +
    " AND numeroViagem = :numeroViagem AND qtdCarregadaCheios > 0")
  List<Saldo> find(List<Integer> tipoItem, Long numeroViagem);

  @Query("SELECT * FROM Saldo where tipoItem IN (:tipoItem) " +
    " AND numeroViagem = :numeroViagem AND (qtdCarregadaCheios > 0 OR qtdRecolhidosHC > 0)")
  List<Saldo> findMovementEquipment(List<Integer> tipoItem, Long numeroViagem);

  @Query("SELECT * FROM Saldo where tipoItem IN (:tipoItem) " +
    " AND numeroViagem = :numeroViagem")
  List<Saldo> findAll(List<Integer> tipoItem, Long numeroViagem);

  @Query("SELECT * " +
    "  FROM saldo" +
    "  JOIN item ON item.cdItem = saldo.cdItem AND item.capacidadeProduto = saldo.capacidade" +
    " WHERE saldo.cdItem = ifnull(:cdItem, saldo.cdItem) AND Item.tipoItem in (:tipoItem) " +
    "   AND numeroViagem = :numeroViagem" +
    " GROUP BY saldo.cdItem, saldo.capacidade ")
  List<Saldo> saldoObc(Long cdItem, List<Integer> tipoItem, Long numeroViagem);
}
