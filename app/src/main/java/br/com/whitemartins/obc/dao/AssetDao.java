package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.whitemartins.obc.model.Asset;
import br.com.whitemartins.obc.model.AssetDistinct;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface AssetDao {

  @Query("SELECT * FROM Asset")
  List<Asset> getAll();

  @Query("SELECT * FROM Asset WHERE cdAtivo = :cdAsset LIMIT 1")
  Asset findById(Long cdAsset);

  @Query("SELECT * FROM Asset WHERE  cdItem = :cdItem AND numeroPatrimonio = :numeroPatrimonio LIMIT 1")
  Asset findById(Long cdItem, String numeroPatrimonio);

  @Query("SELECT * FROM Asset WHERE cdItem = :cdItem")
  List<Asset> findByCdItem(Long cdItem);

  @Query("SELECT DISTINCT cdItem, descricao FROM Asset")
  List<AssetDistinct> getDistinct();

  @Query("SELECT * FROM Asset WHERE numeroPatrimonio = :numeroPatrimonio LIMIT 1")
  Asset findByNumeroPatrimonio(String numeroPatrimonio);

  @Query("SELECT * FROM Asset WHERE checado is null")
  List<Asset> getOpenAssets();

  @Insert(onConflict = REPLACE)
  void insert(Asset asset);

  @Update
  void update(Asset asset);

  @Delete
  void delete(Asset asset);

  @Delete
  void deleteAll(List<Asset> assets);
}
