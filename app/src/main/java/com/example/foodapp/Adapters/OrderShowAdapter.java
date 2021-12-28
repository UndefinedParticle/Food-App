package com.example.foodapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Models.MainModel;
import com.example.foodapp.Models.OrderShowModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class OrderShowAdapter extends RecyclerView.Adapter<OrderShowAdapter.viewholder1>{
    ArrayList<OrderShowModel> list;
    Context context;
    public OrderShowAdapter(ArrayList<OrderShowModel> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public viewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_ordershow,parent,false);
        return new OrderShowAdapter.viewholder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder1 holder, int position) {
        final OrderShowModel model=list.get(position);
        holder.orderImageView.setImageResource(model.getOrderedImage());
        holder.orderName.setText(model.getOrderedFood());
        holder.orderPrice.setText(model.getOrderedPrice());
        holder.orderNumber.setText(model.getOrderNumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder1 extends RecyclerView.ViewHolder{
        ImageView orderImageView;
        TextView orderName,orderPrice,orderNumber;
        public viewholder1(@NonNull View itemView) {
            super(itemView);
            orderImageView=itemView.findViewById(R.id.orderedFoodImage);
            orderName=itemView.findViewById(R.id.orderedFood);
            orderPrice=itemView.findViewById(R.id.orderedPrice);
            orderNumber=itemView.findViewById(R.id.orderedNumber);
        }
    }
}
