package DataAccessLayer;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import BusinessLayer.Advisor;
import BusinessLayer.DepartmentName;
import BusinessLayer.Student;
import BusinessLayer.Thesis;
import BusinessLayer.University;


public class DataAccessLayer {
	private ArrayList<Student> studentList;
	private  ArrayList<Advisor> advisorList;
	private ArrayList<Thesis> thesisList;
	private ArrayList<University> universityList;
	
	public DataAccessLayer(){
		studentList=new ArrayList<Student>();
		advisorList=new ArrayList<Advisor>();
		thesisList=new ArrayList<Thesis>();
		universityList=new ArrayList<University>();
	}
	public void readFile() {
		
	try {
	File xmlFile = new File("files\\genealogy.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(xmlFile);
	
	NodeList advisorNodeList=doc.getElementsByTagName("Advisor");
	for(int i=0;i<advisorNodeList.getLength();i++) {
		    
		    Element advisorElement=(Element) advisorNodeList.item(i);
		    String advisorName=advisorNodeList.item(i).getAttributes().getNamedItem("name").getNodeValue();
		    
		    
	        NodeList studentNodeList=advisorElement.getElementsByTagName("Student");
	        Element studentElement=(Element)studentNodeList.item(0);
	        
	        	 String studentName=studentElement.getAttribute("name");
	  		   
	 	        int studentID=Integer.parseInt(studentElement.getAttribute("id"));
	 	       
	 		    
	 	
	 	    	NodeList thesisNodeList=studentElement.getElementsByTagName("Thesis");
	 	    	Element thesisElement=(Element)thesisNodeList.item(0);
	 	    	String thesisName = thesisElement.getAttribute("name");
	 	    	int thesisYear = Integer.parseInt(thesisElement.getAttribute("year"));
	 	    	
	 	    	
	 	    	NodeList universityNodeList=studentElement.getElementsByTagName("University");
	 	    	Element universityElement=(Element)universityNodeList.item(0);
	 	    	String universityName = universityElement.getAttribute("name");
	 	    	int foundedYear = Integer.parseInt(universityElement.getAttribute("foundedYear"));
	 	    	String country = universityElement.getAttribute("country");
	 	   
	 	    	
	 	    	NodeList departmenNodeList=studentElement.getElementsByTagName("Department");
	 	    	Element departmentElement=(Element)departmenNodeList.item(0);
	 	    	DepartmentName studentDepartment;
	 	    	if(departmentElement.getAttribute("name").equals("MATHEMATICS")) {
	 	    		studentDepartment=DepartmentName.MATH;
	 	    	}else {
	 	    		studentDepartment=DepartmentName.valueOf(departmentElement.getAttribute("name"));
	 	    	}
	 	    	
	 	    	Student student=new Student(studentID,studentName,studentDepartment);
		    	Thesis thesis = new Thesis(thesisName,student,thesisYear);
		    	University university = new University(universityName,foundedYear, country);
		    	
		    	studentList.add(student);
			    thesisList.add(thesis);
			    universityList.add(university);
			    student.setThesisList(thesisList);
			    student.setUniversityList(universityList);		    
			    student.setAdvisorList(advisorList);
			    
			   //System.out.println("country1"+universityList.size());
	        
	       
	   
		    
           /*//ekrana basýyoruz parse edilenleri
	    	System.out.println(advisorElement.getAttribute("name"));
	    	System.out.println(studentElement.getAttribute("name"));
	    	System.out.println(studentElement.getAttribute("id"));
	    	System.out.println(thesisElement.getAttribute("name"));
	    	System.out.println(thesisElement.getAttribute("year"));
	    	System.out.println(universityElement.getAttribute("name"));
	    	System.out.println(universityElement.getAttribute("foundedYear"));
	    	System.out.println(universityElement.getAttribute("country"));
	    	System.out.println(departmentElement.getAttribute("name"));
	    	System.out.println("------------");*/
	    	
	    	Advisor advisor=new Advisor(advisorName);
	    	advisorList.add(advisor);
		    advisor.setStudentList(studentList);
		    
	}
}
	
     catch (Exception e) {
		e.printStackTrace();
	    }
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	public ArrayList<Advisor> getAdvisorList() {
		return advisorList;
	}
	public void setAdvisorList(ArrayList<Advisor> advisorList) {
		this.advisorList = advisorList;
	}
	public ArrayList<Thesis> getThesisList() {
		return thesisList;
	}
	public void setThesisList(ArrayList<Thesis> thesisList) {
		this.thesisList = thesisList;
	}
	public ArrayList<University> getUniversityList() {
		return universityList;
	}
	public void setUniversityList(ArrayList<University> universityList) {
		this.universityList = universityList;
	}
	
	
}