package com.example.foodforme.LoginSignup.adminFragments;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodforme.Admin.AdminHome;
import com.example.foodforme.LoginSignup.users.RestaurantUser;
import com.example.foodforme.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

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
    private String userId;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "AdminSignup";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    public AdminSignup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_admin_signup, container, false);

        final TextView restaurantNameView = (TextView) rootView.findViewById(R.id.admin_signup_restaurant_name);
        final TextInputLayout emailView = (TextInputLayout) rootView.findViewById(R.id.admin_signup_email);
        final TextInputLayout password1View = (TextInputLayout) rootView.findViewById(R.id.admin_signup_password1);
        final TextInputLayout password2View = (TextInputLayout) rootView.findViewById(R.id.admin_signup_password2);
        MaterialButton signupBtnView = (MaterialButton) rootView.findViewById(R.id.admin_signup_button);

        firebaseAuth = FirebaseAuth.getInstance();

        if(isServicesOK()){
            restaurantNameView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getContext(), MapActivity.class);
                    startActivity(i);
                }
            });
        }

        signupBtnView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                email = emailView.getEditText().getText().toString();
                password1 = password1View.getEditText().getText().toString();;
                password2 = password2View.getEditText().getText().toString();

                // form validation
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(getContext(), "Please select your Restaurant", Toast.LENGTH_SHORT).show();
                    return;
                }else if (TextUtils.isEmpty(email)){
                    emailView.setError("Email is required!");
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

                    firebaseAuth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                newUser = new RestaurantUser(name, address, email, password1);
                                userId = firebaseAuth.getCurrentUser().getUid();
                                final DocumentReference documentReference = db.collection("adminUsers").document(userId);
                                documentReference.set(newUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d("AdminSignup", "DocumentSnapshot added with ID: " + documentReference.getId());
                                        Toast.makeText(getContext(), "AdminUser Account Created.", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getContext(), AdminHome.class));
                                        getActivity().finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w("AdminSignup", "Error adding document", e);
                                    }
                                });

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

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: Checking Google Play Services version.");
        int availability = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getContext());
        if (availability == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServicesOK: Google Play Services is Working.");
            return true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(availability)){
            Log.d(TAG, "isServicesOK: an error occur but we can fix it.");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(getActivity(), availability, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(getContext(), "We cannot map request.", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public boolean validatePassword(String pwd1, String pwd2){
        if (pwd1.equals(pwd2)){
            return true;
        }else{
            return false;
        }
    }
}
