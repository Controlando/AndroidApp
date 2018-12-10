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

public class FragmentPrincipal extends Fragment {
    Button bRec, bDesp, bMet;
    View view;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.principal_fragment, container, false);
        bRec =(Button)view.findViewById(R.id.bRec);
        bDesp =(Button)view.findViewById(R.id.bDesp);
        bMet=(Button)view.findViewById(R.id.bMet);

        bRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), CadastroReceita.class));
            }
        });

        bDesp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), CadastroDespesa.class));
            }
        });

        bMet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), CadastroMetas.class));
            }
        });
        return view;
    }



}
