package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailUploadAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_upload_admin);
        getSupportActionBar().hide();
    }

    public void btnSelesai(View view) {
        Intent intent = new Intent(DetailUploadAdmin.this, Home.class);
        startActivity(intent);
    }
}