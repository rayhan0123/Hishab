package com.mrexray.www.hishab.add_new;

/**
 * Created by Ray on 4/22/2017.
 */

public interface Contract {
    interface presenterInterface {

    }

    interface viewsInterface {
        boolean validateFields(String expense);

        boolean addToDatabase(int typeId, float expenseAmount, String note);
    }
}
