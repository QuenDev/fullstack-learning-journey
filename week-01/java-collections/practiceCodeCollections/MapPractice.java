package com.java.collections;
import java.util.*;

public class MapPractice {
    public static void main(String[] args) {
        //1.
        System.out.println("=== BASIC MAP ===");
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Quenedy", 95);
        studentScores.put("Ken", 87);
        studentScores.put("Mark", 92);
        studentScores.put("Ralph", 78);
        studentScores.put("Kate", 96);

        System.out.println("All scores: " + studentScores);
        System.out.println("Quenedy's scores: " + studentScores.get("Quenedy"));
        System.out.println("Unknown score: " + studentScores.getOrDefault("Nobody", 0));
        System.out.println("Has Ken? " +
                studentScores.containsKey("Ken"));
        System.out.println("Size: " + studentScores.size());

        studentScores.put("Ken", 99);
        System.out.println("Ken updated: " + studentScores.get("Ken"));

        //2. Iterating
        System.out.println("\n=== ITERATING ===");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            {
                System.out.printf("%-10s → %d%n", entry.getKey(), entry.getValue());
            }
        }

        //3. TreeMap - sorted!
        System.out.println("\n=== TREEMAP (SORTED) ===");
        Map<String, Integer> sorted = new TreeMap<>(studentScores);
        for(Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() +
                    ": " + entry.getValue());
}

    // 4. Word frequency counter
        System.out.println("\n=== WORD FREQUENCY ===");
        String[] words = {"java", "is", "great",
                "java", "is", "java", "fun"};
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word counts: " + wordCount);

        // 5. Find highest score using map
        System.out.println("\n=== HIGHEST SCORE ===");
        String topStudent = "";
        int highScore = 0;

        for(Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            if(entry.getValue() > highScore) {
                highScore = entry.getValue();
                topStudent = entry.getKey();
            }
        }

        System.out.println("Top: " + topStudent +
                " with " + highScore);

    }
}