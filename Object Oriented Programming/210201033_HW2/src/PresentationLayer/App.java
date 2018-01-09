package PresentationLayer;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
import java.util.Scanner;
import BusinessLayer.Menu;
import DataAccessLayer.DataAccessLayer;

public class App {
	
	static DataAccessLayer dal ;
	
	
	 public static void main(String[] args) {
		 dal = new DataAccessLayer();
		 dal.readFile();
		 Menu menu=new Menu();
		 do {
				System.out.println("1. List all theses by department and university:");
				System.out.println("2. List all academicians that are both advisor and student:");
				System.out.println("3. List all theses in chronological order by advisor:");
				System.out.println("4. Find the country that has the most number of published theses:");
				System.out.println("5. List all universities by advisor:");

				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);

				String choice = input.next();

				switch (choice) {
				case "1":
					System.out.print("Enter department name:");
					Scanner deptInput = new Scanner(System.in);
					String deptName = deptInput.nextLine();
					System.out.print("Enter university name:");
					Scanner uniInput = new Scanner(System.in);
					String uniName= uniInput.nextLine();
					menu.listThesisByDeptUni(deptName, uniName);
					break;
				case "2":
					menu.listAcademicians();
					break;
				case "3":
					System.out.print("Enter advisor name:");
					Scanner advisorInput = new Scanner(System.in);
					String advisorName = advisorInput.nextLine();
					menu.listThesisChronological(advisorName);
					break;
				case "4":
					menu.findCountry();
					break;
				case "5":
					System.out.print("Enter advisor name:");
					Scanner advisorInput2 = new Scanner(System.in);
					String advisorName2 = advisorInput2.nextLine();
					menu.listUniversity(advisorName2);
					break;
				default:
					System.out.println("Invalid menu option");
				}
					
				
			} while (true);
	 }
	
}
