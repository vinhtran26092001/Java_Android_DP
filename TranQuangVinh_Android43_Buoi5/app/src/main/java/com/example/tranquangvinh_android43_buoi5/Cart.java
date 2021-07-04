package com.example.tranquangvinh_android43_buoi5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tranquangvinh_android43_buoi5.databinding.ActivityCartBinding;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity implements ICart{
    ActivityCartBinding binding;
    CartPresenter cartPresenter;

    Food_Cart food;
    List<Food_Cart> foodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_cart);
        cartPresenter = new CartPresenter(this);

        Intent intent = getIntent();
        int price = intent.getIntExtra("price",0);

        String lvfood = intent.getStringExtra("food");
        String[] LVfood = lvfood.split("/");

        foodList = new ArrayList<>();

        cartPresenter.Menu(LVfood,food,foodList);

        AdapterFood_Cart adapterFood_cart = new AdapterFood_Cart(foodList);
        binding.lvFoodCart.setAdapter(adapterFood_cart);

        binding.ttPriceCart.setText(price + "$");

        binding.imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(Order.class);
            }
        });
    }

    @Override
    public void changeActivity(Class Order) {
        Intent intent =new Intent(getBaseContext(),Order);
        startActivity(intent);
    }


}