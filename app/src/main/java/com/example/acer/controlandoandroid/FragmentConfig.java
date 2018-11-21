package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentConfig extends Fragment {
    Button btnNome, btnSenha;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.configuracao_fragment, null);


        btnNome = (Button) view.findViewById(R.id.altNome);
        btnSenha = (Button) view.findViewById(R.id.altSenha);

        btnNome.setOnClickListener(verConfigNome);
        btnSenha.setOnClickListener(verConfigSenha);


        return view;
    }

        View.OnClickListener verConfigNome = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getView().getContext(), AlterarNome.class);
                startActivity(it);
            }
        };

        View.OnClickListener verConfigSenha = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getView().getContext(), AlterarSenha.class);
                startActivity(it);
            }
        };



    }