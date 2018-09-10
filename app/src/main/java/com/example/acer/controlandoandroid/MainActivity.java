package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.controlandoandroid.model.Login;
import com.example.acer.controlandoandroid.model.User;
import com.example.acer.controlandoandroid.service.UserClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView txtEmail, txtSenha, txtCadastro;
    Button btnLogin;
    //RETROFIT
    private static User user;
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://192.168.0.20:3000/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    UserClient userClient = retrofit.create(UserClient.class);


    //ACTION
    View.OnClickListener cadastro = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }
    };
    View.OnClickListener login = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (txtEmail.getText().toString().trim().equalsIgnoreCase("")) {
                txtEmail.requestFocus();
            } else {
                if (txtEmail.getText().toString().trim().equalsIgnoreCase("")) {
                    txtSenha.requestFocus();
                } else {
                    login();
                }

            }
        }
    };
    private void login() {
        //LOGIN
        Login login  = new Login(txtEmail.getText().toString(), txtSenha.getText().toString());
        Call<User> call = userClient.login(login);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user = response.body();
                    Toast.makeText(MainActivity.this, ""+user.toString(), Toast.LENGTH_LONG).show();
                    //FUNCAO SQLITE
                    localDatabase(user);
                    startActivity(new Intent(MainActivity.this, com.example.acer.controlandoandroid.Principal.class));
                } else {
                    Log.i("RETROFIT", response.message());
                    Toast.makeText(MainActivity.this, "Erro: "+ response.message(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Algo deu errado :(" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    private void localDatabase(User user) {
        try {
            SQLiteDatabase bancoUser = openOrCreateDatabase("app", MODE_PRIVATE, null);
            bancoUser.execSQL("CREATE TABLE IF NOT EXISTS usuario(codigo integer not null PRIMARY KEY AUTOINCREMENT, nome VARCHAR, email VARCHAR NOT NULL, senha VARCHAR(400) NOT NULL, token VARCHAR(300))");
            bancoUser.execSQL("INSERT INTO usuario(nome, email, senha, token) VALUES( 'sofrimento'"+", '"+ user.getEmail() +"', '"+ user.getSenha()+"', '"+ user.getToken()+"')");
            Cursor cursor = bancoUser.rawQuery("SELECT * FROM usuario", null);
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaEmail = cursor.getColumnIndex("email");
            int indiceColunaSenha = cursor.getColumnIndex("senha");
            int indiceColunaToken = cursor.getColumnIndex("token");
            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - Nome: ", cursor.getString(indiceColunaNome));
                Log.i("Resultado - Email: ", cursor.getString(indiceColunaEmail));
                Log.i("Resultado - Senha: ", cursor.getString(indiceColunaSenha));
                Log.i("Resultado - token: ", cursor.getString(indiceColunaToken));
                cursor.moveToNext();
            }
            deleteDatabase("usuario");
//            startActivity(new Intent(MainActivity.this, Main2Activity.class));
            //IR PARA TELA PRINCIPAL
        } catch (Exception E) {
            E.printStackTrace();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCadastro = (TextView)findViewById(R.id.viewCadastro);
        txtSenha = (TextView)findViewById(R.id.txtSenhaCadastro);
        txtEmail = (TextView)findViewById(R.id.txtEmailCadastro);
        btnLogin = (Button) findViewById(R.id.btnLogar);

        btnLogin.setOnClickListener(login);
        txtCadastro.setOnClickListener(cadastro);
    }
}
