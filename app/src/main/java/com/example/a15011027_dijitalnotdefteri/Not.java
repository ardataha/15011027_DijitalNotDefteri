package com.example.a15011027_dijitalnotdefteri;

import java.util.Date;

public class Not {

    int id;
    private String baslik;
    private String metin;
    private Date tarih;

    public Not(int id, String baslik, String metin, Date tarih) {
        this.id = id;
        this.baslik = baslik;
        this.metin = metin;
        this.tarih = tarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getMetin() {
        return metin;
    }

    public void setMetin(String metin) {
        this.metin = metin;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }
}
