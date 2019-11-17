package com.example.foodie.Client.Login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodie.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class Signup extends AppCompatActivity {

    String fname;
    String lname;
    String email;
    String password1;
    String password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final TextInputLayout fnameView = (TextInputLayout) findViewById(R.id.signup_fname);
        final TextInputLayout lnameView = (TextInputLayout) findViewById(R.id.signup_lname);
        final TextInputLayout emailView = (TextInputLayout) findViewById(R.id.signup_email);
        final TextInputLayout password1View = (TextInputLayout) findViewById(R.id.signup_password1);
        final TextInputLayout password2View = (TextInputLayout) findViewById(R.id.signup_password2);
        MaterialButton signupBtnView = (MaterialButton) findViewById(R.id.signup_button);
        final TextView login = (TextView) findViewById(R.id.signup_login_button);

        signupBtnView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fname = fnameView.getEditText().getText().toString();
                lname = lnameView.getEditText().getText().toString();
                email = emailView.getEditText().getText().toString();
                password1 = password1View.getEditText().getText().toString();;
                password2 = password2View.getEditText().getText().toString();

                if (validatePassword(password1, password2)){

                } else
                    Toast.makeText(v.getContext(), "Passwords did not match!", Toast.LENGTH_SHORT);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Login.class);
                startActivity(intent);
            }
        });

    }
    public boolean validatePassword(String pwd1, String pwd2){
        return pwd1 == pwd2? true:false;
    }
}
