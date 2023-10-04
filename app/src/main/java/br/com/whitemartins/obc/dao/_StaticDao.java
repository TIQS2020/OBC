package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import br.com.whitemartins.obc.model._StaticTable;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface _StaticDao {

  @Query("SELECT * FROM _StaticTable LIMIT 1")
  _StaticTable find();

  @Insert(onConflict = REPLACE)
  void insert(_StaticTable staticTable);
}
