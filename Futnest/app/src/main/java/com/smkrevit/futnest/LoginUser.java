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
import com.smkrevit.futnest.Model.GetLoginUser;
import com.smkrevit.futnest.Model.M_LoginAdmin;
import com.smkrevit.futnest.Model.M_LoginUser;
import com.smkrevit.futnest.Rest.ApiClientLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUser extends AppCompatActivity {

    Button btnPembeli;
    EditText etEmail, etPassword;
    TextView noAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        getSupportActionBar().hide();

        btnPembeli = findViewById(R.id.btnUser);
        etEmail = findViewById(R.id.etEmailuser);
        etPassword = findViewById(R.id.etPassUser);

        btnPembeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etEmail.getText().toString()) || TextUtils.isEmpty(etPassword.getText().toString())){

                    String message = "Isi semua data ngab";
                    Toast.makeText(LoginUser.this,message, Toast.LENGTH_LONG).show();
                }else {
                    M_LoginUser loginUserRequest = new M_LoginUser();
                    loginUserRequest.setEmail(etEmail.getText().toString());
                    loginUserRequest.setPassword(etPassword.getText().toString());

                    loginUser(loginUserRequest);
                }
            }
        });
    }

    public void loginUser(M_LoginUser m_loginUser){
        Call<GetLoginUser> loginUserCall = ApiClientLogin.getService().loginUser(m_loginUser);
        loginUserCall.enqueue(new Callback<GetLoginUser>() {
            @Override
            public void onResponse(Call<GetLoginUser> call, Response<GetLoginUser> response) {

                if (response.isSuccessful()){

                    M_LoginUser m_loginUser1 = response.body().getData();
                    startActivity(new Intent(LoginUser.this, Profil.class).putExtra("user",m_loginUser1));
                    finish();

                }else {
                    String message = "Kurang ngab";
                    Toast.makeText(LoginUser.this,message, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GetLoginUser> call, Throwable t) {

                String message = "Salah ngab";
                Toast.makeText(LoginUser.this, message, Toast.LENGTH_LONG).show();

            }
        });
    }

//    public void btnLoginUser() {
//        Intent intent = new Intent(LoginUser.this, Home.class);
//        startActivity(intent);
//    }
}