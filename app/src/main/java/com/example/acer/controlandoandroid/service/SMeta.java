package com.example.acer.controlandoandroid.service;

import com.example.acer.controlandoandroid.model.Meta;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SMeta {
    @POST("meta/cadastroMeta")
    Call<Meta> cadastroMeta(@Header( "token" ) String token,@Body Meta meta);
}
