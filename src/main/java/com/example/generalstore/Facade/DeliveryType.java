package com.example.generalstore.Facade;

public enum DeliveryType {
	Delivery,
	InStore;
	
    public static DeliveryType getDeliveryType(String s) {
    	DeliveryType result = null;
    	switch(s.toLowerCase()) {
    	case "delivery":
    		result = DeliveryType.Delivery;
    		break;
	    case "in-store":
	    	result = DeliveryType.InStore;
	    	break;
		default:
			result = DeliveryType.InStore;
			break;
		}
    	return result;
    }
}
