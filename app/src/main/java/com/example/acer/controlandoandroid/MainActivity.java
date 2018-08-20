package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtEmail, txtSenha, txtCadastro;

    View.OnClickListener logar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCadastro = (TextView)findViewById(R.id.viewCadastro);
        txtSenha = (TextView)findViewById(R.id.txtSenha);
        txtEmail = (TextView)findViewById(R.id.txtEmail);

        txtCadastro.setOnClickListener(logar);
    }
}
