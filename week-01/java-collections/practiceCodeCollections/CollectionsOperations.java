package com.java.collections;
import java.util.*;

public class CollectionOperations {
    public static void main(String[] args) {
        //1. Collections utility methods
        System.out.println("=== COLLECTIONS UTILITY ===");
        List<Integer> scores = new ArrayList<>(
                Arrays.asList(85, 92, 78, 96, 88, 71));

        System.out.println("Original: " + scores);
        System.out.println("Min: " + Collections.min(scores));
        System.out.println("Max: " + Collections.max(scores));

        Collections.sort(scores);
        System.out.println("Sorted:" + scores);

        Collections.shuffle(scores);
        System.out.println("Shuffled" + scores);

        //AddAll
        List<String> stack = new ArrayList<>();
        Collections.addAll(stack, "Java", "Spring",
                "React", "TypeScript");
        System.out.println("Stack:" + stack);

        //2. Factory Methods
        System.out.println("\n=== FACTORY METHODS ===");
        List<String> immutableList = List.of("Java",
                "Spring", "React");
        Set<String> immutableSet = Set.of("Java",
                "Spring", "React");

        Map<String, Integer> immutableMap = Map.of("Java", 95,
                "Spring", 88,
                "React", 92
        );
        System.out.println("List: " + immutableList);
        System.out.println("Set: " + immutableSet);
        System.out.println("Map: " + immutableMap);

        //3. Immutable vs Mutable
        System.out.println("\n=== IMMUTABLE VS MUTABLE ===");
        List<String> mutable = new ArrayList<>(immutableList);
        mutable.add("Docker");
        System.out.println("Mutable: " + mutable);

        //Try modifying immutable list
        try {
        immutableList.add("Docker");
    } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable list!");
        }

        //4. Unmodifiable
        System.out.println("\n=== UNMODIFIABLE ===");
        List<String> original = new ArrayList<>(
                Arrays.asList("Java", "Spring", "React"));
        List<String> readOnly = Collections.unmodifiableList(original);
        System.out.println("ReadOnly: " + readOnly);

        original.add("Docker");// modifes original
        System.out.println("After original change: " + readOnly);

        try {
            readOnly.add("Angular"); // error
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify read-only view!");

            //5. copyOf
            System.out.println("\n=== COPY OF ===");
            List<String> source = new ArrayList<>(
                    Arrays.asList("Java", "Spring"));
            List<String> copy = List.copyOf(source);

            source.add("React");
            System.out.println("Source: " + source);
            System.out.println("Copy: " + copy);
        }
    }
}