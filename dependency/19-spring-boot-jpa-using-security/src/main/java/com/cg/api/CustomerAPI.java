package com.cg.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.EmailUpdateDto;
import com.cg.entity.Customer;
import com.cg.service.CustomerService;
	@RestController
	@RequestMapping("/customers")
	public class CustomerAPI {
		@Autowired
		CustomerService service;
		
	//add customers	
	@PostMapping(produces = {"application/json","application/xml"},consumes =  {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Customer> addCustomer( @RequestBody Customer c) {
	System.out.println("l");
			return new ResponseEntity<Customer> (service.addCustomerService(c),HttpStatus.OK);
	}
	
	
	//update customers 
//	@PutMapping(value = "/{custId}",  produces = {"application/json","application/xml"},consumes =  {"application/json","application/xml"})
//	@PreAuthorize("hasAuthority('Admin')")
//	public ResponseEntity<Customer> updateCustomer(@PathVariable int custId,@RequestBody Customer c) {
//	 Customer cust = service.updateCustomerService(custId, c);
//	 return new ResponseEntity<Customer>(cust, HttpStatus.OK);
//	}
	
	
	//read all customers //Success
	@GetMapping(produces = {"application/json","application/xml"},consumes =  {"application/json","application/xml"})
	public ResponseEntity<List<Customer>> readAllCustomers() {
	
		return new ResponseEntity<List<Customer>>(service.readAllCustomersService(),HttpStatus.OK);
	}
	
	
	//get customer by id //Success
	@GetMapping(value = "/{custId}",  produces = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("custId")  int cid) {
		return new ResponseEntity<Customer>(service.getCustomerByIdService(cid),HttpStatus.OK);
	}
	
	
	
	//remove customer by id //Success
	@DeleteMapping(value = "/{custId}",  produces = {"application/json","application/xml"})
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("custId") int cid) {
		System.out.println("Entered");
		return new ResponseEntity<Customer>(service.removeCustomerService(cid), HttpStatus.OK);
	}

	//update email
	@PutMapping
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Customer> updateEmail(@RequestBody EmailUpdateDto e) {
		Customer cust =  service.updateEmailService(e.getCid(), e.getNewEmail());
		System.out.println(e.getNewEmail()+" "+e.getCid());
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		
	}
	//Get customer by city //Success
	@GetMapping(value="/search/customerType", produces="application/json")
	public ResponseEntity<List<Customer>> searchByCustomerType(@RequestParam("ctype") String ctype){
		System.out.println("Hello");
		List<Customer> custlist = service.searchByType(ctype);
		return new ResponseEntity<List<Customer>>(custlist,HttpStatus.OK); 
	}
	
	@GetMapping(value = "/search",  produces = {"application/json","application/xml"})
	public ResponseEntity<List<Customer>> readAllCustomersServiceCity(@RequestParam ("cname") String name){
		return null;
	
	}
}