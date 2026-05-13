package com.java.classesInterfaces;
import static java.lang.Math.*;

class BankAccount {
    //Static fields
    private static int totalAccounts = 0;
    private static double totalBalance = 0;
    private static final double INTEREST_RATE = 0.05; //constant

    //Static init Block
    static {
        System.out.println("BankAccount class initialized!");
        System.out.println("Interest Rate: " + INTEREST_RATE);
    }

    private String owner;
    private double balance;
    private int accountId;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        totalAccounts++;
        totalBalance += balance;
        this.accountId = totalAccounts;
    }

    public static int getTotalAccounts() {return totalAccounts;}
    public static double getTotalBalance() {return totalBalance;}

    public static double calculateInterest(double balance) {
        return balance * INTEREST_RATE;
    }

    public void displayInfo() {
        System.out.println("\nAccount ID: " + accountId);
        System.out.println("Owner: " + owner);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest(balance));
    }
}


public class StaticMembers {
    public static void main(String[] args) {

        System.out.println("\n=== CREATING ACCOUNTS ===");

        BankAccount a1 = new BankAccount("Quenedy", 50000);
        BankAccount a2 = new BankAccount("Ken", 50000);
        BankAccount a3 = new BankAccount("Ralph", 50000);

        System.out.println("\n=== ACCOUNT DETAILS ===");
        a1.displayInfo();
        a2.displayInfo();
        a3.displayInfo();

        System.out.println("\n=== BANK SUMMARY ===");
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
        System.out.println("Total Balance: " + BankAccount.getTotalBalance());

        // Static import - Math methods without prefix!
        System.out.println("\n=== MATH UTILS ===");
        System.out.println("Square root of 144: " + sqrt(144));
        System.out.println("Max balance: " +
                max(max(50000.0, 30000.0), 20000.0));
        System.out.println("PI: " + PI);
    }
}

