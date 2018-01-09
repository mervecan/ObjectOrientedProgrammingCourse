package hw6.domain;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
import java.util.List;

import hw6.domain.customer.CustomerCreatorWithExceptions;

import java.util.ArrayList;

public class CustomerListAnalyticsImpl implements ICustomerListAnalytics{
	
	//CustomerCreatorWithExceptions customerCreator = new CustomerCreatorWithExceptions();
	List<Customer> customerList = new ArrayList<Customer>();
	
	
	@Override
	public boolean add(Customer customer) {
		// TODO Auto-generated method stub
		if(customer==null) {
			return false;
		}else {
			customerList.add(customer);
			return true;
		}
	}

	@Override
	public double getNumberOfSeniorCustomers() {
		int count=0;
		for(Customer c : customerList ) {
			if(c.getType().equals("Senior")) {
				count++;
			}
		}
		return count;
	}
	
	@Override
	public double getNumberOfAdultCustomers() {
		int count=0;
		for(Customer c : customerList ) {
			if(c.getType().equals("Adult")) {
				count++;
			}
		}
		return count;
	}

	@Override
	public double getNumberOfYoungCustomers() {
		int count=0;
		for(Customer c : customerList ) {
			if(c.getType().equals("Young")) {
				count++;
			}
		}
		return count;
	}
	@Override
	public double getNumberOfMaleCustomers() {
		int count=0;
		for(Customer c : customerList) {
			if(c.getGender()=='m'|| c.getGender()=='M') {
				count++;
			}
		}
		return count;
	}

	@Override
	public double getNumberOfFemaleCustomers() {
		int count=0;
		for(Customer c : customerList) {
			if(c.getGender()=='f') {
				count++;
			}else if(c.getGender()=='F') {
				count++;
			}
		}
		return count;
	}

	@Override
	public String toString() {
		return "CustomerListImpl [buyers=[" + customerList.toString() + "]";
	}


	

}
