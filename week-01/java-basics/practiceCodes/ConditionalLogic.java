package com.java.basics;

public class ConditionalLogic {

    public static void main(String[] args) {

        //1. Ternary Operator
        int age = 23;
        String status = age >= 18 ? "Adult" : "Minor";

        System.out.println("Status: " + status);

        //2. If-else chain
        int score = 95;

        if (score >= 90) {
            System.out.println("Grade: A+");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Failed");
        }

        //3. Logical operators
        int a = 20;  int b = 30;
        System.out.println("AND: " + (a > 5 && b > 5));
        System.out.println("OR: " + (a > 5 || b > 5));

        //4. Switch case-statement
       String day = "";

        switch(day) {
            case "Monday":
                System.out.println("Start of the weekdays");
                break;
            case "Tuesday":
                System.out.println("Second day of the weekdays");
                break;
            case "Wednesday":
                System.out.println("Third day of the weekdays");
                break;
            case "Thursday":
                System.out.println("Fourth day of the weekdays");
                break;
            case "Friday":
                System.out.println("Last day of weekdays");
                break;
            default:
                System.out.println("Its weekends!");
        }

    }
}
