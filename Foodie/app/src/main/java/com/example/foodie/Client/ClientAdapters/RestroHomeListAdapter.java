package com.example.foodie.Client.ClientAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodie.R;

import java.util.ArrayList;
import java.util.List;

public class RestroHomeListAdapter extends RecyclerView.Adapter<RestroHomeListAdapter.RestroHomeViewHolder> {

    private ArrayList<List<String>> data = new ArrayList<List<String>>();

    public RestroHomeListAdapter(ArrayList<List<String>> data){
        this.data.addAll(data);

    }


    @NonNull
    @Override
    public RestroHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.restro_home_list, parent, false);
        return new RestroHomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestroHomeViewHolder holder, int position) {
        List<String> listData = data.get(position);
        String title = listData.get(0);
        String desc = listData.get(1);
        holder.restroTitle.setText(title);
        holder.restroDesc.setText(desc);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RestroHomeViewHolder extends RecyclerView.ViewHolder {
        ImageView restroLogo;
        TextView restroTitle;
        TextView restroDesc;
        public RestroHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            restroLogo = itemView.findViewById(R.id.restro_logo);
            restroTitle = itemView.findViewById(R.id.restro_name);
            restroDesc = itemView.findViewById(R.id.restro_desc);
        }
    }
}
