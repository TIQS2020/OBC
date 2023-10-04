package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.Travel;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class TravelDao_Impl implements TravelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTravel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTravel;

  public TravelDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTravel = new EntityInsertionAdapter<Travel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Travel`(`numeroViagem`,`dataViagem`,`sequencia`,`indViagemUsada`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Travel value) {
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroViagem());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataViagem());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        if (value.getSequencia() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getSequencia());
        }
        if (value.getIndViagemUsada() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIndViagemUsada());
        }
      }
    };
    this.__deletionAdapterOfTravel = new EntityDeletionOrUpdateAdapter<Travel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Travel` WHERE `numeroViagem` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Travel value) {
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroViagem());
        }
      }
    };
  }

  @Override
  public void insert(Travel travel) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTravel.insert(travel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Travel travel) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfTravel.handle(travel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Travel> travels) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfTravel.handleMultiple(travels);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Travel> getAll() {
    final String _sql = "SELECT * FROM Travel ORDER BY sequencia ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfSequencia = _cursor.getColumnIndexOrThrow("sequencia");
      final int _cursorIndexOfIndViagemUsada = _cursor.getColumnIndexOrThrow("indViagemUsada");
      final List<Travel> _result = new ArrayList<Travel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Travel _item;
        _item = new Travel();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _item.setNumeroViagem(_tmpNumeroViagem);
        final Date _tmpDataViagem;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataViagem)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataViagem);
        }
        _tmpDataViagem = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataViagem(_tmpDataViagem);
        final Integer _tmpSequencia;
        if (_cursor.isNull(_cursorIndexOfSequencia)) {
          _tmpSequencia = null;
        } else {
          _tmpSequencia = _cursor.getInt(_cursorIndexOfSequencia);
        }
        _item.setSequencia(_tmpSequencia);
        final String _tmpIndViagemUsada;
        _tmpIndViagemUsada = _cursor.getString(_cursorIndexOfIndViagemUsada);
        _item.setIndViagemUsada(_tmpIndViagemUsada);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Travel findById(long numeroViagem) {
    final String _sql = "SELECT * FROM Travel WHERE numeroViagem = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, numeroViagem);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfSequencia = _cursor.getColumnIndexOrThrow("sequencia");
      final int _cursorIndexOfIndViagemUsada = _cursor.getColumnIndexOrThrow("indViagemUsada");
      final Travel _result;
      if(_cursor.moveToFirst()) {
        _result = new Travel();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _result.setNumeroViagem(_tmpNumeroViagem);
        final Date _tmpDataViagem;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataViagem)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataViagem);
        }
        _tmpDataViagem = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataViagem(_tmpDataViagem);
        final Integer _tmpSequencia;
        if (_cursor.isNull(_cursorIndexOfSequencia)) {
          _tmpSequencia = null;
        } else {
          _tmpSequencia = _cursor.getInt(_cursorIndexOfSequencia);
        }
        _result.setSequencia(_tmpSequencia);
        final String _tmpIndViagemUsada;
        _tmpIndViagemUsada = _cursor.getString(_cursorIndexOfIndViagemUsada);
        _result.setIndViagemUsada(_tmpIndViagemUsada);
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
  public Travel findFirst() {
    final String _sql = "SELECT * FROM Travel ORDER BY sequencia ASC LIMIT 1 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfSequencia = _cursor.getColumnIndexOrThrow("sequencia");
      final int _cursorIndexOfIndViagemUsada = _cursor.getColumnIndexOrThrow("indViagemUsada");
      final Travel _result;
      if(_cursor.moveToFirst()) {
        _result = new Travel();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _result.setNumeroViagem(_tmpNumeroViagem);
        final Date _tmpDataViagem;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataViagem)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataViagem);
        }
        _tmpDataViagem = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataViagem(_tmpDataViagem);
        final Integer _tmpSequencia;
        if (_cursor.isNull(_cursorIndexOfSequencia)) {
          _tmpSequencia = null;
        } else {
          _tmpSequencia = _cursor.getInt(_cursorIndexOfSequencia);
        }
        _result.setSequencia(_tmpSequencia);
        final String _tmpIndViagemUsada;
        _tmpIndViagemUsada = _cursor.getString(_cursorIndexOfIndViagemUsada);
        _result.setIndViagemUsada(_tmpIndViagemUsada);
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
  public Travel findNext() {
    final String _sql = "SELECT * FROM Travel WHERE indViagemUsada = 'N' ORDER BY dataViagem LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfSequencia = _cursor.getColumnIndexOrThrow("sequencia");
      final int _cursorIndexOfIndViagemUsada = _cursor.getColumnIndexOrThrow("indViagemUsada");
      final Travel _result;
      if(_cursor.moveToFirst()) {
        _result = new Travel();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _result.setNumeroViagem(_tmpNumeroViagem);
        final Date _tmpDataViagem;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataViagem)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataViagem);
        }
        _tmpDataViagem = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataViagem(_tmpDataViagem);
        final Integer _tmpSequencia;
        if (_cursor.isNull(_cursorIndexOfSequencia)) {
          _tmpSequencia = null;
        } else {
          _tmpSequencia = _cursor.getInt(_cursorIndexOfSequencia);
        }
        _result.setSequencia(_tmpSequencia);
        final String _tmpIndViagemUsada;
        _tmpIndViagemUsada = _cursor.getString(_cursorIndexOfIndViagemUsada);
        _result.setIndViagemUsada(_tmpIndViagemUsada);
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
  public Travel findPrior(long numeroViagem) {
    final String _sql = "SELECT * FROM Travel WHERE indViagemUsada = 'Y'  AND numeroViagem < ? ORDER BY sequencia LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, numeroViagem);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfSequencia = _cursor.getColumnIndexOrThrow("sequencia");
      final int _cursorIndexOfIndViagemUsada = _cursor.getColumnIndexOrThrow("indViagemUsada");
      final Travel _result;
      if(_cursor.moveToFirst()) {
        _result = new Travel();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _result.setNumeroViagem(_tmpNumeroViagem);
        final Date _tmpDataViagem;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataViagem)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataViagem);
        }
        _tmpDataViagem = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataViagem(_tmpDataViagem);
        final Integer _tmpSequencia;
        if (_cursor.isNull(_cursorIndexOfSequencia)) {
          _tmpSequencia = null;
        } else {
          _tmpSequencia = _cursor.getInt(_cursorIndexOfSequencia);
        }
        _result.setSequencia(_tmpSequencia);
        final String _tmpIndViagemUsada;
        _tmpIndViagemUsada = _cursor.getString(_cursorIndexOfIndViagemUsada);
        _result.setIndViagemUsada(_tmpIndViagemUsada);
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
