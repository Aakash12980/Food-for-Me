package com.example.foodforme.Admin.AdminAdapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodforme.Admin.AdminHomeDataStructure.FoodMenuData;
import com.example.foodforme.Admin.AdminNavFragments.FoodItems.FoodItems;
import com.example.foodforme.R;

import java.util.List;

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.FoodMenuAdapterHolder> {
    private List<FoodMenuData> foodMenuData;
    private Context context;
    private static final String TAG = "FoodMenuAdapter";

    public FoodMenuAdapter(Context context, List<FoodMenuData> foodMenuData) {
        this.context = context;
        this.foodMenuData = foodMenuData;
    }

    @NonNull
    @Override
    public FoodMenuAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_menu_genre, parent, false);
        return new FoodMenuAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodMenuAdapterHolder holder, final int position) {
        String foodGenre = foodMenuData.get(position).getFoodGenre();
        int foodImage = foodMenuData.get(position).getFoodImage();

        holder.foodGenreView.setText(foodGenre);
        holder.foodImageView.setImageResource(foodImage);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + foodMenuData.get(position).getFoodGenre());
                Toast.makeText(context, foodMenuData.get(position).getFoodGenre(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, FoodItems.class);
                i.putExtra("food_genre_name", foodMenuData.get(position).getFoodGenre());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodMenuData.size();
    }

    public class FoodMenuAdapterHolder extends RecyclerView.ViewHolder{
        ImageView foodImageView;
        TextView foodGenreView;
        LinearLayout parentLayout;

        public FoodMenuAdapterHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.food_genre_image);
            foodGenreView = itemView.findViewById(R.id.food_genre);
            parentLayout = itemView.findViewById(R.id.food_genre_view);
        }
    }
}
