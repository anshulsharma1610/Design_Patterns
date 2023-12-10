package com.example.generalstore.Command_Pattern;


import com.example.generalstore.Item;

public class RentEquipmentCommand implements CommandAPI {

	private static RentEquipmentCommand instance;  // Lazy Singleton Factory Class
	private Item item;
	
	
	private RentEquipmentCommand() {
		super();
	}
	
	public static synchronized RentEquipmentCommand getInstance() {
		if (instance == null) {
			instance = new RentEquipmentCommand();
		}
		return instance;
	}

	@Override
	public String execute() {
		return item.rentEquipment();
	}

	public Item getItem() {
		return item;
	}

	public RentEquipmentCommand setItem(Item item) {
		this.item = item;
		return this;
	}
	
}
