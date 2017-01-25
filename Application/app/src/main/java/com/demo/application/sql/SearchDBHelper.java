package com.demo.application.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bixia on 2017/1/25.
 */

public class SearchDBHelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE = "create table if not exists " + SearchDBInfo.TABLE_NAME + " (" +
            SearchDBInfo._ID + " INTEGER PRIMARY KEY," +
            SearchDBInfo.COLUMN_1 + " text)";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + SearchDBInfo.TABLE_NAME;

    public SearchDBHelper(Context context) {
        super(context, SearchDBInfo.DB_NAME, null, SearchDBInfo.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}
