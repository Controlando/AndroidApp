package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.acer.controlandoandroid.model.User;
import com.example.acer.controlandoandroid.service.UserClient;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlterarSenha extends AppCompatActivity {
    Button btnAtualizar, btnCancelar;
    EditText edNovaSenha, edConfNovaSenha;

    //retrofit
    private static User uuser;
    String token = null;

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://172.20.10.2:3000/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    UserClient uClient = retrofit.create(UserClient.class);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_senha);

        edNovaSenha = (EditText) findViewById(R.id.edNovoNome);
        edConfNovaSenha = (EditText) findViewById(R.id.edConfNovaSenha);
        btnAtualizar = (Button) findViewById(R.id.btnAtualizarAlterarSenha);
        btnCancelar = (Button) findViewById(R.id.btnCancelarAlterarSenha);


        btnAtualizar.setOnClickListener(atualizar);
        btnCancelar.setOnClickListener(cancelarSenha);

    }

    public void atualizarSenha() {
        /*
        //cadastro despesas
        final User user = new User(edConfNovaSenha.getText().toString());
        Call<User> call = uClient.trocarSenha();
        call.enqueue(new Callback<User>() {
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    ddespesa = response.body();
                    Toast.makeText(AlterarSenha.this, "Despesa cadastrada!" + response.message().toString(), Toast.LENGTH_SHORT).show();
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
        });*/
    }

    View.OnClickListener atualizar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (edConfNovaSenha.getText().toString().trim().equalsIgnoreCase("")) {
                edConfNovaSenha.requestFocus();
            } else {
                token = localDatabase();
                atualizarSenha();
            }

            startActivity(new Intent(AlterarSenha.this, TelaPrincipalActivity.class));
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
        Log.i("Resultado rec - token: ", "2555");

        return tokenLocal;

    }


    View.OnClickListener cancelarSenha = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
