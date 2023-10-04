package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.util.StringUtil;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Saldo;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class SaldoDao_Impl implements SaldoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSaldo;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfSaldo;

  public SaldoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSaldo = new EntityInsertionAdapter<Saldo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Saldo`(`numeroViagem`,`cdItem`,`capacidade`,`nomeItem`,`tipoItem`,`tipoPropriedade`,`qtdCarregadaCheios`,`qtdCarregadaVazios`,`qtdAtualCheios`,`qtdAtualVazios`,`qtdCheiosCont`,`qtdVaziosCont`,`qtdVendidos`,`qtdAplicados`,`qtdRecolhidos`,`qtdAplicadosHC`,`qtdRecolhidosHC`,`qtdAplicadosHCCont`,`qtdRecolhidosHCCont`,`qtdTrocados`,`qtdTransferidos`,`qtdComplementados`,`qtdDescarregados`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Saldo value) {
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroViagem());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdItem());
        }
        if (value.getCapacidade() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getCapacidade());
        }
        if (value.getNomeItem() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNomeItem());
        }
        if (value.getTipoItem() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getTipoItem());
        }
        if (value.getTipoPropriedade() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTipoPropriedade());
        }
        if (value.getQtdCarregadaCheios() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getQtdCarregadaCheios());
        }
        if (value.getQtdCarregadaVazios() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getQtdCarregadaVazios());
        }
        if (value.getQtdAtualCheios() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getQtdAtualCheios());
        }
        if (value.getQtdAtualVazios() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getQtdAtualVazios());
        }
        if (value.getQtdCheiosCont() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getQtdCheiosCont());
        }
        if (value.getQtdVaziosCont() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindDouble(12, value.getQtdVaziosCont());
        }
        if (value.getQtdVendidos() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindDouble(13, value.getQtdVendidos());
        }
        if (value.getQtdAplicados() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindDouble(14, value.getQtdAplicados());
        }
        if (value.getQtdRecolhidos() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindDouble(15, value.getQtdRecolhidos());
        }
        if (value.getQtdAplicadosHC() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindDouble(16, value.getQtdAplicadosHC());
        }
        if (value.getQtdRecolhidosHC() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindDouble(17, value.getQtdRecolhidosHC());
        }
        if (value.getQtdAplicadosHCCont() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindDouble(18, value.getQtdAplicadosHCCont());
        }
        if (value.getQtdRecolhidosHCCont() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindDouble(19, value.getQtdRecolhidosHCCont());
        }
        if (value.getQtdTrocados() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindDouble(20, value.getQtdTrocados());
        }
        if (value.getQtdTransferidos() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindDouble(21, value.getQtdTransferidos());
        }
        if (value.getQtdComplementados() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindDouble(22, value.getQtdComplementados());
        }
        if (value.getQtdDescarregados() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindDouble(23, value.getQtdDescarregados());
        }
      }
    };
    this.__deletionAdapterOfSaldo = new EntityDeletionOrUpdateAdapter<Saldo>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Saldo` WHERE `numeroViagem` = ? AND `cdItem` = ? AND `capacidade` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Saldo value) {
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroViagem());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdItem());
        }
        if (value.getCapacidade() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getCapacidade());
        }
      }
    };
  }

  @Override
  public void insertAll(List<Saldo> saldos) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfSaldo.insert(saldos);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(Saldo saldo) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfSaldo.insert(saldo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Saldo Saldo) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaldo.handle(Saldo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Saldo> saldos) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfSaldo.handleMultiple(saldos);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Saldo> getAll() {
    final String _sql = "SELECT * FROM Saldo";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfQtdCarregadaCheios = _cursor.getColumnIndexOrThrow("qtdCarregadaCheios");
      final int _cursorIndexOfQtdCarregadaVazios = _cursor.getColumnIndexOrThrow("qtdCarregadaVazios");
      final int _cursorIndexOfQtdAtualCheios = _cursor.getColumnIndexOrThrow("qtdAtualCheios");
      final int _cursorIndexOfQtdAtualVazios = _cursor.getColumnIndexOrThrow("qtdAtualVazios");
      final int _cursorIndexOfQtdCheiosCont = _cursor.getColumnIndexOrThrow("qtdCheiosCont");
      final int _cursorIndexOfQtdVaziosCont = _cursor.getColumnIndexOrThrow("qtdVaziosCont");
      final int _cursorIndexOfQtdVendidos = _cursor.getColumnIndexOrThrow("qtdVendidos");
      final int _cursorIndexOfQtdAplicados = _cursor.getColumnIndexOrThrow("qtdAplicados");
      final int _cursorIndexOfQtdRecolhidos = _cursor.getColumnIndexOrThrow("qtdRecolhidos");
      final int _cursorIndexOfQtdAplicadosHC = _cursor.getColumnIndexOrThrow("qtdAplicadosHC");
      final int _cursorIndexOfQtdRecolhidosHC = _cursor.getColumnIndexOrThrow("qtdRecolhidosHC");
      final int _cursorIndexOfQtdAplicadosHCCont = _cursor.getColumnIndexOrThrow("qtdAplicadosHCCont");
      final int _cursorIndexOfQtdRecolhidosHCCont = _cursor.getColumnIndexOrThrow("qtdRecolhidosHCCont");
      final int _cursorIndexOfQtdTrocados = _cursor.getColumnIndexOrThrow("qtdTrocados");
      final int _cursorIndexOfQtdTransferidos = _cursor.getColumnIndexOrThrow("qtdTransferidos");
      final int _cursorIndexOfQtdComplementados = _cursor.getColumnIndexOrThrow("qtdComplementados");
      final int _cursorIndexOfQtdDescarregados = _cursor.getColumnIndexOrThrow("qtdDescarregados");
      final List<Saldo> _result = new ArrayList<Saldo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Saldo _item;
        _item = new Saldo();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _item.setNumeroViagem(_tmpNumeroViagem);
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
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _item.setNomeItem(_tmpNomeItem);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item.setTipoItem(_tmpTipoItem);
        final String _tmpTipoPropriedade;
        _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
        _item.setTipoPropriedade(_tmpTipoPropriedade);
        final Double _tmpQtdCarregadaCheios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaCheios)) {
          _tmpQtdCarregadaCheios = null;
        } else {
          _tmpQtdCarregadaCheios = _cursor.getDouble(_cursorIndexOfQtdCarregadaCheios);
        }
        _item.setQtdCarregadaCheios(_tmpQtdCarregadaCheios);
        final Double _tmpQtdCarregadaVazios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaVazios)) {
          _tmpQtdCarregadaVazios = null;
        } else {
          _tmpQtdCarregadaVazios = _cursor.getDouble(_cursorIndexOfQtdCarregadaVazios);
        }
        _item.setQtdCarregadaVazios(_tmpQtdCarregadaVazios);
        final Double _tmpQtdAtualCheios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualCheios)) {
          _tmpQtdAtualCheios = null;
        } else {
          _tmpQtdAtualCheios = _cursor.getDouble(_cursorIndexOfQtdAtualCheios);
        }
        _item.setQtdAtualCheios(_tmpQtdAtualCheios);
        final Double _tmpQtdAtualVazios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualVazios)) {
          _tmpQtdAtualVazios = null;
        } else {
          _tmpQtdAtualVazios = _cursor.getDouble(_cursorIndexOfQtdAtualVazios);
        }
        _item.setQtdAtualVazios(_tmpQtdAtualVazios);
        final Double _tmpQtdCheiosCont;
        if (_cursor.isNull(_cursorIndexOfQtdCheiosCont)) {
          _tmpQtdCheiosCont = null;
        } else {
          _tmpQtdCheiosCont = _cursor.getDouble(_cursorIndexOfQtdCheiosCont);
        }
        _item.setQtdCheiosCont(_tmpQtdCheiosCont);
        final Double _tmpQtdVaziosCont;
        if (_cursor.isNull(_cursorIndexOfQtdVaziosCont)) {
          _tmpQtdVaziosCont = null;
        } else {
          _tmpQtdVaziosCont = _cursor.getDouble(_cursorIndexOfQtdVaziosCont);
        }
        _item.setQtdVaziosCont(_tmpQtdVaziosCont);
        final Double _tmpQtdVendidos;
        if (_cursor.isNull(_cursorIndexOfQtdVendidos)) {
          _tmpQtdVendidos = null;
        } else {
          _tmpQtdVendidos = _cursor.getDouble(_cursorIndexOfQtdVendidos);
        }
        _item.setQtdVendidos(_tmpQtdVendidos);
        final Double _tmpQtdAplicados;
        if (_cursor.isNull(_cursorIndexOfQtdAplicados)) {
          _tmpQtdAplicados = null;
        } else {
          _tmpQtdAplicados = _cursor.getDouble(_cursorIndexOfQtdAplicados);
        }
        _item.setQtdAplicados(_tmpQtdAplicados);
        final Double _tmpQtdRecolhidos;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidos)) {
          _tmpQtdRecolhidos = null;
        } else {
          _tmpQtdRecolhidos = _cursor.getDouble(_cursorIndexOfQtdRecolhidos);
        }
        _item.setQtdRecolhidos(_tmpQtdRecolhidos);
        final Double _tmpQtdAplicadosHC;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHC)) {
          _tmpQtdAplicadosHC = null;
        } else {
          _tmpQtdAplicadosHC = _cursor.getDouble(_cursorIndexOfQtdAplicadosHC);
        }
        _item.setQtdAplicadosHC(_tmpQtdAplicadosHC);
        final Double _tmpQtdRecolhidosHC;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHC)) {
          _tmpQtdRecolhidosHC = null;
        } else {
          _tmpQtdRecolhidosHC = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHC);
        }
        _item.setQtdRecolhidosHC(_tmpQtdRecolhidosHC);
        final Double _tmpQtdAplicadosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHCCont)) {
          _tmpQtdAplicadosHCCont = null;
        } else {
          _tmpQtdAplicadosHCCont = _cursor.getDouble(_cursorIndexOfQtdAplicadosHCCont);
        }
        _item.setQtdAplicadosHCCont(_tmpQtdAplicadosHCCont);
        final Double _tmpQtdRecolhidosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHCCont)) {
          _tmpQtdRecolhidosHCCont = null;
        } else {
          _tmpQtdRecolhidosHCCont = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHCCont);
        }
        _item.setQtdRecolhidosHCCont(_tmpQtdRecolhidosHCCont);
        final Double _tmpQtdTrocados;
        if (_cursor.isNull(_cursorIndexOfQtdTrocados)) {
          _tmpQtdTrocados = null;
        } else {
          _tmpQtdTrocados = _cursor.getDouble(_cursorIndexOfQtdTrocados);
        }
        _item.setQtdTrocados(_tmpQtdTrocados);
        final Double _tmpQtdTransferidos;
        if (_cursor.isNull(_cursorIndexOfQtdTransferidos)) {
          _tmpQtdTransferidos = null;
        } else {
          _tmpQtdTransferidos = _cursor.getDouble(_cursorIndexOfQtdTransferidos);
        }
        _item.setQtdTransferidos(_tmpQtdTransferidos);
        final Double _tmpQtdComplementados;
        if (_cursor.isNull(_cursorIndexOfQtdComplementados)) {
          _tmpQtdComplementados = null;
        } else {
          _tmpQtdComplementados = _cursor.getDouble(_cursorIndexOfQtdComplementados);
        }
        _item.setQtdComplementados(_tmpQtdComplementados);
        final Double _tmpQtdDescarregados;
        if (_cursor.isNull(_cursorIndexOfQtdDescarregados)) {
          _tmpQtdDescarregados = null;
        } else {
          _tmpQtdDescarregados = _cursor.getDouble(_cursorIndexOfQtdDescarregados);
        }
        _item.setQtdDescarregados(_tmpQtdDescarregados);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Saldo find(Long cdItem, Double capacidade, Long numeroViagem) {
    final String _sql = "SELECT * FROM Saldo WHERE cdItem = ? AND capacidade = ?  AND numeroViagem = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 2;
    if (capacidade == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindDouble(_argIndex, capacidade);
    }
    _argIndex = 3;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroViagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfQtdCarregadaCheios = _cursor.getColumnIndexOrThrow("qtdCarregadaCheios");
      final int _cursorIndexOfQtdCarregadaVazios = _cursor.getColumnIndexOrThrow("qtdCarregadaVazios");
      final int _cursorIndexOfQtdAtualCheios = _cursor.getColumnIndexOrThrow("qtdAtualCheios");
      final int _cursorIndexOfQtdAtualVazios = _cursor.getColumnIndexOrThrow("qtdAtualVazios");
      final int _cursorIndexOfQtdCheiosCont = _cursor.getColumnIndexOrThrow("qtdCheiosCont");
      final int _cursorIndexOfQtdVaziosCont = _cursor.getColumnIndexOrThrow("qtdVaziosCont");
      final int _cursorIndexOfQtdVendidos = _cursor.getColumnIndexOrThrow("qtdVendidos");
      final int _cursorIndexOfQtdAplicados = _cursor.getColumnIndexOrThrow("qtdAplicados");
      final int _cursorIndexOfQtdRecolhidos = _cursor.getColumnIndexOrThrow("qtdRecolhidos");
      final int _cursorIndexOfQtdAplicadosHC = _cursor.getColumnIndexOrThrow("qtdAplicadosHC");
      final int _cursorIndexOfQtdRecolhidosHC = _cursor.getColumnIndexOrThrow("qtdRecolhidosHC");
      final int _cursorIndexOfQtdAplicadosHCCont = _cursor.getColumnIndexOrThrow("qtdAplicadosHCCont");
      final int _cursorIndexOfQtdRecolhidosHCCont = _cursor.getColumnIndexOrThrow("qtdRecolhidosHCCont");
      final int _cursorIndexOfQtdTrocados = _cursor.getColumnIndexOrThrow("qtdTrocados");
      final int _cursorIndexOfQtdTransferidos = _cursor.getColumnIndexOrThrow("qtdTransferidos");
      final int _cursorIndexOfQtdComplementados = _cursor.getColumnIndexOrThrow("qtdComplementados");
      final int _cursorIndexOfQtdDescarregados = _cursor.getColumnIndexOrThrow("qtdDescarregados");
      final Saldo _result;
      if(_cursor.moveToFirst()) {
        _result = new Saldo();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _result.setNumeroViagem(_tmpNumeroViagem);
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
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _result.setNomeItem(_tmpNomeItem);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _result.setTipoItem(_tmpTipoItem);
        final String _tmpTipoPropriedade;
        _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
        _result.setTipoPropriedade(_tmpTipoPropriedade);
        final Double _tmpQtdCarregadaCheios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaCheios)) {
          _tmpQtdCarregadaCheios = null;
        } else {
          _tmpQtdCarregadaCheios = _cursor.getDouble(_cursorIndexOfQtdCarregadaCheios);
        }
        _result.setQtdCarregadaCheios(_tmpQtdCarregadaCheios);
        final Double _tmpQtdCarregadaVazios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaVazios)) {
          _tmpQtdCarregadaVazios = null;
        } else {
          _tmpQtdCarregadaVazios = _cursor.getDouble(_cursorIndexOfQtdCarregadaVazios);
        }
        _result.setQtdCarregadaVazios(_tmpQtdCarregadaVazios);
        final Double _tmpQtdAtualCheios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualCheios)) {
          _tmpQtdAtualCheios = null;
        } else {
          _tmpQtdAtualCheios = _cursor.getDouble(_cursorIndexOfQtdAtualCheios);
        }
        _result.setQtdAtualCheios(_tmpQtdAtualCheios);
        final Double _tmpQtdAtualVazios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualVazios)) {
          _tmpQtdAtualVazios = null;
        } else {
          _tmpQtdAtualVazios = _cursor.getDouble(_cursorIndexOfQtdAtualVazios);
        }
        _result.setQtdAtualVazios(_tmpQtdAtualVazios);
        final Double _tmpQtdCheiosCont;
        if (_cursor.isNull(_cursorIndexOfQtdCheiosCont)) {
          _tmpQtdCheiosCont = null;
        } else {
          _tmpQtdCheiosCont = _cursor.getDouble(_cursorIndexOfQtdCheiosCont);
        }
        _result.setQtdCheiosCont(_tmpQtdCheiosCont);
        final Double _tmpQtdVaziosCont;
        if (_cursor.isNull(_cursorIndexOfQtdVaziosCont)) {
          _tmpQtdVaziosCont = null;
        } else {
          _tmpQtdVaziosCont = _cursor.getDouble(_cursorIndexOfQtdVaziosCont);
        }
        _result.setQtdVaziosCont(_tmpQtdVaziosCont);
        final Double _tmpQtdVendidos;
        if (_cursor.isNull(_cursorIndexOfQtdVendidos)) {
          _tmpQtdVendidos = null;
        } else {
          _tmpQtdVendidos = _cursor.getDouble(_cursorIndexOfQtdVendidos);
        }
        _result.setQtdVendidos(_tmpQtdVendidos);
        final Double _tmpQtdAplicados;
        if (_cursor.isNull(_cursorIndexOfQtdAplicados)) {
          _tmpQtdAplicados = null;
        } else {
          _tmpQtdAplicados = _cursor.getDouble(_cursorIndexOfQtdAplicados);
        }
        _result.setQtdAplicados(_tmpQtdAplicados);
        final Double _tmpQtdRecolhidos;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidos)) {
          _tmpQtdRecolhidos = null;
        } else {
          _tmpQtdRecolhidos = _cursor.getDouble(_cursorIndexOfQtdRecolhidos);
        }
        _result.setQtdRecolhidos(_tmpQtdRecolhidos);
        final Double _tmpQtdAplicadosHC;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHC)) {
          _tmpQtdAplicadosHC = null;
        } else {
          _tmpQtdAplicadosHC = _cursor.getDouble(_cursorIndexOfQtdAplicadosHC);
        }
        _result.setQtdAplicadosHC(_tmpQtdAplicadosHC);
        final Double _tmpQtdRecolhidosHC;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHC)) {
          _tmpQtdRecolhidosHC = null;
        } else {
          _tmpQtdRecolhidosHC = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHC);
        }
        _result.setQtdRecolhidosHC(_tmpQtdRecolhidosHC);
        final Double _tmpQtdAplicadosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHCCont)) {
          _tmpQtdAplicadosHCCont = null;
        } else {
          _tmpQtdAplicadosHCCont = _cursor.getDouble(_cursorIndexOfQtdAplicadosHCCont);
        }
        _result.setQtdAplicadosHCCont(_tmpQtdAplicadosHCCont);
        final Double _tmpQtdRecolhidosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHCCont)) {
          _tmpQtdRecolhidosHCCont = null;
        } else {
          _tmpQtdRecolhidosHCCont = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHCCont);
        }
        _result.setQtdRecolhidosHCCont(_tmpQtdRecolhidosHCCont);
        final Double _tmpQtdTrocados;
        if (_cursor.isNull(_cursorIndexOfQtdTrocados)) {
          _tmpQtdTrocados = null;
        } else {
          _tmpQtdTrocados = _cursor.getDouble(_cursorIndexOfQtdTrocados);
        }
        _result.setQtdTrocados(_tmpQtdTrocados);
        final Double _tmpQtdTransferidos;
        if (_cursor.isNull(_cursorIndexOfQtdTransferidos)) {
          _tmpQtdTransferidos = null;
        } else {
          _tmpQtdTransferidos = _cursor.getDouble(_cursorIndexOfQtdTransferidos);
        }
        _result.setQtdTransferidos(_tmpQtdTransferidos);
        final Double _tmpQtdComplementados;
        if (_cursor.isNull(_cursorIndexOfQtdComplementados)) {
          _tmpQtdComplementados = null;
        } else {
          _tmpQtdComplementados = _cursor.getDouble(_cursorIndexOfQtdComplementados);
        }
        _result.setQtdComplementados(_tmpQtdComplementados);
        final Double _tmpQtdDescarregados;
        if (_cursor.isNull(_cursorIndexOfQtdDescarregados)) {
          _tmpQtdDescarregados = null;
        } else {
          _tmpQtdDescarregados = _cursor.getDouble(_cursorIndexOfQtdDescarregados);
        }
        _result.setQtdDescarregados(_tmpQtdDescarregados);
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
  public List<Saldo> find(List<Integer> tipoItem, Long numeroViagem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Saldo where tipoItem IN (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")  AND numeroViagem = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" AND qtdCarregadaCheios > 0");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 1 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : tipoItem) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 1 + _inputSize;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroViagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfQtdCarregadaCheios = _cursor.getColumnIndexOrThrow("qtdCarregadaCheios");
      final int _cursorIndexOfQtdCarregadaVazios = _cursor.getColumnIndexOrThrow("qtdCarregadaVazios");
      final int _cursorIndexOfQtdAtualCheios = _cursor.getColumnIndexOrThrow("qtdAtualCheios");
      final int _cursorIndexOfQtdAtualVazios = _cursor.getColumnIndexOrThrow("qtdAtualVazios");
      final int _cursorIndexOfQtdCheiosCont = _cursor.getColumnIndexOrThrow("qtdCheiosCont");
      final int _cursorIndexOfQtdVaziosCont = _cursor.getColumnIndexOrThrow("qtdVaziosCont");
      final int _cursorIndexOfQtdVendidos = _cursor.getColumnIndexOrThrow("qtdVendidos");
      final int _cursorIndexOfQtdAplicados = _cursor.getColumnIndexOrThrow("qtdAplicados");
      final int _cursorIndexOfQtdRecolhidos = _cursor.getColumnIndexOrThrow("qtdRecolhidos");
      final int _cursorIndexOfQtdAplicadosHC = _cursor.getColumnIndexOrThrow("qtdAplicadosHC");
      final int _cursorIndexOfQtdRecolhidosHC = _cursor.getColumnIndexOrThrow("qtdRecolhidosHC");
      final int _cursorIndexOfQtdAplicadosHCCont = _cursor.getColumnIndexOrThrow("qtdAplicadosHCCont");
      final int _cursorIndexOfQtdRecolhidosHCCont = _cursor.getColumnIndexOrThrow("qtdRecolhidosHCCont");
      final int _cursorIndexOfQtdTrocados = _cursor.getColumnIndexOrThrow("qtdTrocados");
      final int _cursorIndexOfQtdTransferidos = _cursor.getColumnIndexOrThrow("qtdTransferidos");
      final int _cursorIndexOfQtdComplementados = _cursor.getColumnIndexOrThrow("qtdComplementados");
      final int _cursorIndexOfQtdDescarregados = _cursor.getColumnIndexOrThrow("qtdDescarregados");
      final List<Saldo> _result = new ArrayList<Saldo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Saldo _item_1;
        _item_1 = new Saldo();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _item_1.setNumeroViagem(_tmpNumeroViagem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item_1.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item_1.setCapacidade(_tmpCapacidade);
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _item_1.setNomeItem(_tmpNomeItem);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item_1.setTipoItem(_tmpTipoItem);
        final String _tmpTipoPropriedade;
        _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
        _item_1.setTipoPropriedade(_tmpTipoPropriedade);
        final Double _tmpQtdCarregadaCheios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaCheios)) {
          _tmpQtdCarregadaCheios = null;
        } else {
          _tmpQtdCarregadaCheios = _cursor.getDouble(_cursorIndexOfQtdCarregadaCheios);
        }
        _item_1.setQtdCarregadaCheios(_tmpQtdCarregadaCheios);
        final Double _tmpQtdCarregadaVazios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaVazios)) {
          _tmpQtdCarregadaVazios = null;
        } else {
          _tmpQtdCarregadaVazios = _cursor.getDouble(_cursorIndexOfQtdCarregadaVazios);
        }
        _item_1.setQtdCarregadaVazios(_tmpQtdCarregadaVazios);
        final Double _tmpQtdAtualCheios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualCheios)) {
          _tmpQtdAtualCheios = null;
        } else {
          _tmpQtdAtualCheios = _cursor.getDouble(_cursorIndexOfQtdAtualCheios);
        }
        _item_1.setQtdAtualCheios(_tmpQtdAtualCheios);
        final Double _tmpQtdAtualVazios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualVazios)) {
          _tmpQtdAtualVazios = null;
        } else {
          _tmpQtdAtualVazios = _cursor.getDouble(_cursorIndexOfQtdAtualVazios);
        }
        _item_1.setQtdAtualVazios(_tmpQtdAtualVazios);
        final Double _tmpQtdCheiosCont;
        if (_cursor.isNull(_cursorIndexOfQtdCheiosCont)) {
          _tmpQtdCheiosCont = null;
        } else {
          _tmpQtdCheiosCont = _cursor.getDouble(_cursorIndexOfQtdCheiosCont);
        }
        _item_1.setQtdCheiosCont(_tmpQtdCheiosCont);
        final Double _tmpQtdVaziosCont;
        if (_cursor.isNull(_cursorIndexOfQtdVaziosCont)) {
          _tmpQtdVaziosCont = null;
        } else {
          _tmpQtdVaziosCont = _cursor.getDouble(_cursorIndexOfQtdVaziosCont);
        }
        _item_1.setQtdVaziosCont(_tmpQtdVaziosCont);
        final Double _tmpQtdVendidos;
        if (_cursor.isNull(_cursorIndexOfQtdVendidos)) {
          _tmpQtdVendidos = null;
        } else {
          _tmpQtdVendidos = _cursor.getDouble(_cursorIndexOfQtdVendidos);
        }
        _item_1.setQtdVendidos(_tmpQtdVendidos);
        final Double _tmpQtdAplicados;
        if (_cursor.isNull(_cursorIndexOfQtdAplicados)) {
          _tmpQtdAplicados = null;
        } else {
          _tmpQtdAplicados = _cursor.getDouble(_cursorIndexOfQtdAplicados);
        }
        _item_1.setQtdAplicados(_tmpQtdAplicados);
        final Double _tmpQtdRecolhidos;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidos)) {
          _tmpQtdRecolhidos = null;
        } else {
          _tmpQtdRecolhidos = _cursor.getDouble(_cursorIndexOfQtdRecolhidos);
        }
        _item_1.setQtdRecolhidos(_tmpQtdRecolhidos);
        final Double _tmpQtdAplicadosHC;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHC)) {
          _tmpQtdAplicadosHC = null;
        } else {
          _tmpQtdAplicadosHC = _cursor.getDouble(_cursorIndexOfQtdAplicadosHC);
        }
        _item_1.setQtdAplicadosHC(_tmpQtdAplicadosHC);
        final Double _tmpQtdRecolhidosHC;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHC)) {
          _tmpQtdRecolhidosHC = null;
        } else {
          _tmpQtdRecolhidosHC = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHC);
        }
        _item_1.setQtdRecolhidosHC(_tmpQtdRecolhidosHC);
        final Double _tmpQtdAplicadosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHCCont)) {
          _tmpQtdAplicadosHCCont = null;
        } else {
          _tmpQtdAplicadosHCCont = _cursor.getDouble(_cursorIndexOfQtdAplicadosHCCont);
        }
        _item_1.setQtdAplicadosHCCont(_tmpQtdAplicadosHCCont);
        final Double _tmpQtdRecolhidosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHCCont)) {
          _tmpQtdRecolhidosHCCont = null;
        } else {
          _tmpQtdRecolhidosHCCont = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHCCont);
        }
        _item_1.setQtdRecolhidosHCCont(_tmpQtdRecolhidosHCCont);
        final Double _tmpQtdTrocados;
        if (_cursor.isNull(_cursorIndexOfQtdTrocados)) {
          _tmpQtdTrocados = null;
        } else {
          _tmpQtdTrocados = _cursor.getDouble(_cursorIndexOfQtdTrocados);
        }
        _item_1.setQtdTrocados(_tmpQtdTrocados);
        final Double _tmpQtdTransferidos;
        if (_cursor.isNull(_cursorIndexOfQtdTransferidos)) {
          _tmpQtdTransferidos = null;
        } else {
          _tmpQtdTransferidos = _cursor.getDouble(_cursorIndexOfQtdTransferidos);
        }
        _item_1.setQtdTransferidos(_tmpQtdTransferidos);
        final Double _tmpQtdComplementados;
        if (_cursor.isNull(_cursorIndexOfQtdComplementados)) {
          _tmpQtdComplementados = null;
        } else {
          _tmpQtdComplementados = _cursor.getDouble(_cursorIndexOfQtdComplementados);
        }
        _item_1.setQtdComplementados(_tmpQtdComplementados);
        final Double _tmpQtdDescarregados;
        if (_cursor.isNull(_cursorIndexOfQtdDescarregados)) {
          _tmpQtdDescarregados = null;
        } else {
          _tmpQtdDescarregados = _cursor.getDouble(_cursorIndexOfQtdDescarregados);
        }
        _item_1.setQtdDescarregados(_tmpQtdDescarregados);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Saldo> findMovementEquipment(List<Integer> tipoItem, Long numeroViagem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Saldo where tipoItem IN (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")  AND numeroViagem = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" AND (qtdCarregadaCheios > 0 OR qtdRecolhidosHC > 0)");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 1 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : tipoItem) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 1 + _inputSize;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroViagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfQtdCarregadaCheios = _cursor.getColumnIndexOrThrow("qtdCarregadaCheios");
      final int _cursorIndexOfQtdCarregadaVazios = _cursor.getColumnIndexOrThrow("qtdCarregadaVazios");
      final int _cursorIndexOfQtdAtualCheios = _cursor.getColumnIndexOrThrow("qtdAtualCheios");
      final int _cursorIndexOfQtdAtualVazios = _cursor.getColumnIndexOrThrow("qtdAtualVazios");
      final int _cursorIndexOfQtdCheiosCont = _cursor.getColumnIndexOrThrow("qtdCheiosCont");
      final int _cursorIndexOfQtdVaziosCont = _cursor.getColumnIndexOrThrow("qtdVaziosCont");
      final int _cursorIndexOfQtdVendidos = _cursor.getColumnIndexOrThrow("qtdVendidos");
      final int _cursorIndexOfQtdAplicados = _cursor.getColumnIndexOrThrow("qtdAplicados");
      final int _cursorIndexOfQtdRecolhidos = _cursor.getColumnIndexOrThrow("qtdRecolhidos");
      final int _cursorIndexOfQtdAplicadosHC = _cursor.getColumnIndexOrThrow("qtdAplicadosHC");
      final int _cursorIndexOfQtdRecolhidosHC = _cursor.getColumnIndexOrThrow("qtdRecolhidosHC");
      final int _cursorIndexOfQtdAplicadosHCCont = _cursor.getColumnIndexOrThrow("qtdAplicadosHCCont");
      final int _cursorIndexOfQtdRecolhidosHCCont = _cursor.getColumnIndexOrThrow("qtdRecolhidosHCCont");
      final int _cursorIndexOfQtdTrocados = _cursor.getColumnIndexOrThrow("qtdTrocados");
      final int _cursorIndexOfQtdTransferidos = _cursor.getColumnIndexOrThrow("qtdTransferidos");
      final int _cursorIndexOfQtdComplementados = _cursor.getColumnIndexOrThrow("qtdComplementados");
      final int _cursorIndexOfQtdDescarregados = _cursor.getColumnIndexOrThrow("qtdDescarregados");
      final List<Saldo> _result = new ArrayList<Saldo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Saldo _item_1;
        _item_1 = new Saldo();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _item_1.setNumeroViagem(_tmpNumeroViagem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item_1.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item_1.setCapacidade(_tmpCapacidade);
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _item_1.setNomeItem(_tmpNomeItem);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item_1.setTipoItem(_tmpTipoItem);
        final String _tmpTipoPropriedade;
        _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
        _item_1.setTipoPropriedade(_tmpTipoPropriedade);
        final Double _tmpQtdCarregadaCheios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaCheios)) {
          _tmpQtdCarregadaCheios = null;
        } else {
          _tmpQtdCarregadaCheios = _cursor.getDouble(_cursorIndexOfQtdCarregadaCheios);
        }
        _item_1.setQtdCarregadaCheios(_tmpQtdCarregadaCheios);
        final Double _tmpQtdCarregadaVazios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaVazios)) {
          _tmpQtdCarregadaVazios = null;
        } else {
          _tmpQtdCarregadaVazios = _cursor.getDouble(_cursorIndexOfQtdCarregadaVazios);
        }
        _item_1.setQtdCarregadaVazios(_tmpQtdCarregadaVazios);
        final Double _tmpQtdAtualCheios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualCheios)) {
          _tmpQtdAtualCheios = null;
        } else {
          _tmpQtdAtualCheios = _cursor.getDouble(_cursorIndexOfQtdAtualCheios);
        }
        _item_1.setQtdAtualCheios(_tmpQtdAtualCheios);
        final Double _tmpQtdAtualVazios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualVazios)) {
          _tmpQtdAtualVazios = null;
        } else {
          _tmpQtdAtualVazios = _cursor.getDouble(_cursorIndexOfQtdAtualVazios);
        }
        _item_1.setQtdAtualVazios(_tmpQtdAtualVazios);
        final Double _tmpQtdCheiosCont;
        if (_cursor.isNull(_cursorIndexOfQtdCheiosCont)) {
          _tmpQtdCheiosCont = null;
        } else {
          _tmpQtdCheiosCont = _cursor.getDouble(_cursorIndexOfQtdCheiosCont);
        }
        _item_1.setQtdCheiosCont(_tmpQtdCheiosCont);
        final Double _tmpQtdVaziosCont;
        if (_cursor.isNull(_cursorIndexOfQtdVaziosCont)) {
          _tmpQtdVaziosCont = null;
        } else {
          _tmpQtdVaziosCont = _cursor.getDouble(_cursorIndexOfQtdVaziosCont);
        }
        _item_1.setQtdVaziosCont(_tmpQtdVaziosCont);
        final Double _tmpQtdVendidos;
        if (_cursor.isNull(_cursorIndexOfQtdVendidos)) {
          _tmpQtdVendidos = null;
        } else {
          _tmpQtdVendidos = _cursor.getDouble(_cursorIndexOfQtdVendidos);
        }
        _item_1.setQtdVendidos(_tmpQtdVendidos);
        final Double _tmpQtdAplicados;
        if (_cursor.isNull(_cursorIndexOfQtdAplicados)) {
          _tmpQtdAplicados = null;
        } else {
          _tmpQtdAplicados = _cursor.getDouble(_cursorIndexOfQtdAplicados);
        }
        _item_1.setQtdAplicados(_tmpQtdAplicados);
        final Double _tmpQtdRecolhidos;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidos)) {
          _tmpQtdRecolhidos = null;
        } else {
          _tmpQtdRecolhidos = _cursor.getDouble(_cursorIndexOfQtdRecolhidos);
        }
        _item_1.setQtdRecolhidos(_tmpQtdRecolhidos);
        final Double _tmpQtdAplicadosHC;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHC)) {
          _tmpQtdAplicadosHC = null;
        } else {
          _tmpQtdAplicadosHC = _cursor.getDouble(_cursorIndexOfQtdAplicadosHC);
        }
        _item_1.setQtdAplicadosHC(_tmpQtdAplicadosHC);
        final Double _tmpQtdRecolhidosHC;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHC)) {
          _tmpQtdRecolhidosHC = null;
        } else {
          _tmpQtdRecolhidosHC = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHC);
        }
        _item_1.setQtdRecolhidosHC(_tmpQtdRecolhidosHC);
        final Double _tmpQtdAplicadosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHCCont)) {
          _tmpQtdAplicadosHCCont = null;
        } else {
          _tmpQtdAplicadosHCCont = _cursor.getDouble(_cursorIndexOfQtdAplicadosHCCont);
        }
        _item_1.setQtdAplicadosHCCont(_tmpQtdAplicadosHCCont);
        final Double _tmpQtdRecolhidosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHCCont)) {
          _tmpQtdRecolhidosHCCont = null;
        } else {
          _tmpQtdRecolhidosHCCont = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHCCont);
        }
        _item_1.setQtdRecolhidosHCCont(_tmpQtdRecolhidosHCCont);
        final Double _tmpQtdTrocados;
        if (_cursor.isNull(_cursorIndexOfQtdTrocados)) {
          _tmpQtdTrocados = null;
        } else {
          _tmpQtdTrocados = _cursor.getDouble(_cursorIndexOfQtdTrocados);
        }
        _item_1.setQtdTrocados(_tmpQtdTrocados);
        final Double _tmpQtdTransferidos;
        if (_cursor.isNull(_cursorIndexOfQtdTransferidos)) {
          _tmpQtdTransferidos = null;
        } else {
          _tmpQtdTransferidos = _cursor.getDouble(_cursorIndexOfQtdTransferidos);
        }
        _item_1.setQtdTransferidos(_tmpQtdTransferidos);
        final Double _tmpQtdComplementados;
        if (_cursor.isNull(_cursorIndexOfQtdComplementados)) {
          _tmpQtdComplementados = null;
        } else {
          _tmpQtdComplementados = _cursor.getDouble(_cursorIndexOfQtdComplementados);
        }
        _item_1.setQtdComplementados(_tmpQtdComplementados);
        final Double _tmpQtdDescarregados;
        if (_cursor.isNull(_cursorIndexOfQtdDescarregados)) {
          _tmpQtdDescarregados = null;
        } else {
          _tmpQtdDescarregados = _cursor.getDouble(_cursorIndexOfQtdDescarregados);
        }
        _item_1.setQtdDescarregados(_tmpQtdDescarregados);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Saldo> findAll(List<Integer> tipoItem, Long numeroViagem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Saldo where tipoItem IN (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")  AND numeroViagem = ");
    _stringBuilder.append("?");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 1 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : tipoItem) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 1 + _inputSize;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroViagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfQtdCarregadaCheios = _cursor.getColumnIndexOrThrow("qtdCarregadaCheios");
      final int _cursorIndexOfQtdCarregadaVazios = _cursor.getColumnIndexOrThrow("qtdCarregadaVazios");
      final int _cursorIndexOfQtdAtualCheios = _cursor.getColumnIndexOrThrow("qtdAtualCheios");
      final int _cursorIndexOfQtdAtualVazios = _cursor.getColumnIndexOrThrow("qtdAtualVazios");
      final int _cursorIndexOfQtdCheiosCont = _cursor.getColumnIndexOrThrow("qtdCheiosCont");
      final int _cursorIndexOfQtdVaziosCont = _cursor.getColumnIndexOrThrow("qtdVaziosCont");
      final int _cursorIndexOfQtdVendidos = _cursor.getColumnIndexOrThrow("qtdVendidos");
      final int _cursorIndexOfQtdAplicados = _cursor.getColumnIndexOrThrow("qtdAplicados");
      final int _cursorIndexOfQtdRecolhidos = _cursor.getColumnIndexOrThrow("qtdRecolhidos");
      final int _cursorIndexOfQtdAplicadosHC = _cursor.getColumnIndexOrThrow("qtdAplicadosHC");
      final int _cursorIndexOfQtdRecolhidosHC = _cursor.getColumnIndexOrThrow("qtdRecolhidosHC");
      final int _cursorIndexOfQtdAplicadosHCCont = _cursor.getColumnIndexOrThrow("qtdAplicadosHCCont");
      final int _cursorIndexOfQtdRecolhidosHCCont = _cursor.getColumnIndexOrThrow("qtdRecolhidosHCCont");
      final int _cursorIndexOfQtdTrocados = _cursor.getColumnIndexOrThrow("qtdTrocados");
      final int _cursorIndexOfQtdTransferidos = _cursor.getColumnIndexOrThrow("qtdTransferidos");
      final int _cursorIndexOfQtdComplementados = _cursor.getColumnIndexOrThrow("qtdComplementados");
      final int _cursorIndexOfQtdDescarregados = _cursor.getColumnIndexOrThrow("qtdDescarregados");
      final List<Saldo> _result = new ArrayList<Saldo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Saldo _item_1;
        _item_1 = new Saldo();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _item_1.setNumeroViagem(_tmpNumeroViagem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item_1.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item_1.setCapacidade(_tmpCapacidade);
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _item_1.setNomeItem(_tmpNomeItem);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item_1.setTipoItem(_tmpTipoItem);
        final String _tmpTipoPropriedade;
        _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
        _item_1.setTipoPropriedade(_tmpTipoPropriedade);
        final Double _tmpQtdCarregadaCheios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaCheios)) {
          _tmpQtdCarregadaCheios = null;
        } else {
          _tmpQtdCarregadaCheios = _cursor.getDouble(_cursorIndexOfQtdCarregadaCheios);
        }
        _item_1.setQtdCarregadaCheios(_tmpQtdCarregadaCheios);
        final Double _tmpQtdCarregadaVazios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaVazios)) {
          _tmpQtdCarregadaVazios = null;
        } else {
          _tmpQtdCarregadaVazios = _cursor.getDouble(_cursorIndexOfQtdCarregadaVazios);
        }
        _item_1.setQtdCarregadaVazios(_tmpQtdCarregadaVazios);
        final Double _tmpQtdAtualCheios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualCheios)) {
          _tmpQtdAtualCheios = null;
        } else {
          _tmpQtdAtualCheios = _cursor.getDouble(_cursorIndexOfQtdAtualCheios);
        }
        _item_1.setQtdAtualCheios(_tmpQtdAtualCheios);
        final Double _tmpQtdAtualVazios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualVazios)) {
          _tmpQtdAtualVazios = null;
        } else {
          _tmpQtdAtualVazios = _cursor.getDouble(_cursorIndexOfQtdAtualVazios);
        }
        _item_1.setQtdAtualVazios(_tmpQtdAtualVazios);
        final Double _tmpQtdCheiosCont;
        if (_cursor.isNull(_cursorIndexOfQtdCheiosCont)) {
          _tmpQtdCheiosCont = null;
        } else {
          _tmpQtdCheiosCont = _cursor.getDouble(_cursorIndexOfQtdCheiosCont);
        }
        _item_1.setQtdCheiosCont(_tmpQtdCheiosCont);
        final Double _tmpQtdVaziosCont;
        if (_cursor.isNull(_cursorIndexOfQtdVaziosCont)) {
          _tmpQtdVaziosCont = null;
        } else {
          _tmpQtdVaziosCont = _cursor.getDouble(_cursorIndexOfQtdVaziosCont);
        }
        _item_1.setQtdVaziosCont(_tmpQtdVaziosCont);
        final Double _tmpQtdVendidos;
        if (_cursor.isNull(_cursorIndexOfQtdVendidos)) {
          _tmpQtdVendidos = null;
        } else {
          _tmpQtdVendidos = _cursor.getDouble(_cursorIndexOfQtdVendidos);
        }
        _item_1.setQtdVendidos(_tmpQtdVendidos);
        final Double _tmpQtdAplicados;
        if (_cursor.isNull(_cursorIndexOfQtdAplicados)) {
          _tmpQtdAplicados = null;
        } else {
          _tmpQtdAplicados = _cursor.getDouble(_cursorIndexOfQtdAplicados);
        }
        _item_1.setQtdAplicados(_tmpQtdAplicados);
        final Double _tmpQtdRecolhidos;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidos)) {
          _tmpQtdRecolhidos = null;
        } else {
          _tmpQtdRecolhidos = _cursor.getDouble(_cursorIndexOfQtdRecolhidos);
        }
        _item_1.setQtdRecolhidos(_tmpQtdRecolhidos);
        final Double _tmpQtdAplicadosHC;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHC)) {
          _tmpQtdAplicadosHC = null;
        } else {
          _tmpQtdAplicadosHC = _cursor.getDouble(_cursorIndexOfQtdAplicadosHC);
        }
        _item_1.setQtdAplicadosHC(_tmpQtdAplicadosHC);
        final Double _tmpQtdRecolhidosHC;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHC)) {
          _tmpQtdRecolhidosHC = null;
        } else {
          _tmpQtdRecolhidosHC = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHC);
        }
        _item_1.setQtdRecolhidosHC(_tmpQtdRecolhidosHC);
        final Double _tmpQtdAplicadosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHCCont)) {
          _tmpQtdAplicadosHCCont = null;
        } else {
          _tmpQtdAplicadosHCCont = _cursor.getDouble(_cursorIndexOfQtdAplicadosHCCont);
        }
        _item_1.setQtdAplicadosHCCont(_tmpQtdAplicadosHCCont);
        final Double _tmpQtdRecolhidosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHCCont)) {
          _tmpQtdRecolhidosHCCont = null;
        } else {
          _tmpQtdRecolhidosHCCont = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHCCont);
        }
        _item_1.setQtdRecolhidosHCCont(_tmpQtdRecolhidosHCCont);
        final Double _tmpQtdTrocados;
        if (_cursor.isNull(_cursorIndexOfQtdTrocados)) {
          _tmpQtdTrocados = null;
        } else {
          _tmpQtdTrocados = _cursor.getDouble(_cursorIndexOfQtdTrocados);
        }
        _item_1.setQtdTrocados(_tmpQtdTrocados);
        final Double _tmpQtdTransferidos;
        if (_cursor.isNull(_cursorIndexOfQtdTransferidos)) {
          _tmpQtdTransferidos = null;
        } else {
          _tmpQtdTransferidos = _cursor.getDouble(_cursorIndexOfQtdTransferidos);
        }
        _item_1.setQtdTransferidos(_tmpQtdTransferidos);
        final Double _tmpQtdComplementados;
        if (_cursor.isNull(_cursorIndexOfQtdComplementados)) {
          _tmpQtdComplementados = null;
        } else {
          _tmpQtdComplementados = _cursor.getDouble(_cursorIndexOfQtdComplementados);
        }
        _item_1.setQtdComplementados(_tmpQtdComplementados);
        final Double _tmpQtdDescarregados;
        if (_cursor.isNull(_cursorIndexOfQtdDescarregados)) {
          _tmpQtdDescarregados = null;
        } else {
          _tmpQtdDescarregados = _cursor.getDouble(_cursorIndexOfQtdDescarregados);
        }
        _item_1.setQtdDescarregados(_tmpQtdDescarregados);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Saldo> saldoObc(Long cdItem, List<Integer> tipoItem, Long numeroViagem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT *   FROM saldo  JOIN item ON item.cdItem = saldo.cdItem AND item.capacidadeProduto = saldo.capacidade WHERE saldo.cdItem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", saldo.cdItem) AND Item.tipoItem in (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")    AND numeroViagem = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" GROUP BY saldo.cdItem, saldo.capacidade ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 2 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 2;
    for (Integer _item : tipoItem) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroViagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfQtdCarregadaCheios = _cursor.getColumnIndexOrThrow("qtdCarregadaCheios");
      final int _cursorIndexOfQtdCarregadaVazios = _cursor.getColumnIndexOrThrow("qtdCarregadaVazios");
      final int _cursorIndexOfQtdAtualCheios = _cursor.getColumnIndexOrThrow("qtdAtualCheios");
      final int _cursorIndexOfQtdAtualVazios = _cursor.getColumnIndexOrThrow("qtdAtualVazios");
      final int _cursorIndexOfQtdCheiosCont = _cursor.getColumnIndexOrThrow("qtdCheiosCont");
      final int _cursorIndexOfQtdVaziosCont = _cursor.getColumnIndexOrThrow("qtdVaziosCont");
      final int _cursorIndexOfQtdVendidos = _cursor.getColumnIndexOrThrow("qtdVendidos");
      final int _cursorIndexOfQtdAplicados = _cursor.getColumnIndexOrThrow("qtdAplicados");
      final int _cursorIndexOfQtdRecolhidos = _cursor.getColumnIndexOrThrow("qtdRecolhidos");
      final int _cursorIndexOfQtdAplicadosHC = _cursor.getColumnIndexOrThrow("qtdAplicadosHC");
      final int _cursorIndexOfQtdRecolhidosHC = _cursor.getColumnIndexOrThrow("qtdRecolhidosHC");
      final int _cursorIndexOfQtdAplicadosHCCont = _cursor.getColumnIndexOrThrow("qtdAplicadosHCCont");
      final int _cursorIndexOfQtdRecolhidosHCCont = _cursor.getColumnIndexOrThrow("qtdRecolhidosHCCont");
      final int _cursorIndexOfQtdTrocados = _cursor.getColumnIndexOrThrow("qtdTrocados");
      final int _cursorIndexOfQtdTransferidos = _cursor.getColumnIndexOrThrow("qtdTransferidos");
      final int _cursorIndexOfQtdComplementados = _cursor.getColumnIndexOrThrow("qtdComplementados");
      final int _cursorIndexOfQtdDescarregados = _cursor.getColumnIndexOrThrow("qtdDescarregados");
      final int _cursorIndexOfCdItem_1 = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfTipoPropriedade_1 = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfTipoItem_1 = _cursor.getColumnIndexOrThrow("tipoItem");
      final List<Saldo> _result = new ArrayList<Saldo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Saldo _item_1;
        _item_1 = new Saldo();
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _item_1.setNumeroViagem(_tmpNumeroViagem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item_1.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item_1.setCapacidade(_tmpCapacidade);
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _item_1.setNomeItem(_tmpNomeItem);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item_1.setTipoItem(_tmpTipoItem);
        final String _tmpTipoPropriedade;
        _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
        _item_1.setTipoPropriedade(_tmpTipoPropriedade);
        final Double _tmpQtdCarregadaCheios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaCheios)) {
          _tmpQtdCarregadaCheios = null;
        } else {
          _tmpQtdCarregadaCheios = _cursor.getDouble(_cursorIndexOfQtdCarregadaCheios);
        }
        _item_1.setQtdCarregadaCheios(_tmpQtdCarregadaCheios);
        final Double _tmpQtdCarregadaVazios;
        if (_cursor.isNull(_cursorIndexOfQtdCarregadaVazios)) {
          _tmpQtdCarregadaVazios = null;
        } else {
          _tmpQtdCarregadaVazios = _cursor.getDouble(_cursorIndexOfQtdCarregadaVazios);
        }
        _item_1.setQtdCarregadaVazios(_tmpQtdCarregadaVazios);
        final Double _tmpQtdAtualCheios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualCheios)) {
          _tmpQtdAtualCheios = null;
        } else {
          _tmpQtdAtualCheios = _cursor.getDouble(_cursorIndexOfQtdAtualCheios);
        }
        _item_1.setQtdAtualCheios(_tmpQtdAtualCheios);
        final Double _tmpQtdAtualVazios;
        if (_cursor.isNull(_cursorIndexOfQtdAtualVazios)) {
          _tmpQtdAtualVazios = null;
        } else {
          _tmpQtdAtualVazios = _cursor.getDouble(_cursorIndexOfQtdAtualVazios);
        }
        _item_1.setQtdAtualVazios(_tmpQtdAtualVazios);
        final Double _tmpQtdCheiosCont;
        if (_cursor.isNull(_cursorIndexOfQtdCheiosCont)) {
          _tmpQtdCheiosCont = null;
        } else {
          _tmpQtdCheiosCont = _cursor.getDouble(_cursorIndexOfQtdCheiosCont);
        }
        _item_1.setQtdCheiosCont(_tmpQtdCheiosCont);
        final Double _tmpQtdVaziosCont;
        if (_cursor.isNull(_cursorIndexOfQtdVaziosCont)) {
          _tmpQtdVaziosCont = null;
        } else {
          _tmpQtdVaziosCont = _cursor.getDouble(_cursorIndexOfQtdVaziosCont);
        }
        _item_1.setQtdVaziosCont(_tmpQtdVaziosCont);
        final Double _tmpQtdVendidos;
        if (_cursor.isNull(_cursorIndexOfQtdVendidos)) {
          _tmpQtdVendidos = null;
        } else {
          _tmpQtdVendidos = _cursor.getDouble(_cursorIndexOfQtdVendidos);
        }
        _item_1.setQtdVendidos(_tmpQtdVendidos);
        final Double _tmpQtdAplicados;
        if (_cursor.isNull(_cursorIndexOfQtdAplicados)) {
          _tmpQtdAplicados = null;
        } else {
          _tmpQtdAplicados = _cursor.getDouble(_cursorIndexOfQtdAplicados);
        }
        _item_1.setQtdAplicados(_tmpQtdAplicados);
        final Double _tmpQtdRecolhidos;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidos)) {
          _tmpQtdRecolhidos = null;
        } else {
          _tmpQtdRecolhidos = _cursor.getDouble(_cursorIndexOfQtdRecolhidos);
        }
        _item_1.setQtdRecolhidos(_tmpQtdRecolhidos);
        final Double _tmpQtdAplicadosHC;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHC)) {
          _tmpQtdAplicadosHC = null;
        } else {
          _tmpQtdAplicadosHC = _cursor.getDouble(_cursorIndexOfQtdAplicadosHC);
        }
        _item_1.setQtdAplicadosHC(_tmpQtdAplicadosHC);
        final Double _tmpQtdRecolhidosHC;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHC)) {
          _tmpQtdRecolhidosHC = null;
        } else {
          _tmpQtdRecolhidosHC = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHC);
        }
        _item_1.setQtdRecolhidosHC(_tmpQtdRecolhidosHC);
        final Double _tmpQtdAplicadosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdAplicadosHCCont)) {
          _tmpQtdAplicadosHCCont = null;
        } else {
          _tmpQtdAplicadosHCCont = _cursor.getDouble(_cursorIndexOfQtdAplicadosHCCont);
        }
        _item_1.setQtdAplicadosHCCont(_tmpQtdAplicadosHCCont);
        final Double _tmpQtdRecolhidosHCCont;
        if (_cursor.isNull(_cursorIndexOfQtdRecolhidosHCCont)) {
          _tmpQtdRecolhidosHCCont = null;
        } else {
          _tmpQtdRecolhidosHCCont = _cursor.getDouble(_cursorIndexOfQtdRecolhidosHCCont);
        }
        _item_1.setQtdRecolhidosHCCont(_tmpQtdRecolhidosHCCont);
        final Double _tmpQtdTrocados;
        if (_cursor.isNull(_cursorIndexOfQtdTrocados)) {
          _tmpQtdTrocados = null;
        } else {
          _tmpQtdTrocados = _cursor.getDouble(_cursorIndexOfQtdTrocados);
        }
        _item_1.setQtdTrocados(_tmpQtdTrocados);
        final Double _tmpQtdTransferidos;
        if (_cursor.isNull(_cursorIndexOfQtdTransferidos)) {
          _tmpQtdTransferidos = null;
        } else {
          _tmpQtdTransferidos = _cursor.getDouble(_cursorIndexOfQtdTransferidos);
        }
        _item_1.setQtdTransferidos(_tmpQtdTransferidos);
        final Double _tmpQtdComplementados;
        if (_cursor.isNull(_cursorIndexOfQtdComplementados)) {
          _tmpQtdComplementados = null;
        } else {
          _tmpQtdComplementados = _cursor.getDouble(_cursorIndexOfQtdComplementados);
        }
        _item_1.setQtdComplementados(_tmpQtdComplementados);
        final Double _tmpQtdDescarregados;
        if (_cursor.isNull(_cursorIndexOfQtdDescarregados)) {
          _tmpQtdDescarregados = null;
        } else {
          _tmpQtdDescarregados = _cursor.getDouble(_cursorIndexOfQtdDescarregados);
        }
        _item_1.setQtdDescarregados(_tmpQtdDescarregados);
        final Long _tmpCdItem_1;
        if (_cursor.isNull(_cursorIndexOfCdItem_1)) {
          _tmpCdItem_1 = null;
        } else {
          _tmpCdItem_1 = _cursor.getLong(_cursorIndexOfCdItem_1);
        }
        _item_1.setCdItem(_tmpCdItem_1);
        final String _tmpTipoPropriedade_1;
        _tmpTipoPropriedade_1 = _cursor.getString(_cursorIndexOfTipoPropriedade_1);
        _item_1.setTipoPropriedade(_tmpTipoPropriedade_1);
        final Integer _tmpTipoItem_1;
        if (_cursor.isNull(_cursorIndexOfTipoItem_1)) {
          _tmpTipoItem_1 = null;
        } else {
          _tmpTipoItem_1 = _cursor.getInt(_cursorIndexOfTipoItem_1);
        }
        _item_1.setTipoItem(_tmpTipoItem_1);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
