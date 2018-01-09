package BusinessLayer;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class University {
	private String name;
	private int foundationYear;
	private String country;
	
	public University(String name, int foundationYear, String country) {
		this.name = name;
		this.foundationYear = foundationYear;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFoundationYear() {
		return foundationYear;
	}
	public void setFoundationYear(int foundationYear) {
		this.foundationYear = foundationYear;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
