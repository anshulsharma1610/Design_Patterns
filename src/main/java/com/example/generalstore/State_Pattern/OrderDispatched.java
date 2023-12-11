package com.example.generalstore.State_Pattern;


import com.example.generalstore.ObserverPattern.Order;

public class OrderDispatched implements OrderStateAPI {

	private Order order;
	
	public OrderDispatched(Order order) {
		super();
		this.order = order;
	}
	
	@Override
	public String state_Awaiting_OrderConfirmation() {
		return "Error - Order already CONFIRMED";
	}

	@Override
	public String state_OrderConfirmed() {
		return "Error ... Order already CONFIRMED";
}

	@Override
	public String state_OrderDispatched() {
		return "Error - Order already in DISPATCH state";
	}

	@Override
	public String state_OrderDelivered() {
		order.setState(order.getOrderDelivered());
		return "SUCCESS!! Order successfully DELIVERED";
	}
}
