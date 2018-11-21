package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.acer.controlandoandroid.model.Despesa;
import com.example.acer.controlandoandroid.service.SDespesa;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CadastroDespesa extends AppCompatActivity {
    EditText despesa_nome, despesa_valor, despesa_data;
    TextInputEditText despesa_descricao;
    Button despesa_canc, despesa_conf;
    Spinner spinner;
    RadioButton despesa_rbdiario, despesa_rbsemanal, despesa_rbmensal, despesa_rbunica;
    RadioGroup geral_rb;
    int posicao;
    //retrofit
    private static Despesa ddespesa;
    String token = null;
    String periodo;

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://200.0.0.9:3000/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    SDespesa sDespesa = retrofit.create(SDespesa.class);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_despesa);

        despesa_nome = (EditText) findViewById(R.id.despesa_nomedespesa);
        despesa_valor = (EditText) findViewById(R.id.despesa_valordespesa);
        despesa_data = (EditText) findViewById(R.id.despesa_datadespesa);
        despesa_descricao = (TextInputEditText) findViewById(R.id.despesa_descricaodespesa);

        despesa_rbdiario = (RadioButton) findViewById(R.id.despesa_rbdiario);
        despesa_rbsemanal = (RadioButton) findViewById(R.id.despesa_rbsemanal);
        despesa_rbmensal = (RadioButton) findViewById(R.id.despesa_rbmensal);
        despesa_rbunica = (RadioButton) findViewById(R.id.despesa_rbunica);

        geral_rb = (RadioGroup) findViewById(R.id.geral_rb);


        spinner = (Spinner) findViewById(R.id.spinner);

        despesa_canc = (Button) findViewById(R.id.despesa_btncancelar);
        despesa_conf = (Button) findViewById(R.id.despesa_btnconfirmar);


        despesa_canc.setOnClickListener(voltar);
        despesa_conf.setOnClickListener(cadastrar);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinnerNivel, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

    }

    View.OnClickListener voltar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(CadastroDespesa.this, TelaPrincipalActivity.class);
            startActivity(it);
        }
    };


    public String radioResultado() {
        String resultado = "";
        if (despesa_rbdiario.isChecked()) {
            resultado = "Diario";
        } else {
            if (despesa_rbsemanal.isChecked()) {
                resultado = "Semanal";
            } else {
                if (despesa_rbsemanal.isChecked()) {
                    resultado = "Mensal";
                } else {
                    if (despesa_rbunica.isChecked()) {
                        resultado = "Unica";
                    }
                }
            }
        }
        return resultado;
    }

    View.OnClickListener cadastrar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (despesa_nome.getText().toString().trim().equalsIgnoreCase("")) {
                despesa_nome.requestFocus();
            } else {
                if (despesa_valor.getText().toString().trim().equalsIgnoreCase("")) {
                    despesa_valor.requestFocus();
                } else {
                    if (despesa_data.getText().toString().trim().equalsIgnoreCase("")) {
                        despesa_data.requestFocus();
                    } else {
                        if (despesa_descricao.getText().toString().trim().equalsIgnoreCase("")) {
                            despesa_descricao.requestFocus();
                        } else {
                            if (spinner.getSelectedItem().toString().trim().equalsIgnoreCase("")) {
                                despesa_descricao.requestFocus();

                                //obs : n coloquei o radio,se der b.o. já sabe
                            } else {
                                String radiovalue = ((RadioButton) findViewById(geral_rb.getCheckedRadioButtonId())).getText().toString();
                                posicao = spinner.getSelectedItemPosition(); //PEGA A POSICAO DO ITEM NO SPINNER, NO CASO, NIVEL(BAIXO, MÉDIO, ALTO)
                                token = localDatabase();
                                cadastroDespesa();
                            }
                        }
                    }
                }
            }
        }


    };

    private void cadastroDespesa() {
        //cadastro despesas
        final Despesa despesa = new Despesa(posicao, despesa_nome.getText().toString(), despesa_data.getText().toString(), despesa_descricao.getText().toString(), radioResultado(), Float.parseFloat(despesa_valor.getText().toString()));
        Call<Despesa> call = sDespesa.cadastroDespesa(token, despesa);
        call.enqueue(new Callback<Despesa>() {
            public void onResponse(Call<Despesa> call, Response<Despesa> response) {
                if (response.isSuccessful()) {
                    ddespesa = response.body();
                    startActivity(new Intent(getBaseContext(), TelaPrincipalActivity.class));
                } else {
                    Log.i("RETROFIT", response.message());
                    Toast.makeText(getBaseContext(), "Erro: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Despesa> call, Throwable t) {
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


}
