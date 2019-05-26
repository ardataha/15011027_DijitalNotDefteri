package com.example.a15011027_dijitalnotdefteri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<Not> notlar = new ArrayList<Not>();
    private RecyclerView recyclerView;
    private NotlarAdapter mAdapter;
    private DatabaseController databaseController;
    private Button yeniNotButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        yeniNotButton = (Button) findViewById(R.id.yeni_not_button);
        databaseController = new DatabaseController(this);
        databaseController.open();
        notlar = databaseController.list();

        mAdapter = new NotlarAdapter(notlar);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        yeniNotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotEkle.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        databaseController.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        databaseController.close();
        super.onPause();
    }
}
