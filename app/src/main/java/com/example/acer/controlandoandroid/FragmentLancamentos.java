package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentLancamentos extends Fragment {
    Button btnRec, btnDesp, btnMet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lancamentos_fragment, null);
        btnRec=(Button) view.findViewById(R.id.btnReceitas);
        btnDesp=(Button) view.findViewById(R.id.btnDespesas);
        btnMet=(Button) view.findViewById(R.id.btnMetas);

        btnDesp.setOnClickListener(cadDesp);
        btnMet.setOnClickListener(cadMet);
        btnRec.setOnClickListener(cadRec);

        return view;

    }

    View.OnClickListener cadDesp = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(view.getContext(), CadastroDespesa.class));
        }
    };

    View.OnClickListener cadMet = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(getView().getContext(), CadastroMetas.class);
            startActivity(it);
        }
    };

    View.OnClickListener cadRec = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(view.getContext(), CadastroReceita.class));
        }
    };

}
