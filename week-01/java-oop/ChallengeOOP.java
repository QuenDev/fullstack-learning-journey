package com.quenedy.oop;

abstract class LibraryItem {
    private String title;
    private String author;
    private int id;

    //Shared fields
    protected boolean available;
    protected String borrower;
    protected double feePerDay;

    public LibraryItem(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.available = true;
        this.borrower = null;
    }


    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getId() { return id; };


    public void borrowItem(String borrowerName) {
        if(available) {
            this.available = false;
            this.borrower = borrowerName;
            System.out.println("\"" + title +
                    "\" borrowed by " + borrowerName + " ✅");
        } else {
            System.out.println("\"" + title +
                    "\" is not available ❌");
        }
    }

    public void returnItem() {
        this.available = true;
        this.borrower = null;
        System.out.println("\"" + title + "\" returned ✅");
    }

    // Shared display
    void displayInfo() {
        System.out.println("\nID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Type: " + getItemType());
        System.out.println("Available: " + available);
    }
    // Abstract methods - children MUST implement
    abstract String getItemType();
    abstract double calculateLateFee(int daysLate);
    }

    interface Borrowable {
         boolean isAvailable();
         String getBorrower();
}
    interface Searchable {
        boolean matchesSearch(String keyword);

    }
class Book extends LibraryItem implements Borrowable,Searchable {
    public Book (String title, String author, int id) {
        super(title, author, id);
        this.feePerDay = 5.0;
    }

    @Override
    String getItemType() {
        return "Book";
    }

    @Override
    double calculateLateFee(int daysLate) {
        return feePerDay * daysLate;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public String getBorrower() {
        return borrower;
    }

    @Override
    public boolean matchesSearch(String keyword) {
        return getTitle().toLowerCase()
                .contains(keyword.toLowerCase()) ||
                getAuthor().toLowerCase()
                        .contains(keyword.toLowerCase());
    }
}

class DVD extends LibraryItem implements Borrowable, Searchable {
    public DVD (String title, String author, int id) {
        super(title, author, id);
        this.feePerDay = 10.0;
    }
    @Override
    String getItemType() {
        return "DVD";
    }

    @Override
    double calculateLateFee(int daysLate) {
        return feePerDay * daysLate;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public String getBorrower() {
        return borrower;
    }

    @Override
    public boolean matchesSearch(String keyword) {
        return getTitle().toLowerCase()
                .contains(keyword.toLowerCase()) ||
                getAuthor().toLowerCase()
                        .contains(keyword.toLowerCase());
    }
}

class Magazine extends LibraryItem implements Borrowable,Searchable {
    public Magazine (String title, String author, int id) {
        super(title, author, id);
        this.feePerDay = 2.0;
    }

    @Override
    String getItemType() {
        return "Magazine";
    }

    @Override
    double calculateLateFee(int daysLate) {
        return feePerDay * daysLate;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public String getBorrower() {
        return borrower;
    }

    @Override
    public boolean matchesSearch(String keyword) {
        return getTitle().toLowerCase()
                .contains(keyword.toLowerCase()) ||
                getAuthor().toLowerCase()
                        .contains(keyword.toLowerCase());
    }
}

public class ChallengeOOP {
    public static void main(String[] args) {
        //All items
        LibraryItem[] items = {
                new Book("Clean Code", "Robert Martin", 1),
                new DVD("Inception", "Christopher Nolan", 2),
                new Magazine("National Geographic", "Various Authors", 3)
        };

        // Display all
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===");
        System.out.println("\n=== ALL ITEMS ===");
        for (LibraryItem item : items) {
            item.displayInfo();
        }

        System.out.println("\n=== BORROWING ITEMS ===");
        items[0].borrowItem("Quenedy");
        items[1].borrowItem("Ken");
        items[2].borrowItem("Ralph");

        // Late fees
        System.out.println("\n=== LATE FEES (5 days) ===");
        int daysLate = 5;
        double totalFees = 0;
        for (LibraryItem item : items) {
            double fee = item.calculateLateFee(daysLate);
            System.out.printf("%-20s late fee: %.1f%n",
                    item.getTitle(), fee);
            totalFees += fee;
        }
        System.out.println("Total Fees: " + totalFees);

        // Search
        System.out.println("\n=== SEARCH ===");
        String keyword = "National";
        System.out.println("Searching \"" + keyword + "\":");
        for (LibraryItem item : items) {
            if (((Searchable) item).matchesSearch(keyword)) {
                System.out.println("Found: " + item.getTitle()
                        + " by " + item.getAuthor());
            }
        }

        // Return item  
        System.out.println("\n=== RETURNING ITEMS ===");
        items[0].returnItem();
        System.out.println("Is Clean Code available? "
                + ((Borrowable)items[0]).isAvailable());
    }
}




