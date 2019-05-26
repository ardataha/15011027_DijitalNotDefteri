package com.example.a15011027_dijitalnotdefteri;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Not implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.baslik);
        dest.writeString(this.metin);
        dest.writeLong(this.tarih != null ? this.tarih.getTime() : -1);
    }

    protected Not(Parcel in) {
        this.id = in.readInt();
        this.baslik = in.readString();
        this.metin = in.readString();
        long tmpTarih = in.readLong();
        this.tarih = tmpTarih == -1 ? null : new Date(tmpTarih);
    }

    public static final Parcelable.Creator<Not> CREATOR = new Parcelable.Creator<Not>() {
        @Override
        public Not createFromParcel(Parcel source) {
            return new Not(source);
        }

        @Override
        public Not[] newArray(int size) {
            return new Not[size];
        }
    };
}
