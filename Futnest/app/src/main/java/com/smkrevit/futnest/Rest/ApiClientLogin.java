package com.smkrevit.futnest.Rest;

import com.smkrevit.futnest.Model.M_LoginAdmin;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientLogin {
    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.94.67:1000/")
                .client(okHttpClient)
                .build();

        return retrofit;

    }

    public static ApiInterface getService(){
        ApiInterface apiInterface = getRetrofit().create(ApiInterface.class);

        return apiInterface;
    }
}
