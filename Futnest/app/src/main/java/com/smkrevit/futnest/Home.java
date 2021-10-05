package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataLapangan[] dataLapangans = new DataLapangan[]{
          new DataLapangan("TIZA", "Prumahan Puriindah, Rp.70.000",R.drawable.tiza),
          new DataLapangan("PIS", "Prumahan Puriindah, Rp.70.000",R.drawable.pis),
          new DataLapangan("ALTHEA", "Prumahan Puriindah, Rp.70.000",R.drawable.logo),
          new DataLapangan("BUDURAN", "Prumahan Puriindah, Rp.70.000",R.drawable.logo),
          new DataLapangan("PANJI", "Prumahan Puriindah, Rp.70.000",R.drawable.logo),
          new DataLapangan("FLAMENGO", "Prumahan Puriindah, Rp.70.000",R.drawable.logo),
        };

        LapanganAdapter myLapanganAdapter = new LapanganAdapter(dataLapangans,Home.this);
        recyclerView.setAdapter(myLapanganAdapter);

    }
}