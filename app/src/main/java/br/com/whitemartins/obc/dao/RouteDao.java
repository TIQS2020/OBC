package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Route;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface RouteDao {

  @Query("SELECT * FROM Route")
  List<Route> getAll();

  @Query("SELECT * FROM Route LIMIT 1")
  Route getRoute();

  @Insert(onConflict = REPLACE)
  void insert(Route route);

  @Delete
  void delete(Route route);

  @Delete
  void deleteAll(List<Route> routes);
}
