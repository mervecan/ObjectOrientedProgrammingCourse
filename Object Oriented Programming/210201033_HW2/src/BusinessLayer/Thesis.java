package BusinessLayer;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
import java.util.ArrayList;

public class Thesis {
	
	private String name;
	private Student student;
	private int publishedYear;
	private static ArrayList<Advisor> advisorList;
	private static ArrayList<University> universityList;
	
	
	
	public Thesis(String name, Student student, int publishedYear) {
		this.name = name;
		this.student = student;
		this.publishedYear = publishedYear;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public ArrayList<University> getUniversityList() {
		return universityList;
	}
	public void setUniversityList(ArrayList<University> universityList) {
		Thesis.universityList = universityList;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	public ArrayList<Advisor> getAdvisorList() {
		return advisorList;
	}


	public void setAdvisorList(ArrayList<Advisor> advisorList) {
		Thesis.advisorList = advisorList;
	}
		

}
