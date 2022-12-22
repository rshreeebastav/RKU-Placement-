package com.example.rkuplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.splashscreen.SplashScreen;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
//import android.hardware.biometrics.BiometricPrompt;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.biometric.BiometricPrompt;

import com.application.isradeleon.notify.Notify;

import java.util.concurrent.Executor;

public class terms_conditions extends AppCompatActivity {

    //Initilization
    private CheckBox cb;

    //Biometric Initialization
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    ScrollView mMainLayout;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);

        cb = findViewById(R.id.terms_verify);

        //For Push Notification
        Notify.build(getApplicationContext())

                .setTitle("RKU Placement")
                .setContent("Remainder Please once go to notification")
                .setSmallIcon(R.drawable.ic_notifications_none_white_24dp)

//                .setLargeIcon("https://as1.ftcdn.net/v2/jpg/04/93/13/36/1000_F_493133696_rQhDX4XDc2WADMWTDJ9utLMXSg23RrQH.jpg")
                .largeCircularIcon()
                .setPicture(R.drawable.cmpnotify)
                .setColor(R.color.colorPrimary)
                .setImportance(Notify.NotifyImportance.HIGH)
                .setVibrationPattern(new long[]{100,1000,200,340})
                .enableVibration(true)
                .show();


        mMainLayout = findViewById(R.id.main_layout);


        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()){
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(),"Device Doesn't have fingerprint",Toast.LENGTH_SHORT).show();

            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(),"Not working",Toast.LENGTH_SHORT).show();

            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getApplicationContext(),"No fingerprint assigned",Toast.LENGTH_SHORT).show();

        }

        Executor executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(terms_conditions.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                startActivity(new Intent(getApplicationContext(),terms_conditions.class));
                Toast.makeText(getApplicationContext(),"Please use fingerprint",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
//                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                mMainLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAuthenticationFailed() {

                super.onAuthenticationFailed();

            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("RKU Placement")
                .setDescription("Use fingerprint").setDeviceCredentialAllowed(true).build();
        biometricPrompt.authenticate(promptInfo);




    }

    public void entry_login(View view) {
//Validation for entry login
        String c = cb.getText().toString().trim();
        if(!cb.isChecked()){
            cb.setError("Required ");
            Toast.makeText(getApplicationContext(),"Please check this box to accept terms and conditions.",Toast.LENGTH_SHORT).show();
            return;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                Boolean check = pref.getBoolean("flag", false);
                Intent iNext;
                if (check) {
                    iNext = new Intent(terms_conditions.this, Home.class);

                } else {
                    iNext = new Intent(terms_conditions.this, login.class);
                }

                startActivity(iNext);
            }
        },200);


    }
    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

}