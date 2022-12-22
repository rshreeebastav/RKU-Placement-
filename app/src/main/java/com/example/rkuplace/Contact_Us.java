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

public class Contact_Us extends AppCompatActivity {

    //Declaration
    Button btn;
    EditText Name,Email,Phone,Subject,Message;

    //Admin Website url
    String url = "https://rkuplacement.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        //Get the id from xml
        Name = (EditText) findViewById(R.id.Name);
        Email = (EditText) findViewById(R.id.Email);
        Phone = (EditText) findViewById(R.id.Phone);
        Subject = (EditText) findViewById(R.id.Subject);
        Message = (EditText) findViewById(R.id.Message);
        btn = (Button) findViewById(R.id.contact_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validation for Contact us
                String pass = Name.getText().toString().trim();
                String mEmail = Email.getText().toString().trim();
                String pass1 = Phone.getText().toString().trim();
                String sub = Subject.getText().toString().trim();
                String msg = Message.getText().toString().trim();

                if(TextUtils.isEmpty(pass)){
                    Name.setError("Required Field");
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
                    Subject.setError("Required Field");
                    return;
                }
                if(TextUtils.isEmpty(msg)){
                    Message.setError("Required Field");
                    return;
                }
                //Retrofit Method call
                process();
            }
        });
    }

    //Creating a Process method
    public void process(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl (url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        //Creating API class and Call the Model
        myapicontact api = retrofit.create(myapicontact.class);
        Call<Modelcontact> call = api.adddata(Name.getText().toString(),Email.getText().toString(), Phone.getText().toString(),Subject.getText().toString(),Message.getText().toString());
        call.enqueue(new Callback<Modelcontact>() {
            @Override

            //Success
            public void onResponse(Call<Modelcontact> call, Response<Modelcontact> response) {
                Name.setText("");
                Email.setText("");
                Phone.setText("");
                Subject.setText("");
                Message.setText("");
                Toast.makeText(Contact_Us.this,"Contact has been Successfully added.",Toast.LENGTH_SHORT).show();
            }
            //Fail
            @Override
            public void onFailure(Call<Modelcontact> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    //Intent Activity
    public void back_query_home(View view) {
        Intent back_home_query = new Intent(Contact_Us.this,Home.class);
        startActivity(back_home_query);
    }
}