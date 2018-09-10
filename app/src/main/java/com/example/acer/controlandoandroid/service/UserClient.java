package com.example.acer.controlandoandroid.service;

import com.example.acer.controlandoandroid.model.Login;
import com.example.acer.controlandoandroid.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface UserClient {
    @POST("login")
    Call<User> login(@Body Login login);

    @POST("cadastro")
    Call<User> cadastro(@Body User user);
    @GET("me")
    Call<ResponseBody> getSecret(@Header("x-access-token") String token);
}