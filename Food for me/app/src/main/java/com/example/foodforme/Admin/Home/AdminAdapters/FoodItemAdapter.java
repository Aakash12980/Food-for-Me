package com.example.foodforme.Admin.Home.AdminAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodforme.Admin.Home.AdminHomeDataStructure.FoodItem;
import com.example.foodforme.R;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder> {

    private List<FoodItem> foodItem;
    private Context context;
    private static final String TAG = "FoodItemAdapter";

    public FoodItemAdapter(List<FoodItem> foodItem, Context context) {
        this.foodItem = foodItem;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_items, parent, false);
        return new FoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder holder, int position) {
        int image = foodItem.get(position).getFoodImage();
        String name = foodItem.get(position).getFoodName();
        double price = foodItem.get(position).getFoodPrice();

        holder.foodImageView.setImageResource(image);
        holder.foodNameView.setText(name);
        holder.foodPriceView.setText(String.valueOf(price));
    }

    @Override
    public int getItemCount() {
        return foodItem.size();
    }

    public class FoodItemViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImageView;
        TextView foodNameView;
        TextView foodPriceView;

        public FoodItemViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.food_item_image);
            foodNameView = itemView.findViewById(R.id.food_item_name);
            foodPriceView = itemView.findViewById(R.id.food_item_price);
        }
    }
}
