package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.ConversaoLQ;
import java.lang.Double;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ConversionLQDao_Impl implements ConversionLQDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfConversaoLQ;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfConversaoLQ;

  public ConversionLQDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfConversaoLQ = new EntityInsertionAdapter<ConversaoLQ>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ConversaoLQ`(`numeroWM`,`cdJDECliente`,`numeroSerieTanque`,`capacidadeKG`,`capacidadePol`,`fatorConversao`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConversaoLQ value) {
        if (value.getNumeroWM() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroWM());
        }
        if (value.getCdJDECliente() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdJDECliente());
        }
        if (value.getNumeroSerieTanque() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNumeroSerieTanque());
        }
        if (value.getCapacidadeKG() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getCapacidadeKG());
        }
        if (value.getCapacidadePol() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getCapacidadePol());
        }
        if (value.getFatorConversao() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getFatorConversao());
        }
      }
    };
    this.__deletionAdapterOfConversaoLQ = new EntityDeletionOrUpdateAdapter<ConversaoLQ>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ConversaoLQ` WHERE `cdJDECliente` = ? AND `numeroSerieTanque` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ConversaoLQ value) {
        if (value.getCdJDECliente() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdJDECliente());
        }
        if (value.getNumeroSerieTanque() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNumeroSerieTanque());
        }
      }
    };
  }

  @Override
  public void insert(ConversaoLQ conversaoLQ) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfConversaoLQ.insert(conversaoLQ);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(ConversaoLQ conversaoLQ) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfConversaoLQ.handle(conversaoLQ);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<ConversaoLQ> conversaoLQS) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfConversaoLQ.handleMultiple(conversaoLQS);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ConversaoLQ> getAll() {
    final String _sql = "SELECT * FROM ConversaoLQ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroWM = _cursor.getColumnIndexOrThrow("numeroWM");
      final int _cursorIndexOfCdJDECliente = _cursor.getColumnIndexOrThrow("cdJDECliente");
      final int _cursorIndexOfNumeroSerieTanque = _cursor.getColumnIndexOrThrow("numeroSerieTanque");
      final int _cursorIndexOfCapacidadeKG = _cursor.getColumnIndexOrThrow("capacidadeKG");
      final int _cursorIndexOfCapacidadePol = _cursor.getColumnIndexOrThrow("capacidadePol");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final List<ConversaoLQ> _result = new ArrayList<ConversaoLQ>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ConversaoLQ _item;
        _item = new ConversaoLQ();
        final Long _tmpNumeroWM;
        if (_cursor.isNull(_cursorIndexOfNumeroWM)) {
          _tmpNumeroWM = null;
        } else {
          _tmpNumeroWM = _cursor.getLong(_cursorIndexOfNumeroWM);
        }
        _item.setNumeroWM(_tmpNumeroWM);
        final Long _tmpCdJDECliente;
        if (_cursor.isNull(_cursorIndexOfCdJDECliente)) {
          _tmpCdJDECliente = null;
        } else {
          _tmpCdJDECliente = _cursor.getLong(_cursorIndexOfCdJDECliente);
        }
        _item.setCdJDECliente(_tmpCdJDECliente);
        final String _tmpNumeroSerieTanque;
        _tmpNumeroSerieTanque = _cursor.getString(_cursorIndexOfNumeroSerieTanque);
        _item.setNumeroSerieTanque(_tmpNumeroSerieTanque);
        final Double _tmpCapacidadeKG;
        if (_cursor.isNull(_cursorIndexOfCapacidadeKG)) {
          _tmpCapacidadeKG = null;
        } else {
          _tmpCapacidadeKG = _cursor.getDouble(_cursorIndexOfCapacidadeKG);
        }
        _item.setCapacidadeKG(_tmpCapacidadeKG);
        final Double _tmpCapacidadePol;
        if (_cursor.isNull(_cursorIndexOfCapacidadePol)) {
          _tmpCapacidadePol = null;
        } else {
          _tmpCapacidadePol = _cursor.getDouble(_cursorIndexOfCapacidadePol);
        }
        _item.setCapacidadePol(_tmpCapacidadePol);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _item.setFatorConversao(_tmpFatorConversao);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ConversaoLQ findById(Long numeroWM) {
    final String _sql = "SELECT * FROM ConversaoLQ WHERE numeroWM = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numeroWM == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroWM);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroWM = _cursor.getColumnIndexOrThrow("numeroWM");
      final int _cursorIndexOfCdJDECliente = _cursor.getColumnIndexOrThrow("cdJDECliente");
      final int _cursorIndexOfNumeroSerieTanque = _cursor.getColumnIndexOrThrow("numeroSerieTanque");
      final int _cursorIndexOfCapacidadeKG = _cursor.getColumnIndexOrThrow("capacidadeKG");
      final int _cursorIndexOfCapacidadePol = _cursor.getColumnIndexOrThrow("capacidadePol");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final ConversaoLQ _result;
      if(_cursor.moveToFirst()) {
        _result = new ConversaoLQ();
        final Long _tmpNumeroWM;
        if (_cursor.isNull(_cursorIndexOfNumeroWM)) {
          _tmpNumeroWM = null;
        } else {
          _tmpNumeroWM = _cursor.getLong(_cursorIndexOfNumeroWM);
        }
        _result.setNumeroWM(_tmpNumeroWM);
        final Long _tmpCdJDECliente;
        if (_cursor.isNull(_cursorIndexOfCdJDECliente)) {
          _tmpCdJDECliente = null;
        } else {
          _tmpCdJDECliente = _cursor.getLong(_cursorIndexOfCdJDECliente);
        }
        _result.setCdJDECliente(_tmpCdJDECliente);
        final String _tmpNumeroSerieTanque;
        _tmpNumeroSerieTanque = _cursor.getString(_cursorIndexOfNumeroSerieTanque);
        _result.setNumeroSerieTanque(_tmpNumeroSerieTanque);
        final Double _tmpCapacidadeKG;
        if (_cursor.isNull(_cursorIndexOfCapacidadeKG)) {
          _tmpCapacidadeKG = null;
        } else {
          _tmpCapacidadeKG = _cursor.getDouble(_cursorIndexOfCapacidadeKG);
        }
        _result.setCapacidadeKG(_tmpCapacidadeKG);
        final Double _tmpCapacidadePol;
        if (_cursor.isNull(_cursorIndexOfCapacidadePol)) {
          _tmpCapacidadePol = null;
        } else {
          _tmpCapacidadePol = _cursor.getDouble(_cursorIndexOfCapacidadePol);
        }
        _result.setCapacidadePol(_tmpCapacidadePol);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _result.setFatorConversao(_tmpFatorConversao);
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
  public List<ConversaoLQ> find(Long cdJDECliente) {
    final String _sql = "SELECT * FROM ConversaoLQ WHERE cdJDECliente = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdJDECliente == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdJDECliente);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroWM = _cursor.getColumnIndexOrThrow("numeroWM");
      final int _cursorIndexOfCdJDECliente = _cursor.getColumnIndexOrThrow("cdJDECliente");
      final int _cursorIndexOfNumeroSerieTanque = _cursor.getColumnIndexOrThrow("numeroSerieTanque");
      final int _cursorIndexOfCapacidadeKG = _cursor.getColumnIndexOrThrow("capacidadeKG");
      final int _cursorIndexOfCapacidadePol = _cursor.getColumnIndexOrThrow("capacidadePol");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final List<ConversaoLQ> _result = new ArrayList<ConversaoLQ>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ConversaoLQ _item;
        _item = new ConversaoLQ();
        final Long _tmpNumeroWM;
        if (_cursor.isNull(_cursorIndexOfNumeroWM)) {
          _tmpNumeroWM = null;
        } else {
          _tmpNumeroWM = _cursor.getLong(_cursorIndexOfNumeroWM);
        }
        _item.setNumeroWM(_tmpNumeroWM);
        final Long _tmpCdJDECliente;
        if (_cursor.isNull(_cursorIndexOfCdJDECliente)) {
          _tmpCdJDECliente = null;
        } else {
          _tmpCdJDECliente = _cursor.getLong(_cursorIndexOfCdJDECliente);
        }
        _item.setCdJDECliente(_tmpCdJDECliente);
        final String _tmpNumeroSerieTanque;
        _tmpNumeroSerieTanque = _cursor.getString(_cursorIndexOfNumeroSerieTanque);
        _item.setNumeroSerieTanque(_tmpNumeroSerieTanque);
        final Double _tmpCapacidadeKG;
        if (_cursor.isNull(_cursorIndexOfCapacidadeKG)) {
          _tmpCapacidadeKG = null;
        } else {
          _tmpCapacidadeKG = _cursor.getDouble(_cursorIndexOfCapacidadeKG);
        }
        _item.setCapacidadeKG(_tmpCapacidadeKG);
        final Double _tmpCapacidadePol;
        if (_cursor.isNull(_cursorIndexOfCapacidadePol)) {
          _tmpCapacidadePol = null;
        } else {
          _tmpCapacidadePol = _cursor.getDouble(_cursorIndexOfCapacidadePol);
        }
        _item.setCapacidadePol(_tmpCapacidadePol);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _item.setFatorConversao(_tmpFatorConversao);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ConversaoLQ find(Long cdJDECliente, Long numeroWM, String numeroSerieTanque) {
    final String _sql = "SELECT * FROM ConversaoLQ WHERE cdJDECliente = ? AND numeroWM = ? AND numeroSerieTanque = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (cdJDECliente == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdJDECliente);
    }
    _argIndex = 2;
    if (numeroWM == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroWM);
    }
    _argIndex = 3;
    if (numeroSerieTanque == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroSerieTanque);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroWM = _cursor.getColumnIndexOrThrow("numeroWM");
      final int _cursorIndexOfCdJDECliente = _cursor.getColumnIndexOrThrow("cdJDECliente");
      final int _cursorIndexOfNumeroSerieTanque = _cursor.getColumnIndexOrThrow("numeroSerieTanque");
      final int _cursorIndexOfCapacidadeKG = _cursor.getColumnIndexOrThrow("capacidadeKG");
      final int _cursorIndexOfCapacidadePol = _cursor.getColumnIndexOrThrow("capacidadePol");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final ConversaoLQ _result;
      if(_cursor.moveToFirst()) {
        _result = new ConversaoLQ();
        final Long _tmpNumeroWM;
        if (_cursor.isNull(_cursorIndexOfNumeroWM)) {
          _tmpNumeroWM = null;
        } else {
          _tmpNumeroWM = _cursor.getLong(_cursorIndexOfNumeroWM);
        }
        _result.setNumeroWM(_tmpNumeroWM);
        final Long _tmpCdJDECliente;
        if (_cursor.isNull(_cursorIndexOfCdJDECliente)) {
          _tmpCdJDECliente = null;
        } else {
          _tmpCdJDECliente = _cursor.getLong(_cursorIndexOfCdJDECliente);
        }
        _result.setCdJDECliente(_tmpCdJDECliente);
        final String _tmpNumeroSerieTanque;
        _tmpNumeroSerieTanque = _cursor.getString(_cursorIndexOfNumeroSerieTanque);
        _result.setNumeroSerieTanque(_tmpNumeroSerieTanque);
        final Double _tmpCapacidadeKG;
        if (_cursor.isNull(_cursorIndexOfCapacidadeKG)) {
          _tmpCapacidadeKG = null;
        } else {
          _tmpCapacidadeKG = _cursor.getDouble(_cursorIndexOfCapacidadeKG);
        }
        _result.setCapacidadeKG(_tmpCapacidadeKG);
        final Double _tmpCapacidadePol;
        if (_cursor.isNull(_cursorIndexOfCapacidadePol)) {
          _tmpCapacidadePol = null;
        } else {
          _tmpCapacidadePol = _cursor.getDouble(_cursorIndexOfCapacidadePol);
        }
        _result.setCapacidadePol(_tmpCapacidadePol);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _result.setFatorConversao(_tmpFatorConversao);
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
