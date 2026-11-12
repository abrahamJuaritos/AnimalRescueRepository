import java.io.FileNotFoundException;
import java.io.File;
import java.io.PipedWriter;
import java.util.Scanner;

public class AnimalLover {

	
	public static void main(String[] args) {
		Animal firstAnimal = new Animal("Monkey", "Orangutang", 250.07, 50);
		firstAnimal.displayAnimalAnalysis();
		
		
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
	
	/**
	 * Animal constructor initializes the instance variables to the values when the Animal data type is created
	 * 
	 * @param String name
	 * @param String species
	 * @param double weight
	 * @param double dailyFoodAmount
	 */
	public Animal(String name, String species, double weight, double dailyFoodAmount){
		this.name = name;
		this.species = species;
		this.weight = weight;
		this.dailyFoodAmount = dailyFoodAmount;
	}//end of constructor 
	
	/**
	 * Getter method for Animals name
	 * 
	 * @return String name 
	 */
	public String getName() {
		return name;
	}//end of method 
	
	/**
	 * Getter method for a Animal's daily food intake in cups
	 * 
	 * @return double dailyFoodAmount
	 */
	public double getDailyFoodAmount() {
		return dailyFoodAmount;
	}//end of method
	
	/**
	 * Getter method for an Animal's weight value.
	 * 
	 * @return double weight
	 */
	public double getWeight() {
		return weight;
	}//end of method 
	
	/**
	 * Getter method for Animals species name
	 * 
	 * @return String species
	 */
	public String getSpecies() {
		return species;
	}//end of method
	
	/**
	 * Calculate daily food intake of an animal into a weekly unit by multiplying the daily
	 * unit by 7.
	 * 
	 * @return double weeklyUnit
	 */
	public double calculateWeeklyFood() {
		double weeklyUnit = dailyFoodAmount*7;
		return weeklyUnit;
	}//end of method
	
	/**
	 * Get a string representing the label for the weight range in which the animals
	 * weight value lies between.
	 * 
	 * @return String weightRange
	 */
	public String determineWeightCategory() {
		String weightRange = " ";
		if (weight < 20)
		{
			weightRange = "Small";
		} else if (weight < 50)
		{
			weightRange = "Medium";
		} else if (weight < 100)
		{
			weightRange = "Large";
		} else
		{
			weightRange = "XL";
		}

		return weightRange;
	}//end of method
	
	/**
	 * Print statement for an animals details.
	 * Attributes pulled from class while the weight category are called upon 
	 * by the class behaviors which produce their output instead of allocating memory.
	 */
	public void displayAnimalAnalysis() {
		System.out.printf("Name: %S\nSpecies: %S\nWeight: %.01f lbs\nWeight Category: %S\nDaily food amount: %.02f cups\nWeekly food amount: "
							+ "%.02f cups\n", name, species, weight, determineWeightCategory(), dailyFoodAmount, calculateWeeklyFood());
	}//end of method
	
	public void writeAnimalAnalysis(PrintWriter outputFile) {
		
	}//end of method 
	
	
}//end of Animal class