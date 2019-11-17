package com.example.foodie.Admin.Home.TabLayout.fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.foodie.Admin.Home.AdminAdapters.AdminHomeOrderListAdapter;
import com.example.foodie.Admin.Home.AdminAdapters.AdminHomeUserOrderAdapter;
import com.example.foodie.Admin.Home.AdminHomeDataStructure.AdminHomeOrderItemData;
import com.example.foodie.Admin.Home.AdminHomeDataStructure.OrderCardViewData;
import com.example.foodie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNewOrders extends Fragment {

    private List<OrderCardViewData> userData;
    private List<AdminHomeOrderItemData> orderedItem;
    RecyclerView newOrderRecycleView;
    View rootview;
    ListView listview;


    public FragmentNewOrders() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.admin_home_container, container, false);

        newOrderRecycleView = (RecyclerView) rootview.findViewById(R.id.admin_home_orderlist);
        AdminHomeUserOrderAdapter recyclerAdapter = new AdminHomeUserOrderAdapter(getContext(), userData);
        newOrderRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newOrderRecycleView.setAdapter(recyclerAdapter);
        return rootview;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        orderedItem = new ArrayList<>();
        orderedItem.add(new AdminHomeOrderItemData("Momo", 3, 150.52));
        orderedItem.add(new AdminHomeOrderItemData("Chowmein", 3, 120.0));
        orderedItem.add(new AdminHomeOrderItemData("Pizza", 1, 1500.56));
        orderedItem.add(new AdminHomeOrderItemData("Sandwich", 2, 190.0));
        List<AdminHomeOrderItemData> orderedItem2 = new ArrayList<>();
        orderedItem2.add(new AdminHomeOrderItemData("Momo", 3, 150.52));
        orderedItem2.add(new AdminHomeOrderItemData("Chowmein", 3, 120.0));

        userData = new ArrayList<>();
        userData.add(new OrderCardViewData(
                "Aakash Bhandari", "12:45P.M", 123,
                234.43, "2:50 P.M", "Hello There, Me Aakash Bhandari.", R.drawable.cart, orderedItem));
        userData.add(new OrderCardViewData(
                "Utsav Shrestha", "12:45P.M", 432,
                233.7, "2:50 P.M", "Hello There, Me Aakash.", R.drawable.cart, orderedItem2));
    }
}
