package com.whereismymoney.activity;

import com.whereismymoney.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * The welcome page. The user can choose to login or register from here
 */

public class Welcome extends Activity {
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
		// Turn off the window's title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.button_login_login);
        register = (Button) findViewById(R.id.button_login_register);

        // jump to login page on click
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent goToLogin = new Intent("android.intent.action.LOGIN");
                startActivity(goToLogin);
            }
        });

        // jump to register page on click
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegister = new Intent(
                        "android.intent.action.REGISTER");
                startActivity(goToRegister);
            }
        });
    }
}
