package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hal_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_detail);
        getSupportActionBar().hide();

        Intent intent = getIntent();
    }

    public void btnCheck(View view) {
        Intent intent = new Intent(hal_detail.this, CheckTanggal.class);
        startActivity(intent);
    }
}