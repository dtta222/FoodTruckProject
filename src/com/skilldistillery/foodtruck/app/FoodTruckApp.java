//************************************************************************
//Author: David Taylor
//Date: 10/15/2023
//Purpose: This Java application allows users to input and rate food trucks.
//
//Description:
//This application allows users to input information about food trucks,
//including their names, types of food they serve, and ratings. Users can
//input up to five food trucks and then choose from a menu of options to
//list existing food trucks, calculate the average rating, display the
//highest-rated food truck, or quit the program. The program provides a
//simple way for users to manage and compare food trucks based on their ratings.
//************************************************************************
package com.skilldistillery.foodtruck.app;
import com.skilldistillery.foodtruck.entities.FoodTruck;
import java.util.Scanner;

public class FoodTruckApp {
	public static void main(String[] args) {
	    System.out.println("Hello FoodTrucks!");
	
	    Scanner scan = new Scanner(System.in);
	    FoodTruck[] foodTrucks = new FoodTruck[5];
	    String foodName, foodType, input;
	    int count = 0;
	    double total = 0, foodRating;
	    boolean menu = true;
	
	    // Input loop for adding food trucks
	    while (count < 5) {
	        foodRating = -1;
	        System.out.print("\nEnter the name of food truck #" + (count + 1) + ": ");
	        foodName = scan.nextLine();
	
	        if (foodName.equalsIgnoreCase("quit")) {
	            break; // Exit the input loop
	        }
	
	        System.out.print("Enter the type of food for the truck: ");
	        foodType = scan.nextLine();
	
	        while (foodRating < 1 || foodRating > 10) {
	            System.out.print("Enter a rating for the truck (1-10): ");
	            foodRating = scan.nextDouble();
	            if (foodRating < 1 || foodRating > 10) {
	                System.out.println("\nInvalid input! Please enter a valid rating.");
	            }
	        }
	        scan.nextLine();
	
	        foodTrucks[count] = new FoodTruck(foodName, foodType, foodRating);
	        count++;
	    }
	
	    // Main menu loop
	    while (menu) {
	        System.out.print("""
	                \nMENU:
	                (1) List all existing trucks.
	                (2) See the average rating of food trucks.
	                (3) Display the highest-rated food truck.
	                (4) Quit the program.
	                ->\s""");
	
	        input = scan.nextLine();
	
	        switch (input) {
	            // print list of food trucks
	            case "1" -> {
	                System.out.println("\nList of existing food trucks:");
	                for (FoodTruck truck : foodTrucks) {
	                    if (truck != null) {
	                        System.out.println(truck);
	                    }
	                }
	            }
	            // print average rating of food trucks
	            case "2" -> {
	                double avg = 0;
	                for (FoodTruck truck : foodTrucks) {
	                    if (truck != null) {
	                        total += truck.getfoodRating();
	                    }
	                }
	                if (count != 0) {
	                    avg = total / count;
	                }
	                System.out.println("\nAverage rating of food trucks: " + avg);
	            }
	            // print highest-rated food truck
	            case "3" -> {
	                FoodTruck highestRated = foodTrucks[0];
	                for (FoodTruck truck : foodTrucks) {
	                    if (truck != null && truck.getfoodRating() > highestRated.getfoodRating()) {
	                        highestRated = truck;
	                    }
	                }
	                System.out.println("\nHighest-rated food truck: " + highestRated);
	            }
	            // quit program
	            case "4" -> {
	                System.out.println("\nThank you for using the FoodTruck App!");
	                menu = false;
	                scan.close();
	            }
	            default -> System.out.println("\nInvalid input! Please select a valid option.");
	        }
	    }
	}
}
