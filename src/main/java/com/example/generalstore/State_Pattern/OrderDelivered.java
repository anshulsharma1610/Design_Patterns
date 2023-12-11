package com.example.generalstore.State_Pattern;


import com.example.generalstore.ObserverPattern.Order;

public class OrderDelivered implements OrderStateAPI {

	private Order order;
	
	public OrderDelivered(Order order) {
		super();
		this.order = order;
	}
	
	@Override
	public String state_Awaiting_OrderConfirmation() {
		return "Error - Order already DELIVERED";
	}

	@Override
	public String state_OrderConfirmed() {
		return "Error - Order already DELIVERED";
	}

	@Override
	public String state_OrderDispatched() {
		return "Error ... Order already DELIVERED";
	}

	@Override
	public String state_OrderDelivered() {
		return "Error - Order already DELIVERED";
	}
}
