package com.tirthal.learning.libfeatures.java.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example code to understand Intermediary and Terminal Operations on a Stream
 * 
 * @author tirthalp
 */
public class Ex03_IntermediaryVsTerminalOp {
	
	public static List<Integer> ageList = Arrays.asList(23, 15, 45, 12, 55, 9, 60, 18, 20, 70, 3, 14);
	
	// Intermediary / Lazy operations on Stream = operations to be performed on the data, such as filtering or transformation operations
	public static void demoIntermediaryOp() {
		
		List<Integer> adultFilteredAgeList = new ArrayList<>(); 
		
		System.out.print("Input age values =");
		ageList.stream().
				peek(e -> System.out.print(" " + e)).
				filter(e -> e > 18).
				peek(adultFilteredAgeList::add);
	
		System.out.println("\n" + "Applying Intermediary operations without Terminal Operation - Filtered adult age list =" + adultFilteredAgeList + "\n");
		
		// Did you see? --->  The above code does nothing! Not printing input data and adultFilteredAgeList remains empty...
		// Because all the methods of Stream that return another Stream are lazy
		// That means, an operation on a Stream that returns a Stream is called an intermediary operation, i.e. peek() and filter() in above code		
	}
	
	// Terminal / Final Operations on a Stream = describes what to do with the processed data, as well as determines when (or if) to stop processing the data	
	public static void demoTerminalOp() {
		
		List<Integer> adultFilteredAgeList = new ArrayList<>(); 
		
		System.out.print("Input age values =");
		ageList.stream().
				peek(e -> System.out.print(" " + e)).
				filter(e -> e >= 18).
				forEach(adultFilteredAgeList::add);
			
		System.out.println("\n" + "Applying Intermediary operations without Terminal Operation - Filtered adult age list =" + adultFilteredAgeList + "\n");
		
		// Did you see? --->  The above code does its job! Printing input data and adding filtered values to adultFilteredAgeList list...
		// Because only final operation triggers the processing of data the stream is connected to, i.e. forEach() in above code
		// Be aware, only one terminal operation can be specified per stream
	}
	
	// Try it
	public static void main(String[] args) {		
		demoIntermediaryOp();		
		demoTerminalOp();		
	}
}

