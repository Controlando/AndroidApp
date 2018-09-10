package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lancamentos extends AppCompatActivity {

    Button btnRec, btnMet, btnDesp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamentos);

        btnRec=(Button)findViewById(R.id.btnRec);
        btnDesp=(Button)findViewById(R.id.btnDesp);
        btnMet=(Button)findViewById(R.id.btnMet);

        btnDesp.setOnClickListener(cadDesp);
        btnMet.setOnClickListener(cadMet);
       // btnRec.setOnClickListener(cadRec);
    }
    /* TELA P AJEITAR
    View.OnClickListener cadRec = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(Lancamentos.this, CadastroReceita.class);
            startActivity(it);
        }
    };
    */
    View.OnClickListener cadDesp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(Lancamentos.this, CadastroDespesa.class);
            startActivity(it);
        }
    };

    View.OnClickListener cadMet = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(Lancamentos.this, CadastroMetas.class);
            startActivity(it);
        }
    };
}
