package ATMPROJECT.Transaction;

import ATMPROJECT.Account.useraccount;

public class trans {

    private useraccount account;

    public trans(useraccount account) {
        this.account = account;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.printf("Successfully Deposited: $%.2f%n", amount);
        } else {
            System.out.println("Invalid amount. Deposit must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal must be greater than zero.");
        } 
        else if (amount > account.getBalance()) {
            System.out.println("Insufficient balance. Transaction failed.");
        } 
        else {
            account.setBalance(account.getBalance() - amount);
            System.out.printf("Successfully Withdrawn: $%.2f%n", amount);
        }
    }
}