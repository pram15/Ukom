package com.smkrevit.futnest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataLapangan {

    @SerializedName("idmenu")
    @Expose
    private Integer idmenu;
    @SerializedName("idkategori")
    @Expose
    private Integer idkategori;
    @SerializedName("menu")
    @Expose
    private String menu;
    @SerializedName("jumlahlapangan")
    @Expose
    private String jumlahlapangan;
    @SerializedName("luaslap")
    @Expose
    private String luaslap;
    @SerializedName("jam")
    @Expose
    private String jam;
    @SerializedName("namaLapangan")
    @Expose
    private String namaLapangan;
    @SerializedName("alamatLapangan")
    @Expose
    private String alamatLapangan;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("harga")
    @Expose
    private Integer harga;
    @SerializedName("detailLap")
    @Expose
    private String detailLap;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("kategori")
    @Expose
    private String kategori;

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Integer getIdkategori() {
        return idkategori;
    }

    public void setIdkategori(Integer idkategori) {
        this.idkategori = idkategori;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getJumlahlapangan() {
        return jumlahlapangan;
    }

    public void setJumlahlapangan(String jumlahlapangan) {
        this.jumlahlapangan = jumlahlapangan;
    }

    public String getLuaslap() {
        return luaslap;
    }

    public void setLuaslap(String luaslap) {
        this.luaslap = luaslap;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getNamaLapangan() {
        return namaLapangan;
    }

    public void setNamaLapangan(String namaLapangan) {
        this.namaLapangan = namaLapangan;
    }

    public String getAlamatLapangan() {
        return alamatLapangan;
    }

    public void setAlamatLapangan(String alamatLapangan) {
        this.alamatLapangan = alamatLapangan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getDetailLap() {
        return detailLap;
    }

    public void setDetailLap(String detailLap) {
        this.detailLap = detailLap;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
