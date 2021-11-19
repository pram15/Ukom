package com.smkrevit.futnest.Model;

public class M_Periksa {

    private String NoLap;
    private String TglPeriksa;
    private String JamPeriksa;


    public M_Periksa(String noLap, String tglPeriksa, String jamPeriksa) {
        this.NoLap = noLap;
        this.TglPeriksa = tglPeriksa;
        this.JamPeriksa = jamPeriksa;

    }

    public String getNoLap() {
        return NoLap;
    }

    public void setNoLap(String noLap) {
        NoLap = noLap;
    }

    public String getTglPeriksa() {
        return TglPeriksa;
    }

    public void setTglPeriksa(String tglPeriksa) {
        TglPeriksa = tglPeriksa;
    }

    public String getJamPeriksa() {
        return JamPeriksa;
    }

    public void setJamPeriksa(String jamPeriksa) {
        JamPeriksa = jamPeriksa;
    }

}
