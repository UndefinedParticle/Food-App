package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
        //Objects.requireNonNull(getSupportActionBar()).hide();
        binding=FoodListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.bread,"Bread","20","Bread is a staple food prepared from a dough of flour (usually wheat) and water, usually by baking."));
        list.add(new MainModel(R.drawable.eggroll,"Egg Roll","30","Image result for egg roll\n" +
                "Egg rolls are fried, savory rolls, generally filled with cabbage chopped Chinese roast pork"));
        list.add(new MainModel(R.drawable.biriyani,"Biriyani","110","Biryani is a mixed rice dish originating among the Muslims of the Indian subcontinent. It is made with spices, rice, and meat, or eggs or vegetables such as potatoes in certain regional varieties"));
        list.add(new MainModel(R.drawable.meatt,"Meat","70","Chicken meat"));
        list.add(new MainModel(R.drawable.rooti,"Rooti","5","Wheat Rooti"));
        list.add(new MainModel(R.drawable.cholabhatura,"Chola Bhatura","25","Chole bhature is a food dish popular in the Northern areas of the Indian subcontinent. It is a combination of chana masala and bhatura/puri, a fried bread made from maida."));
        list.add(new MainModel(R.drawable.dosa,"Dosa","35","A dosa is a thin pancake or crepe originating from South India, made from a fermented batter predominantly consisting of lentils and rice"));
        list.add(new MainModel(R.drawable.momo,"Momo","50","Momo is a type of steamed dumpling with some form of filling"));
        list.add(new MainModel(R.drawable.friedrice,"Fried Rice","80","Fried rice is a dish of cooked rice that has been stir-fried in a wok or a frying pan and is usually mixed with other ingredients such as eggs, vegetables, seafood, or meat"));
        MainAdapter adapter=new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.myOrders:
                startActivity(new Intent(FoodListActivity.this,OrderShow.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}