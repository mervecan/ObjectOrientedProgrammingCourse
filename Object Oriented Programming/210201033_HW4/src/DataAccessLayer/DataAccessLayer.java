package DataAccessLayer;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import BusinessLayer.Nutrition;
import BusinessLayer.NutritionType;

/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */


public class DataAccessLayer {
	
	public ArrayList<Nutrition> readFile() throws IOException {
		
		
		ArrayList<Nutrition> nutritionList = new ArrayList<Nutrition>();
		
		StringTokenizer tokenizer;
		BufferedReader in = new BufferedReader(new FileReader("files/nutrition.dat"));
		String line;
		
		while ((line = in.readLine()) != null) {
			tokenizer = new StringTokenizer(line, ",");
			
			while(tokenizer.hasMoreTokens()){
				Nutrition nutritionOb = new Nutrition();
				nutritionOb.setName(tokenizer.nextToken().trim());
				nutritionOb.setUnit(Double.parseDouble(tokenizer.nextToken().trim()));
				nutritionOb.setCalorie(Double.parseDouble(tokenizer.nextToken().trim()));
				String token = tokenizer.nextToken().trim();
				if(token.equals("Cereals")) {
					nutritionOb.setType(NutritionType.CEREAL);
				}else if(token.equals("DairyProduct")) {
					nutritionOb.setType(NutritionType.DAIRY_PRODUCT);
				}else if(token.equals("Fruit")) {
					nutritionOb.setType(NutritionType.FRUITS);
				}else if(token.equals("Fish")) {
					nutritionOb.setType(NutritionType.FISH);
				}else if(token.equals("Meat")) {
					nutritionOb.setType(NutritionType.MEATS);
				}else if(token.equals("Vegetable")) {
					nutritionOb.setType(NutritionType.VEGETABLES);
				}
				nutritionOb.setFoodOrDrink(tokenizer.nextToken().trim());
				nutritionList.add(nutritionOb);
			}	
			
		}
		
		return nutritionList;
	}
	
	public boolean writeFile(ArrayList<Nutrition> dailyNutritionList) {
		PrintWriter writer = null;
		
		String fileName =  "files/dailyNutritions.dat";
		try {
		    writer = new PrintWriter(new OutputStreamWriter(
		          new FileOutputStream(fileName)));
		    writer.println("Name, Unit, Calorie, Type, Food/Drink");
		    for(Nutrition n:dailyNutritionList){
		    	writer.println(n.getName()+", "+n.getUnit()+", "+n.getCalorie()+", "+n.getType()+", "+n.getFoodOrDrink()+"; ");
		    }
			writer.close();
			return true;
		} catch (IOException e) {
			System.out.println("There is a problem about writing to text file " + e.getMessage());
			return false;
		} 
	}
		
	}
	
