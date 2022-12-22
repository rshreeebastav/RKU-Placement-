package com.example.rkuplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class liaison_officers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liaison_officers);
    }
    //Intent Activity
    public void back_liaison_home(View view) {
        Intent back_home_liaison = new Intent(liaison_officers.this, Home.class);
        startActivity(back_home_liaison);
    }
}