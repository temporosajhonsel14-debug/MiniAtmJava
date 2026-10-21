package ATMPROJECT.Account;

interface AccountOperations {
    double getBalance();
    void setBalance(double balance);
}

public class useraccount implements AccountOperations {

    private String username;
    private String fullName;
    private String pin;
    private double balance;

    // Constructor including full name for proper identification
    public useraccount(String username, String fullName, String pin, double balance) {
        this.username = username;
        this.fullName = fullName;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPin() {
        return pin;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }
}