package com.aldi.aldiproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {

    TextView tvNama_wisata,tvNamaDaerah,tvJenis,tvDeskripsi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvNama_wisata = findViewById(R.id.nama_wisata);
        tvNamaDaerah = findViewById(R.id.nama_daerah);
        tvJenis = findViewById(R.id.jenis);
        tvDeskripsi = findViewById(R.id.deskripsi);

        tvNama_wisata.setText(getIntent().getStringExtra("nama"));
        tvNamaDaerah.setText(getIntent().getStringExtra("nama_daerah"));
        tvJenis.setText(getIntent().getStringExtra("jenis"));
        tvDeskripsi.setText(getIntent().getStringExtra("deskripsi"));

    }


}