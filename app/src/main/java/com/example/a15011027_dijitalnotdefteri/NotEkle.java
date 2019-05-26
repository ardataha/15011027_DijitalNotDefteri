package com.example.a15011027_dijitalnotdefteri;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.util.Date;

public class NotEkle extends AppCompatActivity {

    private EditText baslik, metin;
    private Button kaydet;
    private DatabaseController databaseController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_ekle);

        baslik = (EditText) findViewById(R.id.not_baslik);
        metin = (EditText) findViewById(R.id.not_metin);
        kaydet = (Button) findViewById(R.id.kaydet_button);

        databaseController = new DatabaseController(this);
        databaseController.open();

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date = new Date();
                Not not = new Not(1, baslik.getText().toString(), metin.getText().toString(), date);
                databaseController.notEkle(not);
                Intent intent = new Intent(NotEkle.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
