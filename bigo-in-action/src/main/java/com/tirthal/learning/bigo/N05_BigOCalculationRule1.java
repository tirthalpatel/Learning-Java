package com.tirthal.learning.bigo;

/**
 * To calculate Big O,
 *
 * Rule-1: Always care about worst case scenario
 */
public class N05_BigOCalculationRule1 {

    private static Boolean containsWord(String[] bagOfWords, String word) {

        var matchFound = Boolean.FALSE;

        /**
         * In this for loop, no of iterations in the loop would vary
         * depending on the location of "word" in the "bagOfWords".
         *
         * For example,
         *
         * [w0, w1, w2, w3, w5] - matching for "w0" would have the single iteration in the for-loop (best case)
         * [w1, w2, w0, w4, w5] - matching for "w0" would have the three iterations in the for-loop
         * [w1, w2, w3, w4, w0] - matching for "w0" would have the five iterations in the for-loop (worst case)
         * [w1, w2, w3, w4, w5] - matching for "w0" would have the five iterations in the for-loop (worst case)
         *
         * Does it mean, will Big O complexity vary depending on inputs condition?
         *
         * No... Rather we need to think about worst cast scenario, while calculating Big O.
         *
         * Considering worst case scenario, ultimately Big O for below for loop = O(N) | Order N | Linear Time Algorithm
         */
        for(var eachWord : bagOfWords) {

            if(eachWord.equals(word)) {
                matchFound = Boolean.TRUE;
                break;                      // If match found, break the loop and skip unnecessary iterations
            }
        }

        if(matchFound)
            System.out.printf("Match found for '%s' \n", word);
        else
            System.out.printf("No match found for '%s' \n", word);

        return matchFound;
    }

    public static void main(String[] args) {

        containsWord(generateWordsArray(100), "w0");
        containsWord(generateWordsArray(100), "w49");
        containsWord(generateWordsArray(100), "w99");
    }

    private static String[] generateWordsArray(int size) {
        var wordsArray = new String[size];

        for(int i=0; i<size; i++)
            wordsArray[i] = "w"+i;

        return wordsArray;
    }
}
