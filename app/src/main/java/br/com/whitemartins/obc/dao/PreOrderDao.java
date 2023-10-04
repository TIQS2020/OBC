package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.PreOrder;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface PreOrderDao {

  @Query("SELECT * FROM PreOrder")
  List<PreOrder> getAll();

  @Query("SELECT * FROM PreOrder where cdCustomer = :cdCustomer")
  List<PreOrder> find(Long cdCustomer);

//  @Query("SELECT DISTINCT cdPreOrder, dataEmissaoNota, numeroNotaOrigem FROM PreOrder " +
//    "WHERE cdCustomer = :cdCustomer")
//  List<PreOrder> findDistinct(Long cdCustomer);

  @Query("SELECT * FROM PreOrder where numeroNotaOrigem = :numeroNotaOrigem")
  PreOrder find(String numeroNotaOrigem);

  @Query("SELECT * FROM PreOrder " +
    "WHERE numeroNotaOrigem = :numeroNotaOrigem " +
    "  AND cdItem = :cdItem")
  PreOrder find(Long cdItem, String numeroNotaOrigem);

  @Insert(onConflict = REPLACE)
  void insert(PreOrder preOrder);

  @Delete
  void delete(PreOrder preOrder);

  @Delete
  void deleteAll(List<PreOrder> preOrders);
}
