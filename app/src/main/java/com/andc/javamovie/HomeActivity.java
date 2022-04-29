package com.andc.javamovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Button course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bNavHome);

        bottomNavigationView.setOnItemSelectedListener(item -> {
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
        course = findViewById(R.id.javacourse);
        course.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this,JavaCourse.class);
            startActivity(intent);
        });
    }
}