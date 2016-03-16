package chadHoward.IceCreamShop;

public enum Milk {
	
	WHOLE("Whole"),
	SKIM("Skim"),
	TWO_PERCENT("Two Percent");
	
	String milkTypeName;
	
	Milk(String name){
		milkTypeName = name;
	}
	
	String formattedName(){
		return milkTypeName;
	}
	
	public static void printMilkMenu(){
		System.out.println("Heres the available milks:");
		for(Milk milk : Milk.values()){
			System.out.println(milk.formattedName());
		}
	}
	
	public static Milk checkMilk(String inputMilkType){
		for(Milk milk : Milk.values()){
			if(inputMilkType.equalsIgnoreCase(milk.formattedName())){
				return milk;
			}
		}
		return null;
	}
}
