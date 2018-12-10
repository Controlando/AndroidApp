package com.example.acer.controlandoandroid.service;

import com.example.acer.controlandoandroid.model.Receita;
import com.example.acer.controlandoandroid.model.ReceitaAux;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface SReceita {
    @POST("receita/cadastroReceita")
    Call<Receita> cadastroReceita(@Header( "token" ) String token, @Body Receita receita);

    @GET("receita/listaReceita")
    Call<List<ReceitaAux>> listarReceita(@Header( "token" ) String token);

    @GET("receita/getReceita")
    Call<ReceitaAux> getReceita(@Header( "token" ) String token, @Header("id") int id );

    @PUT("receita/alterarReceita")
    Call<ReceitaAux> alterarReceita(@Header( "token" ) String token, @Body ReceitaAux receita ); //VERIFICAR ISSO

    @DELETE("receita/deletarReceita ")
    Call<JSONObject> deletarReceita(@Header( "token" ) String token, @Header("id") int id); //VERIFICAR ISSO

    @GET("receita/getSaldo")
    Call<String> getSaldo(@Header( "token" ) String token);

}
