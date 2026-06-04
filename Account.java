package com.bank.management.system;

import java.io.*;
import java.util.*;

public class Account 
{
	
	    private int accountNumber;
	    private String name;
	    private double balance;

	    public Account(int accountNumber, String name, double balance) {
	        this.accountNumber = accountNumber;
	        this.name = name;
	        this.balance = balance;
	    }

	    public int getAccountNumber() {
	        return accountNumber;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	    }

	    public void withdraw(double amount) {
	        if (amount <= balance)
	            balance -= amount;
	        else
	            System.out.println("Insufficient Balance!");
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public String toString() {
	        return accountNumber + "," + name + "," + balance;
	    }

	    public static Account fromString(String data) {
	        String[] parts = data.split(",");
	        return new Account(
	            Integer.parseInt(parts[0]),
	            parts[1],
	            Double.parseDouble(parts[2])
	        );
	  }
}


