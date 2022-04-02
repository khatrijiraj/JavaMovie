package com.andc.javamovie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
            boolean check = sharedPreferences.getBoolean("flag", false);
            Intent iLogin;
            if (check) {
                iLogin = new Intent(SplashActivity.this, HomeActivity.class);

            } else {
                iLogin = new Intent(SplashActivity.this, MainActivity.class);
            }
            startActivity(iLogin);
            finish();
        }, 3000);
    }
}