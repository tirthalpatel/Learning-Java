package com.tirthal.learning.bigo;

/**
 * Getting started with Big O Calculation / An naive approach to calculate Big O
 */
public class N05_BigOCalculation {

    /*
     * How to calculate Big O notation for this function?
     *
     * Total of steps
     *  = O(1) + O(1) + O(1) + O(N) + O(N) + O(N) + O(N)
     *  = 1 + 1 + 1 + n + n + n + n
     *  = 3 + 4n
     *
     * It becomes Big O(3 + 4n).
     *
     * Ultimately, it's just O(n).
     */
    private static int foo(int input) {

        int a = 50;                         // O(1)
        a = a + 50;                         // O(1)

        for(int i=0; i<input; i++) {        // O(N)
            bar(i);                         // O(N)
            a++;                            // O(N)
            System.out.println(a);          // O(N)
        }
        return a;                           // O(1)
    }


    /*
     * How to calculate Big O notation for this function?
     *
     * It becomes Big O(4 + 9n).
     *
     * Ultimately, it's just O(n).
     */
    private static void bar(int input) {
        int a = 5;                          // O(1)
        int b = 10;                         // O(1)
        int c = 15;                         // O(1)

        for(int i = 0; i< input; i++) {     // O(N)
            int x = i + 1;                  // O(N)
            int y = i + 2;                  // O(N)
            int z = i + 3;                  // O(N)
            System.out.println(x+y+z);      // O(N)
        }

        for(int j = 0; j< input; j++) {     // O(N)
            int p = j * 5;                  // O(N)
            int q = j * 10;                 // O(N)
            System.out.println(p*q);        // O(N)
        }

        System.out.println(a+b+c);          // O(1)
    }

    // ------------------
    // Question = Do we really need step-by-step calculation for Big O complexity?
    // Answer = Not really, there is a rule book to simplify it.
    // ------------------


    public static void main(String[] args) {
        System.out.println("Calling foo()...");
        foo(5);
        System.out.println("Calling bar()...");
        bar(3);
    }
}
