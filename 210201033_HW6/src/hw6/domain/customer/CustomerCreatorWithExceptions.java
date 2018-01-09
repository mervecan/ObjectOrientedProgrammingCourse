package hw6.domain.customer;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
import hw6.domain.Adult;
import hw6.domain.Customer;
import hw6.domain.CustomerListAnalyticsImpl;
import hw6.domain.ICustomerListAnalytics;
import hw6.domain.Senior;
import hw6.domain.Young;

public class CustomerCreatorWithExceptions {
	Customer customer;
	ICustomerListAnalytics customerListAnalytics = new CustomerListAnalyticsImpl();
	public Customer createCustomer(int age, char gender, String name) {
		if(age<18 || age>79) 
			throw new IllegalArgumentException("Invalid Age Parameter");
		if((gender != 'f')&&(gender != 'M')&&(gender != 'F')&&(gender != 'm'))
			throw new IllegalArgumentException("Invalid Gender Parameter");
		if(name==null || name.length()>20) 
			throw new IllegalArgumentException("Invalid Name Parameter! Name can not be null or longer than 20 char");
		else {
			if(age>=60) {
				customer = new Senior();
				customer.setAge(age);
				customer.setGender(gender);
				customer.setName(name);
				customer.setType("Senior");
			}else if(age>=30 && age<=59) {
				customer = new Adult();
				customer.setAge(age);
				customer.setGender(gender);
				customer.setName(name);
				customer.setType("Adult");
			}else if(age>=18 && age<=29) {
				customer = new Young();
				customer.setAge(age);
				customer.setGender(gender);
				customer.setName(name);
				customer.setType("Young");
			}
			customerListAnalytics.add(customer);
			
		}
		
		return customer;
	}

	

}
