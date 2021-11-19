package com.smkrevit.futnest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smkrevit.futnest.Adapter.LapanganAdapter;
import com.smkrevit.futnest.Model.DataLapangan;
import com.smkrevit.futnest.Model.GetDataLapangan;
import com.smkrevit.futnest.Rest.ApiClient;
import com.smkrevit.futnest.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    Button button;
    Button btnDetail;
    ImageButton imageButton;
    ApiInterface mApiInterface;
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static Home ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        mRecycleView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager((mLayoutManager));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;


        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.beranda:

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
//
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        DataLapangan[] dataLapangans = new DataLapangan[]{
//          new DataLapangan("TIZA", "Perumahan Puri Indah, Rp.70.000",R.drawable.tiza),
//          new DataLapangan("PIS", "Perumahan Puri Indah, Rp.70.000",R.drawable.pis),
//          new DataLapangan("BUDURAN FUTSAL", "Buduran, Rp.70.000",R.drawable.logo),
//          new DataLapangan("PANJI", "Buduran, Rp.70.000",R.drawable.logo),
//          new DataLapangan("FLAMINIO", "Jl. Teuku Umar II No.2, Gajah Timur, Magersari, Kec. Sidoarjo, Kabupaten Sidoarjo, Jawa Timur 61212, Rp.70.000",R.drawable.logo),
//        };
//
//        LapanganAdapter myLapanganAdapter = new LapanganAdapter(dataLapangans,Home.this);
//        recyclerView.setAdapter(myLapanganAdapter);
//
//    }
//
//    public void btnDetail(View view) {
//
//    }

        panggilRetrofit();

    }

    public void panggilRetrofit(){
        Call<GetDataLapangan> kontakCall = mApiInterface.getMenu();
        kontakCall.enqueue(new Callback<GetDataLapangan>() {
            @Override
            public void onResponse(Call<GetDataLapangan> call, Response<GetDataLapangan>
                    response) {
                List<DataLapangan> KontakList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(KontakList.size()));
                mAdapter = new LapanganAdapter(KontakList);
                mRecycleView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetDataLapangan> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}