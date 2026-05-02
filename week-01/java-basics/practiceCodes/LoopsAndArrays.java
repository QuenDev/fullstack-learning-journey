package com.java.basics;

public class LoopsandArrays {

    public static void main(String[] args) {

        //1. While loop
        System.out.println("--- While loop ---");
        int i = 6;

        if (i >= 5) {
            while (i >= 5) {
                System.out.println(i);
                i--;
            }
        } else {
            System.out.println("The condition is false, loops never runs");

        }

        //2. Do-while loop
        System.out.println("--- Do-while loop ---");
        int j = 1;
        do {
            System.out.println(3);
            j++;
        } while (j <= 5);

        //3. For loops
        for (int k = 1; k <= 3; k++) {
            System.out.println(k);

        }

        //Nested loops triangle
        for (int triangleRow = 1; triangleRow <= 5; triangleRow++) {
            for (int starsColumns = 1; starsColumns <= triangleRow; starsColumns++) {
                System.out.print(" * ");
            }

                System.out.println();
        }

        //4. Arrays
        System.out.println("---Array---");
        String[] names = {"Quenedy", "Java", "Accenture", "React", "Spring", "3 Months"};
        System.out.println("Name: " + names[0]);
        System.out.println("Skills: " + names[1]);
        System.out.println("Bootcamp: " + names[2]);
        System.out.println("FED BED: " + names[3] + " " + names[4]);

        //5. For loops with array
        System.out.println("---For Loop with array---");
        for (int x = 5; x <= 5; x++ ) {
            System.out.println("Duration: " + names[x]);
        }

        //For-each loops array
        System.out.println("---For-Each Loop with array---");
        int[] numbers = {20, 40, 60, 80, 100};

        for(int number : numbers) {
            System.out.println("Element: " + number);
        }




    }
}