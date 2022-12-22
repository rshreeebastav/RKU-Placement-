package com.example.rkuplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }




    //Method creation for social Method (Clickable)

    //Facebook
    public void facebook(View view)
    {

        Uri uri = Uri.parse(String.format("https://www.facebook.com/rkuindia"));
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(uri);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }



    //Google
    public void google(View view)
    {
        Uri uri1 = Uri.parse(String.format("https://rku.ac.in/about-training-and-placement"));
        Intent intent2 = new Intent(Intent.ACTION_VIEW);
        intent2.setData(uri1);
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent2);
    }



    //Linkedin
    public void linked(View view)
    {
        Uri uri4 = Uri.parse(String.format("https://www.linkedin.com/school/rkuniversity/"));
        Intent intent4 = new Intent(Intent.ACTION_VIEW);
        intent4.setData(uri4);
        intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent4);
    }



    //Twitter
    public void twitter(View view)
    {
        Uri uri3 = Uri.parse(String.format("https://twitter.com/RKUniversity"));
        Intent intent3 = new Intent(Intent.ACTION_VIEW);
        intent3.setData(uri3);
        intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent3);
    }



    //Our Developers Profile
    public void aman(View view)
    {
        Uri uri = Uri.parse(String.format("https://www.linkedin.com/in/aman-verma-198472219/"));
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(uri);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }



    public void rahul(View view)
    {
        Uri uri = Uri.parse(String.format("https://www.linkedin.com/in/rahul-shreebastav-832210205/"));
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(uri);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }




    public void nikhil(View view)
    {
        Uri uri = Uri.parse(String.format("https://www.linkedin.com/in/nikhil-mallik-24265a193/"));
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(uri);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }




    public void moni(View view)
    {
        Uri uri = Uri.parse(String.format("https://www.linkedin.com/in/moni-singh-161839231/"));
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(uri);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
    }



    //Intent Activity To go back

    public void back_about_home(View view)
    {
        Intent back_home_about = new Intent(About.this, Home.class);
        startActivity(back_home_about);
    }
}