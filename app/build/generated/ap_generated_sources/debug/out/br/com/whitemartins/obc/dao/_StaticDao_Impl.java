package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model._StaticTable;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public class _StaticDao_Impl implements _StaticDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOf_StaticTable;

  public _StaticDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOf_StaticTable = new EntityInsertionAdapter<_StaticTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `_StaticTable`(`id`,`semente`,`macAddress`,`nomeImpressora`,`cdFilial`,`cdVeiculo`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, _StaticTable value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getSemente() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSemente());
        }
        if (value.getMacAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMacAddress());
        }
        if (value.getNomeImpressora() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNomeImpressora());
        }
        if (value.getCdFilial() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCdFilial());
        }
        if (value.getCdVeiculo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCdVeiculo());
        }
      }
    };
  }

  @Override
  public void insert(_StaticTable staticTable) {
    __db.beginTransaction();
    try {
      __insertionAdapterOf_StaticTable.insert(staticTable);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public _StaticTable find() {
    final String _sql = "SELECT * FROM _StaticTable LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfSemente = _cursor.getColumnIndexOrThrow("semente");
      final int _cursorIndexOfMacAddress = _cursor.getColumnIndexOrThrow("macAddress");
      final int _cursorIndexOfNomeImpressora = _cursor.getColumnIndexOrThrow("nomeImpressora");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdVeiculo = _cursor.getColumnIndexOrThrow("cdVeiculo");
      final _StaticTable _result;
      if(_cursor.moveToFirst()) {
        _result = new _StaticTable();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpSemente;
        _tmpSemente = _cursor.getString(_cursorIndexOfSemente);
        _result.setSemente(_tmpSemente);
        final String _tmpMacAddress;
        _tmpMacAddress = _cursor.getString(_cursorIndexOfMacAddress);
        _result.setMacAddress(_tmpMacAddress);
        final String _tmpNomeImpressora;
        _tmpNomeImpressora = _cursor.getString(_cursorIndexOfNomeImpressora);
        _result.setNomeImpressora(_tmpNomeImpressora);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _result.setCdFilial(_tmpCdFilial);
        final String _tmpCdVeiculo;
        _tmpCdVeiculo = _cursor.getString(_cursorIndexOfCdVeiculo);
        _result.setCdVeiculo(_tmpCdVeiculo);
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
