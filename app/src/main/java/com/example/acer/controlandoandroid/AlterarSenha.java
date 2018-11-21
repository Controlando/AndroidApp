package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlterarSenha extends AppCompatActivity {

    Button btnAtualizar, btnCancelar, btnLancamento, btnHistorico, btnRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_senha);


        btnAtualizar = (Button)findViewById(R.id.btnAtualizarAlterarSenha);
        btnCancelar = (Button)findViewById(R.id.btnCancelarAlterarSenha);

        //btnLancamento = (Button)findViewById(R.id.btnLancamentoAlterarSenha);
        //btnHistorico = (Button)findViewById(R.id.btnHistoricoAlterarSenha);
        //btnRelatorio = (Button)findViewById(R.id.btnRelatorioAlterarSenha);

        //btnLancamento.setOnClickListener(lancamento);
        //btnHistorico.setOnClickListener(historico);
        //btnRelatorio.setOnClickListener(relatorio);

        btnAtualizar.setOnClickListener(atualizarSenha);
        btnCancelar.setOnClickListener(cancelarSenha);

    }

    /*View.OnClickListener lancamento = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(AlterarSenha.this, Lancamentos.class));
        }
    };
    View.OnClickListener historico = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(AlterarSenha.this, Relatorio.class));
        }
    };
    View.OnClickListener relatorio = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(AlterarSenha.this, TelaHistorico.class));
        }
    };*/
    View.OnClickListener atualizarSenha = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(AlterarSenha.this, TelaPrincipalActivity.class));
        }
    };
    View.OnClickListener cancelarSenha = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(AlterarSenha.this, TelaPrincipalActivity.class));
        }
    };
}
