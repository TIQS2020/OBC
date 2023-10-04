package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.whitemartins.obc.model.Excepty;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ExceptyDao {

  @Query("SELECT * FROM Excepty")
  List<Excepty> getAll();

  @Insert(onConflict = REPLACE)
  void insert(Excepty Excepty);

  @Update
  void update(Excepty Excepty);

  @Delete
  void delete(Excepty Excepty);

  @Delete
  void deleteAll(List<Excepty> excepties);
}
