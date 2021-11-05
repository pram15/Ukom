package com.smkrevit.futnest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smkrevit.futnest.Adapter.LapanganAdapter;

public class Home extends AppCompatActivity {

    Button button;
    Button btnDetail;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();



        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.beranda:

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

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataLapangan[] dataLapangans = new DataLapangan[]{
          new DataLapangan("TIZA", "Perumahan Puri Indah, Rp.70.000",R.drawable.tiza),
          new DataLapangan("PIS", "Perumahan Puri Indah, Rp.70.000",R.drawable.pis),
          new DataLapangan("BUDURAN FUTSAL", "Buduran, Rp.70.000",R.drawable.logo),
          new DataLapangan("PANJI", "Buduran, Rp.70.000",R.drawable.logo),
          new DataLapangan("FLAMINIO", "Jl. Teuku Umar II No.2, Gajah Timur, Magersari, Kec. Sidoarjo, Kabupaten Sidoarjo, Jawa Timur 61212, Rp.70.000",R.drawable.logo),
        };

        LapanganAdapter myLapanganAdapter = new LapanganAdapter(dataLapangans,Home.this);
        recyclerView.setAdapter(myLapanganAdapter);

    }

    public void btnDetail(View view) {

    }

}