package br.com.whitemartins.obc.util;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import com.commonsware.cwac.saferoom.SafeHelperFactory;

import br.com.whitemartins.obc.views.DatabaseApp;

public class SqliteHelper {//extends SQLiteOpenHelper {

  private static SqliteHelper _self;


  public SqliteHelper(Context context) {
//    super(context, Constants.DATABASE_NAME, factory(), Constants.DB_VERSION);
  }

  public static SqliteHelper self(Context context) {
    if (_self == null)
      _self = new SqliteHelper(context);
    return _self;
  }


  public void resetAutoIncrement(SupportSQLiteDatabase db, String tableName, int methodId) {

    String sql = "";

    try {

      if (methodId == 0) {
        sql = "UPDATE " + Constants.TABLE_SQLITE_SEQUENCE + " SET seq=0 WHERE name=\"" + tableName + "\";";
      } else {
        sql = "DELETE FROM " + Constants.TABLE_SQLITE_SEQUENCE + " WHERE name=\"" + tableName + "\";";
      }
      db.execSQL(sql);

    } catch (SQLException e) {
      LogHelper.self().error("resetAutoIncrement", e);
      e.printStackTrace();
    }
  }
}
