package johnabbott.session7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import johnabbott.session7.model.Customer;
import johnabbott.session7.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@RequestMapping("/customer")
	public ModelAndView getCustomers() {
		ModelAndView mav = new ModelAndView("list-customer");
		List<Customer> customers = service.getCustomers();
		mav.addObject("customers", customers);
		return mav;
	}
	
	
	@RequestMapping("/add")
	public ModelAndView addCustomers() {
		service.saveCustomer(new Customer("reza", "email1", "add1"));
		ModelAndView mav = new ModelAndView("list-customer");
		List<Customer> customers = service.getCustomers();
		mav.addObject("customers", customers);
		return mav;
	}
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("list-customer");
		List<Customer> customers = service.getCustomers();
		mav.addObject("customers", customers);
		return mav;
	}
	
	@RequestMapping("/update")
	public ModelAndView editCustomerForm(@RequestParam int id) {
		System.out.println("I am editing id= " + id);
		ModelAndView mav = new ModelAndView("edit-customer");
		Customer customer = service.getCustomer(id);
		mav.addObject("customer", customer);
		return mav;
	}
	
	@RequestMapping(value = "/savecustomer", method = RequestMethod.GET)
	public String saveCustomerRedirect(@ModelAttribute("customer") Customer customer) {
		 return "save-customer";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		service.saveCustomer(customer);
		return "redirect:/customer";
	}
}
