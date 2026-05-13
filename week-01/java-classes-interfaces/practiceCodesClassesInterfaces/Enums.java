package com.java.classesInterfaces;

//1. Enum
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY, SUNDAY;

    boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

//2. Enum with fields and constructor
enum EmployeeLevel {
    INTERN("Intern", 15000.0),
    JUNIOR("Junior Developer", 25000.0),
    MID("Mid Developer", 45000.0),
    SENIOR("Senior Developer", 75000.0),
    LEAD("Tech Lead", 100000.0);

    private String title;
    private double baseSalary;

    EmployeeLevel(String title, double baseSalary) {
        this.title = title;
        this.baseSalary = baseSalary;
    }

    public String getTitle() {
        return title;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
enum Operations {
    ADD {
        @Override
        double apply(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        double apply(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        double apply (double a, double b) {
            return a / b;
    }

};
    abstract double apply(double a, double b);
}


public class Enums {
    public static void main(String[] args) {

        //1. Basic enum usage
        System.out.println("=== DAY CHECKER ===");
        Day today = Day.SATURDAY;
        System.out.println("Today: " + today);
        System.out.println("Is weekend: " + today.isWeekend());

        //2. Switch case
        switch (today) {
            case MONDAY:
                System.out.println("Start of work week!");
                break;
            case FRIDAY:
                System.out.println("TGIF! 🎉");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Rest day! 😴");
                break;
            default:
                System.out.println("Weekday!");
        }

        //3. Enum Ordering
        System.out.println("\n=== LEVEL COMPARISON ===");
        EmployeeLevel myLevel = EmployeeLevel.JUNIOR;
        EmployeeLevel targetLevel = EmployeeLevel.SENIOR;

        System.out.println("My level: " + myLevel.getTitle());
        System.out.println("Salary: " + myLevel.getBaseSalary());
        System.out.println("Target: " + targetLevel.getTitle());

        if (myLevel.compareTo(targetLevel) < 0) {
            System.out.println("Keep Grinding!");
        }

        //3. All enum values
        System.out.println("\n=== ALL LEVELS ===");
        for (EmployeeLevel level : EmployeeLevel.values()) {
            System.out.printf("%-8s → %-20s → %.0f%n",
                    level.name(), level.getTitle(), level.getBaseSalary());
        }
        System.out.println("\n=== OPERATIONS ===");
        double a = 15, b = 10;
        for(Operations op : Operations.values()) {
        System.out.printf("%.0f %s %.0f = %.1f%n",
                a, op.name(), b, op.apply(a, b));
    }
}
}