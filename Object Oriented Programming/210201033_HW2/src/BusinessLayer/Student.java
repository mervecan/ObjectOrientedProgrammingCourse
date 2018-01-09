package BusinessLayer;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
import java.util.ArrayList;

public class Student {
	private int id;
	private String name;
	private static ArrayList <University> universityList;
	private static ArrayList <Thesis> thesisList;
	private static ArrayList <Advisor> advisorList;
	private DepartmentName department;
	
	public Student(int id, String name, DepartmentName department) {
		
		this.id = id;
		this.name = name;
		this.department = department;

	}
	
	public Student() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<University> getUniversityList() {
		return universityList;
	}
	public void setUniversityList(ArrayList<University> universityList) {
		Student.universityList = universityList;
	}
	public ArrayList<Thesis> getThesisList() {
		return thesisList;
	}
	public void setThesisList(ArrayList<Thesis> thesisList) {
		Student.thesisList = thesisList;
	}
	public ArrayList<Advisor> getAdvisorList() {
		return advisorList;
	}
	public void setAdvisorList(ArrayList<Advisor> advisorList) {
		Student.advisorList = advisorList;
	}
	public DepartmentName getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentName department) {
		this.department = department;
	}
	
	
	
}
