package com.example.rkuplace;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface myapicomplaint {

    //For Complaint
    @FormUrlEncoded
    @POST("complaints.php")
    Call<Modelcomplaint> adddata(@Field("FullName") String FullName,@Field("Email") String Email,@Field("Phone") String Phone,@Field("Description") String Description);


}
