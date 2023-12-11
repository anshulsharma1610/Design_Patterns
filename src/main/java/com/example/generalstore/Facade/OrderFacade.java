package com.example.generalstore.Facade;

import com.example.generalstore.Decorator_Pattern.GiftDecorator;
import com.example.generalstore.Decorator_Pattern.ItemDecorator;
import com.example.generalstore.ItemAPI;
import com.example.generalstore.ObserverPattern.Order;

public class OrderFacade {
	private ItemAPI item;

	public OrderFacade() {
		super();
	}
	
	public OrderFacade(ItemAPI item) {
		super();
		this.item = item;
	}
	
	public Order order() {
		Order order = new Order();
		ItemDecorator gift = new GiftDecorator(item);
//		System.out.println(gift);
		order.addItem(gift);
		return order;
	}
	
	public OrderFacade setItem(ItemAPI item) {
		this.item = item;
		return this;
	}	
}
