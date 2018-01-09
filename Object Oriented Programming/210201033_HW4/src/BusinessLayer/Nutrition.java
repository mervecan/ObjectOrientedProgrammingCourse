package BusinessLayer;

import java.util.ArrayList;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */

public class Nutrition {
	
	private double calorie;
	private String name;
	private double unit;
	private NutritionType type;
	private String foodOrDrink;
	
	private ArrayList<Nutrition> nutritionList = new ArrayList<Nutrition>();
	
	public Nutrition(ArrayList<Nutrition> nutritionList) {
		setNutritionList(nutritionList);
	}
	
	public Nutrition( String name, double unit, double calorie, NutritionType type, String foodOrDrink) {
		super();
		this.calorie = calorie;
		this.name = name;
		this.unit = unit;
		this.type = type;
		this.foodOrDrink = foodOrDrink;
	}
	
	public Nutrition() {
		
	}
	
	public double getCalorie() {
		return calorie;
	}
	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}

	public NutritionType getType() {
		return type;
	}

	public void setType(NutritionType type) {
		this.type = type;
	}

	public String getFoodOrDrink() {
		return foodOrDrink;
	}

	public void setFoodOrDrink(String foodOrDrink) {
		this.foodOrDrink = foodOrDrink;
	}

	
	
	public ArrayList<Nutrition> getNutritionList() {
		return nutritionList;
	}

	public void setNutritionList(ArrayList<Nutrition> nutritionList) {
		this.nutritionList = nutritionList;
	}

	@Override
	public String toString() {
		return "Nutrition [calorie=" + calorie + ", name=" + name + ", unit=" + unit + ", type=" + type
				+ ", foodOrDrink=" + foodOrDrink + ", nutritionList=" + nutritionList + "]";
	}


	

	

	
	
	
	
}
