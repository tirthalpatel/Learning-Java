package com.tirthal.learning.libfeatures.java.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example code to understand Intermediary and Terminal Operations on a Stream
 * 
 * <p>
 * How to recognize a intermediate vs. terminal call? - See Javadoc.
 * <ul>
 * <li>If a call returns a Stream, it's an intermediate call such as peek(), skip(), limit(), etc.</li>
 * <li>If a call returns something else, or void is a terminal call that triggers the processing such as match(), find(), count(), reduce(), etc.</li>
 * </ul>
 * </p>
 * 
 * @author tirthalp
 */
public class Ex03_IntermediaryVsTerminalOp {
	
	public static List<Integer> ageList = Arrays.asList(23, 15, 45, 12, 55, 9, 60, 18, 20, 70, 3, 14);
	
	// Intermediary / Lazy operations on Stream = operations to be performed on the data, such as filtering or transformation operations
	public static void demoIntermediaryOp() {
		
		List<Integer> adultFilteredAgeList = new ArrayList<>(); 
		
		System.out.print("Input age values =");
		ageList.stream()
			   .peek(e -> System.out.print(" " + e)) // Intermediate operation, which returns Stream<Integer>
			   .filter(e -> e > 18)
			   .peek(adultFilteredAgeList::add);
	
		System.out.println("\n" + "Applying Intermediary operations without Terminal Operation - Filtered adult age list =" + adultFilteredAgeList + "\n");
		
		// Did you see? --->  The above code does nothing! Not printing input data and adultFilteredAgeList remains empty...
		// Because all the methods of Stream that return another Stream are lazy
		// That means, an operation on a Stream that returns a Stream is called an intermediary operation, i.e. peek() and filter() in above code		
	}
	
	// Terminal / Final Operations on a Stream = describes what to do with the processed data, as well as determines when (or if) to stop processing the data	
	public static void demoTerminalOp() {
		
		List<Integer> adultFilteredAgeList = new ArrayList<>(); 
		
		System.out.print("Input age values =");
		ageList.stream()
				.peek(e -> System.out.print(" " + e))
				.filter(e -> e >= 18)
				.forEach(adultFilteredAgeList::add); // Terminal operation, which has void return type
			
		System.out.println("\n" + "Applying Intermediary operations without Terminal Operation - Filtered adult age list =" + adultFilteredAgeList + "\n");
		
		// Did you see? --->  The above code does its job! Printing input data and adding filtered values to adultFilteredAgeList list...
		// Because only final operation triggers the processing of data the stream is connected to, i.e. forEach() in above code
		// Be aware, only one terminal operation can be specified per stream
		
		// ---> Few more examples of Terminal operations
		System.out.println("Is there any age greater than 80? : " + ageList.stream().anyMatch(age -> age > 80));
		System.out.println("Is there any age greater than 60? : " + ageList.stream().anyMatch(age -> age > 60));		
		System.out.println("What's first age in list? : " + ageList.stream().findFirst().get());
		System.out.println("What's total count of elements in list? : " + ageList.stream().count());
		System.out.println("What's sum of all ages in list? : " + ageList.stream().reduce(0, (age1, age2) -> age1 + age2));
	}
	
	// Try it
	public static void main(String[] args) {		
		demoIntermediaryOp();		
		demoTerminalOp();		
	}
}

