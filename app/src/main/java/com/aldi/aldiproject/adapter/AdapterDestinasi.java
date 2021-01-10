package com.aldi.aldiproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aldi.aldiproject.R;
import com.aldi.aldiproject.model.Destinasi;

import java.util.ArrayList;
import java.util.List;


public class AdapterDestinasi extends BaseAdapter {
    Context context;
    List<Destinasi> destinasiList = new ArrayList<>();
    private  ClickItem clickItem;

    public AdapterDestinasi(Context context, List<Destinasi> destinasiList,ClickItem item) {
        this.context = context;
        this.destinasiList = destinasiList;
        this.clickItem = item;
    }

    @Override
    public int getCount() {
        return destinasiList.size();
    }

    @Override
    public Object getItem(int position) {
        return destinasiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);

        TextView nama_wisata = view.findViewById(R.id.nama_wisata);
        TextView nama_dearah = view.findViewById(R.id.nama_daerah);

            nama_wisata.setText(destinasiList.get(position).getNama());
            nama_dearah.setText(destinasiList.get(position).getDaerah());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickItem.item(
                            destinasiList.get(position).getNama(),
                            destinasiList.get(position).getDaerah(),
                            destinasiList.get(position).getJenis(),
                            destinasiList.get(position).getDeskripsi());

                }
            });





        return view;
    }

    public  interface ClickItem{
        void item(String nama,String nama_daerah,String jenis,String dekripsi);
    }
}

