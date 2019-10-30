package com.unpad.trashcareadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button tambahWarga;
    private Button tambahPetugas;
    private Button tambahArtikel;
    private Button lihatFeedback;
    private Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tambahWarga = findViewById(R.id.btnTambahWarga);
        tambahPetugas = findViewById(R.id.btnTambahPetugas);
        tambahArtikel = findViewById(R.id.btnTambahArtikel);
        lihatFeedback = findViewById(R.id.btnLihatFeedback);
        logOut = findViewById(R.id.btnLogOut);

        tambahWarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent warga = new Intent(MainActivity.this, AddWargaActivity.class);
                startActivity(warga);
            }
        });

        tambahPetugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent petugas = new Intent(MainActivity.this, AddPetugasActivity.class);
                startActivity(petugas);
            }
        });

    }


}
