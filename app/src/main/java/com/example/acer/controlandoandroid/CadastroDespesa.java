package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroDespesa extends AppCompatActivity {
    Button canc, conf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_despesa);

        canc=(Button)findViewById(R.id.canc);
        conf=(Button)findViewById(R.id.conf);

        canc.setOnClickListener(voltar);
        conf.setOnClickListener(irHome);
    }

    View.OnClickListener irHome = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(CadastroDespesa.this, Principal.class);
            startActivity(it);
        }
    };

    View.OnClickListener voltar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(CadastroDespesa.this, Lancamentos.class);
            startActivity(it);
        }
    };
}
