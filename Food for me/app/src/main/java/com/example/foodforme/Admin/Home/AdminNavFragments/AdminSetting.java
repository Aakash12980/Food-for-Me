package com.example.foodforme.Admin.Home.AdminNavFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodforme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminSetting extends Fragment {


    public AdminSetting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_admin_setting, container, false);
        return rootView;

    }

}
