package com.smkrevit.futnest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class IsiData extends AppCompatActivity {

    Button button;
    EditText btnJamBuka;
    EditText btnJamTutup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_data);
        getSupportActionBar().hide();
        load();

        button = (Button) findViewById(R.id.btnIsiData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnIsiGambar();

            }
        });
    }

    public void load(){
        btnJamBuka = findViewById(R.id.etJamBuka);
        btnJamTutup = findViewById(R.id.etJamTutup);
    }

    public void btnIsiGambar() {
        Intent intent = new Intent(IsiData.this, IsiGambar.class);
        startActivity(intent);
    }


    public void btnJamBuka(View view) {
        Calendar jam = Calendar.getInstance();

        TimePickerDialog tmp = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                btnJamBuka.setText(hourOfDay+":"+minute);
            }
        },      jam.get(Calendar.HOUR_OF_DAY), jam.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(this));
        tmp.show();
    }

    public void btnJamTutup(View view) {
        Calendar jam = Calendar.getInstance();

        TimePickerDialog tmp = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                btnJamTutup.setText(hourOfDay+":"+minute);
            }
        },      jam.get(Calendar.HOUR_OF_DAY), jam.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(this));
        tmp.show();
    }
}