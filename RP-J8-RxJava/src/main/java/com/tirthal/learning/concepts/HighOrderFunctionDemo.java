package com.tirthal.learning.concepts;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * High Order Functions = A function that can return a function and has ability of lazy execution
 * 
 * @author tirthalp
 *
 */
public class HighOrderFunctionDemo {

	public static void main(String[] args) {
		
		Supplier<String> tranformOperation = createConcatAndTransform("Hello", "World!", (s) -> s.toUpperCase());

		System.out.println("Before execution");
		System.out.println(tranformOperation.get()); // Execution of high order function
		System.out.println("After execution");
		
	}

	// This is high order function 
	public static Supplier<String> createConcatAndTransform(final String s1, final String s2, 
			Function<String, String> stringTransform) {
		
		// Returns function / lambda expression
		return () -> {
			
			String st1 = s1;
			String st2 = s2;
			
			if(stringTransform != null) {
				st1 = stringTransform.apply(s1);
				st2 = stringTransform.apply(s2);
			}
			
			return st1 + " " + st2;
		};
	}
}
