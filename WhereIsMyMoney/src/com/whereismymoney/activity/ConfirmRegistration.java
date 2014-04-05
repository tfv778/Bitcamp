package com.whereismymoney.activity;

/**
 * This class handles the registration screen that new users go to
 * right after they have registered. It includes buttons that 
 * take then to register another account or to the login page.
 */

import com.whereismymoney.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ConfirmRegistration extends Activity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
		// Turn off the window's title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_registration);

        Button login = (Button) findViewById(R.id.button_goToLoginFromConfirmRegistration);

        // the button that sends the user to the login page
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent goToLogin = new Intent("android.intent.action.LOGIN");
                startActivity(goToLogin);
            }
        });
    }
}