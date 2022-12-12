package com.briz.bioneone;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController 
{
@Autowired
CustomerRepository crepo;
@Autowired
AddressRepository arepo;  // must be autowired for all repositories 
@RequestMapping("/test")
public String test()
{
	return "this is test only";
}
@RequestMapping("/insert1")
public String in1()
{
	Customer c=new Customer();
	Address a=new Address();
	
	c.setName("chandesh");
	c.setAge(33);
	
	a.setCity("bokaro");
	a.setCountry("india");
	
	a.setCustomer(c); // bidirectional 	setting customer
	c.setAddress(a);  // bidirectional setting address 
	// both must be set in bidirectional 
	// in unidirectional only one is set 
	
	crepo.save(c);  // insert with customer repository
	return "data inserted";
}
@RequestMapping("/insert2")
public String in2()
{
	Address a=new Address();	
	Customer c=new Customer();

	c.setName("chandani");
	c.setAge(22);
	
	a.setCity("nasik");
	a.setCountry("india");
	
	c.setAddress(a);  // bidirectional ok 
	a.setCustomer(c);  // bidirectional ok 
	
	arepo.save(a);
	return "data inserted successfully";
}
@RequestMapping("/allcustomer")
public List<Customer> allcust()
{
	return crepo.findAll();  // customer repository used here  bidirectional
}
/*
@RequestMapping("/alladdress")
public List<Address> alladd()
{
	return arepo.findAll();  // address repository used here bidirectional
}
*/
@RequestMapping("/by/{id}")
public Optional<Customer> byid(@PathVariable int id)
{
return crepo.findById(id);	// all data of both tables can be accessed bcoz customerrepo
}// IF DELEYEBYID IS USED THEN BOTH TABLE DATA WILL BE DELETED 
@RequestMapping("/find/{city}")
public List<Address> getbycity(@PathVariable String city)
{
	return  arepo.findByCity(city);//  THIS METHOD IS DEFINED IN ADDREPO NOTE BIDIRECT
}
}
