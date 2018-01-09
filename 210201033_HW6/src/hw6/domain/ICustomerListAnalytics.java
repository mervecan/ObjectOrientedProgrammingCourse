package hw6.domain;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public interface ICustomerListAnalytics {

	boolean add(Customer customer);
	
	double getNumberOfSeniorCustomers();

	double getNumberOfMaleCustomers();

	double getNumberOfAdultCustomers();

	double getNumberOfYoungCustomers();
	
	double getNumberOfFemaleCustomers();

	
}
