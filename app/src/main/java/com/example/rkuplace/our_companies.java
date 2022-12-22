package com.example.rkuplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class our_companies extends AppCompatActivity {

    //Initialization
    private MyAPi myAPi;
    private ArrayList<Model>modelArrayList;
    private  MyAdapter myAdapter;
    private ProgressDialog mDialog;
    private RecyclerView recyclerView;
    private ImageView btncompanies;
    SwipeRefreshLayout swipeRefreshLayout;
    private String BaseUrl = "https://rkuplacement.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_companies);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));
        mDialog= new ProgressDialog(this);
        recyclerView = findViewById(R.id.rv);
        swipeRefreshLayout =findViewById(R.id.swipe);
        modelArrayList = new ArrayList<>();
        viewJsonData();
        companyfunc();

    }

//viewJsonData Method
    private void viewJsonData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl ( BaseUrl )
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPi = retrofit.create(MyAPi.class);
        Call<ArrayList<Model>>modelarralist = myAPi.callArralist();
        modelarralist.enqueue(new Callback<ArrayList<Model>>() {
            @Override
            public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {
                mDialog.setMessage("Loading...");
                mDialog.show();
                modelArrayList = response.body();
                int i =0;
                for(i=0;i< modelArrayList.size();i++){
                    myAdapter = new MyAdapter(modelArrayList,our_companies.this);
                    LinearLayoutManager manager = new LinearLayoutManager(our_companies.this,RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(myAdapter);

                    swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {

                            swipeRefreshLayout.setRefreshing(false);
                            viewJsonData();
                        }
                    });
                }
                mDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ArrayList<Model>> call, Throwable t) {
                Toast.makeText(our_companies.this,"Network Error ! Please try again later.",Toast.LENGTH_SHORT).show();
            }
        });
    }



    //Company Function
    private void companyfunc() {
        btncompanies = findViewById(R.id.btncompanies);
        mDialog = new ProgressDialog(our_companies.this);
        mDialog.setMessage("Loading.....");
        mDialog.show();
    }

        public void apply_company(View view) {

        Intent edit_form = new Intent(our_companies.this, apply_company_form.class);
        startActivity(edit_form);


    }
}