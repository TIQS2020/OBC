package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.PreOrder;
import java.lang.Double;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class PreOrderDao_Impl implements PreOrderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPreOrder;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfPreOrder;

  public PreOrderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPreOrder = new EntityInsertionAdapter<PreOrder>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `PreOrder`(`cdPreOrder`,`dataEmissaoNota`,`cdCustomer`,`numeroNotaOrigem`,`cdItem`,`capacidadeProduto`,`saldo`,`preco`,`ajusteICMS`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PreOrder value) {
        if (value.getCdPreOrder() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdPreOrder());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataEmissaoNota());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCdCustomer());
        }
        if (value.getNumeroNotaOrigem() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumeroNotaOrigem());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCdItem());
        }
        if (value.getCapacidadeProduto() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getCapacidadeProduto());
        }
        if (value.getSaldo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getSaldo());
        }
        if (value.getPreco() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getPreco());
        }
        if (value.getAjusteICMS() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getAjusteICMS());
        }
      }
    };
    this.__deletionAdapterOfPreOrder = new EntityDeletionOrUpdateAdapter<PreOrder>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PreOrder` WHERE `cdPreOrder` = ? AND `cdCustomer` = ? AND `cdItem` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PreOrder value) {
        if (value.getCdPreOrder() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdPreOrder());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdCustomer());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCdItem());
        }
      }
    };
  }

  @Override
  public void insert(PreOrder preOrder) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPreOrder.insert(preOrder);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(PreOrder preOrder) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPreOrder.handle(preOrder);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<PreOrder> preOrders) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPreOrder.handleMultiple(preOrders);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PreOrder> getAll() {
    final String _sql = "SELECT * FROM PreOrder";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdPreOrder = _cursor.getColumnIndexOrThrow("cdPreOrder");
      final int _cursorIndexOfDataEmissaoNota = _cursor.getColumnIndexOrThrow("dataEmissaoNota");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfNumeroNotaOrigem = _cursor.getColumnIndexOrThrow("numeroNotaOrigem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("capacidadeProduto");
      final int _cursorIndexOfSaldo = _cursor.getColumnIndexOrThrow("saldo");
      final int _cursorIndexOfPreco = _cursor.getColumnIndexOrThrow("preco");
      final int _cursorIndexOfAjusteICMS = _cursor.getColumnIndexOrThrow("ajusteICMS");
      final List<PreOrder> _result = new ArrayList<PreOrder>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PreOrder _item;
        _item = new PreOrder();
        final Long _tmpCdPreOrder;
        if (_cursor.isNull(_cursorIndexOfCdPreOrder)) {
          _tmpCdPreOrder = null;
        } else {
          _tmpCdPreOrder = _cursor.getLong(_cursorIndexOfCdPreOrder);
        }
        _item.setCdPreOrder(_tmpCdPreOrder);
        final Date _tmpDataEmissaoNota;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissaoNota)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissaoNota);
        }
        _tmpDataEmissaoNota = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissaoNota(_tmpDataEmissaoNota);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpNumeroNotaOrigem;
        _tmpNumeroNotaOrigem = _cursor.getString(_cursorIndexOfNumeroNotaOrigem);
        _item.setNumeroNotaOrigem(_tmpNumeroNotaOrigem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidadeProduto;
        if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
          _tmpCapacidadeProduto = null;
        } else {
          _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
        }
        _item.setCapacidadeProduto(_tmpCapacidadeProduto);
        final Double _tmpSaldo;
        if (_cursor.isNull(_cursorIndexOfSaldo)) {
          _tmpSaldo = null;
        } else {
          _tmpSaldo = _cursor.getDouble(_cursorIndexOfSaldo);
        }
        _item.setSaldo(_tmpSaldo);
        final Double _tmpPreco;
        if (_cursor.isNull(_cursorIndexOfPreco)) {
          _tmpPreco = null;
        } else {
          _tmpPreco = _cursor.getDouble(_cursorIndexOfPreco);
        }
        _item.setPreco(_tmpPreco);
        final Double _tmpAjusteICMS;
        if (_cursor.isNull(_cursorIndexOfAjusteICMS)) {
          _tmpAjusteICMS = null;
        } else {
          _tmpAjusteICMS = _cursor.getDouble(_cursorIndexOfAjusteICMS);
        }
        _item.setAjusteICMS(_tmpAjusteICMS);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PreOrder> find(Long cdCustomer) {
    final String _sql = "SELECT * FROM PreOrder where cdCustomer = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdPreOrder = _cursor.getColumnIndexOrThrow("cdPreOrder");
      final int _cursorIndexOfDataEmissaoNota = _cursor.getColumnIndexOrThrow("dataEmissaoNota");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfNumeroNotaOrigem = _cursor.getColumnIndexOrThrow("numeroNotaOrigem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("capacidadeProduto");
      final int _cursorIndexOfSaldo = _cursor.getColumnIndexOrThrow("saldo");
      final int _cursorIndexOfPreco = _cursor.getColumnIndexOrThrow("preco");
      final int _cursorIndexOfAjusteICMS = _cursor.getColumnIndexOrThrow("ajusteICMS");
      final List<PreOrder> _result = new ArrayList<PreOrder>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PreOrder _item;
        _item = new PreOrder();
        final Long _tmpCdPreOrder;
        if (_cursor.isNull(_cursorIndexOfCdPreOrder)) {
          _tmpCdPreOrder = null;
        } else {
          _tmpCdPreOrder = _cursor.getLong(_cursorIndexOfCdPreOrder);
        }
        _item.setCdPreOrder(_tmpCdPreOrder);
        final Date _tmpDataEmissaoNota;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissaoNota)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissaoNota);
        }
        _tmpDataEmissaoNota = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissaoNota(_tmpDataEmissaoNota);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpNumeroNotaOrigem;
        _tmpNumeroNotaOrigem = _cursor.getString(_cursorIndexOfNumeroNotaOrigem);
        _item.setNumeroNotaOrigem(_tmpNumeroNotaOrigem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidadeProduto;
        if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
          _tmpCapacidadeProduto = null;
        } else {
          _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
        }
        _item.setCapacidadeProduto(_tmpCapacidadeProduto);
        final Double _tmpSaldo;
        if (_cursor.isNull(_cursorIndexOfSaldo)) {
          _tmpSaldo = null;
        } else {
          _tmpSaldo = _cursor.getDouble(_cursorIndexOfSaldo);
        }
        _item.setSaldo(_tmpSaldo);
        final Double _tmpPreco;
        if (_cursor.isNull(_cursorIndexOfPreco)) {
          _tmpPreco = null;
        } else {
          _tmpPreco = _cursor.getDouble(_cursorIndexOfPreco);
        }
        _item.setPreco(_tmpPreco);
        final Double _tmpAjusteICMS;
        if (_cursor.isNull(_cursorIndexOfAjusteICMS)) {
          _tmpAjusteICMS = null;
        } else {
          _tmpAjusteICMS = _cursor.getDouble(_cursorIndexOfAjusteICMS);
        }
        _item.setAjusteICMS(_tmpAjusteICMS);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public PreOrder find(String numeroNotaOrigem) {
    final String _sql = "SELECT * FROM PreOrder where numeroNotaOrigem = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numeroNotaOrigem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroNotaOrigem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdPreOrder = _cursor.getColumnIndexOrThrow("cdPreOrder");
      final int _cursorIndexOfDataEmissaoNota = _cursor.getColumnIndexOrThrow("dataEmissaoNota");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfNumeroNotaOrigem = _cursor.getColumnIndexOrThrow("numeroNotaOrigem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("capacidadeProduto");
      final int _cursorIndexOfSaldo = _cursor.getColumnIndexOrThrow("saldo");
      final int _cursorIndexOfPreco = _cursor.getColumnIndexOrThrow("preco");
      final int _cursorIndexOfAjusteICMS = _cursor.getColumnIndexOrThrow("ajusteICMS");
      final PreOrder _result;
      if(_cursor.moveToFirst()) {
        _result = new PreOrder();
        final Long _tmpCdPreOrder;
        if (_cursor.isNull(_cursorIndexOfCdPreOrder)) {
          _tmpCdPreOrder = null;
        } else {
          _tmpCdPreOrder = _cursor.getLong(_cursorIndexOfCdPreOrder);
        }
        _result.setCdPreOrder(_tmpCdPreOrder);
        final Date _tmpDataEmissaoNota;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissaoNota)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissaoNota);
        }
        _tmpDataEmissaoNota = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataEmissaoNota(_tmpDataEmissaoNota);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final String _tmpNumeroNotaOrigem;
        _tmpNumeroNotaOrigem = _cursor.getString(_cursorIndexOfNumeroNotaOrigem);
        _result.setNumeroNotaOrigem(_tmpNumeroNotaOrigem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _result.setCdItem(_tmpCdItem);
        final Double _tmpCapacidadeProduto;
        if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
          _tmpCapacidadeProduto = null;
        } else {
          _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
        }
        _result.setCapacidadeProduto(_tmpCapacidadeProduto);
        final Double _tmpSaldo;
        if (_cursor.isNull(_cursorIndexOfSaldo)) {
          _tmpSaldo = null;
        } else {
          _tmpSaldo = _cursor.getDouble(_cursorIndexOfSaldo);
        }
        _result.setSaldo(_tmpSaldo);
        final Double _tmpPreco;
        if (_cursor.isNull(_cursorIndexOfPreco)) {
          _tmpPreco = null;
        } else {
          _tmpPreco = _cursor.getDouble(_cursorIndexOfPreco);
        }
        _result.setPreco(_tmpPreco);
        final Double _tmpAjusteICMS;
        if (_cursor.isNull(_cursorIndexOfAjusteICMS)) {
          _tmpAjusteICMS = null;
        } else {
          _tmpAjusteICMS = _cursor.getDouble(_cursorIndexOfAjusteICMS);
        }
        _result.setAjusteICMS(_tmpAjusteICMS);
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
  public PreOrder find(Long cdItem, String numeroNotaOrigem) {
    final String _sql = "SELECT * FROM PreOrder WHERE numeroNotaOrigem = ?   AND cdItem = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (numeroNotaOrigem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroNotaOrigem);
    }
    _argIndex = 2;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdPreOrder = _cursor.getColumnIndexOrThrow("cdPreOrder");
      final int _cursorIndexOfDataEmissaoNota = _cursor.getColumnIndexOrThrow("dataEmissaoNota");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfNumeroNotaOrigem = _cursor.getColumnIndexOrThrow("numeroNotaOrigem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("capacidadeProduto");
      final int _cursorIndexOfSaldo = _cursor.getColumnIndexOrThrow("saldo");
      final int _cursorIndexOfPreco = _cursor.getColumnIndexOrThrow("preco");
      final int _cursorIndexOfAjusteICMS = _cursor.getColumnIndexOrThrow("ajusteICMS");
      final PreOrder _result;
      if(_cursor.moveToFirst()) {
        _result = new PreOrder();
        final Long _tmpCdPreOrder;
        if (_cursor.isNull(_cursorIndexOfCdPreOrder)) {
          _tmpCdPreOrder = null;
        } else {
          _tmpCdPreOrder = _cursor.getLong(_cursorIndexOfCdPreOrder);
        }
        _result.setCdPreOrder(_tmpCdPreOrder);
        final Date _tmpDataEmissaoNota;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissaoNota)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissaoNota);
        }
        _tmpDataEmissaoNota = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataEmissaoNota(_tmpDataEmissaoNota);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final String _tmpNumeroNotaOrigem;
        _tmpNumeroNotaOrigem = _cursor.getString(_cursorIndexOfNumeroNotaOrigem);
        _result.setNumeroNotaOrigem(_tmpNumeroNotaOrigem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _result.setCdItem(_tmpCdItem);
        final Double _tmpCapacidadeProduto;
        if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
          _tmpCapacidadeProduto = null;
        } else {
          _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
        }
        _result.setCapacidadeProduto(_tmpCapacidadeProduto);
        final Double _tmpSaldo;
        if (_cursor.isNull(_cursorIndexOfSaldo)) {
          _tmpSaldo = null;
        } else {
          _tmpSaldo = _cursor.getDouble(_cursorIndexOfSaldo);
        }
        _result.setSaldo(_tmpSaldo);
        final Double _tmpPreco;
        if (_cursor.isNull(_cursorIndexOfPreco)) {
          _tmpPreco = null;
        } else {
          _tmpPreco = _cursor.getDouble(_cursorIndexOfPreco);
        }
        _result.setPreco(_tmpPreco);
        final Double _tmpAjusteICMS;
        if (_cursor.isNull(_cursorIndexOfAjusteICMS)) {
          _tmpAjusteICMS = null;
        } else {
          _tmpAjusteICMS = _cursor.getDouble(_cursorIndexOfAjusteICMS);
        }
        _result.setAjusteICMS(_tmpAjusteICMS);
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
