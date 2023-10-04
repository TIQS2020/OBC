package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.Search;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class SearchDao_Impl implements SearchDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSearch;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfSearch;

  public SearchDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSearch = new EntityInsertionAdapter<Search>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Search`(`id`,`cdCustomer`,`dtPesquisa`,`motorista`,`contato`,`cargo`,`telefone`,`rejeitada`,`idNota`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Search value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdCustomer());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDtPesquisa());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        if (value.getMotorista() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMotorista());
        }
        if (value.getContato() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getContato());
        }
        if (value.getCargo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCargo());
        }
        if (value.getTelefone() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTelefone());
        }
        if (value.getRejeitada() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRejeitada());
        }
        if (value.getIdNota() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getIdNota());
        }
      }
    };
    this.__deletionAdapterOfSearch = new EntityDeletionOrUpdateAdapter<Search>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Search` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Search value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
  }

  @Override
  public Long insert(Search search) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfSearch.insertAndReturnId(search);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Search> searches) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfSearch.handleMultiple(searches);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Search> getAll() {
    final String _sql = "SELECT * FROM Search";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfDtPesquisa = _cursor.getColumnIndexOrThrow("dtPesquisa");
      final int _cursorIndexOfMotorista = _cursor.getColumnIndexOrThrow("motorista");
      final int _cursorIndexOfContato = _cursor.getColumnIndexOrThrow("contato");
      final int _cursorIndexOfCargo = _cursor.getColumnIndexOrThrow("cargo");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfRejeitada = _cursor.getColumnIndexOrThrow("rejeitada");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final List<Search> _result = new ArrayList<Search>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Search _item;
        _item = new Search();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Date _tmpDtPesquisa;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDtPesquisa)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDtPesquisa);
        }
        _tmpDtPesquisa = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDtPesquisa(_tmpDtPesquisa);
        final String _tmpMotorista;
        _tmpMotorista = _cursor.getString(_cursorIndexOfMotorista);
        _item.setMotorista(_tmpMotorista);
        final String _tmpContato;
        _tmpContato = _cursor.getString(_cursorIndexOfContato);
        _item.setContato(_tmpContato);
        final String _tmpCargo;
        _tmpCargo = _cursor.getString(_cursorIndexOfCargo);
        _item.setCargo(_tmpCargo);
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _item.setTelefone(_tmpTelefone);
        final String _tmpRejeitada;
        _tmpRejeitada = _cursor.getString(_cursorIndexOfRejeitada);
        _item.setRejeitada(_tmpRejeitada);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Search findById(Long idNota) {
    final String _sql = "SELECT * FROM Search WHERE idNota = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfDtPesquisa = _cursor.getColumnIndexOrThrow("dtPesquisa");
      final int _cursorIndexOfMotorista = _cursor.getColumnIndexOrThrow("motorista");
      final int _cursorIndexOfContato = _cursor.getColumnIndexOrThrow("contato");
      final int _cursorIndexOfCargo = _cursor.getColumnIndexOrThrow("cargo");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfRejeitada = _cursor.getColumnIndexOrThrow("rejeitada");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final Search _result;
      if(_cursor.moveToFirst()) {
        _result = new Search();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final Date _tmpDtPesquisa;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDtPesquisa)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDtPesquisa);
        }
        _tmpDtPesquisa = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDtPesquisa(_tmpDtPesquisa);
        final String _tmpMotorista;
        _tmpMotorista = _cursor.getString(_cursorIndexOfMotorista);
        _result.setMotorista(_tmpMotorista);
        final String _tmpContato;
        _tmpContato = _cursor.getString(_cursorIndexOfContato);
        _result.setContato(_tmpContato);
        final String _tmpCargo;
        _tmpCargo = _cursor.getString(_cursorIndexOfCargo);
        _result.setCargo(_tmpCargo);
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _result.setTelefone(_tmpTelefone);
        final String _tmpRejeitada;
        _tmpRejeitada = _cursor.getString(_cursorIndexOfRejeitada);
        _result.setRejeitada(_tmpRejeitada);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _result.setIdNota(_tmpIdNota);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Search> find() {
    final String _sql = "SELECT * FROM Search WHERE idNota IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfDtPesquisa = _cursor.getColumnIndexOrThrow("dtPesquisa");
      final int _cursorIndexOfMotorista = _cursor.getColumnIndexOrThrow("motorista");
      final int _cursorIndexOfContato = _cursor.getColumnIndexOrThrow("contato");
      final int _cursorIndexOfCargo = _cursor.getColumnIndexOrThrow("cargo");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfRejeitada = _cursor.getColumnIndexOrThrow("rejeitada");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final List<Search> _result = new ArrayList<Search>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Search _item;
        _item = new Search();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Date _tmpDtPesquisa;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDtPesquisa)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDtPesquisa);
        }
        _tmpDtPesquisa = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDtPesquisa(_tmpDtPesquisa);
        final String _tmpMotorista;
        _tmpMotorista = _cursor.getString(_cursorIndexOfMotorista);
        _item.setMotorista(_tmpMotorista);
        final String _tmpContato;
        _tmpContato = _cursor.getString(_cursorIndexOfContato);
        _item.setContato(_tmpContato);
        final String _tmpCargo;
        _tmpCargo = _cursor.getString(_cursorIndexOfCargo);
        _item.setCargo(_tmpCargo);
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _item.setTelefone(_tmpTelefone);
        final String _tmpRejeitada;
        _tmpRejeitada = _cursor.getString(_cursorIndexOfRejeitada);
        _item.setRejeitada(_tmpRejeitada);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Search findOne() {
    final String _sql = "SELECT * FROM Search WHERE idNota IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfDtPesquisa = _cursor.getColumnIndexOrThrow("dtPesquisa");
      final int _cursorIndexOfMotorista = _cursor.getColumnIndexOrThrow("motorista");
      final int _cursorIndexOfContato = _cursor.getColumnIndexOrThrow("contato");
      final int _cursorIndexOfCargo = _cursor.getColumnIndexOrThrow("cargo");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfRejeitada = _cursor.getColumnIndexOrThrow("rejeitada");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final Search _result;
      if(_cursor.moveToFirst()) {
        _result = new Search();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final Date _tmpDtPesquisa;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDtPesquisa)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDtPesquisa);
        }
        _tmpDtPesquisa = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDtPesquisa(_tmpDtPesquisa);
        final String _tmpMotorista;
        _tmpMotorista = _cursor.getString(_cursorIndexOfMotorista);
        _result.setMotorista(_tmpMotorista);
        final String _tmpContato;
        _tmpContato = _cursor.getString(_cursorIndexOfContato);
        _result.setContato(_tmpContato);
        final String _tmpCargo;
        _tmpCargo = _cursor.getString(_cursorIndexOfCargo);
        _result.setCargo(_tmpCargo);
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _result.setTelefone(_tmpTelefone);
        final String _tmpRejeitada;
        _tmpRejeitada = _cursor.getString(_cursorIndexOfRejeitada);
        _result.setRejeitada(_tmpRejeitada);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _result.setIdNota(_tmpIdNota);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Search findByCustomer(Long cdCustomer, String dtPesquisa) {
    final String _sql = "SELECT * FROM Search WHERE cdCustomer = ?         AND date(dtPesquisa/1000, 'unixepoch') = ?       ORDER BY dtPesquisa DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2;
    if (dtPesquisa == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dtPesquisa);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfDtPesquisa = _cursor.getColumnIndexOrThrow("dtPesquisa");
      final int _cursorIndexOfMotorista = _cursor.getColumnIndexOrThrow("motorista");
      final int _cursorIndexOfContato = _cursor.getColumnIndexOrThrow("contato");
      final int _cursorIndexOfCargo = _cursor.getColumnIndexOrThrow("cargo");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfRejeitada = _cursor.getColumnIndexOrThrow("rejeitada");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final Search _result;
      if(_cursor.moveToFirst()) {
        _result = new Search();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final Date _tmpDtPesquisa;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDtPesquisa)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDtPesquisa);
        }
        _tmpDtPesquisa = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDtPesquisa(_tmpDtPesquisa);
        final String _tmpMotorista;
        _tmpMotorista = _cursor.getString(_cursorIndexOfMotorista);
        _result.setMotorista(_tmpMotorista);
        final String _tmpContato;
        _tmpContato = _cursor.getString(_cursorIndexOfContato);
        _result.setContato(_tmpContato);
        final String _tmpCargo;
        _tmpCargo = _cursor.getString(_cursorIndexOfCargo);
        _result.setCargo(_tmpCargo);
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _result.setTelefone(_tmpTelefone);
        final String _tmpRejeitada;
        _tmpRejeitada = _cursor.getString(_cursorIndexOfRejeitada);
        _result.setRejeitada(_tmpRejeitada);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _result.setIdNota(_tmpIdNota);
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
