package chadHoward.IceCreamShop;

import java.math.BigDecimal;
import java.util.List;

public abstract class Dessert {
	
	private List<Flavor> iceCreamScoops;
	
	private BigDecimal price = BigDecimal.valueOf(2.00);
	
	public List<Flavor> getFlavors(){
		return iceCreamScoops;
	}
	
	public void setFlavors(List<Flavor> flavors){
		iceCreamScoops = flavors;
	}
	
	public Boolean isDiscountable(){
		return true;
	}
	
	public BigDecimal getBasePrice(){
		return price;
	}
	
	public void printCompletedDessertInformation(){
		System.out.println("N/A");
	}
}
