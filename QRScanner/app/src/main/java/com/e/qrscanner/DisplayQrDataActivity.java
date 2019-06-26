package com.e.qrscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class DisplayQrDataActivity extends AppCompatActivity {
    private static final String TAG = "CardListActivity";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_qr_data);
        Intent i=getIntent();
        List<QrData> list=(List<QrData>)i.getSerializableExtra("qrlist");
        recyclerView=findViewById(R.id.recycler_view);
        QrDataListGenerator adapter = new QrDataListGenerator(list);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

    }
}
