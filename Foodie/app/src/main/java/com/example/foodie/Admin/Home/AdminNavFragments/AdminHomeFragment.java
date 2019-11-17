package com.example.foodie.Admin.Home.AdminNavFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodie.Admin.Home.AdminAdapters.AdminSlidingTabsFragmentAdapter;
import com.example.foodie.Admin.Home.TabLayout.fragments.FragmentBillSection;
import com.example.foodie.Admin.Home.TabLayout.fragments.FragmentCurrentOrder;
import com.example.foodie.Admin.Home.TabLayout.fragments.FragmentNewOrders;
import com.example.foodie.Admin.Home.TabLayout.fragments.FragmentServeFood;
import com.example.foodie.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminHomeFragment extends Fragment {
    private TabLayout adminHomeSlidingTabs;
    private ViewPager adminHomeViewPager;
    private AdminSlidingTabsFragmentAdapter adapter;

    public AdminHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_admin_home, container, false);

        adminHomeSlidingTabs = (TabLayout) rootView.findViewById(R.id.admin_home_sliding_tabs);
        adminHomeViewPager = (ViewPager) rootView.findViewById(R.id.admin_home_viewpager);
        adapter = new AdminSlidingTabsFragmentAdapter(getChildFragmentManager());

        adapter.addFragment(new FragmentNewOrders(), "New Orders");
        adapter.addFragment(new FragmentCurrentOrder(), "Current Orders");
        adapter.addFragment(new FragmentServeFood(), "Serve Food");
        adapter.addFragment(new FragmentBillSection(), "Bill Section");

        adminHomeViewPager.setAdapter(adapter);

        adminHomeSlidingTabs.setupWithViewPager(adminHomeViewPager);
        return rootView;
    }

}
