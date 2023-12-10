package com.example.generalstore.State_Pattern;


import com.example.generalstore.ItemStore;

public class CloseState implements ShopStateAPI {
	
	private static ItemStore itemStore;
	
	public  CloseState(ItemStore store) {
		super();
		CloseState.itemStore =store;
	}
	
	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		itemStore.setState(itemStore.getOpenState());
		System.out.println("Transition from Close State to Open State");
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		System.out.println("Error ... Already in Close State");
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		itemStore.setState(itemStore.getStockState());
		System.out.println("Transition from Close State to Stock State");
		
	}

}
