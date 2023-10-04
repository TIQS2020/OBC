package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Asset;
import br.com.whitemartins.obc.model.AssetDistinct;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class AssetDao_Impl implements AssetDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAsset;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAsset;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfAsset;

  public AssetDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAsset = new EntityInsertionAdapter<Asset>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Asset`(`cdItem`,`descricao`,`numeroPatrimonio`,`numeroSerie`,`cdAtivo`,`descricaoAtivo`,`checado`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Asset value) {
        if (value.getCdItem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdItem());
        }
        if (value.getDescricao() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescricao());
        }
        if (value.getNumeroPatrimonio() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNumeroPatrimonio());
        }
        if (value.getNumeroSerie() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumeroSerie());
        }
        if (value.getCdAtivo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCdAtivo());
        }
        if (value.getDescricaoAtivo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescricaoAtivo());
        }
        if (value.getChecado() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getChecado());
        }
      }
    };
    this.__deletionAdapterOfAsset = new EntityDeletionOrUpdateAdapter<Asset>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Asset` WHERE `cdItem` = ? AND `numeroPatrimonio` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Asset value) {
        if (value.getCdItem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdItem());
        }
        if (value.getNumeroPatrimonio() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNumeroPatrimonio());
        }
      }
    };
    this.__updateAdapterOfAsset = new EntityDeletionOrUpdateAdapter<Asset>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Asset` SET `cdItem` = ?,`descricao` = ?,`numeroPatrimonio` = ?,`numeroSerie` = ?,`cdAtivo` = ?,`descricaoAtivo` = ?,`checado` = ? WHERE `cdItem` = ? AND `numeroPatrimonio` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Asset value) {
        if (value.getCdItem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdItem());
        }
        if (value.getDescricao() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescricao());
        }
        if (value.getNumeroPatrimonio() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNumeroPatrimonio());
        }
        if (value.getNumeroSerie() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumeroSerie());
        }
        if (value.getCdAtivo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCdAtivo());
        }
        if (value.getDescricaoAtivo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescricaoAtivo());
        }
        if (value.getChecado() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getChecado());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getCdItem());
        }
        if (value.getNumeroPatrimonio() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getNumeroPatrimonio());
        }
      }
    };
  }

  @Override
  public void insert(Asset asset) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAsset.insert(asset);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Asset asset) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAsset.handle(asset);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Asset> assets) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAsset.handleMultiple(assets);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Asset asset) {
    __db.beginTransaction();
    try {
      __updateAdapterOfAsset.handle(asset);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Asset> getAll() {
    final String _sql = "SELECT * FROM Asset";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfNumeroPatrimonio = _cursor.getColumnIndexOrThrow("numeroPatrimonio");
      final int _cursorIndexOfNumeroSerie = _cursor.getColumnIndexOrThrow("numeroSerie");
      final int _cursorIndexOfCdAtivo = _cursor.getColumnIndexOrThrow("cdAtivo");
      final int _cursorIndexOfDescricaoAtivo = _cursor.getColumnIndexOrThrow("descricaoAtivo");
      final int _cursorIndexOfChecado = _cursor.getColumnIndexOrThrow("checado");
      final List<Asset> _result = new ArrayList<Asset>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Asset _item;
        _item = new Asset();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _item.setDescricao(_tmpDescricao);
        final String _tmpNumeroPatrimonio;
        _tmpNumeroPatrimonio = _cursor.getString(_cursorIndexOfNumeroPatrimonio);
        _item.setNumeroPatrimonio(_tmpNumeroPatrimonio);
        final String _tmpNumeroSerie;
        _tmpNumeroSerie = _cursor.getString(_cursorIndexOfNumeroSerie);
        _item.setNumeroSerie(_tmpNumeroSerie);
        final String _tmpCdAtivo;
        _tmpCdAtivo = _cursor.getString(_cursorIndexOfCdAtivo);
        _item.setCdAtivo(_tmpCdAtivo);
        final String _tmpDescricaoAtivo;
        _tmpDescricaoAtivo = _cursor.getString(_cursorIndexOfDescricaoAtivo);
        _item.setDescricaoAtivo(_tmpDescricaoAtivo);
        final String _tmpChecado;
        _tmpChecado = _cursor.getString(_cursorIndexOfChecado);
        _item.setChecado(_tmpChecado);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Asset findById(Long cdAsset) {
    final String _sql = "SELECT * FROM Asset WHERE cdAtivo = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdAsset == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdAsset);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfNumeroPatrimonio = _cursor.getColumnIndexOrThrow("numeroPatrimonio");
      final int _cursorIndexOfNumeroSerie = _cursor.getColumnIndexOrThrow("numeroSerie");
      final int _cursorIndexOfCdAtivo = _cursor.getColumnIndexOrThrow("cdAtivo");
      final int _cursorIndexOfDescricaoAtivo = _cursor.getColumnIndexOrThrow("descricaoAtivo");
      final int _cursorIndexOfChecado = _cursor.getColumnIndexOrThrow("checado");
      final Asset _result;
      if(_cursor.moveToFirst()) {
        _result = new Asset();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _result.setCdItem(_tmpCdItem);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _result.setDescricao(_tmpDescricao);
        final String _tmpNumeroPatrimonio;
        _tmpNumeroPatrimonio = _cursor.getString(_cursorIndexOfNumeroPatrimonio);
        _result.setNumeroPatrimonio(_tmpNumeroPatrimonio);
        final String _tmpNumeroSerie;
        _tmpNumeroSerie = _cursor.getString(_cursorIndexOfNumeroSerie);
        _result.setNumeroSerie(_tmpNumeroSerie);
        final String _tmpCdAtivo;
        _tmpCdAtivo = _cursor.getString(_cursorIndexOfCdAtivo);
        _result.setCdAtivo(_tmpCdAtivo);
        final String _tmpDescricaoAtivo;
        _tmpDescricaoAtivo = _cursor.getString(_cursorIndexOfDescricaoAtivo);
        _result.setDescricaoAtivo(_tmpDescricaoAtivo);
        final String _tmpChecado;
        _tmpChecado = _cursor.getString(_cursorIndexOfChecado);
        _result.setChecado(_tmpChecado);
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
  public Asset findById(Long cdItem, String numeroPatrimonio) {
    final String _sql = "SELECT * FROM Asset WHERE  cdItem = ? AND numeroPatrimonio = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 2;
    if (numeroPatrimonio == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroPatrimonio);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfNumeroPatrimonio = _cursor.getColumnIndexOrThrow("numeroPatrimonio");
      final int _cursorIndexOfNumeroSerie = _cursor.getColumnIndexOrThrow("numeroSerie");
      final int _cursorIndexOfCdAtivo = _cursor.getColumnIndexOrThrow("cdAtivo");
      final int _cursorIndexOfDescricaoAtivo = _cursor.getColumnIndexOrThrow("descricaoAtivo");
      final int _cursorIndexOfChecado = _cursor.getColumnIndexOrThrow("checado");
      final Asset _result;
      if(_cursor.moveToFirst()) {
        _result = new Asset();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _result.setCdItem(_tmpCdItem);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _result.setDescricao(_tmpDescricao);
        final String _tmpNumeroPatrimonio;
        _tmpNumeroPatrimonio = _cursor.getString(_cursorIndexOfNumeroPatrimonio);
        _result.setNumeroPatrimonio(_tmpNumeroPatrimonio);
        final String _tmpNumeroSerie;
        _tmpNumeroSerie = _cursor.getString(_cursorIndexOfNumeroSerie);
        _result.setNumeroSerie(_tmpNumeroSerie);
        final String _tmpCdAtivo;
        _tmpCdAtivo = _cursor.getString(_cursorIndexOfCdAtivo);
        _result.setCdAtivo(_tmpCdAtivo);
        final String _tmpDescricaoAtivo;
        _tmpDescricaoAtivo = _cursor.getString(_cursorIndexOfDescricaoAtivo);
        _result.setDescricaoAtivo(_tmpDescricaoAtivo);
        final String _tmpChecado;
        _tmpChecado = _cursor.getString(_cursorIndexOfChecado);
        _result.setChecado(_tmpChecado);
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
  public List<Asset> findByCdItem(Long cdItem) {
    final String _sql = "SELECT * FROM Asset WHERE cdItem = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfNumeroPatrimonio = _cursor.getColumnIndexOrThrow("numeroPatrimonio");
      final int _cursorIndexOfNumeroSerie = _cursor.getColumnIndexOrThrow("numeroSerie");
      final int _cursorIndexOfCdAtivo = _cursor.getColumnIndexOrThrow("cdAtivo");
      final int _cursorIndexOfDescricaoAtivo = _cursor.getColumnIndexOrThrow("descricaoAtivo");
      final int _cursorIndexOfChecado = _cursor.getColumnIndexOrThrow("checado");
      final List<Asset> _result = new ArrayList<Asset>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Asset _item;
        _item = new Asset();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _item.setDescricao(_tmpDescricao);
        final String _tmpNumeroPatrimonio;
        _tmpNumeroPatrimonio = _cursor.getString(_cursorIndexOfNumeroPatrimonio);
        _item.setNumeroPatrimonio(_tmpNumeroPatrimonio);
        final String _tmpNumeroSerie;
        _tmpNumeroSerie = _cursor.getString(_cursorIndexOfNumeroSerie);
        _item.setNumeroSerie(_tmpNumeroSerie);
        final String _tmpCdAtivo;
        _tmpCdAtivo = _cursor.getString(_cursorIndexOfCdAtivo);
        _item.setCdAtivo(_tmpCdAtivo);
        final String _tmpDescricaoAtivo;
        _tmpDescricaoAtivo = _cursor.getString(_cursorIndexOfDescricaoAtivo);
        _item.setDescricaoAtivo(_tmpDescricaoAtivo);
        final String _tmpChecado;
        _tmpChecado = _cursor.getString(_cursorIndexOfChecado);
        _item.setChecado(_tmpChecado);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssetDistinct> getDistinct() {
    final String _sql = "SELECT DISTINCT cdItem, descricao FROM Asset";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final List<AssetDistinct> _result = new ArrayList<AssetDistinct>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssetDistinct _item;
        _item = new AssetDistinct();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _item.setDescricao(_tmpDescricao);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Asset findByNumeroPatrimonio(String numeroPatrimonio) {
    final String _sql = "SELECT * FROM Asset WHERE numeroPatrimonio = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numeroPatrimonio == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroPatrimonio);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfNumeroPatrimonio = _cursor.getColumnIndexOrThrow("numeroPatrimonio");
      final int _cursorIndexOfNumeroSerie = _cursor.getColumnIndexOrThrow("numeroSerie");
      final int _cursorIndexOfCdAtivo = _cursor.getColumnIndexOrThrow("cdAtivo");
      final int _cursorIndexOfDescricaoAtivo = _cursor.getColumnIndexOrThrow("descricaoAtivo");
      final int _cursorIndexOfChecado = _cursor.getColumnIndexOrThrow("checado");
      final Asset _result;
      if(_cursor.moveToFirst()) {
        _result = new Asset();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _result.setCdItem(_tmpCdItem);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _result.setDescricao(_tmpDescricao);
        final String _tmpNumeroPatrimonio;
        _tmpNumeroPatrimonio = _cursor.getString(_cursorIndexOfNumeroPatrimonio);
        _result.setNumeroPatrimonio(_tmpNumeroPatrimonio);
        final String _tmpNumeroSerie;
        _tmpNumeroSerie = _cursor.getString(_cursorIndexOfNumeroSerie);
        _result.setNumeroSerie(_tmpNumeroSerie);
        final String _tmpCdAtivo;
        _tmpCdAtivo = _cursor.getString(_cursorIndexOfCdAtivo);
        _result.setCdAtivo(_tmpCdAtivo);
        final String _tmpDescricaoAtivo;
        _tmpDescricaoAtivo = _cursor.getString(_cursorIndexOfDescricaoAtivo);
        _result.setDescricaoAtivo(_tmpDescricaoAtivo);
        final String _tmpChecado;
        _tmpChecado = _cursor.getString(_cursorIndexOfChecado);
        _result.setChecado(_tmpChecado);
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
  public List<Asset> getOpenAssets() {
    final String _sql = "SELECT * FROM Asset WHERE checado is null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfNumeroPatrimonio = _cursor.getColumnIndexOrThrow("numeroPatrimonio");
      final int _cursorIndexOfNumeroSerie = _cursor.getColumnIndexOrThrow("numeroSerie");
      final int _cursorIndexOfCdAtivo = _cursor.getColumnIndexOrThrow("cdAtivo");
      final int _cursorIndexOfDescricaoAtivo = _cursor.getColumnIndexOrThrow("descricaoAtivo");
      final int _cursorIndexOfChecado = _cursor.getColumnIndexOrThrow("checado");
      final List<Asset> _result = new ArrayList<Asset>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Asset _item;
        _item = new Asset();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _item.setDescricao(_tmpDescricao);
        final String _tmpNumeroPatrimonio;
        _tmpNumeroPatrimonio = _cursor.getString(_cursorIndexOfNumeroPatrimonio);
        _item.setNumeroPatrimonio(_tmpNumeroPatrimonio);
        final String _tmpNumeroSerie;
        _tmpNumeroSerie = _cursor.getString(_cursorIndexOfNumeroSerie);
        _item.setNumeroSerie(_tmpNumeroSerie);
        final String _tmpCdAtivo;
        _tmpCdAtivo = _cursor.getString(_cursorIndexOfCdAtivo);
        _item.setCdAtivo(_tmpCdAtivo);
        final String _tmpDescricaoAtivo;
        _tmpDescricaoAtivo = _cursor.getString(_cursorIndexOfDescricaoAtivo);
        _item.setDescricaoAtivo(_tmpDescricaoAtivo);
        final String _tmpChecado;
        _tmpChecado = _cursor.getString(_cursorIndexOfChecado);
        _item.setChecado(_tmpChecado);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
