package com.cg.service;

import java.util.List;

import com.cg.entity.Customer;

public interface CustomerService {
	public Customer addCustomerService(Customer c);
	
	public Customer updateCustomerService( int custId,Customer c) ;
	
	public List<Customer> readAllCustomersService();

	public Customer getCustomerByIdService( int cid);
	
	public Customer removeCustomerService(int cid); 
	
	public Customer updateEmailService(int custId,String newEmail);

	public List<Customer> readAllCustomersServiceByCity(String name);

	public List<Customer> searchByType(String ctype);
}