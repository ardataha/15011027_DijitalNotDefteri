package com.example.a15011027_dijitalnotdefteri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DatabaseController {

    SQLiteDatabase db;
    SQLiteHelper mdb;

    public DatabaseController(Context context) {
        mdb = new SQLiteHelper(context, "Notlar", null, 1);
    }

    public void open(){
        db = mdb.getWritableDatabase();
    }

    public void close() {
        mdb.close();
    }

    public void notEkle(Not not) {
        ContentValues values = new ContentValues();
        values.put("baslik", not.getBaslik());
        values.put("metin", not.getMetin());
        Date tarih = not.getTarih();
        SimpleDateFormat objSDF = new SimpleDateFormat("dd MMM yyyy");
        values.put("tarih", objSDF.format(tarih));
        db.insert("NOTLAR", null, values);
    }

    public void notSil(Not not) {
        int id = not.getId();
        db.delete("NOTLAR", "id="+id, null);
    }

    public List<Not> list() {
        List<Not> notlar = new ArrayList<Not>();

        String columns[] = {"id", "baslik", "metin"};
        Cursor c = db.query("NOTLAR", columns, null, null, null, null, null);
        c.moveToFirst();

        while(!c.isAfterLast()) {
            int id = c.getInt(0);
            String baslik = c.getString(1);
            String metin = c.getString(2);
            String tarihString = (c.getString(3));
            Date tarih = new SimpleDateFormat("dd MM yyyy").parse(tarihString, new ParsePosition(0));
            Not not = new Not(id, baslik, metin, tarih);
            notlar.add(not);
        }

        return notlar;
    }
}
