package com.example.foodforme.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.foodforme.LoginSignup.adapters.ClientFragmentAdapter;
import com.example.foodforme.R;
import com.google.android.material.tabs.TabLayout;

public class ClientLoginSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login_signup);

        ViewPager viewPager = (ViewPager) findViewById(R.id.client_login_signup_viewpager);
        ClientFragmentAdapter adapter = new ClientFragmentAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.client_login_signup_sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}
