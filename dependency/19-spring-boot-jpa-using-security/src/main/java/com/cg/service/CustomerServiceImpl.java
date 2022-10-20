package com.cg.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Customer;
import com.cg.repository.CustomerRepository;
@Component
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public Customer addCustomerService(Customer c) {
		Customer cust=customerRepository.save(c);
		return cust;
	}
	@Override
	public Customer updateCustomerService(int custId, Customer c) {
//		System.out.println(c.getAddress());
//		int c1 = customerRepository.updateCustomer(custId, c);
//		if(c1>0) {
//			Customer c2 = getCustomerByIdService(custId);
//			return c2;
//		}
		return null;
	}

	@Override
	public List<Customer> readAllCustomersService() {
		List<Customer> custList= new ArrayList<>();
		Iterable<Customer> customers= customerRepository.findAll();
		customers.forEach(c->custList.add(c));
		return custList;
	}

	@Override
	public Customer getCustomerByIdService(int cid) {
		Optional<Customer> c = customerRepository.findById(cid);
		if(c.isPresent()) {
			Customer c1 = c.get();
			return c1;
		}
		else {
			System.out.println("Movie code not found");
			return null;
		}
	}

	@Override
	public Customer removeCustomerService(int cid) {
		
		// TODO Auto-generated method stub
		if(getCustomerByIdService(cid)!=null) {
			Customer c1 = getCustomerByIdService(cid);
			customerRepository.deleteById(cid);
			return c1;
		}
		else {
			return null;
		}
	}

	@Override
	@Transactional
	public Customer updateEmailService(int custId, String newEmail) {
		int c = customerRepository.upadteEmail(custId, newEmail);
		System.out.println(c+" "+custId);
		if(c>0) {
			Customer c1 = getCustomerByIdService(custId);
			System.out.println(c+" "+custId+" "+c1.getEmail());
			return c1;
		}
		else
		return null;
	}
	@Override
	public List<Customer> readAllCustomersServiceByCity(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Customer> searchByType(String ctype) {
		System.out.println("from ctype");
		return customerRepository.findByCustomerType(ctype);
	}

}