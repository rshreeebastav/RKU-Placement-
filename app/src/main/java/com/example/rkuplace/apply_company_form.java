package com.example.rkuplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class apply_company_form extends AppCompatActivity {
   // Initialization checkbox
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_company_form);
        cb = findViewById(R.id.terms_verify);
    }




    //Edit_form Method
    public void edit_form1(View view) {

        //Validation for apply form
        String c = cb.getText().toString().trim();
        if(!cb.isChecked()){
            cb.setError("Required ");
            Toast.makeText(getApplicationContext(),"Please check this box to accept terms and conditions.",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent edit_form = new Intent(apply_company_form.this, applyform.class);
        startActivity(edit_form);
    }

    //Intent activity
    public void back_apply_home(View view) {
        Intent back_home_apply = new Intent(apply_company_form.this, Home.class);
        startActivity(back_home_apply);
    }
}