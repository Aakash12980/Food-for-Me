package com.example.foodforme.LoginSignup.clientFragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodforme.Admin.AdminHome;
import com.example.foodforme.Client.home.AppHome;
import com.example.foodforme.LoginSignup.AdminLoginSignup;
import com.example.foodforme.LoginSignup.ClientLoginSignup;
import com.example.foodforme.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
import com.google.firebase.firestore.QuerySnapshot;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClientLogin extends Fragment {
    private String username;
    private String password;
    private String userId;
    MaterialButton loginBtn;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    public ClientLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_client_login, container, false);
        firebaseAuth = FirebaseAuth.getInstance();

        final TextInputLayout usernameView = (TextInputLayout) rootView.findViewById(R.id.client_login_username);
        final TextInputLayout passwordView = (TextInputLayout) rootView.findViewById(R.id.client_login_password);
        loginBtn = (MaterialButton) rootView.findViewById(R.id.client_login_button);
        TextView forgotPasswordVew = (TextView) rootView.findViewById(R.id.client_forgot_password);
        TextView restaurantIntent = (TextView) rootView.findViewById(R.id.restaurant_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameView.getEditText().getText().toString();
                password = passwordView.getEditText().getText().toString();
                if (TextUtils.isEmpty(username)){
                    usernameView.setError("Username field Empty!");
                    return;
                }else if (TextUtils.isEmpty(password)){
                    passwordView.setError("Password field Empty!");
                    return;
                }else{
                    firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                userId = firebaseAuth.getCurrentUser().getUid();
                                final DocumentReference documentReference = db.collection("clientUsers").document(userId);
                                documentReference.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
                                    @Override
                                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                                        try {
                                            if (! documentSnapshot.getBoolean("admin")){
                                                startActivity(new Intent(getContext(), AppHome.class));
                                                getActivity().finish();
                                            }else{
                                                Toast.makeText(getContext(), "Invalid username/password", Toast.LENGTH_SHORT).show();
                                            }
                                        }catch (Exception e2){
                                            Log.d("ClientLogin", "onEvent: \n\nReference to isAdmin not Found!\n\n");
                                        }
                                    }
                                });
                            }else{
                                Toast.makeText(getContext(), "Invalid username/password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }


            }
        });

        forgotPasswordVew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminHome.class);
                startActivity(intent);
            }
        });

        restaurantIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminLoginSignup.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
