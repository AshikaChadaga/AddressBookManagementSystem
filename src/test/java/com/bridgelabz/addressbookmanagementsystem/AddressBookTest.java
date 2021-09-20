package com.bridgelabz.addressbookmanagementsystem;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddressBookTest {
	

	static AddressBook addressBook = new AddressBook();
	
	@BeforeClass
	public static void createAddressBookObject() {
		addressBook.setAddressBookName("book1");
	}
	
	@Test
	public void givenDetails_ShouldAddToContactList() {
		
		ContactPerson person = new ContactPerson();
		
		
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
		person.setCity(city);
		person.setState(state);
		person.setZip(zipCode);
		
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
		person.setCity(city);
		person.setState(state);
		person.setZip(zipCode);
		
		addressBook.addContact(firstName, person);
		
		int listSize = addressBook.contactList.size();
		Assert.assertEquals(2, listSize);
		
	}
	
	@Test
	public void given2Contacts_WhenWrittenToFile_ShouldMatchEntries()
	{
		AddressBookFileIO addressFileIO = new AddressBookFileIO();
		addressFileIO.writeToAddressBookFile("book1.txt", addressBook.contactList);
		addressFileIO.printData("book1.txt");
		long entries = addressFileIO.countEntries("book1.txt");
		Assert.assertEquals(2, entries);
		
	}
	
	@Test
	public void givenFile_WhenRead_ShouldReturnNumberOfEntries() {
		
		AddressBookFileIO addressFileIO = new AddressBookFileIO();
		List<String> entries = addressFileIO.readDataFromFile("book1.txt");
		long countEntries = entries.size();
		Assert.assertEquals(2, countEntries);
	}
	
	
}
