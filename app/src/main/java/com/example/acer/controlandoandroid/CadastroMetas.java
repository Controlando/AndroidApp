package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroMetas extends AppCompatActivity {
    Button bCanc, bConf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_metas);
        bCanc=(Button)findViewById(R.id.bCanc);
        bConf=(Button)findViewById(R.id.bConf);

        bCanc.setOnClickListener(voltar);
        bConf.setOnClickListener(irHome);
    }

    View.OnClickListener irHome = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(CadastroMetas.this, Principal.class);
            startActivity(it);
        }
    };

    View.OnClickListener voltar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(CadastroMetas.this, Lancamentos.class);
            startActivity(it);
        }
    };

}
