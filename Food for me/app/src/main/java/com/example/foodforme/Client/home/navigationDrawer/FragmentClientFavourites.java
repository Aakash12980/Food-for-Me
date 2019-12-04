package com.example.foodforme.Client.home.navigationDrawer;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.foodforme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClientFavourites extends Fragment {


    public FragmentClientFavourites() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_client_favourites, container, false);
    }

}
