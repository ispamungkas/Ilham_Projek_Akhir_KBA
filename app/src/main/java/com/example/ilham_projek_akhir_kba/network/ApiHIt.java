package com.example.ilham_projek_akhir_kba.network;

import com.example.ilham_projek_akhir_kba.models.event.ResponseEvent;
import com.example.ilham_projek_akhir_kba.models.login.ResponseLogin;
import com.example.ilham_projek_akhir_kba.models.register.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiHIt {

    @GET("getEventHimti")
    Call<ResponseEvent> getEvent();

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> requestLogin(
            @Field("email")
            String email,
            @Field("password")
            String password
    );

    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> requestRegister(
            @Field("username")
            String username,
            @Field("email")
            String email,
            @Field("password")
            String password
    );

}
