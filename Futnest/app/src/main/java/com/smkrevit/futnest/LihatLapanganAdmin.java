package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.smkrevit.futnest.Adapter.Penyewa_Adapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LihatLapanganAdmin extends AppCompatActivity {

    RecyclerView recyclerView;
    Penyewa_Adapter penyewaAdapter;
    List<Penyewa> penyewaList;
    Spinner spinnerLokasi, spinnerJam, spinnerJamSampai;
    EditText etPilTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_lapangan_admin);
        getSupportActionBar().hide();
        load();
        isiPenyewa();
        isiSpinner();
        isiSpinnerJam();
        isiSpinnerJamSampai();
    }

    public void load(){
        etPilTanggal = findViewById(R.id.etPilTanggal);
        spinnerLokasi = findViewById(R.id.spinnerLokasi);
        spinnerJam = findViewById(R.id.spinnerJam);
        spinnerJamSampai = findViewById(R.id.spinnerJamSampai);
        recyclerView = findViewById(R.id.rcvPenyewa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiSpinner(){
        String[] isi = {"Kahuripan", "Puri Indah"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String >(this, android.R.layout.simple_spinner_item,isi);
        spinnerLokasi.setAdapter(adapter);
    }

    public void isiSpinnerJam(){
        String[] isi = {"08.00", "09.00", "10.00", "11.00", "12.00"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String >(this, android.R.layout.simple_spinner_item,isi);
        spinnerJam.setAdapter(adapter);
    }

    public void isiSpinnerJamSampai(){
        String[] isi = {"08.00", "09.00", "10.00", "11.00", "12.00"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String >(this, android.R.layout.simple_spinner_item,isi);
        spinnerJamSampai.setAdapter(adapter);
    }



    public void isiPenyewa(){
        penyewaList = new ArrayList<Penyewa>();
        penyewaList.add(new Penyewa("Lapangan A", "Budi", "28-10-2001", "08.00 - 10.00", "0"));
        penyewaList.add(new Penyewa("Lapangan A", "Arya", "28-10-2001", "08.00 - 10.00", "0"));
        penyewaList.add(new Penyewa("Lapangan A", "Bani", "28-10-2001", "08.00 - 10.00", "0"));
        penyewaList.add(new Penyewa("Lapangan A", "Bandi", "28-10-2001", "08.00 - 10.00", "0"));
        penyewaList.add(new Penyewa("Lapangan A", "Arum", "28-10-2001", "08.00 - 10.00", "0"));
        penyewaList.add(new Penyewa("Lapangan A", "Arum", "28-10-2001", "08.00 - 10.00", "0"));
        penyewaList.add(new Penyewa("Lapangan A", "Arum", "28-10-2001", "08.00 - 10.00", "0"));
        penyewaList.add(new Penyewa("Lapangan A", "Arum", "28-10-2001", "08.00 - 10.00", "0"));
        penyewaList.add(new Penyewa("Lapangan A", "Arum", "28-10-2001", "08.00 - 10.00", "0"));
        penyewaList.add(new Penyewa("Lapangan A", "Arum", "28-10-2001", "08.00 - 10.00", "0"));

        penyewaAdapter = new Penyewa_Adapter(this, penyewaList);
        recyclerView.setAdapter(penyewaAdapter);
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