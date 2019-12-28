package com.example.foodforme.LoginSignup.adminFragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodforme.Admin.AdminHome;
import com.example.foodforme.LoginSignup.ClientLoginSignup;
import com.example.foodforme.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminLogin extends Fragment {
    private String username;
    private String password;
    private String userId;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    public AdminLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_admin_login, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        final TextInputLayout usernameView = (TextInputLayout) rootView.findViewById(R.id.admin_login_username);
        final TextInputLayout passwordView = (TextInputLayout) rootView.findViewById(R.id.admin_login_password);
        MaterialButton loginBtn = (MaterialButton) rootView.findViewById(R.id.admin_login_button);
        TextView forgotPasswordVew = (TextView) rootView.findViewById(R.id.admin_forgot_password);
        final TextView customerIntent = (TextView) rootView.findViewById(R.id.customer_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameView.getEditText().getText().toString();
                password = passwordView.getEditText().getText().toString();

                firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            userId = firebaseAuth.getCurrentUser().getUid();
                            final DocumentReference documentReference = db.collection("adminUsers").document(userId);
                            documentReference.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
                                @Override
                                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                                    try {
                                        if (documentSnapshot.getBoolean("admin")){
                                            startActivity(new Intent(getContext(), AdminHome.class));
                                            getActivity().finish();
                                        }else{
                                            Toast.makeText(getContext(), "Invalid username/password", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (Exception e2){
                                        Log.d("AdminLogin", "onEvent: \n\nReference to isAdmin not Found!\n\n");
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(getContext(), "Invalid username/password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        forgotPasswordVew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminHome.class);
                startActivity(intent);
            }
        });

        customerIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ClientLoginSignup.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
