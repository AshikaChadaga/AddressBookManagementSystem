package com.bridgelabz.addressbookmanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookDirectoryIF {
	
	public void addAddressBook();

	public void operationDirectory();

	public void displayDirectoryContents();

	public void editAddressBook();

	public void searchByCity();

	public void searchByState();

	public void displayPeopleByRegion(HashMap<String, ArrayList<ContactPerson>> listToDisplay);

	public void countPeopleByRegion(HashMap<String, ArrayList<ContactPerson>> listToDisplay);
}
