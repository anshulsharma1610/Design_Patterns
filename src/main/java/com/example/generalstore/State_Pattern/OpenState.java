package com.example.generalstore.State_Pattern;


import com.example.generalstore.ItemStore;

public class OpenState implements ShopStateAPI {
	
	private static ItemStore itemStore;
	
	public  OpenState(ItemStore store) {
		super();
		OpenState.itemStore =store;
	}
	
	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		System.out.println("Error ... Already in Open State");
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		itemStore.setState(itemStore.getCloseState());
		System.out.println("Currently in Close State");
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		itemStore.setState(itemStore.getStockState());
		System.out.println("Currently in Stock State");
		
	}

}
