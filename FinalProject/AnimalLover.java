import java.io.FileNotFoundException;
import java.io.File;
import java.io.PipedWriter;
import java.util.Scanner;

public class AnimalLover {

	
	public static void main(String[] args) {
		
	}//end of main method

}// end of AnimalLover class

/**
 * Animal class holds the blueprint for an animal data type.
 * Attributes:
 * name
 * species
 * weight
 * dailyFoodAmount
 */
class Animal{
	private String name;
	private String species;
	double weight;
	double dailyFoodAmount;
	
	public Animal(String name, String species, double weight, double dailyFoodAmount){
		this.name = name;
		this.species = species;
		this.weight = weight;
		this.dailyFoodAmount = dailyFoodAmount;
	}//end of constructor 
	
	public String getName() {
		return name;
	}//end of method 
	
	public double getDailyFoodAmount() {
		return dailyFoodAmount;
	}//end of method
	
	public double getWeight() {
		return weight;
	}//end of method 
	
	public String getSpecies() {
		return species;
	}//end of method
	
	public double calculateWeeklyFood() {
	
	}//end of method
	
	public String determineWeightCategory() {
		
	}//end of method
	
	public void displayAnimalAnalysis() {
		
	}//end of method
	
	public void writeAnimalAnalysis(PrintWriter outputFile) {
		
	}//end of method 
	
	
}//end of Animal class