package com.smkrevit.futnest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BuktiPemesanan extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4 ,tv5, tv6, tv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bukti_pemesanan);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        tv1 = (TextView) findViewById(R.id.tvNamaBukti);
        tv2 = (TextView) findViewById(R.id.tvNamaLapBukti);
//        tv3 = (TextView) findViewById(R.id.tvNoTelpBukti);
        tv4 = (TextView) findViewById(R.id.tvTgldanJamBukti);
        tv5 = (TextView) findViewById(R.id.tvPilLap);
        tv6 = (TextView) findViewById(R.id.tvAlamatBukti);
        tv7 = (TextView) findViewById(R.id.tvNoTelpPemilikBukti);

        tv1.setText(intent.getStringExtra("Nama"));
        tv2.setText(intent.getStringExtra("NamaLapBukti"));
//        tv3.setText(intent.getStringExtra("NoTelpBukti"));
        tv4.setText(intent.getStringExtra("tgldanjam"));
        tv5.setText(intent.getStringExtra("TipeLapangan"));
        tv6.setText(intent.getStringExtra("Alamat"));
        tv7.setText(intent.getStringExtra("NoTelpPemilik"));


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
    }
}