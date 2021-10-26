package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class LihatLapanganAdmin extends AppCompatActivity {

    EditText etPilTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_lapangan_admin);
        getSupportActionBar().hide();
        load();
    }

    public void load(){
        etPilTanggal = findViewById(R.id.etPilTanggal);
    }

    public void etPilTanggal(View view) {
        Calendar cal = Calendar.getInstance();
        int tgl = cal.get(Calendar.DAY_OF_MONTH);
        int bln = cal.get(Calendar.MONTH);
        int thn = cal.get(Calendar.YEAR);

        DatePickerDialog dtp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int thn, int bln, int tgl) {
                etPilTanggal.setText(tgl + "-" + (bln + 1) + "-" + thn);
            }
        }, thn, bln, tgl);

        dtp.show();
    }

    public void btnTambahLapAdmin(View view) {
        Intent intent = new Intent(LihatLapanganAdmin.this, IsiData.class);
        startActivity(intent);
    }
}