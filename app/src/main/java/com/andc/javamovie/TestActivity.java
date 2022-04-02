package com.andc.javamovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TestActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bNavTest);

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

    }
}