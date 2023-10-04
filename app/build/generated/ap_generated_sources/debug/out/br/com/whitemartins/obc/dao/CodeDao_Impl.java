package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Code;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class CodeDao_Impl implements CodeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCode;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCode;

  public CodeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCode = new EntityInsertionAdapter<Code>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Code`(`id`,`tipoCodigo`,`codigo`,`descricao`,`indRastreabilidade`,`cfop3`,`sufixo`,`cfop4`,`situacaoTributariaPis`,`cstPis`,`situacaoTributariaCofins`,`cstCofins`,`cstIpiZero`,`cstIpiTributado`,`cstIpiIsento`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Code value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTipoCodigo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTipoCodigo());
        }
        if (value.getCodigo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCodigo());
        }
        if (value.getDescricao() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescricao());
        }
        if (value.getIndRastreabilidade() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getIndRastreabilidade());
        }
        if (value.getCfop3() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCfop3());
        }
        if (value.getSufixo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSufixo());
        }
        if (value.getCfop4() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getCfop4());
        }
        if (value.getSituacaoTributariaPis() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getSituacaoTributariaPis());
        }
        if (value.getCstPis() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCstPis());
        }
        if (value.getSituacaoTributariaCofins() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getSituacaoTributariaCofins());
        }
        if (value.getCstCofins() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCstCofins());
        }
        if (value.getCstIpiZero() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCstIpiZero());
        }
        if (value.getCstIpiTributado() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getCstIpiTributado());
        }
        if (value.getCstIpiIsento() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getCstIpiIsento());
        }
      }
    };
    this.__deletionAdapterOfCode = new EntityDeletionOrUpdateAdapter<Code>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Code` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Code value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
  }

  @Override
  public void insert(Code code) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCode.insert(code);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Code code) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCode.handle(code);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Code> codes) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCode.handleMultiple(codes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Code> getAll() {
    final String _sql = "SELECT * FROM Code";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoCodigo = _cursor.getColumnIndexOrThrow("tipoCodigo");
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfCfop3 = _cursor.getColumnIndexOrThrow("cfop3");
      final int _cursorIndexOfSufixo = _cursor.getColumnIndexOrThrow("sufixo");
      final int _cursorIndexOfCfop4 = _cursor.getColumnIndexOrThrow("cfop4");
      final int _cursorIndexOfSituacaoTributariaPis = _cursor.getColumnIndexOrThrow("situacaoTributariaPis");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfSituacaoTributariaCofins = _cursor.getColumnIndexOrThrow("situacaoTributariaCofins");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfCstIpiZero = _cursor.getColumnIndexOrThrow("cstIpiZero");
      final int _cursorIndexOfCstIpiTributado = _cursor.getColumnIndexOrThrow("cstIpiTributado");
      final int _cursorIndexOfCstIpiIsento = _cursor.getColumnIndexOrThrow("cstIpiIsento");
      final List<Code> _result = new ArrayList<Code>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Code _item;
        _item = new Code();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpTipoCodigo;
        _tmpTipoCodigo = _cursor.getString(_cursorIndexOfTipoCodigo);
        _item.setTipoCodigo(_tmpTipoCodigo);
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _item.setDescricao(_tmpDescricao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _item.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpCfop3;
        if (_cursor.isNull(_cursorIndexOfCfop3)) {
          _tmpCfop3 = null;
        } else {
          _tmpCfop3 = _cursor.getInt(_cursorIndexOfCfop3);
        }
        _item.setCfop3(_tmpCfop3);
        final String _tmpSufixo;
        _tmpSufixo = _cursor.getString(_cursorIndexOfSufixo);
        _item.setSufixo(_tmpSufixo);
        final Integer _tmpCfop4;
        if (_cursor.isNull(_cursorIndexOfCfop4)) {
          _tmpCfop4 = null;
        } else {
          _tmpCfop4 = _cursor.getInt(_cursorIndexOfCfop4);
        }
        _item.setCfop4(_tmpCfop4);
        final Integer _tmpSituacaoTributariaPis;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaPis)) {
          _tmpSituacaoTributariaPis = null;
        } else {
          _tmpSituacaoTributariaPis = _cursor.getInt(_cursorIndexOfSituacaoTributariaPis);
        }
        _item.setSituacaoTributariaPis(_tmpSituacaoTributariaPis);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _item.setCstPis(_tmpCstPis);
        final Integer _tmpSituacaoTributariaCofins;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaCofins)) {
          _tmpSituacaoTributariaCofins = null;
        } else {
          _tmpSituacaoTributariaCofins = _cursor.getInt(_cursorIndexOfSituacaoTributariaCofins);
        }
        _item.setSituacaoTributariaCofins(_tmpSituacaoTributariaCofins);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _item.setCstCofins(_tmpCstCofins);
        final String _tmpCstIpiZero;
        _tmpCstIpiZero = _cursor.getString(_cursorIndexOfCstIpiZero);
        _item.setCstIpiZero(_tmpCstIpiZero);
        final String _tmpCstIpiTributado;
        _tmpCstIpiTributado = _cursor.getString(_cursorIndexOfCstIpiTributado);
        _item.setCstIpiTributado(_tmpCstIpiTributado);
        final String _tmpCstIpiIsento;
        _tmpCstIpiIsento = _cursor.getString(_cursorIndexOfCstIpiIsento);
        _item.setCstIpiIsento(_tmpCstIpiIsento);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Code findById(Long codigo) {
    final String _sql = "SELECT * FROM Code WHERE codigo = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (codigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, codigo);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoCodigo = _cursor.getColumnIndexOrThrow("tipoCodigo");
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfCfop3 = _cursor.getColumnIndexOrThrow("cfop3");
      final int _cursorIndexOfSufixo = _cursor.getColumnIndexOrThrow("sufixo");
      final int _cursorIndexOfCfop4 = _cursor.getColumnIndexOrThrow("cfop4");
      final int _cursorIndexOfSituacaoTributariaPis = _cursor.getColumnIndexOrThrow("situacaoTributariaPis");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfSituacaoTributariaCofins = _cursor.getColumnIndexOrThrow("situacaoTributariaCofins");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfCstIpiZero = _cursor.getColumnIndexOrThrow("cstIpiZero");
      final int _cursorIndexOfCstIpiTributado = _cursor.getColumnIndexOrThrow("cstIpiTributado");
      final int _cursorIndexOfCstIpiIsento = _cursor.getColumnIndexOrThrow("cstIpiIsento");
      final Code _result;
      if(_cursor.moveToFirst()) {
        _result = new Code();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpTipoCodigo;
        _tmpTipoCodigo = _cursor.getString(_cursorIndexOfTipoCodigo);
        _result.setTipoCodigo(_tmpTipoCodigo);
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _result.setCodigo(_tmpCodigo);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _result.setDescricao(_tmpDescricao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _result.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpCfop3;
        if (_cursor.isNull(_cursorIndexOfCfop3)) {
          _tmpCfop3 = null;
        } else {
          _tmpCfop3 = _cursor.getInt(_cursorIndexOfCfop3);
        }
        _result.setCfop3(_tmpCfop3);
        final String _tmpSufixo;
        _tmpSufixo = _cursor.getString(_cursorIndexOfSufixo);
        _result.setSufixo(_tmpSufixo);
        final Integer _tmpCfop4;
        if (_cursor.isNull(_cursorIndexOfCfop4)) {
          _tmpCfop4 = null;
        } else {
          _tmpCfop4 = _cursor.getInt(_cursorIndexOfCfop4);
        }
        _result.setCfop4(_tmpCfop4);
        final Integer _tmpSituacaoTributariaPis;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaPis)) {
          _tmpSituacaoTributariaPis = null;
        } else {
          _tmpSituacaoTributariaPis = _cursor.getInt(_cursorIndexOfSituacaoTributariaPis);
        }
        _result.setSituacaoTributariaPis(_tmpSituacaoTributariaPis);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _result.setCstPis(_tmpCstPis);
        final Integer _tmpSituacaoTributariaCofins;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaCofins)) {
          _tmpSituacaoTributariaCofins = null;
        } else {
          _tmpSituacaoTributariaCofins = _cursor.getInt(_cursorIndexOfSituacaoTributariaCofins);
        }
        _result.setSituacaoTributariaCofins(_tmpSituacaoTributariaCofins);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _result.setCstCofins(_tmpCstCofins);
        final String _tmpCstIpiZero;
        _tmpCstIpiZero = _cursor.getString(_cursorIndexOfCstIpiZero);
        _result.setCstIpiZero(_tmpCstIpiZero);
        final String _tmpCstIpiTributado;
        _tmpCstIpiTributado = _cursor.getString(_cursorIndexOfCstIpiTributado);
        _result.setCstIpiTributado(_tmpCstIpiTributado);
        final String _tmpCstIpiIsento;
        _tmpCstIpiIsento = _cursor.getString(_cursorIndexOfCstIpiIsento);
        _result.setCstIpiIsento(_tmpCstIpiIsento);
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
  public Code find(String tipoCodigo, Integer codigo, Integer cfop3) {
    final String _sql = "SELECT * FROM Code WHERE tipoCodigo = ? AND codigo = ? and cfop3 = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (tipoCodigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoCodigo);
    }
    _argIndex = 2;
    if (codigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, codigo);
    }
    _argIndex = 3;
    if (cfop3 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cfop3);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoCodigo = _cursor.getColumnIndexOrThrow("tipoCodigo");
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfCfop3 = _cursor.getColumnIndexOrThrow("cfop3");
      final int _cursorIndexOfSufixo = _cursor.getColumnIndexOrThrow("sufixo");
      final int _cursorIndexOfCfop4 = _cursor.getColumnIndexOrThrow("cfop4");
      final int _cursorIndexOfSituacaoTributariaPis = _cursor.getColumnIndexOrThrow("situacaoTributariaPis");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfSituacaoTributariaCofins = _cursor.getColumnIndexOrThrow("situacaoTributariaCofins");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfCstIpiZero = _cursor.getColumnIndexOrThrow("cstIpiZero");
      final int _cursorIndexOfCstIpiTributado = _cursor.getColumnIndexOrThrow("cstIpiTributado");
      final int _cursorIndexOfCstIpiIsento = _cursor.getColumnIndexOrThrow("cstIpiIsento");
      final Code _result;
      if(_cursor.moveToFirst()) {
        _result = new Code();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpTipoCodigo;
        _tmpTipoCodigo = _cursor.getString(_cursorIndexOfTipoCodigo);
        _result.setTipoCodigo(_tmpTipoCodigo);
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _result.setCodigo(_tmpCodigo);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _result.setDescricao(_tmpDescricao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _result.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpCfop3;
        if (_cursor.isNull(_cursorIndexOfCfop3)) {
          _tmpCfop3 = null;
        } else {
          _tmpCfop3 = _cursor.getInt(_cursorIndexOfCfop3);
        }
        _result.setCfop3(_tmpCfop3);
        final String _tmpSufixo;
        _tmpSufixo = _cursor.getString(_cursorIndexOfSufixo);
        _result.setSufixo(_tmpSufixo);
        final Integer _tmpCfop4;
        if (_cursor.isNull(_cursorIndexOfCfop4)) {
          _tmpCfop4 = null;
        } else {
          _tmpCfop4 = _cursor.getInt(_cursorIndexOfCfop4);
        }
        _result.setCfop4(_tmpCfop4);
        final Integer _tmpSituacaoTributariaPis;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaPis)) {
          _tmpSituacaoTributariaPis = null;
        } else {
          _tmpSituacaoTributariaPis = _cursor.getInt(_cursorIndexOfSituacaoTributariaPis);
        }
        _result.setSituacaoTributariaPis(_tmpSituacaoTributariaPis);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _result.setCstPis(_tmpCstPis);
        final Integer _tmpSituacaoTributariaCofins;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaCofins)) {
          _tmpSituacaoTributariaCofins = null;
        } else {
          _tmpSituacaoTributariaCofins = _cursor.getInt(_cursorIndexOfSituacaoTributariaCofins);
        }
        _result.setSituacaoTributariaCofins(_tmpSituacaoTributariaCofins);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _result.setCstCofins(_tmpCstCofins);
        final String _tmpCstIpiZero;
        _tmpCstIpiZero = _cursor.getString(_cursorIndexOfCstIpiZero);
        _result.setCstIpiZero(_tmpCstIpiZero);
        final String _tmpCstIpiTributado;
        _tmpCstIpiTributado = _cursor.getString(_cursorIndexOfCstIpiTributado);
        _result.setCstIpiTributado(_tmpCstIpiTributado);
        final String _tmpCstIpiIsento;
        _tmpCstIpiIsento = _cursor.getString(_cursorIndexOfCstIpiIsento);
        _result.setCstIpiIsento(_tmpCstIpiIsento);
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
  public Code find(Integer codigo, Integer cfop3) {
    final String _sql = "SELECT * FROM Code WHERE codigo = ? AND cfop3 = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (codigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, codigo);
    }
    _argIndex = 2;
    if (cfop3 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cfop3);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoCodigo = _cursor.getColumnIndexOrThrow("tipoCodigo");
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfCfop3 = _cursor.getColumnIndexOrThrow("cfop3");
      final int _cursorIndexOfSufixo = _cursor.getColumnIndexOrThrow("sufixo");
      final int _cursorIndexOfCfop4 = _cursor.getColumnIndexOrThrow("cfop4");
      final int _cursorIndexOfSituacaoTributariaPis = _cursor.getColumnIndexOrThrow("situacaoTributariaPis");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfSituacaoTributariaCofins = _cursor.getColumnIndexOrThrow("situacaoTributariaCofins");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfCstIpiZero = _cursor.getColumnIndexOrThrow("cstIpiZero");
      final int _cursorIndexOfCstIpiTributado = _cursor.getColumnIndexOrThrow("cstIpiTributado");
      final int _cursorIndexOfCstIpiIsento = _cursor.getColumnIndexOrThrow("cstIpiIsento");
      final Code _result;
      if(_cursor.moveToFirst()) {
        _result = new Code();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpTipoCodigo;
        _tmpTipoCodigo = _cursor.getString(_cursorIndexOfTipoCodigo);
        _result.setTipoCodigo(_tmpTipoCodigo);
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _result.setCodigo(_tmpCodigo);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _result.setDescricao(_tmpDescricao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _result.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpCfop3;
        if (_cursor.isNull(_cursorIndexOfCfop3)) {
          _tmpCfop3 = null;
        } else {
          _tmpCfop3 = _cursor.getInt(_cursorIndexOfCfop3);
        }
        _result.setCfop3(_tmpCfop3);
        final String _tmpSufixo;
        _tmpSufixo = _cursor.getString(_cursorIndexOfSufixo);
        _result.setSufixo(_tmpSufixo);
        final Integer _tmpCfop4;
        if (_cursor.isNull(_cursorIndexOfCfop4)) {
          _tmpCfop4 = null;
        } else {
          _tmpCfop4 = _cursor.getInt(_cursorIndexOfCfop4);
        }
        _result.setCfop4(_tmpCfop4);
        final Integer _tmpSituacaoTributariaPis;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaPis)) {
          _tmpSituacaoTributariaPis = null;
        } else {
          _tmpSituacaoTributariaPis = _cursor.getInt(_cursorIndexOfSituacaoTributariaPis);
        }
        _result.setSituacaoTributariaPis(_tmpSituacaoTributariaPis);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _result.setCstPis(_tmpCstPis);
        final Integer _tmpSituacaoTributariaCofins;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaCofins)) {
          _tmpSituacaoTributariaCofins = null;
        } else {
          _tmpSituacaoTributariaCofins = _cursor.getInt(_cursorIndexOfSituacaoTributariaCofins);
        }
        _result.setSituacaoTributariaCofins(_tmpSituacaoTributariaCofins);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _result.setCstCofins(_tmpCstCofins);
        final String _tmpCstIpiZero;
        _tmpCstIpiZero = _cursor.getString(_cursorIndexOfCstIpiZero);
        _result.setCstIpiZero(_tmpCstIpiZero);
        final String _tmpCstIpiTributado;
        _tmpCstIpiTributado = _cursor.getString(_cursorIndexOfCstIpiTributado);
        _result.setCstIpiTributado(_tmpCstIpiTributado);
        final String _tmpCstIpiIsento;
        _tmpCstIpiIsento = _cursor.getString(_cursorIndexOfCstIpiIsento);
        _result.setCstIpiIsento(_tmpCstIpiIsento);
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
  public Code find(Integer codigo) {
    final String _sql = "SELECT * FROM Code WHERE codigo = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (codigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, codigo);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoCodigo = _cursor.getColumnIndexOrThrow("tipoCodigo");
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfCfop3 = _cursor.getColumnIndexOrThrow("cfop3");
      final int _cursorIndexOfSufixo = _cursor.getColumnIndexOrThrow("sufixo");
      final int _cursorIndexOfCfop4 = _cursor.getColumnIndexOrThrow("cfop4");
      final int _cursorIndexOfSituacaoTributariaPis = _cursor.getColumnIndexOrThrow("situacaoTributariaPis");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfSituacaoTributariaCofins = _cursor.getColumnIndexOrThrow("situacaoTributariaCofins");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfCstIpiZero = _cursor.getColumnIndexOrThrow("cstIpiZero");
      final int _cursorIndexOfCstIpiTributado = _cursor.getColumnIndexOrThrow("cstIpiTributado");
      final int _cursorIndexOfCstIpiIsento = _cursor.getColumnIndexOrThrow("cstIpiIsento");
      final Code _result;
      if(_cursor.moveToFirst()) {
        _result = new Code();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpTipoCodigo;
        _tmpTipoCodigo = _cursor.getString(_cursorIndexOfTipoCodigo);
        _result.setTipoCodigo(_tmpTipoCodigo);
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _result.setCodigo(_tmpCodigo);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _result.setDescricao(_tmpDescricao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _result.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpCfop3;
        if (_cursor.isNull(_cursorIndexOfCfop3)) {
          _tmpCfop3 = null;
        } else {
          _tmpCfop3 = _cursor.getInt(_cursorIndexOfCfop3);
        }
        _result.setCfop3(_tmpCfop3);
        final String _tmpSufixo;
        _tmpSufixo = _cursor.getString(_cursorIndexOfSufixo);
        _result.setSufixo(_tmpSufixo);
        final Integer _tmpCfop4;
        if (_cursor.isNull(_cursorIndexOfCfop4)) {
          _tmpCfop4 = null;
        } else {
          _tmpCfop4 = _cursor.getInt(_cursorIndexOfCfop4);
        }
        _result.setCfop4(_tmpCfop4);
        final Integer _tmpSituacaoTributariaPis;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaPis)) {
          _tmpSituacaoTributariaPis = null;
        } else {
          _tmpSituacaoTributariaPis = _cursor.getInt(_cursorIndexOfSituacaoTributariaPis);
        }
        _result.setSituacaoTributariaPis(_tmpSituacaoTributariaPis);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _result.setCstPis(_tmpCstPis);
        final Integer _tmpSituacaoTributariaCofins;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaCofins)) {
          _tmpSituacaoTributariaCofins = null;
        } else {
          _tmpSituacaoTributariaCofins = _cursor.getInt(_cursorIndexOfSituacaoTributariaCofins);
        }
        _result.setSituacaoTributariaCofins(_tmpSituacaoTributariaCofins);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _result.setCstCofins(_tmpCstCofins);
        final String _tmpCstIpiZero;
        _tmpCstIpiZero = _cursor.getString(_cursorIndexOfCstIpiZero);
        _result.setCstIpiZero(_tmpCstIpiZero);
        final String _tmpCstIpiTributado;
        _tmpCstIpiTributado = _cursor.getString(_cursorIndexOfCstIpiTributado);
        _result.setCstIpiTributado(_tmpCstIpiTributado);
        final String _tmpCstIpiIsento;
        _tmpCstIpiIsento = _cursor.getString(_cursorIndexOfCstIpiIsento);
        _result.setCstIpiIsento(_tmpCstIpiIsento);
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
  public List<Code> find(String tipoCodigo) {
    final String _sql = "SELECT * FROM Code WHERE tipoCodigo = ? ORDER BY descricao";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tipoCodigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoCodigo);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoCodigo = _cursor.getColumnIndexOrThrow("tipoCodigo");
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfCfop3 = _cursor.getColumnIndexOrThrow("cfop3");
      final int _cursorIndexOfSufixo = _cursor.getColumnIndexOrThrow("sufixo");
      final int _cursorIndexOfCfop4 = _cursor.getColumnIndexOrThrow("cfop4");
      final int _cursorIndexOfSituacaoTributariaPis = _cursor.getColumnIndexOrThrow("situacaoTributariaPis");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfSituacaoTributariaCofins = _cursor.getColumnIndexOrThrow("situacaoTributariaCofins");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfCstIpiZero = _cursor.getColumnIndexOrThrow("cstIpiZero");
      final int _cursorIndexOfCstIpiTributado = _cursor.getColumnIndexOrThrow("cstIpiTributado");
      final int _cursorIndexOfCstIpiIsento = _cursor.getColumnIndexOrThrow("cstIpiIsento");
      final List<Code> _result = new ArrayList<Code>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Code _item;
        _item = new Code();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpTipoCodigo;
        _tmpTipoCodigo = _cursor.getString(_cursorIndexOfTipoCodigo);
        _item.setTipoCodigo(_tmpTipoCodigo);
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _item.setDescricao(_tmpDescricao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _item.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpCfop3;
        if (_cursor.isNull(_cursorIndexOfCfop3)) {
          _tmpCfop3 = null;
        } else {
          _tmpCfop3 = _cursor.getInt(_cursorIndexOfCfop3);
        }
        _item.setCfop3(_tmpCfop3);
        final String _tmpSufixo;
        _tmpSufixo = _cursor.getString(_cursorIndexOfSufixo);
        _item.setSufixo(_tmpSufixo);
        final Integer _tmpCfop4;
        if (_cursor.isNull(_cursorIndexOfCfop4)) {
          _tmpCfop4 = null;
        } else {
          _tmpCfop4 = _cursor.getInt(_cursorIndexOfCfop4);
        }
        _item.setCfop4(_tmpCfop4);
        final Integer _tmpSituacaoTributariaPis;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaPis)) {
          _tmpSituacaoTributariaPis = null;
        } else {
          _tmpSituacaoTributariaPis = _cursor.getInt(_cursorIndexOfSituacaoTributariaPis);
        }
        _item.setSituacaoTributariaPis(_tmpSituacaoTributariaPis);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _item.setCstPis(_tmpCstPis);
        final Integer _tmpSituacaoTributariaCofins;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaCofins)) {
          _tmpSituacaoTributariaCofins = null;
        } else {
          _tmpSituacaoTributariaCofins = _cursor.getInt(_cursorIndexOfSituacaoTributariaCofins);
        }
        _item.setSituacaoTributariaCofins(_tmpSituacaoTributariaCofins);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _item.setCstCofins(_tmpCstCofins);
        final String _tmpCstIpiZero;
        _tmpCstIpiZero = _cursor.getString(_cursorIndexOfCstIpiZero);
        _item.setCstIpiZero(_tmpCstIpiZero);
        final String _tmpCstIpiTributado;
        _tmpCstIpiTributado = _cursor.getString(_cursorIndexOfCstIpiTributado);
        _item.setCstIpiTributado(_tmpCstIpiTributado);
        final String _tmpCstIpiIsento;
        _tmpCstIpiIsento = _cursor.getString(_cursorIndexOfCstIpiIsento);
        _item.setCstIpiIsento(_tmpCstIpiIsento);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Code find(String tipoCodigo, Integer codigo, Integer cfop3, Integer cfop4) {
    final String _sql = "SELECT * FROM Code WHERE tipoCodigo = ? AND codigo = ? AND cfop3 = ? AND cfop4 = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (tipoCodigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoCodigo);
    }
    _argIndex = 2;
    if (codigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, codigo);
    }
    _argIndex = 3;
    if (cfop3 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cfop3);
    }
    _argIndex = 4;
    if (cfop4 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cfop4);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoCodigo = _cursor.getColumnIndexOrThrow("tipoCodigo");
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfCfop3 = _cursor.getColumnIndexOrThrow("cfop3");
      final int _cursorIndexOfSufixo = _cursor.getColumnIndexOrThrow("sufixo");
      final int _cursorIndexOfCfop4 = _cursor.getColumnIndexOrThrow("cfop4");
      final int _cursorIndexOfSituacaoTributariaPis = _cursor.getColumnIndexOrThrow("situacaoTributariaPis");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfSituacaoTributariaCofins = _cursor.getColumnIndexOrThrow("situacaoTributariaCofins");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfCstIpiZero = _cursor.getColumnIndexOrThrow("cstIpiZero");
      final int _cursorIndexOfCstIpiTributado = _cursor.getColumnIndexOrThrow("cstIpiTributado");
      final int _cursorIndexOfCstIpiIsento = _cursor.getColumnIndexOrThrow("cstIpiIsento");
      final Code _result;
      if(_cursor.moveToFirst()) {
        _result = new Code();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpTipoCodigo;
        _tmpTipoCodigo = _cursor.getString(_cursorIndexOfTipoCodigo);
        _result.setTipoCodigo(_tmpTipoCodigo);
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _result.setCodigo(_tmpCodigo);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _result.setDescricao(_tmpDescricao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _result.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpCfop3;
        if (_cursor.isNull(_cursorIndexOfCfop3)) {
          _tmpCfop3 = null;
        } else {
          _tmpCfop3 = _cursor.getInt(_cursorIndexOfCfop3);
        }
        _result.setCfop3(_tmpCfop3);
        final String _tmpSufixo;
        _tmpSufixo = _cursor.getString(_cursorIndexOfSufixo);
        _result.setSufixo(_tmpSufixo);
        final Integer _tmpCfop4;
        if (_cursor.isNull(_cursorIndexOfCfop4)) {
          _tmpCfop4 = null;
        } else {
          _tmpCfop4 = _cursor.getInt(_cursorIndexOfCfop4);
        }
        _result.setCfop4(_tmpCfop4);
        final Integer _tmpSituacaoTributariaPis;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaPis)) {
          _tmpSituacaoTributariaPis = null;
        } else {
          _tmpSituacaoTributariaPis = _cursor.getInt(_cursorIndexOfSituacaoTributariaPis);
        }
        _result.setSituacaoTributariaPis(_tmpSituacaoTributariaPis);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _result.setCstPis(_tmpCstPis);
        final Integer _tmpSituacaoTributariaCofins;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaCofins)) {
          _tmpSituacaoTributariaCofins = null;
        } else {
          _tmpSituacaoTributariaCofins = _cursor.getInt(_cursorIndexOfSituacaoTributariaCofins);
        }
        _result.setSituacaoTributariaCofins(_tmpSituacaoTributariaCofins);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _result.setCstCofins(_tmpCstCofins);
        final String _tmpCstIpiZero;
        _tmpCstIpiZero = _cursor.getString(_cursorIndexOfCstIpiZero);
        _result.setCstIpiZero(_tmpCstIpiZero);
        final String _tmpCstIpiTributado;
        _tmpCstIpiTributado = _cursor.getString(_cursorIndexOfCstIpiTributado);
        _result.setCstIpiTributado(_tmpCstIpiTributado);
        final String _tmpCstIpiIsento;
        _tmpCstIpiIsento = _cursor.getString(_cursorIndexOfCstIpiIsento);
        _result.setCstIpiIsento(_tmpCstIpiIsento);
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
  public Code find(String tipoCodigo, Integer codigo) {
    final String _sql = "SELECT * FROM Code WHERE tipoCodigo = ? AND codigo = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tipoCodigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoCodigo);
    }
    _argIndex = 2;
    if (codigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, codigo);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoCodigo = _cursor.getColumnIndexOrThrow("tipoCodigo");
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfDescricao = _cursor.getColumnIndexOrThrow("descricao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfCfop3 = _cursor.getColumnIndexOrThrow("cfop3");
      final int _cursorIndexOfSufixo = _cursor.getColumnIndexOrThrow("sufixo");
      final int _cursorIndexOfCfop4 = _cursor.getColumnIndexOrThrow("cfop4");
      final int _cursorIndexOfSituacaoTributariaPis = _cursor.getColumnIndexOrThrow("situacaoTributariaPis");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfSituacaoTributariaCofins = _cursor.getColumnIndexOrThrow("situacaoTributariaCofins");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfCstIpiZero = _cursor.getColumnIndexOrThrow("cstIpiZero");
      final int _cursorIndexOfCstIpiTributado = _cursor.getColumnIndexOrThrow("cstIpiTributado");
      final int _cursorIndexOfCstIpiIsento = _cursor.getColumnIndexOrThrow("cstIpiIsento");
      final Code _result;
      if(_cursor.moveToFirst()) {
        _result = new Code();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpTipoCodigo;
        _tmpTipoCodigo = _cursor.getString(_cursorIndexOfTipoCodigo);
        _result.setTipoCodigo(_tmpTipoCodigo);
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _result.setCodigo(_tmpCodigo);
        final String _tmpDescricao;
        _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        _result.setDescricao(_tmpDescricao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _result.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpCfop3;
        if (_cursor.isNull(_cursorIndexOfCfop3)) {
          _tmpCfop3 = null;
        } else {
          _tmpCfop3 = _cursor.getInt(_cursorIndexOfCfop3);
        }
        _result.setCfop3(_tmpCfop3);
        final String _tmpSufixo;
        _tmpSufixo = _cursor.getString(_cursorIndexOfSufixo);
        _result.setSufixo(_tmpSufixo);
        final Integer _tmpCfop4;
        if (_cursor.isNull(_cursorIndexOfCfop4)) {
          _tmpCfop4 = null;
        } else {
          _tmpCfop4 = _cursor.getInt(_cursorIndexOfCfop4);
        }
        _result.setCfop4(_tmpCfop4);
        final Integer _tmpSituacaoTributariaPis;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaPis)) {
          _tmpSituacaoTributariaPis = null;
        } else {
          _tmpSituacaoTributariaPis = _cursor.getInt(_cursorIndexOfSituacaoTributariaPis);
        }
        _result.setSituacaoTributariaPis(_tmpSituacaoTributariaPis);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _result.setCstPis(_tmpCstPis);
        final Integer _tmpSituacaoTributariaCofins;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaCofins)) {
          _tmpSituacaoTributariaCofins = null;
        } else {
          _tmpSituacaoTributariaCofins = _cursor.getInt(_cursorIndexOfSituacaoTributariaCofins);
        }
        _result.setSituacaoTributariaCofins(_tmpSituacaoTributariaCofins);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _result.setCstCofins(_tmpCstCofins);
        final String _tmpCstIpiZero;
        _tmpCstIpiZero = _cursor.getString(_cursorIndexOfCstIpiZero);
        _result.setCstIpiZero(_tmpCstIpiZero);
        final String _tmpCstIpiTributado;
        _tmpCstIpiTributado = _cursor.getString(_cursorIndexOfCstIpiTributado);
        _result.setCstIpiTributado(_tmpCstIpiTributado);
        final String _tmpCstIpiIsento;
        _tmpCstIpiIsento = _cursor.getString(_cursorIndexOfCstIpiIsento);
        _result.setCstIpiIsento(_tmpCstIpiIsento);
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
