package com.example.foodforme.Admin.AdminNavFragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foodforme.Admin.AdminAdapters.FoodMenuAdapter;
import com.example.foodforme.Admin.AdminHomeDataStructure.FoodMenuData;
import com.example.foodforme.Admin.AdminNavFragments.FoodItems.AddCategory;
import com.example.foodforme.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodMenu extends Fragment{
    private View rootView;
    private RecyclerView childView;
    private List<FoodMenuData> foodGenreData;

    public FoodMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_food_menu, container, false);
        childView = (RecyclerView) rootView.findViewById(R.id.admin_food_menu);
        FoodMenuAdapter adapter = new FoodMenuAdapter(getActivity(), foodGenreData);
        childView.setLayoutManager(new LinearLayoutManager(getActivity()));
        childView.setAdapter(adapter);

        Button addCategoryView = (Button) rootView.findViewById(R.id.add_category);
        addCategoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategoryDialog();
            }
        });

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        foodGenreData = new ArrayList<>();
        foodGenreData.add(new FoodMenuData(R.drawable.app_logo, "Snacks"));
        foodGenreData.add(new FoodMenuData(R.drawable.app_logo, "Lunch"));

    }

    public void openCategoryDialog(){
        AddCategory addCategory = new AddCategory();
        addCategory.show(getChildFragmentManager(), "Add Category");
    }
}
