package com.example.generalstore.State_Pattern;


import com.example.generalstore.ObserverPattern.Order;

public class OrderConfirmed implements OrderStateAPI{

	private Order order;
	
	public OrderConfirmed(Order order) {
		super();
		this.order = order;
	}
	
	@Override
	public String state_Awaiting_OrderConfirmation() {
		return "Error - Order already CONFIRMED";
	}

	@Override
	public String state_OrderConfirmed() {
		return "Error - Order already in CONFIRMED State";
	}

	@Override
	public String state_OrderDispatched() {
		order.setState(order.getOrderDispatched());
		return "SUCCESS!! Order DISPATCHED";
	}

	@Override
	public String state_OrderDelivered() {
		return "Error - Order not yet DISPATCHED";
	}
}
