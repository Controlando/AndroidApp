package com.example.acer.controlandoandroid.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.acer.controlandoandroid.R;

import java.util.ArrayList;

public class Row extends BaseAdapter {

    private ArrayList<ReceitaAux> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public Row(Context context, ArrayList<ReceitaAux> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //      int type = getItemViewType(position);

        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.activity_row, null);
            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.nameTextView111);
            holder.age = (TextView) convertView.findViewById(R.id.ageTextView222);
            holder.valor = (TextView) convertView.findViewById(R.id.ageTextView333);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(listData.get(position).nome);
        holder.age.setText(listData.get(position).dataReceita);
        holder.valor.setText(""+listData.get(position).valor);
        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView age;
        TextView valor;

    }
}