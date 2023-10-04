package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.InvoiceNumber;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class InvoiceNumberDao_Impl implements InvoiceNumberDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfInvoiceNumber;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfInvoiceNumber;

  public InvoiceNumberDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInvoiceNumber = new EntityInsertionAdapter<InvoiceNumber>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `InvoiceNumber`(`numeroSerieEntrada`,`tipoNotaEntrada`,`numeroNotaFiscalEntrada`,`numeroMaximoNFEntrada`,`numeroSerieSaida`,`tipoNotaSaida`,`nuemroNotaFiscalSaida`,`numeroMaximoNFSaida`,`numeroLinhasEntrada`,`numeroLinhasSaida`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InvoiceNumber value) {
        if (value.getNumeroSerieEntrada() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroSerieEntrada());
        }
        if (value.getTipoNotaEntrada() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTipoNotaEntrada());
        }
        if (value.getNumeroNotaFiscalEntrada() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getNumeroNotaFiscalEntrada());
        }
        if (value.getNumeroMaximoNFEntrada() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getNumeroMaximoNFEntrada());
        }
        if (value.getNumeroSerieSaida() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getNumeroSerieSaida());
        }
        if (value.getTipoNotaSaida() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTipoNotaSaida());
        }
        if (value.getNuemroNotaFiscalSaida() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getNuemroNotaFiscalSaida());
        }
        if (value.getNumeroMaximoNFSaida() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getNumeroMaximoNFSaida());
        }
        if (value.getNumeroLinhasEntrada() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getNumeroLinhasEntrada());
        }
        if (value.getNumeroLinhasSaida() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getNumeroLinhasSaida());
        }
      }
    };
    this.__deletionAdapterOfInvoiceNumber = new EntityDeletionOrUpdateAdapter<InvoiceNumber>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `InvoiceNumber` WHERE `numeroNotaFiscalEntrada` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InvoiceNumber value) {
        if (value.getNumeroNotaFiscalEntrada() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroNotaFiscalEntrada());
        }
      }
    };
  }

  @Override
  public void insertAll(List<InvoiceNumber> invoiceNumbers) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfInvoiceNumber.insert(invoiceNumbers);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(InvoiceNumber invoiceNumbers) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfInvoiceNumber.insert(invoiceNumbers);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(InvoiceNumber invoiceNumber) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfInvoiceNumber.handle(invoiceNumber);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<InvoiceNumber> invoiceNumbers) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfInvoiceNumber.handleMultiple(invoiceNumbers);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<InvoiceNumber> getAll() {
    final String _sql = "SELECT * FROM InvoiceNumber";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroSerieEntrada = _cursor.getColumnIndexOrThrow("numeroSerieEntrada");
      final int _cursorIndexOfTipoNotaEntrada = _cursor.getColumnIndexOrThrow("tipoNotaEntrada");
      final int _cursorIndexOfNumeroNotaFiscalEntrada = _cursor.getColumnIndexOrThrow("numeroNotaFiscalEntrada");
      final int _cursorIndexOfNumeroMaximoNFEntrada = _cursor.getColumnIndexOrThrow("numeroMaximoNFEntrada");
      final int _cursorIndexOfNumeroSerieSaida = _cursor.getColumnIndexOrThrow("numeroSerieSaida");
      final int _cursorIndexOfTipoNotaSaida = _cursor.getColumnIndexOrThrow("tipoNotaSaida");
      final int _cursorIndexOfNuemroNotaFiscalSaida = _cursor.getColumnIndexOrThrow("nuemroNotaFiscalSaida");
      final int _cursorIndexOfNumeroMaximoNFSaida = _cursor.getColumnIndexOrThrow("numeroMaximoNFSaida");
      final int _cursorIndexOfNumeroLinhasEntrada = _cursor.getColumnIndexOrThrow("numeroLinhasEntrada");
      final int _cursorIndexOfNumeroLinhasSaida = _cursor.getColumnIndexOrThrow("numeroLinhasSaida");
      final List<InvoiceNumber> _result = new ArrayList<InvoiceNumber>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InvoiceNumber _item;
        _item = new InvoiceNumber();
        final Long _tmpNumeroSerieEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroSerieEntrada)) {
          _tmpNumeroSerieEntrada = null;
        } else {
          _tmpNumeroSerieEntrada = _cursor.getLong(_cursorIndexOfNumeroSerieEntrada);
        }
        _item.setNumeroSerieEntrada(_tmpNumeroSerieEntrada);
        final String _tmpTipoNotaEntrada;
        _tmpTipoNotaEntrada = _cursor.getString(_cursorIndexOfTipoNotaEntrada);
        _item.setTipoNotaEntrada(_tmpTipoNotaEntrada);
        final Long _tmpNumeroNotaFiscalEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaFiscalEntrada)) {
          _tmpNumeroNotaFiscalEntrada = null;
        } else {
          _tmpNumeroNotaFiscalEntrada = _cursor.getLong(_cursorIndexOfNumeroNotaFiscalEntrada);
        }
        _item.setNumeroNotaFiscalEntrada(_tmpNumeroNotaFiscalEntrada);
        final Long _tmpNumeroMaximoNFEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroMaximoNFEntrada)) {
          _tmpNumeroMaximoNFEntrada = null;
        } else {
          _tmpNumeroMaximoNFEntrada = _cursor.getLong(_cursorIndexOfNumeroMaximoNFEntrada);
        }
        _item.setNumeroMaximoNFEntrada(_tmpNumeroMaximoNFEntrada);
        final Long _tmpNumeroSerieSaida;
        if (_cursor.isNull(_cursorIndexOfNumeroSerieSaida)) {
          _tmpNumeroSerieSaida = null;
        } else {
          _tmpNumeroSerieSaida = _cursor.getLong(_cursorIndexOfNumeroSerieSaida);
        }
        _item.setNumeroSerieSaida(_tmpNumeroSerieSaida);
        final String _tmpTipoNotaSaida;
        _tmpTipoNotaSaida = _cursor.getString(_cursorIndexOfTipoNotaSaida);
        _item.setTipoNotaSaida(_tmpTipoNotaSaida);
        final Long _tmpNuemroNotaFiscalSaida;
        if (_cursor.isNull(_cursorIndexOfNuemroNotaFiscalSaida)) {
          _tmpNuemroNotaFiscalSaida = null;
        } else {
          _tmpNuemroNotaFiscalSaida = _cursor.getLong(_cursorIndexOfNuemroNotaFiscalSaida);
        }
        _item.setNuemroNotaFiscalSaida(_tmpNuemroNotaFiscalSaida);
        final Long _tmpNumeroMaximoNFSaida;
        if (_cursor.isNull(_cursorIndexOfNumeroMaximoNFSaida)) {
          _tmpNumeroMaximoNFSaida = null;
        } else {
          _tmpNumeroMaximoNFSaida = _cursor.getLong(_cursorIndexOfNumeroMaximoNFSaida);
        }
        _item.setNumeroMaximoNFSaida(_tmpNumeroMaximoNFSaida);
        final Long _tmpNumeroLinhasEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroLinhasEntrada)) {
          _tmpNumeroLinhasEntrada = null;
        } else {
          _tmpNumeroLinhasEntrada = _cursor.getLong(_cursorIndexOfNumeroLinhasEntrada);
        }
        _item.setNumeroLinhasEntrada(_tmpNumeroLinhasEntrada);
        final Long _tmpNumeroLinhasSaida;
        if (_cursor.isNull(_cursorIndexOfNumeroLinhasSaida)) {
          _tmpNumeroLinhasSaida = null;
        } else {
          _tmpNumeroLinhasSaida = _cursor.getLong(_cursorIndexOfNumeroLinhasSaida);
        }
        _item.setNumeroLinhasSaida(_tmpNumeroLinhasSaida);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public InvoiceNumber getFirst() {
    final String _sql = "SELECT * FROM InvoiceNumber LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroSerieEntrada = _cursor.getColumnIndexOrThrow("numeroSerieEntrada");
      final int _cursorIndexOfTipoNotaEntrada = _cursor.getColumnIndexOrThrow("tipoNotaEntrada");
      final int _cursorIndexOfNumeroNotaFiscalEntrada = _cursor.getColumnIndexOrThrow("numeroNotaFiscalEntrada");
      final int _cursorIndexOfNumeroMaximoNFEntrada = _cursor.getColumnIndexOrThrow("numeroMaximoNFEntrada");
      final int _cursorIndexOfNumeroSerieSaida = _cursor.getColumnIndexOrThrow("numeroSerieSaida");
      final int _cursorIndexOfTipoNotaSaida = _cursor.getColumnIndexOrThrow("tipoNotaSaida");
      final int _cursorIndexOfNuemroNotaFiscalSaida = _cursor.getColumnIndexOrThrow("nuemroNotaFiscalSaida");
      final int _cursorIndexOfNumeroMaximoNFSaida = _cursor.getColumnIndexOrThrow("numeroMaximoNFSaida");
      final int _cursorIndexOfNumeroLinhasEntrada = _cursor.getColumnIndexOrThrow("numeroLinhasEntrada");
      final int _cursorIndexOfNumeroLinhasSaida = _cursor.getColumnIndexOrThrow("numeroLinhasSaida");
      final InvoiceNumber _result;
      if(_cursor.moveToFirst()) {
        _result = new InvoiceNumber();
        final Long _tmpNumeroSerieEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroSerieEntrada)) {
          _tmpNumeroSerieEntrada = null;
        } else {
          _tmpNumeroSerieEntrada = _cursor.getLong(_cursorIndexOfNumeroSerieEntrada);
        }
        _result.setNumeroSerieEntrada(_tmpNumeroSerieEntrada);
        final String _tmpTipoNotaEntrada;
        _tmpTipoNotaEntrada = _cursor.getString(_cursorIndexOfTipoNotaEntrada);
        _result.setTipoNotaEntrada(_tmpTipoNotaEntrada);
        final Long _tmpNumeroNotaFiscalEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaFiscalEntrada)) {
          _tmpNumeroNotaFiscalEntrada = null;
        } else {
          _tmpNumeroNotaFiscalEntrada = _cursor.getLong(_cursorIndexOfNumeroNotaFiscalEntrada);
        }
        _result.setNumeroNotaFiscalEntrada(_tmpNumeroNotaFiscalEntrada);
        final Long _tmpNumeroMaximoNFEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroMaximoNFEntrada)) {
          _tmpNumeroMaximoNFEntrada = null;
        } else {
          _tmpNumeroMaximoNFEntrada = _cursor.getLong(_cursorIndexOfNumeroMaximoNFEntrada);
        }
        _result.setNumeroMaximoNFEntrada(_tmpNumeroMaximoNFEntrada);
        final Long _tmpNumeroSerieSaida;
        if (_cursor.isNull(_cursorIndexOfNumeroSerieSaida)) {
          _tmpNumeroSerieSaida = null;
        } else {
          _tmpNumeroSerieSaida = _cursor.getLong(_cursorIndexOfNumeroSerieSaida);
        }
        _result.setNumeroSerieSaida(_tmpNumeroSerieSaida);
        final String _tmpTipoNotaSaida;
        _tmpTipoNotaSaida = _cursor.getString(_cursorIndexOfTipoNotaSaida);
        _result.setTipoNotaSaida(_tmpTipoNotaSaida);
        final Long _tmpNuemroNotaFiscalSaida;
        if (_cursor.isNull(_cursorIndexOfNuemroNotaFiscalSaida)) {
          _tmpNuemroNotaFiscalSaida = null;
        } else {
          _tmpNuemroNotaFiscalSaida = _cursor.getLong(_cursorIndexOfNuemroNotaFiscalSaida);
        }
        _result.setNuemroNotaFiscalSaida(_tmpNuemroNotaFiscalSaida);
        final Long _tmpNumeroMaximoNFSaida;
        if (_cursor.isNull(_cursorIndexOfNumeroMaximoNFSaida)) {
          _tmpNumeroMaximoNFSaida = null;
        } else {
          _tmpNumeroMaximoNFSaida = _cursor.getLong(_cursorIndexOfNumeroMaximoNFSaida);
        }
        _result.setNumeroMaximoNFSaida(_tmpNumeroMaximoNFSaida);
        final Long _tmpNumeroLinhasEntrada;
        if (_cursor.isNull(_cursorIndexOfNumeroLinhasEntrada)) {
          _tmpNumeroLinhasEntrada = null;
        } else {
          _tmpNumeroLinhasEntrada = _cursor.getLong(_cursorIndexOfNumeroLinhasEntrada);
        }
        _result.setNumeroLinhasEntrada(_tmpNumeroLinhasEntrada);
        final Long _tmpNumeroLinhasSaida;
        if (_cursor.isNull(_cursorIndexOfNumeroLinhasSaida)) {
          _tmpNumeroLinhasSaida = null;
        } else {
          _tmpNumeroLinhasSaida = _cursor.getLong(_cursorIndexOfNumeroLinhasSaida);
        }
        _result.setNumeroLinhasSaida(_tmpNumeroLinhasSaida);
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
