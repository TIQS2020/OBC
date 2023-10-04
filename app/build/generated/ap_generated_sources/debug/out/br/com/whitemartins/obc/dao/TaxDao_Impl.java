package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.Tax;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class TaxDao_Impl implements TaxDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTax;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTax;

  public TaxDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTax = new EntityInsertionAdapter<Tax>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Tax`(`condPagto`,`descPagto`,`seqParcela`,`dtEmissao`,`dtParcela`,`percentual`,`indCondPagto`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tax value) {
        if (value.getCondPagto() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCondPagto());
        }
        if (value.getDescPagto() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescPagto());
        }
        if (value.getSeqParcela() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getSeqParcela());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDtEmissao());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        final Long _tmp_1;
        _tmp_1 = DateTypeConverter.dateToTimestamp(value.getDtParcela());
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_1);
        }
        if (value.getPercentual() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getPercentual());
        }
        if (value.getIndCondPagto() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getIndCondPagto());
        }
      }
    };
    this.__deletionAdapterOfTax = new EntityDeletionOrUpdateAdapter<Tax>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Tax` WHERE `condPagto` = ? AND `dtEmissao` = ? AND `dtParcela` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tax value) {
        if (value.getCondPagto() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCondPagto());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDtEmissao());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        final Long _tmp_1;
        _tmp_1 = DateTypeConverter.dateToTimestamp(value.getDtParcela());
        if (_tmp_1 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp_1);
        }
      }
    };
  }

  @Override
  public void insert(Tax tax) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTax.insert(tax);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Tax tax) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfTax.handle(tax);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Tax> taxes) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfTax.handleMultiple(taxes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Tax> getAll() {
    final String _sql = "SELECT * FROM Tax";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCondPagto = _cursor.getColumnIndexOrThrow("condPagto");
      final int _cursorIndexOfDescPagto = _cursor.getColumnIndexOrThrow("descPagto");
      final int _cursorIndexOfSeqParcela = _cursor.getColumnIndexOrThrow("seqParcela");
      final int _cursorIndexOfDtEmissao = _cursor.getColumnIndexOrThrow("dtEmissao");
      final int _cursorIndexOfDtParcela = _cursor.getColumnIndexOrThrow("dtParcela");
      final int _cursorIndexOfPercentual = _cursor.getColumnIndexOrThrow("percentual");
      final int _cursorIndexOfIndCondPagto = _cursor.getColumnIndexOrThrow("indCondPagto");
      final List<Tax> _result = new ArrayList<Tax>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Tax _item;
        _item = new Tax();
        final Integer _tmpCondPagto;
        if (_cursor.isNull(_cursorIndexOfCondPagto)) {
          _tmpCondPagto = null;
        } else {
          _tmpCondPagto = _cursor.getInt(_cursorIndexOfCondPagto);
        }
        _item.setCondPagto(_tmpCondPagto);
        final String _tmpDescPagto;
        _tmpDescPagto = _cursor.getString(_cursorIndexOfDescPagto);
        _item.setDescPagto(_tmpDescPagto);
        final Integer _tmpSeqParcela;
        if (_cursor.isNull(_cursorIndexOfSeqParcela)) {
          _tmpSeqParcela = null;
        } else {
          _tmpSeqParcela = _cursor.getInt(_cursorIndexOfSeqParcela);
        }
        _item.setSeqParcela(_tmpSeqParcela);
        final Date _tmpDtEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDtEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDtEmissao);
        }
        _tmpDtEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDtEmissao(_tmpDtEmissao);
        final Date _tmpDtParcela;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDtParcela)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDtParcela);
        }
        _tmpDtParcela = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDtParcela(_tmpDtParcela);
        final Double _tmpPercentual;
        if (_cursor.isNull(_cursorIndexOfPercentual)) {
          _tmpPercentual = null;
        } else {
          _tmpPercentual = _cursor.getDouble(_cursorIndexOfPercentual);
        }
        _item.setPercentual(_tmpPercentual);
        final String _tmpIndCondPagto;
        _tmpIndCondPagto = _cursor.getString(_cursorIndexOfIndCondPagto);
        _item.setIndCondPagto(_tmpIndCondPagto);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Tax> findByCondPagtoEmissao(String condPagto, Date dtEmissao) {
    final String _sql = "SELECT * FROM Tax WHERE condPagto = ? and dtEmissao = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (condPagto == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, condPagto);
    }
    _argIndex = 2;
    final Long _tmp;
    _tmp = DateTypeConverter.dateToTimestamp(dtEmissao);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCondPagto = _cursor.getColumnIndexOrThrow("condPagto");
      final int _cursorIndexOfDescPagto = _cursor.getColumnIndexOrThrow("descPagto");
      final int _cursorIndexOfSeqParcela = _cursor.getColumnIndexOrThrow("seqParcela");
      final int _cursorIndexOfDtEmissao = _cursor.getColumnIndexOrThrow("dtEmissao");
      final int _cursorIndexOfDtParcela = _cursor.getColumnIndexOrThrow("dtParcela");
      final int _cursorIndexOfPercentual = _cursor.getColumnIndexOrThrow("percentual");
      final int _cursorIndexOfIndCondPagto = _cursor.getColumnIndexOrThrow("indCondPagto");
      final List<Tax> _result = new ArrayList<Tax>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Tax _item;
        _item = new Tax();
        final Integer _tmpCondPagto;
        if (_cursor.isNull(_cursorIndexOfCondPagto)) {
          _tmpCondPagto = null;
        } else {
          _tmpCondPagto = _cursor.getInt(_cursorIndexOfCondPagto);
        }
        _item.setCondPagto(_tmpCondPagto);
        final String _tmpDescPagto;
        _tmpDescPagto = _cursor.getString(_cursorIndexOfDescPagto);
        _item.setDescPagto(_tmpDescPagto);
        final Integer _tmpSeqParcela;
        if (_cursor.isNull(_cursorIndexOfSeqParcela)) {
          _tmpSeqParcela = null;
        } else {
          _tmpSeqParcela = _cursor.getInt(_cursorIndexOfSeqParcela);
        }
        _item.setSeqParcela(_tmpSeqParcela);
        final Date _tmpDtEmissao;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDtEmissao)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDtEmissao);
        }
        _tmpDtEmissao = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDtEmissao(_tmpDtEmissao);
        final Date _tmpDtParcela;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDtParcela)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDtParcela);
        }
        _tmpDtParcela = DateTypeConverter.fromTimestamp(_tmp_2);
        _item.setDtParcela(_tmpDtParcela);
        final Double _tmpPercentual;
        if (_cursor.isNull(_cursorIndexOfPercentual)) {
          _tmpPercentual = null;
        } else {
          _tmpPercentual = _cursor.getDouble(_cursorIndexOfPercentual);
        }
        _item.setPercentual(_tmpPercentual);
        final String _tmpIndCondPagto;
        _tmpIndCondPagto = _cursor.getString(_cursorIndexOfIndCondPagto);
        _item.setIndCondPagto(_tmpIndCondPagto);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Tax find(String condPagto) {
    final String _sql = "SELECT * FROM Tax WHERE condPagto = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (condPagto == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, condPagto);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCondPagto = _cursor.getColumnIndexOrThrow("condPagto");
      final int _cursorIndexOfDescPagto = _cursor.getColumnIndexOrThrow("descPagto");
      final int _cursorIndexOfSeqParcela = _cursor.getColumnIndexOrThrow("seqParcela");
      final int _cursorIndexOfDtEmissao = _cursor.getColumnIndexOrThrow("dtEmissao");
      final int _cursorIndexOfDtParcela = _cursor.getColumnIndexOrThrow("dtParcela");
      final int _cursorIndexOfPercentual = _cursor.getColumnIndexOrThrow("percentual");
      final int _cursorIndexOfIndCondPagto = _cursor.getColumnIndexOrThrow("indCondPagto");
      final Tax _result;
      if(_cursor.moveToFirst()) {
        _result = new Tax();
        final Integer _tmpCondPagto;
        if (_cursor.isNull(_cursorIndexOfCondPagto)) {
          _tmpCondPagto = null;
        } else {
          _tmpCondPagto = _cursor.getInt(_cursorIndexOfCondPagto);
        }
        _result.setCondPagto(_tmpCondPagto);
        final String _tmpDescPagto;
        _tmpDescPagto = _cursor.getString(_cursorIndexOfDescPagto);
        _result.setDescPagto(_tmpDescPagto);
        final Integer _tmpSeqParcela;
        if (_cursor.isNull(_cursorIndexOfSeqParcela)) {
          _tmpSeqParcela = null;
        } else {
          _tmpSeqParcela = _cursor.getInt(_cursorIndexOfSeqParcela);
        }
        _result.setSeqParcela(_tmpSeqParcela);
        final Date _tmpDtEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDtEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDtEmissao);
        }
        _tmpDtEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDtEmissao(_tmpDtEmissao);
        final Date _tmpDtParcela;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDtParcela)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDtParcela);
        }
        _tmpDtParcela = DateTypeConverter.fromTimestamp(_tmp_1);
        _result.setDtParcela(_tmpDtParcela);
        final Double _tmpPercentual;
        if (_cursor.isNull(_cursorIndexOfPercentual)) {
          _tmpPercentual = null;
        } else {
          _tmpPercentual = _cursor.getDouble(_cursorIndexOfPercentual);
        }
        _result.setPercentual(_tmpPercentual);
        final String _tmpIndCondPagto;
        _tmpIndCondPagto = _cursor.getString(_cursorIndexOfIndCondPagto);
        _result.setIndCondPagto(_tmpIndCondPagto);
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
