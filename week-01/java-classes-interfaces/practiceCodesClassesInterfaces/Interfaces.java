package com.java.classesInterfaces;

//1. Basic interfaces
interface Drawable{
    void draw();

    default void drawWithBorder() {
        System.out.println("--- Border ---");
        draw();
        System.out.println("--- Border ---");
    }
}

interface Resizable {
    void resize(double factor);
    double getSize();
}

interface Colorable {
    void setColor(String color);
    String getColor();
}

//2. Generic Interface

interface Storage<T> {
    void store (T item);
    T retrieve(int index);
    int count();
}

//3. Implement multiple interfaces
class Shape implements Drawable, Resizable, Colorable {
    private String name;
    private double size;
    private String color;

    public Shape(String name, double size, String color) {
        this.name = name;;
        this.size = size;
        this.color = color;
    }
    @Override
    public void draw() {
        System.out.println("Drawing " + color + " " +
                name + " (size: " + size + ")");
    }

    @Override
    public void resize(double factor) {
        size *= factor;
        System.out.println(name + " resized to: " + size);
    }

    @Override
    public double getSize() { return size; }

    @Override
    public void setColor(String color) { this.color = color;}

    @Override
    public String getColor() { return color; }
}

//4. Simple storage implementation
class NumberStorage implements Storage<Integer> {
    private int[] numbers = new int [10];
    private int count = 0;

    @Override
    public void store(Integer item) {
        if (count < numbers.length) {
            numbers[count ++] = item;
            System.out.println("Stored: " + item);
        }
    }

    @Override
    public Integer retrieve(int index) {
        return numbers[index];
    }

    @Override
    public int count() {return count;}
}

public class Interfaces {
    public static void main(String[] args) {

        //Multiple interfaces
        System.out.println("=== SHAPE DEMO ===");

        Shape circle = new Shape("Circle", 5.0, "Red");
        circle.draw();
        circle.drawWithBorder();
        circle.resize(2.0);
        circle.setColor("Blue");
        circle.draw();

        System.out.println();

        //Interface as reference type
        System.out.println("=== INTERFACE REFERENCES ===");
        Drawable d = new Shape("Square", 4.0, "Green");
        d.draw();
        d.drawWithBorder();

        Resizable r = new Shape("Triangle", 3.0, "Yellow");
        r.resize(1.5);
        System.out.println("Size: " + r.getSize());

        System.out.println();

        System.out.println("=== STORAGE DEMO ===");
        NumberStorage storage = new NumberStorage();
        storage.store(10);
        storage.store(20);
        storage.store(30);
        System.out.println("Count: " + storage.count());
        System.out.println("Index 1: " + storage.retrieve(1));
    }
}
