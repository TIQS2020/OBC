package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Code;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface CodeDao {
  @Query("SELECT * FROM Code")
  List<Code> getAll();

  @Query("SELECT * FROM Code WHERE codigo = :codigo LIMIT 1")
  Code findById(Long codigo);

  @Insert(onConflict = REPLACE)
  void insert(Code code);

  @Delete
  void delete(Code code);

  @Delete
  void deleteAll(List<Code> codes);

  @Query("SELECT * FROM Code WHERE tipoCodigo = :tipoCodigo AND codigo = :codigo " +
    "and cfop3 = :cfop3 LIMIT 1")
  Code find(String tipoCodigo, Integer codigo, Integer cfop3);

  @Query("SELECT * FROM Code WHERE codigo = :codigo AND cfop3 = :cfop3 LIMIT 1")
  Code find(Integer codigo, Integer cfop3);

  @Query("SELECT * FROM Code WHERE codigo = :codigo LIMIT 1")
  Code find(Integer codigo);

  @Query("SELECT * FROM Code WHERE tipoCodigo = :tipoCodigo ORDER BY descricao")
  List<Code> find(String tipoCodigo);

  @Query("SELECT * FROM Code WHERE tipoCodigo = :tipoCodigo AND codigo = :codigo " +
    "AND cfop3 = :cfop3 AND cfop4 = :cfop4 LIMIT 1")
  Code find(String tipoCodigo, Integer codigo, Integer cfop3, Integer cfop4);

  @Query("SELECT * FROM Code WHERE tipoCodigo = :tipoCodigo AND codigo = :codigo LIMIT 1")
  Code find(String tipoCodigo, Integer codigo);

}
