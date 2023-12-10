package com.example.generalstore.Adapter_Pattern;

import com.example.generalstore.ItemAPI;

public class ManufacturerObjectAdapter implements ItemAPI{
	
	private Manufacturer manufacturer;
	private ItemAPI item;
	
	public ManufacturerObjectAdapter(ItemAPI item, Manufacturer adaptee) {
		this.item = item;
		this.manufacturer=adaptee;
	}

	@Override
	public String itemDescription() {
		// TODO Auto-generated method stub
		return item.itemDescription();
	}

	@Override
	public Object getItemManufact() {
		// TODO Auto-generated method stub
		return Manufacturer.class.cast(manufacturer);
	}

	@Override
	public int manufacturerProductCount() {
		return manufacturer.getManufacturerProductCount();
	}

	@Override
	public double getItemPrice() {
		return item.getItemPrice();
	}



	@Override
	public String toString() {
		return "[" + manufacturer + "], [item=" + item + "]";
	}

	
	
}
