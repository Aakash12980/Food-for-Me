package com.example.foodforme.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.foodforme.LoginSignup.adapters.AdminFragmentAdapter;
import com.example.foodforme.R;
import com.google.android.material.tabs.TabLayout;

public class AdminLoginSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_signup);

        ViewPager viewPager = (ViewPager) findViewById(R.id.admin_login_signup_viewpager);
        AdminFragmentAdapter adapter = new AdminFragmentAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);

        Bundle placeData = getIntent().getBundleExtra("placeData");

        TabLayout tabLayout = (TabLayout) findViewById(R.id.admin_login_signup_sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }
}
