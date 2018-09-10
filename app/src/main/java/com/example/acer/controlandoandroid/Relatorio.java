package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Relatorio extends AppCompatActivity {
    Button btnAtualizar, btnCancelar, btnLancamento, btnHistorico, btnRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        btnLancamento = (Button)findViewById(R.id.btnRelatorioLancamento);
        btnHistorico = (Button)findViewById(R.id.btnRelatorioHistorico);
        btnRelatorio = (Button)findViewById(R.id.btnRelatorioRelatorio);

        btnLancamento.setOnClickListener(lancamento);
        btnRelatorio.setOnClickListener(relatorio);
    }

    View.OnClickListener lancamento = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Relatorio.this, Lancamentos.class));
        }
    };

    View.OnClickListener relatorio = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Relatorio.this, TelaHistorico.class));
        }
    };
}
