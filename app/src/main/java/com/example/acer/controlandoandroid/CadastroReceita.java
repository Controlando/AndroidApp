package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.acer.controlandoandroid.model.Receita;
import com.example.acer.controlandoandroid.service.SReceita;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CadastroReceita extends AppCompatActivity {
    EditText receita_nome, receita_valor, receita_data;
    TextInputEditText receita_descricao;
    Button receita_canc, receita_conf;
    String token = null;


    //retrofit
    private static Receita rreceita;
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://200.0.0.9:3000/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    SReceita sReceita = retrofit.create(SReceita.class);

    //onclick-funçoes
    View.OnClickListener cadastrar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (receita_nome.getText().toString().trim().equalsIgnoreCase("")) {
                receita_nome.requestFocus();
            } else {
                if (receita_valor.getText().toString().trim().equalsIgnoreCase("")) {
                    receita_valor.requestFocus();
                } else {
                    if (receita_data.getText().toString().trim().equalsIgnoreCase("")) {
                        receita_data.requestFocus();
                    } else {
                        if (receita_descricao.getText().toString().trim().equalsIgnoreCase("")) {
                            receita_descricao.requestFocus();
                        } else {
                            token = localDatabase();
                            cadastroReceita();
                        }
                    }
                }
            }
        }

    };

        private void cadastroReceita() {
            //cadastro receitas
            final Receita receita = new Receita(receita_nome.getText().toString(), receita_descricao.getText().toString(), receita_data.getText().toString(), Float.parseFloat(receita_valor.getText().toString()));
            Call<Receita> call = sReceita.cadastroReceita(token,receita);
            call.enqueue(new Callback<Receita>() {
                public void onResponse(Call<Receita> call, Response<Receita> response) {
                    if (response.isSuccessful()) {
                        rreceita = response.body();
                        startActivity(new Intent(getBaseContext(), TelaPrincipalActivity.class));
                    } else {
                        Log.i("RETROFIT", response.message());
                        Toast.makeText(getBaseContext(), "Erro: " + response.message(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Receita> call, Throwable t) {
                    Toast.makeText(getBaseContext(), "Algo deu errado :(" + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

        View.OnClickListener voltar = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CadastroReceita.this, TelaPrincipalActivity.class);
                startActivity(it);
            }
        };


    private String localDatabase() {
        String tokenLocal = null;
        try {
            SQLiteDatabase bancoUser = openOrCreateDatabase("app", MODE_PRIVATE, null);
            Cursor cursor = bancoUser.rawQuery("SELECT * FROM usuario", null);
            int indiceColunaToken = cursor.getColumnIndex("token");
            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - token: ", cursor.getString(indiceColunaToken));
                tokenLocal = cursor.getString(indiceColunaToken);
                cursor.moveToNext();
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        Log.i("Resultado rec - token: ", tokenLocal);

        return tokenLocal;

    }


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_receita);

            receita_nome = (EditText) findViewById(R.id.receita_nomereceita);
            receita_valor = (EditText) findViewById(R.id.receita_valordespesa);
            receita_data = (EditText) findViewById(R.id.receita_datareceita);
            receita_descricao = (TextInputEditText) findViewById(R.id.receita_descricaoreceita);
            receita_canc = (Button) findViewById(R.id.receita_btncancelar);
            receita_conf = (Button) findViewById(R.id.receita_btnconfirmar);

            receita_canc.setOnClickListener(voltar);
            receita_conf.setOnClickListener(cadastrar);
        }


    }

