package com.pluralsight.finance;

public class CreditCard implements Valuable {
    private String name;
    private String accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean charge(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public void pay(double amount) {
        if (amount > 0) {
            balance = Math.max(0, balance - amount);
        }
    }


    @Override
    public double getValue() {
        return -balance; // Return negative value since this is debt
    }
}
