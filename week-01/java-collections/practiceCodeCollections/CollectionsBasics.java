package com.java.collections;

import java.util.*;


public class CollectionsBasics {
    public static void main(String[] args) {

        //Create Collections
        List<String> techStack = new ArrayList<>();

        //Add elements
        techStack.add("Java");
        techStack.add("Spring");
        techStack.add("React");
        techStack.add("TypeScript");
        techStack.add("Git");

        //Basic Operation
        System.out.println("Stack: " + techStack);
        System.out.println("Size: " + techStack.size());
        System.out.println("Empty?: " + techStack.isEmpty());
        System.out.println("Has Git?: " + techStack.contains("Git"));

        //Remove
        techStack.remove("Git");
        System.out.println("After remove: " + techStack);

        //Iterator - safe removal
        System.out.println("\n=== ITERATOR DEMO ===");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(15);
        numbers.add(25);
        numbers.add(10);
        numbers.add(30);

                    Iterator<Integer> iterator = numbers.iterator();
                    while (iterator.hasNext()) {
                        int num = iterator.next();
                        if (num > 20) {
                            iterator.remove();
                        }
                    }
        System.out.println("Numbers > 20 removed: " + numbers);

        //Bulk operation
        System.out.println("\n=== BULK OPERATIONS ===");
        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        List<String> list2 = new ArrayList<>(Arrays.asList("B", "D"));

        System.out.println("Original:" + list1);
        list1.removeAll(list2);
        System.out.println("After removeAll: " + list1);
        list1.addAll(list2);
        System.out.println("After addAll: " + list1);
        list1.retainAll(list2);
        System.out.println("After retainAll: " + list1);



    }
}
