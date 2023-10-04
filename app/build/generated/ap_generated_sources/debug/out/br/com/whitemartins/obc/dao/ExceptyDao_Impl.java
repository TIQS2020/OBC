package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.Excepty;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class ExceptyDao_Impl implements ExceptyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfExcepty;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfExcepty;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfExcepty;

  public ExceptyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExcepty = new EntityInsertionAdapter<Excepty>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Excepty`(`cdCustomer`,`cdExcept`,`dataHoraEntrada`,`tipo`,`odometro`,`dataHoraSaida`,`numeroViagem`,`dataViagem`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Excepty value) {
        if (value.getCdCustomer() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdCustomer());
        }
        if (value.getCdExcept() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdExcept());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataHoraEntrada());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        if (value.getTipo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTipo());
        }
        if (value.getOdometro() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getOdometro());
        }
        final Long _tmp_1;
        _tmp_1 = DateTypeConverter.dateToTimestamp(value.getDataHoraSaida());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_1);
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getNumeroViagem());
        }
        final Long _tmp_2;
        _tmp_2 = DateTypeConverter.dateToTimestamp(value.getDataViagem());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_2);
        }
      }
    };
    this.__deletionAdapterOfExcepty = new EntityDeletionOrUpdateAdapter<Excepty>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Excepty` WHERE `cdCustomer` = ? AND `cdExcept` = ? AND `dataHoraEntrada` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Excepty value) {
        if (value.getCdCustomer() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdCustomer());
        }
        if (value.getCdExcept() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdExcept());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataHoraEntrada());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
      }
    };
    this.__updateAdapterOfExcepty = new EntityDeletionOrUpdateAdapter<Excepty>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Excepty` SET `cdCustomer` = ?,`cdExcept` = ?,`dataHoraEntrada` = ?,`tipo` = ?,`odometro` = ?,`dataHoraSaida` = ?,`numeroViagem` = ?,`dataViagem` = ? WHERE `cdCustomer` = ? AND `cdExcept` = ? AND `dataHoraEntrada` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Excepty value) {
        if (value.getCdCustomer() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdCustomer());
        }
        if (value.getCdExcept() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdExcept());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataHoraEntrada());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        if (value.getTipo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTipo());
        }
        if (value.getOdometro() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getOdometro());
        }
        final Long _tmp_1;
        _tmp_1 = DateTypeConverter.dateToTimestamp(value.getDataHoraSaida());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_1);
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getNumeroViagem());
        }
        final Long _tmp_2;
        _tmp_2 = DateTypeConverter.dateToTimestamp(value.getDataViagem());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_2);
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getCdCustomer());
        }
        if (value.getCdExcept() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getCdExcept());
        }
        final Long _tmp_3;
        _tmp_3 = DateTypeConverter.dateToTimestamp(value.getDataHoraEntrada());
        if (_tmp_3 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp_3);
        }
      }
    };
  }

  @Override
  public void insert(Excepty Excepty) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfExcepty.insert(Excepty);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Excepty Excepty) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfExcepty.handle(Excepty);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Excepty> excepties) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfExcepty.handleMultiple(excepties);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Excepty Excepty) {
    __db.beginTransaction();
    try {
      __updateAdapterOfExcepty.handle(Excepty);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Excepty> getAll() {
    final String _sql = "SELECT * FROM Excepty";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdExcept = _cursor.getColumnIndexOrThrow("cdExcept");
      final int _cursorIndexOfDataHoraEntrada = _cursor.getColumnIndexOrThrow("dataHoraEntrada");
      final int _cursorIndexOfTipo = _cursor.getColumnIndexOrThrow("tipo");
      final int _cursorIndexOfOdometro = _cursor.getColumnIndexOrThrow("odometro");
      final int _cursorIndexOfDataHoraSaida = _cursor.getColumnIndexOrThrow("dataHoraSaida");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final List<Excepty> _result = new ArrayList<Excepty>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Excepty _item;
        _item = new Excepty();
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Long _tmpCdExcept;
        if (_cursor.isNull(_cursorIndexOfCdExcept)) {
          _tmpCdExcept = null;
        } else {
          _tmpCdExcept = _cursor.getLong(_cursorIndexOfCdExcept);
        }
        _item.setCdExcept(_tmpCdExcept);
        final Date _tmpDataHoraEntrada;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataHoraEntrada)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataHoraEntrada);
        }
        _tmpDataHoraEntrada = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataHoraEntrada(_tmpDataHoraEntrada);
        final String _tmpTipo;
        _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        _item.setTipo(_tmpTipo);
        final Long _tmpOdometro;
        if (_cursor.isNull(_cursorIndexOfOdometro)) {
          _tmpOdometro = null;
        } else {
          _tmpOdometro = _cursor.getLong(_cursorIndexOfOdometro);
        }
        _item.setOdometro(_tmpOdometro);
        final Date _tmpDataHoraSaida;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataHoraSaida)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataHoraSaida);
        }
        _tmpDataHoraSaida = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDataHoraSaida(_tmpDataHoraSaida);
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _item.setNumeroViagem(_tmpNumeroViagem);
        final Date _tmpDataViagem;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataViagem)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataViagem);
        }
        _tmpDataViagem = DateTypeConverter.fromTimestamp(_tmp_2);
        _item.setDataViagem(_tmpDataViagem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
