package com.tirthal.learning.bigo;

import java.time.LocalTime;

/**
 * Good code = Readable and Scalable Code
 *
 * Scalable code = Think about (1) Speed (i.e. time complexity) (2) Memory (i.e. space complexity)
 *
 * How to measure, if is it "scalable code"? Well, think about Big O notation
 *
 * Big O notation is a common language
 *    - To determine that how long an given algorithm takes to run (irrespective of cpu of machine, programming language used or other dynamic parameters)
 *    - To compare two algorithms from code scalability or space requirement standpoint
 *    - To analyse algorithmic efficiency (i.e. how much the algorithm slows down / how much more operations the algorithm needs to perform, when inputs become bigger and bigger...)
 */
public class N01_WhyBigO {

    /*
     * For any algorithm / function / piece of code (e.g. containsWord):
     *      How to measure an efficiency of code (in terms of space and time complexity)?
     *      How to determine - Is it good or bad code from efficiency standpoint? Is it "scalable code"?
     */
    private static Boolean containsWord(String[] bagOfWords, String word) {

        var startTime = LocalTime.now();

        var matchFound = Boolean.FALSE;

        for(var eachWord : bagOfWords) {

            if(eachWord.equals(word)) {
                matchFound = Boolean.TRUE;
                break;
            }
        }

        if(matchFound)
            System.out.printf("Match found for '%s' \n", word);
        else
            System.out.printf("No match found for '%s' \n", word);

        var endTime = LocalTime.now();

        /*
         * If we measure execution time of code in terms of milliseconds, then on everyone's machine
         * this code can take different execution time depending on cpu, programming language used and other parameters.
         *
         * In fact, on each run, it can take different execution time on same machine too!
         */
        System.out.println("Algorithm took '%d' milliseconds for executing code instructions: " + (endTime.minusNanos(startTime.getNano()).getNano())/1000000);

        // Need better approach or standard mechanism to determine algorithmic efficiency, so use Big O notation.

        return matchFound;
    }

    public static void main(String[] args) {

        // With increased inputs (e.g. size of words array / bagOfWords), the function becomes slower, slower and slower!
        // At some stage, it can take few seconds or may even throw out-of-memory exception!

        containsWord(generateWordsArray(1), "w0");
        containsWord(generateWordsArray(100), "w99");
        containsWord(generateWordsArray(10000), "w9999");
        containsWord(generateWordsArray(1000000), "w999999");
        containsWord(generateWordsArray(10000000), "w9999999");
        containsWord(generateWordsArray(100000000), "w99999999");
    }

    private static String[] generateWordsArray(int size) {
        var wordsArray = new String[size];

        for(int i=0; i<size; i++)
            wordsArray[i] = "w"+i;

        return wordsArray;
    }
}
