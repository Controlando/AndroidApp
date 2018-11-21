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

import com.example.acer.controlandoandroid.model.Meta;
import com.example.acer.controlandoandroid.service.SMeta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CadastroMetas extends AppCompatActivity {
    EditText metas_nome, metas_valor, metas_data;
    TextInputEditText metas_descricao;
    Button metas_canc, metas_conf;

    String token = null;


    //retrofit
    private static Meta mmeta;
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://200.0.0.9:3000/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    SMeta sMeta = retrofit.create(SMeta.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_metas);

        metas_nome = (EditText) findViewById(R.id.meta_nomemeta);
        metas_valor = (EditText) findViewById(R.id.meta_valormeta);
        metas_data = (EditText) findViewById(R.id.meta_datameta);
        metas_descricao = (TextInputEditText) findViewById(R.id.meta_descricaometa);
        metas_canc = (Button) findViewById(R.id.meta_btncancelar);
        metas_conf = (Button) findViewById(R.id.meta_btnconfirmar);

        metas_canc.setOnClickListener(voltar);
        metas_conf.setOnClickListener(cadastrar);
    }

    View.OnClickListener cadastrar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                if (metas_nome.getText().toString().trim().equalsIgnoreCase("")) {
                    metas_nome.requestFocus();
                } else {
                    if (metas_valor.getText().toString().trim().equalsIgnoreCase("")) {
                        metas_valor.requestFocus();
                    } else {
                        if (metas_data.getText().toString().trim().equalsIgnoreCase("")) {
                            metas_data.requestFocus();
                        } else {
                            if (metas_descricao.getText().toString().trim().equalsIgnoreCase("")) {
                                metas_descricao.requestFocus();
                            } else {
                                token = localDatabase();
                                cadastroMeta();
                            }
                        }
                    }
                }
            }
    };

    private void cadastroMeta() {
        //cadastro metas
        final Meta meta = new Meta(metas_nome.getText().toString(),metas_data.getText().toString(), metas_descricao.getText().toString(), Float.parseFloat(metas_valor.getText().toString()), 0);
        Call<Meta> call = sMeta.cadastroMeta(token,meta);
        call.enqueue(new Callback<Meta>() {
            public void onResponse(Call<Meta> call, Response<Meta> response) {
                if (response.isSuccessful()) {
                    mmeta = response.body();
                    startActivity(new Intent(getBaseContext(), TelaPrincipalActivity.class));
                } else {
                    Log.i("RETROFIT", response.message());
                    Toast.makeText(getBaseContext(), "Erro: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Meta> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Algo deu errado :(" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

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
        Log.i("Resultado rec - token: ", "2555");

        return tokenLocal;

    }

    View.OnClickListener voltar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(CadastroMetas.this, TelaPrincipalActivity.class);
            startActivity(it);
        }
    };

}
