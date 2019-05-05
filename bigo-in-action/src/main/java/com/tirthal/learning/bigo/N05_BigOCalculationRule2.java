package com.tirthal.learning.bigo;

import java.util.Objects;

/**
 * To calculate Big O,
 *
 * Rule-2: Remove the constants
 */
public class N05_BigOCalculationRule2 {

    /**
     * Here, Big O for time complexity = Total step = O(1 + 1 + 100 + 1 + n + 1 + n + 1) = O(2n + 105).
     *
     * When there will be large input array (e.g. containing 100000000 elements),
     * the performance impact of constant 105 iterations can be trivial.
     *
     * Likewise, constant multiplication factor 2 can be also ignored, as time to run grows directly
     * proportional to the size of its inputs anyway. It'll remain linear for worst case even if
     * multiplication factor is removed (i.e. if consider just n instead of 2n).
     *
     * So, if we remove the constants, Big O for time complexity = O(n) = Linear Time Algorithm.
     */
    private static void iterateLoopAndPrintMsg(String[] bagOfWords) {

        Objects.requireNonNull(bagOfWords);             // O(1)

        String message = null;                          // O(1)

        // Constant loop with 100 iterations
        for(int i=0; i<100; i++) {                      // O(100)
            message = "Hello Foo!";
        }
        System.out.println(message);                    // O(1)

        // N iterations depending on bagOfWords input array size
        for(int i=0; i<(bagOfWords.length); i++) {      // O(n)
            message = bagOfWords[i].toUpperCase();
        }
        System.out.println(message);                    // O(1)

        // N iterations depending on bagOfWords input array size
        for(int i=0; i<bagOfWords.length; i++) {        // O(n)
            message = bagOfWords[i].toLowerCase();
        }
        System.out.println(message);                    // O(1)
    }

    public static void main(String[] args) {

        iterateLoopAndPrintMsg(generateWordsArray(10));
        iterateLoopAndPrintMsg(generateWordsArray(7));
        iterateLoopAndPrintMsg(generateWordsArray(1000));
        iterateLoopAndPrintMsg(generateWordsArray(1000000));
    }

    private static String[] generateWordsArray(int size) {
        var wordsArray = new String[size];

        for(int i=0; i<size; i++)
            wordsArray[i] = "w"+i;

        return wordsArray;
    }
}
