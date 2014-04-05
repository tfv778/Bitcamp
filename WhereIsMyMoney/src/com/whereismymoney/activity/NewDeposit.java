package com.whereismymoney.activity;

import com.whereismymoney.R;
import com.whereismymoney.model.TransactionManager;
import com.whereismymoney.service.IntegrityCheck;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class handles the activity associated with creating a new deposit.
 */

public class NewDeposit extends Activity {

    private TransactionManager transactionManager;
    Bundle a;
    Button confirm, cancel;

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        this.onCreate(a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	getActionBar().setTitle("");
        
        a = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_deposit);
        transactionManager = new TransactionManager();

        confirm = (Button) findViewById(R.id.button_confirm_deposit);

        // this method handles the confirm button being clicked
        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EditText source = (EditText) findViewById(R.id.edit_deposit_source);
                EditText amount = (EditText) findViewById(R.id.edit_deposit_amount);
                EditText effectiveDate = (EditText) findViewById(R.id.edit_deposit_effective_date);

                String alertMessage = "Deposit Failed";
                String alertReason = null;
                if (!IntegrityCheck.isInputValid(source.getText().toString())) {
                    alertReason = "You didn't enter a source";
                } else if (!IntegrityCheck.isInputValid(amount.getText()
                        .toString())) {
                    alertReason = "You didn't enter an amount";
                } else if (!IntegrityCheck.isInputValid(effectiveDate.getText()
                        .toString())) {
                    alertReason = "You didn't enter an effective date";
                } else if (!IntegrityCheck.amountFormat(amount.getText()
                        .toString())) {
                    alertReason = "Amount needs to be in the format #...#.##. Ex: 4.25";
                } else if (!IntegrityCheck.validDate(effectiveDate.getText()
                        .toString())) {
                    alertReason = "Date is not in the correct format. Correct format is yyyy-mm-dd";
                } else if (transactionManager.newDeposit(source.getText()
                        .toString(), Double.parseDouble(amount.getText()
                        .toString()), effectiveDate.getText().toString())) {
                    alertMessage = "Success";
                    alertReason = "Deposit added";
                } else {
                    // failure. probably due to network error.
                    alertReason = "Something's wrong";
                }
                AlertDialog newDepositAlert = new AlertDialog.Builder(
                        NewDeposit.this).create();
                newDepositAlert.setTitle(alertMessage);
                newDepositAlert.setMessage(alertReason);
                newDepositAlert.show();
                // if(source.getText().toString().matches("\\s*")) {
                // AlertDialog newDepositFailAlert = new
                // AlertDialog.Builder(NewDeposit.this).create();
                // newDepositFailAlert.setTitle("Deposit Failed");
                // newDepositFailAlert.setMessage("You didn't enter a source");
                // newDepositFailAlert.show();
                // } else if(amount.getText().toString().matches("\\s*")) {
                // AlertDialog newDepositFailAlert = new
                // AlertDialog.Builder(NewDeposit.this).create();
                // newDepositFailAlert.setTitle("Deposit Failed");
                // newDepositFailAlert.setMessage("You didn't enter an amount");
                // newDepositFailAlert.show();
                // } else if(effectiveDate.getText().toString().matches("\\s*"))
                // {
                // AlertDialog newDepositFailAlert = new
                // AlertDialog.Builder(NewDeposit.this).create();
                // newDepositFailAlert.setTitle("Deposit Failed");
                // newDepositFailAlert.setMessage("You didn't enter an effective date");
                // newDepositFailAlert.show();
                // } else
                // if(amount.getText().toString().matches("[0-9]{0,}.[0-9]{2}"))
                // {
                // //bug: entering 100 will fall into this block
                // AlertDialog newDepositFailAlert = new
                // AlertDialog.Builder(NewDeposit.this).create();
                // newDepositFailAlert.setTitle("Deposit Failed");
                // newDepositFailAlert.setMessage("Amount needs to be in the format #...#.##. Ex: 4.25");
                // newDepositFailAlert.show();
                // //this regex only checks for a valid format, doesn't make
                // sure it is actually a valid date
                // } else
                // if(effectiveDate.getText().toString().matches("[0-9]{2}\\\\/[0-9]{2}\\\\/[0-9]{4}"))
                // {
                // AlertDialog newDepositFailAlert = new
                // AlertDialog.Builder(NewDeposit.this).create();
                // newDepositFailAlert.setTitle("Deposit Failed");
                // newDepositFailAlert.setMessage("Date is not in the correct format. Correct format is yyyy-mm-dd");
                // newDepositFailAlert.show();
                // //success case
                // } else
                // if(transactionManager.newDeposit(source.getText().toString(),
                // Double.parseDouble(amount.getText().toString()),
                // effectiveDate.getText().toString())){
                // AlertDialog newDepositAlert = new
                // AlertDialog.Builder(NewDeposit.this).create();
                // newDepositAlert.setTitle("Success");
                // newDepositAlert.setMessage("Deposit added");
                // newDepositAlert.show();
                //
                // } else {
                // //failure. probably due to network error.
                // AlertDialog newDepositFailAlert = new
                // AlertDialog.Builder(NewDeposit.this).create();
                // newDepositFailAlert.setTitle("Deposit Failed");
                // newDepositFailAlert.setMessage("Something's wrong");
                // newDepositFailAlert.show();
                // }
            }
        });

        // this method handles the cancel button being clicked
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent goBackToNewTransaction = new Intent(
                        "android.intent.action.NEWTRANSACTION");
                startActivity(goBackToNewTransaction);
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
