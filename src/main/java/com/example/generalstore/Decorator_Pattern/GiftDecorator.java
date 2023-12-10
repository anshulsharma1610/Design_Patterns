package com.example.generalstore.Decorator_Pattern;


import com.example.generalstore.Item;
import com.example.generalstore.ItemAPI;

public class GiftDecorator extends ItemDecorator {

	public GiftDecorator(ItemAPI decoratedItem) {
		super(decoratedItem);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String itemDescription() {
		// TODO Auto-generated method stub
		return decoratedItem.itemDescription()+ "..Wrapped for gift";
	}

	@Override
	public Object getItemManufact() {
		// TODO Auto-generated method stub
		return decoratedItem.getItemManufact();
	}
	
	public double getItemPrice() {
		Item b = Item.class.cast(decoratedItem);
		return b.getItemPrice()+10;
	}
	
}
