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
package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private double foodRating;   // Rating for the food truck
	private static int nextID = 1;  // Static variable to assign unique IDs
	private int iD;            // Unique ID for the food truck
	private String foodName;   // Name of the food truck
	private String foodType;   // Type of food served
	
	// Default constructor
	public FoodTruck() {}
	
	// Parameterized constructor to initialize a FoodTruck object
	public FoodTruck(String foodName, String foodType, double foodRating) {
	    this.iD = nextID++;     // Assign a unique ID to the food truck
	    this.foodName = foodName;
	    this.foodType = foodType;
	    this.foodRating = foodRating;
	}
	
	// Setter methods for class fields
	public void setiD(int iD) {
	    this.iD = iD;
	}
	
	public void setfoodName(String foodName) {
	    this.foodName = foodName;
	}
	
	public void setfoodType(String foodType) {
	    this.foodType = foodType;
	}
	
	public void setfoodRating(double foodRating) {
	    this.foodRating = foodRating;
	}
	
	// Getter methods for class fields
	public int getiD() {
	    return iD;
	}
	
	public String getfoodName() {
	    return foodName;
	}
	
	public String getfoodType() {
	    return foodType;
	}
	
	public double getfoodRating() {
	    return foodRating;
	}
	
	// Override toString() method to provide a string representation of the FoodTruck object
	@Override
	public String toString() {
	    String phrase = "";
	    phrase += "\nID: " + getiD()
	            + "\nFood Name: " + getfoodName()
	            + "\nFood Rating: " + getfoodRating()
	            + "\nFood Type: " + getfoodType();
	    return phrase;
	}
}

