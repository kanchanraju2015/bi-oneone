package com.briz.bioneone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="address")
public class Address //implements Serializable 
{	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
// immediate below the @Id annotation id must be defined 
int id;
String city;
String country;
@JsonIgnore // must be for non-repeating output for client 
// jsonignore annotation must be used into FK 
// here customerrepo is used in controller so address is fk
// i.e by customerrepo we can access all data of both tables in json format  
// if addressrepo is used then json wil be used into the customer entity
@OneToOne //  (cascade=CascadeType.ALL,mappedBy="address",fetch = FetchType.LAZY)
// mappedby is used in FK always note this 
// automatically creates extra column with customer_id
Customer customer;  // must be present for bidirectional mapping 

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
}
