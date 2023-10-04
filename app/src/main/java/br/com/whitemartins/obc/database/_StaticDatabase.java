package br.com.whitemartins.obc.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import br.com.whitemartins.obc.dao._StaticDao;
import br.com.whitemartins.obc.model._StaticTable;
import br.com.whitemartins.obc.util.Constants;

@Database(entities = {
  _StaticTable.class
},
  version = 3,
  exportSchema = false)

@TypeConverters({DateTypeConverter.class})
public abstract class _StaticDatabase extends RoomDatabase {

  public abstract _StaticDao staticDao();

}

