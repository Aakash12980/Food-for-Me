package com.example.foodforme.Admin.Home.AdminNavFragments.FoodItem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.foodforme.R;

public class AddFoodItem extends AppCompatDialogFragment {

//    private ImageView foodImageView;
    private TextView foodNameView;
    private TextView foodPriceView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_food_item_dialog, null);
        builder.setView(view).setTitle("Add Food Item").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = foodNameView.getText().toString();
                double price = Double.valueOf(foodPriceView.getText().toString());
                int image = R.drawable.app_logo;

            }
        });

        foodNameView = view.findViewById(R.id.food_item_title);
        foodPriceView  = view.findViewById(R.id.food_item_price);
//        foodImageView = view.findViewById(R.id.food_item_image);
        return builder.create();

    }
}
