package com.example.foodforme.Client.home.navigationDrawer;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodforme.Client.ClientAdapters.RestroHomeListAdapter;
import com.example.foodforme.LoginSignup.ClientLoginSignup;
import com.example.foodforme.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentClientHome extends Fragment {


    public FragmentClientHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_client_home, container, false);
        RecyclerView restroListView = (RecyclerView) rootView.findViewById(R.id.home_restro_list);
        restroListView.setLayoutManager(new LinearLayoutManager(getContext()));

        ImageView cartView = (ImageView) rootView.findViewById(R.id.cart);

        cartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), ClientLoginSignup.class));
            }
        });

        ArrayList<List<String>> title = new ArrayList<List<String>>();
        String data[] = {"Hello", "There"};
        List<String> data1 = Arrays.asList(data);
        title.add(data1);
        data = new String[]{"Me", "You"};
        List<String> data2 = Arrays.asList(data);;
        title.add(data2);
        data = new String[]{"Them", "Rheaaa"};
        List<String> data3 = Arrays.asList(data);
        title.add(data3);
        data = new String[]{"Hi", "Fukka"};
        List<String> data4 = Arrays.asList(data);
        title.add(data4);
        restroListView.setAdapter(new RestroHomeListAdapter(title));
        return rootView;
    }

}
