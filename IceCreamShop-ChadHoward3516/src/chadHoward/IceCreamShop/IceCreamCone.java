package chadHoward.IceCreamShop;

import java.math.BigDecimal;
import java.util.List;

public class IceCreamCone extends Dessert {
		
	private Container container;
	
	public Container getContainer(){
		return container;
	}
	
	public void setContainer(Container container){
		this.container = container;
	}
	
	public Boolean isDicountable(){
		return false;
	}
	
	public BigDecimal getBasePrice(){
		Double basePrice = 4.23D;
		basePrice = basePrice + this.getFlavors().size()*.25;
		return BigDecimal.valueOf(basePrice);
	}
	
	public void printCompletedDessertInformation(){
		List<Flavor> flavors = this.getFlavors();
		if(flavors.size() == 1){
			System.out.println("1 scoop of ice cream in a " + container.formattedName().toLowerCase());
		}else{
			System.out.println(flavors.size() + " scoops of ice cream in a " + container.formattedName().toLowerCase());
		}
		for(int i=0; i<flavors.size(); i++){
			System.out.println("Scoop "+(i+1)+" : "+flavors.get(i).formattedName());
		}
	}
}
