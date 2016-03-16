package chadHoward.IceCreamShop;

import java.util.ArrayList;
import java.util.Scanner;

public class DessertBuilder {
	Scanner input = new Scanner(System.in);
	
	public IceCreamCone startIceCreamQuestions(){
		IceCreamCone iceCreamCone = new IceCreamCone();
		iceCreamCone.setFlavors(askForFlavors("iceCreamCone"));
		iceCreamCone.setContainer(askForContainerType());
		return iceCreamCone;
	}
	
	public Milkshake startMilkshakeQuestions(){
		Milkshake milkshake = new Milkshake();
		milkshake.setFlavors(askForFlavors("milkshake"));
		milkshake.setMilk(askForMilkType());
		return milkshake;
	}
	
	public IceCreamFloat startIceCreamFloatQuestions(){
		IceCreamFloat iceCreamFloat = new IceCreamFloat();
		iceCreamFloat.setFlavors(askForFlavors("float"));
		iceCreamFloat.setSoda(askForSodaType());
		return iceCreamFloat;
	}
	
	private ArrayList<Flavor> askForFlavors(String type){
		ArrayList<Flavor> flavors = new ArrayList<Flavor>();
		Boolean stillAsking = true;
		Integer numberOfScoops = null;
		if(type.equals("iceCreamCone")){
			numberOfScoops = 2;
		}else if(type.equals("milkshake")){
			numberOfScoops = 1;
		}
		while(stillAsking){
			if(numberOfScoops !=null && numberOfScoops == flavors.size()){
				return flavors;
			}else{
				if(flavors.size() > 0){
					System.out.println("Would you like another scoop? yes/no");
					String answer = input.nextLine();
					if(answer.equalsIgnoreCase("no")){
						return flavors;
					}else{
						flavors.add(askFlavor());
					}
				}else{
					flavors.add(askFlavor());
				}
			}
		}
		return flavors;
	}
		
	private Flavor askFlavor(){
		System.out.println("What flavor of Ice cream would you like?");
		Flavor.printFlavorMenu();
		String answer = input.nextLine();
		Flavor answeredFlavor = Flavor.checkFlavor(answer);
		if(answeredFlavor == null){
			System.out.println("Sorry, I didn't get that.");
			return askFlavor();
		}else{
			return answeredFlavor;
		}
	}
	
	private Container askForContainerType(){
		System.out.println("What would you like your ice cream to be in?");
		Container.printContainerMenu();
		String answer = input.nextLine();
		Container answeredContainer = Container.checkContainer(answer.toLowerCase());
		if(answeredContainer == null){
			System.out.println("Sorry, I didn't get that.");
			return askForContainerType();
		}else{
			return answeredContainer;
		}
	}
	
	private Milk askForMilkType(){
		System.out.println("What type of milk would you like in your shake?");
		Milk.printMilkMenu();
		String answer = input.nextLine();
		Milk answeredMilk = Milk.checkMilk(answer);
		if(answeredMilk == null){
			System.out.println("Sorry, I didn't get that.");
			return askForMilkType();
		}else{
			return answeredMilk;
		}
	}
	
	private Soda askForSodaType(){
		System.out.println("What type of soda would you like in your float?");
		Soda.printSodaMenu();
		String answer = input.nextLine();
		Soda answeredSoda = Soda.checkSoda(answer);
		if(answeredSoda == null){
			System.out.println("Sorry, I didn't get that.");
			return askForSodaType();
		}else{
			return answeredSoda;
		}
	}
}
