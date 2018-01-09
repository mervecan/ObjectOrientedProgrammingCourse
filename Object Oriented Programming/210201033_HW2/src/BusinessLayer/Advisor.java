package BusinessLayer;

/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */

import java.util.ArrayList;

import DataAccessLayer.DataAccessLayer;

public class Advisor {
	private String name;
	private static ArrayList <Student> studentList =  new ArrayList<Student>();
	DataAccessLayer dal = new DataAccessLayer();
	
	public Advisor(String name) {
		this.name = name;
	}
	
	public Advisor() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		Advisor.studentList = studentList;
		
	}
	
	
	
}
