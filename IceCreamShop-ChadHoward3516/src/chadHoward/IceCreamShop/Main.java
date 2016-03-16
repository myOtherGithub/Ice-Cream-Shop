package chadHoward.IceCreamShop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Dessert> orders =  new ArrayList<Dessert>();
	static Boolean stillOrdering = true;
	
	public static void main(String[] args) {
		welcomeCustomer();
		orders.add(placeNewOrder(input.nextLine()));
		while(stillOrdering){
			stillOrdering = addDessertToOrder();
		}
		checkOut();
		input.close();
	}
	
	private static void welcomeCustomer(){
		System.out.println("Hello, welcome to Chad's ice cream shop! What would you like today?");
		System.out.println("Menu: Ice Cream, Milkshake, Float?");
	}
	
	private static Boolean addDessertToOrder(){
		System.out.println("Would you like anything else today?: yes/no");
		String answer = input.nextLine();
		if(answer.equalsIgnoreCase("no")){
			return false;
		}else if(answer.equalsIgnoreCase("yes")){
			System.out.println("Menu: Ice Cream, Milkshake, Float?");
			Dessert dessert = placeNewOrder(input.nextLine());
			if(dessert!=null){
				orders.add(dessert);
				return true;
			}else{
				return addDessertToOrder();
			}
		}else{
			System.out.println("Sorry, I didn't get that, let's try again!");
			return addDessertToOrder();
		}
	}
	
	private static Dessert placeNewOrder(String startOrder){
		DessertBuilder desertBuilder = new DessertBuilder();
		switch (startOrder.toLowerCase()) {
        case "ice cream": 
        		return desertBuilder.startIceCreamQuestions();
        case "milkshake":
        		return desertBuilder.startMilkshakeQuestions();
        case "float":
        		return desertBuilder.startIceCreamFloatQuestions();
        default: 
        		System.out.println("Sorry, I didn't catch that! Let's try again.");
        		System.out.println("Menu: Ice Cream, Milkshake, Float?");
        		return placeNewOrder(input.nextLine());
		}
	}
	
	static void checkOut(){
		Boolean applyDiscount = askForDiscountCard();
		printReceipt(applyDiscount);
	}
	
	private static Boolean askForDiscountCard(){
		System.out.println("Do you have a discount card? : yes/no");
		String answer = input.nextLine();
		if(answer.equals("yes")){
			return true;
		}else if(answer.equals("no")){
			return false;
		}else{
			return askForDiscountCard();
		}
		
	}
	
	private static void printReceipt(Boolean discountCard){
		BigDecimal orderTotal = BigDecimal.ZERO;
		BigDecimal discountRate = BigDecimal.valueOf(.9);
		for(int i=0; i<orders.size(); i++){
			System.out.println("------------");
			System.out.println("Dessert "+(i+1));
			System.out.println("------------");
			if(orders.get(i).isDiscountable() && discountCard){
				orderTotal = orderTotal.add(orders.get(i).getBasePrice().multiply(discountRate));
				orders.get(i).printCompletedDessertInformation();
				System.out.println("Price: " + orders.get(i).getBasePrice().multiply(discountRate).setScale(2, BigDecimal.ROUND_CEILING));
			}else{
				orderTotal = orderTotal.add(orders.get(i).getBasePrice());
				orders.get(i).printCompletedDessertInformation();
				System.out.println("Price: $" + orders.get(i).getBasePrice().setScale(2, BigDecimal.ROUND_CEILING));
			}
		}
		System.out.println("------------");
		orderTotal.setScale(1, BigDecimal.ROUND_HALF_EVEN);
		System.out.println("Order Total: $" + orderTotal.setScale(2, BigDecimal.ROUND_CEILING).toString());
		System.out.println("------------");
		System.out.println("Thank you! :D");
	}
}
