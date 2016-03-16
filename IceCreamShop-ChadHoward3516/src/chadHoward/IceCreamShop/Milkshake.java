package chadHoward.IceCreamShop;

import java.math.BigDecimal;
import java.util.List;

public class Milkshake extends Dessert {
	
	private Milk milk;
		
	public Milk getMilk(){
		return milk;
	}
	
	public void setMilk(Milk milk){
		this.milk = milk;
	}
	
	public BigDecimal getBasePrice(){
		return BigDecimal.valueOf(4.16);
	}
	
	public void printCompletedDessertInformation(){
		List<Flavor> flavors = this.getFlavors();
		System.out.println(milk.formattedName().toLowerCase() + " milk " + flavors.get(0).flavorName.toLowerCase() + " milkshake");
	}
}
