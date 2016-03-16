package chadHoward.IceCreamShop;

public enum Container {
	
	CAKE_CONE("Cake Cone"),
	PAPER_CONE("Paper Cone"),
	SUGAR_CONE("Sugar Cone"), 
	WAFFLE_CONE("Waffle Cone");
	
	String containerName;
	
	Container(String name){
		containerName = name;
	}
	
	String formattedName(){
		return containerName;
	}
	
	public static void printContainerMenu(){
		System.out.println("Here are the available containers:");
		for(Container container : Container.values()){
			System.out.println(container.formattedName());
		}
	}
	
	public static Container checkContainer(String inputContainerType){
		for(Container container : Container.values()){
			if(inputContainerType.equalsIgnoreCase(container.formattedName())){
				return container;
			}
		}
		return null;
	}
}
