package com.mrexray.www.hishab.utils;

/**
 * Created by Ray on 4/21/2017.
 */

public class ExpenseType {
    private int expenseTypeId;
    private String expenseTypeName;

    public ExpenseType(int expenseTypeId, String expenseTypeName) {
        this.expenseTypeId = expenseTypeId;
        this.expenseTypeName = expenseTypeName;
    }


    public void setExpenseTypeId(int expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public int getExpenseTypeId() {
        return expenseTypeId;
    }

    public String getExpenseTypeName() {
        return expenseTypeName;
    }

    public void setExpenseTypeName(String expenseTypeName) {
        this.expenseTypeName = expenseTypeName;
    }
}
