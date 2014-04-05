package com.whereismymoney.activity;

import com.whereismymoney.R;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

/**
 * UI class to display transaction details associated with the current account.
 * @author cxy
 *
 */
public class AccountDetail extends FragmentActivity implements DatePickerDialog.OnDateSetListener {
    private Button createNewTransaction;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	getActionBar().setTitle("");
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transaction_history);
        
        createNewTransaction = (Button) findViewById(R.id.button_create_new_transaction);
        
        //clicking on new transaction
        createNewTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent goCreateTransaction = new Intent("android.intent.action.NEWTRANSACTION");
                startActivity(goCreateTransaction);
            }
        });
    }

    @Override
    public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
        
    }
    
    //creates the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
