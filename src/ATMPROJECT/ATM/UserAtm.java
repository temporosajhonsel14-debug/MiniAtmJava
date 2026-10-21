package ATMPROJECT.ATM;

import java.util.Scanner;
import ATMPROJECT.Account.useraccount;
import ATMPROJECT.Login.userlogin;
import ATMPROJECT.Transaction.trans;

public class UserAtm {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        userlogin loginSystem = new userlogin();

        System.out.println("==================================");
        System.out.println("   Welcome to the Mini ATM System ");
        System.out.println("==================================");

        useraccount currentAccount = null;

        // Login Loop
        while (currentAccount == null) {
            System.out.print("\nEnter Username (jhonsel / mark): ");
            String username = input.nextLine();

            System.out.print("Enter PIN: ");
            String pin = input.nextLine();

            currentAccount = loginSystem.authenticate(username, pin);

            if (currentAccount == null) {
                System.out.println("Invalid Username or PIN. Please try again.");
            }
        }

        // Greets the user by their full name
        System.out.println("\nLogin successful! Welcome, " + currentAccount.getFullName() + "!");
        trans transaction = new trans(currentAccount);

        // ATM Menu Loop
        boolean running = true;
        while (running) {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                input.next();
                continue;
            }

            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.printf("Current Balance: $%.2f%n", currentAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    if (input.hasNextDouble()) {
                        double deposit = input.nextDouble();
                        input.nextLine();
                        transaction.deposit(deposit);
                    } else {
                        System.out.println("Invalid numerical input.");
                        input.next();
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    if (input.hasNextDouble()) {
                        double withdraw = input.nextDouble();
                        input.nextLine();
                        transaction.withdraw(withdraw);
                    } else {
                        System.out.println("Invalid numerical input.");
                        input.next();
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using Mini ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please pick an option from 1 to 4.");
            }
        }
        input.close();
    }
}