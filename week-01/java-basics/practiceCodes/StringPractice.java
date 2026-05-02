package com.java.basics;

public class StringPractice {

    public static void main(String[] args) {

        //1. Basic string
        String name = "Quenedy Pabular";
        System.out.println("Name: " + name);
        System.out.println("Length: " + name.length());
        System.out.println("LowerCase: " + name.toLowerCase());
        System.out.println("UpperCase: " + name.toUpperCase());

        //2. String methods
        System.out.println("Contains 'Quen': " + name.contains("Quen"));
        System.out.println("Replace: " + name.replace("Pabular", "Dev"));
        System.out.println("Substring: " + name.substring(8, 15)); //0 based index start is included end is not included
        System.out.println("CharAt :" + name.charAt(14)); // zero base index also

        //3. String equality
        String a = "Pabular";
        String b = "Pabular";
        System.out.println("== :" + (a == b)); //compartes memory address not content
        System.out.println("equals: " + a.equals(b)); //check actual letters/content

        //4. Split
        String techStack = " Java, Spring, React, Typescript";
        String[] splitTechStack = techStack.split(",");
        for (String techStacks : splitTechStack) {
            System.out.println("Tech Stack: " + techStacks.trim());
        }

        //5. StringBuilder
        StringBuilder passion = new StringBuilder();
        passion.append("I am ");
        passion.append("Quenedy. ");
        passion.append("I will be a distinguished software engineer someday");
        System.out.print(passion.toString());

    }
}
