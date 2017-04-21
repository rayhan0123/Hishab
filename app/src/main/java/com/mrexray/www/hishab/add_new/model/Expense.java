package com.mrexray.www.hishab.add_new.model;

import java.util.Date;

/**
 * Created by Ray on 4/21/2017.
 */

public class Expense {
    private int expenseId;
    private int userinfoId;
    private int expeseTypeId;
    private float expenseAmount;
    private String remark;
    private Date date;

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(int userinfoId) {
        this.userinfoId = userinfoId;
    }

    public int getExpeseTypeId() {
        return expeseTypeId;
    }

    public void setExpeseTypeId(int expeseTypeId) {
        this.expeseTypeId = expeseTypeId;
    }

    public float getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(float expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
