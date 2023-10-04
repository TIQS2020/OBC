package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.Daily;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class DailyDao_Impl implements DailyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfDaily;

  private final EntityInsertionAdapter __insertionAdapterOfDaily_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfDaily;

  public DailyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDaily = new EntityInsertionAdapter<Daily>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Daily`(`numeroViagem`,`dataHoraInicio`,`odometroInicial`,`dataHoraFim`,`odometroFinal`,`rota`,`veiculo`,`filial`,`versao`,`modeloDocViagem`,`dataViagem`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Daily value) {
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroViagem());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataHoraInicio());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        if (value.getOdometroInicial() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getOdometroInicial());
        }
        final Long _tmp_1;
        _tmp_1 = DateTypeConverter.dateToTimestamp(value.getDataHoraFim());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp_1);
        }
        if (value.getOdometroFinal() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getOdometroFinal());
        }
        if (value.getRota() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getRota());
        }
        if (value.getVeiculo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getVeiculo());
        }
        if (value.getFilial() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFilial());
        }
        if (value.getVersao() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getVersao());
        }
        if (value.getModeloDocViagem() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getModeloDocViagem());
        }
        if (value.getDataViagem() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDataViagem());
        }
      }
    };
    this.__insertionAdapterOfDaily_1 = new EntityInsertionAdapter<Daily>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Daily`(`numeroViagem`,`dataHoraInicio`,`odometroInicial`,`dataHoraFim`,`odometroFinal`,`rota`,`veiculo`,`filial`,`versao`,`modeloDocViagem`,`dataViagem`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Daily value) {
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroViagem());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataHoraInicio());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        if (value.getOdometroInicial() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getOdometroInicial());
        }
        final Long _tmp_1;
        _tmp_1 = DateTypeConverter.dateToTimestamp(value.getDataHoraFim());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp_1);
        }
        if (value.getOdometroFinal() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getOdometroFinal());
        }
        if (value.getRota() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getRota());
        }
        if (value.getVeiculo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getVeiculo());
        }
        if (value.getFilial() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFilial());
        }
        if (value.getVersao() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getVersao());
        }
        if (value.getModeloDocViagem() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getModeloDocViagem());
        }
        if (value.getDataViagem() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDataViagem());
        }
      }
    };
    this.__deletionAdapterOfDaily = new EntityDeletionOrUpdateAdapter<Daily>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Daily` WHERE `numeroViagem` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Daily value) {
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroViagem());
        }
      }
    };
  }

  @Override
  public void insertAll(List<Daily> dailies) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfDaily.insert(dailies);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(Daily daily) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfDaily_1.insert(daily);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Daily daily) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfDaily.handle(daily);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Daily> clients) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfDaily.handleMultiple(clients);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Daily> getAll() {
    final String _sql = "SELECT * FROM Daily";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataHoraInicio = _cursor.getColumnIndexOrThrow("dataHoraInicio");
      final int _cursorIndexOfOdometroInicial = _cursor.getColumnIndexOrThrow("odometroInicial");
      final int _cursorIndexOfDataHoraFim = _cursor.getColumnIndexOrThrow("dataHoraFim");
      final int _cursorIndexOfOdometroFinal = _cursor.getColumnIndexOrThrow("odometroFinal");
      final int _cursorIndexOfRota = _cursor.getColumnIndexOrThrow("rota");
      final int _cursorIndexOfVeiculo = _cursor.getColumnIndexOrThrow("veiculo");
      final int _cursorIndexOfFilial = _cursor.getColumnIndexOrThrow("filial");
      final int _cursorIndexOfVersao = _cursor.getColumnIndexOrThrow("versao");
      final int _cursorIndexOfModeloDocViagem = _cursor.getColumnIndexOrThrow("modeloDocViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final List<Daily> _result = new ArrayList<Daily>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Daily _item;
        _item = new Daily();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _item.setNumeroViagem(_tmpNumeroViagem);
        final Date _tmpDataHoraInicio;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataHoraInicio)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataHoraInicio);
        }
        _tmpDataHoraInicio = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataHoraInicio(_tmpDataHoraInicio);
        final Long _tmpOdometroInicial;
        if (_cursor.isNull(_cursorIndexOfOdometroInicial)) {
          _tmpOdometroInicial = null;
        } else {
          _tmpOdometroInicial = _cursor.getLong(_cursorIndexOfOdometroInicial);
        }
        _item.setOdometroInicial(_tmpOdometroInicial);
        final Date _tmpDataHoraFim;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataHoraFim)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataHoraFim);
        }
        _tmpDataHoraFim = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDataHoraFim(_tmpDataHoraFim);
        final Long _tmpOdometroFinal;
        if (_cursor.isNull(_cursorIndexOfOdometroFinal)) {
          _tmpOdometroFinal = null;
        } else {
          _tmpOdometroFinal = _cursor.getLong(_cursorIndexOfOdometroFinal);
        }
        _item.setOdometroFinal(_tmpOdometroFinal);
        final Integer _tmpRota;
        if (_cursor.isNull(_cursorIndexOfRota)) {
          _tmpRota = null;
        } else {
          _tmpRota = _cursor.getInt(_cursorIndexOfRota);
        }
        _item.setRota(_tmpRota);
        final String _tmpVeiculo;
        _tmpVeiculo = _cursor.getString(_cursorIndexOfVeiculo);
        _item.setVeiculo(_tmpVeiculo);
        final String _tmpFilial;
        _tmpFilial = _cursor.getString(_cursorIndexOfFilial);
        _item.setFilial(_tmpFilial);
        final String _tmpVersao;
        _tmpVersao = _cursor.getString(_cursorIndexOfVersao);
        _item.setVersao(_tmpVersao);
        final Integer _tmpModeloDocViagem;
        if (_cursor.isNull(_cursorIndexOfModeloDocViagem)) {
          _tmpModeloDocViagem = null;
        } else {
          _tmpModeloDocViagem = _cursor.getInt(_cursorIndexOfModeloDocViagem);
        }
        _item.setModeloDocViagem(_tmpModeloDocViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _item.setDataViagem(_tmpDataViagem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Daily findByNumViagem(Long numeroViagem) {
    final String _sql = "SELECT * FROM Daily WHERE numeroViagem = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroViagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataHoraInicio = _cursor.getColumnIndexOrThrow("dataHoraInicio");
      final int _cursorIndexOfOdometroInicial = _cursor.getColumnIndexOrThrow("odometroInicial");
      final int _cursorIndexOfDataHoraFim = _cursor.getColumnIndexOrThrow("dataHoraFim");
      final int _cursorIndexOfOdometroFinal = _cursor.getColumnIndexOrThrow("odometroFinal");
      final int _cursorIndexOfRota = _cursor.getColumnIndexOrThrow("rota");
      final int _cursorIndexOfVeiculo = _cursor.getColumnIndexOrThrow("veiculo");
      final int _cursorIndexOfFilial = _cursor.getColumnIndexOrThrow("filial");
      final int _cursorIndexOfVersao = _cursor.getColumnIndexOrThrow("versao");
      final int _cursorIndexOfModeloDocViagem = _cursor.getColumnIndexOrThrow("modeloDocViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final Daily _result;
      if(_cursor.moveToFirst()) {
        _result = new Daily();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _result.setNumeroViagem(_tmpNumeroViagem);
        final Date _tmpDataHoraInicio;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataHoraInicio)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataHoraInicio);
        }
        _tmpDataHoraInicio = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataHoraInicio(_tmpDataHoraInicio);
        final Long _tmpOdometroInicial;
        if (_cursor.isNull(_cursorIndexOfOdometroInicial)) {
          _tmpOdometroInicial = null;
        } else {
          _tmpOdometroInicial = _cursor.getLong(_cursorIndexOfOdometroInicial);
        }
        _result.setOdometroInicial(_tmpOdometroInicial);
        final Date _tmpDataHoraFim;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataHoraFim)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataHoraFim);
        }
        _tmpDataHoraFim = DateTypeConverter.fromTimestamp(_tmp_1);
        _result.setDataHoraFim(_tmpDataHoraFim);
        final Long _tmpOdometroFinal;
        if (_cursor.isNull(_cursorIndexOfOdometroFinal)) {
          _tmpOdometroFinal = null;
        } else {
          _tmpOdometroFinal = _cursor.getLong(_cursorIndexOfOdometroFinal);
        }
        _result.setOdometroFinal(_tmpOdometroFinal);
        final Integer _tmpRota;
        if (_cursor.isNull(_cursorIndexOfRota)) {
          _tmpRota = null;
        } else {
          _tmpRota = _cursor.getInt(_cursorIndexOfRota);
        }
        _result.setRota(_tmpRota);
        final String _tmpVeiculo;
        _tmpVeiculo = _cursor.getString(_cursorIndexOfVeiculo);
        _result.setVeiculo(_tmpVeiculo);
        final String _tmpFilial;
        _tmpFilial = _cursor.getString(_cursorIndexOfFilial);
        _result.setFilial(_tmpFilial);
        final String _tmpVersao;
        _tmpVersao = _cursor.getString(_cursorIndexOfVersao);
        _result.setVersao(_tmpVersao);
        final Integer _tmpModeloDocViagem;
        if (_cursor.isNull(_cursorIndexOfModeloDocViagem)) {
          _tmpModeloDocViagem = null;
        } else {
          _tmpModeloDocViagem = _cursor.getInt(_cursorIndexOfModeloDocViagem);
        }
        _result.setModeloDocViagem(_tmpModeloDocViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _result.setDataViagem(_tmpDataViagem);
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
  public Daily findPrior(Long numeroViagem) {
    final String _sql = "SELECT * FROM Daily WHERE numeroViagem < ? ORDER BY numeroViagem DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroViagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataHoraInicio = _cursor.getColumnIndexOrThrow("dataHoraInicio");
      final int _cursorIndexOfOdometroInicial = _cursor.getColumnIndexOrThrow("odometroInicial");
      final int _cursorIndexOfDataHoraFim = _cursor.getColumnIndexOrThrow("dataHoraFim");
      final int _cursorIndexOfOdometroFinal = _cursor.getColumnIndexOrThrow("odometroFinal");
      final int _cursorIndexOfRota = _cursor.getColumnIndexOrThrow("rota");
      final int _cursorIndexOfVeiculo = _cursor.getColumnIndexOrThrow("veiculo");
      final int _cursorIndexOfFilial = _cursor.getColumnIndexOrThrow("filial");
      final int _cursorIndexOfVersao = _cursor.getColumnIndexOrThrow("versao");
      final int _cursorIndexOfModeloDocViagem = _cursor.getColumnIndexOrThrow("modeloDocViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final Daily _result;
      if(_cursor.moveToFirst()) {
        _result = new Daily();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _result.setNumeroViagem(_tmpNumeroViagem);
        final Date _tmpDataHoraInicio;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataHoraInicio)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataHoraInicio);
        }
        _tmpDataHoraInicio = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataHoraInicio(_tmpDataHoraInicio);
        final Long _tmpOdometroInicial;
        if (_cursor.isNull(_cursorIndexOfOdometroInicial)) {
          _tmpOdometroInicial = null;
        } else {
          _tmpOdometroInicial = _cursor.getLong(_cursorIndexOfOdometroInicial);
        }
        _result.setOdometroInicial(_tmpOdometroInicial);
        final Date _tmpDataHoraFim;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataHoraFim)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataHoraFim);
        }
        _tmpDataHoraFim = DateTypeConverter.fromTimestamp(_tmp_1);
        _result.setDataHoraFim(_tmpDataHoraFim);
        final Long _tmpOdometroFinal;
        if (_cursor.isNull(_cursorIndexOfOdometroFinal)) {
          _tmpOdometroFinal = null;
        } else {
          _tmpOdometroFinal = _cursor.getLong(_cursorIndexOfOdometroFinal);
        }
        _result.setOdometroFinal(_tmpOdometroFinal);
        final Integer _tmpRota;
        if (_cursor.isNull(_cursorIndexOfRota)) {
          _tmpRota = null;
        } else {
          _tmpRota = _cursor.getInt(_cursorIndexOfRota);
        }
        _result.setRota(_tmpRota);
        final String _tmpVeiculo;
        _tmpVeiculo = _cursor.getString(_cursorIndexOfVeiculo);
        _result.setVeiculo(_tmpVeiculo);
        final String _tmpFilial;
        _tmpFilial = _cursor.getString(_cursorIndexOfFilial);
        _result.setFilial(_tmpFilial);
        final String _tmpVersao;
        _tmpVersao = _cursor.getString(_cursorIndexOfVersao);
        _result.setVersao(_tmpVersao);
        final Integer _tmpModeloDocViagem;
        if (_cursor.isNull(_cursorIndexOfModeloDocViagem)) {
          _tmpModeloDocViagem = null;
        } else {
          _tmpModeloDocViagem = _cursor.getInt(_cursorIndexOfModeloDocViagem);
        }
        _result.setModeloDocViagem(_tmpModeloDocViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _result.setDataViagem(_tmpDataViagem);
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
