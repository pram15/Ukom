package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IsiGambar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_gambar);
        getSupportActionBar().hide();
    }

    public void btnUnggah(View view) {
        Intent intent = new Intent(IsiGambar.this, DetailUploadAdmin.class);
        startActivity(intent);
    }
}