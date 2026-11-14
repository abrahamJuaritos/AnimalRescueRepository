import java.io.FileNotFoundException;
import java.io.File;
import java.io.PipedWriter;
import java.util.Scanner;

public class AnimalLover {

	
	public static void main(String[] args) {

		
	}//end of main method
	
	public static void rescueSetUp(String fileName, RescueCenter rescue)throws FileNotFoundException{
		
	}//end of method
	
	public static void runAnalysis(RescueCenter rescue)throws FileNotFoundException{
		
	}//end of method 
	
	/**
	 * Summary of the program.
	 * 
	 * No return.
	 */
	public static void displaySummary() {
		System.out.println("**********************************\n"
				+ "Animal Rescue Center Analysis\n"
				+ "**********************************\n"
				+ "-This program reads animal information from a text file\n"
				+ "-Displays each animal's weight category and weekly food\n"
				+ "-Calculates average daily and total weekly food\n"
				+ "Writes rescue information and analysis toa file\n");
	}//end of method

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
}//end of Animal class

class RescueCenter{
	private String rescueName;
	private Animal[] animals;
	private int animalCount;
	
	/**
	 * Constructor for RescueCenter class which initializes the animalCount and the 
	 * Animal data type array's size.
	 * 
	 * Initializes the rescue centers name.
	 * @param String rescueName
	 * @param int maxAnimals
	 */
	public RescueCenter(String rescueName, int maxAnimals) {
		this.rescueName = rescueName;
		animals = new Animal[maxAnimals];
	}//end of constructor method 
	
	/**
	 * Getter method for the Rescue center name instance variable.
	 * @return String rescueName
	 */
	public String getRescueName() {
		return rescueName;
	}///end of method
	
	/**
	 * Getter method for the animal counter instance variable.
	 * @return int animalCount
	 */
	public int getAnimalCount() {
		return animalCount;
	}//end of method
	
	/**
	 * add Animal inserts an Animal data type object into the Animal dataType array instance variable.
	 * @param Animal animal
	 */
	public void addAnimal(Animal animal) {
		if (animalCount == animals.length)
		{
			System.out.println("\nRescue is full");
		} else
		{
			animals[animalCount] = animal;
			animalCount += 1;
		}
		
	}//end of method
	
	/**
	 * Print statement to showcase stats for the Animal Rescue as a whole.
	 * Accesses instance variables and instance methods.
	 */
	public void displayAnimalResults() {
		System.out.printf("----------------%S Rescue Food Analysis-------------------\n"
				+ "Total number of animals: %d\n"
				+ "Total weekly food required: %.02f cups\n"
				+ "Average daily food amount: %.02f cups\n", rescueName, animalCount, calculateTotalWeeklyFood(), calculateAverageDailyFood());
		displayAnimalsAtOrAboveDailyFood(calculateAverageDailyFood());
	}//end of method
	
	/**
	 * Getter method in a sense. Accesses every Animal objects weekly food
	 * needs and sums them into a total value needed in cups for a week for the rescue as a whole.
	 * @return double totalWeeklyFoodReturn
	 */
	public double calculateTotalWeeklyFood() {
		double totalWeeklyFoodReturn = 0.0;
		
		for(int i = 0; i < animals.length; i ++) {
			if(animals[i] != null) {
				totalWeeklyFoodReturn += animals[i].calculateWeeklyFood();
			}//end of if conditional code block 
		}//end of for loop
		return totalWeeklyFoodReturn;
		
	}//end of method
	
	/**
	 * calculateAverageDailyFood iterates through all the entire rescue and for every animal adds up the daily 
	 * food cups and divides that sum by the number of animals.
	 * 
	 * @return double avgDailyFood
	 */
	public double calculateAverageDailyFood() {
		
		double avgDailyFood = 0.0;
		for(int i = 0; i<animals.length; i++) {
			if(animals[i] != null) {
				avgDailyFood += animals[i].getDailyFoodAmount();
			}//end of if condition 
		}//end of for loop
		avgDailyFood = avgDailyFood / animalCount;
		return avgDailyFood;
		
	}//end of method
	
	/**
	 * Method brings in the average between all animals daily cup intake.
	 * And accesses the animal display details within the animal class for the animals whose 
	 * daily intake equal to or greater than the average calculated from the calculateAverageDailyFood method.
	 * 
	 * @param double average
	 */
	public void displayAnimalsAtOrAboveDailyFood(double average) {
		System.out.println("Animals at or above avg:");
		for(int i = 0; i<animals.length; i++) {
			if(animals[i] != null) {
				if(animals[i].getDailyFoodAmount() >= average) {
					System.out.printf("%S: %.02f cups\n", animals[i].getName(), animals[i].getDailyFoodAmount());
				}//end of if condition code block
			}//end of if condition code block
		}//end of for loop
	}//end of method
	
	public void writeAnimalsToFile(String fileName)throws FileNotFoundException{
		
	}//end of method
}//end of RescueCenter class