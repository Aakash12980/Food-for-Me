package com.example.foodforme.Admin.Home.AdminAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodforme.Admin.Home.AdminHomeDataStructure.OrderCardViewData;
import com.example.foodforme.R;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdminHomeUserOrderAdapter extends RecyclerView.Adapter<AdminHomeUserOrderAdapter.AdminHomeUserOrderViewHolder> {
    private Context context;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<OrderCardViewData> userData;
    View view;

    public AdminHomeUserOrderAdapter(Context context, List<OrderCardViewData> userData){
        this.context = context;
        this.userData = userData;
    }

    @NonNull
    @Override
    public AdminHomeUserOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.listview_new_order, parent, false);
        return new AdminHomeUserOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminHomeUserOrderViewHolder holder, int position) {
        String customerName = userData.get(position).getCustomerName();
        String orderTime = userData.get(position).getOrderTime();
        int orderId = userData.get(position).getOrderId();
        double totalPrice = userData.get(position).getTotalPrice();
        String readyTime = userData.get(position).getReadyTime();
        String message = userData.get(position).getMessage();
        int image = userData.get(position).getImageResourceId();

        holder.customerName.setText(customerName);
        holder.orderTime.setText(orderTime);
        holder.orderId.setText(String.valueOf(orderId));
        holder.totalPrice.setText(String.valueOf(totalPrice));
        holder.readyTime.setText(readyTime);
        holder.message.setText(message);
        holder.image.setImageResource(image);

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.subItemView.getContext(), RecyclerView.VERTICAL, false
        );
        layoutManager.setInitialPrefetchItemCount(userData.get(position).getSubItems().size());
        AdminHomeOrderListAdapter subItemAdapter = new AdminHomeOrderListAdapter(userData.get(position).getSubItems());
        holder.subItemView.setLayoutManager(layoutManager);
        holder.subItemView.setAdapter(subItemAdapter);
        holder.subItemView.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public class AdminHomeUserOrderViewHolder extends RecyclerView.ViewHolder{
        TextView customerName;
        TextView orderTime;
        TextView orderId;
        TextView totalPrice;
        TextView readyTime;
        TextView message;
        CircleImageView image;
        RecyclerView subItemView;

        public AdminHomeUserOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            customerName = itemView.findViewById(R.id.admin_home_username);
            orderTime = itemView.findViewById(R.id.admin_home_order_time);
            orderId = itemView.findViewById(R.id.admin_home_order_id);
            totalPrice = itemView.findViewById(R.id.admin_home_order_total);
            readyTime = itemView.findViewById(R.id.admin_home_ready_time);
            message = itemView.findViewById(R.id.admin_home_order_message);
            image = itemView.findViewById(R.id.admin_home_user_image);
            subItemView = itemView.findViewById(R.id.admin_home_order_item_listview);
        }
    }

}
