package com.example.acer.controlandoandroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.controlandoandroid.model.ReceitaAux;
import com.example.acer.controlandoandroid.model.Row;
import com.example.acer.controlandoandroid.service.SReceita;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaPrincipalActivity extends AppCompatActivity {
    //TextView texto;
    BottomNavigationMenu menu;
    String token = null;
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://172.20.10.2:3000/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    String saldo = null;
    SReceita sReceita = retrofit.create(SReceita.class);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Log.i("token", "ABRIU");
        //texto = (TextView) findViewById(R.id.textView2);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentPrincipal()).commit();
        token = localDatabase();
        getSaldo();

    }
    public void getSaldo() {
        Call<String> call = sReceita.getSaldo(token);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    saldo = response.body().toString();
                    Toast.makeText(TelaPrincipalActivity.this, "Seu saldo e R$ " + saldo, Toast.LENGTH_LONG).show();
                    Log.i("RETROFIT", "" +saldo );
                } else {
                    Log.i("RETROFIT", response.message());
                    Toast.makeText(TelaPrincipalActivity.this, "Erro: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(TelaPrincipalActivity.this, "Algo deu errado :(", Toast.LENGTH_LONG).show();
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.inicio_item:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentPrincipal()).commit();
                            break;

                        case R.id.lancamentos_item:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentLancamentos()).commit();
                            break;

                        case R.id.relatorios_item:

                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentRelatorio()).commit();
                            break;

                        case R.id.historico_item:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHistorico()).commit();
                            break;

                        case R.id.perfil_item:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentConfig()).commit();
                            break;

                    }
                return true;
                }
            };


}
