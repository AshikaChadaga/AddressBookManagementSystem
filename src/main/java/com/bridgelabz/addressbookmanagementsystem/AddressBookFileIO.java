package com.bridgelabz.addressbookmanagementsystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddressBookFileIO {
	
	public void writeToAddressBookFile(String fileName, Map<String, ContactPerson> contactList) {
				
		StringBuffer addressBookBuffer = new StringBuffer();
		contactList.values().stream().forEach(contact -> {
			String personDataString = contact.toString().concat("\n");
			addressBookBuffer.append(personDataString);
		});

		try {
			Files.write(Paths.get(fileName), addressBookBuffer.toString().getBytes());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void printData(String fileName) {
		
		try {
			Files.lines(new File(fileName).toPath()).forEach(System.out::println);
		}
		catch(IOException e) {e.printStackTrace();}
		
	}

	public long countEntries(String fileName) {
		
		long entries=0;
		try {
			entries = Files.lines(new File(fileName).toPath()).count();
		}
		catch(IOException e) {e.printStackTrace();};
		return entries;
	}
	
	public List<String> readDataFromFile(String fileName) {
		
		List<String> addressBookList = new ArrayList<String>();
		
		System.out.println("Reading from : "+fileName+"\n");
		try {
			Files.lines(new File(fileName).toPath())
				.map(line -> line.trim())
				.forEach(employeeDetails -> {
					System.out.println(employeeDetails);
					addressBookList.add(employeeDetails);
			});
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return addressBookList;
	}
	
}
