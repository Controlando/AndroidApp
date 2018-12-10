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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.acer.controlandoandroid.model.Receita;
import com.example.acer.controlandoandroid.model.ReceitaAux;
import com.example.acer.controlandoandroid.service.SReceita;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlteracaoReceita extends AppCompatActivity {

    EditText receita_nome, receita_valor, receita_data;
    TextInputEditText receita_descricao;
    Button receita_excluir, receita_alterar, btn_editar;
    int id;
    ReceitaAux receitaAux = null;
    //retrofit
    private static Receita rreceita;
    String token = null;


    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://172.20.10.2:3000/")
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
                            alterarReceita();
                        }
                    }
                }
            }

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

    private void alterarReceita() {
        //cadastro receitas
        final ReceitaAux receita = new ReceitaAux(receita_nome.getText().toString(), receita_data.getText().toString(), Float.parseFloat(receita_valor.getText().toString()), id, receita_descricao.getText().toString());
        Call<ReceitaAux> call = sReceita.alterarReceita(token,receita);
        call.enqueue(new Callback<ReceitaAux>() {
            public void onResponse(Call<ReceitaAux> call, Response<ReceitaAux> response) {
                if (response.isSuccessful()) {
//                    rreceita = response.body();

                    Toast.makeText(AlteracaoReceita.this, "Receita alterada!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getBaseContext(), TelaPrincipalActivity.class));
                } else {
                    Log.i("RETROFIT", response.message());
                    Toast.makeText(getBaseContext(), "Erro: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ReceitaAux> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Algo deu errado :(" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    View.OnClickListener excluir = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //final ReceitaAux receita = new ReceitaAux(receita_nome.getText().toString(), receita_data.getText().toString(), Float.parseFloat(receita_valor.getText().toString()), id, receita_descricao.getText().toString());
            Call<JSONObject> call = sReceita.deletarReceita(token,id);
            call.enqueue(new Callback<JSONObject>() {
                public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                    if (response.isSuccessful()) {
//                    rreceita = response.body();
                        JSONObject obj = response.body();
                        Log.i("JSON: ", obj.toString());
                        Toast.makeText(AlteracaoReceita.this, "Receita alterada!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getBaseContext(), TelaPrincipalActivity.class));
                    } else {
                        Log.i("RETROFIT", response.message());
                        Toast.makeText(getBaseContext(), "Erro: " + response.message(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<JSONObject> call, Throwable t) {
                    Toast.makeText(getBaseContext(), "Algo deu errado :(" + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alteracao_receita);

        id = Integer.parseInt(this.getIntent().getStringExtra("id"));
        receita_nome = (EditText) findViewById(R.id.receita_nomereceita);
        receita_valor = (EditText) findViewById(R.id.receita_valordespesa);
        receita_data = (EditText) findViewById(R.id.receita_datareceita);
        receita_descricao = (TextInputEditText) findViewById(R.id.receita_descricaoreceita);
        receita_excluir = (Button) findViewById(R.id.receita_btnExcluirRec);
        receita_alterar = (Button) findViewById(R.id.receita_btnalterar);
        btn_editar = (Button) findViewById(R.id.btn_editarReceita);
        token = localDatabase();
        colocarDados();
        desabilitar();
        receita_excluir.setOnClickListener(excluir);
        receita_alterar.setOnClickListener(cadastrar);
        btn_editar.setOnClickListener(buttonAction);
    }
    public void colocarDados() {
        Call<ReceitaAux> call = sReceita.getReceita(token, id);
        call.enqueue(new Callback<ReceitaAux>() {
            @Override
            public void onResponse(Call<ReceitaAux> call, Response<ReceitaAux> response) {
                if (response.isSuccessful()) {
                    receitaAux = response.body();
                    receita_nome.setText(receitaAux.getNome());
                    receita_descricao.setText(receitaAux.getDescricao());
                    receita_valor.setText(""+receitaAux.getValor());
                    receita_data.setText(""+receitaAux.getDataReceita());
                    Log.i("RESPOSTA",receitaAux.getNome());
                } else {
                    Log.i("RETROFIT", response.message());
                    Toast.makeText(AlteracaoReceita.this, "Erro: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ReceitaAux> call, Throwable t) {
                Toast.makeText(AlteracaoReceita.this, "Algo deu errado :(" +t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    View.OnClickListener buttonAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            habilitar();
        }
    };

    public void desabilitar(){
        receita_nome.setEnabled(false);
        receita_valor.setEnabled(false);
        receita_data.setEnabled(false);
        receita_descricao.setEnabled(false);
        receita_alterar.setEnabled(false);
    }

    public void habilitar(){
        receita_nome.setEnabled(true);
        receita_valor.setEnabled(true);
        receita_data.setEnabled(true);
        receita_descricao.setEnabled(true);
        receita_alterar.setEnabled(true);
    }


}
