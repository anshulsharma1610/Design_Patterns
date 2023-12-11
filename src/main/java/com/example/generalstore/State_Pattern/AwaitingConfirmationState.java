package com.example.generalstore.State_Pattern;


import com.example.generalstore.ObserverPattern.Order;

public class AwaitingConfirmationState implements OrderStateAPI{
	
	private Order order;
	
	public AwaitingConfirmationState(Order order) {
		super();
		this.order = order;
	}

	@Override
	public String state_Awaiting_OrderConfirmation() {
		return "Error - Already in Awaiting State";
	}

	@Override
	public String state_OrderConfirmed() {
		order.setState(order.getOrderConfirmed());
		return "SUCCESS!! Order moved to Confirmed State";
	}

	@Override
	public String state_OrderDispatched() {
		return "Error - Order not yet CONFIRMED";
	}

	@Override
	public String state_OrderDelivered() {
		return "Error - Order not yet CONFIRMED or DISPATCHED";
	}

}
