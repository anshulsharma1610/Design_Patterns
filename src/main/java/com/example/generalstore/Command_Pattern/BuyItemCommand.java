package com.example.generalstore.Command_Pattern;


import com.example.generalstore.Item;

public class BuyItemCommand implements CommandAPI{

	private static BuyItemCommand instance;  // Lazy Singleton Factory Class
	private Item item;
	
	
	private BuyItemCommand() {
		super();
	}
	
	public static synchronized BuyItemCommand getInstance() {
		if (instance == null) {
			instance = new BuyItemCommand();
		}
		return instance;
	}

	@Override
	public String execute() {
		return item.buyItem();
	}

	public Item getItem() {
		return item;
	}

	public BuyItemCommand setItem(Item item) {
		this.item = item;
		return this;
	}
}
