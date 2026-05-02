package com.java.basics;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Challenge {

    static String calculateGrade(int scores) {
        if (scores >= 90) {
            return "A";
        } else if (scores >= 80) {
            return "B";
        } else if (scores >= 70) {
            return "C";
        } else {
            return "F";

        }
    }

    static String displayReport(String student, int score, String calculateGrades) {

        return String.format("Name: %-10s | Score: %d | Grade: %s", student, score, calculateGrades);

    }

    public static void main(String[] args) {

        String[] students = {"Ken", "Mark", "Kate", "John", "Ralph"};
        int[] scores = {91, 80, 95, 92, 79};
        int sum = 0;


        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");
        System.out.println("===Generate Summary Report===");
        System.out.println( dateTime.format(formatter));

        for (int i = 0; i < students.length; i++) {
            String report = displayReport(students[i], scores[i], calculateGrade(scores[i]));
            sum += scores[i];

            System.out.println(report);

        }

           double average = (double)sum / students.length;

            StringBuilder summary = new StringBuilder();
            summary.append("\n=== SUMMARY ===\n");
            summary.append("Total Students: " + students.length + "\n");
            summary.append("Average score: " + average + "\n");
            System.out.print(summary.toString());

    }
}
