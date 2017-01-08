package com.tirthal.learning.libfeatures.java.util.function.predicates;

import java.util.function.Predicate;
import java.util.stream.IntStream;

// java.util.function.Predicate represents a predicate (boolean-valued function) of one argument

/**
* Sample code to demo syntax of Predicate functional interface usage in Java 8
* 
* @see https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
* @author tirthalp
*
*/
public class Ex_PredicateDemo {

	public static void main(String[] args) {		

		// Example usage of Predicate
		Predicate<String> isGtFive = s -> s.length() > 5;
		Predicate<String> isLtTwenty = s -> s.length() < 20;
		Predicate<String> isBetweenFiveAndTwenty = isGtFive.and(isLtTwenty);
		
		System.out.printf("Is '%s' greater than 5? - %s \n", "Hello", isGtFive.test("Hello"));
		System.out.printf("Is '%s' not greater than 5? - %s \n", "Hello", isGtFive.negate().test("Hello"));
		System.out.printf("Is '%s' less than 20? - %s \n", "Hello", isLtTwenty.test("Hello"));
		System.out.printf("Is '%s' greater than 5 and less than 20? - %s \n", "Hello World", isBetweenFiveAndTwenty.test("Hello World"));
		
		// Usage of Predicate to filter Stream
		System.out.print("Even numbers in 1 to 10 = ");
		IntStream.range(1, 11)
				 .filter(n -> n%2==0) // Predicate to filter even numbers
				 .mapToObj(n -> n + " ")
				 .forEach(System.out::print);
	}
}
