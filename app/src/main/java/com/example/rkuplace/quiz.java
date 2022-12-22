package com.example.rkuplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class quiz extends AppCompatActivity {
    //Initialization
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        webView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Website URL
        webView.loadUrl("https://www.allindiaexams.in/online-test/online-aptitude-test/45");
    }


    //Intent Activity
    public void back_quiz_home(View view) {
        Intent back_home_quiz = new Intent(quiz.this,Home.class);
        startActivity(back_home_quiz);
    }
}