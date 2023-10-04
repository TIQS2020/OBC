package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.util.StringUtil;
import android.database.Cursor;
import br.com.whitemartins.obc.model.InvoiceImage;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class InvoiceImageDao_Impl implements InvoiceImageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfInvoiceImage;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfInvoiceImage;

  public InvoiceImageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInvoiceImage = new EntityInsertionAdapter<InvoiceImage>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `InvoiceImage`(`idNota`,`status`,`cec`,`assinatura`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InvoiceImage value) {
        if (value.getIdNota() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getIdNota());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getStatus());
        }
        if (value.getCec() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCec());
        }
        if (value.getAssinatura() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAssinatura());
        }
      }
    };
    this.__deletionAdapterOfInvoiceImage = new EntityDeletionOrUpdateAdapter<InvoiceImage>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `InvoiceImage` WHERE `idNota` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InvoiceImage value) {
        if (value.getIdNota() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getIdNota());
        }
      }
    };
  }

  @Override
  public void insert(InvoiceImage invoiceImage) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfInvoiceImage.insert(invoiceImage);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(InvoiceImage invoiceImage) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfInvoiceImage.handle(invoiceImage);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<InvoiceImage> invoiceImages) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfInvoiceImage.handleMultiple(invoiceImages);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<InvoiceImage> getAll() {
    final String _sql = "SELECT * FROM InvoiceImage";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfCec = _cursor.getColumnIndexOrThrow("cec");
      final int _cursorIndexOfAssinatura = _cursor.getColumnIndexOrThrow("assinatura");
      final List<InvoiceImage> _result = new ArrayList<InvoiceImage>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InvoiceImage _item;
        _item = new InvoiceImage();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpCec;
        _tmpCec = _cursor.getString(_cursorIndexOfCec);
        _item.setCec(_tmpCec);
        final String _tmpAssinatura;
        _tmpAssinatura = _cursor.getString(_cursorIndexOfAssinatura);
        _item.setAssinatura(_tmpAssinatura);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public InvoiceImage find(Long idNota) {
    final String _sql = "SELECT * FROM InvoiceImage WHERE idNota = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfCec = _cursor.getColumnIndexOrThrow("cec");
      final int _cursorIndexOfAssinatura = _cursor.getColumnIndexOrThrow("assinatura");
      final InvoiceImage _result;
      if(_cursor.moveToFirst()) {
        _result = new InvoiceImage();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _result.setIdNota(_tmpIdNota);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpCec;
        _tmpCec = _cursor.getString(_cursorIndexOfCec);
        _result.setCec(_tmpCec);
        final String _tmpAssinatura;
        _tmpAssinatura = _cursor.getString(_cursorIndexOfAssinatura);
        _result.setAssinatura(_tmpAssinatura);
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
  public List<InvoiceImage> find(List<Integer> status) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM InvoiceImage WHERE status IN (");
    final int _inputSize = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : status) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfCec = _cursor.getColumnIndexOrThrow("cec");
      final int _cursorIndexOfAssinatura = _cursor.getColumnIndexOrThrow("assinatura");
      final List<InvoiceImage> _result = new ArrayList<InvoiceImage>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InvoiceImage _item_1;
        _item_1 = new InvoiceImage();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item_1.setIdNota(_tmpIdNota);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item_1.setStatus(_tmpStatus);
        final String _tmpCec;
        _tmpCec = _cursor.getString(_cursorIndexOfCec);
        _item_1.setCec(_tmpCec);
        final String _tmpAssinatura;
        _tmpAssinatura = _cursor.getString(_cursorIndexOfAssinatura);
        _item_1.setAssinatura(_tmpAssinatura);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
