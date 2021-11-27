package com.smkrevit.futnest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetLoginAdmin implements Serializable {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("pesan")
    @Expose
    private String pesan;
    @SerializedName("data")
    @Expose
    private M_LoginAdmin data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public M_LoginAdmin getData() {
        return data;
    }

    public void setData(M_LoginAdmin data) {
        this.data = data;
    }
}
