package com.example.acer.controlandoandroid;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class TelaPrincipalActivity extends AppCompatActivity {

    BottomNavigationMenu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentPrincipal()).commit();


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
