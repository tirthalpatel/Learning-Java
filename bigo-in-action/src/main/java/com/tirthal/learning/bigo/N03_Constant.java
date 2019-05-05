package com.tirthal.learning.bigo;

import java.util.Objects;

/**
 *  O(1) | Order 1 | Constant Time Algorithms = Takes a constant amount of time to run, irrespective of its input size
 */
public class N03_Constant {

    // How does the input size (e.g. bagOfWords) of this function's algorithm affect its running time?
    // Answer = O(1) Big O notation
    private static void printFirstItemInUppercase(String[] bagOfWords) {

        /*
         * Clearly, irrespective of inputs size (e.g. size of input array bagOfWords),
         * this piece of code takes a constant amount of time to run (executes constant operations).
         *
         * The operation would have constant performance, with small or any bigger
         * size of inputs (e.g. from hundreds to thousands or millions).
         *
         * That's O(1) = Order 1 / Constant Time Algorithm
         *
         * Here, it's O(1) + O(1) = O(2)
         *
         * Ultimately, O(1) / O(2) / O(3)... = Constant Time Algorithm
         */
        Objects.requireNonNull(bagOfWords);                 // O(1) - b'cas this instruction always runs once irrespective of input size
        System.out.println(bagOfWords[0].toUpperCase());    // O(1) - b'cas this instruction always runs once irrespective of input size
    }

    public static void main(String[] args) {

        System.out.println("Array with 1 item ---");
        printFirstItemInUppercase(generateWordsArray(1));

        System.out.println("Array with 100 item ---");
        printFirstItemInUppercase(generateWordsArray(10));

        System.out.println("Array with 1000 item ---");
        printFirstItemInUppercase(generateWordsArray(100000));
    }

    private static String[] generateWordsArray(int size) {
        var wordsArray = new String[size];

        for(int i=0; i<size; i++)
            wordsArray[i] = "w"+i;

        return wordsArray;
    }
}
