package com.tirthal.learning.libfeatures.java.other;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Usage of Optional<T>
 * 
 * <p>
 * A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true
 * and get() will return the value.
 * 
 * This is a value-based class; use of identity-sensitive operations (including reference equality (==), identity hash
 * code, or synchronization) on instances of Optional may have unpredictable results and should be avoided.
 * </p>
 * 
 * @author tirthalp
 */
public class OptionalDemo {

	public static void main(String[] args) {
		
		// Java 7 or Prior - Method may throw, but cannot enforce caller for Null check and may result in NullPointerException
		if(mayReturnNullString()!=null)
			System.out.println("Without null check, this may throw NullPointerException" + mayReturnNullString().length());
		else
			System.out.println("This is old way to deal with null value, in Java 7 or prior. ");
		
		// Java 8 Optional<T> - caller of the method is explicitly forced by the type system to think about the possibility of null value		
		System.out.println("If value doesn't present, return value from 'orElse': " + tryOptional(null).orElse("Hello World"));		
		System.out.println("If value presents, return it: " + tryOptional("Bye World").orElse("Hello World"));
		
		// Another example of Optional
		System.out.println("Square root of -10 (negative number) is:" + sqrt(-10d));
		System.out.println("Square root of zero is:" + sqrt(0d));
		System.out.println("Square root of 10 (positive number) is:" + sqrt(10d));
				
		// Usage of OptionalInt with Stream's terminal operation
		final OptionalInt randomEvenNumber = getRandomEvenNumber(1, 100);
		if(randomEvenNumber.isPresent())
			System.out.println(randomEvenNumber.getAsInt() + " - Awesome, this is your lucky even number");
		else
			System.out.println(randomEvenNumber + " - Oops, you didn't get even number this time. Try again. ");									
	}
	
	private static String mayReturnNullString() {
		return null;
	}
	
	private static Optional<String> tryOptional(String input) {
				
		// Optional.of(input); // Here, input must be non-null value, otherwise will throw NullPointerException 				
		
		return Optional.ofNullable(input); // Here, if null value, will return empty Optional, i.e. Optional.empty()
	}
	
	private static OptionalInt getRandomEvenNumber(int randomNumberOrigin, int randomNumberBound) {

		return ThreadLocalRandom.current().ints(1, randomNumberOrigin, randomNumberBound)
										  .filter(n -> n%2==0)
										  .max();	
	}
	
	private static Optional<Double> sqrt(Double d) {
		
		return d > 0d ? Optional.of(Math.sqrt(d)) : Optional.empty();
	}
}
