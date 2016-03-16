package chadHoward.IceCreamShop;

import java.math.BigDecimal;
import java.util.List;

public class IceCreamFloat extends Dessert{
	
	private Soda soda;
	
	public Soda getSoda(){
		return soda;
	}
	
	public void setSoda(Soda soda){
		this.soda = soda;
	}
	
	public BigDecimal getBasePrice(){
		Double basePrice = 5.25D;
		basePrice = basePrice + this.getFlavors().size()*.25;
		return BigDecimal.valueOf(basePrice);
	}
	
	public void printCompletedDessertInformation(){
		List<Flavor> flavors = this.getFlavors();
		if(flavors.size() >1){
			System.out.println(soda.formattedName().toLowerCase() + " float with " + flavors.size() + " scoops of ice cream");
			for(int i=0; i<flavors.size(); i++){
				System.out.println("Scoop " + (i+1) + " : " + flavors.get(i).formattedName());
			}
		}else{
			System.out.println(soda.formattedName().toLowerCase() + " float with a scoop of " + flavors.get(0).formattedName().toLowerCase() + " ice cream");
		}		
		
	}
}
