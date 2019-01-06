package com.tirthal.learning.libfeatures.misc;

import java.util.*;

/**
 * JEP 269: Convenience Factory Methods for Collections
 *
 * New static factory methods on the List, Set, and Map interfaces make it simpler
 * to create immutable instances of those collections
 */
public class CollectionFactoryMethodsDemo {

    public static void main(String[] args) {

        // --------------------------
        // Prior to Java 9 ---> Old ways
        // --------------------------

        // Too verbose
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");

        // Bit better, but only for List and no Set constructors
        colors = Arrays.asList("Red", "Blue");

        // --------------------------
        // Java 9 or later
        // --------------------------

        // New static factory methods on the List

        colors = List.of();
        System.out.println(colors.getClass());

        colors = List.of("Red", "Blue");
        System.out.println(colors.getClass());

        colors = List.of("Red", "Blue", "Black");
        System.out.println(colors.getClass());

        // New static factory methods on the Set

        Set<Integer> numbers = Set.of();
        System.out.println(numbers.getClass());

        numbers = Set.of(1, 2, 3);
        System.out.println(numbers.getClass());

        // New static factory methods on the Map

        Map<Integer, String> usersMap = Map.of();
        System.out.println(usersMap.getClass());

        usersMap = Map.of(1, "Tirthal", 2, "Ian");
        System.out.println(usersMap.getClass());

        usersMap = Map.ofEntries(Map.entry(1, "Tirthal"), Map.entry(2, "Ian"));
        System.out.println(usersMap.getClass());
    }
}
