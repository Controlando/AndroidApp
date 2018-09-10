package com.example.acer.controlandoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.controlandoandroid.model.User;
import com.example.acer.controlandoandroid.service.UserClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {
    EditText txtNome, txtEmail, txtSenha;
    Button btnCadastrar;
    private static User user;
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://200.0.0.14:3000/")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
    UserClient userClient = retrofit.create(UserClient.class);

    View.OnClickListener cadastro = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (txtEmail.getText().toString().trim().equalsIgnoreCase("")) {
                txtEmail.requestFocus();
            } else {
                if (txtEmail.getText().toString().trim().equalsIgnoreCase("")) {
                    txtSenha.requestFocus();
                } else {
                    cadastrar();
                }

            }
        }
    };
    //Cadastro
    private void cadastrar() {
        User userBody = new User(txtEmail.getText().toString(), txtSenha.getText().toString(), "", txtNome.getText().toString());
        Call<User> call = userClient.cadastro(userBody);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user = response.body();
                    Toast.makeText(Main2Activity.this, ""+response.message().toString(), Toast.LENGTH_LONG).show();
                    //FUNCAO SQLITE
//                    localDatabase(user);
                } else {
                    Log.i("RETROFIT", response.message());
                    Toast.makeText(Main2Activity.this, "Erro: "+ response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Main2Activity.this, "Algo deu errado :(" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtEmail = (EditText)findViewById(R.id.txtEmailCadastro);
        txtNome = (EditText)findViewById(R.id.txtNomeCadastro);
        txtSenha = (EditText)findViewById(R.id.txtSenhaCadastro);
        btnCadastrar= (Button)findViewById(R.id.btnCadastar);
        btnCadastrar.setOnClickListener(cadastro);
    }
}
