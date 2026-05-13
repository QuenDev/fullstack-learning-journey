package com.java.classesInterfaces;

    //1, Static Nested class
    class University {
        private String name;

        //Static nested class
        static class Department {
            private String deptName;
            private int studentCount;

            Department(String deptName, int studentCount) {
                this.deptName = deptName;
                this.studentCount = studentCount;
            }

            void displayInfo() {
                System.out.println("Department: " + deptName);
                System.out.println("Students: " + studentCount);
            }
        }

        //Inner class
        class Student {
            private String studentName;
            private double gpa;

            Student(String studentName, double gpa) {
                this.studentName = studentName;
                this.gpa = gpa;
            }

            void displayInfo() {
                // Accesses outer class private field!
                System.out.println("University: " + name);
                System.out.println("Student: " + studentName);
                System.out.println("GPA: " + gpa);
            }
        }

        University(String name) {
            this.name = name;
        }
    }

    //2. Interface for anonymous class demo
    interface Sortable {
        void sort (int[] numbers);
    }

    interface Validator {
        boolean validate (String input);
    }

public class NestedAndAnonymous {
    public static void main(String[] args) {
        //Static nested class
        System.out.println("=== STATIC NESTED CLASS ===");
        University.Department dept =
                new University.Department("College of Computing Studies", 150);
        dept.displayInfo();

        System.out.println();
        System.out.println("=== INNER CLASS ===");
        University uni = new University("Isabela State University");
        University.Student student = uni.new Student("Quenedy", 3.8);
        student.displayInfo();

        // Anonymous classes
        System.out.println("=== ANONYMOUS CLASSES ===");

        //Different sorting strategies
        Sortable bubbleSort = new Sortable() {
            @Override
            public void sort(int[] numbers) {
                System.out.print("Bubble sorted: ");
                // Simple bubble sort
                for (int i = 0; i < numbers.length - 1; i++) {
                    for (int j = 0; j < numbers.length - i - 1; j++) {
                        if (numbers[j] > numbers[j + 1]) {
                            int temp = numbers[j];
                            numbers[j] = numbers[j + 1];
                            numbers[j + 1] = temp;
                        }
                    }
                }
                for (int n : numbers) System.out.print(n + " ");
                System.out.println();
            }
        };
        // Different validators
        Validator emailValidator = new Validator() {
            @Override
            public boolean validate(String input) {
                return input.contains("@") &&
                        input.contains(".");
            }
        };
        Validator passwordValidator = new Validator() {
            @Override
            public boolean validate(String input) {
                return input.length() >= 8;
            }
        };

        // Use anonymous classes
        int[] numbers = {5, 2, 8, 1, 9, 3};
        bubbleSort.sort(numbers);

        System.out.println();
        System.out.println("=== VALIDATORS ===");
        String email = "quenedy@gmail.com";
        String password = "java2024";
        String weakPassword = "abc";

        System.out.println("Email valid: " +
                emailValidator.validate(email));
        System.out.println("Password valid: " +
                passwordValidator.validate(password));
        System.out.println("Weak password valid: " +
                passwordValidator.validate(weakPassword));
    }
}

