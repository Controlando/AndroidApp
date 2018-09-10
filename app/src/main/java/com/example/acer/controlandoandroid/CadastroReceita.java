package com.example.acer.controlandoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CadastroReceita extends AppCompatActivity {
   /* private Spinner spn1;
    private List<String> nomes = new ArrayList<String>();
    private String nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_receita);

            //Adicionando Nomes no ArrayList
            nomes.add("Saldo Inicial");
            nomes.add("Receitas");

            //Identifica o Spinner no layout
            spn1 = (Spinner) findViewById(R.id.spinner);
            //Cria um ArrayAdapter usando um padrão de layout da classe R do android, passando o ArrayList nomes
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nomes);
            ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spn1.setAdapter(spinnerArrayAdapter);

            //Método do Spinner para capturar o item selecionado
            spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                    //pega nome pela posição
                    nome = parent.getItemAtPosition(posicao).toString();
                    //imprime um Toast na tela com o nome que foi selecionado
                    //Toast.makeText(CadastroReceita.this, "", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
        */
    }

