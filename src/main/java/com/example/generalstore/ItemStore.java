package com.example.generalstore;
import com.example.generalstore.Adapter_Pattern.Manufacturer;
import com.example.generalstore.Adapter_Pattern.ManufacturerObjectAdapter;
import com.example.generalstore.Builder.EmployeeBuilder;
import com.example.generalstore.Builder.ItemBuilder;
import com.example.generalstore.Command_Pattern.Invoker;
import com.example.generalstore.Facade.DeliveryType;
import com.example.generalstore.Facade.OrderFacade;
import com.example.generalstore.Factory_Pattern.EmployeeFactory;
import com.example.generalstore.Factory_Pattern.ItemFactory;
import com.example.generalstore.ObserverPattern.Order;
import com.example.generalstore.State_Pattern.CloseState;
import com.example.generalstore.State_Pattern.ShopStateAPI;
import com.example.generalstore.State_Pattern.OpenState;
import com.example.generalstore.State_Pattern.StockState;
import com.example.generalstore.Strategy_Pattern.DiscountStrategy;
import com.example.generalstore.Strategy_Pattern.DiscountStrategyAPI;
import com.example.generalstore.Strategy_Pattern.EmployeeDiscount;
import com.example.generalstore.Strategy_Pattern.StudentDiscount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ItemStore implements ShopStateAPI {
	
    private String name;
    private List<Item> itemList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    public static DiscountStrategy usingStrategy = DiscountStrategy.NONE;
    private static final String FILE_NAME = "src/main/java/com/example/generalstore/inputData/details.csv";
	
	private ShopStateAPI openState = new OpenState(this);
	private ShopStateAPI stockState = new StockState(this);
	private ShopStateAPI closeState = new CloseState(this);
	private ShopStateAPI state;
	
	
    private static HashMap<DiscountStrategy, DiscountStrategyAPI> algorithmMap = new HashMap<>();
    {
//    	algorithmMap.put(DiscountStrategy.NONE, null);
        algorithmMap.put(DiscountStrategy.StudentDiscount, new StudentDiscount());
        algorithmMap.put(DiscountStrategy.EmployeeDiscount, new EmployeeDiscount());
    }
	
	public ItemStore(String name) {
		super();
		this.name = name;
		this.state = getOpenState();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public static DiscountStrategy getUsingStrategy() {
		return usingStrategy;
	}

	public static void setUsingStrategy(DiscountStrategy usingStrategy) {
		ItemStore.usingStrategy = usingStrategy;
	}

	public static HashMap<DiscountStrategy, DiscountStrategyAPI> getAlgorithmMap() {
		return algorithmMap;
	}

	public static void setAlgorithmMap(HashMap<DiscountStrategy, DiscountStrategyAPI> algorithmMap) {
		ItemStore.algorithmMap = algorithmMap;
	}

	public ShopStateAPI getState() {
		return state;
	}

	public void setState(ShopStateAPI state) {
		this.state = state;
	}

	public ShopStateAPI getOpenState() {
		return openState;
	}

	public void setOpenState(ShopStateAPI openState) {
		this.openState = openState;
	}

	public ShopStateAPI getStockState() {
		return stockState;
	}

	public void setStockState(ShopStateAPI stockState) {
		this.stockState = stockState;
	}

	public ShopStateAPI getCloseState() {
		return closeState;
	}

	public void setCloseState(ShopStateAPI closeState) {
		this.closeState = closeState;
	}

	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		this.state.state_Open();
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		this.state.state_Close();
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		this.state.state_Stock();
	}

	// Adapter Pattern demonstration
	public List<String> demonstrateAdapterPattern() {
		List<String> outputList = new LinkedList<>();
		FileUtil.getFileData(FILE_NAME);
		List<Item> itemList = new ArrayList<>();
		List<Item> itemList2 = new ArrayList<>();

		ItemBuilder itemBuilder = new ItemBuilder(1, "iPhone 15", 999.99, ItemCategory.Electronics, "Apple");
		ItemAPI item = ItemFactory.getInstance().getObject(itemBuilder);
		itemList.add((Item)item);
		System.out.println(item);
		FileUtil.appendEntryToFile(FILE_NAME, itemBuilder);

		// Your Adapter Pattern demonstration code here
		//Prototype Pattern to clone the object of manufacture
		outputList.add("***************************************************************************************");
		outputList.add("Demonstrating of prototype pattern to clone the object of Manufacturer");
		Manufacturer manufacture = Manufacturer.getInstance().clone();
		manufacture.setManufacturerName("Samsung")
				.setManufacturerRegistrationId(52).setNoOfManufacturerProductCount(10);

		//Adapter Pattern to adapt manufacture legacy code with  Item Interface
		ManufacturerObjectAdapter manufacturerAdapter = new ManufacturerObjectAdapter(item, manufacture);

		outputList.add(String.valueOf(manufacture));
		outputList.add("***************************************************************************************");
		outputList.add("Demonstrating of Adapter pattern to adapt manufacture legacy class with Item Interface and priting their object");

		outputList.add(String.valueOf(manufacturerAdapter));
		outputList.add("***************************************************************************************");
		return outputList;
	}

	// Builder Pattern demonstration
	public List<String> demonstrateBuilderPattern() {
		List<String> outputList = new LinkedList<>();

		// Your Builder Pattern demonstration code here
		//Builder Pattern and getting object of Builder using Factory and Singleton Pattern
		outputList.add("***************************************************************************************");
		outputList.add("Builder Design Pattern Demonstration. Delegating the responsibility of creating Item objects to Item Builder which implements build method and builds item object for us");
		outputList.add("Using Factory and singleton pattern to get only single instance of Item Builder object");
		ItemBuilder itemBuilder = new ItemBuilder(1, "iPhone 15", 999.99, ItemCategory.Electronics, "Apple");
		ItemAPI item = ItemFactory.getInstance().getObject(itemBuilder);
		itemList.add((Item)item);
		outputList.add(item.toString());
		FileUtil.appendEntryToFile(FILE_NAME, itemBuilder);

		return outputList;
	}


	// Command Pattern demonstration
	public List<String> demonstrateCommandPattern() {
		List<String> outputList = new LinkedList<>();
		FileUtil.getFileData(FILE_NAME);
		List<Item> itemList = new ArrayList<>();
		List<Item> itemList2 = new ArrayList<>();

		// Your Command Pattern demonstration code here
		//Command Pattern
		outputList.add("Demonstration of Command pattern to send the request for all Items orders and print them");

		Invoker invoker = new Invoker();
		invoker.placeOrders(itemList);
		invoker.rentOrders(itemList2);
		outputList.add("***************************************************************************************");

		ItemStore itmStr = new ItemStore("Best Buy");
		EmployeeBuilder emplBuilder = new EmployeeBuilder(7, 27, "Anshul", "Sharma", 50.00);
		Employee empl = EmployeeFactory.getInstance().getObject(emplBuilder);
		outputList.add("Using Factory and singleton pattern to get only single instance of Employee Builder object");
		outputList.add(empl.toString());
		outputList.add("***************************************************************************************");

		return outputList;
	}


	// Decorator Pattern demonstration
	public void demonstrateDecoratorPattern() {
	}

	// Facade Pattern demonstration
	public List<String> demonstrateFacadePattern() {
		List<String> outputList = new LinkedList<>();
		FileUtil.getFileData(FILE_NAME);
		List<Item> itemList = new ArrayList<>();
		List<Item> itemList2 = new ArrayList<>();

		ItemBuilder itemBuilder = new ItemBuilder(1, "iPhone 15", 999.99, ItemCategory.Electronics, "Apple");
		ItemAPI item = ItemFactory.getInstance().getObject(itemBuilder);

		outputList.add("Demonstration of Facade pattern and adding Decorator pattern to decorate Items and adding it to our order list");
		outputList.add("Demonstration of Observer pattern to notify the shipping cost and discount observer of changes as the number of our orders added into order list");

		OrderFacade orderFacade = new OrderFacade(item);
		Order order = orderFacade.order();
		Order order2 = orderFacade.order();

		outputList.add(order.toString());
		order.setDeliveryType(DeliveryType.Delivery);

		// Repeated for each itemBuilder and item addition
		itemBuilder = new ItemBuilder(2, "Samsung - 75\" UHD 4K Smart Tizen TV", 549.99, ItemCategory.Appliances, "Samsung");
		item = ItemFactory.getInstance().getObject(itemBuilder);
		order.addItem(item);
		outputList.add(order.toString());
		itemList.add((Item)item);
		FileUtil.appendEntryToFile(FILE_NAME, itemBuilder);

		// ... More itemBuilder and order additions ...

		itemBuilder = new ItemBuilder(6, "Avengers - Infinity War", 13.99, ItemCategory.Movies_Music, "Marvel");
		item = ItemFactory.getInstance().getObject(itemBuilder);
		order2.addItem(item);
		outputList.add(order2.toString());
		itemList2.add((Item)item);
		FileUtil.appendEntryToFile(FILE_NAME, itemBuilder);

		outputList.add("***************************************************************************************");

		return outputList;
	}


	// Factory Pattern demonstration
	public void demonstrateFactoryPattern() {
		// Your Factory Pattern demonstration code here

	}

	// Observer Pattern demonstration
	public void demonstrateObserverPattern() {
		// Your Observer Pattern demonstration code here
	}

	// Prototype Pattern demonstration
	public void demonstratePrototypePattern() {
		// Your Prototype Pattern demonstration code here
	}

	// State Pattern demonstration
	public List<String> demonstrateStatePattern() {
		List<String> outputList = new LinkedList<>();
		FileUtil.getFileData(FILE_NAME);
		List<Item> itemList = new ArrayList<>();
		List<Item> itemList2 = new ArrayList<>();

		ItemBuilder itemBuilder = new ItemBuilder(1, "iPhone 15", 999.99, ItemCategory.Electronics, "Apple");
		ItemAPI item = ItemFactory.getInstance().getObject(itemBuilder);

		OrderFacade orderFacade = new OrderFacade(item);
		Order order = orderFacade.order();
		Order order2 = orderFacade.order();

		outputList.add("Demonstration of state pattern completed life cycle of order transitioning from ordered to delivered state");

		order.state_Awaiting_OrderConfirmation();
		order.state_OrderConfirmed();
		order.state_OrderDispatched();
		order.state_OrderDelivered();
		outputList.add("Order states transitioned successfully.");

		outputList.add("***************************************************************************************");

		// Strategy Pattern Demonstration
		outputList.add("Demonstration of strategy pattern to show different discounts applied to original price and final price after student and employee discounts");
		outputList.add("Item before discount: \n" + item.toString());
		double price;
		ItemStore itmStr = new ItemStore("Best Buy");
		for(DiscountStrategy strategy : ItemStore.getAlgorithmMap().keySet()){
			itmStr.setUsingStrategy(strategy);
			price = ((Item)item).runStrategy();
			outputList.add("Item price after discount during sale: " + strategy + " - " + price);
		}

		return outputList;
	}
}
