package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.LotePatrimonio;
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
public class LotePatrimonioDao_Impl implements LotePatrimonioDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfLotePatrimonio;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfLotePatrimonio;

  public LotePatrimonioDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLotePatrimonio = new EntityInsertionAdapter<LotePatrimonio>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `LotePatrimonio`(`codigo`,`idNota`,`cdFilial`,`cdItem`,`capacidade`,`numeroLote`,`numeroVeiuclo`,`numeroViagem`,`dataViagem`,`cdCustomer`,`tipo`,`liberado`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LotePatrimonio value) {
        if (value.getCodigo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCodigo());
        }
        if (value.getIdNota() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIdNota());
        }
        if (value.getCdFilial() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCdFilial());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getCdItem());
        }
        if (value.getCapacidade() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getCapacidade());
        }
        if (value.getNumeroLote() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getNumeroLote());
        }
        if (value.getNumeroVeiuclo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNumeroVeiuclo());
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getNumeroViagem());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataViagem());
        if (_tmp == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp);
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getCdCustomer());
        }
        if (value.getTipo() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getTipo());
        }
        if (value.getLiberado() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLiberado());
        }
      }
    };
    this.__deletionAdapterOfLotePatrimonio = new EntityDeletionOrUpdateAdapter<LotePatrimonio>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `LotePatrimonio` WHERE `codigo` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LotePatrimonio value) {
        if (value.getCodigo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCodigo());
        }
      }
    };
  }

  @Override
  public void insert(LotePatrimonio lotePatrimonio) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfLotePatrimonio.insert(lotePatrimonio);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<LotePatrimonio> lotePatrimonios) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfLotePatrimonio.handleMultiple(lotePatrimonios);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<LotePatrimonio> getAll() {
    final String _sql = "SELECT * FROM LotePatrimonio";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfNumeroVeiuclo = _cursor.getColumnIndexOrThrow("numeroVeiuclo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfTipo = _cursor.getColumnIndexOrThrow("tipo");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final List<LotePatrimonio> _result = new ArrayList<LotePatrimonio>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LotePatrimonio _item;
        _item = new LotePatrimonio();
        final Long _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _item.setCdFilial(_tmpCdFilial);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item.setCapacidade(_tmpCapacidade);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _item.setNumeroLote(_tmpNumeroLote);
        final String _tmpNumeroVeiuclo;
        _tmpNumeroVeiuclo = _cursor.getString(_cursorIndexOfNumeroVeiuclo);
        _item.setNumeroVeiuclo(_tmpNumeroVeiuclo);
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
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Integer _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
        }
        _item.setTipo(_tmpTipo);
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
  public List<LotePatrimonio> find() {
    final String _sql = "SELECT * FROM LotePatrimonio WHERE idNota IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfNumeroVeiuclo = _cursor.getColumnIndexOrThrow("numeroVeiuclo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfTipo = _cursor.getColumnIndexOrThrow("tipo");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final List<LotePatrimonio> _result = new ArrayList<LotePatrimonio>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LotePatrimonio _item;
        _item = new LotePatrimonio();
        final Long _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _item.setCdFilial(_tmpCdFilial);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item.setCapacidade(_tmpCapacidade);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _item.setNumeroLote(_tmpNumeroLote);
        final String _tmpNumeroVeiuclo;
        _tmpNumeroVeiuclo = _cursor.getString(_cursorIndexOfNumeroVeiuclo);
        _item.setNumeroVeiuclo(_tmpNumeroVeiuclo);
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
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Integer _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
        }
        _item.setTipo(_tmpTipo);
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
  public List<LotePatrimonio> findById(Long idNota) {
    final String _sql = "SELECT * FROM LotePatrimonio WHERE idNota = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfNumeroVeiuclo = _cursor.getColumnIndexOrThrow("numeroVeiuclo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfTipo = _cursor.getColumnIndexOrThrow("tipo");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final List<LotePatrimonio> _result = new ArrayList<LotePatrimonio>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LotePatrimonio _item;
        _item = new LotePatrimonio();
        final Long _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _item.setCdFilial(_tmpCdFilial);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item.setCapacidade(_tmpCapacidade);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _item.setNumeroLote(_tmpNumeroLote);
        final String _tmpNumeroVeiuclo;
        _tmpNumeroVeiuclo = _cursor.getString(_cursorIndexOfNumeroVeiuclo);
        _item.setNumeroVeiuclo(_tmpNumeroVeiuclo);
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
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Integer _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
        }
        _item.setTipo(_tmpTipo);
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
  public LotePatrimonio find(String numeroLote, String liberado) {
    final String _sql = "SELECT * FROM LotePatrimonio WHERE numeroLote = ? AND liberado = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (numeroLote == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroLote);
    }
    _argIndex = 2;
    if (liberado == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, liberado);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfNumeroVeiuclo = _cursor.getColumnIndexOrThrow("numeroVeiuclo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfTipo = _cursor.getColumnIndexOrThrow("tipo");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final LotePatrimonio _result;
      if(_cursor.moveToFirst()) {
        _result = new LotePatrimonio();
        final Long _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
        }
        _result.setCodigo(_tmpCodigo);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _result.setIdNota(_tmpIdNota);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _result.setCdFilial(_tmpCdFilial);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _result.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _result.setCapacidade(_tmpCapacidade);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _result.setNumeroLote(_tmpNumeroLote);
        final String _tmpNumeroVeiuclo;
        _tmpNumeroVeiuclo = _cursor.getString(_cursorIndexOfNumeroVeiuclo);
        _result.setNumeroVeiuclo(_tmpNumeroVeiuclo);
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
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final Integer _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
        }
        _result.setTipo(_tmpTipo);
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
  public List<LotePatrimonio> find(Long idNota, Long cdItem, Double capacidade) {
    final String _sql = "SELECT * FROM LotePatrimonio WHERE idNota = ? AND cdItem = ? AND capacidade = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (idNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idNota);
    }
    _argIndex = 2;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 3;
    if (capacidade == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindDouble(_argIndex, capacidade);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfNumeroVeiuclo = _cursor.getColumnIndexOrThrow("numeroVeiuclo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfTipo = _cursor.getColumnIndexOrThrow("tipo");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final List<LotePatrimonio> _result = new ArrayList<LotePatrimonio>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LotePatrimonio _item;
        _item = new LotePatrimonio();
        final Long _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _item.setCdFilial(_tmpCdFilial);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item.setCapacidade(_tmpCapacidade);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _item.setNumeroLote(_tmpNumeroLote);
        final String _tmpNumeroVeiuclo;
        _tmpNumeroVeiuclo = _cursor.getString(_cursorIndexOfNumeroVeiuclo);
        _item.setNumeroVeiuclo(_tmpNumeroVeiuclo);
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
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Integer _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
        }
        _item.setTipo(_tmpTipo);
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
  public List<LotePatrimonio> find(Integer tipo) {
    final String _sql = "SELECT * FROM LotePatrimonio WHERE tipo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tipo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, tipo);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNumeroLote = _cursor.getColumnIndexOrThrow("numeroLote");
      final int _cursorIndexOfNumeroVeiuclo = _cursor.getColumnIndexOrThrow("numeroVeiuclo");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfTipo = _cursor.getColumnIndexOrThrow("tipo");
      final int _cursorIndexOfLiberado = _cursor.getColumnIndexOrThrow("liberado");
      final List<LotePatrimonio> _result = new ArrayList<LotePatrimonio>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LotePatrimonio _item;
        _item = new LotePatrimonio();
        final Long _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _item.setCdFilial(_tmpCdFilial);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item.setCapacidade(_tmpCapacidade);
        final String _tmpNumeroLote;
        _tmpNumeroLote = _cursor.getString(_cursorIndexOfNumeroLote);
        _item.setNumeroLote(_tmpNumeroLote);
        final String _tmpNumeroVeiuclo;
        _tmpNumeroVeiuclo = _cursor.getString(_cursorIndexOfNumeroVeiuclo);
        _item.setNumeroVeiuclo(_tmpNumeroVeiuclo);
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
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Integer _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
        }
        _item.setTipo(_tmpTipo);
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
