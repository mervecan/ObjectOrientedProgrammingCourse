package development;

/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */

public class Vehicle {
	private String owner;
	private String brand;
	private double producedYear;
	private int horsePower;
	private double accidentpenalty;
	private VehicleType type;
	
	public Vehicle(String owner, String brand, double producedYear, int horsePower, double accidentpenalty, VehicleType type){
		setOwner(owner);
		setBrand(brand);
		setProducedYear(producedYear);
		setHorsePower(horsePower);
		setAccidentpenalty(accidentpenalty);
		setType(type);
	}
	
	public Vehicle(){
		
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		if(owner == null){
			this.owner = "NO NAME GIVEN";
		}else{
		this.owner = owner;}
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		if(brand == null){
			this.brand = "NO BRAND GIVEN";
		}else{
			this.brand = brand;
		}
	}
	
	public double getProducedYear() {
		return producedYear;
	}
	
	public void setProducedYear(double producedYear) {
		if(producedYear <= 0){
			this.producedYear=2017.0;
		}else{
			this.producedYear = producedYear;
		}
	}
	
	public int getHorsePower() {
		return horsePower;	
	}
	
	public void setHorsePower(int horsePower) {
		if(horsePower < 0 ){  //-10
			this.horsePower = 0;
		}else{
			this.horsePower = horsePower;
		}
	}
	
	public double getAccidentpenalty() {
		return accidentpenalty;
	}
	
	public void setAccidentpenalty(double accidentpenalty) {
		if(accidentpenalty < 0){
			this.accidentpenalty = 1.0;
		}else{
			this.accidentpenalty = accidentpenalty;
		}
	}
	
	public VehicleType getType() {
		return type;
	}
	
	public void setType(VehicleType type) {
		if(type == null){
			this.type = VehicleType.CAR;
		}else{
			this.type = type;
		}
	}

	@Override
	public String toString() {
		return "Vehicle [owner=" + owner + ", brand=" + brand + ", producedyear=" + producedYear + ", housepower="
				+ horsePower + ", accidentpenalty=" + accidentpenalty + ", type=" + type + "]";
	}
	

	
}
