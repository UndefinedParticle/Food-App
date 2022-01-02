package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        DBhelper helper=new DBhelper(this);
        binding.placedOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted=helper.insertOrder(binding.orderNameBox.getText().toString(),
                        binding.orderPhoneBox.getText().toString(),
                        image,name,price,
                        Integer.parseInt(binding.orderQuantity.getText().toString()),
                        description);
                if(isInserted==true){
                    Toast.makeText(OrderDetailActivity.this,"Order Placed",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(OrderDetailActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
            }
        });
        /*myOrder=findViewById(R.id.placedOrder);
        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OrderDetailActivity.this,OrderShow.class);

                //ntent.putExtra("orderedfoodimage",findViewById(R.id.orderedFood).getText().toString());
                startActivity(intent);
            }
        });*/

    }
}