package development;

/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */

public class Company {
	private double weightX;
	private double weightY;
	private double weightZ;
	
	
	public Company(double weightX, double weightY, double weightZ){
	     setWeightX(weightX);
	     setWeightY(weightY);
	     setWeightZ(weightZ);
	     
	}
	public Company(){
		
	}
	public double getWeightX() {
		return weightX;
	}
	public void setWeightX(double weightX) {
		if(weightX <= 0.0){
			this.weightX = 1.0;
		}else{
			this.weightX = weightX;
		}
		
	}
	public double getWeightY() {
		return weightY;
	}
	public void setWeightY(double weightY) {
		if(weightY <= 0.0){
			this.weightY = 1.0;
		}else{
		this.weightY = weightY;
		}
	}
	public double getWeightZ() {
		return weightZ;
	}
	public void setWeightZ(double weightZ) {
		if(weightZ <= 0.0){
			this.weightZ = 1.0;
		}else{
		this.weightZ = weightZ;
		}
	}
	@Override
	public String toString() {
		return "Company [weightX=" + weightX + ", weightY=" + weightY + ", weightZ=" + weightZ + "]";
	}
	
	
	
	
	
}
