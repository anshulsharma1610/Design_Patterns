package com.example.generalstore.Builder;

import com.example.generalstore.ConvertUtility;
import com.example.generalstore.Factory_Pattern.ItemFactory;
import com.example.generalstore.Item;
import com.example.generalstore.ItemCategory;

public class ItemBuilder implements BuilderAPI<Item>{
	
	private int itemID;
	private String itemName;
	private double itemPrice;
	private ItemCategory itemCategory;
	private String itemManufact;
	
	
	public String getItemManufact() {
		return itemManufact;
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

	public ItemBuilder(int itemID, String itemName, double itemPrice, ItemCategory itemCategory,String itemManufact) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemCategory = itemCategory;
		this.itemManufact = itemManufact;
	}
	
	public ItemBuilder(String s) {
		String[] tokens=s.split(",");
		this.itemID= ConvertUtility.StringToInt(tokens[0]);
		this.itemName=tokens[1];
		this.itemPrice=ConvertUtility.StringToDouble(tokens[2]);
		this.itemCategory=ItemCategory.getItemCategory(tokens[3]);
		this.itemManufact=tokens[4];
	}


	@Override
	public Item build() {
		// TODO Auto-generated method stub
		return ItemFactory.getInstance().getObject(this);
	}
}
