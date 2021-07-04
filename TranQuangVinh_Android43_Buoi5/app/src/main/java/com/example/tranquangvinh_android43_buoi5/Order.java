package com.example.tranquangvinh_android43_buoi5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tranquangvinh_android43_buoi5.databinding.ActivityOrderBinding;

import java.util.ArrayList;
import java.util.List;


public class Order extends AppCompatActivity implements IOrder {

    Food food, food1, food2, food3, food4, food5;
    List<Food> foodList;
    String lvFood_Cart = "";
    int count = 0;
    int Price = 0;
    ActivityOrderBinding binding;
    OrderPresenter orderPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order);
        orderPresenter = new OrderPresenter(this);


        foodList = new ArrayList<>();

        food = new Food("Pizza Panda", "100");
        food1 = new Food("KFC Super", "120");
        food2 = new Food("Bread Eggs", "50");
        food3 = new Food("Coca Cola", "10");
        food4 = new Food("Chicken super", "200");
        food5 = new Food("Cup Cake", "30");

        foodList.add(food);
        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);

        AdapterFood adapterFood = new AdapterFood(foodList);
        binding.lvFood.setAdapter(adapterFood);


        binding.lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int price = Integer.parseInt(foodList.get(i).getPrice());
                count = Integer.parseInt(binding.tvCCart.getText().toString());
                Price = Integer.parseInt(binding.ttPrice.getText().toString().substring(0,binding.ttPrice.length()-1));
                orderPresenter.onClickItemLV(count,price,Price);

                lvFood_Cart = lvFood_Cart + foodList.get(i).getName() + "/";
            }
        });

        binding.btOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lvFood_Cart = "";
                orderPresenter.onOrderClick(count,Price);
            }
        });


        binding.btCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = Integer.parseInt(binding.tvCCart.getText().toString());
                Price = Integer.parseInt(binding.ttPrice.getText().toString().substring(0,binding.ttPrice.length()-1));
                changeActivity(Cart.class);
            }
        });


    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("price", Price);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Price = savedInstanceState.getInt("price");
        binding.ttPrice.setText(Integer.toString(Price));
    }


    @Override
    public void onItemLVClick(int count, int curPrice) {
        binding.tvCCart.setText(Integer.toString(count));
        binding.ttPrice.setText(Integer.toString(curPrice) + "$");
    }

    @Override
    public void onOrderClick(String mess) {
        binding.tvCCart.setText("0");
        binding.ttPrice.setText("0$");
        binding.tvThank.setText("Thank you! Your order is sent to restaurant!");
        Toast.makeText(getBaseContext(),mess,Toast.LENGTH_LONG).show();
    }

    @Override
    public void changeActivity(Class Cart) {
        Intent intent = new Intent(getBaseContext(), Cart);
        intent.putExtra("price", Price);
        intent.putExtra("food", lvFood_Cart);
        startActivity(intent);
    }
}