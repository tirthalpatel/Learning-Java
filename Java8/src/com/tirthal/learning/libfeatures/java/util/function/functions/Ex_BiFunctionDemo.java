package com.tirthal.learning.libfeatures.java.util.function.functions;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

// java.util.function.BiFunction accepts two arguments and produces a result

/**
* Sample code to demo syntax of BiFunction functional interface usage in Java 8
* 
* @see https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html
* @author tirthalp
*
*/
public class Ex_BiFunctionDemo {

	public static void main(String[] args) {		
		
		// Take List of String and Integer number, return another List String 		
		BiFunction<List<String>, Integer, List<String>> strBooster = (numbersList, echoFactor) -> {
			
			Objects.requireNonNull(numbersList);
			Objects.requireNonNull(echoFactor);
			
			List<String> l = numbersList.stream()
										  // Tip: Always better to move Lambda's in-line logic into separate method 
									     .map(s -> Ex_BiFunctionDemo.repeater(s, echoFactor)) 
										 .collect(Collectors.toList());
			return l;						
		};				
		
		// Try it				
		List<String> l = strBooster.apply(Arrays.asList("Hi", "Hello", "Ola"), 3);
		System.out.println(l);
		
		System.out.println(strBooster.apply(null, null)); // Oops, null not allowed
	}
	
	// Repeat each String from input List by given number of times
	private static String repeater(String input, Integer count) {
		
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= count; i++)
			sb.append(input + " ");
		return sb.toString();
	}
}
