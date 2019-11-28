package com.example.foodforme.Admin.Home.AdminNavFragments.FoodItem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.foodforme.R;

public class AddCategory extends AppCompatDialogFragment {

    private EditText foodTitleView;
    private EditText foodImageView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_category, null);
        builder.setView(view).setTitle("Add Category").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = foodTitleView.getText().toString();
                String image = foodImageView.getText().toString();

            }
        });

        foodTitleView = view.findViewById(R.id.category_title);
        foodImageView = view.findViewById(R.id.category_image);

        return builder.create();
    }


}
