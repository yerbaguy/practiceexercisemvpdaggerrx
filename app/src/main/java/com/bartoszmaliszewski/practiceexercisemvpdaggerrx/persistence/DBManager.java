package com.bartoszmaliszewski.practiceexercisemvpdaggerrx.persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
//import android.database.SQLException;

/**
 * Created by bartoszmaliszewski on 24.04.18.
 */

public class DBManager {

    private DatabaseHelper dbHelper;
    private Context context;
    public SQLiteDatabase database;
    public DBManager(Context c) {
        context = c;
    }
    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }
    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._id, DatabaseHelper.engword, DatabaseHelper.plword };
        Cursor cursor = database.query( DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    //   public Cursor fetch() {
    //       Cursor cursor = database.rawQuery("SELECT * FROM WordColumns", null);
    //       if (cursor != null) {
    //           cursor.moveToFirst();
    //       }
    //       return cursor;
    //   }
}
