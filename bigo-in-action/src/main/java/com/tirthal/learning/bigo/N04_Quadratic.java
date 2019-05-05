package com.tirthal.learning.bigo;

/**
 * O(N^2) | Quadratic Time Algorithm = Time to run grows quadratically as its input size grows
 *
 * Polynomial Time Algorithms = O(n^p)
 *  - The term polynomial is a general term which contains quadratic (n^2), cubic (n^3), quartic (n^4), etc. functions.
 *  - n^2 = two nested loops
 *  - n^3 = three nested loops
 *  - n^4 = four nested loops
 *  - ...
 *  - What’s important to know is that O(n^2) is faster than O(n^3) which is faster than O(n^4), etc.
 */
public class N04_Quadratic {

    // How does the input size (e.g. "t") of this function's algorithm affect its running time?
    // Answer = O(n^2) Big O notation
    private static <T> void printAllPairsOfArray(T[] t) {

        /*
         * A loop within loop / Two nested loop = use multiplication for Big O calculation
         *
         * So, it becomes O(n * n) = O(n^2)
         *
         * That means, in case of,
         *  n = 1 element, then total operations = 1
         *  n = 2 elements, then total operations = 4
         *  n = 3 elements, then total operations = 9
         *  n = 5 elements, then total operations = 25
         *  n = 100 elements, then total operations = 100*100 = 10000
         *  n = 1000 elements, then total operations = 1000*1000 = 1000000
         *  ...
         */
        for(int i=0; i < t.length; i++) {                   // O(n)
            for(int j=0; j < t.length; j++) {               // O(n)
                System.out.println(t[i] + " : " + t[j]);    // O(1) - just ignore constant for Big O calculation
            }
        }

        // Note: if we were to nest another for loop in above (i.e. three nested loops), it would become an O(n * n * n ) | O(n^3) algorithm
    }

    public static void main(String[] args) {

        String[] vowelsInEnglish = {"a", "e", "i", "o", "u"};
        printAllPairsOfArray(vowelsInEnglish);
    }
}
