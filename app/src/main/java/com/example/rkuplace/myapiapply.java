package com.example.rkuplace;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface myapiapply {

    //For apply
    @FormUrlEncoded
    @POST("applystudent.php")
    Call<ModelApply> adddata(@Field("enrollmentno") String enrollmentno, @Field("name") String name, @Field("gender") String gender, @Field("dob") String dob

            , @Field("contact") String contact, @Field("email") String email , @Field("institute") String institute, @Field("course") String course

            , @Field("specialization") String specialization, @Field("cgpa") String cgpa , @Field("company_name") String company_name
    );


}
