package com.whereismymoney.activity;

import com.whereismymoney.R;
import com.whereismymoney.model.PasswordManager;
import com.whereismymoney.service.IntegrityCheck;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class handles the register page.
 */

public class Register extends Activity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private PasswordManager passwordManager;
    Button register, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
		// Turn off the window's title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        passwordManager = new PasswordManager();
        register = (Button) findViewById(R.id.button_register_confirm);

        // this method handles everything associated with the confirm
        // registration button
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EditText firstName = (EditText) findViewById(R.id.edit_text_register_first_name);
                EditText lastName = (EditText) findViewById(R.id.edit_text_register_last_name);
                EditText email = (EditText) findViewById(R.id.edit_text_register_email_address);
                EditText username = (EditText) findViewById(R.id.edit_text_register_username);
                EditText password = (EditText) findViewById(R.id.edit_text_register_password);
                EditText confirmPassword = (EditText) findViewById(R.id.edit_text_register_confirm_password);

                String failAlert = "Registration Failed";
                String failReason = null;
                if (!IntegrityCheck
                        .isInputValid(firstName.getText().toString())) {
                    failReason = "You didn't enter in a first name!";
                } else if (!IntegrityCheck.isInputValid(lastName.getText()
                        .toString())) {
                    failReason = "You didn't enter a last name!";
                } else if (!IntegrityCheck.checkEmail(email.getText()
                        .toString())) {
                    failReason = "Your email is in an incorrect format";
                } else if (!IntegrityCheck.isInputValid(username.getText()
                        .toString())) {
                    failReason = "You didn't enter a username!";
                } else if (!IntegrityCheck.checkPasswordLength(password
                        .getText().toString(), 7)) {
                    failReason = "Your password needs to be at least 7 characters";
                } else if (!IntegrityCheck.checkMatch(password.getText()
                        .toString(), confirmPassword.getText().toString())) {
                    failReason = "The password fields don't match";
                } else if (passwordManager.register(username.getText()
                        .toString(), firstName.getText().toString(), lastName
                        .getText().toString(), password.getText().toString(),
                        email.getText().toString())) {
                    Intent goToConfirmation = new Intent(
                            "android.intent.action.CONFIRMREGISTRATION");
                    startActivity(goToConfirmation);
                } else {
                    failReason = "Username Already Exists";
                }
                AlertDialog registerFailAlert = new AlertDialog.Builder(
                        Register.this).create();
                registerFailAlert.setTitle(failAlert);
                registerFailAlert.setMessage(failReason);
                registerFailAlert.show();
            }
        });
    }
}