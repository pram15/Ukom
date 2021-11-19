package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class hal_detail extends AppCompatActivity {

    ImageView imgdetail;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_detail);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        imgdetail = (ImageView) findViewById(R.id.imgLapangan);
        tv1 = (TextView) findViewById(R.id.tvNamaLapangan);
        tv2 = (TextView) findViewById(R.id.tvAlamatLapangan);
        tv3 = (TextView) findViewById(R.id.tvJumlahLapangan);
        tv4 = (TextView) findViewById(R.id.tvJamLapangan);
        tv5 = (TextView) findViewById(R.id.tvTipeLapangan);
        tv6 = (TextView) findViewById(R.id.tvLuasLapangan);
        tv7 = (TextView) findViewById(R.id.tvDetailTambahan);
        tv8 = (TextView) findViewById(R.id.Harga);

        tv1.setText(intent.getStringExtra("Nama"));
        tv2.setText(intent.getStringExtra("Alamat"));
        tv3.setText(intent.getStringExtra("Jumlah"));
        tv4.setText(intent.getStringExtra("Jam"));
        tv5.setText(intent.getStringExtra("TipeLapangan"));
        tv6.setText(intent.getStringExtra("LuasLapangan"));
        tv7.setText(intent.getStringExtra("Detail"));
        tv8.setText(Integer.toString(intent.getIntExtra("Harga", 0)));

        Glide.with(hal_detail.this)
                .load("" + intent.getStringExtra("gambar"))
                .apply(new RequestOptions().override(350, 550))
                .into(imgdetail);
    }

    public void btnCheck(View view) {
        Intent intent = new Intent(hal_detail.this, CheckTanggal.class);
        startActivity(intent);
    }
}