package com.demo.application.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bixia on 2017/1/25.
 */

public class SearchDao {
    private SearchDBHelper searchDBHelper;
    private SQLiteDatabase database;

    public SearchDao(Context context) {
        searchDBHelper = new SearchDBHelper(context);
        initTable();
    }

    private void initTable() {
        database = searchDBHelper.getWritableDatabase();
        database.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(SearchDBInfo.COLUMN_1, "Adolf Hitler");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Africa");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Android");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Animal");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "AOA");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "BBC");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Best");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Blog");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Canada");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Candy");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "China");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Drag");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Dad");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Effect");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Fire");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Hurry");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "India");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Korea");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Lion");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Maybe");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Many");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Nova");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Oil");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Paras");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Query");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Rise up");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Singapore");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Tiny");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Wear");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Water");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Yeah");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Yesterday");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Yim");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Yss");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Zero");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Zeus");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        values.put(SearchDBInfo.COLUMN_1, "Zodiac");
        database.insert(SearchDBInfo.TABLE_NAME, null, values);
        database.setTransactionSuccessful();
    }

    public List<String> search(String str) {
        database = searchDBHelper.getReadableDatabase();
        List<String> items = null;
        String[] projection = {
                SearchDBInfo.COLUMN_1
        };
        String selection = SearchDBInfo.COLUMN_1 + " like '" + str + "%'";
        String sort = "LENGTH(" + SearchDBInfo.COLUMN_1 + ")";
        Cursor cursor = database.query(SearchDBInfo.TABLE_NAME,
                projection,
                selection,
                null,
                null,
                null,
                sort);
        if (cursor.getCount() > 0) {
            items = new ArrayList<>(cursor.getCount());
            while (cursor.moveToNext()) {
                items.add(cursor.getString(0));
            }
        }
        cursor.close();
        return items;
    }
}
