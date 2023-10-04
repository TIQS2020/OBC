package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Questions;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class QuestionsDao_Impl implements QuestionsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfQuestions;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfQuestions;

  public QuestionsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuestions = new EntityInsertionAdapter<Questions>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Questions`(`numeroPergunta`,`pergunta`,`numeroResposta1`,`resposta1`,`numeroResposta2`,`resposta2`,`numeroResposta3`,`resposta3`,`numeroResposta4`,`resposta4`,`numeroResposta5`,`resposta5`,`categorizar`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Questions value) {
        if (value.getNumeroPergunta() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroPergunta());
        }
        if (value.getPergunta() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPergunta());
        }
        if (value.getNumeroResposta1() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getNumeroResposta1());
        }
        if (value.getResposta1() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getResposta1());
        }
        if (value.getNumeroResposta2() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getNumeroResposta2());
        }
        if (value.getResposta2() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getResposta2());
        }
        if (value.getNumeroResposta3() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getNumeroResposta3());
        }
        if (value.getResposta3() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getResposta3());
        }
        if (value.getNumeroResposta4() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getNumeroResposta4());
        }
        if (value.getResposta4() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getResposta4());
        }
        if (value.getNumeroResposta5() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getNumeroResposta5());
        }
        if (value.getResposta5() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getResposta5());
        }
        if (value.getCategorizar() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCategorizar());
        }
      }
    };
    this.__deletionAdapterOfQuestions = new EntityDeletionOrUpdateAdapter<Questions>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Questions` WHERE `numeroPergunta` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Questions value) {
        if (value.getNumeroPergunta() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getNumeroPergunta());
        }
      }
    };
  }

  @Override
  public void insert(Questions questions) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfQuestions.insert(questions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Questions questions) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfQuestions.handle(questions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Questions> perguntas) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfQuestions.handleMultiple(perguntas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Questions> getAll() {
    final String _sql = "SELECT * FROM Questions";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroPergunta = _cursor.getColumnIndexOrThrow("numeroPergunta");
      final int _cursorIndexOfPergunta = _cursor.getColumnIndexOrThrow("pergunta");
      final int _cursorIndexOfNumeroResposta1 = _cursor.getColumnIndexOrThrow("numeroResposta1");
      final int _cursorIndexOfResposta1 = _cursor.getColumnIndexOrThrow("resposta1");
      final int _cursorIndexOfNumeroResposta2 = _cursor.getColumnIndexOrThrow("numeroResposta2");
      final int _cursorIndexOfResposta2 = _cursor.getColumnIndexOrThrow("resposta2");
      final int _cursorIndexOfNumeroResposta3 = _cursor.getColumnIndexOrThrow("numeroResposta3");
      final int _cursorIndexOfResposta3 = _cursor.getColumnIndexOrThrow("resposta3");
      final int _cursorIndexOfNumeroResposta4 = _cursor.getColumnIndexOrThrow("numeroResposta4");
      final int _cursorIndexOfResposta4 = _cursor.getColumnIndexOrThrow("resposta4");
      final int _cursorIndexOfNumeroResposta5 = _cursor.getColumnIndexOrThrow("numeroResposta5");
      final int _cursorIndexOfResposta5 = _cursor.getColumnIndexOrThrow("resposta5");
      final int _cursorIndexOfCategorizar = _cursor.getColumnIndexOrThrow("categorizar");
      final List<Questions> _result = new ArrayList<Questions>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Questions _item;
        _item = new Questions();
        final Integer _tmpNumeroPergunta;
        if (_cursor.isNull(_cursorIndexOfNumeroPergunta)) {
          _tmpNumeroPergunta = null;
        } else {
          _tmpNumeroPergunta = _cursor.getInt(_cursorIndexOfNumeroPergunta);
        }
        _item.setNumeroPergunta(_tmpNumeroPergunta);
        final String _tmpPergunta;
        _tmpPergunta = _cursor.getString(_cursorIndexOfPergunta);
        _item.setPergunta(_tmpPergunta);
        final Integer _tmpNumeroResposta1;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta1)) {
          _tmpNumeroResposta1 = null;
        } else {
          _tmpNumeroResposta1 = _cursor.getInt(_cursorIndexOfNumeroResposta1);
        }
        _item.setNumeroResposta1(_tmpNumeroResposta1);
        final String _tmpResposta1;
        _tmpResposta1 = _cursor.getString(_cursorIndexOfResposta1);
        _item.setResposta1(_tmpResposta1);
        final Integer _tmpNumeroResposta2;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta2)) {
          _tmpNumeroResposta2 = null;
        } else {
          _tmpNumeroResposta2 = _cursor.getInt(_cursorIndexOfNumeroResposta2);
        }
        _item.setNumeroResposta2(_tmpNumeroResposta2);
        final String _tmpResposta2;
        _tmpResposta2 = _cursor.getString(_cursorIndexOfResposta2);
        _item.setResposta2(_tmpResposta2);
        final Integer _tmpNumeroResposta3;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta3)) {
          _tmpNumeroResposta3 = null;
        } else {
          _tmpNumeroResposta3 = _cursor.getInt(_cursorIndexOfNumeroResposta3);
        }
        _item.setNumeroResposta3(_tmpNumeroResposta3);
        final String _tmpResposta3;
        _tmpResposta3 = _cursor.getString(_cursorIndexOfResposta3);
        _item.setResposta3(_tmpResposta3);
        final Integer _tmpNumeroResposta4;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta4)) {
          _tmpNumeroResposta4 = null;
        } else {
          _tmpNumeroResposta4 = _cursor.getInt(_cursorIndexOfNumeroResposta4);
        }
        _item.setNumeroResposta4(_tmpNumeroResposta4);
        final String _tmpResposta4;
        _tmpResposta4 = _cursor.getString(_cursorIndexOfResposta4);
        _item.setResposta4(_tmpResposta4);
        final Integer _tmpNumeroResposta5;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta5)) {
          _tmpNumeroResposta5 = null;
        } else {
          _tmpNumeroResposta5 = _cursor.getInt(_cursorIndexOfNumeroResposta5);
        }
        _item.setNumeroResposta5(_tmpNumeroResposta5);
        final String _tmpResposta5;
        _tmpResposta5 = _cursor.getString(_cursorIndexOfResposta5);
        _item.setResposta5(_tmpResposta5);
        final String _tmpCategorizar;
        _tmpCategorizar = _cursor.getString(_cursorIndexOfCategorizar);
        _item.setCategorizar(_tmpCategorizar);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Questions findById(Long numeroPergunta) {
    final String _sql = "SELECT * FROM Questions WHERE numeroPergunta = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numeroPergunta == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numeroPergunta);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroPergunta = _cursor.getColumnIndexOrThrow("numeroPergunta");
      final int _cursorIndexOfPergunta = _cursor.getColumnIndexOrThrow("pergunta");
      final int _cursorIndexOfNumeroResposta1 = _cursor.getColumnIndexOrThrow("numeroResposta1");
      final int _cursorIndexOfResposta1 = _cursor.getColumnIndexOrThrow("resposta1");
      final int _cursorIndexOfNumeroResposta2 = _cursor.getColumnIndexOrThrow("numeroResposta2");
      final int _cursorIndexOfResposta2 = _cursor.getColumnIndexOrThrow("resposta2");
      final int _cursorIndexOfNumeroResposta3 = _cursor.getColumnIndexOrThrow("numeroResposta3");
      final int _cursorIndexOfResposta3 = _cursor.getColumnIndexOrThrow("resposta3");
      final int _cursorIndexOfNumeroResposta4 = _cursor.getColumnIndexOrThrow("numeroResposta4");
      final int _cursorIndexOfResposta4 = _cursor.getColumnIndexOrThrow("resposta4");
      final int _cursorIndexOfNumeroResposta5 = _cursor.getColumnIndexOrThrow("numeroResposta5");
      final int _cursorIndexOfResposta5 = _cursor.getColumnIndexOrThrow("resposta5");
      final int _cursorIndexOfCategorizar = _cursor.getColumnIndexOrThrow("categorizar");
      final Questions _result;
      if(_cursor.moveToFirst()) {
        _result = new Questions();
        final Integer _tmpNumeroPergunta;
        if (_cursor.isNull(_cursorIndexOfNumeroPergunta)) {
          _tmpNumeroPergunta = null;
        } else {
          _tmpNumeroPergunta = _cursor.getInt(_cursorIndexOfNumeroPergunta);
        }
        _result.setNumeroPergunta(_tmpNumeroPergunta);
        final String _tmpPergunta;
        _tmpPergunta = _cursor.getString(_cursorIndexOfPergunta);
        _result.setPergunta(_tmpPergunta);
        final Integer _tmpNumeroResposta1;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta1)) {
          _tmpNumeroResposta1 = null;
        } else {
          _tmpNumeroResposta1 = _cursor.getInt(_cursorIndexOfNumeroResposta1);
        }
        _result.setNumeroResposta1(_tmpNumeroResposta1);
        final String _tmpResposta1;
        _tmpResposta1 = _cursor.getString(_cursorIndexOfResposta1);
        _result.setResposta1(_tmpResposta1);
        final Integer _tmpNumeroResposta2;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta2)) {
          _tmpNumeroResposta2 = null;
        } else {
          _tmpNumeroResposta2 = _cursor.getInt(_cursorIndexOfNumeroResposta2);
        }
        _result.setNumeroResposta2(_tmpNumeroResposta2);
        final String _tmpResposta2;
        _tmpResposta2 = _cursor.getString(_cursorIndexOfResposta2);
        _result.setResposta2(_tmpResposta2);
        final Integer _tmpNumeroResposta3;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta3)) {
          _tmpNumeroResposta3 = null;
        } else {
          _tmpNumeroResposta3 = _cursor.getInt(_cursorIndexOfNumeroResposta3);
        }
        _result.setNumeroResposta3(_tmpNumeroResposta3);
        final String _tmpResposta3;
        _tmpResposta3 = _cursor.getString(_cursorIndexOfResposta3);
        _result.setResposta3(_tmpResposta3);
        final Integer _tmpNumeroResposta4;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta4)) {
          _tmpNumeroResposta4 = null;
        } else {
          _tmpNumeroResposta4 = _cursor.getInt(_cursorIndexOfNumeroResposta4);
        }
        _result.setNumeroResposta4(_tmpNumeroResposta4);
        final String _tmpResposta4;
        _tmpResposta4 = _cursor.getString(_cursorIndexOfResposta4);
        _result.setResposta4(_tmpResposta4);
        final Integer _tmpNumeroResposta5;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta5)) {
          _tmpNumeroResposta5 = null;
        } else {
          _tmpNumeroResposta5 = _cursor.getInt(_cursorIndexOfNumeroResposta5);
        }
        _result.setNumeroResposta5(_tmpNumeroResposta5);
        final String _tmpResposta5;
        _tmpResposta5 = _cursor.getString(_cursorIndexOfResposta5);
        _result.setResposta5(_tmpResposta5);
        final String _tmpCategorizar;
        _tmpCategorizar = _cursor.getString(_cursorIndexOfCategorizar);
        _result.setCategorizar(_tmpCategorizar);
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
  public Questions find(String pergunta) {
    final String _sql = "SELECT * FROM Questions WHERE pergunta = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (pergunta == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, pergunta);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNumeroPergunta = _cursor.getColumnIndexOrThrow("numeroPergunta");
      final int _cursorIndexOfPergunta = _cursor.getColumnIndexOrThrow("pergunta");
      final int _cursorIndexOfNumeroResposta1 = _cursor.getColumnIndexOrThrow("numeroResposta1");
      final int _cursorIndexOfResposta1 = _cursor.getColumnIndexOrThrow("resposta1");
      final int _cursorIndexOfNumeroResposta2 = _cursor.getColumnIndexOrThrow("numeroResposta2");
      final int _cursorIndexOfResposta2 = _cursor.getColumnIndexOrThrow("resposta2");
      final int _cursorIndexOfNumeroResposta3 = _cursor.getColumnIndexOrThrow("numeroResposta3");
      final int _cursorIndexOfResposta3 = _cursor.getColumnIndexOrThrow("resposta3");
      final int _cursorIndexOfNumeroResposta4 = _cursor.getColumnIndexOrThrow("numeroResposta4");
      final int _cursorIndexOfResposta4 = _cursor.getColumnIndexOrThrow("resposta4");
      final int _cursorIndexOfNumeroResposta5 = _cursor.getColumnIndexOrThrow("numeroResposta5");
      final int _cursorIndexOfResposta5 = _cursor.getColumnIndexOrThrow("resposta5");
      final int _cursorIndexOfCategorizar = _cursor.getColumnIndexOrThrow("categorizar");
      final Questions _result;
      if(_cursor.moveToFirst()) {
        _result = new Questions();
        final Integer _tmpNumeroPergunta;
        if (_cursor.isNull(_cursorIndexOfNumeroPergunta)) {
          _tmpNumeroPergunta = null;
        } else {
          _tmpNumeroPergunta = _cursor.getInt(_cursorIndexOfNumeroPergunta);
        }
        _result.setNumeroPergunta(_tmpNumeroPergunta);
        final String _tmpPergunta;
        _tmpPergunta = _cursor.getString(_cursorIndexOfPergunta);
        _result.setPergunta(_tmpPergunta);
        final Integer _tmpNumeroResposta1;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta1)) {
          _tmpNumeroResposta1 = null;
        } else {
          _tmpNumeroResposta1 = _cursor.getInt(_cursorIndexOfNumeroResposta1);
        }
        _result.setNumeroResposta1(_tmpNumeroResposta1);
        final String _tmpResposta1;
        _tmpResposta1 = _cursor.getString(_cursorIndexOfResposta1);
        _result.setResposta1(_tmpResposta1);
        final Integer _tmpNumeroResposta2;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta2)) {
          _tmpNumeroResposta2 = null;
        } else {
          _tmpNumeroResposta2 = _cursor.getInt(_cursorIndexOfNumeroResposta2);
        }
        _result.setNumeroResposta2(_tmpNumeroResposta2);
        final String _tmpResposta2;
        _tmpResposta2 = _cursor.getString(_cursorIndexOfResposta2);
        _result.setResposta2(_tmpResposta2);
        final Integer _tmpNumeroResposta3;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta3)) {
          _tmpNumeroResposta3 = null;
        } else {
          _tmpNumeroResposta3 = _cursor.getInt(_cursorIndexOfNumeroResposta3);
        }
        _result.setNumeroResposta3(_tmpNumeroResposta3);
        final String _tmpResposta3;
        _tmpResposta3 = _cursor.getString(_cursorIndexOfResposta3);
        _result.setResposta3(_tmpResposta3);
        final Integer _tmpNumeroResposta4;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta4)) {
          _tmpNumeroResposta4 = null;
        } else {
          _tmpNumeroResposta4 = _cursor.getInt(_cursorIndexOfNumeroResposta4);
        }
        _result.setNumeroResposta4(_tmpNumeroResposta4);
        final String _tmpResposta4;
        _tmpResposta4 = _cursor.getString(_cursorIndexOfResposta4);
        _result.setResposta4(_tmpResposta4);
        final Integer _tmpNumeroResposta5;
        if (_cursor.isNull(_cursorIndexOfNumeroResposta5)) {
          _tmpNumeroResposta5 = null;
        } else {
          _tmpNumeroResposta5 = _cursor.getInt(_cursorIndexOfNumeroResposta5);
        }
        _result.setNumeroResposta5(_tmpNumeroResposta5);
        final String _tmpResposta5;
        _tmpResposta5 = _cursor.getString(_cursorIndexOfResposta5);
        _result.setResposta5(_tmpResposta5);
        final String _tmpCategorizar;
        _tmpCategorizar = _cursor.getString(_cursorIndexOfCategorizar);
        _result.setCategorizar(_tmpCategorizar);
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
