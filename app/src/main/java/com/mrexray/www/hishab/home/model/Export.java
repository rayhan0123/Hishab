package com.mrexray.www.hishab.home.model;

/**
 * Created by Ray on 4/23/2017.
 */

public class Export {
    private int exportId;
    private int expenseId;
    private String ExportDate;

    public Export(int exportId, int expenseId, String exportDate) {
        this.exportId = exportId;
        this.expenseId = expenseId;
        ExportDate = exportDate;
    }

    public Export(int expenseId, String exportDate) {
        this.expenseId = expenseId;
        ExportDate = exportDate;
    }

    public Export() {

    }

    public int getExportId() {
        return exportId;
    }

    public void setExportId(int exportId) {
        this.exportId = exportId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getExportDate() {
        return ExportDate;
    }

    public void setExportDate(String exportDate) {
        ExportDate = exportDate;
    }
}
