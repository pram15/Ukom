package com.smkrevit.futnest;

public class Riwayat {

    private String nama;
    private String alamat;
    private String tanggal;
    private String jam;

    public Riwayat(String nama, String alamat, String tanggal, String jam) {
        this.nama = nama;
        this.alamat = alamat;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
}
