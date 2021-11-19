package com.smkrevit.futnest.Rest;

import com.smkrevit.futnest.Model.GetDataLapangan;
import com.smkrevit.futnest.Model.GetRiwayat;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/api/menu")
    Call<GetDataLapangan> getMenu();

    @GET("/api/order")
    Call<GetRiwayat> getOrder();

}
