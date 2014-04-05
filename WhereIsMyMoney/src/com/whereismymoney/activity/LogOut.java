package com.whereismymoney.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.whereismymoney.R;

public class LogOut extends Activity {	
	Button home;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// Turn off the window's title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		home = (Button) findViewById(R.id.button_log_out_home);
		
		home.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent goToLogin = new Intent("android.intent.action.LOGIN");
				startActivity(goToLogin);
				}
		});
	}
	
	@Override
    public void onBackPressed() {
		Intent goToLogin = new Intent("android.intent.action.LOGIN");
		startActivity(goToLogin);
    }
}

