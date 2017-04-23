package com.mrexray.www.hishab.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ray on 4/21/2017.
 */

 class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "hishab_db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_USER_INFO = "userInfo";
    public static final String USER_INFO_ID = "userInfoId";
    public static final String USER_NAME = "userName";
    public static final String USER_FATHER_NAME = "userFatherName";
    public static final String USER_MOTHER_NAME = "userMotherName";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_PASSWORD = "userPassword";
    public static final String USER_REFF_NUM = "userReffNum";
    public static final String USER_PHONE_NUM = "userPhoneNum";
    public static final String USER_OFFICE_NUM = "userOfficePhoneNum";

    public static final String TABLE_EXPENSE = "expense";
    public static final String EXPENSE_ID = "expenseId";
    public static final String EXPENSE_AMOUNT = "expenseAmount";
    public static final String EXPENSE_REMARK = "remark";
    public static final String EXPENSE_DATE = "date";

    public static final String TABLE_EXPENSE_TYPE = "expenseType";
    public static final String EXPENSE_TYPE_ID = "expenseTypeId";
    public static final String EXPENSE_TYPE_NAME = "expenseTypeName";

    public static final String TABLE_EXPORTED="exported";
    public static  final String EXPORT_ID= "exportId";
    public static  final String EXPORT_DATE= "exportDate";


    private static final String CREATE_USER_INFO_TABLE =
            " CREATE TABLE " + TABLE_USER_INFO + " ( "
                    + USER_INFO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + USER_NAME + " TEXT NOT NULL, "
                    + USER_FATHER_NAME + " TEXT, "
                    + USER_MOTHER_NAME + "TEXT, "
                    + USER_EMAIL + "TEXT NOT NULL UNIQUE, "
                    + USER_PASSWORD + "TEXT NOT NULL, "
                    + USER_REFF_NUM + "TEXT NOT NULL, "
                    + USER_PHONE_NUM + "TEXT NOT NULL, "
                    + USER_OFFICE_NUM + " TEXT NOT NULL )";

    private static final String CREATE_EXPENSE_TABLE =
            " CREATE TABLE " + TABLE_EXPENSE + " ( "
                    + EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + USER_INFO_ID + "INTEGER NOT NULL, "
                    + EXPENSE_TYPE_ID + " INTEGER NOT NULL, "
                    + EXPENSE_AMOUNT + " TEXT NOT NULL, "
                    + EXPENSE_DATE + " TEXT NOT NULL, "
                    + EXPENSE_REMARK + " TEXT )";

    private static final String CREATE_EXPENSE_TYPE_TABLE =
            " CREATE TABLE " + TABLE_EXPENSE_TYPE + " ( "
                    + EXPENSE_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + USER_INFO_ID + "INTEGER NOT NULL, "
                    + EXPENSE_TYPE_NAME + " TEXT NOT NULL )";

    private static final String CREATE_EXPORTED_TABLE =
            " CREATE TABLE " + TABLE_EXPORTED + " ( "
                    + EXPORT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + EXPENSE_ID + "INTEGER NOT NULL, "
                    + EXPORT_DATE + " TEXT NOT NULL )";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EXPENSE_TYPE_TABLE);
        db.execSQL(CREATE_EXPENSE_TABLE);
        db.execSQL(CREATE_USER_INFO_TABLE);
        db.execSQL(CREATE_EXPORTED_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
