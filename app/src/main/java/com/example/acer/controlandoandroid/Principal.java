package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Principal extends AppCompatActivity {
    Button bMet, bRec,bDesp;
    Button b1,b2,b3;
    ImageButton b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        bRec=(Button)findViewById(R.id.bRec);
        bDesp=(Button)findViewById(R.id.bDesp);
        bMet=(Button)findViewById(R.id.bMet);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(ImageButton)findViewById(R.id.b4);

        bDesp.setOnClickListener(cadDesp);
        bMet.setOnClickListener(cadMet);
        b1.setOnClickListener(verLanc);
        b2.setOnClickListener(verRel);
        b3.setOnClickListener(verHist);
        b4.setOnClickListener(verConfig);
    }

    View.OnClickListener cadDesp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(Principal.this, CadastroDespesa.class);
            startActivity(it);
        }
    };

    View.OnClickListener cadMet = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(Principal.this, CadastroMetas.class);
            startActivity(it);
        }
    };
    View.OnClickListener verLanc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(Principal.this, Lancamentos.class);
            startActivity(it);
        }
    };
    View.OnClickListener verRel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(Principal.this, Relatorio.class);
            startActivity(it);
        }
    };
    View.OnClickListener verHist = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(Principal.this, TelaHistorico.class);
            startActivity(it);
        }
    };
    View.OnClickListener verConfig = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(Principal.this, TelaConfig.class);
            startActivity(it);
        }
    };
}
