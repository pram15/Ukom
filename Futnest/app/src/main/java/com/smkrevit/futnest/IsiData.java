package com.smkrevit.futnest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IsiData extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_data);
        getSupportActionBar().hide();

        button = (Button) findViewById(R.id.btnIsiData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnIsiGambar();

            }
        });
    }

    public void btnIsiGambar() {
        Intent intent = new Intent(IsiData.this, IsiGambar.class);
        startActivity(intent);
    }


}