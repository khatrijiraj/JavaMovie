package com.andc.javamovie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
Button logout;
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        logout= findViewById(R.id.logoutButton);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bNavProfile);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.bNavHome) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (itemId == R.id.bNavWebview) {
                startActivity(new Intent(getApplicationContext(), CompilerActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (itemId == R.id.bNavTest) {
                startActivity(new Intent(getApplicationContext(), TestActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (itemId == R.id.bNavProfile) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                overridePendingTransition(0, 0);
            }
            return false;
        });

        logout.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("flag", false);
            editor.apply();

            Intent iLogOut;
            iLogOut = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(iLogOut);
        });
    }
}