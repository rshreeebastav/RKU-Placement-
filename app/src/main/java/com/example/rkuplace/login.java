package com.example.rkuplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    //Initialization
    private EditText email,password;
    TextView mCreateBtn,forgotTextLink;
    private Button btnlogin,btnregistration;
    private long pressedTime;
    //Declaration for authentication
    private FirebaseAuth mAuth;


    //Declaration for Progressbar
    private ProgressDialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Instance class-->To pass data
        mAuth=FirebaseAuth.getInstance();
        mDialog= new ProgressDialog(this);
        forgotTextLink = findViewById(R.id.fp);
        LoginFunction(); //Function Call
    }


    //Login Function
    private void LoginFunction(){
        email = findViewById(R.id.email_log);
        password = findViewById(R.id.password_log);
        btnlogin = findViewById(R.id.btn_log);
        btnregistration = findViewById(R.id.btn_reg);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validation for login
                String mEmail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if (TextUtils.isEmpty(mEmail)){
                    email.setError("Required Field");
                    return;
                }

                if(TextUtils.isEmpty(pass)){
                    password.setError("Required Field");
                    return;
                }

                if(password.length() < 8){
                    password.setError("Password Must be 8 characters");
                    return;
                }

                //Progress Bar
                mDialog.setMessage("Processing...");
                mDialog.show();

            //Authentication
                mAuth.signInWithEmailAndPassword(mEmail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                            SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putBoolean("flag",true);
                            editor.apply();
                            startActivity(new Intent(getApplicationContext(),Home.class));

                            mDialog.dismiss();
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(),"Network Error . Please check your email and password !",Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                        }
                    }
                });

//                Intent iHome = new Intent(login.this,MainActivity.class);
//                startActivity(iHome);
            }
        });

        btnregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });



        //Forgot Password

        forgotTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText resetMail = new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("Reset Password?");
                passwordResetDialog.setMessage("Enter your email to received reset link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        startActivity(new Intent(getApplicationContext(),login.class));
                        String mail = resetMail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(login.this,"Reset Link Sent To your Email.",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(login.this,"Error ! Reset Link is not Sent To your Email." + e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
                passwordResetDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                });
                passwordResetDialog.create().show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure want to exit?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }
}