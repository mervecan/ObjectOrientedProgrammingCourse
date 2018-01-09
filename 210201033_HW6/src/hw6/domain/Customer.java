package hw6.domain;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class Customer {
	
	private int age;
	private char gender;
	private String name;
	private String type;
	
	public Customer() {
		
	}
	
	public Customer(int age, char gender, String name) {
		super();
		this.age = age;
		this.gender = gender;
		this.name = name;
	}



	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return getType()+" [super=Customer [age=" + getAge() + ", gender=" + getGender() + ", name=" + getName() + ", type=" + getType() + "]]";
	}
	
	
	

}
