package BusinessLayer;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Menu {
	
	Advisor advisor = new Advisor();
	Student student = new Student();
	
	public void listThesisByDeptUni(String deptName, String uniName) {
	 for(int i=0;i<advisor.getStudentList().size();i++) {
		if(deptName.equals("MATHEMATICS") || deptName.equals("mathematics")) {
			if((advisor.getStudentList().get(i).getDepartment().equals(DepartmentName.MATH))
						&& (advisor.getStudentList().get(i).getUniversityList().get(i).getName().equals(uniName))){
				System.out.println(advisor.getStudentList().get(i).getThesisList().get(i).getName());
				}
			}else if((advisor.getStudentList().get(i).getDepartment().equals(DepartmentName.valueOf(deptName.toUpperCase())))
					&& (advisor.getStudentList().get(i).getUniversityList().get(i).getName().equals(uniName))){
				System.out.println(advisor.getStudentList().get(i).getThesisList().get(i).getName());
			}
		}
	}
	
	public void listAcademicians() {
		for(int i=0;i<student.getAdvisorList().size();i++) {
			for(int j=0;j<advisor.getStudentList().size();j++) {
				if(student.getAdvisorList().get(i).getName().equals(advisor.getStudentList().get(j).getName())) {
					System.out.println(student.getAdvisorList().get(i).getName());
				}
			}
		}
	}
	
	public void listThesisChronological(String advisorName) {
		ArrayList<Thesis> chronologicaThesis=new ArrayList<>();
		  for(int i=0;i<advisor.getStudentList().size();i++) {
			  if(advisor.getStudentList().get(i).getAdvisorList().get(i).getName().equals(advisorName)){
				  chronologicaThesis.add(student.getThesisList().get(i));
			  }
			
		  Collections.sort(chronologicaThesis,new Comparator<Thesis>() {
			@Override
			public int compare(Thesis o1, Thesis o2) {
				// TODO Auto-generated method stub
				return o1.getPublishedYear()-o2.getPublishedYear();
			}
			   
		});
		 }
		  for (int j = 0; j < chronologicaThesis.size(); j++) {
				System.out.println(chronologicaThesis.get(j).getName());
			}
	}
	
	public void findCountry() {	
		int germany =0;
		int france = 0;
		int america = 0;
		int russia =0;
		int austria = 0;
		int italy = 0;
		for(int i=0;i<student.getUniversityList().size();i++) {
			if(advisor.getStudentList().get(i).getUniversityList().get(i).getCountry().equals("Germany")) {
				germany++;
			}else if(advisor.getStudentList().get(i).getUniversityList().get(i).getCountry().equals("France")) {
				france++;
			}else if(advisor.getStudentList().get(i).getUniversityList().get(i).getCountry().equals("United States of America")) {
				america++;
			}else if(advisor.getStudentList().get(i).getUniversityList().get(i).getCountry().equals("Russia")) {
				russia++;
			}else if(advisor.getStudentList().get(i).getUniversityList().get(i).getCountry().equals("Austria")) {
				austria++;
			}else if(advisor.getStudentList().get(i).getUniversityList().get(i).getCountry().equals("Italy")) {
				italy++;
			}
		}
			int largest=Collections.max(Arrays.asList(germany,france,america,russia,austria,italy));
			if(largest == germany) {
				System.out.println("Most number of published in Germany");
			}else if(largest==france) {
				System.out.println("Most number of published in France");
			}else if(largest==america) {
				System.out.println("Most number of published in United States America");
			}else if(largest==russia) {
				System.out.println("Most number of published in Russia");
			}else if(largest==austria) {
				System.out.println("Most number of published in Austria");
			}else if(largest==italy) {
				System.out.println("Most number of published in Italy");
			}

	}
	
	public void listUniversity(String advisorName) {
		for(int i=0;i<advisor.getStudentList().size();i++) {
			if(advisor.getStudentList().get(i).getAdvisorList().get(i).getName().equals(advisorName)) {
				System.out.println(advisor.getStudentList().get(i).getUniversityList().get(i).getName());
			}
		}
	}

}
