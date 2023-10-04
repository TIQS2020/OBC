package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.whitemartins.obc.model.Patient;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface PatientDao {

  @Query("SELECT * FROM Patient")
  List<Patient> getAll();

  @Query("SELECT * FROM Patient WHERE cdPaciente = :cdPaciente LIMIT 1")
  Patient findById(Long cdPaciente);

  @Insert
  void insertAll(List<Patient> patients);

  @Insert(onConflict = REPLACE)
  void insert(Patient patient);

  @Delete
  void delete(Patient patient);

  @Delete
  void deleteAll(List<Patient> patients);
}
