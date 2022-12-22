package com.example.rkuplace;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myapinotify {

    //For notify

    @GET("notificationretrieve.php")
    Call<ArrayList<Modelnotify>> callArralist();
}
