package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void btnLoginAdmin(View view) {
        Intent intent = new Intent(MainActivity.this, LoginAdmin.class);
        startActivity(intent);
    }

    public void btnLoginUser(View view) {
        Intent intent = new Intent(MainActivity.this, LoginUser.class);
        startActivity(intent);
    }

    public void btnHome(View view) {
        Intent intent = new Intent(MainActivity.this, Home.class);
        startActivity(intent);
    }

    public void btnRegister(View view) {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }
}