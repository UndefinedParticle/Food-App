package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodapp.Adapters.MainAdapter;
import com.example.foodapp.Models.MainModel;
import com.example.foodapp.databinding.ActivityMainBinding;
import com.example.foodapp.databinding.FoodListBinding;

import java.util.ArrayList;
import java.util.Objects;

public class FoodListActivity extends AppCompatActivity {

    FoodListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        binding=FoodListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.bread,"Bread","25.00","This is a sweet Bread"));
        list.add(new MainModel(R.drawable.eggroll,"Egg Roll","30.00","This is a tasty Egg Roll"));
        list.add(new MainModel(R.drawable.biriyani,"Biriyani","100.00","Your FAV Biriyani"));
        list.add(new MainModel(R.drawable.meatt,"Meat","90.00","Chicken meat"));
        list.add(new MainModel(R.drawable.rooti,"Rooti","5.00","Wheat Rooti"));
        MainAdapter adapter=new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }
}