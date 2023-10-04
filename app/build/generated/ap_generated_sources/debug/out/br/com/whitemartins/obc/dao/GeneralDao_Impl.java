package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.General;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class GeneralDao_Impl implements GeneralDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfGeneral;

  private final EntityInsertionAdapter __insertionAdapterOfGeneral_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfGeneral;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfGeneral;

  public GeneralDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGeneral = new EntityInsertionAdapter<General>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `General`(`id`,`numeroViagem`,`numeroNotaEntrada`,`serieNotaEntrada`,`numeroNotaSaida`,`serieNotaSaida`,`contadorSenha`,`flIndOriginalRefeita`,`beginTravelType`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, General value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getNumeroViagem());
        }
        if (value.getNumeroNotaEntrada() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getNumeroNotaEntrada());
        }
        if (value.getSerieNotaEntrada() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getSerieNotaEntrada());
        }
        if (value.getNumeroNotaSaida() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getNumeroNotaSaida());
        }
        if (value.getSerieNotaSaida() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getSerieNotaSaida());
        }
        if (value.getContadorSenha() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getContadorSenha());
        }
        if (value.getFlIndOriginalRefeita() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFlIndOriginalRefeita());
        }
        if (value.getBeginTravelType() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBeginTravelType());
        }
      }
    };
    this.__insertionAdapterOfGeneral_1 = new EntityInsertionAdapter<General>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `General`(`id`,`numeroViagem`,`numeroNotaEntrada`,`serieNotaEntrada`,`numeroNotaSaida`,`serieNotaSaida`,`contadorSenha`,`flIndOriginalRefeita`,`beginTravelType`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, General value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getNumeroViagem());
        }
        if (value.getNumeroNotaEntrada() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getNumeroNotaEntrada());
        }
        if (value.getSerieNotaEntrada() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getSerieNotaEntrada());
        }
        if (value.getNumeroNotaSaida() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getNumeroNotaSaida());
        }
        if (value.getSerieNotaSaida() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getSerieNotaSaida());
        }
        if (value.getContadorSenha() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getContadorSenha());
        }
        if (value.getFlIndOriginalRefeita() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFlIndOriginalRefeita());
        }
        if (value.getBeginTravelType() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBeginTravelType());
        }
      }
    };
    this.__deletionAdapterOfGeneral = new EntityDeletionOrUpdateAdapter<General>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `General` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, General value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfGeneral = new EntityDeletionOrUpdateAdapter<General>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `General` SET `id` = ?,`numeroViagem` = ?,`numeroNotaEntrada` = ?,`serieNotaEntrada` = ?,`numeroNotaSaida` = ?,`serieNotaSaida` = ?,`contadorSenha` = ?,`flIndOriginalRefeita` = ?,`beginTravelType` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, General value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getNumeroViagem());
        }
        if (value.getNumeroNotaEntrada() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getNumeroNotaEntrada());
        }
        if (value.getSerieNotaEntrada() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getSerieNotaEntrada());
        }
        if (value.getNumeroNotaSaida() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getNumeroNotaSaida());
        }
        if (value.getSerieNotaSaida() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getSerieNotaSaida());
        }
        if (value.getContadorSenha() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getContadorSenha());
        }
        if (value.getFlIndOriginalRefeita() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFlIndOriginalRefeita());
        }
        if (value.getBeginTravelType() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBeginTravelType());
        }
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getId());
        }
      }
    };
  }

  @Override
  public void insertAll(List<General> generals) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfGeneral.insert(generals);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(General general) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfGeneral_1.insert(general);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(General general) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfGeneral.handle(general);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<General> generals) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfGeneral.handleMultiple(generals);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(General general) {
    __db.beginTransaction();
    try {
      __updateAdapterOfGeneral.handle(general);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<General> getAll() {
    final String _sql = "SELECT * FROM General";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfNumeroNotaEntrada = _cursor.getColumnIndexOrThrow("numeroNotaEntrada");
      final int _cursorIndexOfSerieNotaEntrada = _cursor.getColumnIndexOrThrow("serieNotaEntrada");
      final int _cursorIndexOfNumeroNotaSaida = _cursor.getColumnIndexOrThrow("numeroNotaSaida");
      final int _cursorIndexOfSerieNotaSaida = _cursor.getColumnIndexOrThrow("serieNotaSaida");
      final int _cursorIndexOfContadorSenha = _cursor.getColumnIndexOrThrow("contadorSenha");
      final int _cursorIndexOfFlIndOriginalRefeita = _cursor.getColumnIndexOrThrow("flIndOriginalRefeita");
      final int _cursorIndexOfBeginTravelType = _cursor.getColumnIndexOrThrow("beginTravelType");
      final List<General> _result = new ArrayList<General>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final General _item;
        _item = new General();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _item.setNumeroViagem(_tmpNumeroViagem);
        final Long _tmpNumeroNotaEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaEntrada)) {
          _tmpNumeroNotaEntrada = null;
        } else {
          _tmpNumeroNotaEntrada = _cursor.getLong(_cursorIndexOfNumeroNotaEntrada);
        }
        _item.setNumeroNotaEntrada(_tmpNumeroNotaEntrada);
        final Long _tmpSerieNotaEntrada;
        if (_cursor.isNull(_cursorIndexOfSerieNotaEntrada)) {
          _tmpSerieNotaEntrada = null;
        } else {
          _tmpSerieNotaEntrada = _cursor.getLong(_cursorIndexOfSerieNotaEntrada);
        }
        _item.setSerieNotaEntrada(_tmpSerieNotaEntrada);
        final Long _tmpNumeroNotaSaida;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaSaida)) {
          _tmpNumeroNotaSaida = null;
        } else {
          _tmpNumeroNotaSaida = _cursor.getLong(_cursorIndexOfNumeroNotaSaida);
        }
        _item.setNumeroNotaSaida(_tmpNumeroNotaSaida);
        final Long _tmpSerieNotaSaida;
        if (_cursor.isNull(_cursorIndexOfSerieNotaSaida)) {
          _tmpSerieNotaSaida = null;
        } else {
          _tmpSerieNotaSaida = _cursor.getLong(_cursorIndexOfSerieNotaSaida);
        }
        _item.setSerieNotaSaida(_tmpSerieNotaSaida);
        final Integer _tmpContadorSenha;
        if (_cursor.isNull(_cursorIndexOfContadorSenha)) {
          _tmpContadorSenha = null;
        } else {
          _tmpContadorSenha = _cursor.getInt(_cursorIndexOfContadorSenha);
        }
        _item.setContadorSenha(_tmpContadorSenha);
        final String _tmpFlIndOriginalRefeita;
        _tmpFlIndOriginalRefeita = _cursor.getString(_cursorIndexOfFlIndOriginalRefeita);
        _item.setFlIndOriginalRefeita(_tmpFlIndOriginalRefeita);
        final String _tmpBeginTravelType;
        _tmpBeginTravelType = _cursor.getString(_cursorIndexOfBeginTravelType);
        _item.setBeginTravelType(_tmpBeginTravelType);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public General findById(Long numeroViagem) {
    final String _sql = "SELECT * FROM General WHERE numeroViagem = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroViagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfNumeroNotaEntrada = _cursor.getColumnIndexOrThrow("numeroNotaEntrada");
      final int _cursorIndexOfSerieNotaEntrada = _cursor.getColumnIndexOrThrow("serieNotaEntrada");
      final int _cursorIndexOfNumeroNotaSaida = _cursor.getColumnIndexOrThrow("numeroNotaSaida");
      final int _cursorIndexOfSerieNotaSaida = _cursor.getColumnIndexOrThrow("serieNotaSaida");
      final int _cursorIndexOfContadorSenha = _cursor.getColumnIndexOrThrow("contadorSenha");
      final int _cursorIndexOfFlIndOriginalRefeita = _cursor.getColumnIndexOrThrow("flIndOriginalRefeita");
      final int _cursorIndexOfBeginTravelType = _cursor.getColumnIndexOrThrow("beginTravelType");
      final General _result;
      if(_cursor.moveToFirst()) {
        _result = new General();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _result.setNumeroViagem(_tmpNumeroViagem);
        final Long _tmpNumeroNotaEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaEntrada)) {
          _tmpNumeroNotaEntrada = null;
        } else {
          _tmpNumeroNotaEntrada = _cursor.getLong(_cursorIndexOfNumeroNotaEntrada);
        }
        _result.setNumeroNotaEntrada(_tmpNumeroNotaEntrada);
        final Long _tmpSerieNotaEntrada;
        if (_cursor.isNull(_cursorIndexOfSerieNotaEntrada)) {
          _tmpSerieNotaEntrada = null;
        } else {
          _tmpSerieNotaEntrada = _cursor.getLong(_cursorIndexOfSerieNotaEntrada);
        }
        _result.setSerieNotaEntrada(_tmpSerieNotaEntrada);
        final Long _tmpNumeroNotaSaida;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaSaida)) {
          _tmpNumeroNotaSaida = null;
        } else {
          _tmpNumeroNotaSaida = _cursor.getLong(_cursorIndexOfNumeroNotaSaida);
        }
        _result.setNumeroNotaSaida(_tmpNumeroNotaSaida);
        final Long _tmpSerieNotaSaida;
        if (_cursor.isNull(_cursorIndexOfSerieNotaSaida)) {
          _tmpSerieNotaSaida = null;
        } else {
          _tmpSerieNotaSaida = _cursor.getLong(_cursorIndexOfSerieNotaSaida);
        }
        _result.setSerieNotaSaida(_tmpSerieNotaSaida);
        final Integer _tmpContadorSenha;
        if (_cursor.isNull(_cursorIndexOfContadorSenha)) {
          _tmpContadorSenha = null;
        } else {
          _tmpContadorSenha = _cursor.getInt(_cursorIndexOfContadorSenha);
        }
        _result.setContadorSenha(_tmpContadorSenha);
        final String _tmpFlIndOriginalRefeita;
        _tmpFlIndOriginalRefeita = _cursor.getString(_cursorIndexOfFlIndOriginalRefeita);
        _result.setFlIndOriginalRefeita(_tmpFlIndOriginalRefeita);
        final String _tmpBeginTravelType;
        _tmpBeginTravelType = _cursor.getString(_cursorIndexOfBeginTravelType);
        _result.setBeginTravelType(_tmpBeginTravelType);
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
  public General getGeneral() {
    final String _sql = "SELECT * FROM General LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfNumeroNotaEntrada = _cursor.getColumnIndexOrThrow("numeroNotaEntrada");
      final int _cursorIndexOfSerieNotaEntrada = _cursor.getColumnIndexOrThrow("serieNotaEntrada");
      final int _cursorIndexOfNumeroNotaSaida = _cursor.getColumnIndexOrThrow("numeroNotaSaida");
      final int _cursorIndexOfSerieNotaSaida = _cursor.getColumnIndexOrThrow("serieNotaSaida");
      final int _cursorIndexOfContadorSenha = _cursor.getColumnIndexOrThrow("contadorSenha");
      final int _cursorIndexOfFlIndOriginalRefeita = _cursor.getColumnIndexOrThrow("flIndOriginalRefeita");
      final int _cursorIndexOfBeginTravelType = _cursor.getColumnIndexOrThrow("beginTravelType");
      final General _result;
      if(_cursor.moveToFirst()) {
        _result = new General();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _result.setNumeroViagem(_tmpNumeroViagem);
        final Long _tmpNumeroNotaEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaEntrada)) {
          _tmpNumeroNotaEntrada = null;
        } else {
          _tmpNumeroNotaEntrada = _cursor.getLong(_cursorIndexOfNumeroNotaEntrada);
        }
        _result.setNumeroNotaEntrada(_tmpNumeroNotaEntrada);
        final Long _tmpSerieNotaEntrada;
        if (_cursor.isNull(_cursorIndexOfSerieNotaEntrada)) {
          _tmpSerieNotaEntrada = null;
        } else {
          _tmpSerieNotaEntrada = _cursor.getLong(_cursorIndexOfSerieNotaEntrada);
        }
        _result.setSerieNotaEntrada(_tmpSerieNotaEntrada);
        final Long _tmpNumeroNotaSaida;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaSaida)) {
          _tmpNumeroNotaSaida = null;
        } else {
          _tmpNumeroNotaSaida = _cursor.getLong(_cursorIndexOfNumeroNotaSaida);
        }
        _result.setNumeroNotaSaida(_tmpNumeroNotaSaida);
        final Long _tmpSerieNotaSaida;
        if (_cursor.isNull(_cursorIndexOfSerieNotaSaida)) {
          _tmpSerieNotaSaida = null;
        } else {
          _tmpSerieNotaSaida = _cursor.getLong(_cursorIndexOfSerieNotaSaida);
        }
        _result.setSerieNotaSaida(_tmpSerieNotaSaida);
        final Integer _tmpContadorSenha;
        if (_cursor.isNull(_cursorIndexOfContadorSenha)) {
          _tmpContadorSenha = null;
        } else {
          _tmpContadorSenha = _cursor.getInt(_cursorIndexOfContadorSenha);
        }
        _result.setContadorSenha(_tmpContadorSenha);
        final String _tmpFlIndOriginalRefeita;
        _tmpFlIndOriginalRefeita = _cursor.getString(_cursorIndexOfFlIndOriginalRefeita);
        _result.setFlIndOriginalRefeita(_tmpFlIndOriginalRefeita);
        final String _tmpBeginTravelType;
        _tmpBeginTravelType = _cursor.getString(_cursorIndexOfBeginTravelType);
        _result.setBeginTravelType(_tmpBeginTravelType);
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
