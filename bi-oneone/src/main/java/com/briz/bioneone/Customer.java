package com.briz.bioneone;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="customer")
public class Customer //implements Serializable
{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	int id;
	String name;
	int age;
	//@JsonIgnore cannot use this annotation 
	// because repo of customer is used in controller 
	@OneToOne(cascade=CascadeType.ALL) // must be with pk
	//@JoinColumn(name="address_id")
	// if we donot use joincolumn then it will create extra column i.e address_id
	// secondary table must be below the annotation i.e onetoone etc imp
	Address address; // this must be below the onetoone annotation 
	// mapping to the another table i.e FK as target 
	public int getId() 
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) 
	{
		this.address = address;
	}	
}
