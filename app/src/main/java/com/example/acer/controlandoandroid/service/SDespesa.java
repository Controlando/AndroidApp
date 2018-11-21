package com.example.acer.controlandoandroid.service;

import com.example.acer.controlandoandroid.model.Despesa;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Header;

public interface SDespesa {
    @POST("despesa/cadastroDespesa")
    Call<Despesa> cadastroDespesa(@Header( "token" ) String token, @Body Despesa despesa);
}

