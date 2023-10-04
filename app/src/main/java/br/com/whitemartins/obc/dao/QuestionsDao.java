package br.com.whitemartins.obc.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Questions;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface QuestionsDao {
  @Query("SELECT * FROM Questions")
  List<Questions> getAll();

  @Query("SELECT * FROM Questions WHERE numeroPergunta = :numeroPergunta LIMIT 1")
  Questions findById(Long numeroPergunta);

  @Query("SELECT * FROM Questions WHERE pergunta = :pergunta LIMIT 1")
  Questions find(String pergunta);

  @Insert(onConflict = REPLACE)
  void insert(Questions questions);

  @Delete
  void delete(Questions questions);

  @Delete
  void deleteAll(List<Questions> perguntas);

}
