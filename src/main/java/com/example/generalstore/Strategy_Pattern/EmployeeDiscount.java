package com.example.generalstore.Strategy_Pattern;


import com.example.generalstore.Item;

public class EmployeeDiscount implements DiscountStrategyAPI{

    @Override
    public double discountPrice(Item item) {
        // TODO Auto-generated method stub
        double discountedPrice= item.getItemPrice() - item.getItemPrice()*0.15;
        return discountedPrice;
    }

    @Override
    public String discountDescription(Item item) {
        // TODO Auto-generated method stub
        return "Employee Discount Applied : 15% OFF";
    }

}
