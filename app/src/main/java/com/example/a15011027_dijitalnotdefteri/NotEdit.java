package com.example.a15011027_dijitalnotdefteri;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class NotEdit extends AppCompatActivity {

    Not not;
    private EditText baslik, metin;
    private Button kaydet, sil;
    private DatabaseController databaseController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_edit);

        baslik = (EditText) findViewById(R.id.not_baslik_edit);
        metin = (EditText) findViewById(R.id.not_metin_edit);
        kaydet = (Button) findViewById(R.id.kaydet_button_edit);
        sil = (Button) findViewById(R.id.delete_button_edit);

        Intent intent = getIntent();
        not = intent.getParcelableExtra("Not");

        baslik.setText(not.getBaslik());
        metin.setText(not.getMetin());

        databaseController = new DatabaseController(this);
        databaseController.open();

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                not.setBaslik(baslik.getText().toString());
                not.setMetin(metin.getText().toString());
                not.setTarih(new Date());
                databaseController.notGuncelle(not);
                Intent intent = new Intent(NotEdit.this, MainActivity.class);
                startActivity(intent);
            }
        });

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog diaBox = AskOption();
                diaBox.show();
            }
        });

    }

    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                .setTitle("Sil")
                .setMessage("Bu notu silmek istediğinizden emin misiniz?")
                .setPositiveButton("Sil", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        databaseController.notSil(not);
                        Intent intent = new Intent(NotEdit.this, MainActivity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();

        return myQuittingDialogBox;
    }
}
