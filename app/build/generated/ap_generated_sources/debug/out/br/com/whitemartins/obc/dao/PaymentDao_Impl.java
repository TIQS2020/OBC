package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Payment;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class PaymentDao_Impl implements PaymentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPayment;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfPayment;

  public PaymentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPayment = new EntityInsertionAdapter<Payment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Payment`(`id`,`idNota`,`tipoIntegracao`,`cnpj`,`numeroAutorizacao`,`valor`,`credenciadora`,`bandeira`,`nomeBandeira`,`modalidade`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Payment value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIdNota() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIdNota());
        }
        if (value.getTipoIntegracao() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getTipoIntegracao());
        }
        if (value.getCnpj() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCnpj());
        }
        if (value.getNumeroAutorizacao() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNumeroAutorizacao());
        }
        if (value.getValor() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getValor());
        }
        if (value.getCredenciadora() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCredenciadora());
        }
        if (value.getBandeira() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBandeira());
        }
        if (value.getNomeBandeira() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getNomeBandeira());
        }
        if (value.getModalidade() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getModalidade());
        }
      }
    };
    this.__deletionAdapterOfPayment = new EntityDeletionOrUpdateAdapter<Payment>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Payment` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Payment value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
  }

  @Override
  public void insert(Payment payment) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPayment.insert(payment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Payment payment) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPayment.handle(payment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Payment> payments) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPayment.handleMultiple(payments);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Payment> getAll() {
    final String _sql = "SELECT * FROM Payment";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfTipoIntegracao = _cursor.getColumnIndexOrThrow("tipoIntegracao");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfNumeroAutorizacao = _cursor.getColumnIndexOrThrow("numeroAutorizacao");
      final int _cursorIndexOfValor = _cursor.getColumnIndexOrThrow("valor");
      final int _cursorIndexOfCredenciadora = _cursor.getColumnIndexOrThrow("credenciadora");
      final int _cursorIndexOfBandeira = _cursor.getColumnIndexOrThrow("bandeira");
      final int _cursorIndexOfNomeBandeira = _cursor.getColumnIndexOrThrow("nomeBandeira");
      final int _cursorIndexOfModalidade = _cursor.getColumnIndexOrThrow("modalidade");
      final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payment _item;
        _item = new Payment();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Integer _tmpTipoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoIntegracao)) {
          _tmpTipoIntegracao = null;
        } else {
          _tmpTipoIntegracao = _cursor.getInt(_cursorIndexOfTipoIntegracao);
        }
        _item.setTipoIntegracao(_tmpTipoIntegracao);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _item.setCnpj(_tmpCnpj);
        final String _tmpNumeroAutorizacao;
        _tmpNumeroAutorizacao = _cursor.getString(_cursorIndexOfNumeroAutorizacao);
        _item.setNumeroAutorizacao(_tmpNumeroAutorizacao);
        final Double _tmpValor;
        if (_cursor.isNull(_cursorIndexOfValor)) {
          _tmpValor = null;
        } else {
          _tmpValor = _cursor.getDouble(_cursorIndexOfValor);
        }
        _item.setValor(_tmpValor);
        final String _tmpCredenciadora;
        _tmpCredenciadora = _cursor.getString(_cursorIndexOfCredenciadora);
        _item.setCredenciadora(_tmpCredenciadora);
        final String _tmpBandeira;
        _tmpBandeira = _cursor.getString(_cursorIndexOfBandeira);
        _item.setBandeira(_tmpBandeira);
        final String _tmpNomeBandeira;
        _tmpNomeBandeira = _cursor.getString(_cursorIndexOfNomeBandeira);
        _item.setNomeBandeira(_tmpNomeBandeira);
        final Integer _tmpModalidade;
        if (_cursor.isNull(_cursorIndexOfModalidade)) {
          _tmpModalidade = null;
        } else {
          _tmpModalidade = _cursor.getInt(_cursorIndexOfModalidade);
        }
        _item.setModalidade(_tmpModalidade);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Payment find(String numeroAutorizacao) {
    final String _sql = "SELECT * FROM Payment WHERE numeroAutorizacao = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numeroAutorizacao == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroAutorizacao);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfTipoIntegracao = _cursor.getColumnIndexOrThrow("tipoIntegracao");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfNumeroAutorizacao = _cursor.getColumnIndexOrThrow("numeroAutorizacao");
      final int _cursorIndexOfValor = _cursor.getColumnIndexOrThrow("valor");
      final int _cursorIndexOfCredenciadora = _cursor.getColumnIndexOrThrow("credenciadora");
      final int _cursorIndexOfBandeira = _cursor.getColumnIndexOrThrow("bandeira");
      final int _cursorIndexOfNomeBandeira = _cursor.getColumnIndexOrThrow("nomeBandeira");
      final int _cursorIndexOfModalidade = _cursor.getColumnIndexOrThrow("modalidade");
      final Payment _result;
      if(_cursor.moveToFirst()) {
        _result = new Payment();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _result.setIdNota(_tmpIdNota);
        final Integer _tmpTipoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoIntegracao)) {
          _tmpTipoIntegracao = null;
        } else {
          _tmpTipoIntegracao = _cursor.getInt(_cursorIndexOfTipoIntegracao);
        }
        _result.setTipoIntegracao(_tmpTipoIntegracao);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _result.setCnpj(_tmpCnpj);
        final String _tmpNumeroAutorizacao;
        _tmpNumeroAutorizacao = _cursor.getString(_cursorIndexOfNumeroAutorizacao);
        _result.setNumeroAutorizacao(_tmpNumeroAutorizacao);
        final Double _tmpValor;
        if (_cursor.isNull(_cursorIndexOfValor)) {
          _tmpValor = null;
        } else {
          _tmpValor = _cursor.getDouble(_cursorIndexOfValor);
        }
        _result.setValor(_tmpValor);
        final String _tmpCredenciadora;
        _tmpCredenciadora = _cursor.getString(_cursorIndexOfCredenciadora);
        _result.setCredenciadora(_tmpCredenciadora);
        final String _tmpBandeira;
        _tmpBandeira = _cursor.getString(_cursorIndexOfBandeira);
        _result.setBandeira(_tmpBandeira);
        final String _tmpNomeBandeira;
        _tmpNomeBandeira = _cursor.getString(_cursorIndexOfNomeBandeira);
        _result.setNomeBandeira(_tmpNomeBandeira);
        final Integer _tmpModalidade;
        if (_cursor.isNull(_cursorIndexOfModalidade)) {
          _tmpModalidade = null;
        } else {
          _tmpModalidade = _cursor.getInt(_cursorIndexOfModalidade);
        }
        _result.setModalidade(_tmpModalidade);
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
  public List<Payment> find(Long idNota) {
    final String _sql = "SELECT * FROM Payment WHERE idNota = ?";
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
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfTipoIntegracao = _cursor.getColumnIndexOrThrow("tipoIntegracao");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfNumeroAutorizacao = _cursor.getColumnIndexOrThrow("numeroAutorizacao");
      final int _cursorIndexOfValor = _cursor.getColumnIndexOrThrow("valor");
      final int _cursorIndexOfCredenciadora = _cursor.getColumnIndexOrThrow("credenciadora");
      final int _cursorIndexOfBandeira = _cursor.getColumnIndexOrThrow("bandeira");
      final int _cursorIndexOfNomeBandeira = _cursor.getColumnIndexOrThrow("nomeBandeira");
      final int _cursorIndexOfModalidade = _cursor.getColumnIndexOrThrow("modalidade");
      final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payment _item;
        _item = new Payment();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Integer _tmpTipoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoIntegracao)) {
          _tmpTipoIntegracao = null;
        } else {
          _tmpTipoIntegracao = _cursor.getInt(_cursorIndexOfTipoIntegracao);
        }
        _item.setTipoIntegracao(_tmpTipoIntegracao);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _item.setCnpj(_tmpCnpj);
        final String _tmpNumeroAutorizacao;
        _tmpNumeroAutorizacao = _cursor.getString(_cursorIndexOfNumeroAutorizacao);
        _item.setNumeroAutorizacao(_tmpNumeroAutorizacao);
        final Double _tmpValor;
        if (_cursor.isNull(_cursorIndexOfValor)) {
          _tmpValor = null;
        } else {
          _tmpValor = _cursor.getDouble(_cursorIndexOfValor);
        }
        _item.setValor(_tmpValor);
        final String _tmpCredenciadora;
        _tmpCredenciadora = _cursor.getString(_cursorIndexOfCredenciadora);
        _item.setCredenciadora(_tmpCredenciadora);
        final String _tmpBandeira;
        _tmpBandeira = _cursor.getString(_cursorIndexOfBandeira);
        _item.setBandeira(_tmpBandeira);
        final String _tmpNomeBandeira;
        _tmpNomeBandeira = _cursor.getString(_cursorIndexOfNomeBandeira);
        _item.setNomeBandeira(_tmpNomeBandeira);
        final Integer _tmpModalidade;
        if (_cursor.isNull(_cursorIndexOfModalidade)) {
          _tmpModalidade = null;
        } else {
          _tmpModalidade = _cursor.getInt(_cursorIndexOfModalidade);
        }
        _item.setModalidade(_tmpModalidade);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Payment> find() {
    final String _sql = "SELECT * FROM Payment WHERE idNota IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfTipoIntegracao = _cursor.getColumnIndexOrThrow("tipoIntegracao");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfNumeroAutorizacao = _cursor.getColumnIndexOrThrow("numeroAutorizacao");
      final int _cursorIndexOfValor = _cursor.getColumnIndexOrThrow("valor");
      final int _cursorIndexOfCredenciadora = _cursor.getColumnIndexOrThrow("credenciadora");
      final int _cursorIndexOfBandeira = _cursor.getColumnIndexOrThrow("bandeira");
      final int _cursorIndexOfNomeBandeira = _cursor.getColumnIndexOrThrow("nomeBandeira");
      final int _cursorIndexOfModalidade = _cursor.getColumnIndexOrThrow("modalidade");
      final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Payment _item;
        _item = new Payment();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Integer _tmpTipoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoIntegracao)) {
          _tmpTipoIntegracao = null;
        } else {
          _tmpTipoIntegracao = _cursor.getInt(_cursorIndexOfTipoIntegracao);
        }
        _item.setTipoIntegracao(_tmpTipoIntegracao);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _item.setCnpj(_tmpCnpj);
        final String _tmpNumeroAutorizacao;
        _tmpNumeroAutorizacao = _cursor.getString(_cursorIndexOfNumeroAutorizacao);
        _item.setNumeroAutorizacao(_tmpNumeroAutorizacao);
        final Double _tmpValor;
        if (_cursor.isNull(_cursorIndexOfValor)) {
          _tmpValor = null;
        } else {
          _tmpValor = _cursor.getDouble(_cursorIndexOfValor);
        }
        _item.setValor(_tmpValor);
        final String _tmpCredenciadora;
        _tmpCredenciadora = _cursor.getString(_cursorIndexOfCredenciadora);
        _item.setCredenciadora(_tmpCredenciadora);
        final String _tmpBandeira;
        _tmpBandeira = _cursor.getString(_cursorIndexOfBandeira);
        _item.setBandeira(_tmpBandeira);
        final String _tmpNomeBandeira;
        _tmpNomeBandeira = _cursor.getString(_cursorIndexOfNomeBandeira);
        _item.setNomeBandeira(_tmpNomeBandeira);
        final Integer _tmpModalidade;
        if (_cursor.isNull(_cursorIndexOfModalidade)) {
          _tmpModalidade = null;
        } else {
          _tmpModalidade = _cursor.getInt(_cursorIndexOfModalidade);
        }
        _item.setModalidade(_tmpModalidade);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
