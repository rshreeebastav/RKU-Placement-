package com.example.rkuplace;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class applyform extends AppCompatActivity {
    //Declaration

    private CheckBox cb;
    private ProgressDialog mDialog;
    Button submit_form,buttonfetch;
    Dialog dialog;
    EditText editTextvalue,editt;

    //For Refresh
    SwipeRefreshLayout swipeRefreshLayout;

    TextView enrollmentnotv,nametv,gendertv,dobtv,contacttv,emailtv,institutetv,coursetv,specializationtv,cgpatv;
//    TextView nametv;
//    TextView gendertv;
//    TextView dobtv;
//    TextView contacttv;
//    TextView emailtv;
//    TextView institutetv;
//    TextView coursetv;
//    TextView specializationtv;
//    TextView cgpatv;



    TextView enrollmentno,name,gender,dob,email	,contact,institute,course,specialization,cgpa;
    EditText company_name;

    //Admin url
    String url = "https://rkuplacement.000webhostapp.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        mDialog= new ProgressDialog(this);
        cb = findViewById(R.id.edit_form_checkbox);
        editTextvalue = findViewById(R.id.etvalue);
        company_name = (EditText) findViewById(R.id.company_name);
        submit_form = findViewById(R.id.submit_form);
        dialog = new Dialog(this);
        enrollmentnotv =(TextView)findViewById(R.id.enrollmentno);


        submit_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validation for Applyform

                String c = cb.getText().toString().trim();
                String en = enrollmentnotv.getText().toString().trim();
                String mEmail = editTextvalue.getText().toString().trim();

                String companyname = company_name.getText().toString().trim();

                if(!cb.isChecked()){
                    cb.setError("Required ");
                    Toast.makeText(getApplicationContext(),"Please check this box",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(en)){
                    enrollmentnotv.setError("Required Field");
                    return;
                }

                if (TextUtils.isEmpty(companyname)){
                    company_name.setError("Required Field");
                    return;
                }

                //Method Call
                process();
                openSubmitDialog();

            }
        });

       //To retrieve data
        enrollmentnotv =(TextView)findViewById(R.id.enrollmentno);
        nametv =(TextView)findViewById(R.id.name);
       gendertv =(TextView)findViewById(R.id.gender);
        dobtv =(TextView)findViewById(R.id.dob);
        contacttv =(TextView)findViewById(R.id.contact);
        emailtv =(TextView)findViewById(R.id.email);
        institutetv=(TextView)findViewById(R.id.institute);
        coursetv =(TextView)findViewById(R.id.course);
        specializationtv =(TextView)findViewById(R.id.specialization);
        cgpatv =(TextView)findViewById(R.id.cgpa);
        editTextvalue = (EditText)findViewById(R.id.etvalue);
        buttonfetch = (Button)findViewById(R.id.buttonfetchdata);

        //TO insertion data
        enrollmentno =(TextView)findViewById(R.id.enrollmentno);
        name =(TextView)findViewById(R.id.name);
        gender =(TextView)findViewById(R.id.gender);
        dob =(TextView)findViewById(R.id.dob);
        contact =(TextView)findViewById(R.id.contact);
        email =(TextView)findViewById(R.id.email);
        institute=(TextView)findViewById(R.id.institute);
        course =(TextView)findViewById(R.id.course);
        specialization =(TextView)findViewById(R.id.specialization);
        cgpa =(TextView)findViewById(R.id.cgpa);
        company_name = (EditText) findViewById(R.id.company_name);
        buttonfetch.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

        //Method Call
            getData();


        }
    });


}

    //Method Creation
    private void getData() {
    //Validation
        String pass = editTextvalue.getText().toString().trim();
        String id = editTextvalue.getText().toString().trim();
        if(TextUtils.isEmpty(pass)){
            editTextvalue.setError("Required Field");

        }
        if(editTextvalue.length() < 12){
            editTextvalue.setError("Enrollment Must be 12 characters");
            return;
        }

        //Check the condtion
        if (id.equals("")) {

            Toast.makeText(this, "Check Detail!", Toast.LENGTH_LONG).show();
            return;
        }


        //Progress bar
        mDialog.setTitle("Loading");
        mDialog.setMessage("Please wait...");
        mDialog.show();



        //Get the data and fetch into the textview
        String url = Config.DATA_URL + editTextvalue.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                showJSONS(response);
                mDialog.dismiss();

            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
       Toast.makeText(applyform.this,"Network error.",Toast.LENGTH_SHORT).show();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void showJSONS(String response) {
        String id = "";
        String name = "";
        String gender = "";
        String dob = "";
        String email = "";
        String phone = "";
        String iname = "";
        String coursename = "";
        String branch = "";
        String cgpa = "";


        //File handling

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            id = collegeData.getString(Config.KEY_ENROLL);
            name = collegeData.getString(Config.KEY_NAME);
            gender = collegeData.getString(Config.KEY_GENDER);
            dob = collegeData.getString(Config.KEY_DOB);
            email = collegeData.getString(Config.KEY_EMAIL);
            phone = collegeData.getString(Config.KEY_PHONE);
            iname = collegeData.getString(Config.KEY_INAME);
            coursename = collegeData.getString(Config.KEY_COURSENAME);
            branch = collegeData.getString(Config.KEY_BRANCH);
            cgpa = collegeData.getString(Config.KEY_CGPA);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        enrollmentnotv.setText("" + id);
        nametv.setText("" + name);
        gendertv.setText("" + gender);
        dobtv.setText("" + dob);
        emailtv.setText("" + email);
        contacttv.setText("" + phone);
        institutetv.setText("" + iname);
        coursetv.setText("" + coursename);
        specializationtv.setText("" + branch);
        cgpatv.setText("" + cgpa);

    }

    private void openSubmitDialog() {
        dialog.setContentView(R.layout.apply_form_terms_condition_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button button = dialog.findViewById(R.id.okButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(applyform.this,"Thankyou for apply.",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    //Process method creation

    public void process(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl (url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myapiapply api = retrofit.create(myapiapply.class);
        Call<ModelApply> call = api.adddata(enrollmentno.getText().toString(),name.getText().toString(), gender.getText().toString(),dob.getText().toString(),contact.getText().toString(),email.getText().toString(),

                institute.getText().toString(),course.getText().toString(),

                specialization.getText().toString(),cgpa.getText().toString(),company_name.getText().toString() );
        call.enqueue(new Callback<ModelApply>() {
            @Override
            public void onResponse(Call<ModelApply> call, retrofit2.Response<ModelApply> response) {
                enrollmentno.setText("");
                name.setText("");
                gender.setText("");
                dob.setText("");
                contact.setText("");
                email.setText("");
                institute.setText("");
                course.setText("");
                specialization.setText("");
                cgpa.setText("");
                company_name.setText("");
                Toast.makeText(applyform.this,"Contact has been Successfully added.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModelApply> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

//Intent Activity
    public void back_editform_home(View view) {
        Intent back_home_applyform = new Intent(applyform.this, apply_company_form.class);
        startActivity(back_home_applyform);
    }
}