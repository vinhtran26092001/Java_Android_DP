package com.example.tranquangvinh_android43_buoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    ListView lvFood_Cart;
    Food_Cart food,food1,food2,food3,food4,food5;
    List<Food_Cart> foodList;
    ImageButton imbBack;

    TextView ttPrice_Cart,foodCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        int price = intent.getIntExtra("price",0);

        String lvfood = intent.getStringExtra("food");
        String[] LVfood = lvfood.split("/");

        foodCount = findViewById(R.id.foodCount);
        lvFood_Cart = findViewById(R.id.lvFood_Cart);
        foodList = new ArrayList<>();


        for(int i = 0; i < LVfood.length ; i ++){
            int x = 1;
            int count = 0;
            for(int j = 0; j < i ; j ++){
                if(LVfood[i].compareTo(LVfood[j]) == 0){
                    x = 0;
                    break;
                }
            }
            for(int k = 0; k < LVfood.length ; k ++){
                if(LVfood[i].compareTo(LVfood[k]) == 0){
                    count++;
                }
            }
            if(x == 1){
                food = new Food_Cart(LVfood[i],"(" + Integer.toString(count) + ")");
                foodList.add(food);
            }
        }


        AdapterFood_Cart adapterFood_cart = new AdapterFood_Cart(foodList);
        lvFood_Cart.setAdapter(adapterFood_cart);

        ttPrice_Cart = findViewById(R.id.ttPrice_Cart);
        ttPrice_Cart.setText(price + "$");

        imbBack = findViewById(R.id.imbBack);
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),Order.class);
                startActivity(intent);
            }
        });
    }
}