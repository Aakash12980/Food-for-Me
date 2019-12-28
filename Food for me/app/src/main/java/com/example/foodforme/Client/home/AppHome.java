package com.example.foodforme.Client.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.foodforme.Client.home.navigationDrawer.FragmentClientFavourites;
import com.example.foodforme.Client.home.navigationDrawer.FragmentClientHome;
import com.example.foodforme.Client.home.navigationDrawer.FragmentClientNotification;
import com.example.foodforme.Client.home.navigationDrawer.FragmentClientProfile;
import com.example.foodforme.Client.home.navigationDrawer.FragmentClientSetting;
import com.example.foodforme.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppHome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.client_nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.client_fragment_container, new FragmentClientHome()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.client_home:
                            selectedFragment = new FragmentClientHome();
                            break;
                        case R.id.client_setting:
                            selectedFragment = new FragmentClientSetting();
                            break;
                        case R.id.client_notification:
                            selectedFragment = new FragmentClientNotification();
                            break;
                        case R.id.client_favourite:
                            selectedFragment = new FragmentClientFavourites();
                            break;
                        case R.id.client_profile:
                            selectedFragment = new FragmentClientProfile();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.client_fragment_container, selectedFragment).commit();
                    return true;
                }
            };
    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }
}
