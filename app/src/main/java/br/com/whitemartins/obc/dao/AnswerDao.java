package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Answer;

@Dao
public interface AnswerDao {

  @Query("SELECT * FROM Answer")
  List<Answer> getAll();

  @Query("SELECT * FROM Answer WHERE idPesquisa = :idSearch")
  List<Answer> findById(Long idSearch);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(Answer answer);

  @Delete
  void deleteAll(List<Answer> answers);
}
