package johnabbott.session7.service;

import java.util.List;

import johnabbott.session7.model.Customer;


public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
	
	public void saveCustomer(Customer cust);
}
