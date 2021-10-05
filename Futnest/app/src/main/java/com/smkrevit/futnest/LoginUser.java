package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginUser extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        getSupportActionBar().hide();
        button = (Button) findViewById(R.id.btnUser);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLoginUser();
            }
        });
    }

    public void btnLoginUser() {
        Intent intent = new Intent(LoginUser.this, Home.class);
        startActivity(intent);
    }
}