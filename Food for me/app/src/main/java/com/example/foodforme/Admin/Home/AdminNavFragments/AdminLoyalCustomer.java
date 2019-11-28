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
public class AdminLoyalCustomer extends Fragment {


    public AdminLoyalCustomer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loyal_customer, container, false);
    }

}
