package com.tirthal.learning.libfeatures.java.util.function.functions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// java.util.function.Function accepts one argument and produces a result

/**
* Sample code to demo syntax of Function functional interface usage in Java 8
* 
* @see https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
* @author tirthalp
*
*/
public class Ex_FunctionDemo {

	public static void main(String[] args) {		
		
		// ---> Example 1: simple usage 
		
		// Taking String as input argument and returning String as result
		Function<String, String> sayHello = s -> "Hello " + s;		
		System.out.println(sayHello.apply("Tirthal"));
		
		// Taking Integer as input argument and returning String as result
		Function<Integer, String> generateKey = i -> "Key"+i;
		System.out.println(generateKey.apply(100));
		
		// ---> Example 2: using with Comparator.comparing()
		List<String> fruits = Arrays.asList("oranges", "banana", "pineapple", "apple");
		
		Function<String, Integer> cmpByLength = s -> s.length();				
		Collections.sort(fruits, Comparator.comparing(cmpByLength));	// sort by String length		
		System.out.println(fruits);
						
		Collections.sort(fruits, Comparator.comparing(String::hashCode)); // sort by String hash code		
		System.out.println(fruits);	
		
		// ----> Example 3: Function to split line into words
		Function<String, Stream<String>> splitIntoWords = line -> Pattern.compile(" ").splitAsStream(line);
		
		splitIntoWords.apply("Hello World, how are you?")
					  .forEach(word -> System.out.print(word + " "));
		System.out.println();
		
		// Usage with flatMap
		Set<String> words = Stream.of(Stream.of("Hello how are you"), Stream.of("I am fine"), Stream.of("What about you")) 	// stream of stream of lines
								  .flatMap(Function.identity())												   				// stream of lines			  
								  .flatMap(splitIntoWords)													   				// stream of words								  
								  .collect(Collectors.toSet());												   				// unordered set of distinct words	
		System.out.println(words);
	}

}
