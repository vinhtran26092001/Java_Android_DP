package com.example.tranquangvinh_android43_buoi5;

public interface IOrder {
    void onItemLVClick(int count, int curPrice);

    void onOrderClick(String mess);

    void changeActivity(Class mess);
}
