package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.smkrevit.futnest.Adapter.Lapangan_Admin_Adapter;
import com.smkrevit.futnest.Model.Lapangan_Admin;

import java.util.ArrayList;
import java.util.List;

public class Recycler_Lapangan_Admin extends AppCompatActivity {

    RecyclerView recyclerView;
    Lapangan_Admin_Adapter lapangan_admin_adapter;
    List<Lapangan_Admin> lapangan_adminList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler__lapangan__admin);
        getSupportActionBar().hide();

        load();
        isiNomer();
    }

    public void load(){
        recyclerView = findViewById(R.id.rcvNomerLap);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiNomer(){
        lapangan_adminList = new ArrayList<Lapangan_Admin>();
        lapangan_adminList.add(new Lapangan_Admin("A"));
        lapangan_adminList.add(new Lapangan_Admin("B"));
        lapangan_adminList.add(new Lapangan_Admin("C"));
        lapangan_adminList.add(new Lapangan_Admin("D"));
        lapangan_adminList.add(new Lapangan_Admin("E"));

        lapangan_admin_adapter = new Lapangan_Admin_Adapter(this,lapangan_adminList);
        recyclerView.setAdapter(lapangan_admin_adapter);
    }
}