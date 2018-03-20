package com.example.transactions.SpringTransaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SpringTransactionService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Transactional
	public void updateDB(List<Person> persons, List<Address> addresses) {
		for (Person person : persons) {
			System.out.println("Person -> " + person);
			jdbcTemplate.update("insert into PERSONALINFO(FIRST_NAME) values (?)", person.getFirstName());
		}

		for (Address address : addresses) {
			System.out.println("Address -> " + address);
			jdbcTemplate.update("insert into ADDRESS(ADDRESS_LINE) values (?)", address.getAddressLine());
		}
	}
	
	public List<Person> findAllPersons() {
		return jdbcTemplate.queryForList("select FIRST_NAME from PERSONALINFO", Person.class);
	}
	
	public List<Address> findAllAddress() {
		return jdbcTemplate.queryForList("select ADDRESS_LINE from ADDRESS", Address.class);
	}

}
