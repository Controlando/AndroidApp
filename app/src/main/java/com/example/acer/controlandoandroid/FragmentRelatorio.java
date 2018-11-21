package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class FragmentRelatorio extends Fragment {
    /*
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://192.168.0.20:3000/")
            .addConverterFactory(GsonConverterFactory.create());

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.relatorio_fragment, container, false);
    }
    View.OnClickListener login = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (txtEmail.getText().toString().trim().equalsIgnoreCase("")) {
                txtEmail.requestFocus();
            } else {
                if (txtSenha.getText().toString().trim().equalsIgnoreCase("")) {
                    txtSenha.requestFocus();
                } else {
                    login();
                }

            }
        }
    };

    @Override
    public void onStart() {

    }

    private void login() {
        //LOGIN
        Login login  = new Login(txtEmail.getText().toString(), txtSenha.getText().toString());
        Call<User> call = userClient.login(login);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user = response.body();

                    //Toast.makeText(TelaInicial.this, ""+user.toString(), Toast.LENGTH_LONG).show();
                    //FUNCAO SQLITE
                    listagem(arraylist);
                    //startActivity(new Intent(TelaInicial.this, TelaPrincipalActivity.class));
                } else {
                    Log.i("RETROFIT", response.message());
                    Toast.makeText(TelaInicial.this, "Erro: "+ response.message(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(TelaInicial.this, "Algo deu errado :(" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
*/

}
