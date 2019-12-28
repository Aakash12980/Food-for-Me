package com.example.foodforme;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.foodforme.Admin.AdminHome;
import com.example.foodforme.Client.home.AppHome;
import com.example.foodforme.LoginSignup.ClientLoginSignup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (firebaseAuth.getCurrentUser() != null){
            String userId = firebaseAuth.getCurrentUser().getUid();
            DocumentReference documentReference = db.collection("clientUsers").document(userId);
            documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    Log.d("MainActivity", "\n\nonEvent: Snapshot exists: "+ documentSnapshot.exists());
                    startActivity(new Intent(getApplicationContext(), AppHome.class));
                    finish();
                }
            });
            startActivity(new Intent(this, AdminHome.class));
            finish();
        }
        Intent intent = new Intent(this, ClientLoginSignup.class);
        startActivity(intent);
        finish();
    }
}
