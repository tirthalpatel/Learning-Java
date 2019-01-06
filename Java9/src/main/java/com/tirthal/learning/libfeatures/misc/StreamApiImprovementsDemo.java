package com.tirthal.learning.libfeatures.misc;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java 9 - added the four useful new methods to java.util.Stream interface.
 * (1) dropWhile (2) takeWhile (3) iterate (4) ofNullable
 */
public class StreamApiImprovementsDemo {

    public static void main(String[] args) {

        // ------------------
        // dropWhile() and takeWhile() default methods
        // Recommended to use with ordered streams (it behaves differently for Ordered and Unordered Streams)
        // ------------------

        // takeWhile() - returns longest prefix elements which matches the Predicate condition
        // dropWhile() - drops the longest prefix elements which matches the Predicate and returns the rest of elements

        // dropWhile() and takeWhile() demo with Ordered streams

        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .takeWhile(n -> n<5)
                .forEach(n -> System.out.print(n + ", "));

        System.out.println();

        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .dropWhile(n -> n<5)
                .forEach(n -> System.out.print(n + ", "));

        System.out.println();

        // dropWhile() and takeWhile() demo with Unordered streams

        Stream.of(3, 1, 5, 10, 4, 8, 6, 9, 7, 2)
                .takeWhile(n -> n<5)
                .forEach(n -> System.out.print(n + ", "));

        System.out.println();

        Stream.of(3, 1, 5, 10, 4, 8, 6, 9, 7, 2)
                .dropWhile(n -> n<5)
                .forEach(n -> System.out.print(n + ", "));

        System.out.println();

        // ------------------
        // iterate() static method
        // ------------------

        IntStream.iterate(1, i -> i <= 5, i -> i + 1)
                .forEach(n -> System.out.print(n + ", "));

        System.out.println();

        // ------------------
        // ofNullable() static method
        // ------------------

        // ofNullable() returns a sequential Stream containing a single element, if non-null, otherwise returns an empty Stream

        assert Stream.ofNullable("HelloWorld").count()==1 : "Should return a sequential Stream containing a single element, if non-null";
        assert Stream.ofNullable(null).count()==0 : "Should return an empty Stream, if null";
    }
}
