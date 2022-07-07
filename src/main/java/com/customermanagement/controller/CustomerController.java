package com.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customermanagement.entity.Customer;
import com.customermanagement.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerservice;
	
	@RequestMapping("/list")
	public String listcustomer(Model theModel) {

		System.out.println("request recieved");
		
		List<Customer> customerrelation = customerservice.findAll();

		
		theModel.addAttribute("customers", customerrelation);

		return "customer-form";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		
		Customer customerrelation = new Customer();

		theModel.addAttribute("customer", customerrelation);

		return "customer-list";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		
		Customer customerrelation = customerservice.findById(theId);

		
		theModel.addAttribute("customer", customerrelation);

		
		return "customer-list";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		System.out.println(id);
		Customer customerrelation;
		if (id != 0) {
			customerrelation = customerservice.findById(id);
			customerrelation.setFirstName(firstName);
			customerrelation.setLastName(lastName);
			customerrelation.setEmail(email);
			
		} else
			customerrelation = new Customer(firstName, lastName, email);
	
		customerservice.save(customerrelation);

		
		return "redirect:/customer/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		
		customerservice.deleteById(theId);

	
		return "redirect:/customer/list";

	}
}
