package com.mrexray.www.hishab.add_new.presenter;

import com.mrexray.www.hishab.add_new.Contract;


/**
 * Created by Ray on 4/22/2017.
 */

public class NewPresenter implements Contract.viewsInterface {


    @Override
    public boolean validateFields(String expense) {
        return !(expense == null);
    }

    @Override
    public boolean addToDatabase(int typeId, float expenseAmount, String note) {

        return false;
    }


}
