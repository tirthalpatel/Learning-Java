package com.tirthal.learning.libfeatures.java.util.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world example to demo usage of Stream!
 * 
 * @author tirthalp
 */
public class Ex01_StreamHelloWorld {

	public static void main(String[] args) {
		
		// There are different ways to obtain stream - Trying static factory method of the Stream class				
		Stream<String> hwStream = Stream.of("one", "two", "hello", "three", "world", "four");
		
		System.out.println("Original Stream - " + hwStream);
		
		List<String> hwFilteredList = hwStream.	// a standard declarative assignment statement and an example of a data source
				filter(e -> (e.equalsIgnoreCase("hello") || e.equalsIgnoreCase("World"))). // an example of an intermediate operation
				collect(Collectors.toList()); // an example of a terminal operation		
						
		System.out.println("Hello World Filtered List" + hwFilteredList);
		
		// Again filtering using a multi-stage pipe
		List<String> numbersFilteredList = Stream.of("one", "two", "hello", "three", "world", "four"). // an example of a data source
				filter(e -> (!e.equalsIgnoreCase("hello"))). // an example of an intermediate operation
				filter(e -> (!e.equalsIgnoreCase("World"))). // an example of an intermediate operation
				collect(Collectors.toList()); // an example of a terminal operation	
		
		System.out.println("Numbers Filtered List" + numbersFilteredList);
	}

}
