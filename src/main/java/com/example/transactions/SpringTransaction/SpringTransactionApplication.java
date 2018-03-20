package com.example.transactions.SpringTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactionApplication.class, args);
	}
}
