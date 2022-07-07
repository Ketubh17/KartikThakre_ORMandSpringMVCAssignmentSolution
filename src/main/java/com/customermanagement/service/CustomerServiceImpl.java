package com.customermanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customermanagement.entity.Customer;



@Repository
public class CustomerServiceImpl implements CustomerService
{

	private SessionFactory sessionFactory;

	
	private Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<Customer> findAll() {

		Transaction tx = session.beginTransaction();

		
		List<Customer> customerrelation = session.createQuery("from Customer").list();

		tx.commit();

		return  customerrelation;
	}

	@Transactional
	public void save(Customer customerrelation) {

		Transaction tx = session.beginTransaction();

	
		session.saveOrUpdate(customerrelation);

		tx.commit();

	}
	
	@Transactional
	public void deleteById(int id) {

		Transaction tx = session.beginTransaction();

	
		Customer customerrelation = session.get(Customer.class, id);

	
		session.delete(customerrelation);

		tx.commit();

	}
	@Transactional
	public Customer findById(int id) {

		Customer customerrelation = new Customer();

		Transaction tx = session.beginTransaction();

		
		customerrelation = session.get(Customer.class, id);

		tx.commit();

		return customerrelation;
	}
	
}
