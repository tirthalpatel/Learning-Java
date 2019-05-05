package com.tirthal.learning.bigo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * How to calculate Big O Space Complexity? --- It's similar to time cost calculation approach.
 * Look at total size relative to the size of the input and see how much new variables or memory
 * getting allocated or being used by the algorithm.
 *
 * What causes space complexity? --- Variables, Data structures, Function calls, Allocations.
 *
 * To calculate Space Complexity --- Don't think about space taken up by the input of the algorithm itself
 * or should not care about how big is the input of the algorithm itself. Rather the focus would be to see,
 * if are we adding any space requirement (e.g. new variable or data structure) within the algorithm?
 *
 * While implementing algorithm, always think what's more important - Space or Time?
 * B'cas improving on time complexity may need to compromise on space complexity, and vice versa.
 */
public class N06_BigOSpaceComplexity {

    /**
     * Space Complexity = O(1)
     *
     * B'cas no additional memory requirement.
     */
    private static void printHello(int noOfMsg) {
        for(int i=0; i<noOfMsg; i++) {
            System.out.println("Hello!");
        }
    }

    /**
     * Space Complexity = O(n)
     *
     * B'cas of additional memory requirement for list data structure variable
     */
    private static String repeatHello(int noOfTimes) {

        List<String> hello = new ArrayList<>(); // memory requirement increases with the higher input value

        for(int i=0; i<noOfTimes; i++) {
            hello.add("Hello");
        }

        return hello.stream().collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        printHello(3);
        System.out.println(repeatHello(5)+"!");
    }
}
