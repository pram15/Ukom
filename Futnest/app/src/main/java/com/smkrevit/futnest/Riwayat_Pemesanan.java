package com.smkrevit.futnest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smkrevit.futnest.Adapter.LapanganAdapter;
import com.smkrevit.futnest.Adapter.Riwayat_Adapter;
import com.smkrevit.futnest.Model.DataLapangan;
import com.smkrevit.futnest.Model.GetDataLapangan;
import com.smkrevit.futnest.Model.GetRiwayat;
import com.smkrevit.futnest.Model.Riwayat;
import com.smkrevit.futnest.Rest.ApiClient;
import com.smkrevit.futnest.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Riwayat_Pemesanan extends AppCompatActivity {

    Button button;
    Button btnDetail;
    ImageButton imageButton;
    ApiInterface mApiInterface;
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayout;
    public static Riwayat_Pemesanan ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat__pemesanan);
        getSupportActionBar().hide();

        mRecycleView = (RecyclerView) findViewById(R.id.rcvRiwayat);
        mLayout = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager((mLayout));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.riwayat);

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
                        startActivity(new Intent(getApplicationContext()
                                ,Profil.class));
                        overridePendingTransition(0,0);
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

//        load();
//        isiRiwayat();

        panggilRetrofit();
    }

//    public void load(){
//        recyclerView = findViewById(R.id.rcvRiwayat);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }

//    public void isiRiwayat(){
//        riwayatList = new ArrayList<Riwayat>();
//        riwayatList.add(new Riwayat("Raden", "Kahuripan", "15-06-2021", "08.00 - 10.00"));
//        riwayatList.add(new Riwayat("Burhan", "Kahuripan", "15-06-2021", "10.00 - 12.00"));
//        riwayatList.add(new Riwayat("Dewa", "Villa Jasmine", "15-06-2021", "12.00 - 14.00"));
//        riwayatList.add(new Riwayat("Shopie", "Jati", "16-06-2021", "08.00 - 10.00"));
//        riwayatList.add(new Riwayat("Suep", "Cemeng", "17-06-2021", "08.00 - 10.00"));
//        riwayatList.add(new Riwayat("Pram", "Kahuripan", "18-06-2021", "08.00 - 10.00"));
//        riwayatList.add(new Riwayat("Hapsari", "Kahuripan", "15-08-2021", "16.00 - 18.00"));
//        riwayatList.add(new Riwayat("Raden", "Kahuripan", "15-06-2021", "08.00 - 10.00"));
//
//        riwayat_adapter = new Riwayat_Adapter(this,riwayatList);
//        recyclerView.setAdapter(riwayat_adapter);
//    }

    public void panggilRetrofit(){
        Call<GetRiwayat> kontakCall = mApiInterface.getOrder();
        kontakCall.enqueue(new Callback<GetRiwayat>() {
            @Override
            public void onResponse(Call<GetRiwayat> call, Response<GetRiwayat>
                    response) {
                List<Riwayat> OrderList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(OrderList.size()));
                mAdapter = new Riwayat_Adapter(OrderList);
                mRecycleView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetRiwayat> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}