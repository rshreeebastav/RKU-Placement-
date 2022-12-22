package com.example.rkuplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class Payment extends AppCompatActivity {

    // UPI PAYMENT MOETHOD

    EditText amount,note,name,upi;
    Button pay;
    String TAG="main";
    final int UPI_PAYMENT = 0;

    //COMPLETE UPI PAYMENT METHOD


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // UPI PAYMENT MOETHOD

        pay = (Button) findViewById(R.id.pay);
        amount = (EditText) findViewById(R.id.amount);
        note = (EditText) findViewById(R.id.note);
        name = (EditText) findViewById(R.id.name);
        upi = (EditText) findViewById(R.id.upi);

        //Validation
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText().toString().trim())){
                    Toast.makeText(Payment.this,"Name is Invalid...",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(amount.getText().toString().trim())){
                    Toast.makeText(Payment.this,"Amount is Invalid...",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(upi.getText().toString().trim())){
                    Toast.makeText(Payment.this,"UPI ID is Invalid...",Toast.LENGTH_SHORT).show();
                }
                payUsingUpi("Aman Verma",
                        "", note.getText().toString(), amount.getText().toString());
            }
        });

        //COMPLETE UPI PAYMENT METHOD
    }

    private void payUsingUpi(String upi_name, String upi_id, String note, String amount) {
        Log.e("main","name "+name +"--up--"+UPI_PAYMENT+"--"+ note+"--"+amount);
        Uri uri =
                new Uri.Builder()
                        .scheme("upi")
                        .authority("pay")
                        .appendQueryParameter("pa", String.valueOf(upi))
                        .appendQueryParameter("pn", String.valueOf(name))
                        .appendQueryParameter("tn", note)
                        .appendQueryParameter("am", amount)
                        .appendQueryParameter("cu", "INR")
                        .build();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
    }

    public void back_payment_home(View view) {
        Intent back_home_payment = new Intent(Payment.this, Home.class);
        startActivity(back_home_payment);
    }
}