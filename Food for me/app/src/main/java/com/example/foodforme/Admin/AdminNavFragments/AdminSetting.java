package com.example.foodforme.Admin.AdminNavFragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.foodforme.LoginSignup.AdminLoginSignup;
import com.example.foodforme.LoginSignup.adminFragments.AdminLogin;
import com.example.foodforme.R;
import com.google.firebase.auth.FirebaseAuth;

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
        TextView logoutView = (TextView) rootView.findViewById(R.id.setting_logout);
        logoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), AdminLoginSignup.class));
            }
        });
        return rootView;

    }

}
