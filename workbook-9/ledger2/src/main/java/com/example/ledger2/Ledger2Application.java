package com.example.ledger2;

import com.example.ledger2.services.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Ledger2Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ledger2Application.class, args);
		TransactionService transactionService = context.getBean(TransactionService.class);

		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("================Ledger Application============");
			System.out.println("");

		} while (choice != 0);

		scanner.close();;
	}

}
