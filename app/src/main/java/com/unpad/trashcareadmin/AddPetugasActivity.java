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

import java.util.Objects;

import com.unpad.trashcareadmin.models.Warga;

public class AddPetugasActivity extends AppCompatActivity {

    private static final String TAG = AddWargaActivity.class.getSimpleName();

    EditText etNama, etAlamat, etNoTelp, etIdWarga, etPassword;
    Button submitWarga;

    FirebaseFirestore db;
    public static final String COLLECTION_NAME_KEY = "petugas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_petugas);

        db = FirebaseFirestore.getInstance();

        etNama = findViewById(R.id.inputNamaPetugas);
        etAlamat = findViewById(R.id.inputAlamatPetugas);
        etNoTelp = findViewById(R.id.inputNoTelpPetugas);
        etIdWarga = findViewById(R.id.inputIdPetugas);
        etPassword = findViewById(R.id.inputPasswordPetugas);
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
                    Toast.makeText(AddPetugasActivity.this, "Data harus diisi semua!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Warga warga = new Warga(nama, alamat, noTelp, idWarga, password);
                    db.collection(COLLECTION_NAME_KEY).document(idWarga).set(warga).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(AddPetugasActivity.this, "Data Berhasil Ditambahkan!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    etNama.getText().clear();
                    etAlamat.getText().clear();
                    etNoTelp.getText().clear();
                    etIdWarga.getText().clear();
                    etPassword.getText().clear();
                }

            }
        });

    }
}
