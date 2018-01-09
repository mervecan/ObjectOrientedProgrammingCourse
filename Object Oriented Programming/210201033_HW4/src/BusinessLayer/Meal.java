package BusinessLayer;

import java.util.ArrayList;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public abstract class Meal {
	
	private double totalCalorie;
	private ArrayList<Nutrition> nutritionList;
	private ArrayList<NutritionType> nutritionTypeList;
	
	public Meal() {
		
	}
	
	public Meal(double totalCalorie, ArrayList<Nutrition> nutritionList, ArrayList<NutritionType> nutritionTypeList) {
		super();
		this.totalCalorie = totalCalorie;
		this.nutritionList = nutritionList;
		this.nutritionTypeList = nutritionTypeList;
	}



	public double getTotalCalorie() {
		return totalCalorie;
	}



	public void setTotalCalorie(double totalCalorie) {
		this.totalCalorie = totalCalorie;
	}



	public ArrayList<Nutrition> getNutritionList() {
		return nutritionList;
	}



	public void setNutritionList(ArrayList<Nutrition> nutritionList) {
		this.nutritionList = nutritionList;
	}



	public ArrayList<NutritionType> getNutritionTypeList() {
		return nutritionTypeList;
	}



	public void setNutritionTypeList(ArrayList<NutritionType> nutritionTypeList) {
		this.nutritionTypeList = nutritionTypeList;
	}



	public abstract double totalCalorie();

}
