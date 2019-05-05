package com.tirthal.learning.bigo;

/**
 * To calculate Big O,
 *
 * Rule-4: Drop non dominants
 */
public class N05_BigOCalculationRule4 {

    /**
     * Here, Big O for time complexity is NOT O(n + n^2), if we remove constants as per {@link N05_BigOCalculationRule2}.
     *
     * B'cas O(n) becomes insignificant over O(n^2), when it comes to really large input term (i.e. worst case scenario).
     *
     * For example, in case of,
     *      n = 5 ===>  O(n) = 5 and O(n^2) = 25
     *      n = 100 ===>  O(n) = 100 and O(n^2) = 10000
     *      n = 5000 ===>  O(n) = 5000 and O(n^2) = 25000000
     *      ...
     *
     * Considering worst case scenario as per {@link N05_BigOCalculationRule1},
     * the O(n) becomes non dominant compare to O(n^2) and it can be dropped ultimately.
     *
     * Thus, if we drop the non dominant term O(n) from Big O(n + n^2), then here
     *
     * Big O for time complexity = O(n^2).
     */
    private static <T extends Number> void printAllNumbersThenAllPairSums(T[] t) {

        System.out.println("The numbers are:");
        for(int i=0; i < t.length; i++) {       // Big O of the for loop = O(n)
            System.out.println(t[i]);
        }

        System.out.println("The sum of casted integer numbers are:");
        for(int i=0; i < t.length; i++) {       // Big O of the two nested for loops = O(n^2)
            for(int j=0; j < t.length; j++) {
                System.out.println(t[i].intValue() + t[j].intValue());
            }
        }
    }

    public static void main(String[] args) {
        Number[] randomNumbers = {2.0f, 5, 10.50d, 3, 9};
        printAllNumbersThenAllPairSums(randomNumbers);
    }
}
