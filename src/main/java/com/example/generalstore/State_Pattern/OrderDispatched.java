package com.example.generalstore.State_Pattern;


import com.example.generalstore.ObserverPattern.Order;

public class OrderDispatched implements OrderStateAPI {

	private Order order;
	
	public OrderDispatched(Order order) {
		super();
		this.order = order;
	}
	
	@Override
	public void state_Awaiting_OrderConfirmation() {
		System.out.println("Error ... Order already CONFIRMED");
	}

	@Override
	public void state_OrderConfirmed() {
		System.out.println("Error ... Order already CONFIRMED");	
	}

	@Override
	public void state_OrderDispatched() {
		System.out.println("Error ... Order already in DISPATCH state");
	}

	@Override
	public void state_OrderDelivered() {
		order.setState(order.getOrderDelivered());
		System.out.println("SUCCESS!! Order successfully DELIVERED");
	}

}
