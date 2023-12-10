package com.example.generalstore.Factory_Pattern;


import com.example.generalstore.Builder.BuilderAPI;
import com.example.generalstore.Builder.ItemBuilder;
import com.example.generalstore.Item;

public class ItemFactory extends AbstractFactory<Item> {
	
	private static ItemFactory instance=new ItemFactory(); // Eager Singleton Factory Class
	
	private ItemFactory() {
		super();
	}
	
	public synchronized static ItemFactory getInstance() {
		return instance;
	}

	@Override
	public Item getObject(BuilderAPI<Item> builder) {
		// TODO Auto-generated method stub
		ItemBuilder itemBuilder =(ItemBuilder)builder;
		return new Item(itemBuilder);
	}

}
