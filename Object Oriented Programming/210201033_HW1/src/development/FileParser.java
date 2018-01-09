package development;

/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FileParser {
	
	private ArrayList <Vehicle> vehicleList;
	Vehicle vehicleObject;
	
	public FileParser(){
		vehicleList = new ArrayList<>();
		
	}
	
	
	public ArrayList<Vehicle> getVehicleList() {
		return vehicleList;
	}



	public void setVehicleList(ArrayList<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}



	@SuppressWarnings("resource")
	public ArrayList<Vehicle> readFile() throws IOException{
		StringTokenizer tokenizer;
		BufferedReader in = new BufferedReader(new FileReader("files/vehicles.dat"));
		String line;
		
		while ((line = in.readLine()) != null) {
			tokenizer = new StringTokenizer(line, ",");
			
			while(tokenizer.hasMoreTokens()){
				vehicleObject = new Vehicle();
				vehicleObject.setOwner(tokenizer.nextToken().trim());
				vehicleObject.setBrand(tokenizer.nextToken().trim());
				vehicleObject.setProducedYear(Integer.parseInt(tokenizer.nextToken().trim()));
				vehicleObject.setHorsePower(Integer.parseInt(tokenizer.nextToken().trim()));
				vehicleObject.setAccidentpenalty(Double.parseDouble(tokenizer.nextToken().trim()));
				vehicleObject.setType(VehicleType.valueOf(tokenizer.nextToken().trim().toUpperCase()));
				vehicleList.add(vehicleObject);
				
			}
		}
		return vehicleList;
	}
}
