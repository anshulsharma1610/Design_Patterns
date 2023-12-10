package com.example.generalstore.Command_Pattern;


import com.example.generalstore.Item;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	private List<Item> orderList = new ArrayList<>();

	public void takeOrder(Item order){
		orderList.add(order);		
	}

   public void placeOrders(){
	   BuyItemCommand buyItemCommand = BuyItemCommand.getInstance();
      for (Item order : orderList) {
    	  System.out.println(buyItemCommand.setItem(order)
         .execute());
      }
      orderList.clear();
   }
   
   public void placeOrders(List<Item> itemList){
	      for (Item b : itemList) {
	    	  orderList.add(b);
	      }
	      placeOrders();
   }
   
   
   public void rentOrders(){
	   RentEquipmentCommand rentItemCommand = RentEquipmentCommand.getInstance();
      for (Item order : orderList) {
    	  System.out.println(rentItemCommand.setItem(order)
         .execute());
      }
      orderList.clear();
   }
   
   public void rentOrders(List<Item> itemList){
	      for (Item b : itemList) {
	    	  orderList.add(b);
	      }
	      rentOrders();
   }
   
   
   
   

	public List<Item> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(List<Item> orderList) {
		this.orderList = orderList;
	}
   
   
   
   
   
   
   
}


//public class CommandPatternDemo {
//	   public static void main(String[] args) {
//	      Stock abcStock = new Stock();
//
//	      BuyStock buyStockOrder = new BuyStock(abcStock);
//	      SellStock sellStockOrder = new SellStock(abcStock);
//
//	      Broker broker = new Broker();
//	      broker.takeOrder(buyStockOrder);
//	      broker.takeOrder(sellStockOrder);
//
//	      broker.placeOrders();
//	   }
//	}
