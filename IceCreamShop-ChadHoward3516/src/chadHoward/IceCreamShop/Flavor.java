package chadHoward.IceCreamShop;

public enum Flavor {
	
	CHOCOLATE("Chocolate"), 
	STRAWBERRY("Strawberry"), 
	ORANGE("Orange"), 
	BANANA("Banana"), 
	COCONUT("Coconut"), 
	VANILLA("Vanilla"), 
	BIRTHDAY_CAKE("Birthday Cake"), 
	COOKIE_DOUGH("Cookie dough"), 
	SUGAR_COOKIE_DOUGH("Sugar Cookie"), 
	RED_VELVET("Red Velvet"), 
	PEANUT_BUTTER("Peanut Butter"), 
	ROCKY_ROAD("Rocky Road"),
	MEGA_MONSTER_CHOCOLATE_CHUNK("Mega Monster Chocolate Chunk");
	
	String flavorName;
	
	Flavor(String name){
		flavorName = name;
	}
	
	String formattedName(){
		return flavorName;
	}
	
	public static void printFlavorMenu(){
		System.out.println("Heres the available flavors:");
		for(Flavor flavor : Flavor.values()){
			System.out.println(flavor.formattedName());
		}
	}
	
	public static Flavor checkFlavor(String inputFlavor){
		for(Flavor flavor : Flavor.values()){
			if(inputFlavor.equalsIgnoreCase(flavor.formattedName())){
				return flavor;
			}
		}
		return null;
	}
}
