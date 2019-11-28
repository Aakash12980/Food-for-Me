package com.example.foodforme.Admin.Home.TabLayout.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodforme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCurrentOrder extends Fragment {


    public FragmentCurrentOrder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.admin_home_container, container, false);
        return rootview;
    }

}
