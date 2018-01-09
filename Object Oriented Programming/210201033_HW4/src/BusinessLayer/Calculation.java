package BusinessLayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import DataAccessLayer.DataAccessLayer;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class Calculation {
	DataAccessLayer dal;
	ArrayList<Nutrition> nutritionList;
	public Calculation() throws IOException {
		dal = new DataAccessLayer();
		nutritionList = new ArrayList<Nutrition>();
		nutritionList = dal.readFile();
	}
	
//---------------------------------------------------------------------------------------		
	//calculate MaxCalorie according to formula
	static double maxCalorie=0;
	public double calculateMaxCalorie(String gender, double weight, double height, int age ) {
		if(gender.equals("Female")) {
			maxCalorie = (10*weight)+6.25 * height - 5*age - 161;
		}else if(gender.equals("Male")) {
			maxCalorie = (10*weight)+6.25 * height - 5*age +5;
		}
		return maxCalorie;
	}
	
//---------------------------------------------------------------------------------------	
	//return breakfastList according to given information
	public ArrayList<Nutrition> breakfastList (){
		ArrayList<Nutrition> breakfastList = new ArrayList<Nutrition>();
		for(int i=0;i<nutritionList.size();i++) {
			if(nutritionList.get(i).getType().equals(NutritionType.CEREAL)){
				breakfastList.add(nutritionList.get(i));
			}else if(nutritionList.get(i).getType().equals(NutritionType.DAIRY_PRODUCT)){
				breakfastList.add(nutritionList.get(i));
			}else if(nutritionList.get(i).getType().equals(NutritionType.FRUITS)) {
				breakfastList.add(nutritionList.get(i));
			}else if(nutritionList.get(i).getType().equals(NutritionType.VEGETABLES)) {
				breakfastList.add(nutritionList.get(i));
			}
		}
		return breakfastList;
	}
//---------------------------------------------------------------------------------------	
	//return lunchList according to given information
	public ArrayList<Nutrition> lunchList (){
		ArrayList<Nutrition> lunchList = new ArrayList<Nutrition>();
		for(int i=0;i<nutritionList.size();i++) {
			if(nutritionList.get(i).getType().equals(NutritionType.MEATS)){
				lunchList.add(nutritionList.get(i));
			}else if(nutritionList.get(i).getType().equals(NutritionType.FRUITS)) {
				lunchList.add(nutritionList.get(i));
			}else if(nutritionList.get(i).getType().equals(NutritionType.VEGETABLES)) {
				lunchList.add(nutritionList.get(i));
			}
		}		
		return lunchList;
	}
//---------------------------------------------------------------------------------------	
	//return dinnerList according to given information
	public ArrayList<Nutrition> dinnerList (){
		ArrayList<Nutrition> dinnerList = new ArrayList<Nutrition>();
		for(int i=0;i<nutritionList.size();i++) {
			if(nutritionList.get(i).getType().equals(NutritionType.FISH)){
				dinnerList.add(nutritionList.get(i));
			}else if(nutritionList.get(i).getType().equals(NutritionType.FRUITS)) {
				dinnerList.add(nutritionList.get(i));
			}else if(nutritionList.get(i).getType().equals(NutritionType.VEGETABLES)) {
				dinnerList.add(nutritionList.get(i));
			}
		}		
		return dinnerList;
	}
	
//---------------------------------------------------------------------------------------	
	//return ascendingOrderList
	public ArrayList<Nutrition> ascendingOrder(ArrayList<Nutrition> nutritionList) {
		 Collections.sort(nutritionList,new Comparator<Nutrition>() {
			 public int compare(Nutrition n1,Nutrition n2) {
				 return Integer.compare((int)n1.getCalorie(),(int)n2.getCalorie());
			 }
		 });
		 return nutritionList;
	}
//---------------------------------------------------------------------------------------	
	//return descendingOrderList
	public ArrayList<Nutrition> descendingOrder(ArrayList<Nutrition> nutritionList){
		 Collections.sort(nutritionList,new Comparator<Nutrition>() {
			 public int compare(Nutrition n1,Nutrition n2) {
				 return (int) (n2.getCalorie()-n1.getCalorie());
			 }
		 });
		 return nutritionList;
	}
	
//---------------------------------------------------------------------------------------	
	//return dailyNutritionList selected from nutritionList
	ArrayList<Nutrition> dailyNutritions = new ArrayList<Nutrition>();
	public ArrayList<Nutrition> addNutritionList(Nutrition nutritionOb) {
		
		dailyNutritions.add(nutritionOb);
		return dailyNutritions;
	}
	
	public ArrayList<Nutrition> returnList(){
		return dailyNutritions;
	}
//---------------------------------------------------------------------------------------	
	//check exceed or not daily calorie limit
	public boolean checkCalorie() {
		double calorie = 0;
		for(int i=0; i<dailyNutritions.size();i++) {
			calorie = calorie + dailyNutritions.get(i).getCalorie();
		}
		
		if(calorie <= maxCalorie ) {
			return true;
		}else {
			
			return false;
		}

	}
}
