package com.example.rkuplace;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface myapicontact {

    //For contact
    @FormUrlEncoded
    @POST("contact.php")
    Call<Modelcontact> adddata(@Field("Name") String Name, @Field("Email") String Email, @Field("Phone") String Phone, @Field("Subject") String Subject, @Field("Message") String Message);


}

