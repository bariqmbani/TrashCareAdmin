package com.unpad.trashcareadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import Model.AdminLoginModel;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    EditText admUsername, admPassword;
    private DatabaseReference databaseReference;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static  final  String COLLECTION_NAME_KEY = "admin";
    public static  final  String USERNAME_KEY = "username";
    public static  final  String PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        admUsername = findViewById(R.id.inputUsername);
        admPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("admin");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!admUsername.getText().toString().equals("") && !admPassword.getText().toString().equals("")) {
                    DocumentReference docRef = db.collection(COLLECTION_NAME_KEY).document(admUsername.getText().toString());
                    docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                AdminLoginModel user = documentSnapshot.toObject(AdminLoginModel.class);
                                if (user.getPassword().equals(admPassword.getText().toString())) {
                                    Toast.makeText(getApplicationContext(), "welcome admin", Toast.LENGTH_SHORT).show();
                                    Intent in = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(in);
                                } else {
                                    Toast.makeText(LoginActivity.this, "Passsword Mismatching", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Check your Username ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Username or Password Cannot be Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
