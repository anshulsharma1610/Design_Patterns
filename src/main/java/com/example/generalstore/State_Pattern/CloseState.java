package com.example.generalstore.State_Pattern;


import com.example.generalstore.ItemStore;

public class CloseState implements ShopStateAPI {
	
	private static ItemStore itemStore;
	
	public  CloseState(ItemStore store) {
		super();
		CloseState.itemStore =store;
	}
	
	@Override
	public String state_Open() {
		// TODO Auto-generated method stub
		itemStore.setState(itemStore.getOpenState());
		return "Transition from Close State to Open State";
	}

	@Override
	public String state_Close() {
		// TODO Auto-generated method stub
		return "Error - Already in Close State";
	}

	@Override
	public String state_Stock() {
		// TODO Auto-generated method stub
		itemStore.setState(itemStore.getStockState());
		return "Transition from Close State to Stock State";
		
	}

}
