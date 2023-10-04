package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.InvoiceMessage;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class InvoiceMessageDao_Impl implements InvoiceMessageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfInvoiceMessage;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfInvoiceMessage;

  public InvoiceMessageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInvoiceMessage = new EntityInsertionAdapter<InvoiceMessage>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `InvoiceMessage`(`idNota`,`tipoTransacao`,`numeroNota`,`serieNota`,`cdCustomer`,`cdRota`,`numeroFutEntrega`,`dataEmissao`,`sequencia`,`linha`,`mensagem`,`mostrarMsg`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InvoiceMessage value) {
        if (value.getIdNota() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getIdNota());
        }
        if (value.getTipoTransacao() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getTipoTransacao());
        }
        if (value.getNumeroNota() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getNumeroNota());
        }
        if (value.getSerieNota() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getSerieNota());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCdCustomer());
        }
        if (value.getCdRota() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCdRota());
        }
        if (value.getNumeroFutEntrega() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNumeroFutEntrega());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataEmissao());
        if (_tmp == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp);
        }
        if (value.getSequencia() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getSequencia());
        }
        if (value.getLinha() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getLinha());
        }
        if (value.getMensagem() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMensagem());
        }
        if (value.getMostrarMsg() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMostrarMsg());
        }
      }
    };
    this.__deletionAdapterOfInvoiceMessage = new EntityDeletionOrUpdateAdapter<InvoiceMessage>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `InvoiceMessage` WHERE `idNota` = ? AND `cdCustomer` = ? AND `sequencia` = ? AND `linha` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InvoiceMessage value) {
        if (value.getIdNota() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getIdNota());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdCustomer());
        }
        if (value.getSequencia() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getSequencia());
        }
        if (value.getLinha() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getLinha());
        }
      }
    };
  }

  @Override
  public Long[] insertAll(List<InvoiceMessage> invoiceMessages) {
    __db.beginTransaction();
    try {
      Long[] _result = __insertionAdapterOfInvoiceMessage.insertAndReturnIdsArrayBox(invoiceMessages);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Long insert(InvoiceMessage invoiceMessage) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfInvoiceMessage.insertAndReturnId(invoiceMessage);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(InvoiceMessage invoiceMessage) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfInvoiceMessage.handle(invoiceMessage);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<InvoiceMessage> invoiceMessages) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfInvoiceMessage.handleMultiple(invoiceMessages);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<InvoiceMessage> getAll() {
    final String _sql = "SELECT * FROM InvoiceMessage";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfSerieNota = _cursor.getColumnIndexOrThrow("serieNota");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdRota = _cursor.getColumnIndexOrThrow("cdRota");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfSequencia = _cursor.getColumnIndexOrThrow("sequencia");
      final int _cursorIndexOfLinha = _cursor.getColumnIndexOrThrow("linha");
      final int _cursorIndexOfMensagem = _cursor.getColumnIndexOrThrow("mensagem");
      final int _cursorIndexOfMostrarMsg = _cursor.getColumnIndexOrThrow("mostrarMsg");
      final List<InvoiceMessage> _result = new ArrayList<InvoiceMessage>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InvoiceMessage _item;
        _item = new InvoiceMessage();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item.setTipoTransacao(_tmpTipoTransacao);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item.setNumeroNota(_tmpNumeroNota);
        final Long _tmpSerieNota;
        if (_cursor.isNull(_cursorIndexOfSerieNota)) {
          _tmpSerieNota = null;
        } else {
          _tmpSerieNota = _cursor.getLong(_cursorIndexOfSerieNota);
        }
        _item.setSerieNota(_tmpSerieNota);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Integer _tmpCdRota;
        if (_cursor.isNull(_cursorIndexOfCdRota)) {
          _tmpCdRota = null;
        } else {
          _tmpCdRota = _cursor.getInt(_cursorIndexOfCdRota);
        }
        _item.setCdRota(_tmpCdRota);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissao(_tmpDataEmissao);
        final Integer _tmpSequencia;
        if (_cursor.isNull(_cursorIndexOfSequencia)) {
          _tmpSequencia = null;
        } else {
          _tmpSequencia = _cursor.getInt(_cursorIndexOfSequencia);
        }
        _item.setSequencia(_tmpSequencia);
        final Integer _tmpLinha;
        if (_cursor.isNull(_cursorIndexOfLinha)) {
          _tmpLinha = null;
        } else {
          _tmpLinha = _cursor.getInt(_cursorIndexOfLinha);
        }
        _item.setLinha(_tmpLinha);
        final String _tmpMensagem;
        _tmpMensagem = _cursor.getString(_cursorIndexOfMensagem);
        _item.setMensagem(_tmpMensagem);
        final String _tmpMostrarMsg;
        _tmpMostrarMsg = _cursor.getString(_cursorIndexOfMostrarMsg);
        _item.setMostrarMsg(_tmpMostrarMsg);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<InvoiceMessage> findById(Long id) {
    final String _sql = "SELECT * FROM InvoiceMessage WHERE idNota = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfSerieNota = _cursor.getColumnIndexOrThrow("serieNota");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdRota = _cursor.getColumnIndexOrThrow("cdRota");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfSequencia = _cursor.getColumnIndexOrThrow("sequencia");
      final int _cursorIndexOfLinha = _cursor.getColumnIndexOrThrow("linha");
      final int _cursorIndexOfMensagem = _cursor.getColumnIndexOrThrow("mensagem");
      final int _cursorIndexOfMostrarMsg = _cursor.getColumnIndexOrThrow("mostrarMsg");
      final List<InvoiceMessage> _result = new ArrayList<InvoiceMessage>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InvoiceMessage _item;
        _item = new InvoiceMessage();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item.setTipoTransacao(_tmpTipoTransacao);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item.setNumeroNota(_tmpNumeroNota);
        final Long _tmpSerieNota;
        if (_cursor.isNull(_cursorIndexOfSerieNota)) {
          _tmpSerieNota = null;
        } else {
          _tmpSerieNota = _cursor.getLong(_cursorIndexOfSerieNota);
        }
        _item.setSerieNota(_tmpSerieNota);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Integer _tmpCdRota;
        if (_cursor.isNull(_cursorIndexOfCdRota)) {
          _tmpCdRota = null;
        } else {
          _tmpCdRota = _cursor.getInt(_cursorIndexOfCdRota);
        }
        _item.setCdRota(_tmpCdRota);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissao(_tmpDataEmissao);
        final Integer _tmpSequencia;
        if (_cursor.isNull(_cursorIndexOfSequencia)) {
          _tmpSequencia = null;
        } else {
          _tmpSequencia = _cursor.getInt(_cursorIndexOfSequencia);
        }
        _item.setSequencia(_tmpSequencia);
        final Integer _tmpLinha;
        if (_cursor.isNull(_cursorIndexOfLinha)) {
          _tmpLinha = null;
        } else {
          _tmpLinha = _cursor.getInt(_cursorIndexOfLinha);
        }
        _item.setLinha(_tmpLinha);
        final String _tmpMensagem;
        _tmpMensagem = _cursor.getString(_cursorIndexOfMensagem);
        _item.setMensagem(_tmpMensagem);
        final String _tmpMostrarMsg;
        _tmpMostrarMsg = _cursor.getString(_cursorIndexOfMostrarMsg);
        _item.setMostrarMsg(_tmpMostrarMsg);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<InvoiceMessage> find(Long id, String mostrarMsg) {
    final String _sql = "SELECT * FROM InvoiceMessage WHERE idNota = ? AND mostrarMsg = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    _argIndex = 2;
    if (mostrarMsg == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, mostrarMsg);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfSerieNota = _cursor.getColumnIndexOrThrow("serieNota");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdRota = _cursor.getColumnIndexOrThrow("cdRota");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfSequencia = _cursor.getColumnIndexOrThrow("sequencia");
      final int _cursorIndexOfLinha = _cursor.getColumnIndexOrThrow("linha");
      final int _cursorIndexOfMensagem = _cursor.getColumnIndexOrThrow("mensagem");
      final int _cursorIndexOfMostrarMsg = _cursor.getColumnIndexOrThrow("mostrarMsg");
      final List<InvoiceMessage> _result = new ArrayList<InvoiceMessage>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InvoiceMessage _item;
        _item = new InvoiceMessage();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item.setTipoTransacao(_tmpTipoTransacao);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item.setNumeroNota(_tmpNumeroNota);
        final Long _tmpSerieNota;
        if (_cursor.isNull(_cursorIndexOfSerieNota)) {
          _tmpSerieNota = null;
        } else {
          _tmpSerieNota = _cursor.getLong(_cursorIndexOfSerieNota);
        }
        _item.setSerieNota(_tmpSerieNota);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Integer _tmpCdRota;
        if (_cursor.isNull(_cursorIndexOfCdRota)) {
          _tmpCdRota = null;
        } else {
          _tmpCdRota = _cursor.getInt(_cursorIndexOfCdRota);
        }
        _item.setCdRota(_tmpCdRota);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissao(_tmpDataEmissao);
        final Integer _tmpSequencia;
        if (_cursor.isNull(_cursorIndexOfSequencia)) {
          _tmpSequencia = null;
        } else {
          _tmpSequencia = _cursor.getInt(_cursorIndexOfSequencia);
        }
        _item.setSequencia(_tmpSequencia);
        final Integer _tmpLinha;
        if (_cursor.isNull(_cursorIndexOfLinha)) {
          _tmpLinha = null;
        } else {
          _tmpLinha = _cursor.getInt(_cursorIndexOfLinha);
        }
        _item.setLinha(_tmpLinha);
        final String _tmpMensagem;
        _tmpMensagem = _cursor.getString(_cursorIndexOfMensagem);
        _item.setMensagem(_tmpMensagem);
        final String _tmpMostrarMsg;
        _tmpMostrarMsg = _cursor.getString(_cursorIndexOfMostrarMsg);
        _item.setMostrarMsg(_tmpMostrarMsg);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
