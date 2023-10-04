package br.com.whitemartins.obc.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import br.com.whitemartins.obc.dao._StaticDao;
import br.com.whitemartins.obc.dao._StaticDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class _StaticDatabase_Impl extends _StaticDatabase {
  private volatile _StaticDao _StaticDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `_StaticTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `semente` TEXT, `macAddress` TEXT, `nomeImpressora` TEXT, `cdFilial` TEXT, `cdVeiculo` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"c79e3ce9435d293b75abd081ff263235\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `_StaticTable`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsStaticTable = new HashMap<String, TableInfo.Column>(6);
        _columnsStaticTable.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsStaticTable.put("semente", new TableInfo.Column("semente", "TEXT", false, 0));
        _columnsStaticTable.put("macAddress", new TableInfo.Column("macAddress", "TEXT", false, 0));
        _columnsStaticTable.put("nomeImpressora", new TableInfo.Column("nomeImpressora", "TEXT", false, 0));
        _columnsStaticTable.put("cdFilial", new TableInfo.Column("cdFilial", "TEXT", false, 0));
        _columnsStaticTable.put("cdVeiculo", new TableInfo.Column("cdVeiculo", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStaticTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStaticTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStaticTable = new TableInfo("_StaticTable", _columnsStaticTable, _foreignKeysStaticTable, _indicesStaticTable);
        final TableInfo _existingStaticTable = TableInfo.read(_db, "_StaticTable");
        if (! _infoStaticTable.equals(_existingStaticTable)) {
          throw new IllegalStateException("Migration didn't properly handle _StaticTable(br.com.whitemartins.obc.model._StaticTable).\n"
                  + " Expected:\n" + _infoStaticTable + "\n"
                  + " Found:\n" + _existingStaticTable);
        }
      }
    }, "c79e3ce9435d293b75abd081ff263235", "9af3ab3ebdef9a4ff8b870b437683a3a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "_StaticTable");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `_StaticTable`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public _StaticDao staticDao() {
    if (_StaticDao != null) {
      return _StaticDao;
    } else {
      synchronized(this) {
        if(_StaticDao == null) {
          _StaticDao = new _StaticDao_Impl(this);
        }
        return _StaticDao;
      }
    }
  }
}
