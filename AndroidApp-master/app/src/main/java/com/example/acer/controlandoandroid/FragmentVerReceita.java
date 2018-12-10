package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.acer.controlandoandroid.model.Receita;
import com.example.acer.controlandoandroid.model.ReceitaAux;
import com.example.acer.controlandoandroid.model.Row;
import com.example.acer.controlandoandroid.service.SReceita;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentVerReceita extends Fragment {
    View view;
    String token = null;
    private static Receita rReceita;
    ListView listView_Receita;
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://172.20.10.2:3000/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();
    SReceita sReceita = retrofit.create(SReceita.class);
    List<ReceitaAux> list = null;

    public String localDatabase() {
        String tokenLocal = null;
        try {
            SQLiteDatabase bc = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.example.acer.controlandoandroid/databases/app", null, null);

            Cursor cursor = bc.rawQuery("SELECT * FROM usuario", null);
            int indiceColunaToken = cursor.getColumnIndex("token");
            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - token: ", cursor.getString(indiceColunaToken));
                tokenLocal = cursor.getString(indiceColunaToken);
                cursor.moveToNext();
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        return tokenLocal;

    }

    public void receita() {
        token = localDatabase();
    }

    public void listarReceita() {
        Call<List<ReceitaAux>> call = sReceita.listarReceita(token);
        call.enqueue(new Callback<List<ReceitaAux>>() {
            @Override
            public void onResponse(Call<List<ReceitaAux>> call, Response<List<ReceitaAux>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    ArrayList<ReceitaAux> arrayRec = new ArrayList<>();
                    for( ReceitaAux rect : list ){
                        ReceitaAux aux = new ReceitaAux(rect.getNome(), rect.getDataReceita(), rect.getValor(), rect.getId());
                        arrayRec.add(aux);
                    }

                    Row row= new Row(getContext(), arrayRec);
                    listView_Receita.setAdapter(row);
                    Log.i("RETROFIT", "" + list.size());
                } else {
                    Log.i("RETROFIT", response.message());
                    Toast.makeText(getContext(), "Erro: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ReceitaAux>> call, Throwable t) {
                Toast.makeText(getContext(), "Algo deu errado :(", Toast.LENGTH_LONG).show();
            }
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ver_receita, container, false);
        listView_Receita = view.findViewById(R.id.listView_Receita);

        receita();
        listarReceita();
        listView_Receita.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selecionada = ""+list.get(position).getId();
                Intent intent = new Intent(getContext(), AlteracaoReceita.class);
                intent.putExtra("id", selecionada);
                startActivity(intent);
            }
        });
        return view;
    }

}
