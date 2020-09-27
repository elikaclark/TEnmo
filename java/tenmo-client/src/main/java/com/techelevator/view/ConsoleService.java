package com.techelevator.view;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.User;

public class ConsoleService {

	private PrintWriter out;
	private Scanner in;

	public ConsoleService(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output, true);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		out.println();
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

	public String getUserInput(String prompt) {
		out.print(prompt+": ");
		out.flush();
		return in.nextLine();
	}

	public Integer getUserInputInteger(String prompt) {
		Integer result = null;
		do {
			out.print(prompt+": ");
			out.flush();
			String userInput = in.nextLine();
			try {
				result = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				out.println("\n*** " + userInput + " is not valid ***\n");
			}
		} while(result == null);
		return result;
	}
	
	public void viewCurrentBalance (double currentBalance) {
		System.out.println("The current balance is : "+ currentBalance);

		
	}
	public void listOfUsers(User[] listOfUsers){
	for (User users : listOfUsers ) {
		System.out.println(users.getUsername() + " " + users.getId());
	}
		System.out.println("This is your list of users " + listOfUsers);
		System.out.println("Who do you want to send it to?");
		
		
	
		
	}
	
	public double promptUserSendBucks (String prompt, double currentBalance, User[] listOfUsers) {
		Account account = new Account();
		Scanner scanner = new Scanner(System.in);
		System.out.println("How much bucks you want to send?");
		String amountInput = scanner.nextLine();
		double amount = Double.parseDouble(amountInput);
//		Account account = new Account();
	
			try {
//			double amount = Double.valueOf(amountInput);
				if (amount > currentBalance) {
					
					System.out.println("You have no enough funds to process transfer...");
			} else {
				System.out.println("your currnet balance is : " +  currentBalance);
				System.out.println("Please choose account you would like to make transfer to: " + listOfUsers);
				
				
				
				double newBalance = currentBalance - amount;
				return newBalance;
			}
		} catch (NumberFormatException e) {
			
		}
		return currentBalance;
		
	}
	
	public void viewTransferHistory (Transfer[] transfer) {
		
		
		if(transfer == null) {
			System.out.println("Nothing to display");
		} else {
			System.out.println(transfer.length);
		
		for (Transfer transfers : transfer) {
			System.out.println(transfers);
			
		}
	}
	
	}

	

	
}
