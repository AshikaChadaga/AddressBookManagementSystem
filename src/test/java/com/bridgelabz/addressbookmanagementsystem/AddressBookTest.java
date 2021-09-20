package com.bridgelabz.addressbookmanagementsystem;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {
	
	@Test
	public void givenDetails_ShouldAddToContactList() {
		
		ContactPerson person = new ContactPerson();
		Address address = new Address();
		AddressBook addressBook = new AddressBook();
		
		String firstName = "Ashika";
		String lastName = "Satish";
		String email = "ashika@gmail.com";
		long phoneNumber = 938476387;
		String city = "Bangalore";
		String state = "Karnataka";
		long zipCode = 560043;
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setEmail(email);
		person.setPhoneNumber(phoneNumber);
		address.setCity(city);
		address.setState(state);
		address.setZip(zipCode);
		person.setAddress(address);
		
		addressBook.addContact(firstName, person);
		
		firstName = "Sagarika";
		lastName = "Satish";
		email = "sagarika@gmail.com";
		phoneNumber = 847648253;
		city = "Mangalore";
		state = "Karnataka";
		zipCode = 560043;
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setEmail(email);
		person.setPhoneNumber(phoneNumber);
		address.setCity(city);
		address.setState(state);
		address.setZip(zipCode);
		person.setAddress(address);
		
		addressBook.addContact(firstName, person);
		
		int listSize = addressBook.contactList.size();
		Assert.assertEquals(2, listSize);
		
	}
	
	
}
