package com.java.basics;

public class Methods {

    //1. No return, no params
    static void greet() {
        System.out.println("Hello from method");
    }

    //2. With params, no return
    static void introduce(String name, String course, int age) {
        System.out.println("Name:" + name + " Course:" + course + " Age:" + age);
    }

    //3. With params and return
    static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    //4. Returns array
    static int[]getArrayScores() {
        return new int[]{90, 96, 90, 89};
    }

    //5. Pass by value demo
    static void passName(String title) {
        title = title + " Accenture";
        System.out.println("Inside method: " + title);
    }

    public static void main(String[] args) {

        //Call greet method
        greet();

        //Call introduce method
        introduce("Quenedy", "BSIT", 23);

        //Call Multiply method
        int multiplication = multiply(20, 30);
        System.out.println("Product: " + multiplication);

        //Call getArrayScore
        int[] scores = getArrayScores();
        for(int score : scores) {
            System.out.println("Score: " + score);
        }

        // Pass by value demo
        String bootcamp = "Bootcamp";
        passName(bootcamp);
        System.out.println("Outside method: " + bootcamp);
    }

}
