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

public class notification extends AppCompatActivity {
    //Initialization
    private myapinotify myAPi;
    private ArrayList<Modelnotify>modelArrayList;
    private  MyAdapternotify myAdapter;
    private RecyclerView recyclerView;
    private ImageView btncompanies1;
    private ProgressDialog mDialog1;
    SwipeRefreshLayout swipeRefreshLayout;

    private String BaseUrl = "https://rkuplacement.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange)));
        recyclerView = findViewById(R.id.rv);
        swipeRefreshLayout =findViewById(R.id.swipe);
        modelArrayList = new ArrayList<>();
        viewJsonData();
        notifyfunc();
    }

//Method creation for calling retrofit

    private void viewJsonData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl ( BaseUrl )
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPi = retrofit.create(myapinotify.class);
        Call<ArrayList<Modelnotify>>modelarralist = myAPi.callArralist();
        modelarralist.enqueue(new Callback<ArrayList<Modelnotify>>() {
            @Override
            public void onResponse(Call<ArrayList<Modelnotify>> call, Response<ArrayList<Modelnotify>> response) {
                modelArrayList = response.body();
                int i =0;
                for(i=0;i< modelArrayList.size();i++){
                    myAdapter = new MyAdapternotify (modelArrayList,notification.this);
                    LinearLayoutManager manager = new LinearLayoutManager(notification.this,RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(myAdapter);
                }
                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

//                             myAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                        viewJsonData();
                    }
                });

                mDialog1.dismiss();
            }


            @Override
            public void onFailure(Call<ArrayList<Modelnotify>> call, Throwable t) {
                Toast.makeText(notification.this,"Network Error ! Please try again later.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Notification Function
    private void notifyfunc() {
        btncompanies1 = findViewById(R.id.btncompanies1);
        mDialog1 = new ProgressDialog(notification.this);
        mDialog1.setMessage("Loading.....");
        mDialog1.show();


    }


}