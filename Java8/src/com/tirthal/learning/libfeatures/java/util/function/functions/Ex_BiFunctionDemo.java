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

	// Take List of String and Integer number, return another List String 		
	public static BiFunction<List<String>, Integer, List<String>> strBooster = (strList, echoFactor) -> {
				
		Objects.requireNonNull(strList);
		Objects.requireNonNull(echoFactor);
		
		List<String> l = strList.stream()									   								
								.map(s -> repeater(s, echoFactor))
								.collect(Collectors.toList());
		return l;						
	};
	
	// Repeat each String from input List by given number of times
	private static String repeater(String input, Integer count) {
		
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= count; i++)
			sb.append(input + " ");
		return sb.toString();
	}
		
	public static void main(String[] args) {											
		try {
			List<String> l = strBooster.apply(Arrays.asList("Hi", "Hello", "Ola"), 3);
			System.out.println(l);

			System.out.println(strBooster.apply(null, null)); // Oops, null not allowed
		} catch (NullPointerException e) {
			System.out.print("Oops, null arguments are not allowed");
		}
	}	
}
