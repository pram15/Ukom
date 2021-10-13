package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CardView extends AppCompatActivity {

    View cvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview);
        getSupportActionBar().hide();

        load();
    }

    public void load(){
        cvDetail = findViewById(R.id.Detail);
        cvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CardView.this, "tes", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btnDetail(View view) {
    }
}