package com.example.rkuplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class registration extends AppCompatActivity {
    public static final String TAG1 = "TAG";
    public static final String TAG = "TAG";
    private EditText emailreg;
    private EditText passreg;
    private EditText fullname;
    private EditText cp;
    private CheckBox cb;
    private Button btnregister;
    private Button btnlogin;
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;
    FirebaseFirestore fstore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
//        getSupportActionBar().setTitle("Create account");
        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);
        fstore = FirebaseFirestore.getInstance();
        Registration();
    }
    private void Registration(){
        emailreg = findViewById(R.id.email_reg);
        passreg = findViewById(R.id.password_reg);
        fullname = findViewById(R.id.fn);
        btnlogin = findViewById(R.id.btn_login);
        btnregister = findViewById(R.id.btn_reg);
       cb = findViewById(R.id.checkBox);
       cp =findViewById(R.id.cp1);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailreg.getText().toString().trim();
                String password = passreg.getText().toString().trim();
                String cpassword = cp.getText().toString().trim();
                String c = cb.getText().toString().trim();
                String FN = fullname.getText().toString();
                if (TextUtils.isEmpty(FN)){
                    fullname.setError("Required Field");

                    return;
                }
                if (TextUtils.isEmpty(email)){
                    emailreg.setError("Required Field");

                    return;
                }

                if (TextUtils.isEmpty(password)){
                    passreg.setError("Required Field");

                    return;
                }
                if(password.length() < 8){
                    passreg.setError("Password Must be 8 characters");
                    return;
                }
                if(!password.equals(cpassword)){
                    cp.setError("Password would not be matched.");
                    return;

                }

                if(!cb.isChecked()){
                    cb.setError("Required ");
                    Toast.makeText(getApplicationContext(),"Please check this box",Toast.LENGTH_SHORT).show();
                    return;
                }


                mDialog.setMessage("Processing..");
                mDialog.show();
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Register Successful",Toast.LENGTH_SHORT).show();
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName",FN);
                            user.put("email",email);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG, "onSuccess: user profile is created for "+ userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG1, "onFailure: " + e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),login.class));
                            mDialog.dismiss();
                        }else{
                            Toast.makeText(getApplicationContext(),"Registration Failed ! Please try aian later",Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();


                        }
                    }
                });

            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });
    }
}
