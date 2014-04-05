package com.whereismymoney.activity;

import com.whereismymoney.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

/**
 * This class handles the selection of a new transaction type, deposit or
 * withdrawal. User can also go back to the account info screen.
 */

public class NewTransaction extends Activity {

    Bundle a;
    Button deposit, withdrawal, cancel;

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        this.onCreate(a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	getActionBar().setTitle("");
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);

        deposit = (Button) findViewById(R.id.button_new_deposit);
        withdrawal = (Button) findViewById(R.id.button_new_withdrawal);

        // going to the new deposit screen
        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNewDeposit = new Intent(
                        "android.intent.action.NEWDEPOSIT");
                startActivity(goToNewDeposit);
            }
        });

        // going to the new withdrawal screen
        withdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNewWithdrawal = new Intent(
                        "android.intent.action.NEWWITHDRAWAL");
                startActivity(goToNewWithdrawal);
            }
        });
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