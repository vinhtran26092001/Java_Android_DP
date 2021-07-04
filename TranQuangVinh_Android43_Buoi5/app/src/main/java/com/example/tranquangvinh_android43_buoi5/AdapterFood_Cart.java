package com.example.tranquangvinh_android43_buoi5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterFood_Cart extends BaseAdapter {

    List<Food_Cart> foodList;

    public AdapterFood_Cart(List<Food_Cart> foodList) {
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_lvfood_cart, parent, false);

        TextView tvName_Cart,foodCount;

        tvName_Cart = view.findViewById(R.id.tvName_Cart);
        foodCount = view.findViewById(R.id.foodCount);

        Food_Cart food = foodList.get(position);

        tvName_Cart.setText(food.getName());
        foodCount.setText(food.getCount());

        return view;
    }
}
