package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaConfig extends AppCompatActivity {
    Button btnNome, btnSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_config);

        btnNome=(Button)findViewById(R.id.btnNome);
        btnSenha=(Button)findViewById(R.id.btnSenha);

        btnNome.setOnClickListener(verConfigNome);
        btnSenha.setOnClickListener(verConfigSenha);
    }

    View.OnClickListener verConfigNome = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(TelaConfig.this, AlterarNome.class);
            startActivity(it);
        }
    };

    View.OnClickListener verConfigSenha = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(TelaConfig.this, AlterarSenha.class);
            startActivity(it);
        }
    };
}
