package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class CheckTanggal extends AppCompatActivity {

    EditText etTanggal;
    EditText etJam;
    EditText etJam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_tanggal);
        getSupportActionBar().hide();
        load();
    }

    public void load() {
        etTanggal = findViewById(R.id.etTanggal);

    }

    public void etTanggal(View view) {

        Calendar cal = Calendar.getInstance();
        int tgl = cal.get(Calendar.DAY_OF_MONTH);
        int bln = cal.get(Calendar.MONTH);
        int thn = cal.get(Calendar.YEAR);

        DatePickerDialog dtp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int thn, int bln, int tgl) {
                etTanggal.setText(tgl + "-" + (bln + 1) + "-" + thn);
            }
        }, thn, bln, tgl);

        dtp.show();
    }

    public void btnPeriksa(View view) {
        Intent intent = new Intent(CheckTanggal.this, periksa.class);
        startActivity(intent);
    }
}