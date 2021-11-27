package com.smkrevit.futnest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Riwayat {

    @SerializedName("iddetail")
    @Expose
    private Integer iddetail;
    @SerializedName("idorder")
    @Expose
    private Integer idorder;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("NoTelpPemilik")
    @Expose
    private String noTelpPemilik;
    @SerializedName("idmenu")
    @Expose
    private Integer idmenu;
    @SerializedName("jumlah")
    @Expose
    private Integer jumlah;
    @SerializedName("hargajual")
    @Expose
    private Integer hargajual;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("tglorder")
    @Expose
    private String tglorder;
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
    @SerializedName("pilLap")
    @Expose
    private String pilLap;
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

    public Integer getIddetail() {
        return iddetail;
    }

    public void setIddetail(Integer iddetail) {
        this.iddetail = iddetail;
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelpPemilik() {
        return noTelpPemilik;
    }

    public void setNoTelpPemilik(String noTelpPemilik) {
        this.noTelpPemilik = noTelpPemilik;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getHargajual() {
        return hargajual;
    }

    public void setHargajual(Integer hargajual) {
        this.hargajual = hargajual;
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

    public String getTglorder() {
        return tglorder;
    }

    public void setTglorder(String tglorder) {
        this.tglorder = tglorder;
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

    public String getPilLap() {
        return pilLap;
    }

    public void setPilLap(String pilLap) {
        this.pilLap = pilLap;
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

}
