package com.smkrevit.futnest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.smkrevit.futnest.Model.GetRegister;
import com.smkrevit.futnest.Model.M_Register;
import com.smkrevit.futnest.Rest.ApiClient;
import com.smkrevit.futnest.Rest.ApiClientLogin;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    Button btnRegis;
    EditText etNama, etEmail, etPass, etAlamat, etNoTelp;

    Button btnverifyCaptcha;
    String SITE_KEY = "6LcFnFIdAAAAALydJpwOqFCpIPo5HkgjDsm1QtLy";
    String SECRET_KEY = "6LcFnFIdAAAAADTjQizZ5tiSO0yS8BPp-fMj4RRJ";
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        btnRegis = findViewById(R.id.btnRegis);
        etNama = findViewById(R.id.tvNama);
        etEmail = findViewById(R.id.tvEmail);
        etPass = findViewById(R.id.tvPass);
        etNoTelp = findViewById(R.id.tvNoTelp);
        etAlamat = findViewById(R.id.tvAlamat);

        queue = Volley.newRequestQueue(getApplicationContext());
        btnverifyCaptcha = findViewById(R.id.btnCap);
        btnverifyCaptcha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyGoogleReCAPTCHA();
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etEmail.getText().toString()) || TextUtils.isEmpty(etNama.getText().toString())
                        || TextUtils.isEmpty(etPass.getText().toString()) || TextUtils.isEmpty(etNoTelp.getText().toString())
                        || TextUtils.isEmpty(etAlamat.getText().toString())) {

                    String message = "Kurang Ngab";
                    Toast.makeText(Register.this, message, Toast.LENGTH_LONG).show();
                } else {
                    M_Register m_register = new M_Register();
                    m_register.setNama(etNama.getText().toString());
                    m_register.setEmail(etEmail.getText().toString());
                    m_register.setPassword(etPass.getText().toString());
                    m_register.setRelasi(etNoTelp.getText().toString());
                    m_register.setLevel(etAlamat.getText().toString());
                    registerUser(m_register);
                }
            }
        });
    }

        public void registerUser(M_Register m_register){

            Call<GetRegister> getRegisterCall = ApiClientLogin.getService().registerUser(m_register);
            getRegisterCall.enqueue(new Callback<GetRegister>() {
                @Override
                public void onResponse(Call<GetRegister> call, Response<GetRegister> response) {

                    if (response.isSuccessful()){

                        String message = "Masuk ngab";
                        Toast.makeText(Register.this,message, Toast.LENGTH_LONG).show();

                        startActivity(new Intent(Register.this, MainActivity.class));
                        finish();

                    }else {
                        String message = "Registrasi sek ngab";
                        Toast.makeText(Register.this,message, Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<GetRegister> call, Throwable t) {

                    String message = t.getLocalizedMessage();
                    Toast.makeText(Register.this, message, Toast.LENGTH_LONG).show();

                }
            });
        }

    private void verifyGoogleReCAPTCHA() {

        // below line is use for getting our safety
        // net client and verify with reCAPTCHA
        SafetyNet.getClient(this).verifyWithRecaptcha(SITE_KEY)
                // after getting our client we have
                // to add on success listener.
                .addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                    @Override
                    public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                        // in below line we are checking the response token.
                        if (!response.getTokenResult().isEmpty()) {
                            // if the response token is not empty then we
                            // are calling our verification method.
                            handleVerification(response.getTokenResult());
                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // this method is called when we get any error.
                        if (e instanceof ApiException) {
                            ApiException apiException = (ApiException) e;
                            // below line is use to display an error message which we get.
                            Log.d("TAG", "Error message: " +
                                    CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                        } else {
                            // below line is use to display a toast message for any error.
                            Toast.makeText(Register.this, "Error found is : " + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    protected void handleVerification(final String responseToken) {
        // inside handle verification method we are
        // verifying our user with response token.
        // url to sen our site key and secret key
        // to below url using POST method.
        String url = "https://www.google.com/recaptcha/api/siteverify";

        // in this we are making a string request and
        // using a post method to pass the data.
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // inside on response method we are checking if the
                        // response is successful or not.
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getBoolean("success")) {
                                // if the response is successful then we are
                                // showing below toast message.
                                Toast.makeText(Register.this, "User verified with reCAPTCHA", Toast.LENGTH_SHORT).show();
                            } else {
                                // if the response if failure we are displaying
                                // a below toast message.
                                Toast.makeText(getApplicationContext(), String.valueOf(jsonObject.getString("error-codes")), Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception ex) {
                            // if we get any exception then we are
                            // displaying an error message in logcat.
                            Log.d("TAG", "JSON exception: " + ex.getMessage());
                        }
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // inside error response we are displaying
                        // a log message in our logcat.
                        Log.d("TAG", "Error message: " + error.getMessage());
                    }
                }) {
            // below is the getParamns method in which we will
            // be passing our response token and secret key to the above url.
            @Override
            protected Map<String, String> getParams() {
                // we are passing data using hashmap
                // key and value pair.
                Map<String, String> params = new HashMap<>();
                params.put("secret", SECRET_KEY);
                params.put("response", responseToken);
                return params;
            }
        };
        // below line of code is use to set retry
        // policy if the api fails in one try.
        request.setRetryPolicy(new DefaultRetryPolicy(
                // we are setting time for retry is 5 seconds.
                50000,

                // below line is to perform maximum retries.
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // at last we are adding our request to queue.
        queue.add(request);
    }

}