package com.example.buoi9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.buoi9.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Product> productList;
    AdapterProduct adapterProduct;
    //    String jsonStr = "{\"id\":\"144\",\"publisher_id\":\"3\",\"content_type\":\"3\",\"tab\":\"0\",\"title\":\"Chinese Series\",\"avatar\":null}";
    String jsonArray = "[{\"id\":\"144\",\"publisher_id\":\"3\",\"content_type\":\"3\",\"tab\":\"0\",\"title\":\"Chinese Series\",\"avatar\":null},{\"id\":\"111\",\"publisher_id\":\"113\",\"content_type\":\"113\",\"tab\":\"110\",\"title\":\"Series Phim\",\"avatar\":\"----------\"}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        productList = new ArrayList<>();

        getJsonArray(productList);
//        getJson();
        adapterProduct = new AdapterProduct(productList);
        binding.lvProduct.setAdapter(adapterProduct);
    }

//    private void getJson(){
//        try {
//            JSONObject jsonObject = new JSONObject(jsonStr);
//
//            int id = jsonObject.getInt("id");
//            String title = jsonObject.getString("title");
//
//            binding.tvView.setText(title);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

    private void getJsonArray(List<Product> productList) {
        try {
            jsonArray = jsonArray.substring(1, jsonArray.length() - 1);
            JSONObject array = new JSONObject(jsonArray);

            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = new JSONObject(jsonArray);

                int id = jsonObject.getInt("id");
                int publisher_id = jsonObject.getInt("publisher_id");
                String title = jsonObject.getString("title");

                Product product = new Product(id, title, publisher_id);
                this.productList.add(product);


//                binding.tvView.setText(id + " - " + publisher_id + " - " + title);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}