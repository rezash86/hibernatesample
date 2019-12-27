package johnabbott.session7.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import johnabbott.session7.dao.CustomerDAO;
import johnabbott.session7.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		//List<Customer> customerList = new ArrayList<Customer>();
		
//		customerList.add(new Customer(1, "toto1", "1111111", "add1"));
//		customerList.add(new Customer(2, "toto2", "2222222", "add2"));
//		customerList.add(new Customer(3, "toto3", "3333333", "add3"));
//		customerList.add(new Customer(4, "toto4", "4444444", "add4"));
			
		return customerDao.getCustomers();
	}

	@Override
	public Customer getCustomer(int id) {
		return getCustomers().get(id-1);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer cust) {
		customerDao.addCustomer(cust);
		
	}

}
