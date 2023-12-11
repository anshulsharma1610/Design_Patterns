package com.example.generalstore;


import com.example.generalstore.Builder.ItemBuilder;
import com.example.generalstore.Strategy_Pattern.DiscountStrategy;

public class Item implements ItemAPI {

	public int itemID;
	public String itemName;
	public double itemPrice;
	public ItemCategory itemCategory;
	public Object itemManufact;

	public Item(ItemBuilder builder) {
		super();
		this.itemID = builder.getItemID();
		this.itemName = builder.getItemName();
		this.itemPrice = builder.getItemPrice();
		this.itemCategory = builder.getItemCategory();
		this.itemManufact=builder.getItemManufact();
	}

	public Object getItemManufact() {
		return String.class.cast(itemManufact);
	}

	public void setItemManufact(String itemManufact) {
		this.itemManufact = itemManufact;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	@Override
	public String itemDescription() {
		// TODO Auto-generated method stub
		return this.itemName + ", "+this.itemCategory;
	}


	@Override
	public int manufacturerProductCount() {
		// TODO Auto-generated method stub
		return (int) Math.random()*10;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemCategory="
				+ itemCategory + ", itemManufact=" + (String) itemManufact + "]";
	}

	public String buyItem() {

		return this.itemName+ " is bought";
	}

	public String rentEquipment() {
		this.itemPrice = this.itemPrice * 0.75;
		return this.itemName + " is rented";
	}

	public double runStrategy() {
		double value = 0;
		switch(ItemStore.usingStrategy){
			case EmployeeDiscount:
				value = ItemStore.getAlgorithmMap().get(DiscountStrategy.EmployeeDiscount).discountPrice(this);
				break;
			case StudentDiscount:
				value = ItemStore.getAlgorithmMap().get(DiscountStrategy.StudentDiscount).discountPrice(this);
				break;
			default:
				value = itemPrice;
				break;
		}
		return value;
	}

}
