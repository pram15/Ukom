package com.smkrevit.futnest;

public class DataLapangan {

    private String namaLapangan;
    private String deskripsi;
    private Integer Imagelap;

    public DataLapangan(String namaLapangan, String deskripsi, Integer imagelap) {
        this.namaLapangan = namaLapangan;
        this.deskripsi = deskripsi;
        this.Imagelap = imagelap;
    }

    public String getNamaLapangan() {
        return namaLapangan;
    }

    public void setNamaLapangan(String namaLapangan) {
        this.namaLapangan = namaLapangan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getImagelap() {
        return Imagelap;
    }

    public void setImagelap(Integer imagelap) {
        Imagelap = imagelap;
    }
}
