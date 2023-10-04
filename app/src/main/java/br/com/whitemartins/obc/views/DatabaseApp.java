package br.com.whitemartins.obc.views;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.text.Editable;

import com.commonsware.cwac.saferoom.SafeHelperFactory;

import br.com.whitemartins.obc.database.AppDatabase;
import br.com.whitemartins.obc.database._StaticDatabase;
import br.com.whitemartins.obc.util.Constants;
import br.com.whitemartins.obc.util.LogHelper;

//import com.commonsware.cwac.saferoom.SafeHelperFactory;

public class DatabaseApp extends Application {

  private static DatabaseApp _self;
  private AppDatabase database;
  private _StaticDatabase staticDatabase;

  public static DatabaseApp self() {
    return _self;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    _self = this;
    final String key = "obcandroid@2019";

    createDB(key);
    createTempDB(key);
  }

  public void createDB(String privateKey) {
    try {
      Editable e = Editable.Factory.getInstance().newEditable(privateKey);
      SafeHelperFactory factory = SafeHelperFactory.fromUser(e);

      database =
          Room.databaseBuilder(getApplicationContext(), AppDatabase.class, Constants.DATABASE_NAME)
              .allowMainThreadQueries()
              .fallbackToDestructiveMigration()
              .openHelperFactory(factory)
              .build();

    } catch (Exception e) {
      LogHelper.self().error("DatabaseApp", e);
    }
  }

  public void createTempDB(String privateKey) {
    try {
      Editable e = Editable.Factory.getInstance().newEditable(privateKey);
      SafeHelperFactory factory = SafeHelperFactory.fromUser(e);

      staticDatabase =
          Room.databaseBuilder(getApplicationContext(), _StaticDatabase.class, Constants.STATIC_DATABSE_OBC)
              .allowMainThreadQueries()
              .fallbackToDestructiveMigration()
              .openHelperFactory(factory)
              .build();

    } catch (Exception e) {
      LogHelper.self().error("DatabaseApp", e);
    }
  }

  public AppDatabase getDatabase() {
    return database;
  }

  public _StaticDatabase getStaticDatabase() {
    return staticDatabase;
  }
}
