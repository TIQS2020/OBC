package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Abastecimento;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class AbastecimentoDao_Impl implements AbastecimentoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAbastecimento;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAbastecimento;

  public AbastecimentoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAbastecimento = new EntityInsertionAdapter<Abastecimento>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Abastecimento`(`codigo`,`numWM`,`cdCustomer`,`numeroSerieTanque`,`capacidadeKG`,`capacidadePol`,`fatorConversao`,`pesoAntes`,`pesoDepois`,`nivelAntes`,`nivelDepois`,`totalDescarga`,`totalCalulado`,`totalNfe`,`divergente`,`tipoCalculo`,`idNota`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Abastecimento value) {
        if (value.getCodigo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCodigo());
        }
        if (value.getNumWM() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getNumWM());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCdCustomer());
        }
        if (value.getNumeroSerieTanque() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumeroSerieTanque());
        }
        if (value.getCapacidadeKG() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getCapacidadeKG());
        }
        if (value.getCapacidadePol() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getCapacidadePol());
        }
        if (value.getFatorConversao() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getFatorConversao());
        }
        if (value.getPesoAntes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getPesoAntes());
        }
        if (value.getPesoDepois() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getPesoDepois());
        }
        if (value.getNivelAntes() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getNivelAntes());
        }
        if (value.getNivelDepois() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getNivelDepois());
        }
        if (value.getTotalDescarga() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindDouble(12, value.getTotalDescarga());
        }
        if (value.getTotalCalulado() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindDouble(13, value.getTotalCalulado());
        }
        if (value.getTotalNfe() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindDouble(14, value.getTotalNfe());
        }
        if (value.getDivergente() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getDivergente());
        }
        if (value.getTipoCalculo() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindLong(16, value.getTipoCalculo());
        }
        if (value.getIdNota() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.getIdNota());
        }
      }
    };
    this.__deletionAdapterOfAbastecimento = new EntityDeletionOrUpdateAdapter<Abastecimento>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Abastecimento` WHERE `codigo` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Abastecimento value) {
        if (value.getCodigo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCodigo());
        }
      }
    };
  }

  @Override
  public void insert(Abastecimento abastecimento) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAbastecimento.insert(abastecimento);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Abastecimento abastecimento) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAbastecimento.handle(abastecimento);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Abastecimento> abastecimentos) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAbastecimento.handleMultiple(abastecimentos);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Abastecimento> getAll() {
    final String _sql = "SELECT * FROM Abastecimento";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfNumWM = _cursor.getColumnIndexOrThrow("numWM");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfNumeroSerieTanque = _cursor.getColumnIndexOrThrow("numeroSerieTanque");
      final int _cursorIndexOfCapacidadeKG = _cursor.getColumnIndexOrThrow("capacidadeKG");
      final int _cursorIndexOfCapacidadePol = _cursor.getColumnIndexOrThrow("capacidadePol");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final int _cursorIndexOfPesoAntes = _cursor.getColumnIndexOrThrow("pesoAntes");
      final int _cursorIndexOfPesoDepois = _cursor.getColumnIndexOrThrow("pesoDepois");
      final int _cursorIndexOfNivelAntes = _cursor.getColumnIndexOrThrow("nivelAntes");
      final int _cursorIndexOfNivelDepois = _cursor.getColumnIndexOrThrow("nivelDepois");
      final int _cursorIndexOfTotalDescarga = _cursor.getColumnIndexOrThrow("totalDescarga");
      final int _cursorIndexOfTotalCalulado = _cursor.getColumnIndexOrThrow("totalCalulado");
      final int _cursorIndexOfTotalNfe = _cursor.getColumnIndexOrThrow("totalNfe");
      final int _cursorIndexOfDivergente = _cursor.getColumnIndexOrThrow("divergente");
      final int _cursorIndexOfTipoCalculo = _cursor.getColumnIndexOrThrow("tipoCalculo");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final List<Abastecimento> _result = new ArrayList<Abastecimento>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Abastecimento _item;
        _item = new Abastecimento();
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final Long _tmpNumWM;
        if (_cursor.isNull(_cursorIndexOfNumWM)) {
          _tmpNumWM = null;
        } else {
          _tmpNumWM = _cursor.getLong(_cursorIndexOfNumWM);
        }
        _item.setNumWM(_tmpNumWM);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpNumeroSerieTanque;
        _tmpNumeroSerieTanque = _cursor.getString(_cursorIndexOfNumeroSerieTanque);
        _item.setNumeroSerieTanque(_tmpNumeroSerieTanque);
        final Double _tmpCapacidadeKG;
        if (_cursor.isNull(_cursorIndexOfCapacidadeKG)) {
          _tmpCapacidadeKG = null;
        } else {
          _tmpCapacidadeKG = _cursor.getDouble(_cursorIndexOfCapacidadeKG);
        }
        _item.setCapacidadeKG(_tmpCapacidadeKG);
        final Double _tmpCapacidadePol;
        if (_cursor.isNull(_cursorIndexOfCapacidadePol)) {
          _tmpCapacidadePol = null;
        } else {
          _tmpCapacidadePol = _cursor.getDouble(_cursorIndexOfCapacidadePol);
        }
        _item.setCapacidadePol(_tmpCapacidadePol);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _item.setFatorConversao(_tmpFatorConversao);
        final Double _tmpPesoAntes;
        if (_cursor.isNull(_cursorIndexOfPesoAntes)) {
          _tmpPesoAntes = null;
        } else {
          _tmpPesoAntes = _cursor.getDouble(_cursorIndexOfPesoAntes);
        }
        _item.setPesoAntes(_tmpPesoAntes);
        final Double _tmpPesoDepois;
        if (_cursor.isNull(_cursorIndexOfPesoDepois)) {
          _tmpPesoDepois = null;
        } else {
          _tmpPesoDepois = _cursor.getDouble(_cursorIndexOfPesoDepois);
        }
        _item.setPesoDepois(_tmpPesoDepois);
        final Double _tmpNivelAntes;
        if (_cursor.isNull(_cursorIndexOfNivelAntes)) {
          _tmpNivelAntes = null;
        } else {
          _tmpNivelAntes = _cursor.getDouble(_cursorIndexOfNivelAntes);
        }
        _item.setNivelAntes(_tmpNivelAntes);
        final Double _tmpNivelDepois;
        if (_cursor.isNull(_cursorIndexOfNivelDepois)) {
          _tmpNivelDepois = null;
        } else {
          _tmpNivelDepois = _cursor.getDouble(_cursorIndexOfNivelDepois);
        }
        _item.setNivelDepois(_tmpNivelDepois);
        final Double _tmpTotalDescarga;
        if (_cursor.isNull(_cursorIndexOfTotalDescarga)) {
          _tmpTotalDescarga = null;
        } else {
          _tmpTotalDescarga = _cursor.getDouble(_cursorIndexOfTotalDescarga);
        }
        _item.setTotalDescarga(_tmpTotalDescarga);
        final Double _tmpTotalCalulado;
        if (_cursor.isNull(_cursorIndexOfTotalCalulado)) {
          _tmpTotalCalulado = null;
        } else {
          _tmpTotalCalulado = _cursor.getDouble(_cursorIndexOfTotalCalulado);
        }
        _item.setTotalCalulado(_tmpTotalCalulado);
        final Double _tmpTotalNfe;
        if (_cursor.isNull(_cursorIndexOfTotalNfe)) {
          _tmpTotalNfe = null;
        } else {
          _tmpTotalNfe = _cursor.getDouble(_cursorIndexOfTotalNfe);
        }
        _item.setTotalNfe(_tmpTotalNfe);
        final String _tmpDivergente;
        _tmpDivergente = _cursor.getString(_cursorIndexOfDivergente);
        _item.setDivergente(_tmpDivergente);
        final Integer _tmpTipoCalculo;
        if (_cursor.isNull(_cursorIndexOfTipoCalculo)) {
          _tmpTipoCalculo = null;
        } else {
          _tmpTipoCalculo = _cursor.getInt(_cursorIndexOfTipoCalculo);
        }
        _item.setTipoCalculo(_tmpTipoCalculo);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Abastecimento> findById(Long codigo) {
    final String _sql = "SELECT * FROM Abastecimento WHERE codigo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (codigo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, codigo);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfNumWM = _cursor.getColumnIndexOrThrow("numWM");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfNumeroSerieTanque = _cursor.getColumnIndexOrThrow("numeroSerieTanque");
      final int _cursorIndexOfCapacidadeKG = _cursor.getColumnIndexOrThrow("capacidadeKG");
      final int _cursorIndexOfCapacidadePol = _cursor.getColumnIndexOrThrow("capacidadePol");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final int _cursorIndexOfPesoAntes = _cursor.getColumnIndexOrThrow("pesoAntes");
      final int _cursorIndexOfPesoDepois = _cursor.getColumnIndexOrThrow("pesoDepois");
      final int _cursorIndexOfNivelAntes = _cursor.getColumnIndexOrThrow("nivelAntes");
      final int _cursorIndexOfNivelDepois = _cursor.getColumnIndexOrThrow("nivelDepois");
      final int _cursorIndexOfTotalDescarga = _cursor.getColumnIndexOrThrow("totalDescarga");
      final int _cursorIndexOfTotalCalulado = _cursor.getColumnIndexOrThrow("totalCalulado");
      final int _cursorIndexOfTotalNfe = _cursor.getColumnIndexOrThrow("totalNfe");
      final int _cursorIndexOfDivergente = _cursor.getColumnIndexOrThrow("divergente");
      final int _cursorIndexOfTipoCalculo = _cursor.getColumnIndexOrThrow("tipoCalculo");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final List<Abastecimento> _result = new ArrayList<Abastecimento>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Abastecimento _item;
        _item = new Abastecimento();
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final Long _tmpNumWM;
        if (_cursor.isNull(_cursorIndexOfNumWM)) {
          _tmpNumWM = null;
        } else {
          _tmpNumWM = _cursor.getLong(_cursorIndexOfNumWM);
        }
        _item.setNumWM(_tmpNumWM);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpNumeroSerieTanque;
        _tmpNumeroSerieTanque = _cursor.getString(_cursorIndexOfNumeroSerieTanque);
        _item.setNumeroSerieTanque(_tmpNumeroSerieTanque);
        final Double _tmpCapacidadeKG;
        if (_cursor.isNull(_cursorIndexOfCapacidadeKG)) {
          _tmpCapacidadeKG = null;
        } else {
          _tmpCapacidadeKG = _cursor.getDouble(_cursorIndexOfCapacidadeKG);
        }
        _item.setCapacidadeKG(_tmpCapacidadeKG);
        final Double _tmpCapacidadePol;
        if (_cursor.isNull(_cursorIndexOfCapacidadePol)) {
          _tmpCapacidadePol = null;
        } else {
          _tmpCapacidadePol = _cursor.getDouble(_cursorIndexOfCapacidadePol);
        }
        _item.setCapacidadePol(_tmpCapacidadePol);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _item.setFatorConversao(_tmpFatorConversao);
        final Double _tmpPesoAntes;
        if (_cursor.isNull(_cursorIndexOfPesoAntes)) {
          _tmpPesoAntes = null;
        } else {
          _tmpPesoAntes = _cursor.getDouble(_cursorIndexOfPesoAntes);
        }
        _item.setPesoAntes(_tmpPesoAntes);
        final Double _tmpPesoDepois;
        if (_cursor.isNull(_cursorIndexOfPesoDepois)) {
          _tmpPesoDepois = null;
        } else {
          _tmpPesoDepois = _cursor.getDouble(_cursorIndexOfPesoDepois);
        }
        _item.setPesoDepois(_tmpPesoDepois);
        final Double _tmpNivelAntes;
        if (_cursor.isNull(_cursorIndexOfNivelAntes)) {
          _tmpNivelAntes = null;
        } else {
          _tmpNivelAntes = _cursor.getDouble(_cursorIndexOfNivelAntes);
        }
        _item.setNivelAntes(_tmpNivelAntes);
        final Double _tmpNivelDepois;
        if (_cursor.isNull(_cursorIndexOfNivelDepois)) {
          _tmpNivelDepois = null;
        } else {
          _tmpNivelDepois = _cursor.getDouble(_cursorIndexOfNivelDepois);
        }
        _item.setNivelDepois(_tmpNivelDepois);
        final Double _tmpTotalDescarga;
        if (_cursor.isNull(_cursorIndexOfTotalDescarga)) {
          _tmpTotalDescarga = null;
        } else {
          _tmpTotalDescarga = _cursor.getDouble(_cursorIndexOfTotalDescarga);
        }
        _item.setTotalDescarga(_tmpTotalDescarga);
        final Double _tmpTotalCalulado;
        if (_cursor.isNull(_cursorIndexOfTotalCalulado)) {
          _tmpTotalCalulado = null;
        } else {
          _tmpTotalCalulado = _cursor.getDouble(_cursorIndexOfTotalCalulado);
        }
        _item.setTotalCalulado(_tmpTotalCalulado);
        final Double _tmpTotalNfe;
        if (_cursor.isNull(_cursorIndexOfTotalNfe)) {
          _tmpTotalNfe = null;
        } else {
          _tmpTotalNfe = _cursor.getDouble(_cursorIndexOfTotalNfe);
        }
        _item.setTotalNfe(_tmpTotalNfe);
        final String _tmpDivergente;
        _tmpDivergente = _cursor.getString(_cursorIndexOfDivergente);
        _item.setDivergente(_tmpDivergente);
        final Integer _tmpTipoCalculo;
        if (_cursor.isNull(_cursorIndexOfTipoCalculo)) {
          _tmpTipoCalculo = null;
        } else {
          _tmpTipoCalculo = _cursor.getInt(_cursorIndexOfTipoCalculo);
        }
        _item.setTipoCalculo(_tmpTipoCalculo);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Abastecimento> find(Long cdCustomer) {
    final String _sql = "SELECT * FROM Abastecimento WHERE cdCustomer = ? AND idNota IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfNumWM = _cursor.getColumnIndexOrThrow("numWM");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfNumeroSerieTanque = _cursor.getColumnIndexOrThrow("numeroSerieTanque");
      final int _cursorIndexOfCapacidadeKG = _cursor.getColumnIndexOrThrow("capacidadeKG");
      final int _cursorIndexOfCapacidadePol = _cursor.getColumnIndexOrThrow("capacidadePol");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final int _cursorIndexOfPesoAntes = _cursor.getColumnIndexOrThrow("pesoAntes");
      final int _cursorIndexOfPesoDepois = _cursor.getColumnIndexOrThrow("pesoDepois");
      final int _cursorIndexOfNivelAntes = _cursor.getColumnIndexOrThrow("nivelAntes");
      final int _cursorIndexOfNivelDepois = _cursor.getColumnIndexOrThrow("nivelDepois");
      final int _cursorIndexOfTotalDescarga = _cursor.getColumnIndexOrThrow("totalDescarga");
      final int _cursorIndexOfTotalCalulado = _cursor.getColumnIndexOrThrow("totalCalulado");
      final int _cursorIndexOfTotalNfe = _cursor.getColumnIndexOrThrow("totalNfe");
      final int _cursorIndexOfDivergente = _cursor.getColumnIndexOrThrow("divergente");
      final int _cursorIndexOfTipoCalculo = _cursor.getColumnIndexOrThrow("tipoCalculo");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final List<Abastecimento> _result = new ArrayList<Abastecimento>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Abastecimento _item;
        _item = new Abastecimento();
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final Long _tmpNumWM;
        if (_cursor.isNull(_cursorIndexOfNumWM)) {
          _tmpNumWM = null;
        } else {
          _tmpNumWM = _cursor.getLong(_cursorIndexOfNumWM);
        }
        _item.setNumWM(_tmpNumWM);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpNumeroSerieTanque;
        _tmpNumeroSerieTanque = _cursor.getString(_cursorIndexOfNumeroSerieTanque);
        _item.setNumeroSerieTanque(_tmpNumeroSerieTanque);
        final Double _tmpCapacidadeKG;
        if (_cursor.isNull(_cursorIndexOfCapacidadeKG)) {
          _tmpCapacidadeKG = null;
        } else {
          _tmpCapacidadeKG = _cursor.getDouble(_cursorIndexOfCapacidadeKG);
        }
        _item.setCapacidadeKG(_tmpCapacidadeKG);
        final Double _tmpCapacidadePol;
        if (_cursor.isNull(_cursorIndexOfCapacidadePol)) {
          _tmpCapacidadePol = null;
        } else {
          _tmpCapacidadePol = _cursor.getDouble(_cursorIndexOfCapacidadePol);
        }
        _item.setCapacidadePol(_tmpCapacidadePol);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _item.setFatorConversao(_tmpFatorConversao);
        final Double _tmpPesoAntes;
        if (_cursor.isNull(_cursorIndexOfPesoAntes)) {
          _tmpPesoAntes = null;
        } else {
          _tmpPesoAntes = _cursor.getDouble(_cursorIndexOfPesoAntes);
        }
        _item.setPesoAntes(_tmpPesoAntes);
        final Double _tmpPesoDepois;
        if (_cursor.isNull(_cursorIndexOfPesoDepois)) {
          _tmpPesoDepois = null;
        } else {
          _tmpPesoDepois = _cursor.getDouble(_cursorIndexOfPesoDepois);
        }
        _item.setPesoDepois(_tmpPesoDepois);
        final Double _tmpNivelAntes;
        if (_cursor.isNull(_cursorIndexOfNivelAntes)) {
          _tmpNivelAntes = null;
        } else {
          _tmpNivelAntes = _cursor.getDouble(_cursorIndexOfNivelAntes);
        }
        _item.setNivelAntes(_tmpNivelAntes);
        final Double _tmpNivelDepois;
        if (_cursor.isNull(_cursorIndexOfNivelDepois)) {
          _tmpNivelDepois = null;
        } else {
          _tmpNivelDepois = _cursor.getDouble(_cursorIndexOfNivelDepois);
        }
        _item.setNivelDepois(_tmpNivelDepois);
        final Double _tmpTotalDescarga;
        if (_cursor.isNull(_cursorIndexOfTotalDescarga)) {
          _tmpTotalDescarga = null;
        } else {
          _tmpTotalDescarga = _cursor.getDouble(_cursorIndexOfTotalDescarga);
        }
        _item.setTotalDescarga(_tmpTotalDescarga);
        final Double _tmpTotalCalulado;
        if (_cursor.isNull(_cursorIndexOfTotalCalulado)) {
          _tmpTotalCalulado = null;
        } else {
          _tmpTotalCalulado = _cursor.getDouble(_cursorIndexOfTotalCalulado);
        }
        _item.setTotalCalulado(_tmpTotalCalulado);
        final Double _tmpTotalNfe;
        if (_cursor.isNull(_cursorIndexOfTotalNfe)) {
          _tmpTotalNfe = null;
        } else {
          _tmpTotalNfe = _cursor.getDouble(_cursorIndexOfTotalNfe);
        }
        _item.setTotalNfe(_tmpTotalNfe);
        final String _tmpDivergente;
        _tmpDivergente = _cursor.getString(_cursorIndexOfDivergente);
        _item.setDivergente(_tmpDivergente);
        final Integer _tmpTipoCalculo;
        if (_cursor.isNull(_cursorIndexOfTipoCalculo)) {
          _tmpTipoCalculo = null;
        } else {
          _tmpTipoCalculo = _cursor.getInt(_cursorIndexOfTipoCalculo);
        }
        _item.setTipoCalculo(_tmpTipoCalculo);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Abastecimento> find(Long cdCustomer, Long idNota) {
    final String _sql = "SELECT * FROM Abastecimento WHERE cdCustomer = ? AND idNota = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2;
    if (idNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCodigo = _cursor.getColumnIndexOrThrow("codigo");
      final int _cursorIndexOfNumWM = _cursor.getColumnIndexOrThrow("numWM");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfNumeroSerieTanque = _cursor.getColumnIndexOrThrow("numeroSerieTanque");
      final int _cursorIndexOfCapacidadeKG = _cursor.getColumnIndexOrThrow("capacidadeKG");
      final int _cursorIndexOfCapacidadePol = _cursor.getColumnIndexOrThrow("capacidadePol");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final int _cursorIndexOfPesoAntes = _cursor.getColumnIndexOrThrow("pesoAntes");
      final int _cursorIndexOfPesoDepois = _cursor.getColumnIndexOrThrow("pesoDepois");
      final int _cursorIndexOfNivelAntes = _cursor.getColumnIndexOrThrow("nivelAntes");
      final int _cursorIndexOfNivelDepois = _cursor.getColumnIndexOrThrow("nivelDepois");
      final int _cursorIndexOfTotalDescarga = _cursor.getColumnIndexOrThrow("totalDescarga");
      final int _cursorIndexOfTotalCalulado = _cursor.getColumnIndexOrThrow("totalCalulado");
      final int _cursorIndexOfTotalNfe = _cursor.getColumnIndexOrThrow("totalNfe");
      final int _cursorIndexOfDivergente = _cursor.getColumnIndexOrThrow("divergente");
      final int _cursorIndexOfTipoCalculo = _cursor.getColumnIndexOrThrow("tipoCalculo");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final List<Abastecimento> _result = new ArrayList<Abastecimento>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Abastecimento _item;
        _item = new Abastecimento();
        final Integer _tmpCodigo;
        if (_cursor.isNull(_cursorIndexOfCodigo)) {
          _tmpCodigo = null;
        } else {
          _tmpCodigo = _cursor.getInt(_cursorIndexOfCodigo);
        }
        _item.setCodigo(_tmpCodigo);
        final Long _tmpNumWM;
        if (_cursor.isNull(_cursorIndexOfNumWM)) {
          _tmpNumWM = null;
        } else {
          _tmpNumWM = _cursor.getLong(_cursorIndexOfNumWM);
        }
        _item.setNumWM(_tmpNumWM);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpNumeroSerieTanque;
        _tmpNumeroSerieTanque = _cursor.getString(_cursorIndexOfNumeroSerieTanque);
        _item.setNumeroSerieTanque(_tmpNumeroSerieTanque);
        final Double _tmpCapacidadeKG;
        if (_cursor.isNull(_cursorIndexOfCapacidadeKG)) {
          _tmpCapacidadeKG = null;
        } else {
          _tmpCapacidadeKG = _cursor.getDouble(_cursorIndexOfCapacidadeKG);
        }
        _item.setCapacidadeKG(_tmpCapacidadeKG);
        final Double _tmpCapacidadePol;
        if (_cursor.isNull(_cursorIndexOfCapacidadePol)) {
          _tmpCapacidadePol = null;
        } else {
          _tmpCapacidadePol = _cursor.getDouble(_cursorIndexOfCapacidadePol);
        }
        _item.setCapacidadePol(_tmpCapacidadePol);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _item.setFatorConversao(_tmpFatorConversao);
        final Double _tmpPesoAntes;
        if (_cursor.isNull(_cursorIndexOfPesoAntes)) {
          _tmpPesoAntes = null;
        } else {
          _tmpPesoAntes = _cursor.getDouble(_cursorIndexOfPesoAntes);
        }
        _item.setPesoAntes(_tmpPesoAntes);
        final Double _tmpPesoDepois;
        if (_cursor.isNull(_cursorIndexOfPesoDepois)) {
          _tmpPesoDepois = null;
        } else {
          _tmpPesoDepois = _cursor.getDouble(_cursorIndexOfPesoDepois);
        }
        _item.setPesoDepois(_tmpPesoDepois);
        final Double _tmpNivelAntes;
        if (_cursor.isNull(_cursorIndexOfNivelAntes)) {
          _tmpNivelAntes = null;
        } else {
          _tmpNivelAntes = _cursor.getDouble(_cursorIndexOfNivelAntes);
        }
        _item.setNivelAntes(_tmpNivelAntes);
        final Double _tmpNivelDepois;
        if (_cursor.isNull(_cursorIndexOfNivelDepois)) {
          _tmpNivelDepois = null;
        } else {
          _tmpNivelDepois = _cursor.getDouble(_cursorIndexOfNivelDepois);
        }
        _item.setNivelDepois(_tmpNivelDepois);
        final Double _tmpTotalDescarga;
        if (_cursor.isNull(_cursorIndexOfTotalDescarga)) {
          _tmpTotalDescarga = null;
        } else {
          _tmpTotalDescarga = _cursor.getDouble(_cursorIndexOfTotalDescarga);
        }
        _item.setTotalDescarga(_tmpTotalDescarga);
        final Double _tmpTotalCalulado;
        if (_cursor.isNull(_cursorIndexOfTotalCalulado)) {
          _tmpTotalCalulado = null;
        } else {
          _tmpTotalCalulado = _cursor.getDouble(_cursorIndexOfTotalCalulado);
        }
        _item.setTotalCalulado(_tmpTotalCalulado);
        final Double _tmpTotalNfe;
        if (_cursor.isNull(_cursorIndexOfTotalNfe)) {
          _tmpTotalNfe = null;
        } else {
          _tmpTotalNfe = _cursor.getDouble(_cursorIndexOfTotalNfe);
        }
        _item.setTotalNfe(_tmpTotalNfe);
        final String _tmpDivergente;
        _tmpDivergente = _cursor.getString(_cursorIndexOfDivergente);
        _item.setDivergente(_tmpDivergente);
        final Integer _tmpTipoCalculo;
        if (_cursor.isNull(_cursorIndexOfTipoCalculo)) {
          _tmpTipoCalculo = null;
        } else {
          _tmpTipoCalculo = _cursor.getInt(_cursorIndexOfTipoCalculo);
        }
        _item.setTipoCalculo(_tmpTipoCalculo);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
