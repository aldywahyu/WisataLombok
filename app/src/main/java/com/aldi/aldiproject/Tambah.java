package com.aldi.aldiproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.aldi.aldiproject.model.Destinasi;
import com.google.gson.Gson;

import java.util.ArrayList;


public class Tambah extends AppCompatActivity {

    EditText editTextNama, editTextDaerah, editTextJenis, editTextDeskripsi;
    Button buttonsave;
    SharedPreferences preferences;
    ArrayList<Destinasi> arrayList;
    SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        editTextNama = findViewById(R.id.save_wisata);
        editTextDaerah = findViewById(R.id.save_daerah);
        editTextJenis = findViewById(R.id.jenis);
        editTextDeskripsi = findViewById(R.id.deskripsi);
        buttonsave = findViewById(R.id.tambah);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();
        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Destinasi destinasi = new Destinasi(
                        editTextNama.getText().toString(),
                        editTextDaerah.getText().toString(),
                        editTextJenis.getText().toString(),
                        editTextDeskripsi.getText().toString()
                );
                arrayList = new ArrayList<>();
                arrayList.add(destinasi);

                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(arrayList);
                editor.putString("key", json);
                editor.commit();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));


            }
        });


    }
}