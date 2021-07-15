package com.example.buoi9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterProduct extends BaseAdapter {
    List<Product> productList;

    public AdapterProduct(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_lv, parent, false);

        TextView tvId, tvTitle, tvPublisher_id;

        tvId = view.findViewById(R.id.tvId);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvPublisher_id = view.findViewById(R.id.tvPublisher_id);

        Product product = productList.get(position);

        tvId.setText(String.valueOf(product.getId()));
        tvTitle.setText(product.getTitle());
        tvPublisher_id.setText(String.valueOf(product.getPublisher_id()));

        return view;
    }
}
