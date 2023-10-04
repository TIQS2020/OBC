package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Item;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


@Dao
public interface ItemDao {

  @Query("SELECT * FROM Item")
  List<Item> getAll();

  @Query("SELECT * FROM Item WHERE (cdItem = :cdItem OR cdCilindro = :cdItem) AND capacidadeProduto = :capacidadeProduto")
  Item find(Long cdItem, Double capacidadeProduto);

  @Query("SELECT * FROM Item WHERE cdItem = :cdItem OR cdCilindro = :cdItem")
  Item find(Long cdItem);

  @Query("SELECT * FROM Item WHERE (qtdCilindroCheios > 0 OR qtdCilindroVazios > 0) " +
    "AND tipoItem IN (:tipoItem)")
  List<Item> find(List<Integer> tipoItem);

  @Insert(onConflict = REPLACE)
  void insertAll(Item... items);

  @Insert(onConflict = REPLACE)
  void insert(Item item);

  @Delete
  void delete(Item item);

  @Delete
  void deleteAll(List<Item> items);


//  @Query("SELECT * FROM Item WHERE tipoItem in (:tipoItem) AND qtdCilindroCheios > 0")
//  public List<Item> findItemsAPL(String tipoItem);
}
