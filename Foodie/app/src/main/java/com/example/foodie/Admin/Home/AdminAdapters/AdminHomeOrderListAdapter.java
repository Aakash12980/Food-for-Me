package com.example.foodie.Admin.Home.AdminAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodie.Admin.Home.AdminHomeDataStructure.AdminHomeOrderItemData;
import com.example.foodie.R;

import java.util.List;

public class AdminHomeOrderListAdapter extends RecyclerView.Adapter<AdminHomeOrderListAdapter.SubItemViewHolder>{

    private List<AdminHomeOrderItemData> subItems;

    AdminHomeOrderListAdapter(List<AdminHomeOrderItemData> subItems){
        this.subItems = subItems;
    }

    @NonNull
    @Override
    public SubItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_home_order_item_listview, parent, false);
        return new SubItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubItemViewHolder holder, int position) {
        String itemName = subItems.get(position).getItemName();
        int itemQuantity = subItems.get(position).getItemQuantity();
        double itemPrice = subItems.get(position).getItemPrice();

        holder.itemNameView.setText(itemName);
        holder.itemQuantityView.setText(String.valueOf(itemQuantity));
        holder.itemQuantityView.setText(String.valueOf(itemPrice));

    }

    @Override
    public int getItemCount() {
        return subItems.size();
    }

    public class SubItemViewHolder extends RecyclerView.ViewHolder{

        TextView itemNameView;
        TextView itemQuantityView;
        TextView itemPriceView;
        SubItemViewHolder (View itemView){
            super(itemView);
            itemNameView = itemView.findViewById(R.id.admin_home_order_item_name);
            itemQuantityView = itemView.findViewById(R.id.admin_home_order_item_qty);
            itemPriceView = itemView.findViewById(R.id.admin_home_order_item_price);
        }


    }
}
