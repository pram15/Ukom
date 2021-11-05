package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class periksa extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periksa);
        getSupportActionBar().hide();
    }

    public void btnGambarLapangan(View view) {
        Intent intent = new Intent(periksa.this, InputDataPesanan.class);
        startActivity(intent);
    }

    public void btnGambarLapangan2(View view) {

    }
}