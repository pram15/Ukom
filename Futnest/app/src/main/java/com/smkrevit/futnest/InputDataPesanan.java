package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InputDataPesanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_pesanan);
        getSupportActionBar().hide();
    }

    public void btnPesanLapangan(View view) {
        Intent intent = new Intent(InputDataPesanan.this, BuktiPemesanan.class);
        startActivity(intent);
    }
}