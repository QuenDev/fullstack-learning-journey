package com.java.classesInterfaces;

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class GradeUtils {

    //1. Pass by reference demo
    static void addbonus(Student student, int bonus) {
        student.score += bonus; //modifies the original
        System.out.println("Inside method: " + student.score);
    }

    //2. Method Overloading
    static double average(int a, int b) {
        System.out.println("Two ints version");
        return (a + b) / 2.0;
    }

    static double average(int a, int b, int c) {
        System.out.println("Three ints version");
        return (a + b + c) / 3.0;
    }

    static double average(double a, double b) {
        System.out.println("Two doubles version");
        return (a + b) / 2.0;
    }

    //3. Varargs
    static int product(int... numbers) {
        int totalProduct = 1;
        for (int number : numbers) {
            totalProduct *= number;
        }
        return totalProduct;
    }

    static void displayScore(String label, int... scores) {
        System.out.println(label + ": ");
        for (int i = 0; i < scores.length; i++) {
            if (i > 0)
            System.out.print(",");
            System.out.print(scores[i]);
        }
        System.out.println();
    }
}

public class Methods {
    public static void main(String[] args) {

        //1. Pass by reference
        System.out.println("=== PASS BY REFERENCE ===");
        Student ken = new Student("Ken", 90);
        System.out.println( "Name: "+ ken.name + "\nBefore passing :"  + ken.score);
        GradeUtils.addbonus(ken, 10);
        System.out.println("After: " + ken.score);

        System.out.println();

        System.out.println("=== METHOD OVERLOADING ===");
        System.out.println(GradeUtils.average(80, 90));
        System.out.println(GradeUtils.average(80, 90, 100));
        System.out.println(GradeUtils.average(80.5, 90.5));

        System.out.println();

        // 3. Varargs
        System.out.println("=== VARARGS ===");
        System.out.println("Product of nothing: " + GradeUtils.product());
        System.out.println("Product of 5: " + GradeUtils.product(5));
        System.out.println("Product of 5,10,15: " + GradeUtils.product(5, 10, 15));


        GradeUtils.displayScore("Ken's scores", 85, 90, 78, 92);
        GradeUtils.displayScore("Mark's scores", 70, 75);
    }
}

