package com.java.collections;

import java.util.*;


public class ListPractice {
    public static void main(String[] args) {

        // 1. Basic List operations
        System.out.println("=== LIST OPERATIONS ===");
        List<String> students = new ArrayList<>();
        students.add("Quenedy");
        students.add("Ken");
        students.add("Mark");
        students.add("Ralph");
        students.add("Kate");

        System.out.println("Students: " + students);
        System.out.println("Size: " + students.size());
        System.out.println("Get index of 2: " + students.get(3));
        System.out.println("Index of Kate: " + +students.indexOf("Kate"));

        //Set/Replace
        students.set(0, "Quen Dev");
        System.out.println("After set: " + students);

        //Add index
        students.add(3, "Reynald");
        System.out.println("After insert: " + students);


        //Sublist
        System.out.println("Sublist(0,3) " + students.subList(0, 3));

        //Sorting
        System.out.println("\n=== SORTING ===");
        List<Integer> scores = new ArrayList<>(
                Arrays.asList(87, 88, 89, 97, 80));

        System.out.println("Original: " + scores);
        Collections.sort(scores);
        System.out.println("Ascending " + scores);
        Collections.sort(scores, Collections.reverseOrder());
        System.out.println("Descendint" + scores);

        //3. Utility method
        System.out.println("\n=== UTILITIES ===");
        System.out.println("Min: " + Collections.min(scores));
        System.out.println("Max:" + Collections.max(scores));

        List<String> techStack = new ArrayList<>(
                Arrays.asList("Java", "React", "Java",
                        "Spring", "Java", "React"));
        System.out.println("Java count: " + Collections.frequency(techStack, "Java"));
        System.out.println("React count: " + Collections.frequency(techStack, "React"));

        //4. ArrayList vs LinkedList
        System.out.println("\n=== ARRAYLIST VS LINKEDLIST ===");
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        arrayList.add("Fast Random Access");
        linkedList.add("Fast Insertion");

        //5. Array conversion
        System.out.println("\n=== ARRAY CONVERSION ===");
        String[] array = {"Java", "React", "Spring"};
        List<String> fromArray = new ArrayList<>(Arrays.asList(array));
        System.out.println("From array: " + fromArray);

        String[] backtoArray = fromArray.toArray(new String[0]);
        System.out.println("Back to array: " + Arrays.toString(backtoArray));







    }
}
