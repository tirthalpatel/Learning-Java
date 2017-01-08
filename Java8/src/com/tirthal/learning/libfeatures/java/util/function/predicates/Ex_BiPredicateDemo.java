package com.tirthal.learning.libfeatures.java.util.function.predicates;

import java.util.function.BiPredicate;

// java.util.function.BiPredicate represents a predicate (boolean-valued function) of two arguments, which is the two-arity specialization of Predicate

/**
* Sample code to demo syntax of BiPredicate functional interface usage in Java 8
* 
* @see https://docs.oracle.com/javase/8/docs/api/java/util/function/BiPredicate.html
* @author tirthalp
*
*/
public class Ex_BiPredicateDemo {

	public static void main(String[] args) {		
		// Example usage of BiPredicate
		BiPredicate<String, Integer> gt = (s, n) -> s.length() > n;
		BiPredicate<String, Integer> lt = (s, n) -> s.length() < n;
		
		System.out.printf("Is '%s' greater than %d? - %s \n", "Hello", 5, gt.test("Hello", 5));
		System.out.printf("Is '%s' not greater than %d? - %s \n", "Hello", 5, gt.negate().test("Hello", 5));
		System.out.printf("Is '%s' less than %d? - %s \n", "Hello", 20, lt.test("Hello", 20));		
	}
}
