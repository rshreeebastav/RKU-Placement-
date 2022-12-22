package com.example.rkuplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Prominent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

    }

    //Intent Activity

    public void back_department_home(View view) {
        Intent back_home_department = new Intent(Prominent.this, Home.class);
        startActivity(back_home_department);
    }
}