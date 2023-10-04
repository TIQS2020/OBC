package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.PaymentCard;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class PaymentCardDao_Impl implements PaymentCardDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPaymentCard;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfPaymentCard;

  public PaymentCardDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPaymentCard = new EntityInsertionAdapter<PaymentCard>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `PaymentCard`(`cnpj`,`nomeEmpresa`,`tipoIntegracao`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PaymentCard value) {
        if (value.getCnpj() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCnpj());
        }
        if (value.getNomeEmpresa() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNomeEmpresa());
        }
        if (value.getTipoIntegracao() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getTipoIntegracao());
        }
      }
    };
    this.__deletionAdapterOfPaymentCard = new EntityDeletionOrUpdateAdapter<PaymentCard>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PaymentCard` WHERE `cnpj` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PaymentCard value) {
        if (value.getCnpj() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCnpj());
        }
      }
    };
  }

  @Override
  public void insert(PaymentCard paymentCard) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPaymentCard.insert(paymentCard);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(PaymentCard paymentCard) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPaymentCard.handle(paymentCard);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<PaymentCard> paymentCards) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPaymentCard.handleMultiple(paymentCards);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PaymentCard> getAll() {
    final String _sql = "SELECT * FROM PaymentCard";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfNomeEmpresa = _cursor.getColumnIndexOrThrow("nomeEmpresa");
      final int _cursorIndexOfTipoIntegracao = _cursor.getColumnIndexOrThrow("tipoIntegracao");
      final List<PaymentCard> _result = new ArrayList<PaymentCard>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PaymentCard _item;
        _item = new PaymentCard();
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _item.setCnpj(_tmpCnpj);
        final String _tmpNomeEmpresa;
        _tmpNomeEmpresa = _cursor.getString(_cursorIndexOfNomeEmpresa);
        _item.setNomeEmpresa(_tmpNomeEmpresa);
        final Integer _tmpTipoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoIntegracao)) {
          _tmpTipoIntegracao = null;
        } else {
          _tmpTipoIntegracao = _cursor.getInt(_cursorIndexOfTipoIntegracao);
        }
        _item.setTipoIntegracao(_tmpTipoIntegracao);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public PaymentCard findByCnpj(String cnpj) {
    final String _sql = "SELECT * FROM PaymentCard WHERE cnpj = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cnpj == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cnpj);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfNomeEmpresa = _cursor.getColumnIndexOrThrow("nomeEmpresa");
      final int _cursorIndexOfTipoIntegracao = _cursor.getColumnIndexOrThrow("tipoIntegracao");
      final PaymentCard _result;
      if(_cursor.moveToFirst()) {
        _result = new PaymentCard();
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _result.setCnpj(_tmpCnpj);
        final String _tmpNomeEmpresa;
        _tmpNomeEmpresa = _cursor.getString(_cursorIndexOfNomeEmpresa);
        _result.setNomeEmpresa(_tmpNomeEmpresa);
        final Integer _tmpTipoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoIntegracao)) {
          _tmpTipoIntegracao = null;
        } else {
          _tmpTipoIntegracao = _cursor.getInt(_cursorIndexOfTipoIntegracao);
        }
        _result.setTipoIntegracao(_tmpTipoIntegracao);
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
