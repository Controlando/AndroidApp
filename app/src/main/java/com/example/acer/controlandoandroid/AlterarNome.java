package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlterarNome extends AppCompatActivity {
    Button btnAtualizar, btnCancelar, btnLancamento, btnHistorico, btnRelatorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_nome);

        btnAtualizar = (Button)findViewById(R.id.btnAlterarNome);
        btnCancelar = (Button)findViewById(R.id.btnCancelarAlterarNome);

        btnLancamento = (Button)findViewById(R.id.btnAlterarNomeLancamento);
        btnHistorico = (Button)findViewById(R.id.btnAlterarNomeHistorico);
        btnRelatorio = (Button)findViewById(R.id.btnAlterarNomeRelatorio);


        btnLancamento.setOnClickListener(lancamento);
        btnHistorico.setOnClickListener(historico);
        btnRelatorio.setOnClickListener(relatorio);

    }
    View.OnClickListener lancamento = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(AlterarNome.this, Lancamentos.class));
        }
    };
    View.OnClickListener historico = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(AlterarNome.this, Relatorio.class));
        }
    };
    View.OnClickListener relatorio = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(AlterarNome.this, TelaHistorico.class));
        }
    };
}
