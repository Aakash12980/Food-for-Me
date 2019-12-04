package com.example.foodforme.LoginSignup.clientFragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodforme.Client.home.AppHome;
import com.example.foodforme.LoginSignup.users.ClientUser;

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
public class ClientSignup extends Fragment {
    private String fname;
    private String lname;
    private String email;
    private String password1;
    private String password2;
    private ClientUser newUser;
    private FirebaseAuth firebaseAuth;


    public ClientSignup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_client_signup, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        final TextInputLayout fnameView = (TextInputLayout) rootView.findViewById(R.id.client_signup_fname);
        final TextInputLayout lnameView = (TextInputLayout) rootView.findViewById(R.id.client_signup_lname);
        final TextInputLayout emailView = (TextInputLayout) rootView.findViewById(R.id.client_signup_email);
        final TextInputLayout password1View = (TextInputLayout) rootView.findViewById(R.id.client_signup_password1);
        final TextInputLayout password2View = (TextInputLayout) rootView.findViewById(R.id.client_signup_password2);
        MaterialButton signupBtnView = (MaterialButton) rootView.findViewById(R.id.client_signup_button);

        signupBtnView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fname = fnameView.getEditText().getText().toString().trim();
                lname = lnameView.getEditText().getText().toString().trim();
                email = emailView.getEditText().getText().toString().trim();
                password1 = password1View.getEditText().getText().toString().trim();;
                password2 = password2View.getEditText().getText().toString().trim();


                // form validation
                if (TextUtils.isEmpty(fname)){
                    fnameView.setError("Your first name is required!");
                    return;
                }else if (TextUtils.isEmpty(lname)){
                    lnameView.setError("Your last name is required!");
                    return;
                }else if (TextUtils.isEmpty(email)){
                    emailView.setError("Your email is required!");
                    return;
                }else if (TextUtils.isEmpty(password1)){
                    password1View.setError("Password is required!");
                    return;
                }else if (TextUtils.isEmpty(password2)){
                    password2View.setError("Confirm your Password!");
                    return;
                }
                if (password1.length() < 7){
                    password1View.setError("Password should be at least 8 characters long.");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    emailView.setError("Please enter valid email address.");
                    return;
                }

                if (validatePassword(password1, password2)){
                    newUser = new ClientUser(fname, lname, email, password1);
                    firebaseAuth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getContext(), "ClientUser Account Created.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getContext(), AppHome.class));
                            }else {
                                Toast.makeText(getContext(), "Internal Error occurred!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });
                }else{
                    Toast.makeText(getContext(), "Passwords did not match!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        return rootView;
    }
    public boolean validatePassword(String pwd1, String pwd2){
        if (pwd1.equals(pwd2)){
            return true;
        }else{
            return false;
        }
    }

}
