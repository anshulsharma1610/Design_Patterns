package com.example.generalstore.Command_Pattern;


import com.example.generalstore.Item;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	private List<Item> orderList = new ArrayList<>();

	public void takeOrder(Item order){
		orderList.add(order);		
	}

   public String placeOrders(){
	   BuyItemCommand buyItemCommand = BuyItemCommand.getInstance();
      for (Item order : orderList) {
    	  System.out.println(buyItemCommand.setItem(order)
         .execute());

		  return buyItemCommand.setItem(order).execute();
      }
      orderList.clear();
	   return null;
   }
   
   public String placeOrders(List<Item> itemList){
	   orderList.clear();
	      for (Item b : itemList) {
	    	  orderList.add(b);
	      }
	      return placeOrders();
   }
   
   
   public String rentOrders(){
	   RentEquipmentCommand rentItemCommand = RentEquipmentCommand.getInstance();
      for (Item order : orderList) {
    	  System.out.println(rentItemCommand.setItem(order)
         .execute());
		  return rentItemCommand.setItem(order)
				  .execute();
      }
      orderList.clear();
	   return null;
   }
   
   public String rentOrders(List<Item> itemList){
	   orderList.clear();
	      for (Item b : itemList) {
	    	  orderList.add(b);
	      }
	   return rentOrders();
   }

	public List<Item> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Item> orderList) {
		this.orderList = orderList;
	}

}

