package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodapp.Adapters.MainAdapter;
import com.example.foodapp.Adapters.OrderShowAdapter;
import com.example.foodapp.Models.MainModel;
import com.example.foodapp.Models.OrderShowModel;
import com.example.foodapp.databinding.ActivityOrderShowBinding;
import com.example.foodapp.databinding.FoodListBinding;

import java.util.ArrayList;
import java.util.Objects;

public class OrderShow extends AppCompatActivity {
    ActivityOrderShowBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        binding= ActivityOrderShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<OrderShowModel> list=new ArrayList<>();
        list.add(new OrderShowModel(R.drawable.bread,"Bread","25","1"));
        OrderShowAdapter adapter=new OrderShowAdapter(list,this);
        binding.recyclerview1.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview1.setLayoutManager(layoutManager);
    }
}