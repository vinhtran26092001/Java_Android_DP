package com.example.tranquangvinh_android43_buoi5;

public class OrderPresenter {
    IOrder iorder;

    public OrderPresenter(IOrder iorder) {
        this.iorder = iorder;
    }

    public void onClickItemLV(int count, int price, int curPrice){
        count = count + 1;
        curPrice = curPrice + price;
        iorder.onItemLVClick(count,curPrice);
    }

    public void onOrderClick(int count, int price){
        count = 0;
        price = 0;
        iorder.onOrderClick("Thank you! Your order is sent to restaurant!");
    }
}
