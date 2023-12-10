package com.example.generalstore.Strategy_Pattern;


import com.example.generalstore.Item;

public class StudentDiscount implements DiscountStrategyAPI {

    @Override
    public double discountPrice(Item item) {
        // TODO Auto-generated method stub
        double discountedPrice= item.getItemPrice() - item.getItemPrice()*0.25;
        return discountedPrice;
    }

    @Override
    public String discountDescription(Item item) {
        // TODO Auto-generated method stub
        return "Student Discount Applied : 25% OFF";
    }

}
