package com.java.classesInterfaces;

class Person {
    //Private fields
    private String name;
    private int age;
    private boolean active;

    //Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.active = true;
    }
    //Getters
    public String getName(){ return name; }
    public int getAge(){ return age; }
    public boolean isActive(){ return active; }

    //Setters with validation
    public void setName( String name ) {
        if(name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        }
    }

    // Method
    public void introduce() {
        System.out.println("Hi! I'm " + name +
                ", " + age + " years old");
    }
}

public class ClassesAndObjects {
    public static void main(String[] args) {

        //Create objects
        Person s1 = new Person("Ken", 23);
        Person s2 = new Person("Ralph", 23);

        s1.introduce();
        s2.introduce();

        //Getters
        System.out.println("Name: " + s1.getName());
        System.out.println("Age: " + s1.getAge());
        System.out.println("Active: " + s1.isActive());

        System.out.println();

        //Setters
        s1.setName("Ken dev");
        s1.setAge(44);
        s1.introduce();

        // Multiple references - same object!
        Person reference = s1;
        reference.setName("Modified Name");
        System.out.println("S1 name: " + s1.getName()); // also modified!
        System.out.println("reference name: " + reference.getName());

        // Null reference
        Person nobody = null;
        if (nobody != null) {
            nobody.introduce();
        } else {
            System.out.println("Person is null - no object!");
        }
    }

}
