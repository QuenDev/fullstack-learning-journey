package com.java.classesInterfaces;

import java.time.LocalDate;

class Course {
    private String courseName;
    private String instructor;
    private int duration;
    private String createdAt;
    private boolean active;

    //Field Initializer
    private static int totalCourses = 0;
    //
    // Initialization block - runs on EVERY creation
    {
        createdAt  = LocalDate.now().toString();
        active = true;
        totalCourses++;
        System.out.println("Course object created! Total: "
                + totalCourses);
    }

    // Master constructor
    public Course(String courseName, String instructor, int duration) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.duration = duration;

    }
    //Default Constructor
    public Course(){
        this("Unkown Course", "Unknown Instructor", 0);
    }

    // Constructor with name only
    public Course(String courseName) {
        this(courseName, "Unknown Instructor", 0);
    }

    //Getters
    public String getCourseName() {return courseName;}
    public String getInstructor() {return instructor;}
    public int getDuration() {return duration;}
    public String getCreatedAt() {return createdAt;}
    public boolean isActive() {return active;}
    public static int getTotalCourses() {return totalCourses;}


    public void displayInfo() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Created: " + createdAt);
        System.out.println("Active: " + active);
    }
}

public class Constructor {
    public static void main(String[] args) {

        //Default Constructor

        Course c1 = new Course("Javascript", "Sir Rex", 40);

        Course c2 = new Course();

        //Constructor with one params
        Course c3 = new Course("Python");


        System.out.println("\n=== COURSE DETAILS ===");
        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();

        System.out.println("\nTotal Courses: " + Course.getTotalCourses());





    }
}




