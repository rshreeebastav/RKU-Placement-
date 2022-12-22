package com.example.rkuplace;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPi {

    //For company retrive data
    @GET("retrieve.php")
    Call<ArrayList<Model>>callArralist();

}
