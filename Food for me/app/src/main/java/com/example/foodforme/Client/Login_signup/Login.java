package com.example.foodforme.Client.Login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodforme.Admin.Home.AdminHome;
import com.example.foodforme.R;
import com.example.foodforme.Client.home.AppHome;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    private String username;
    private String password;
    MaterialButton loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final TextInputLayout usernameView = (TextInputLayout) findViewById(R.id.login_username);
        final TextInputLayout passwordView = (TextInputLayout) findViewById(R.id.login_password);
        loginBtn = (MaterialButton) findViewById(R.id.login_button);
        TextView createAccountView = (TextView) findViewById(R.id.create_account);
        TextView forgotPasswordVew = (TextView) findViewById(R.id.forgot_password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameView.getEditText().getText().toString();
                password = passwordView.getEditText().getText().toString();
                if (validateUser(username, password)){
                    Intent intent = new Intent(v.getContext(), AppHome.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(v.getContext(), "Invalid username/password", Toast.LENGTH_SHORT).show();
            }
        });
        createAccountView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Signup.class);
                startActivity(intent);
            }
        });

        forgotPasswordVew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdminHome.class);
                startActivity(intent);
            }
        });


    }

    public boolean validateUser(String username, String password){
        return username.equals("test") && password.equals("test")? true:false;
    }
}
