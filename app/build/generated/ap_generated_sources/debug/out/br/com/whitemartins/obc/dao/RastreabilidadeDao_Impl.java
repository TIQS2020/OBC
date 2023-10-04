package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.Rastreabilidade;
import java.lang.Double;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class RastreabilidadeDao_Impl implements RastreabilidadeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfRastreabilidade;

  private final EntityInsertionAdapter __insertionAdapterOfRastreabilidade_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfRastreabilidade;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfRastreabilidade;

  public RastreabilidadeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRastreabilidade = new EntityInsertionAdapter<Rastreabilidade>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Rastreabilidade`(`id`,`cdFilial`,`cdCilindro`,`numeroLote`,`idNota`,`numeroNota`,`cdItem`,`numeroVeiculo`,`numeroViagem`,`dataViagem`,`capacidadeItem`,`cdCustomer`,`liberado`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Rastreabilidade value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCdFilial() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCdFilial());
        }
        if (value.getCdCilindro() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCdCilindro());
        }
        if (value.getNumeroLote() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumeroLote());
        }
        if (value.getIdNota() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getIdNota());
        }
        if (value.getNumeroNota() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getNumeroNota());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getCdItem());
        }
        if (value.getNumeroVeiculo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNumeroVeiculo());
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getNumeroViagem());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataViagem());
        if (_tmp == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, _tmp);
        }
        if (value.getCapacidadeItem() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getCapacidadeItem());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getCdCustomer());
        }
        if (value.getLiberado() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLiberado());
        }
      }
    };
    this.__insertionAdapterOfRastreabilidade_1 = new EntityInsertionAdapter<Rastreabilidade>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Rastreabilidade`(`id`,`cdFilial`,`cdCilindro`,`numeroLote`,`idNota`,`numeroNota`,`cdItem`,`numeroVeiculo`,`numeroViagem`,`dataViagem`,`capacidadeItem`,`cdCustomer`,`liberado`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Rastreabilidade value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCdFilial() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCdFilial());
        }
        if (value.getCdCilindro() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCdCilindro());
        }
        if (value.getNumeroLote() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumeroLote());
        }
        if (value.getIdNota() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getIdNota());
        }
        if (value.getNumeroNota() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getNumeroNota());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getCdItem());
        }
        if (value.getNumeroVeiculo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNumeroVeiculo());
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getNumeroViagem());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataViagem());
        if (_tmp == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, _tmp);
        }
        if (value.getCapacidadeItem() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getCapacidadeItem());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getCdCustomer());
        }
        if (value.getLiberado() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLiberado());
        }
      }
    };
    this.__deletionAdapterOfRastreabilidade = new EntityDeletionOrUpdateAdapter<Rastreabilidade>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Rastreabilidade` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Rastreabilidade value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfRastreabilidade = new EntityDeletionOrUpdateAdapter<Rastreabilidade>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Rastreabilidade` SET `id` = ?,`cdFilial` = ?,`cdCilindro` = ?,`numeroLote` = ?,`idNota` = ?,`numeroNota` = ?,`cdItem` = ?,`numeroVeiculo` = ?,`numeroViagem` = ?,`dataViagem` = ?,`capacidadeItem` = ?,`cdCustomer` = ?,`liberado` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Rastreabilidade value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCdFilial() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCdFilial());
        }
        if (value.getCdCilindro() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCdCilindro());
        }
        if (value.getNumeroLote() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumeroLote());
        }
        if (value.getIdNota() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getIdNota());
        }
        if (value.getNumeroNota() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getNumeroNota());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getCdItem());
        }
        if (value.getNumeroVeiculo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNumeroVeiculo());
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getNumeroViagem());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataViagem());
        if (_tmp == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, _tmp);
        }
        if (value.getCapacidadeItem() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getCapacidadeItem());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getCdCustomer());
        }
        if (value.getLiberado() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLiberado());
        }
        if (value.getId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getId());
        }
      }
    };
  }

  @Override
  public void insert(Rastreabilidade rastreabilidade) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfRastreabilidade.insert(rastreabilidade);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(List<Rastreabilidade> rastreabilidades) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfRastreabilidade_1.insert(rastreabilidades);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Rastreabilidade rastreabilidade) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfRastreabilidade.handle(rastreabilidade);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Rastreabilidade> rastreabilidades) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfRastreabilidade.handleMultiple(rastreabilidades);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Rastreabilidade rastreabilidade) {
    __db.beginTransaction();
    try {
      __updateAdapterOfRastreabilidade.handle(rastreabilidade);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Rastreabilidade> getAll() {
    final String _sql = "SELECT * FROM Rastreabilidade ORDER BY numeroLote, cdCilindro";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("cdCilindro");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCapacidadeItem = _cursor.getColumnIndexOrThrow("capacidadeItem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final List<Rastreabilidade> _result = new ArrayList<Rastreabilidade>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Rastreabilidade _item;
        _item = new Rastreabilidade();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _item.setCdFilial(_tmpCdFilial);
        final String _tmpCdCilindro;
        _tmpCdCilindro = _cursor.getString(_cursorIndexOfCdCilindro);
        _item.setCdCilindro(_tmpCdCilindro);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _item.setNumeroLote(_tmpNumeroLote);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item.setNumeroNota(_tmpNumeroNota);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item.setNumeroVeiculo(_tmpNumeroVeiculo);
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
        final Double _tmpCapacidadeItem;
        if (_cursor.isNull(_cursorIndexOfCapacidadeItem)) {
          _tmpCapacidadeItem = null;
        } else {
          _tmpCapacidadeItem = _cursor.getDouble(_cursorIndexOfCapacidadeItem);
        }
        _item.setCapacidadeItem(_tmpCapacidadeItem);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpLiberado;
        _tmpLiberado = _cursor.getString(_cursorIndexOfLiberado);
        _item.setLiberado(_tmpLiberado);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Rastreabilidade find(String cdCilindro) {
    final String _sql = "SELECT * FROM Rastreabilidade WHERE cdCilindro = ? AND liberado = 'N' LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdCilindro == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cdCilindro);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("cdCilindro");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCapacidadeItem = _cursor.getColumnIndexOrThrow("capacidadeItem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final Rastreabilidade _result;
      if(_cursor.moveToFirst()) {
        _result = new Rastreabilidade();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _result.setCdFilial(_tmpCdFilial);
        final String _tmpCdCilindro;
        _tmpCdCilindro = _cursor.getString(_cursorIndexOfCdCilindro);
        _result.setCdCilindro(_tmpCdCilindro);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _result.setNumeroLote(_tmpNumeroLote);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _result.setIdNota(_tmpIdNota);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _result.setNumeroNota(_tmpNumeroNota);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _result.setCdItem(_tmpCdItem);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _result.setNumeroVeiculo(_tmpNumeroVeiculo);
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
        final Double _tmpCapacidadeItem;
        if (_cursor.isNull(_cursorIndexOfCapacidadeItem)) {
          _tmpCapacidadeItem = null;
        } else {
          _tmpCapacidadeItem = _cursor.getDouble(_cursorIndexOfCapacidadeItem);
        }
        _result.setCapacidadeItem(_tmpCapacidadeItem);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final String _tmpLiberado;
        _tmpLiberado = _cursor.getString(_cursorIndexOfLiberado);
        _result.setLiberado(_tmpLiberado);
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
  public List<Rastreabilidade> findByCustomer(Long cdCustomer) {
    final String _sql = "SELECT * FROM Rastreabilidade WHERE cdCustomer = ? AND idNota IS NULL ORDER BY numeroLote, cdCilindro";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("cdCilindro");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCapacidadeItem = _cursor.getColumnIndexOrThrow("capacidadeItem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final List<Rastreabilidade> _result = new ArrayList<Rastreabilidade>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Rastreabilidade _item;
        _item = new Rastreabilidade();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _item.setCdFilial(_tmpCdFilial);
        final String _tmpCdCilindro;
        _tmpCdCilindro = _cursor.getString(_cursorIndexOfCdCilindro);
        _item.setCdCilindro(_tmpCdCilindro);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _item.setNumeroLote(_tmpNumeroLote);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item.setNumeroNota(_tmpNumeroNota);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item.setNumeroVeiculo(_tmpNumeroVeiculo);
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
        final Double _tmpCapacidadeItem;
        if (_cursor.isNull(_cursorIndexOfCapacidadeItem)) {
          _tmpCapacidadeItem = null;
        } else {
          _tmpCapacidadeItem = _cursor.getDouble(_cursorIndexOfCapacidadeItem);
        }
        _item.setCapacidadeItem(_tmpCapacidadeItem);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpLiberado;
        _tmpLiberado = _cursor.getString(_cursorIndexOfLiberado);
        _item.setLiberado(_tmpLiberado);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Rastreabilidade> findByItem(Long idNota, Long cdItem) {
    final String _sql = "SELECT * FROM Rastreabilidade WHERE cdItem = ? and idNota = ? ORDER BY numeroLote, cdCilindro";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 2;
    if (idNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("cdCilindro");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCapacidadeItem = _cursor.getColumnIndexOrThrow("capacidadeItem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final List<Rastreabilidade> _result = new ArrayList<Rastreabilidade>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Rastreabilidade _item;
        _item = new Rastreabilidade();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _item.setCdFilial(_tmpCdFilial);
        final String _tmpCdCilindro;
        _tmpCdCilindro = _cursor.getString(_cursorIndexOfCdCilindro);
        _item.setCdCilindro(_tmpCdCilindro);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _item.setNumeroLote(_tmpNumeroLote);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item.setNumeroNota(_tmpNumeroNota);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item.setNumeroVeiculo(_tmpNumeroVeiculo);
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
        final Double _tmpCapacidadeItem;
        if (_cursor.isNull(_cursorIndexOfCapacidadeItem)) {
          _tmpCapacidadeItem = null;
        } else {
          _tmpCapacidadeItem = _cursor.getDouble(_cursorIndexOfCapacidadeItem);
        }
        _item.setCapacidadeItem(_tmpCapacidadeItem);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpLiberado;
        _tmpLiberado = _cursor.getString(_cursorIndexOfLiberado);
        _item.setLiberado(_tmpLiberado);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Rastreabilidade> find(Long idNota, Long numeroViagem, Long cdCustomer) {
    final String _sql = "SELECT DISTINCT idNota, cdItem, cdCilindro, numeroLote FROM Rastreabilidade WHERE Rastreabilidade.idNota = ?   AND Rastreabilidade.numeroViagem = ?   AND Rastreabilidade.cdCustomer = ? ORDER BY numeroLote, cdCilindro";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (idNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idNota);
    }
    _argIndex = 2;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroViagem);
    }
    _argIndex = 3;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("cdCilindro");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final List<Rastreabilidade> _result = new ArrayList<Rastreabilidade>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Rastreabilidade _item;
        _item = new Rastreabilidade();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final String _tmpCdCilindro;
        _tmpCdCilindro = _cursor.getString(_cursorIndexOfCdCilindro);
        _item.setCdCilindro(_tmpCdCilindro);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _item.setNumeroLote(_tmpNumeroLote);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Rastreabilidade> findByNota(Long idNota) {
    final String _sql = "SELECT * FROM Rastreabilidade WHERE idNota = ? ORDER BY numeroLote, cdCilindro";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("cdCilindro");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCapacidadeItem = _cursor.getColumnIndexOrThrow("capacidadeItem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final List<Rastreabilidade> _result = new ArrayList<Rastreabilidade>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Rastreabilidade _item;
        _item = new Rastreabilidade();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _item.setCdFilial(_tmpCdFilial);
        final String _tmpCdCilindro;
        _tmpCdCilindro = _cursor.getString(_cursorIndexOfCdCilindro);
        _item.setCdCilindro(_tmpCdCilindro);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _item.setNumeroLote(_tmpNumeroLote);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item.setNumeroNota(_tmpNumeroNota);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item.setNumeroVeiculo(_tmpNumeroVeiculo);
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
        final Double _tmpCapacidadeItem;
        if (_cursor.isNull(_cursorIndexOfCapacidadeItem)) {
          _tmpCapacidadeItem = null;
        } else {
          _tmpCapacidadeItem = _cursor.getDouble(_cursorIndexOfCapacidadeItem);
        }
        _item.setCapacidadeItem(_tmpCapacidadeItem);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpLiberado;
        _tmpLiberado = _cursor.getString(_cursorIndexOfLiberado);
        _item.setLiberado(_tmpLiberado);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
