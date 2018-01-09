package development;

import java.io.IOException;

/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */

public class App {
	static Company companyA;
	static Company companyB;
	static Company companyC;
	
	public static void main(String[] args) throws IOException{
		FileParser file = new FileParser();
		Calculation calculate = new Calculation();
		file.readFile();
		companyA = new Company(0.7 , 0.3 , 0.3);
		companyB = new Company(0.3 , 0.3 , 0.4);
		companyC = new Company(0.2 , 0.2 , 0.6);
		
		System.out.println("For CompanyA " + file.readFile().get(0).getOwner()+"'s insurance cost:  "+calculate.calculate(file.readFile().get(0), companyA));
		System.out.println("For CompanyB " +file.readFile().get(0).getOwner()+"'s insurance cost:  "+calculate.calculate(file.readFile().get(0), companyB));
		System.out.println("For CompanyC " +file.readFile().get(0).getOwner()+"'s insurance cost:  "+calculate.calculate(file.readFile().get(0), companyC));
		System.out.println("For CompanyA " + file.readFile().get(1).getOwner()+"'s insurance cost:  "+calculate.calculate(file.readFile().get(1), companyA));
		System.out.println("For CompanyB " + file.readFile().get(1).getOwner()+"'s insurance cost:  "+calculate.calculate(file.readFile().get(1), companyB));
		System.out.println("For CompanyC " + file.readFile().get(1).getOwner()+"'s insurance cost:  "+calculate.calculate(file.readFile().get(1), companyC));
		System.out.println("For CompanyA " + file.readFile().get(2).getOwner()+"'s insurance cost:  "+calculate.calculate(file.readFile().get(2), companyA));
		System.out.println("For CompanyB " + file.readFile().get(2).getOwner()+"'s insurance cost:  "+calculate.calculate(file.readFile().get(2), companyB));
		System.out.println("For CompanyC " + file.readFile().get(2).getOwner()+"'s insurance cost:  "+calculate.calculate(file.readFile().get(2), companyC));
		
		
		
	}

}
