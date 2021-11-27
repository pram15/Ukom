package com.smkrevit.futnest;

import androidx.appcompat.app.AppCompatActivity;
import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LupaPasswordActivity extends AppCompatActivity {

    private OtpTextView otpTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);
        getSupportActionBar().hide();

        otpTextView = findViewById(R.id.KodeOtp);
        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {

            }

            @Override
            public void onOTPComplete(String otp) {
                if (otp.equals("12345")){
                    otpTextView.showSuccess();
                    Toast.makeText(LupaPasswordActivity.this, "kode benar"+otp, Toast.LENGTH_LONG).show();
                }
                else {
                    otpTextView.showError();
                    Toast.makeText(LupaPasswordActivity.this, "kode salah"+otp, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void btnLupa(View view) {
        Intent intent = new Intent(LupaPasswordActivity.this, LoginUser.class);
        startActivity(intent);
    }
}