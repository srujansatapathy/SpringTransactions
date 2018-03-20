package com.example.transactions.SpringTransaction;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringTransactionController {
	
	@Autowired
	SpringTransactionService springTransactionService;
	
	@GetMapping("/happy")
	public void testHappyPath() {
		
		List<Person> persons = Arrays.asList(new Person("NAME-1"), new Person("NAME-2"));
		List<Address> addresses = Arrays.asList(new Address("ADDRESS-1"), new Address("ADDRESS-2"));
		
		try {
		springTransactionService.updateDB(persons, addresses);
		} catch (Exception e) {
			System.out.println("Exception is -> " + e.getMessage());
		}
		List<Person> personsRsult = springTransactionService.findAllPersons();
		List<Address> addressRsult = springTransactionService.findAllAddress();
		
		System.out.println("No of Persons in DB -> " + personsRsult.size());
		System.out.println("No of Addresses in DB -> " + addressRsult.size());
		
	}
	
	@GetMapping("/personFail")
	public void testPersonFail() {
		List<Person> persons = Arrays.asList(new Person("NAME-1"), new Person("NAME-22222222222222")); // Name is too long, Should Fail
		List<Address> addresses = Arrays.asList(new Address("ADDRESS-1"), new Address("ADDRESS-2"));
		
		try {
		springTransactionService.updateDB(persons, addresses);
		} catch (Exception e) {
			System.out.println("Exception is -> " + e.getMessage());
		}
		List<Person> personsRsult = springTransactionService.findAllPersons();
		List<Address> addressRsult = springTransactionService.findAllAddress();
		
		System.out.println("No of Persons in DB -> " + personsRsult.size());
		System.out.println("No of Addresses in DB -> " + addressRsult.size());
	}
	
	@GetMapping("/addressFail")
	public void testAddressFail() {
		List<Person> persons = Arrays.asList(new Person("NAME-1"), new Person("NAME-2"));
		List<Address> addresses = Arrays.asList(new Address("ADDRESS-1"), new Address("ADwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwDRESS-2")); //Address is too long ,Should Fail
		
		try {
		springTransactionService.updateDB(persons, addresses);
		} catch (Exception e) {
			System.out.println("Exception is -> " + e.getMessage());
		}
		List<Person> personsRsult = springTransactionService.findAllPersons();
		List<Address> addressRsult = springTransactionService.findAllAddress();
		
		System.out.println("No of Persons in DB -> " + personsRsult.size());
		System.out.println("No of Addresses in DB -> " + addressRsult.size());
	}

}
