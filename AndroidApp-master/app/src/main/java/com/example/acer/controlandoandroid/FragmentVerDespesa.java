package com.example.acer.controlandoandroid;

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
import android.widget.ListView;
import android.widget.Toast;

import com.example.acer.controlandoandroid.model.DespesaAux;
import com.example.acer.controlandoandroid.model.Row;
import com.example.acer.controlandoandroid.model.RowDespesa;
import com.example.acer.controlandoandroid.service.SDespesa;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentVerDespesa extends Fragment {
    View view;
    ListView listViewDespesa;
    String token = null;

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://172.20.10.2:3000/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    SDespesa sDespesa = retrofit.create(SDespesa.class);
    List<DespesaAux> list = null;

    public FragmentVerDespesa(){

    }
    public String localDatabase() {
        String tokenLocal = null;
        try {
            SQLiteDatabase bc = SQLiteDatabase.openOrCreateDatabase("/data/user/0/com.example.acer.controlandoandroid/databases/app", null, null);

            Cursor cursor = bc.rawQuery("SELECT * FROM usuario", null);
            int indiceColunaToken = cursor.getColumnIndex("token");
            cursor.moveToFirst();

            while (cursor != null) {
                tokenLocal = cursor.getString(indiceColunaToken);
                cursor.moveToNext();
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        return tokenLocal;

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ver_despesa,container,false);
        listViewDespesa = (ListView) view.findViewById(R.id.listView_Despesa);

        token = localDatabase();
        listarReceita();
        return view;


    }
    public void listarReceita() {
        Log.i("Token", token);
        Call<List<DespesaAux>> call = sDespesa.listarDespesa(token);
        call.enqueue(new Callback<List<DespesaAux>>() {
            @Override
            public void onResponse(Call<List<DespesaAux>> call, Response<List<DespesaAux>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    ArrayList<DespesaAux> arrayRec = new ArrayList<>();
                    Log.i("SIZE", ""+list.size());
                    for (int i = 0; i < list.size(); i++) {
                        DespesaAux aux = new DespesaAux(list.get(i).getNome(), list.get(i).getDescricao(), list.get(i).getDataDespesa(), list.get(i).getValor(), list.get(i).getId());
                        Log.i("RETROFIT", "" + list.get(i).getDataDespesa());
                        arrayRec.add(aux);
                    }
                    RowDespesa row= new RowDespesa(getContext(), arrayRec);
                    listViewDespesa.setAdapter(row);
                    //Log.i("RETROFIT", "" + list.get(2).getDataDespesa());
                } else {
                    Log.i("RETROFIT", response.message());
                    Toast.makeText(getActivity(), "Erro: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<DespesaAux>> call, Throwable t) {
                Toast.makeText(getContext(), "Algo deu errado :(" +t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
