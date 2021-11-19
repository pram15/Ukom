package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.smkrevit.futnest.Adapter.Periksa_Adapter;
import com.smkrevit.futnest.Model.M_Periksa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CheckTanggal extends AppCompatActivity {

    EditText etTanggal;
    RecyclerView recyclerView;
    Periksa_Adapter periksa_adapter;
    List<M_Periksa> periksaList;
    Spinner spinner, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_tanggal);
        getSupportActionBar().hide();
        load();
        isiPeriksa();
        isiSpinner();
        isiSpinner2();
    }

    public void load() {
        etTanggal = findViewById(R.id.etTanggal);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        recyclerView = findViewById(R.id.rcvPeriksa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiPeriksa(){
        periksaList = new ArrayList<M_Periksa>();
        periksaList.add(new M_Periksa("Lapangan A", "20-10-2021", "08.00-10.00"));
        periksaList.add(new M_Periksa("Lapangan B", "20-10-2021", "08.00-10.00"));

        periksa_adapter = new Periksa_Adapter(this, periksaList);
        recyclerView.setAdapter(periksa_adapter);
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

    public void isiSpinner(){
        String[] isi = {"08.00", "09.00", "10.00", "11.00", "12.00"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String >(this, android.R.layout.simple_spinner_item,isi);
        spinner.setAdapter(adapter);
    }

    public void isiSpinner2(){
        String[] isi = {"08.00", "09.00", "10.00", "11.00", "12.00"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String >(this, android.R.layout.simple_spinner_item,isi);
        spinner2.setAdapter(adapter);
    }

    public void btnPeriksaTgl(View view) {
        String pilihan = spinner.getSelectedItem().toString();
        String pilihan2 = spinner2.getSelectedItem().toString();

        System.out.println(pilihan);
        System.out.println(pilihan2);
    }
}