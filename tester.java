/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodriguez
 *
 * Programming Assignment #3
 *
 * In this program, we will deal with a Directed Graph which is
 * a graph that has directed edges, some of them being two-way or just
 * one-way. We implemented this directed graph using an adjacency list
 * due to the fact that the adjacency matrix for the application was
 * sparse and it is more practical to utilize the adjacency list.
 * 
 * 
 * 
 *
 * Kevin Grossi
 */
package edu.csupomona.cs.cs241.prog_assgmnt_3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



/**
 * Driver program that utilizes the DirectedGraph Class and 
 * the Hashmap class. 
 * 
 * @author Kevin
 *
 */
public class tester {
	
	/**  
	 * Driver
	 * 
	 * @param args args
	 */
	public static void main(String[] args){
	
	DirectedGraph Santos = new DirectedGraph(12); //DirectedGraph for use with program
	HashMap<String, List<String>> map = new HashMap<String, List<String>>(); //Hashmpa for use with lookup
	
	//Adds all locations with keyword library to a 
	//String List. 
	List<String> library = new ArrayList<String>();
	library.add("Los Santos Public Library");
	
	//Adds all locations with keyword recreation to a 
	//String List. 
	List<String> recreation = new ArrayList<String>();
	recreation.add("Los Santos Public Library");
	recreation.add("Los Santos Santos' Stadium");
	recreation.add("Vinewood Boulevard");
	recreation.add("Los Santos Forum");
	recreation.add("Centennial Theater");
	recreation.add("Richman Country Club");
		
	//Adds all locations with keyword landmark to a 
	//String List. 
	List<String> landmark = new ArrayList<String>();
	landmark.add("Los Santos Public Library");
	landmark.add("Los Santos Santos' Stadium");
	landmark.add("Vinewood Boulevard");
	landmark.add("Los Santos Forum");
	landmark.add("Los Santos City Hall");
	landmark.add("Centennial Theater");
	
	//Adds all locations with keyword sports to a 
	//String List. 
	List<String> sports = new ArrayList<String>();
	sports.add("Los Santos Santos' Stadium");
	sports.add("Los Santos Forum");
	
	//Adds all locations with keyword arts to a 
	//String List. 
	List<String> arts = new ArrayList<String>();
	arts.add("Centennial Theater");
	
	//Adds all locations with keyword hospital to a 
	//String List. 
	List<String> hospital = new ArrayList<String>();
	hospital.add("All Saints General Hospital");
	
	//Adds all locations with keyword healthandcare to a 
	//String List. 
	List<String> healthandcare = new ArrayList<String>();
	healthandcare.add("All Saints General Hospital");
	healthandcare.add("Los Santos Gym");
	
	//Adds all locations with keyword dining to a 
	//String List. 
	List<String> dining = new ArrayList<String>();
	dining.add("BurgerShot");
	dining.add("Cluckin' Bell");
	dining.add("Pimientos");
	
	//Adds all locations with keyword fastfood to a 
	//String List. 
	List<String> fastfood = new ArrayList<String>();
	fastfood.add("BurgerShot");
	fastfood.add("Cluckin'Bell");
	
	//Adds all locations with keyword restaurant to a 
	//String List. 
	List<String> restaurant = new ArrayList<String>();
	restaurant.add("BurgerShot");
	restaurant.add("Cluckin'Bell");
	restaurant.add("Pimiento's");
	
	//Adds all locations with keyword fitness to a 
	//String List. 
	List<String> fitness = new ArrayList<String>();
	fitness.add("Los Santos Gym");
	
	//This adds all of the locations onto the Hash Map
	//by adding the Lists containing the Keyword in order
	//to reference the location. 
	map.put("Library", library);
	map.put("Recreation", recreation);
	map.put("Landmark", landmark);
	map.put("Sports", sports);
	map.put("Arts", arts);
	map.put("Hospital", hospital);
	map.put("Health&Care", healthandcare);
	map.put("Dining", dining);
	map.put("Fast-food", fastfood);
	map.put("Restaurant", restaurant);
	map.put("Fitness", fitness);
	
	//This sets all of the names of the vertices
	Santos.setLabel(0, "Los Santos Public Library");
	Santos.setLabel(1, "Los Santos Saints' Stadium");
	Santos.setLabel(2, "Vinewood Blvd");
	Santos.setLabel(3, "Los Santos Forum");
	Santos.setLabel(4, "Los Santos City Hall");
	Santos.setLabel(5, "Centenniel Theater");
	Santos.setLabel(6, "All Saints General Hospital");
	Santos.setLabel(7, "Richmond Country Club");
	Santos.setLabel(8, "BurgerShot");
	Santos.setLabel(9, "Los Santos Gym");
	Santos.setLabel(10, "Cluckin' Bell");
	Santos.setLabel(11, "Pimientos");
	
	//This adds all of the edges in the graph with a direction attached
	Santos.addEdge(0, 4, 5, "South");
	Santos.addEdge(0, 1, 3, "East");
	Santos.addEdge(1, 0, 3, "West");
	Santos.addEdge(1, 2, 2, "East");
	Santos.addEdge(2, 1, 2, "West");
	Santos.addEdge(2, 3, 5, "East");
	Santos.addEdge(2, 6, 6, "South");
	Santos.addEdge(3, 2, 5, "West");
	Santos.addEdge(4, 5, 4, "East");
	Santos.addEdge(5, 1, 1, "North");
	Santos.addEdge(5, 4, 5, "West");
	Santos.addEdge(5, 6, 7, "East");
	Santos.addEdge(6, 5, 7, "West");
	Santos.addEdge(6, 7, 3, "East");
	Santos.addEdge(6, 9, 1, "South");
	Santos.addEdge(7, 3, 1, "North");
	Santos.addEdge(7, 6, 3, "West");
	Santos.addEdge(8, 5, 2, "North");
	Santos.addEdge(8, 9, 1, "East");
	Santos.addEdge(9, 8, 1, "West");
	Santos.addEdge(9, 10, 1, "East");
	Santos.addEdge(9, 11, 2, "Southeast");
	Santos.addEdge(10, 7, 3, "North");
	Santos.addEdge(10, 9, 1, "West");
	Santos.addEdge(11, 10, 3, " North");
	
	//These arrays are for use in Dijkstra and printPath,
	//they will be populated the mentioned methods. 
	int[] parent = new int[Santos.size()];
	double[] distance = new double[Santos.size()];
	
	
	System.out.print("Greetings! Welcome to the Los Santos GPS System!\n"
			+ "If you want point-to-point navigation, enter '1'.\n"
			+ "If you want to find a specific destination, enter '2'.\n\n");
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Your input:");
	int firstOption = sc.nextInt();
	
	//Prompts the user for the first choice, utilizes a switch case. 
	switch(firstOption) {
	
	//User picks point to point, prints out all of the choices and has them
	//pick two out of the list, then performs Dijkstra and prints the path
	//between the two points.
	case 1:		
		System.out.print("You have chosen point-to-point navigation!\n\n");
		System.out.print("Here are all of the names of the locations\n"
				+ "in Los Santos assoicated with a number. Please enter\n"
				+ "the number associated to the location select your\n"
				+ "start and end point\n\n");
			
		System.out.println("(1) Los Santos Public Library");
		System.out.println("(2) Los Santos Saints' Stadium");
		System.out.println("(3) Vinewood Bvld");
		System.out.println("(4) Los Santos Forum");
		System.out.println("(5) Los Santos City Hall");
		System.out.println("(6) Centenniel Theater");
		System.out.println("(7) All Saints Hospital");
		System.out.println("(8) Richmond Country Club");
		System.out.println("(9) BurgerShot");
		System.out.println("(10) Los Santos Gym");
		System.out.println("(11) Cluckin Bell");
		System.out.println("(12) Pimientos");
		
		System.out.print("Your starting point? \n");
		int start = sc.nextInt()-1;
		System.out.print("Your end point? \n");
		int end = sc.nextInt()-1;
		
		Santos.dijkstra(start, distance, parent);
		Santos.printPath(start, end, parent);
		break;
	
	//User wants to find specific destination. Prompts them to search via name
	//or via keyword. 
	case 2:		
		System.out.print("You have chosen to find a specific destination!\n");
		System.out.print("If you want to search via name, enter '1'.\n");
		System.out.print("If you want to search via keyword, enter '2'.\n");
		System.out.println("Your input:");
		int secOption = sc.nextInt();
		
			//User wants to search by name, and is given the list of locations. When
			//the user chooses the destination and then asks if they want a list
			//of directions or to navigate to the destination
			switch(secOption) {
			case 1:
				System.out.print("You have chosen to search by name\n");
				System.out.print("Here are all of the names of the locations\n"
						+ "in Los Santos associated with a number. Please enter\n"
						+ "the number associated to your desired destination\n");						
				
				System.out.println("(1) Los Santos Public Library");
				System.out.println("(2) Los Santos Saints' Stadium");
				System.out.println("(3) Vinewood Bvld");
				System.out.println("(4) Los Santos Forum");
				System.out.println("(5) Los Santos City Hall");
				System.out.println("(6) Centenniel Theater");
				System.out.println("(7) All Saints Hospital");
				System.out.println("(8) Richmond Country Club");
				System.out.println("(9) BurgerShot");
				System.out.println("(10) Los Santos Gym");
				System.out.println("(11) Cluckin Bell");
				System.out.println("(12) Pimientos");
								
				System.out.print("Your destination? \n");
				int destination = sc.nextInt()-1;
				
				System.out.print("Destination selected\n");
				System.out.print("Enter '1' if you want directions to this destination\n");
				System.out.print("Enter '2' if you want to navigate to this location\n");
				
				int selection = sc.nextInt();
				
				//User selects list of directions. Much like the first choice, it uses Dijkstra
				//and then prints the path from the default location(City Hall) to the destination.
				//If navigation is chosen, then it will display the set of directions one by one. 
				//Navigate has not been implemented. 
				switch(selection){
				
				case 1: 
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, destination, parent);
					
					break;
					
				case 2:
					System.out.print("Your first set of directions is \n");
					break;
				}
				break;
				
			//User wants to search by keyword. Utilizes the populated Hashmap. User picks the
			//keyword that they want to search by. 
			case 2:
				System.out.print("You have chosen to search by keyword.\n");
				System.out.print("The following are the keywords that you can "
						+ "use to search with.\n");
				System.out.println(map.keySet());
				
				System.out.print("Please enter the keyword you wish to search by.\n");
				System.out.println("Your input:");
				String keyword = sc.next();
				
				//Depending on the keyword, program will print the list of locations associated
				//with the user input. User wil then pick a destination from the list. 
				switch (keyword){
				
				case "Health&Care": 
					System.out.println(healthandcare.toString());
					break;
				case "Restaurant":
					System.out.println(restaurant.toString());
					break;
				case "Recreation":
					System.out.println(recreation.toString());
					break;
				case "Landmark":
					System.out.println(landmark.toString());
					break;
				case "Library":
					System.out.println(library.toString());
					break;
				case "Hospital":
					System.out.println(hospital.toString());
					break;
				case "Dining":
					System.out.println(dining.toString());
					break;
				case "Fast-food":
					System.out.println(fastfood.toString());
					break;
				case "Sports":
					System.out.println(sports.toString());
					break;
				case "Arts":
					System.out.println(arts.toString());
					break;
				case "Fitness":
					System.out.println(fitness.toString());
					break;
				}
				
				System.out.print("Please pick a destination.\n");
				System.out.println("Your input:");
				String result = sc.next();
				
				//Depending on the destination, then the program will perform Dijkstra and
				//print the path to the destination from the default start point(Library)
				switch (result){
				
				case "Los Santos Public Library":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 0, parent);
					break;
					
				case "Los Santos Saints' Stadium":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 1, parent);
					break;
					
				case "Vinewood Blvd":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 2, parent);
					break;
					
				case "Los Santos Forum":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 3, parent);
					break;
					
				case "Los Santos City Hall":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 4, parent);
					break;
					
				case "Centenniel Theater":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 5, parent);
					break;
					
				case "All Saints Hospital":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 6, parent);
					break;
					
				case "Richmond Country Club":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 7, parent);
					break;
					
				case "BurgerShot":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 8, parent);
					break;
					
				case "Los Santos Gym":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 9, parent);
					break;
					
				case "Cluckin Bell":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 10, parent);
					break;
					
				case "Pimientos":
					System.out.print("The directions to the selected destination are : \n");
					Santos.dijkstra(4, distance, parent);
					Santos.printPath(4, 11, parent);
					break;
				}
				
				break;
			}
		break;
	
	
	}
	
	//Closes Scanner 
	sc.close();
	
	
	
	
	
	}
}
