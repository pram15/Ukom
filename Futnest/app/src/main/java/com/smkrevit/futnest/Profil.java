package com.smkrevit.futnest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smkrevit.futnest.Model.M_LoginAdmin;
import com.smkrevit.futnest.Model.M_LoginUser;

public class Profil extends AppCompatActivity {

    EditText etNamaProfil, etAlamat, etEmail, etNoTelp, etSosmed;
    ImageView imgProfil;
    M_LoginAdmin m_loginAdmin;
    M_LoginUser m_loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        getSupportActionBar().hide();

        etNamaProfil = findViewById(R.id.tvNamaProfil);
        etAlamat = findViewById(R.id.tvAlamatProfil);
        etEmail = findViewById(R.id.tvEmailProfil);
        etNoTelp = findViewById(R.id.tvNoTelpProfil);
        etSosmed = findViewById(R.id.tvSosmedProfil);
        imgProfil = findViewById(R.id.tmgProfil);

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            m_loginAdmin = (M_LoginAdmin) intent.getSerializableExtra("foto");
            //          m_loginUser = (M_LoginUser) intent.getSerializableExtra("user");
//
//            Glide.with(Profil.this)
//                    .load(""+m_loginAdmin.getFoto())
//                    .into(img);

            etNamaProfil.setText(m_loginAdmin.getNama());
            etAlamat.setText(m_loginAdmin.getLevel());
            etEmail.setText(m_loginAdmin.getEmail());
            etNoTelp.setText(m_loginAdmin.getRelasi());
            etSosmed.setText(m_loginAdmin.getSosmed());
        }


        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.profil);

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


    public void ivBack(View view) {
        Intent intent = new Intent(Profil.this, Home.class);
        startActivity(intent);
    }

    public void btnLihatLapangan(View view) {
        Intent intent = new Intent(Profil.this, Recycler_Lapangan_Admin.class);
        startActivity(intent);
    }

    public void btnLogout(View view) {
        Intent intent = new Intent(Profil.this, MainActivity.class);
        startActivity(intent);
    }
}