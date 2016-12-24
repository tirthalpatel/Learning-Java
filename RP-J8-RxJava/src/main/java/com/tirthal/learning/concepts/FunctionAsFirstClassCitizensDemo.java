package com.tirthal.learning.concepts;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Functions as First Class Citizen = The ability to store a function as a variable and pass that function as a parameter
 * 
 * @author tirthalp
 *
 */
public class FunctionAsFirstClassCitizensDemo {

	public static void main(String[] args) {
		
		// Example 1 - Assigning lambda expression as a function in a variable and calling directly from variable
		BiFunction<String, String, String> concatFunction = (s1, s2) -> s1 + " " + s2;
		System.out.println(concatFunction.apply("Hello", "World!"));
		
		// Example 2 - Storing static method (which conforms method signature of BiFunction) in a variable and then invoking it
		concatFunction = FunctionAsFirstClassCitizensDemo::concatStrings;
		System.out.println(concatFunction.apply("Hello", "World!"));
		
		// Example 3 - Storing instance method (which conforms method signature of BiFunction) in a variable and then invoking it 
		FunctionAsFirstClassCitizensDemo instance = new FunctionAsFirstClassCitizensDemo();
		concatFunction = instance::concatStringsAnother;
		System.out.println(concatFunction.apply("Hello", "World!"));
		
		// Example 4 - Passing function as a parameter
		
		// passing lambda directly
		System.out.println(concatAndTransform("Hello", "World!", (s) -> s.toUpperCase())); 
		
		// passing from a variable
		Function<String, String> transformToLower = (s) -> s.toLowerCase();
		System.out.println(concatAndTransform("Hello", "World!", transformToLower));
		
	}

	// Static method
	private static String concatStrings(String s1, String s2) {
		return s1 + " " + s2;
	}
	
	// Instance method
	String concatStringsAnother(String s1, String s2) {
		return s1 + " " + s2;
	}
	
	// Method taking function as an input parameter
	private static String concatAndTransform(String s1, String s2, Function<String, String> stringTransform) {
		if(stringTransform != null) {
			s1 = stringTransform.apply(s1);
			s2 = stringTransform.apply(s2);
		}
		
		return s1 + " " + s2;
	}
}
