package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class periksa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periksa);
        getSupportActionBar().hide();
    }

    public void btnPesan(View view) {
        Intent intent = new Intent(periksa.this, InputDataPesanan.class);
        startActivity(intent);
    }
}