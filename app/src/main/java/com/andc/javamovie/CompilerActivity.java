package com.andc.javamovie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CompilerActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private WebView webView;
    ProgressBar progressBar;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compiler);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bNavWebview);

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
        progressBar = findViewById(R.id.progressBar);
        webView = findViewById(R.id.compilerWebview);
        webView.loadUrl("https://www.mycompiler.io/new/java");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}