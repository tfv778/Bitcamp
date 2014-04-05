package com.whereismymoney.activity;

import com.whereismymoney.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * first activity of the program, which shows a starting picture and plays a
 * starting sound.
 */
public class Main extends Activity {
    MediaPlayer startingSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
		// Turn off the window's title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // play the starting song
        startingSong = MediaPlayer.create(Main.this, R.raw.startingsound);
        startingSong.start();

        // displaying the starting picture for 3000 ms
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openMain = new Intent("android.intent.action.LOGIN");
                    startActivity(openMain);
                }
            }
        };
        timer.start();
    }

    // release the MediaPlayer resources on pause
    @Override
    protected void onPause() {
        super.onPause();
        startingSong.release();
        finish();
    }
}
