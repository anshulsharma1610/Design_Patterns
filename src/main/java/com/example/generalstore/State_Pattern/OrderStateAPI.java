package com.example.generalstore.State_Pattern;

public interface OrderStateAPI {
	String state_Awaiting_OrderConfirmation();
	String state_OrderConfirmed();
	String state_OrderDispatched();
	String state_OrderDelivered();
}
