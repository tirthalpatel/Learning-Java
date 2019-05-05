package com.tirthal.learning.bigo;

/**
 * O(N) | Order N | Linear Time Algorithms = Time to run / algorithmic complexity grows directly proportional to its input size
 */
public class N02_Linear {

    // How does this input size (e.g. bagOfWords) of this function's algorithm affect its running time?
    // Answer = O(N) Big O notation
    private static void printInUppercase(String[] bagOfWords) {

        /*
         * With the increased inputs size (i.e. no of elements in array), the no of operations would increase linearly.
         *
         * e.g., loop with 1 or 10 or 100 array items would perform quite well, but loop with thousands of items may take some time.
         *
         * How many times does below for loop run? N times (i.e. size of input array), of course!
         * We don’t know exactly how long it will take for this to run, and we don’t worry about that anyway.
         *
         * What we do know is that the simple algorithm presented here will grow its execution time linearly with the increase in size of its input.
         * That's O(N) = Order N / Linear Time Algorithm.
         */
        for(var eachWord : bagOfWords) {                // O(N) - b'cas this instruction runs N times depending on input size
            System.out.println(eachWord.toUpperCase()); // O(N) - b'cas this instruction runs N times depending on input size
        }
    }

    public static void main(String[] args) {

        System.out.println("Array with 1 item ---");
        printInUppercase(generateWordsArray(1));

        System.out.println("Array with 100 item ---");
        printInUppercase(generateWordsArray(10));

        System.out.println("Array with 1000 item ---");
        printInUppercase(generateWordsArray(100000));
    }

    private static String[] generateWordsArray(int size) {
        var wordsArray = new String[size];

        for(int i=0; i<size; i++)
            wordsArray[i] = "w"+i;

        return wordsArray;
    }
}
