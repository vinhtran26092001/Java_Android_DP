package com.example.tranquangvinh_android43_buoi5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Order extends AppCompatActivity {
    ListView lvFood;
    Food food,food1,food2,food3,food4,food5;
    List<Food> foodList;
    ImageButton btCart;
    TextView tvCCart,ttPrice,tvThank,tvName;
    Button btOrder;
    String lvFood_Cart = "";
    int count = 0;
    int Price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        lvFood = findViewById(R.id.lvFood);

        foodList = new ArrayList<>();

        food = new Food("Pizza Panda","100");
        food1 = new Food("KFC Super","120");
        food2 = new Food("Bread Eggs","50");
        food3 = new Food("Coca Cola","10");
        food4 = new Food("Chicken super","200");
        food5 = new Food("Cup Cake","30");

        foodList.add(food);
        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);

        AdapterFood adapterFood = new AdapterFood(foodList);
        lvFood.setAdapter(adapterFood);

        tvCCart = findViewById(R.id.tvCCart);
        tvThank = findViewById(R.id.tvThank);
        ttPrice = findViewById(R.id.ttPrice);
        btOrder = findViewById(R.id.btOrder);


        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                count = count + 1;
                tvCCart.setText(Integer.toString(count));

                int price = Integer.parseInt(foodList.get(i).getPrice());
                Price = Price + price;
                ttPrice.setText(Integer.toString(Price) + "$");

                lvFood_Cart = lvFood_Cart + foodList.get(i).getName() + "/";
            }
        });

        btOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Price = 0;
                count = 0;
                lvFood_Cart = "";
                tvCCart.setText("0");
                ttPrice.setText("0$");
                tvThank.setText("Thank you! Your order is sent to restaurant!");
            }
        });

        btCart = findViewById(R.id.btCart);

        btCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),Cart.class);
                intent.putExtra("price", Price);
                intent.putExtra("food",lvFood_Cart);
                startActivity(intent);
            }
        });
        

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("price",Price);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Price = savedInstanceState.getInt("price");
        ttPrice.setText(Integer.toString(Price));
    }
}