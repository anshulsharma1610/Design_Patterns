package com.example.generalstore.Decorator_Pattern;


import com.example.generalstore.ItemAPI;

public abstract class ItemDecorator implements ItemAPI {
	
	protected ItemAPI decoratedItem;
	
	public ItemDecorator(ItemAPI decoratedItem){
	      this.decoratedItem = decoratedItem;
	}
	 
	@Override
	public String itemDescription() {
		// TODO Auto-generated method stub
		return decoratedItem.itemDescription();
	}

	@Override
	public int manufacturerProductCount() {
		// TODO Auto-generated method stub
		return decoratedItem.manufacturerProductCount();
	}
	
	public ItemAPI getDecoratedItem() {
		return this.decoratedItem;
	}

	@Override
	public String toString() {
		return "ItemDecorator [ItemDescription()=" + itemDescription() + ", manufacturerProductCount()="
				+ manufacturerProductCount() + ", getDecoratedItem()=" + getDecoratedItem() + "]";
	}
}
