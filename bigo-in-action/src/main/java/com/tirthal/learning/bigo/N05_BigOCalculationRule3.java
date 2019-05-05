package com.tirthal.learning.bigo;

import java.util.Objects;

/**
 * To calculate Big O,
 *
 * Rule-3: Different terms for inputs
 *
 * @see N05_BigOCalculationRule2
 */
public class N05_BigOCalculationRule3 {

    /**
     * Here, Big O for time complexity is NOT O(n), if we remove constants as per {@link N05_BigOCalculationRule2}.
     *
     * B'cas number of iterations of both "for" loops is subject to vary depending on discrete inputs (i.e. bagOfWords1 and bagOfWords2).
     * As a result, different terms need to be used in Big O notation for different inputs.
     *
     * Another thumb rule = If two separate loops (one loop after another), always go for "addition". If nested loop (one loop inside another), always go for multiplication.
     *
     * Considering different terms for each input (e.g. "n" iterations for "bagOfWords1" and "m" iterations for "bagOfWords2"),
     * removing constants and considering worst case scenario, here
     *
     * Big O for time complexity = O(n + m).
     */
    private static void iterateLoopAndPrintMsg(String[] bagOfWords1, String[] bagOfWords2) {

        Objects.requireNonNull(bagOfWords1);            // O(1)
        Objects.requireNonNull(bagOfWords2);            // O(1)
        String message = null;                          // O(1)

        // N iterations depending on bagOfWords1 input array size
        for(int i=0; i<(bagOfWords1.length); i++) {     // O(n)
            message = bagOfWords1[i].toUpperCase();
        }
        System.out.println(message);                    // O(1)

        // M iterations depending on bagOfWords2 input array size
        for(int i=0; i<bagOfWords2.length; i++) {       // O(m)
            message = bagOfWords2[i].toLowerCase();
        }
        System.out.println(message);                    // O(1)
    }

    public static void main(String[] args) {

        iterateLoopAndPrintMsg(generateWordsArray(10), generateWordsArray(10));
        iterateLoopAndPrintMsg(generateWordsArray(100), generateWordsArray(1000000));
        iterateLoopAndPrintMsg(generateWordsArray(1000000), generateWordsArray(100));
    }

    private static String[] generateWordsArray(int size) {
        var wordsArray = new String[size];

        for(int i=0; i<size; i++)
            wordsArray[i] = "w"+i;

        return wordsArray;
    }
}
