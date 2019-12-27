package johnabbott.session7.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import johnabbott.session7.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {
		return getSession().createQuery("from Customer", Customer.class).list();
	}

	@Override
	public void addCustomer(Customer c) {
		getSession().persist(c);
	}
	
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	public void persist(Customer c) {
		getSession().persist(c);
	}

	public void delete(Customer c) {
		getSession().delete(c);
	}
	
}
