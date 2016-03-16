package chadHoward.IceCreamShop;

public enum Soda {
	
	CHEERWINE("Cheerwine"), 
	PEPSI("Pepsi"), 
	DR_PEPPER("Dr.Pepper"), 
	COKE("Coke"), 
	GINGER_ALE("Ginger Ale"), 
	ROOT_BEER("Root Beer"),
	ORANGE_SODA("Orange Soda"),
	CREAM_SODA("Cream Soda");
	
	String sodaName;
	
	Soda(String name){
		sodaName = name;
	}
	
	String formattedName(){
		return sodaName;
	}
	
	public static void printSodaMenu(){
		System.out.println("Heres the available sodas:");
		for(Soda soda : Soda.values()){
			System.out.println(soda.formattedName());
		}
	}
	
	public static Soda checkSoda(String inputSoda){
		for(Soda soda : Soda.values()){
			if(inputSoda.equalsIgnoreCase(soda.formattedName())){
				return soda;
			}
		}
		return null;
	}
}
