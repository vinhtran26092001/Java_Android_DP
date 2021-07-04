package com.example.tranquangvinh_android43_buoi5;

import android.content.Intent;

import java.util.List;

public class CartPresenter {
    ICart iCart;

    public CartPresenter(ICart iCart) {
        this.iCart = iCart;
    }

    public void onBack(){
        iCart.changeActivity(Order.class);
    }

    public void Menu(String[] LVfood, Food_Cart food, List<Food_Cart> foodList){
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
    }
}
