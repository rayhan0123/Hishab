package com.mrexray.www.hishab.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ray on 4/21/2017.
 */

public class DatabaseManager {
    private Context context;
    private DatabaseHelper helper;
    private SQLiteDatabase database;


    public DatabaseManager(Context context) {
        this.context = context;
        helper = new DatabaseHelper(context);
    }

    public void openDatabase() {
        database = helper.getWritableDatabase();
    }

    public void closeDatabase() {
        helper.close();
        database.close();
    }
}
