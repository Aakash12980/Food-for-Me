package com.example.foodie.Admin.Home.AdminNavFragments.FoodItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodie.Admin.Home.AdminAdapters.FoodItemAdapter;
import com.example.foodie.Admin.Home.AdminHomeDataStructure.FoodItem;
import com.example.foodie.R;

import java.util.ArrayList;
import java.util.List;

public class FoodItems extends AppCompatActivity {
    private static final String TAG = "FoodItems";
    private List<FoodItem> foodItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_items);
        Log.d(TAG, "onCreate: Activity Started");

        getIncomingIntent();
        Button addFoodItemView = findViewById(R.id.add_food_item);
        addFoodItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddFoodItemDialog();
            }
        });

    }
    private void getIncomingIntent(){

        Log.d(TAG, "getIncommingIntent: Checking for Incomming Intent");
        if (getIntent().hasExtra("food_genre_name")){
            Log.d(TAG, "getIncommingIntent: has found Extras");
            String foodGenreName = getIntent().getStringExtra("food_genre_name");
            setFoodGenreDetails();

        }
    }
    private void setFoodGenreDetails(){
        Log.d(TAG, "setFoodGenreName: Setting food_genre_name");

        foodItem = new ArrayList<>();
        foodItem.add(new FoodItem(R.drawable.app_logo, "Mo: Mo", 156.87));
        foodItem.add(new FoodItem(R.drawable.app_logo, "Chowmein", 120));
        foodItem.add(new FoodItem(R.drawable.app_logo, "Pizza", 760));
        foodItem.add(new FoodItem(R.drawable.app_logo, "Mountain Dew", 50));

        RecyclerView recyclerView = findViewById(R.id.food_items);
        FoodItemAdapter adapter = new FoodItemAdapter(foodItem, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

    }

    public void openAddFoodItemDialog(){
        AddFoodItem newFoodItem = new AddFoodItem();
        newFoodItem.show(getSupportFragmentManager(), "Add Food");
    }
}
