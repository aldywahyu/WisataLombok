package com.aldi.aldiproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.aldi.aldiproject.adapter.AdapterDestinasi;
import com.aldi.aldiproject.model.Destinasi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements AdapterDestinasi.ClickItem {

    List<Destinasi> destinasiList = new ArrayList<>();
    AdapterDestinasi adapterDestinasi;
    ListView listView;
    Button tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        tambah = findViewById(R.id.tambah);


        SharedPreferences appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());

        Gson gson = new Gson();
        String json = appSharedPrefs.getString("key", "");
        Type type = new TypeToken<List<Destinasi>>() {}.getType();
        destinasiList  = gson.fromJson(json, type);
        for (int i =0;i<destinasiList.size();i++){



            adapterDestinasi = new AdapterDestinasi(getApplicationContext(),destinasiList,MainActivity.this);
            listView.setAdapter(adapterDestinasi);


        }

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Tambah.class));
            }
        });
    }


    @Override
    public void item(String nama, String nama_daerah, String jenis, String dekripsi) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("nama", nama);
        intent.putExtra("nama_daerah", nama_daerah);
        intent.putExtra("jenis", jenis);
        intent.putExtra("deskripsi", dekripsi);
        startActivity(intent);

    }
}