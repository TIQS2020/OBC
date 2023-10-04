package br.com.whitemartins.obc.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateTypeConverter {

  @TypeConverter
  public static Date fromTimestamp(Long value) {
    return (value == null || value == 0) ? null : new Date(value);
  }

  @TypeConverter
  public static Long dateToTimestamp(Date date) {
    return date == null ? null : date.getTime();
  }


}
