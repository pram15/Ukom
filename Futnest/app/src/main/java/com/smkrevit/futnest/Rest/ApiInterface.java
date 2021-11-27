package com.smkrevit.futnest.Rest;

import com.smkrevit.futnest.Model.GetDataLapangan;
import com.smkrevit.futnest.Model.GetLoginAdmin;
import com.smkrevit.futnest.Model.GetLoginUser;
import com.smkrevit.futnest.Model.GetRegister;
import com.smkrevit.futnest.Model.GetRiwayat;
import com.smkrevit.futnest.Model.M_LoginAdmin;
import com.smkrevit.futnest.Model.M_LoginUser;
import com.smkrevit.futnest.Model.M_Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/api/menu")
    Call<GetDataLapangan> getMenu();

    @GET("/api/detail")
    Call<GetRiwayat> getDetail();

    @POST("/api/login")
    Call<GetLoginAdmin> loginAdmin(@Body M_LoginAdmin m_loginAdmin);

    @POST("/api/login")
    Call<GetLoginUser> loginUser(@Body M_LoginUser m_loginUser);

    @POST("/api/register")
    Call<GetRegister> registerUser(@Body M_Register m_register);

}
