package com.example.acer.controlandoandroid.service;

import com.example.acer.controlandoandroid.model.Receita;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SReceita {
    @POST("receita/cadastroReceita")
    Call<Receita> cadastroReceita(@Header( "token" ) String token, @Body Receita receita);
}
