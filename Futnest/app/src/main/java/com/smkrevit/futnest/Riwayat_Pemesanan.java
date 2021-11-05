package com.smkrevit.futnest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smkrevit.futnest.Adapter.Riwayat_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Riwayat_Pemesanan extends AppCompatActivity {

    RecyclerView recyclerView;
    Riwayat_Adapter riwayat_adapter;
    List<Riwayat> riwayatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat__pemesanan);
        getSupportActionBar().hide();

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.riwayat);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.beranda:
                        startActivity(new Intent(getApplicationContext()
                                ,Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profil:
                        startActivity(new Intent(getApplicationContext()
                                ,Profil.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.riwayat:
                        startActivity(new Intent(getApplicationContext()
                                ,Riwayat_Pemesanan.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        load();
        isiRiwayat();
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvRiwayat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiRiwayat(){
        riwayatList = new ArrayList<Riwayat>();
        riwayatList.add(new Riwayat("Raden", "Kahuripan", "15-06-2021", "08.00 - 10.00"));
        riwayatList.add(new Riwayat("Burhan", "Kahuripan", "15-06-2021", "10.00 - 12.00"));
        riwayatList.add(new Riwayat("Dewa", "Villa Jasmine", "15-06-2021", "12.00 - 14.00"));
        riwayatList.add(new Riwayat("Shopie", "Jati", "16-06-2021", "08.00 - 10.00"));
        riwayatList.add(new Riwayat("Suep", "Cemeng", "17-06-2021", "08.00 - 10.00"));
        riwayatList.add(new Riwayat("Pram", "Kahuripan", "18-06-2021", "08.00 - 10.00"));
        riwayatList.add(new Riwayat("Hapsari", "Kahuripan", "15-08-2021", "16.00 - 18.00"));
        riwayatList.add(new Riwayat("Raden", "Kahuripan", "15-06-2021", "08.00 - 10.00"));

        riwayat_adapter = new Riwayat_Adapter(this,riwayatList);
        recyclerView.setAdapter(riwayat_adapter);
    }
}