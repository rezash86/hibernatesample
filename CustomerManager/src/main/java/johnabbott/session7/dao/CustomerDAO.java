package johnabbott.session7.dao;

import java.util.List;

import johnabbott.session7.model.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
	public void addCustomer(Customer c);
}
