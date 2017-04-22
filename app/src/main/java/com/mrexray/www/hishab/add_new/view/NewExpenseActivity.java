package com.mrexray.www.hishab.add_new.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.mrexray.www.hishab.R;
import com.mrexray.www.hishab.add_new.presenter.NewPresenter;

/**
 * Created by Ray on 4/21/2017.
 */

public class NewExpenseActivity extends AppCompatActivity {

    private EditText etAmount;
    private EditText etNote;
    private Spinner spinner;
    NewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_expense);
        initView();
    }

    private void initView() {
        presenter = new NewPresenter();
        etAmount = (EditText) findViewById(R.id.etAmount);
        etNote = (EditText) findViewById(R.id.etNote);
        spinner = (Spinner) findViewById(R.id.spnExpenseType);
        initSpinner();
    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.expense_type, R.layout.spinner_textview);
        adapter.setDropDownViewResource(R.layout.spinner_textview);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_new_expense_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save && spinner.getSelectedItemPosition() != 0) {


            String tempAmount = etAmount.getText().toString();
            int typeId = spinner.getSelectedItemPosition();
            String note = etNote.getText().toString();

            if (presenter.validateFields(tempAmount)) {
                Float amount = Float.parseFloat(tempAmount);
                presenter.addToDatabase(typeId,amount,note);

            }
        }
        return true;
    }

    public void save(View view) {
    }
}
