package com.example.generalstore.Strategy_Pattern;

import com.example.generalstore.Item;

public interface DiscountStrategyAPI {
    double discountPrice(Item item);
    String discountDescription(Item item);
}
