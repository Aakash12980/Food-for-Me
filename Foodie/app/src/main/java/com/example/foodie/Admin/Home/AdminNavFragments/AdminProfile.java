package com.example.foodie.Admin.Home.AdminNavFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.foodie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminProfile extends Fragment {


    public AdminProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_admin_profile, container, false);
        return rootView;

    }

}
