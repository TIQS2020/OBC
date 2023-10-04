package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Answer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class AnswerDao_Impl implements AnswerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAnswer;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAnswer;

  public AnswerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAnswer = new EntityInsertionAdapter<Answer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Answer`(`id`,`idPesquisa`,`pergunrta`,`resposta`,`categorizada`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Answer value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIdPesquisa() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIdPesquisa());
        }
        if (value.getPergunrta() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPergunrta());
        }
        if (value.getResposta() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getResposta());
        }
        if (value.getCategorizada() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCategorizada());
        }
      }
    };
    this.__deletionAdapterOfAnswer = new EntityDeletionOrUpdateAdapter<Answer>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Answer` WHERE `id` = ? AND `idPesquisa` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Answer value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIdPesquisa() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIdPesquisa());
        }
      }
    };
  }

  @Override
  public void insert(Answer answer) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAnswer.insert(answer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Answer> answers) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAnswer.handleMultiple(answers);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Answer> getAll() {
    final String _sql = "SELECT * FROM Answer";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdPesquisa = _cursor.getColumnIndexOrThrow("idPesquisa");
      final int _cursorIndexOfPergunrta = _cursor.getColumnIndexOrThrow("pergunrta");
      final int _cursorIndexOfResposta = _cursor.getColumnIndexOrThrow("resposta");
      final int _cursorIndexOfCategorizada = _cursor.getColumnIndexOrThrow("categorizada");
      final List<Answer> _result = new ArrayList<Answer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Answer _item;
        _item = new Answer();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpIdPesquisa;
        if (_cursor.isNull(_cursorIndexOfIdPesquisa)) {
          _tmpIdPesquisa = null;
        } else {
          _tmpIdPesquisa = _cursor.getLong(_cursorIndexOfIdPesquisa);
        }
        _item.setIdPesquisa(_tmpIdPesquisa);
        final String _tmpPergunrta;
        _tmpPergunrta = _cursor.getString(_cursorIndexOfPergunrta);
        _item.setPergunrta(_tmpPergunrta);
        final String _tmpResposta;
        _tmpResposta = _cursor.getString(_cursorIndexOfResposta);
        _item.setResposta(_tmpResposta);
        final String _tmpCategorizada;
        _tmpCategorizada = _cursor.getString(_cursorIndexOfCategorizada);
        _item.setCategorizada(_tmpCategorizada);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Answer> findById(Long idSearch) {
    final String _sql = "SELECT * FROM Answer WHERE idPesquisa = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idSearch == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idSearch);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdPesquisa = _cursor.getColumnIndexOrThrow("idPesquisa");
      final int _cursorIndexOfPergunrta = _cursor.getColumnIndexOrThrow("pergunrta");
      final int _cursorIndexOfResposta = _cursor.getColumnIndexOrThrow("resposta");
      final int _cursorIndexOfCategorizada = _cursor.getColumnIndexOrThrow("categorizada");
      final List<Answer> _result = new ArrayList<Answer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Answer _item;
        _item = new Answer();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpIdPesquisa;
        if (_cursor.isNull(_cursorIndexOfIdPesquisa)) {
          _tmpIdPesquisa = null;
        } else {
          _tmpIdPesquisa = _cursor.getLong(_cursorIndexOfIdPesquisa);
        }
        _item.setIdPesquisa(_tmpIdPesquisa);
        final String _tmpPergunrta;
        _tmpPergunrta = _cursor.getString(_cursorIndexOfPergunrta);
        _item.setPergunrta(_tmpPergunrta);
        final String _tmpResposta;
        _tmpResposta = _cursor.getString(_cursorIndexOfResposta);
        _item.setResposta(_tmpResposta);
        final String _tmpCategorizada;
        _tmpCategorizada = _cursor.getString(_cursorIndexOfCategorizada);
        _item.setCategorizada(_tmpCategorizada);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
