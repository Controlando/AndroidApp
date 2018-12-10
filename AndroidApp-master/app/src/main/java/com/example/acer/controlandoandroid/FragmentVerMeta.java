package com.example.acer.controlandoandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.acer.controlandoandroid.model.Meta;

public class FragmentVerMeta extends Fragment {
    View view;
    String token = null;
    private static Meta mMeta;
    ListView listView_Meta;

    public FragmentVerMeta(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ver_meta, container, false);

        listView_Meta = (ListView) view.findViewById(R.id.listView_m);

        return view;
    }

}
