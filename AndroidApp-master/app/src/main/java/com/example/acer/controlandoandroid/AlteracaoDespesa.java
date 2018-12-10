package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AlteracaoDespesa extends AppCompatActivity {

    EditText despesa_nome, despesa_valor, despesa_data;
    TextInputEditText despesa_descricao;
    Button despesa_excluir, despesa_alt, btn_editar;
    Spinner spinner;
    RadioButton despesa_rbdiario, despesa_rbsemanal, despesa_rbmensal, despesa_rbunica;
    RadioGroup geral_rb;
    int posicao;
    String periodo;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alteracao_despesa);

        despesa_nome = (EditText) findViewById(R.id.despesa_nomedespesa);
        despesa_valor = (EditText) findViewById(R.id.despesa_valordespesa);
        despesa_data = (EditText) findViewById(R.id.despesa_datadespesa);
        despesa_descricao = (TextInputEditText) findViewById(R.id.despesa_descricaodespesa);

        despesa_rbdiario = (RadioButton) findViewById(R.id.despesa_rbdiario);
        despesa_rbsemanal = (RadioButton) findViewById(R.id.despesa_rbsemanal);
        despesa_rbmensal = (RadioButton) findViewById(R.id.despesa_rbmensal);
        despesa_rbunica = (RadioButton) findViewById(R.id.despesa_rbunica);

        geral_rb = (RadioGroup) findViewById(R.id.geral_rb);


        spinner = (Spinner) findViewById(R.id.spinner);

        despesa_excluir = (Button) findViewById(R.id.despesa_btnExcluirDesp);
        despesa_alt = (Button) findViewById(R.id.despesa_btnalterar);
        btn_editar = (Button) findViewById(R.id.btn_editar);

        despesa_excluir.setOnClickListener(excluir);
        despesa_alt.setOnClickListener(cadastrar);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinnerNivel, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        desabilitar();

        btn_editar.setOnClickListener(buttonAction);
    }

    public void desabilitar(){
        despesa_nome.setEnabled(false);
        despesa_valor.setEnabled(false);
        despesa_data.setEnabled(false);
        despesa_descricao.setEnabled(false);

        despesa_alt.setEnabled(false);

    }

    public void habilitar(){
        despesa_nome.setEnabled(true);
        despesa_valor.setEnabled(true);
        despesa_data.setEnabled(true);
        despesa_descricao.setEnabled(true);
        despesa_alt.setEnabled(true);

    }

    View.OnClickListener buttonAction = new View.OnClickListener() {
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

    View.OnClickListener cadastrar = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

        }
    };


}
