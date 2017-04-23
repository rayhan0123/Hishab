package com.mrexray.www.hishab.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mrexray.www.hishab.add_new.model.Expense;
import com.mrexray.www.hishab.login_register.model.UserInfo;
import com.mrexray.www.hishab.utils.ExpenseType;

import java.util.ArrayList;

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


    public boolean addNewExpense(Expense expense)

    {
        this.openDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DatabaseHelper.USER_INFO_ID, expense.getUserInfoId());
        cv.put(DatabaseHelper.EXPENSE_TYPE_ID, expense.getExpenseTypeId());
        cv.put(DatabaseHelper.EXPENSE_AMOUNT, expense.getExpenseAmount());
        cv.put(DatabaseHelper.EXPENSE_REMARK, expense.getRemark());
        cv.put(DatabaseHelper.EXPENSE_DATE, expense.getDate());

        long inserted = database.insert(DatabaseHelper.TABLE_EXPENSE, null, cv);

        this.closeDatabase();
        return inserted > 0;
    }


    public boolean addNewUser(UserInfo user) {
        this.openDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DatabaseHelper.USER_NAME, user.getUserName());
        cv.put(DatabaseHelper.USER_EMAIL, user.getUserEmail());
        cv.put(DatabaseHelper.USER_FATHER_NAME, user.getUserFatherName());
        cv.put(DatabaseHelper.USER_MOTHER_NAME, user.getUserMotherName());
        cv.put(DatabaseHelper.USER_PASSWORD, user.getUserPassword());
        cv.put(DatabaseHelper.USER_REFF_NUM, user.getUserReffNum());
        cv.put(DatabaseHelper.USER_PHONE_NUM, user.getUserPhoneNum());
        cv.put(DatabaseHelper.USER_OFFICE_NUM, user.getUserOfficePhoneNum());

        long inserted = database.insert(DatabaseHelper.TABLE_USER_INFO, null, cv);

        this.closeDatabase();
        return inserted > 0;
    }


    public boolean addNewExpeseType(ExpenseType type) {
        this.openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.EXPENSE_TYPE_NAME, type.getExpenseTypeName());

        long inserted = database.insert(DatabaseHelper.TABLE_EXPENSE_TYPE, null, cv);

        this.closeDatabase();
        return inserted > 0;
    }


    //GET

    public ArrayList<ExpenseType> getExpeseTypes() {
        ArrayList<ExpenseType> expenseTypeList = null;
        this.openDatabase();

        Cursor cursor = database.query(DatabaseHelper.TABLE_EXPENSE_TYPE,
                new String[]{DatabaseHelper.EXPENSE_TYPE_ID, DatabaseHelper.EXPENSE_TYPE_NAME},
                null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {

                int expenseTypeId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.EXPENSE_TYPE_ID));
                String expenseTypeName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.EXPENSE_TYPE_NAME));

                ExpenseType expenseType = new ExpenseType(expenseTypeId, expenseTypeName);

                expenseTypeList.add(expenseType);

                cursor.moveToNext();
            }

        }

        this.closeDatabase();
        return expenseTypeList;
    }
}
