package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Message;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class MessageDao_Impl implements MessageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMessage;

  private final EntityInsertionAdapter __insertionAdapterOfMessage_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMessage;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfMessage;

  public MessageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMessage = new EntityInsertionAdapter<Message>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Message`(`id`,`tipoMensagem`,`cdCustomer`,`mensagem`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Message value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTipoMensagem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTipoMensagem());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCdCustomer());
        }
        if (value.getMensagem() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMensagem());
        }
      }
    };
    this.__insertionAdapterOfMessage_1 = new EntityInsertionAdapter<Message>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Message`(`id`,`tipoMensagem`,`cdCustomer`,`mensagem`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Message value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTipoMensagem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTipoMensagem());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCdCustomer());
        }
        if (value.getMensagem() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMensagem());
        }
      }
    };
    this.__deletionAdapterOfMessage = new EntityDeletionOrUpdateAdapter<Message>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Message` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Message value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfMessage = new EntityDeletionOrUpdateAdapter<Message>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Message` SET `id` = ?,`tipoMensagem` = ?,`cdCustomer` = ?,`mensagem` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Message value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTipoMensagem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTipoMensagem());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCdCustomer());
        }
        if (value.getMensagem() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMensagem());
        }
        if (value.getId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getId());
        }
      }
    };
  }

  @Override
  public void insertAll(List<Message> messages) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMessage.insert(messages);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(Message message) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMessage_1.insert(message);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Message message) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfMessage.handle(message);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Message> messages) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfMessage.handleMultiple(messages);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Message message) {
    __db.beginTransaction();
    try {
      __updateAdapterOfMessage.handle(message);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Message> getAll() {
    final String _sql = "SELECT * FROM Message";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoMensagem = _cursor.getColumnIndexOrThrow("tipoMensagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfMensagem = _cursor.getColumnIndexOrThrow("mensagem");
      final List<Message> _result = new ArrayList<Message>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Message _item;
        _item = new Message();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpTipoMensagem;
        _tmpTipoMensagem = _cursor.getString(_cursorIndexOfTipoMensagem);
        _item.setTipoMensagem(_tmpTipoMensagem);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpMensagem;
        _tmpMensagem = _cursor.getString(_cursorIndexOfMensagem);
        _item.setMensagem(_tmpMensagem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Message> find(String tipoMensagem, Long cdCustomer) {
    final String _sql = "SELECT * FROM Message WHERE cdCustomer = ifnull(?, cdCustomer) AND tipoMensagem = ?  ORDER BY id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2;
    if (tipoMensagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoMensagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoMensagem = _cursor.getColumnIndexOrThrow("tipoMensagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfMensagem = _cursor.getColumnIndexOrThrow("mensagem");
      final List<Message> _result = new ArrayList<Message>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Message _item;
        _item = new Message();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpTipoMensagem;
        _tmpTipoMensagem = _cursor.getString(_cursorIndexOfTipoMensagem);
        _item.setTipoMensagem(_tmpTipoMensagem);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpMensagem;
        _tmpMensagem = _cursor.getString(_cursorIndexOfMensagem);
        _item.setMensagem(_tmpMensagem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Message> find(Long cdCustomer) {
    final String _sql = "SELECT * FROM Message WHERE cdCustomer = ?";
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
      final int _cursorIndexOfTipoMensagem = _cursor.getColumnIndexOrThrow("tipoMensagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfMensagem = _cursor.getColumnIndexOrThrow("mensagem");
      final List<Message> _result = new ArrayList<Message>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Message _item;
        _item = new Message();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpTipoMensagem;
        _tmpTipoMensagem = _cursor.getString(_cursorIndexOfTipoMensagem);
        _item.setTipoMensagem(_tmpTipoMensagem);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpMensagem;
        _tmpMensagem = _cursor.getString(_cursorIndexOfMensagem);
        _item.setMensagem(_tmpMensagem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Message> find(String tipoMensagem) {
    final String _sql = "SELECT * FROM Message WHERE tipoMensagem = ? ORDER BY id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tipoMensagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoMensagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoMensagem = _cursor.getColumnIndexOrThrow("tipoMensagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfMensagem = _cursor.getColumnIndexOrThrow("mensagem");
      final List<Message> _result = new ArrayList<Message>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Message _item;
        _item = new Message();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpTipoMensagem;
        _tmpTipoMensagem = _cursor.getString(_cursorIndexOfTipoMensagem);
        _item.setTipoMensagem(_tmpTipoMensagem);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpMensagem;
        _tmpMensagem = _cursor.getString(_cursorIndexOfMensagem);
        _item.setMensagem(_tmpMensagem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Message findByType(String tipoMensagem) {
    final String _sql = "SELECT * FROM Message WHERE tipoMensagem = ? ORDER BY id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tipoMensagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoMensagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTipoMensagem = _cursor.getColumnIndexOrThrow("tipoMensagem");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfMensagem = _cursor.getColumnIndexOrThrow("mensagem");
      final Message _result;
      if(_cursor.moveToFirst()) {
        _result = new Message();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpTipoMensagem;
        _tmpTipoMensagem = _cursor.getString(_cursorIndexOfTipoMensagem);
        _result.setTipoMensagem(_tmpTipoMensagem);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final String _tmpMensagem;
        _tmpMensagem = _cursor.getString(_cursorIndexOfMensagem);
        _result.setMensagem(_tmpMensagem);
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
