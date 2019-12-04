package com.example.foodforme.LoginSignup.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.foodforme.LoginSignup.adminFragments.AdminLogin;
import com.example.foodforme.LoginSignup.adminFragments.AdminSignup;

public class AdminFragmentAdapter extends FragmentPagerAdapter {
    private Context context;

    public AdminFragmentAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Login";
        }else {
            return "Signup";
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new AdminLogin();
        }else {
            return new AdminSignup();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
