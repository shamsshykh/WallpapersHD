 package com.app24.www.wbwp.acitivty;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.app24.www.wbwp.R;

 public class Splash extends AppCompatActivity {

     private static final long SPLASH_TIME_OUT = 3000;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove status bar if the version is lower than Jellybean(16), use this line of code
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
         setContentView(R.layout.activity_splash);
         // postDelayed run after given time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,MainActivity.class));
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
