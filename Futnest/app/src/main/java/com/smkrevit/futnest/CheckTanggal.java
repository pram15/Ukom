package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class CheckTanggal extends AppCompatActivity {

    EditText etTanggal;
    EditText etJam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_tanggal);
        getSupportActionBar().hide();
        load();
    }

    public void load() {
        etTanggal = findViewById(R.id.etTanggal);
        etJam = findViewById(R.id.etJam);
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

    public void etJam(View view) {
        Calendar jam = Calendar.getInstance();

        TimePickerDialog tmp = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                etJam.setText(hourOfDay+"."+minute);
            }
        },      jam.get(Calendar.HOUR_OF_DAY), jam.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(this));
        tmp.show();
    }
}