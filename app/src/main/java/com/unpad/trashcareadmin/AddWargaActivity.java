package com.unpad.trashcareadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import Model.WargaModel;

public class AddWargaActivity extends AppCompatActivity {

    private static final String TAG = AddWargaActivity.class.getSimpleName();

    EditText etNama, etAlamat, etNoTelp, etIdWarga, etPassword;
    Button submitWarga;

    FirebaseFirestore db;
    public static final String COLLECTION_NAME_KEY = "warga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_warga);

        db = FirebaseFirestore.getInstance();

        etNama = findViewById(R.id.inputNama);
        etAlamat = findViewById(R.id.inputAlamat);
        etNoTelp = findViewById(R.id.inputNoTelp);
        etIdWarga = findViewById(R.id.inputIdWarga);
        etPassword = findViewById(R.id.inputPassword);
        submitWarga = findViewById(R.id.btnSubmit);

        submitWarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = Objects.requireNonNull(etNama.getText().toString());
                String alamat = Objects.requireNonNull(etAlamat.getText().toString());
                String noTelp = Objects.requireNonNull(etNoTelp.getText().toString());
                String idWarga = Objects.requireNonNull(etIdWarga.getText().toString());
                String password = Objects.requireNonNull(etPassword.getText().toString());

                if (TextUtils.isEmpty(nama) || TextUtils.isEmpty(alamat) || TextUtils.isEmpty(noTelp) || TextUtils.isEmpty(idWarga) || TextUtils.isEmpty(password)) {
                    Toast.makeText(AddWargaActivity.this, "Data harus diisi semua!", Toast.LENGTH_SHORT).show();
                }
                else {
                    WargaModel warga = new WargaModel(nama, alamat, noTelp, idWarga, password);
                    db.collection(COLLECTION_NAME_KEY).document(idWarga).set(warga).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(AddWargaActivity.this, "Data Berhasil Ditambahkan!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}
