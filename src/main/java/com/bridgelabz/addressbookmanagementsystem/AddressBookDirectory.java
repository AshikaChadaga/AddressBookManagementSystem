package com.bridgelabz.addressbookmanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookDirectory {
	
	public AddressBook addressBook;
	Scanner scannerObject = new Scanner(System.in);
	Map<String,AddressBook> addressBookDirectory = new HashMap<String,AddressBook>();
	

	public void operationDirectory() {

		boolean moreChanges = true;
		do {

			System.out.println("\nChoose the operation on the Directory you want to perform");
			System.out.println(
					"1.Add an Address Book\n2.Edit Existing Address Book\n3.Search Person By Region\n4.View People By Region\n5.Count People By Region\n6.Display Address book Directory\n7.Exit Address book System");

			switch (scannerObject.nextInt()) {
			case 1:
				addAddressBook();
				break;
			case 2:
				editAddressBook();
				break;
			case 3:
				System.out.println("Enter \n1.Search By City\n2.Search By State");
				int searChoice = scannerObject.nextInt();
				if(searChoice==1)
					searchByCity();
				else 
					searchByState();
				break;
			case 4:
				System.out.println("Enter \n1.Display By City\n2.Display By State");
				int displayChoice = scannerObject.nextInt();
				if(displayChoice==1)
					displayPeopleByRegion(AddressBook.personByCity);
				else 
					displayPeopleByRegion(AddressBook.personByState);
				break;
			case 5:
				System.out.println("Enter \n1.Display By City\n2.Display By State");
				int countChoice = scannerObject.nextInt();
				if(countChoice==1)
					countPeopleByRegion(AddressBook.personByCity);
				else 
					countPeopleByRegion(AddressBook.personByState);
				break;
			case 6:
				displayDirectoryContents();
				break;
			case 7:
				moreChanges = false;
				System.out.println("Exiting Address Book Directory !");
			}

		} while (moreChanges);
	}

	public void addAddressBook() {

		System.out.println("Enter the name of the Address Book you want to add");
		String bookNameToAdd = scannerObject.next();

		if(addressBookDirectory.containsKey(bookNameToAdd)) {
			System.out.println("Book Name Already Exists");
			return;
		}
		AddressBook addressBook = new AddressBook();
		addressBook.setAddressBookName(bookNameToAdd);
		addressBookDirectory.put(bookNameToAdd, addressBook);

	}

	public void editAddressBook() {

		System.out.println("Enter the Name of the Address Book which you want to edit:");
		String addressBookToEdit = scannerObject.next();

		if(addressBookDirectory.containsKey(addressBookToEdit)) {
			addressBook = addressBookDirectory.get(addressBookToEdit);
			addressBook.operation();
		}
		else {
			System.out.println("Book Does Not Exist");
		}

	}
	
	public void searchByCity() {
		
		System.out.println("Enter the name of the City where the Person resides : ");
		String cityName = scannerObject.next();
		System.out.println("Enter the name of the Person : ");
		String personName = scannerObject.next();
		
		for(AddressBook addressBook : addressBookDirectory.values()) {
			ArrayList<ContactPerson> contactList = addressBook.getContact();
			contactList.stream()
				.filter(person -> person.getFirstName().equals(personName) && person.getAddress().getCity().equals(cityName))
				.forEach(person -> System.out.println(person));
			
		}		
	}
	
	public void searchByState() {
		
		System.out.println("Enter the name of the State where the Person resides : ");
		String stateName = scannerObject.next();
		System.out.println("Enter the name of the Person : ");
		String personName = scannerObject.next();
		
		for(AddressBook addressBook : addressBookDirectory.values()) {
			ArrayList<ContactPerson> contactList = ((AddressBook) addressBook).getContact();
			contactList.stream()
				.filter(person -> person.getFirstName().equals(personName) && person.getAddress().getState().equals(stateName))
				.forEach(person -> System.out.println(person));
			
		}

	}
	
	public void displayPeopleByRegion(HashMap<String, ArrayList<ContactPerson>> listToDisplay) {

		System.out.println("Enter the name of the region :");
		String regionName = scannerObject.next();
		
		listToDisplay.values().stream()
			.map(region -> region.stream()
				.filter(person -> person.getAddress().getState().equals(regionName) || person.getAddress().getCity().equals(regionName)))
				.forEach(person -> person.forEach(personDetails -> System.out.println(personDetails)));
	}
	
	public void countPeopleByRegion(HashMap<String, ArrayList<ContactPerson>> listToDisplay) {

		System.out.println("Enter the name of the region :");
		String regionName = scannerObject.next();
		
		long countPeople = listToDisplay.values().stream()
				.map(region -> region.stream()
					.filter(person -> person.getAddress().getState().equals(regionName) || person.getAddress().getCity().equals(regionName)))
					.count();
					
		System.out.println("Number of People residing in " + regionName+" are: "+countPeople+"\n");
		
	}
	
	public void displayDirectoryContents() {

		System.out.println("----- Contents of the Address Book Directory-----");
		for (String eachBookName : addressBookDirectory.keySet()) {
			
				System.out.println(eachBookName);
		}
		System.out.println("-----------------------------------------");
	}
}
