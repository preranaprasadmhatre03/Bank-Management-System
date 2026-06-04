package com.bank.management.system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BankManagement 
{
	 static ArrayList<Account> accounts = new ArrayList<>();
	    static final String FILE_NAME = "accounts.txt";

	    public static void main(String[] args) {
	        loadAccounts();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Check 5.Exit");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Account Number: ");
	                    int accNo = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Initial Balance: ");
	                    double balance = sc.nextDouble();
	                    accounts.add(new Account(accNo, name, balance));
	                    saveAccounts();
	                    break;

	                case 2:
	                    System.out.print("Account Number: ");
	                    accNo = sc.nextInt();
	                    System.out.print("Amount: ");
	                    double deposit = sc.nextDouble();
	                    findAccount(accNo).deposit(deposit);
	                    saveAccounts();
	                    break;

	                case 3:
	                    System.out.print("Account Number: ");
	                    accNo = sc.nextInt();
	                    System.out.print("Amount: ");
	                    double withdraw = sc.nextDouble();
	                    findAccount(accNo).withdraw(withdraw);
	                    saveAccounts();
	                    break;

	                case 4:
	                    System.out.print("Account Number: ");
	                    accNo = sc.nextInt();
	                    System.out.println("Balance: " + findAccount(accNo).getBalance());
	                    break;

	                case 5:
	                	System.out.println("Thank you for using the system.");
	                    sc.nextLine();
	                    sc.nextLine();
	                    sc.close();
	                    return;
	                    
//	                case 6:
//	                	accounts.remove(accNo);
	                    
	                default:System.out.println("Invalid choice! Please select a valid option.");
	            }
	        }
	    }

	    static Account findAccount(int accNo) {
	        for (Account a : accounts) {
	            if (a.getAccountNumber() == accNo)
	                return a;
	        }
	        System.out.println("Account not found!");
	        return null;
	    }

	    static void saveAccounts() {
	        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
	            for (Account a : accounts) {
	                pw.println(a);
	            }
	        } catch (IOException e) {
	            System.out.println("Error saving data.");
	        }
	    }

	    static void loadAccounts() {
	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                accounts.add(Account.fromString(line));
	            }
	        } catch (IOException e) {
	            // File may not exist first time
	        }
	    }

}
