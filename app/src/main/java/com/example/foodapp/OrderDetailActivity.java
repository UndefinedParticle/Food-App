package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapp.databinding.ActivityOrderDetailBinding;
import com.example.foodapp.databinding.FoodListBinding;

import java.util.Objects;

public class OrderDetailActivity extends AppCompatActivity {
    ActivityOrderDetailBinding binding;
    Button myOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        Objects.requireNonNull(getSupportActionBar()).hide();
        binding= ActivityOrderDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int image=getIntent().getIntExtra("foodImage",0);
        int price=Integer.parseInt(getIntent().getStringExtra("foodPrice"));
        String name=getIntent().getStringExtra("foodName");
        String description=getIntent().getStringExtra("foodDescription");
        binding.orderFoodImage.setImageResource(image);
        binding.orderFoodName.setText(name);
        binding.orderFoodPrice.setText(String.format("%d",price));
        binding.foodDescription.setText(description);
        myOrder=findViewById(R.id.placedOrder);
        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OrderDetailActivity.this,OrderShow.class);

                //ntent.putExtra("orderedfoodimage",findViewById(R.id.orderedFood).getText().toString());
                startActivity(intent);
            }
        });

    }
}