package com.example.foodforme.LoginSignup.clientFragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodforme.Admin.AdminHome;
import com.example.foodforme.Client.home.AppHome;
import com.example.foodforme.LoginSignup.AdminLoginSignup;
import com.example.foodforme.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClientLogin extends Fragment {
    private String username;
    private String password;
    MaterialButton loginBtn;
    private FirebaseAuth firebaseAuth;


    public ClientLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_client_login, container, false);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getContext(), AdminHome.class));
        }

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
                firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(getContext(), AppHome.class));
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
