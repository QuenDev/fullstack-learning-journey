package com.java.classesInterfaces;

interface Gradable {
    String calculateGrade();
    double getAverage();
}

interface Reportable {
    void generateReport();
}

enum CourseType {
    LECTURE("Face-to-face lecture class", 3),
    LABORATORY("Hands-on-laboratory", 4),
    ONLINE("Online distance learning", 3);

    private String description;
    private int units;

    CourseType(String description, int units) {
        this.description = description;
        this.units = units;
    }

    public int getUnits() {
        return units;
    }

    public String getDescription() {
        return description;
    }
}

abstract class Persons {
    private String name;
    private int age;
    private int id;
    private static int totalPersons = 0;


    public Persons(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;

        totalPersons++;
    }
    void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Role: " + getRole());
    }

    public static int getTotalPersons() {return totalPersons;}

    abstract String getRole();

    @Override
    public String toString(){
        return "Person{name ='" + name + "', id =" + id +"}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Persons)) return false;
        Persons other = (Persons) obj;
        return this.id == other.id;
    }

    public String getName(){ return name; }
    public int getAge() { return age; }
    public int getId() {return id;}
}

class Students extends Persons implements Gradable, Reportable {
    private int[] scores;
    private String course;
    private CourseType courseType;


    Students(String name, int age, int id, int[] scores, String course, CourseType courseType) {
        super(name, age, id);
        this.scores = scores;
        this.course = course;
        this.courseType = courseType;
    }

    @Override
    public double getAverage() {
        double sum= 0;
        for (int score : scores) {
            sum += score;
        }
        double average = sum / scores.length;
        return average;
    }

    @Override
    public String calculateGrade() {
        double avg = getAverage();

        if(avg >= 90) {return "A";}
        if(avg >= 80) {return "B";}
        if(avg >= 70) {return "C";}
        return "F";
    }

    @Override
    public void generateReport() {
        displayInfo();
        System.out.println("Course: " + course);
        System.out.println("Type: " + courseType + " (" + courseType.getUnits() + " units) - " + courseType.getDescription());
        System.out.print("Scores: "  );
        for(int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
        System.out.println("Average: " + getAverage());
        System.out.println("Grade: " + calculateGrade());
    }

    @Override
    public String getRole() {
        return "Student";
    }



}

class Instructor extends Persons implements Reportable {
    private String department;
    private double salary;

    Instructor(String name, int age, int id, String department, double salary) {
        super(name, age, id);
        this.department = department;
        this.salary = salary;
    }

    @Override
    public void generateReport() {
        displayInfo();
        System.out.println("Role:" +  getRole());
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary );
    }

    @Override
    public String getRole() {return "Instructor";}
}


    public class ChallengeClassesInterface {
        public static void main(String[] args) {

            Students[] students = {
                    new Students("Mark", 22, 1001, new int[]{90, 99, 99, 89, 90}, "Java", CourseType.LABORATORY),
                    new Students("Lee", 25, 1002, new int[]{87, 78, 97, 99, 78}, "Python", CourseType.LECTURE),
                    new Students("Ralph", 26, 1003, new int[]{99, 98, 79, 99, 99}, "C++", CourseType.ONLINE),
            };

            Instructor[] instructors = {
                    new Instructor("Sir Rex", 23, 1004, "CCSICT", 50000.0),
                    new Instructor("Sir Pablo", 27, 1005, "Engineering Dept", 25000.0),
            };

            System.out.println("=== SCHOOL MANAGEMENT SYSTEM ===");
            System.out.println("Total Persons Created: " + Persons.getTotalPersons());


            for (Students student : students) {
                System.out.println();
                student.generateReport();
            }
            System.out.println();


            for (Instructor instructor : instructors) {
                System.out.println();
                instructor.generateReport();
            }
            System.out.println();

            System.out.println("=== HEIGHEST AVERAGE ===");
            Students topStudent = students[0];
            for (Students topStudents : students) {
                if (topStudents.getAverage() > topStudent.getAverage()) {
                    topStudent = topStudents;
                }
            }
            System.out.println("Top student: " + topStudent.getName() + " " + topStudent.getAverage());


            System.out.println("=== Equals Test ===");
            Students checkEqual = students[0];
            for(Students isEqual : students) {
                if(isEqual.equals(checkEqual)) {

                }
                System.out.println(isEqual.getName() + " == Mark? " + isEqual.equals(checkEqual));
            }


        }
    }
