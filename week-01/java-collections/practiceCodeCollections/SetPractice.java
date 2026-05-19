package com.java.collections;
import java.util.*;


public class SetPractice {
    public static void main(String[] args) {

        //1. Basic HashSet
        System.out.println("=== HASHSET BASICS ===");
        Set<String> techStack = new HashSet<>();
        techStack.add("Java");
        techStack.add("Spring");
        techStack.add("React");
        techStack.add("TypeScript");
        techStack.add("Java"); // duplicate - ignored!
        techStack.add("React"); // duplicate - ignored!


        System.out.println("Stack: " + techStack);
        System.out.println("Size: " + techStack.size()); // 4 not 6!
        System.out.println("Has Java? " + techStack.contains("Java"));
        System.out.println("Has Python? " + techStack.contains("Python"));

        System.out.println("\n=== TREESET (SORTED) ===");
        Set<String> sorted = new TreeSet<>(techStack);
        System.out.println("Sorted: " + sorted);

        //2. Tree set ordered
        Set<Integer> sortedNumbers = new TreeSet<>();
        sortedNumbers.add(5);
        sortedNumbers.add(2);
        sortedNumbers.add(8);
        sortedNumbers.add(1);
        sortedNumbers.add(9);
        System.out.println("Sorted numbers: " + sortedNumbers);

        //3, Remove duplicated from list using Sets
        System.out.println("\n=== REMOVE DUPLICATES ===");
        List<String> withDuplicates = new ArrayList<>(
                Arrays.asList("Java", "React", "Java",
                        "Spring", "React", "Java"));
        System.out.println("With duplicates: " + withDuplicates);

        Set<String> unique = new HashSet<>(withDuplicates);
        System.out.println("Unique only: " + unique);

        //Union
        Set<String> mySkills = new HashSet<>(
                Arrays.asList("Java", "Spring", "React",
                        "SQL", "Git"));
        Set<String> jobRequirements = new HashSet<>(
                Arrays.asList("Java", "React", "Docker",
                        "SQL", "AWS"));

        Set<String> union = new HashSet<>(mySkills);
        union.addAll(jobRequirements);
        System.out.println("Union: " + union);

        //Intersection - skills that i have that job needs!
        Set<String> intersection = new HashSet<>(mySkills);
        intersection.retainAll(jobRequirements);
        System.out.println("I matched: " + intersection);

        //Difference - skills job needs that i dont have
        Set<String> missing = new HashSet<>(jobRequirements);
        missing.removeAll(mySkills);
        System.out.println("I need to learn: " + missing);

        //5. Codility pattern - find duplicates!
        System.out.println("\n=== FIND DUPLICATES ===");
        int[] numbers = {1, 3, 4, 2, 2, 3, 1};
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : numbers) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("Seen: " + seen);
        System.out.println("Duplicates: " + duplicates);

        //6. Codility pattern - smallest missing positive!
        System.out.println("\n=== SMALLEST MISSING POSITIVE ===");
        int[] arr = {1, 3, 6, 4, 1, 2};
        Set<Integer> numSet = new HashSet<>();
        for (int n : arr) {
            if (n > 0) numSet.add(n);
        }
            int smallest = 1;
            while(numSet.contains(smallest)) {
                smallest++;
            }
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Smallest missing: " + smallest);
        }
}


