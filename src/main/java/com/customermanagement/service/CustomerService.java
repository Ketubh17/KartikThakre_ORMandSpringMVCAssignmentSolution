package com.customermanagement.service;

import java.util.List;

import com.customermanagement.entity.Customer;

public interface CustomerService
{
	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer customerrelation);

	public void deleteById(int theId);
}
