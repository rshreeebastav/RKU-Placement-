package com.example.rkuplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Study_Material extends AppCompatActivity {

    //Initialization
    private WebView mywebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_material);

        mywebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Website URL
        mywebView.loadUrl("https://www.indiabix.com/");
    }

    //Intent Activity
    public void back_study_home(View view) {
        Intent back_home_study = new Intent(Study_Material.this, Home.class);
        startActivity(back_home_study);
    }
}