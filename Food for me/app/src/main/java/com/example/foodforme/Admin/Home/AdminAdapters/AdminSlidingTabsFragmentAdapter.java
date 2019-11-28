package com.example.foodforme.Admin.Home.AdminAdapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdminSlidingTabsFragmentAdapter extends FragmentPagerAdapter {
    private final List<Fragment> lastFragment = new ArrayList<>();
    private final List<String> lastTiles = new ArrayList<>();

    public AdminSlidingTabsFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lastTiles.get(position);
    }

    @Override
    public Fragment getItem(int index) {
        return lastFragment.get(index);
    }

    public void addFragment(Fragment fragment, String title){
        lastFragment.add(fragment);
        lastTiles.add(title);
    }

    @Override
    public int getCount() {
        return lastFragment.size();
    }
}