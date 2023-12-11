package com.example.generalstore;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	private List<Item> itemList2 = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    public static DiscountStrategy usingStrategy = DiscountStrategy.NONE;
    private static final String ORDER_FILE = "src/main/java/com/example/generalstore/output/orders.csv";
	private static final String ITEM_FILE = "src/main/java/com/example/generalstore/output/items.csv";

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
	public String state_Open() {
		// TODO Auto-generated method stub
		this.state.state_Open();

		return null;
	}

	@Override
	public String state_Close() {
		// TODO Auto-generated method stub
		this.state.state_Close();
		return null;
	}

	@Override
	public String state_Stock() {
		// TODO Auto-generated method stub
		this.state.state_Stock();
		return null;
	}

	// Adapter Pattern demonstration
	public List<String> demonstrateAdapterPattern() {
		List<String> outputList = new LinkedList<>();
		FileUtil.getFileData(ITEM_FILE);

		ItemBuilder itemBuilder = new ItemBuilder(7, "Galaxy s23", 999.99, ItemCategory.Electronics, "Samsung");
		ItemAPI item = ItemFactory.getInstance().getObject(itemBuilder);
		itemList.add((Item)item);
		System.out.println(item);
		FileUtil.appendEntryToFile(ITEM_FILE, itemBuilder);

		// Your Adapter Pattern demonstration code here
		//Prototype Pattern to clone the object of manufacture
		outputList.add("Demonstrating of prototype pattern to clone the object of Manufacturer");
		outputList.add("-------------------------------------------------------------------------");
		Manufacturer manufacture = Manufacturer.getInstance().clone();
		manufacture.setManufacturerName("Samsung")
				.setManufacturerRegistrationId(52).setNoOfManufacturerProductCount(10);

		//Adapter Pattern to adapt manufacture legacy code with  Item Interface
		ManufacturerObjectAdapter manufacturerAdapter = new ManufacturerObjectAdapter(item, manufacture);

		outputList.add(String.valueOf(manufacture));
		outputList.add("\n\nDemonstrating of Adapter pattern to adapt manufacture legacy class with Item Interface and priting their object");
		outputList.add("-------------------------------------------------------------------------");

		outputList.add(String.valueOf(manufacturerAdapter));
		return outputList;
	}

	// Builder Pattern demonstration
	public List<String> demonstrateBuilderPattern() {
		List<String> outputList = new LinkedList<>();
		FileUtil.getFileData(ITEM_FILE);

		// Your Builder Pattern demonstration code here
		//Builder Pattern and getting object of Builder using Factory and Singleton Pattern
		outputList.add("Builder Design Pattern Demonstration. Delegating the responsibility of creating Item objects to Item Builder which implements build method and builds item object for us");
		outputList.add("Using Factory and singleton pattern to get only single instance of Item Builder object");
		outputList.add("-------------------------------------------------------------------------");

		ItemBuilder itemBuilder = new ItemBuilder(1, "iPhone 15", 999.99, ItemCategory.Electronics, "Apple");
		ItemAPI item = ItemFactory.getInstance().getObject(itemBuilder);
		itemList.add((Item)item);
		FileUtil.appendEntryToFile(ITEM_FILE, itemBuilder);

		itemBuilder = new ItemBuilder(2, "Samsung - 75\" UHD 4K Smart Tizen TV", 549.99, ItemCategory.Appliances, "Samsung");
		item = ItemFactory.getInstance().getObject(itemBuilder);
		itemList.add((Item)item);
		FileUtil.appendEntryToFile(ITEM_FILE, itemBuilder);

		itemBuilder = new ItemBuilder(3, "Lenovo - Ideapad 1 14.0\" HD Laptop", 119.99, ItemCategory.Computers_Tablets, "Lenovo");
		item = ItemFactory.getInstance().getObject(itemBuilder);
		itemList.add((Item)item);
		FileUtil.appendEntryToFile(ITEM_FILE, itemBuilder);

		itemBuilder = new ItemBuilder(4, "Canon - EOS R5 Mirrorless Camera", 2999.99, ItemCategory.Cameras, "Canon");
		item = ItemFactory.getInstance().getObject(itemBuilder);
		itemList.add((Item)item);
		FileUtil.appendEntryToFile(ITEM_FILE, itemBuilder);

		itemBuilder = new ItemBuilder(5, "Apple - AirPods Max", 449.99, ItemCategory.Electronics, "Apple");
		item = ItemFactory.getInstance().getObject(itemBuilder);
		itemList.add((Item)item);
		FileUtil.appendEntryToFile(ITEM_FILE, itemBuilder);

		itemBuilder = new ItemBuilder(6, "Avengers - Infinity War", 13.99, ItemCategory.Movies_Music, "Marvel");
		item = ItemFactory.getInstance().getObject(itemBuilder);
		itemList2.add((Item)item);
		FileUtil.appendEntryToFile(ITEM_FILE, itemBuilder);

		outputList.add(itemList.toString());
		outputList.add(itemList2.toString());
		return outputList;
	}


	// Command Pattern demonstration
	public List<String> demonstrateCommandPattern() {
		List<String> outputList = new LinkedList<>();

		// Your Command Pattern demonstration code here
		//Command Pattern
		outputList.add("Command pattern to send the request for all Items orders and print them");
		outputList.add("-------------------------------------------------------------------------");
		Invoker invoker = new Invoker();
		// Placing orders for items
		outputList.add("Placing orders for items:");
		outputList.add("------------------------");
		outputList.add(invoker.placeOrders(itemList));

		// Renting orders for items
		outputList.add("\nRenting orders for items:");
		outputList.add("------------------------");
		outputList.add(invoker.rentOrders(itemList2));
		return outputList;
	}

	// Facade Pattern demonstration
	public List<String> demonstrateFacadePattern() {
		List<String> outputList = new LinkedList<>();

		// Format the date and time to use in the filename
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateFormat.format(new Date());

		// Create the order file with the current date and time in the filename
		final String ORDER_FILE = "src/main/java/com/example/generalstore/output/orders_" + timestamp + ".csv";
		FileUtil.newFile(ORDER_FILE);

		ItemBuilder itemBuilder = new ItemBuilder(1, "iPhone 15", 999.99, ItemCategory.Electronics, "Apple");
		ItemAPI item = ItemFactory.getInstance().getObject(itemBuilder);

		outputList.add("Facade pattern and adding Decorator pattern to decorate Items and adding it to our order list");
		outputList.add("Observer pattern to notify the shipping cost and discount observer of changes as the number of our orders added into order list");
		outputList.add("-------------------------------------------------------------------------");

		OrderFacade orderFacade = new OrderFacade(item);
		Order order = orderFacade.order();
		order.setDeliveryType(DeliveryType.Delivery);

		// Repeated for each itemBuilder and item addition
		itemBuilder = new ItemBuilder(2, "Samsung - 75\" UHD 4K Smart Tizen TV", 549.99, ItemCategory.Appliances, "Samsung");
		item = ItemFactory.getInstance().getObject(itemBuilder);
		order.addItem(item);
		outputList.add("Added Item to Order:\n" + order.toString());
		itemList.add((Item)item);

		itemBuilder = new ItemBuilder(3, "Lenovo - Ideapad 1 14.0\" HD Laptop", 119.99, ItemCategory.Computers_Tablets, "Lenovo");
		item = ItemFactory.getInstance().getObject(itemBuilder);
		order.addItem(item);
		outputList.add("Added Item to Order:\n" + order.toString());
		itemList.add((Item)item);

		// Create the order file
		FileUtil.createOrder(ORDER_FILE, order.getItemList(), order.getDiscount(), order.getShippingCost(), order.getOrderCost());

		// Display order details
		outputList.add("\n---------------------------------------------------");
		outputList.add("Order Details:\n" + order.toString());
		outputList.add("Items in Order:\n" + order.getItemListString());
		outputList.add("Discount: " + String.valueOf(order.getDiscount()));
		outputList.add("Shipping Cost: " + String.valueOf(order.getShippingCost()));
		outputList.add("Total Order Cost: " + String.valueOf(order.getOrderCost()));

		return outputList;
	}


	// Factory Pattern demonstration
	public List<String> demonstrateFactoryPattern() {
		// Your Factory Pattern demonstration code here
		List<String> outputList = new LinkedList<>();
		// Factory Pattern Demonstration
		outputList.add("Factory pattern with Singleton pattern");
		outputList.add("-------------------------------------------------------------------------");

		ItemStore itmStr = new ItemStore("Best Buy");
		EmployeeBuilder emplBuilder = new EmployeeBuilder(7, 27, "Anshul", "Sharma", 50.00);
		Employee empl = EmployeeFactory.getInstance().getObject(emplBuilder);
		outputList.add("Using Factory and singleton pattern to get only single instance of Employee Builder object");
		outputList.add(empl.toString());
		return outputList;
	}

	// State Pattern demonstration
	public List<String> demonstrateStatePattern() {
		List<String> outputList = new LinkedList<>();
		ItemBuilder itemBuilder = new ItemBuilder(1, "iPhone 15", 999.99, ItemCategory.Electronics, "Apple");
		ItemAPI item = ItemFactory.getInstance().getObject(itemBuilder);

		OrderFacade orderFacade = new OrderFacade(item);
		Order order = orderFacade.order();
		order.addItem(item);

		itemBuilder = new ItemBuilder(3, "Lenovo - Ideapad 1 14.0\" HD Laptop", 119.99, ItemCategory.Computers_Tablets, "Lenovo");
		item = ItemFactory.getInstance().getObject(itemBuilder);
		order.addItem(item);

		order.setDeliveryType(DeliveryType.Delivery);

		outputList.add("State pattern: Completed life cycle of order transitioning from ordered to delivered state");
		outputList.add("-------------------------------------------------------------------------");

		// Display order state transitions with purpose
		outputList.add("Order State Transitions:");
		outputList.add("-------------------------------------------------------------------------");
		outputList.add("1. " + order.state_Awaiting_OrderConfirmation() + " (Order placed, awaiting confirmation)");
		outputList.add("2. " + order.state_OrderConfirmed() + " (Order confirmed, awaiting dispatch)");
		outputList.add("3. " + order.state_OrderDispatched() + " (Order dispatched, in transit)");
		outputList.add("4. " + order.state_OrderDelivered() + " (Order delivered, completed)");
		outputList.add("Order states transitioned successfully.");
		return outputList;
	}

	public List<String> demonstrateStrategyPattern() {
		// Strategy Pattern Demonstration
		List<String> outputList = new LinkedList<>();

		outputList.add("Strategy pattern: Applying different discounts to original and final prices after student and employee discounts");
		outputList.add("-------------------------------------------------------------------------");

		// Create an item for demonstration
		ItemBuilder itemBuilder = new ItemBuilder(1, "iPhone 15", 999.99, ItemCategory.Electronics, "Apple");
		ItemAPI item = ItemFactory.getInstance().getObject(itemBuilder);

		// Print original item details
		outputList.add("Item before discount: \n" + item.toString());

		// Apply different discounts during a sale
		double price;
		ItemStore itmStr = new ItemStore("Best Buy");
		for(DiscountStrategy strategy : ItemStore.getAlgorithmMap().keySet()){
			itmStr.setUsingStrategy(strategy);
			price = ((Item)item).runStrategy();
			outputList.add("Item price after discount during sale (" + strategy + "): " + price);
		}
		return outputList;
	}
}
