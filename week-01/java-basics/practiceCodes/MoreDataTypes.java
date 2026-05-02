package com.java.basics;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class MoreDataTypes {

    public static void main(String[] args) {

        //1. Instant Time
        Instant instant = Instant.now();
        System.out.println("Instant: " + instant);

        //2. Local Date/Time
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("DateTime: " + dateTime);

        //3. ZonedDateTime
        ZonedDateTime zoned = ZonedDateTime.now();
        System.out.println("Zoned: " + zoned);

        //4. Date Time Formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");
        System.out.println("Formatted: " + dateTime.format(formatter));


        // 5. Primitive Wrappers
        Integer age = 23;
        Double gpa = null;
        Boolean isEmployed = null;

        System.out.println("Age: " + age);
        System.out.println("Max Int: " + Integer.MAX_VALUE);
        System.out.println("Parse: " + Integer.parseInt("100"));

    }


}
