package com.example.rkuplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Complaints extends AppCompatActivity {

    //Initialization
    Button btn;
    EditText FullName,Email,Phone,Description;


    //Admin Website Url
    String url = "https://rkuplacement.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints);

        FullName = (EditText) findViewById(R.id.FullName);
        Email = (EditText) findViewById(R.id.Email);
        Phone = (EditText) findViewById(R.id.Phone);
        Description = (EditText) findViewById(R.id.Description);
        btn = (Button) findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //Validation for Complaints
                String pass = FullName.getText().toString().trim();
                String mEmail = Email.getText().toString().trim();
                String pass1 = Phone.getText().toString().trim();
                String sub = Description.getText().toString().trim();

                if(TextUtils.isEmpty(pass)){
                    FullName.setError("Required Field");
                    return;
                }
                if (TextUtils.isEmpty(mEmail)){
                    Email.setError("Required Field");
                    return;
                }
                if(TextUtils.isEmpty(pass1)){
                    Phone.setError("Required Field");
                    return;
                }

                if (TextUtils.isEmpty(sub)){
                    Description.setError("Required Field");
                    return;
                }

                //Retrofit Method call
                process();
            }
        });
    }

    //Creating a method
    public void process(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl (url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();




        //Creating API class and Call the Model

        myapicomplaint api = retrofit.create(myapicomplaint.class);
        Call<Modelcomplaint> call = api.adddata(FullName.getText().toString(),Email.getText().toString(), Phone.getText().toString(),Description.getText().toString());
        call.enqueue(new Callback<Modelcomplaint>() {
            @Override
            public void onResponse(Call<Modelcomplaint> call, Response<Modelcomplaint> response) {
                FullName.setText("");
                Email.setText("");
                Phone.setText("");
                Description.setText("");
                Toast.makeText(Complaints.this,"Complaint has been Successfully added.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Modelcomplaint> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    //Intent actitivty to go back home
    public void back_complaints_home(View view) {
        Intent back_home_complaints = new Intent(Complaints.this, Home.class);
        startActivity(back_home_complaints);
    }
}