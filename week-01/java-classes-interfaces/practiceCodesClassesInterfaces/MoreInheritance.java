package com.java.classesInterfaces;

//Abstract base class

abstract class Shapes{
    private String color;
    private String name;

    Shapes( String name, String color) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {return color;}
    public String getName(){return name;}

    //Abstract methods - child must implement this
    abstract double calculateArea();
    abstract double calculatePerimeter();

    final void displayInfo() {
        System.out.println("\nShape: " + name);
        System.out.println("Color: " + color);
        System.out.printf("Area: %.2f%n", calculateArea());
        System.out.printf("Perimeter: %.2f%n", calculatePerimeter());
    }
}

// Derived class 1
class Circle extends Shapes {
    private double radius;

    Circle(String color, double radius) {
        super("Circle", color);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
//Derived class 2
class Rectangle extends Shapes{
    private double height;
    private double width;

    Rectangle(String color, double height, double width) {
        super("Rectangle", color);
        this.height = height;
        this.width = width;

    }

    @Override
    double calculateArea() {
        return width * height;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (width + height);
    }

}

//Derived class 3
class Triangle extends Shapes {
    private double base;
    private double height;
    private double sideA, sideB, sideC;

    Triangle(String color, double base, double height, double sideA, double sideB, double sideC ) {
        super("Triangle", color);
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
}
// Final class - cannot be extended!v
final class MathConstants {
    static final double PI = Math.PI;
    static final double E = Math.E;


    static void display() {
        System.out.println("\nPI: " + PI);
        System.out.println("E: " + E);
    }
}


public class MoreInheritance {
    public static void main(String[] args) {

        //Create Shapes
        Shapes[] shapes = {
                new Circle("Red",5.0),
                new Rectangle("Blue", 4.0, 6.0),
                new Triangle("Green", 3.0, 4.0, 3.0, 4.0, 5.0)
        };

        System.out.println("=== SHAPE CALCULATOR ===");
        for (Shapes shape : shapes) {
            shape.displayInfo();
        }

        System.out.println("\n=== TOTALS ===");
        double totalArea = 0;
        double totalPerimeter = 0;
        for (Shapes shape : shapes) {
            totalArea += shape.calculateArea();
            totalPerimeter += shape.calculatePerimeter();
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
        System.out.printf("Total Perimeter: %.2f%n", totalPerimeter);

        System.out.println("\n=== MATH CONSTANTS ===");
        MathConstants.display();
    }
}
