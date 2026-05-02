package com.java.basics;

public class DataTypes {

    public static void main(String[] args) {


        /* 1. Variables */
        String name = "Quenedy";

        /* 2. Primitive types */
         int age = 23;
         double salary = 0.50;
         char initial = 'Q';
         boolean isEmployed = false;
         final int MAX_AGE = 100;

         System.out.println("Name: " + name);
         System.out.println("Age: " + age);
         System.out.println("Salary: " + salary);
         System.out.println("Initial: " + initial);
         System.out.println("Employed " + isEmployed);
         System.out.println("Max Age: " + MAX_AGE);

         /* 3. Math operators */
        int num1 = 20; int num2 = 15;

        System.out.println("Add:" + (num1 + num2));
        System.out.println("Subtract: " + (num1 - num2));
        System.out.println("Multiply: " + (num1 * num2));
        System.out.println("Divide: " + (num1 / num2));
        System.out.println("Modulus: " + (num1 % num2));

        /* 4. Type Conversion */
        double decimal = 10.132;
        int conversion = (int) decimal;

        System.out.println(conversion);


        /* 5. Compound operators */
        int num3 = 22;
        int num4 = 23;

        num3 += num4;

        System.out.println("Compound: " + num3);


    }
}
