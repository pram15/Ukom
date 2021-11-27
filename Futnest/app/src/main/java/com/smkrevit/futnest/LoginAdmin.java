package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smkrevit.futnest.Model.GetLoginAdmin;
import com.smkrevit.futnest.Model.GetRegister;
import com.smkrevit.futnest.Model.M_LoginAdmin;
import com.smkrevit.futnest.Rest.ApiClientLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginAdmin extends AppCompatActivity {

    Button btnPenjual;
    EditText etEmail, etPassword;
    TextView noAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        getSupportActionBar().hide();

        btnPenjual = findViewById(R.id.btnAdmin);
        etEmail = findViewById(R.id.etEmailPenjual);
        etPassword = findViewById(R.id.etPassPenjual);

        btnPenjual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etEmail.getText().toString()) || TextUtils.isEmpty(etPassword.getText().toString())){

                    String message = "Login dulu ngab";
                    Toast.makeText(LoginAdmin.this,message, Toast.LENGTH_LONG).show();
                }else {
                    M_LoginAdmin loginAdminRequest = new M_LoginAdmin();
                    loginAdminRequest.setEmail(etEmail.getText().toString());
                    loginAdminRequest.setPassword(etPassword.getText().toString());

                    loginAdmin(loginAdminRequest);
                }
            }
        });
    }

    public void loginAdmin(M_LoginAdmin m_loginAdmin){
        Call<GetLoginAdmin> loginAdminResponseCall = ApiClientLogin.getService().loginAdmin(m_loginAdmin);
        loginAdminResponseCall.enqueue(new Callback<GetLoginAdmin>() {
            @Override
            public void onResponse(Call<GetLoginAdmin> call, Response<GetLoginAdmin> response) {

                if (response.isSuccessful()){

                    M_LoginAdmin m_loginAdmin1 = response.body().getData();
                    startActivity(new Intent(LoginAdmin.this, Profil.class).putExtra("foto",m_loginAdmin1));
                    finish();

                }else {
                    String message = "Kurang ngab";
                    Toast.makeText(LoginAdmin.this,message, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GetLoginAdmin> call, Throwable t) {

                String message = "Salah ngab";
                Toast.makeText(LoginAdmin.this, message, Toast.LENGTH_LONG).show();

            }
        });
    }

    public void btnLupaPass(View view) {
        Intent intent = new Intent(LoginAdmin.this, LupaPasswordActivity.class);
        startActivity(intent);
    }
}