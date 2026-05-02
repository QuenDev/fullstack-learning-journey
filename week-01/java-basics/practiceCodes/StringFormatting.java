package com.java.basics;

public class StringFormatting {

    public static void main(String[] args) {

        //1. Basic format specifiers
        System.out.printf("Name: %s%n", "Quenedy");
        System.out.printf("Age: %d%n", 23);
        System.out.printf("GPA: %f%n", 3.14259);

        // 2. Precision
        System.out.printf("GPA: %.2f%n", 3.14159);

        //3. Width
        System.out.printf("%10s|%n", "Quenedy");
        System.out.printf("%-10s|%n", "Quenedy");

        //4. Flags
        System.out.printf("%05d%n", 23);
        System.out.printf("%,d%n", 100000);
        System.out.printf("%+d%n", 23);

        //5. Argument index
        System.out.printf(" Si %1$s ay %2$s tapos wala pang %3$s wawa naman %n", "Cris at Quen", "pagod na", "lambing");
        
        //6. String format
        String profile = String.format(
                "Name: %s | Age: %d | Course: %s",
                "Quenedy", 23, "BSIT");
        System.out.println(profile);
    }
}
