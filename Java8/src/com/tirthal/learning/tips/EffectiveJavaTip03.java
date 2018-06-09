package com.tirthal.learning.tips;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

/**
 * Effective Java Tips (<a href="https://www.youtube.com/watch?v=wZKmA6XodNE">See Also</a>):
 *  
 * (1) In functional programming, should not modify state (modifying state = imperative style) / 
 * Prefer side-effect-free functions in streams.
 * 
 * (2) Use streams judiciously. When used appropriately, streams can make programs shorter and clearer; 
 * when used inappropriately, they can make programs difficult to read and maintain. Avoid loops in stream.
 * 
 * (3) Do not parallelize stream pipelines indiscriminately. Use parallel streams with Stateless operations 
 * (filter, map, peek…) and don't use with Stateful operations (distinct, sorted, limit and skip). Refer
 * {@link com.tirthal.learning.libfeatures.java.util.stream.Ex04_ParallelStream}
 * 
 * @author tirthalp
 */
public class EffectiveJavaTip03 {
	
	// Do sum of provided map values
	public static int doSumOfMapValues(Map<String, Integer> exMap) {		
		Set<String> sourceKeySet = exMap.keySet();
		
		// ---> Approach 1: Correct code, still imperative thinking		 
		LongAdder sourceCount = new LongAdder(); // Atomic in multi-threading
		
		sourceKeySet.stream()
					.forEach(k -> sourceCount.add(exMap.get(k))); // modifying state = imperative style	
		
		// ------------------------------------------------------------------------------------------------------
		// Tip: In functional programming, should not modify state / Prefer side-effect-free functions in streams
		// ------------------------------------------------------------------------------------------------------
		/*
		 * Streams paradigm is to structure your computation as a sequence of transformations where the result of each
		 * stage is as close as possible to a pure function of the result of the previous stage. A pure function is one
		 * whose result depends only on its input: it does not depend on any mutable state, nor does it update any
		 * state.
		 * 
		 * The forEach operation should be used only to report the result of a stream computation, not to perform the
		 * computation.
		 */
		
		// ---> Approach 2: Functional way
		sourceKeySet.stream()
					.mapToInt(k -> exMap.get(k))
					.sum();
		
		// ---> Approach 3: What if wants to print too?
		int sum = sourceKeySet.stream()
							  .peek(e -> System.out.println("Value:"+exMap.get(e)))
							  .mapToInt(k -> exMap.get(k))
							  .sum();
		
		return sum;
	}
	
	// Find length of longest line in a file
	public static int findLongestLineLength(File f) throws FileNotFoundException, IOException {
		
		try(BufferedReader reader = new BufferedReader(new FileReader(f))) {
		
			// ---------------------------------------------------------
			// Tip: Avoid loops in Streams 
			// (See below approach with no loops, rather functional way)
			// ----------------------------------------------------------
			Stream<String> lines = reader.lines();
			int longest = lines.mapToInt(String::length)
							   .max()
							   .getAsInt();
			
			System.out.println("Longest line length:"+longest);
			
			return longest;
		}				
	}
		
	// Find longest line in a file
	public static String findLongestLine(File f) throws IOException {		
		BufferedReader reader = null;
		String longest = "";
		
		// ---> Approach 1: External iteration solution
		reader = new BufferedReader(new FileReader(f));		
		String s = "";
		
		// Simple code, but inherently serial and thread-safety concerns
		while((s = reader.readLine()) != null)
			if(s.length() > longest.length())
				longest = s;
		
		reader.close();
		System.out.println("Longest line using approach 1:"+longest);
		
		// ---> Approach 2: Recursive approach
		reader = new BufferedReader(new FileReader(f));
		
		// No explicit loops, no mutable state
		// BUT larger data sets will generate OOM and too many stack frames
		longest = findLongestStringRecursively("", reader);
		
		System.out.println("Longest line using approach 2:"+longest);
		reader.close();		
		
		// ---> Approach 3: Just naive stream solution		
		reader = new BufferedReader(new FileReader(f));
		
		// But inefficient, specifically for big files will take long time and lot of resources to sort
		longest = reader.lines()
					    .sorted((x, y) -> y.length() - x.length())
					    .findFirst()
					    .get();
		
		reader.close();
		System.out.println("Longest line using approach 3:"+longest);
		
		// ---> Approach 4: A better stream solution using filter-map-reduce pattern 
		reader = new BufferedReader(new FileReader(f));
		
		// Filter and map not needed, just using reduce
		// Using recursive approach as an accumulator for a reduction 
		longest = reader.lines()
						.reduce((x, y) -> {
							if(x.length() > y.length())
								return x;
							return y;
						})
						.get();
		
		reader.close();
		System.out.println("Longest line using approach 4:"+longest);
		
		// ---> Approach 5: The simplest stream solution 
		reader = new BufferedReader(new FileReader(f));
		
		// Using a specialized form of max()
		longest = reader.lines()
						.max(Comparator.comparingInt(String::length))
						.get();
		
		reader.close();
		System.out.println("Longest line using approach 5:"+longest);
		
		// ---> Approach 6: For larger data set, leverage the computing power of multicore CPUs
		
		// Java 7 Project Coin Feature - Try With Resources Statement
		try(BufferedReader r = new BufferedReader(new FileReader(f))) {
			
			// ---------------------------------------------------------
			// Tip: Avoid loops in Streams / Parallel Streams 
			// (See below approach with no loops, rather functional way)
			// ----------------------------------------------------------
			Stream<String> lines = r.lines();
						
			longest = lines.parallel()
						   .max(Comparator.comparingInt(String::length))
						   .get();
			
			System.out.println("Longest line using approach 6:"+longest);
			
			return longest;
		}
	}
	
	private static String findLongestStringRecursively(String longest, BufferedReader reader) throws IOException {
		String next = reader.readLine();
		
		if(next == null)
			return longest;
		
		if(next.length() > longest.length())
			longest = next;
		
		return findLongestStringRecursively(longest, reader);
	}		
}
