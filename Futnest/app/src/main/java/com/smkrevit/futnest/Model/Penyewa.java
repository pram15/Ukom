package com.smkrevit.futnest.Model;

public class Penyewa {

    private String noLapangan;
    private String namaPenyewa;
    private String tglSewa;
    private String jamSewa;
    private String btnHapus;

    public Penyewa(String noLapangan, String namaPenyewa, String tglSewa, String jamSewa, String btnHapus) {
        this.noLapangan = noLapangan;
        this.namaPenyewa = namaPenyewa;
        this.tglSewa = tglSewa;
        this.jamSewa = jamSewa;
        this.btnHapus = btnHapus;
    }

    public String getNoLapangan() {
        return noLapangan;
    }

    public void setNoLapangan(String noLapangan) {
        this.noLapangan = noLapangan;
    }

    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public void setNamaPenyewa(String namaPenyewa) {
        this.namaPenyewa = namaPenyewa;
    }

    public String getTglSewa() {
        return tglSewa;
    }

    public void setTglSewa(String tglSewa) {
        this.tglSewa = tglSewa;
    }

    public String getJamSewa() {
        return jamSewa;
    }

    public void setJamSewa(String jamSewa) {
        this.jamSewa = jamSewa;
    }

    public String getBtnHapus() {
        return btnHapus;
    }

    public void setBtnHapus(String btnHapus) {
        this.btnHapus = btnHapus;
    }
}
