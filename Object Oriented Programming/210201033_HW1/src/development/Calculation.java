package development;

/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */

public class Calculation {
	
	Company company;
	int age;
	double year_cost;
	double hp_cost;
	double accident_penalty;
	double insurance_cost;
	
	
	public double calculate(Vehicle vehicle, Company company){
		age = (int) (2017 - vehicle.getProducedYear());
			if(vehicle.getType().equals(VehicleType.CAR)){	
				year_cost = 1000 / Math.pow(2, age);
				hp_cost = vehicle.getHorsePower()*10;
				if(age<3){
					accident_penalty = vehicle.getAccidentpenalty()*200;
				}else if(age>=3){
					accident_penalty = vehicle.getAccidentpenalty()*100;
				}	
			}else if(vehicle.getType().equals(VehicleType.BUS)){
				year_cost = 2000 / Math.pow(2, age);
				hp_cost = vehicle.getHorsePower()*10;
				if(age<5){
					accident_penalty = vehicle.getAccidentpenalty()*400;
				}else if(age>=5){
					accident_penalty = vehicle.getAccidentpenalty()*200;
				}
			}else if(vehicle.getType().equals(VehicleType.MOTORCYCLE)){
				year_cost = 500 / Math.pow(2, age);
				hp_cost = vehicle.getHorsePower()*3;
				if(age<1){
					accident_penalty = vehicle.getAccidentpenalty()*100;
				}else if(age>=1){
					accident_penalty = vehicle.getAccidentpenalty()*50;
				}	
			}
			
			insurance_cost = ((company.getWeightX())* year_cost) + ((company.getWeightY()) * hp_cost) + ((company.getWeightZ()) * accident_penalty);
			
			return insurance_cost;
			
		}
		
	}


