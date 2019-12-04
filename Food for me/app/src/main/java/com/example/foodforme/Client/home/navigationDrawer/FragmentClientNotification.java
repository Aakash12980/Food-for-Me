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
public class FragmentClientNotification extends Fragment {


    public FragmentClientNotification() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_client_notification, container, false);
    }

}
