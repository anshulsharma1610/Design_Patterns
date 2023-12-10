package com.example.generalstore.State_Pattern;


import com.example.generalstore.ItemStore;

public class StockState implements ShopStateAPI {
	
	private static ItemStore itemStore;
	
	public  StockState(ItemStore store) {
		super();
		StockState.itemStore =store;
	}
	
	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		itemStore.setState(itemStore.getOpenState());
		System.out.println("Transition from Stock State to Open State");
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		itemStore.setState(itemStore.getCloseState());
		System.out.println("Transition from Stock State to Close State");
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		System.out.println("Error ... Already in Stock State");
		
	}
}
