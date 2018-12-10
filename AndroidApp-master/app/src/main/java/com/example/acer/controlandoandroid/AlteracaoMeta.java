package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AlteracaoMeta extends AppCompatActivity {

    EditText metas_nome, metas_valor, metas_data;
    TextInputEditText metas_descricao;
    Button metas_excluir, metas_alterar, btn_editarMeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alteracao_meta);

        metas_nome = (EditText) findViewById(R.id.meta_nomemeta);
        metas_valor = (EditText) findViewById(R.id.meta_valormeta);
        metas_data = (EditText) findViewById(R.id.meta_datameta);
        metas_descricao = (TextInputEditText) findViewById(R.id.meta_descricaometa);

        metas_excluir = (Button) findViewById(R.id.meta_btnExcluirMeta);
        metas_alterar = (Button) findViewById(R.id.meta_btnExcluirMeta);
        btn_editarMeta = (Button) findViewById(R.id.btn_editarMeta);

        desabilitar();

        metas_excluir.setOnClickListener(excluir);
        metas_alterar.setOnClickListener(cadastrar);
        btn_editarMeta.setOnClickListener(buttonActionMeta);
    }

    public void desabilitar(){
        metas_nome.setEnabled(false);
        metas_valor.setEnabled(false);
        metas_data.setEnabled(false);
        metas_descricao.setEnabled(false);

        metas_alterar.setEnabled(false);

    }

    public void habilitar(){
        metas_nome.setEnabled(true);
        metas_valor.setEnabled(true);
        metas_data.setEnabled(true);
        metas_descricao.setEnabled(true);

        metas_alterar.setEnabled(true);

    }

    View.OnClickListener cadastrar = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener buttonActionMeta = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            habilitar();
        }
    };

    View.OnClickListener excluir = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

}
