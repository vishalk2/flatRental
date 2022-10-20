package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_data")
public class Customer {
	@Id
	@GeneratedValue
private int custId;
private String custName;
private String email;
private String customerType;
private String address;

public Customer() {
	// TODO Auto-generated constructor stub
}

public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCustomerType() {
	return customerType;
}
public void setCustomerType(String customerType) {
	this.customerType = customerType;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
}