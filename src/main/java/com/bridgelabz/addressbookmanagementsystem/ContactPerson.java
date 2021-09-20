package com.bridgelabz.addressbookmanagementsystem;

import com.opencsv.bean.CsvBindByName;

public class ContactPerson {
	
	@CsvBindByName(column = "First Name")
	private String firstName;
	
	@CsvBindByName(column = "Last Name")
	private String lastName;
	
	@CsvBindByName(column = "Email")
	private String email;
	
	@CsvBindByName(column = "Phone Number")
	private long phoneNumber;
	
	@CsvBindByName(column = "City")
	private String city;
	
	@CsvBindByName(column = "State")
	private String state;
	
	@CsvBindByName(column = "Zip Code")
	private long zip;
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public long getZip() {
		return zip;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZip(long zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		
		return "First Name - "+firstName+", Last Name - "+lastName+", Phone Number - "+phoneNumber+", Email - "+email+", City - "+city+", State - "+state+", Zip Code - "+zip;
	}
}
