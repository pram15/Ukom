package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginAdmin extends AppCompatActivity {

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        getSupportActionBar().hide();
        button = (Button) findViewById(R.id.btnAdmin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAdminIsiData();

            }
        });
    }

    public void btnAdminIsiData() {
        Intent intent = new Intent(LoginAdmin.this, IsiData.class);
        startActivity(intent);
    }
}