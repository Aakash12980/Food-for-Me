package com.example.foodforme.LoginSignup.adminFragments;


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

import com.example.foodforme.Admin.AdminHome;
import com.example.foodforme.LoginSignup.users.RestaurantUser;
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
public class AdminSignup extends Fragment {
    private String name;
    private String address;
    private String email;
    private String password1;
    private String password2;
    private RestaurantUser newUser;
    private FirebaseAuth firebaseAuth;

    public AdminSignup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_admin_signup, container, false);

        final TextInputLayout restaurantNameView = (TextInputLayout) rootView.findViewById(R.id.admin_signup_restaurant_name);
        final TextInputLayout restaurantAddressView = (TextInputLayout) rootView.findViewById(R.id.admin_signup_restaurant_address);
        final TextInputLayout emailView = (TextInputLayout) rootView.findViewById(R.id.admin_signup_email);
        final TextInputLayout password1View = (TextInputLayout) rootView.findViewById(R.id.admin_signup_password1);
        final TextInputLayout password2View = (TextInputLayout) rootView.findViewById(R.id.admin_signup_password2);
        MaterialButton signupBtnView = (MaterialButton) rootView.findViewById(R.id.admin_signup_button);

        firebaseAuth = FirebaseAuth.getInstance();

        signupBtnView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                name = restaurantNameView.getEditText().getText().toString();
                address = restaurantAddressView.getEditText().getText().toString();
                email = emailView.getEditText().getText().toString();
                password1 = password1View.getEditText().getText().toString();;
                password2 = password2View.getEditText().getText().toString();

                // form validation
                if (TextUtils.isEmpty(name)){
                    restaurantNameView.setError("Your first name is required!");
                    return;
                }else if (TextUtils.isEmpty(address)){
                    restaurantAddressView.setError("Your last name is required!");
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
                    newUser = new RestaurantUser(name, address, email, password1);
                    firebaseAuth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getContext(), "ClientUser Account Created.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getContext(), AdminHome.class));
                            }else{
                                Toast.makeText(getContext(), "Internal Error Occurred!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else{
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
