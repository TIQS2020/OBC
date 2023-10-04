package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Patient;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class PatientDao_Impl implements PatientDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPatient;

  private final EntityInsertionAdapter __insertionAdapterOfPatient_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfPatient;

  public PatientDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPatient = new EntityInsertionAdapter<Patient>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Patient`(`cdPaciente`,`nome`,`endereco`,`bairro`,`cidade`,`UF`,`CEP`,`telefone`,`cdJDEOperadora`,`cnpj`,`flDistribGas`,`precoDiferente`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Patient value) {
        if (value.getCdPaciente() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdPaciente());
        }
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        if (value.getEndereco() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEndereco());
        }
        if (value.getBairro() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBairro());
        }
        if (value.getCidade() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCidade());
        }
        if (value.getUF() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUF());
        }
        if (value.getCEP() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCEP());
        }
        if (value.getTelefone() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTelefone());
        }
        if (value.getCdJDEOperadora() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getCdJDEOperadora());
        }
        if (value.getCnpj() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCnpj());
        }
        if (value.getFlDistribGas() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFlDistribGas());
        }
        if (value.getPrecoDiferente() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPrecoDiferente());
        }
      }
    };
    this.__insertionAdapterOfPatient_1 = new EntityInsertionAdapter<Patient>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Patient`(`cdPaciente`,`nome`,`endereco`,`bairro`,`cidade`,`UF`,`CEP`,`telefone`,`cdJDEOperadora`,`cnpj`,`flDistribGas`,`precoDiferente`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Patient value) {
        if (value.getCdPaciente() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdPaciente());
        }
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        if (value.getEndereco() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEndereco());
        }
        if (value.getBairro() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBairro());
        }
        if (value.getCidade() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCidade());
        }
        if (value.getUF() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUF());
        }
        if (value.getCEP() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCEP());
        }
        if (value.getTelefone() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTelefone());
        }
        if (value.getCdJDEOperadora() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getCdJDEOperadora());
        }
        if (value.getCnpj() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCnpj());
        }
        if (value.getFlDistribGas() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFlDistribGas());
        }
        if (value.getPrecoDiferente() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPrecoDiferente());
        }
      }
    };
    this.__deletionAdapterOfPatient = new EntityDeletionOrUpdateAdapter<Patient>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Patient` WHERE `cdPaciente` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Patient value) {
        if (value.getCdPaciente() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdPaciente());
        }
      }
    };
  }

  @Override
  public void insertAll(List<Patient> patients) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPatient.insert(patients);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(Patient patient) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPatient_1.insert(patient);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Patient patient) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPatient.handle(patient);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Patient> patients) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPatient.handleMultiple(patients);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Patient> getAll() {
    final String _sql = "SELECT * FROM Patient";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdPaciente = _cursor.getColumnIndexOrThrow("cdPaciente");
      final int _cursorIndexOfNome = _cursor.getColumnIndexOrThrow("nome");
      final int _cursorIndexOfEndereco = _cursor.getColumnIndexOrThrow("endereco");
      final int _cursorIndexOfBairro = _cursor.getColumnIndexOrThrow("bairro");
      final int _cursorIndexOfCidade = _cursor.getColumnIndexOrThrow("cidade");
      final int _cursorIndexOfUF = _cursor.getColumnIndexOrThrow("UF");
      final int _cursorIndexOfCEP = _cursor.getColumnIndexOrThrow("CEP");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfCdJDEOperadora = _cursor.getColumnIndexOrThrow("cdJDEOperadora");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfFlDistribGas = _cursor.getColumnIndexOrThrow("flDistribGas");
      final int _cursorIndexOfPrecoDiferente = _cursor.getColumnIndexOrThrow("precoDiferente");
      final List<Patient> _result = new ArrayList<Patient>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Patient _item;
        _item = new Patient();
        final Long _tmpCdPaciente;
        if (_cursor.isNull(_cursorIndexOfCdPaciente)) {
          _tmpCdPaciente = null;
        } else {
          _tmpCdPaciente = _cursor.getLong(_cursorIndexOfCdPaciente);
        }
        _item.setCdPaciente(_tmpCdPaciente);
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        _item.setNome(_tmpNome);
        final String _tmpEndereco;
        _tmpEndereco = _cursor.getString(_cursorIndexOfEndereco);
        _item.setEndereco(_tmpEndereco);
        final String _tmpBairro;
        _tmpBairro = _cursor.getString(_cursorIndexOfBairro);
        _item.setBairro(_tmpBairro);
        final String _tmpCidade;
        _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
        _item.setCidade(_tmpCidade);
        final String _tmpUF;
        _tmpUF = _cursor.getString(_cursorIndexOfUF);
        _item.setUF(_tmpUF);
        final String _tmpCEP;
        _tmpCEP = _cursor.getString(_cursorIndexOfCEP);
        _item.setCEP(_tmpCEP);
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _item.setTelefone(_tmpTelefone);
        final Long _tmpCdJDEOperadora;
        if (_cursor.isNull(_cursorIndexOfCdJDEOperadora)) {
          _tmpCdJDEOperadora = null;
        } else {
          _tmpCdJDEOperadora = _cursor.getLong(_cursorIndexOfCdJDEOperadora);
        }
        _item.setCdJDEOperadora(_tmpCdJDEOperadora);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _item.setCnpj(_tmpCnpj);
        final String _tmpFlDistribGas;
        _tmpFlDistribGas = _cursor.getString(_cursorIndexOfFlDistribGas);
        _item.setFlDistribGas(_tmpFlDistribGas);
        final String _tmpPrecoDiferente;
        _tmpPrecoDiferente = _cursor.getString(_cursorIndexOfPrecoDiferente);
        _item.setPrecoDiferente(_tmpPrecoDiferente);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Patient findById(Long cdPaciente) {
    final String _sql = "SELECT * FROM Patient WHERE cdPaciente = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdPaciente == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdPaciente);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdPaciente = _cursor.getColumnIndexOrThrow("cdPaciente");
      final int _cursorIndexOfNome = _cursor.getColumnIndexOrThrow("nome");
      final int _cursorIndexOfEndereco = _cursor.getColumnIndexOrThrow("endereco");
      final int _cursorIndexOfBairro = _cursor.getColumnIndexOrThrow("bairro");
      final int _cursorIndexOfCidade = _cursor.getColumnIndexOrThrow("cidade");
      final int _cursorIndexOfUF = _cursor.getColumnIndexOrThrow("UF");
      final int _cursorIndexOfCEP = _cursor.getColumnIndexOrThrow("CEP");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfCdJDEOperadora = _cursor.getColumnIndexOrThrow("cdJDEOperadora");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfFlDistribGas = _cursor.getColumnIndexOrThrow("flDistribGas");
      final int _cursorIndexOfPrecoDiferente = _cursor.getColumnIndexOrThrow("precoDiferente");
      final Patient _result;
      if(_cursor.moveToFirst()) {
        _result = new Patient();
        final Long _tmpCdPaciente;
        if (_cursor.isNull(_cursorIndexOfCdPaciente)) {
          _tmpCdPaciente = null;
        } else {
          _tmpCdPaciente = _cursor.getLong(_cursorIndexOfCdPaciente);
        }
        _result.setCdPaciente(_tmpCdPaciente);
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        _result.setNome(_tmpNome);
        final String _tmpEndereco;
        _tmpEndereco = _cursor.getString(_cursorIndexOfEndereco);
        _result.setEndereco(_tmpEndereco);
        final String _tmpBairro;
        _tmpBairro = _cursor.getString(_cursorIndexOfBairro);
        _result.setBairro(_tmpBairro);
        final String _tmpCidade;
        _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
        _result.setCidade(_tmpCidade);
        final String _tmpUF;
        _tmpUF = _cursor.getString(_cursorIndexOfUF);
        _result.setUF(_tmpUF);
        final String _tmpCEP;
        _tmpCEP = _cursor.getString(_cursorIndexOfCEP);
        _result.setCEP(_tmpCEP);
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _result.setTelefone(_tmpTelefone);
        final Long _tmpCdJDEOperadora;
        if (_cursor.isNull(_cursorIndexOfCdJDEOperadora)) {
          _tmpCdJDEOperadora = null;
        } else {
          _tmpCdJDEOperadora = _cursor.getLong(_cursorIndexOfCdJDEOperadora);
        }
        _result.setCdJDEOperadora(_tmpCdJDEOperadora);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _result.setCnpj(_tmpCnpj);
        final String _tmpFlDistribGas;
        _tmpFlDistribGas = _cursor.getString(_cursorIndexOfFlDistribGas);
        _result.setFlDistribGas(_tmpFlDistribGas);
        final String _tmpPrecoDiferente;
        _tmpPrecoDiferente = _cursor.getString(_cursorIndexOfPrecoDiferente);
        _result.setPrecoDiferente(_tmpPrecoDiferente);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
