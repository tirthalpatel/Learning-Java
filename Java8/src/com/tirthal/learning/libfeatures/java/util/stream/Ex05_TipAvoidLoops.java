package com.tirthal.learning.libfeatures.java.util.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;

/**
 * Demo code for Tip of avoiding loops in Streams. <a href="https://www.youtube.com/watch?v=wZKmA6XodNE">See</a> 
 * 
 * @author tirthalp
 */
public class Ex05_TipAvoidLoops {

	private static final File README_FILE = Paths.get(".\\README.md").toFile();
	
	public static void main(String[] args) throws IOException {		
		
		// Create Sample Data
		Map<String, Integer> exMap = createSampleMapData();
		
		// ---> Example 1: Counting		
		doSumOfMapValues(exMap); 
																			
		// ---> Example 2: Find length of longest line in a file
		findLongestLineLength(README_FILE);
		
		// ---> Example 3: Find longest line in a file
		findLongestLine(README_FILE);
	}
	
	private static void findLongestLine(File f) throws IOException {		
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
		reader = new BufferedReader(new FileReader(f));
		
		// Using a parallel()
		longest = reader.lines()
						.parallel()
						.max(Comparator.comparingInt(String::length))
						.get();
		
		reader.close();
		System.out.println("Longest line using approach 6:"+longest);
	}

	private static String findLongestStringRecursively(String longest, BufferedReader reader) throws IOException {
		String next = reader.readLine();
		
		if(next == null)
			return longest;
		
		if(next.length() > longest.length())
			longest = next;
		
		return findLongestStringRecursively(longest, reader);
	}
	
	private static void findLongestLineLength(File f) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(f));
		
		// ---> Approach: No loops, rather functional way
		int longest = reader.lines()
							.mapToInt(String::length)
							.max()
							.getAsInt();
		
		System.out.println("Longest length:"+longest);
		reader.close();
	}

	private static void doSumOfMapValues(Map<String, Integer> exMap) {		
		Set<String> sourceKeySet = exMap.keySet();
		
		// ---> Approach 1: Correct code, still imperative thinking		 
		LongAdder sourceCount = new LongAdder(); // Atomic in multi-threading
		
		sourceKeySet.stream()
					.forEach(k -> sourceCount.add(exMap.get(k))); // modifying state = imperative style	
		
		// ---> Approach 2: Functional way
		sourceKeySet.stream()
					.mapToInt(k -> exMap.get(k))
					.sum();
		
		// ---> Approach 3: What if wants to print too?
		sourceKeySet.stream()
					.peek(e -> System.out.println("Value:"+exMap.get(e)))
					.mapToInt(k -> exMap.get(k))
					.sum();
	}

	private static Map<String, Integer> createSampleMapData() {
		
		Map<String, Integer> exMap = new HashMap<>();
		exMap.put("key1", 10);
		exMap.put("key2", 5);
		exMap.put("key3", 145);
		exMap.put("key4", 22);
		exMap.put("key5", 54);
											  		
		return exMap;
	}
}
