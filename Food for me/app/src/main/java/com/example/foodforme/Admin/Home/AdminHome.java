package com.example.foodforme.Admin.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.foodforme.Admin.Home.AdminNavFragments.AdminHomeFragment;
import com.example.foodforme.Admin.Home.AdminNavFragments.AdminLoyalCustomer;
import com.example.foodforme.Admin.Home.AdminNavFragments.AdminSetting;
import com.example.foodforme.Admin.Home.AdminNavFragments.FoodMenu;
import com.example.foodforme.R;
import com.google.android.material.navigation.NavigationView;

public class AdminHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    androidx.appcompat.widget.Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
//        for NavBar Drawer
        toolbar = findViewById(R.id.admin_nav_toolbar);
        setSupportActionBar(toolbar);
//        for Navigation View Fragments
        NavigationView navigationView = findViewById(R.id.admin_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // adminHomeSlidingTabs.getTabAt(0).setIcon(R.drawable.app_logo);


        drawerLayout = findViewById(R.id.admin_nav_drawer);
        ActionBarDrawerToggle toggleDrawer = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_close, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggleDrawer);
        toggleDrawer.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.admin_nav_fragment_container, new AdminHomeFragment()).commit();
            navigationView.setCheckedItem(R.id.admin_nav_home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.admin_nav_food_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_nav_fragment_container, new FoodMenu()).commit();
                break;
            case R.id.admin_nav_customers:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_nav_fragment_container, new AdminLoyalCustomer()).commit();
                break;
            case R.id.admin_nav_setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_nav_fragment_container, new AdminSetting()).commit();
                break;
            case R.id.admin_nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.admin_nav_fragment_container, new AdminHomeFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
