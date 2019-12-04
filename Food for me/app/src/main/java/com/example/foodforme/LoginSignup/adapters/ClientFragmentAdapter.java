package com.example.foodforme.LoginSignup.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.foodforme.LoginSignup.clientFragments.ClientLogin;
import com.example.foodforme.LoginSignup.clientFragments.ClientSignup;

public class ClientFragmentAdapter extends FragmentPagerAdapter {
    private Context context;

    public ClientFragmentAdapter(FragmentManager fm, Context context){
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
            return new ClientLogin();
        }else {
            return new ClientSignup();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
