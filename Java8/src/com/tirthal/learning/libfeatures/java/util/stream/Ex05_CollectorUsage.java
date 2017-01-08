package com.tirthal.learning.libfeatures.java.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Example code for basic and complex patterns for Collector usage
 * 
 * <p>
 * There are reduction operations for aggregations like sum, max, average, etc. However, a collector is a special type
 * of reduction. It is a terminal operation, that triggers the computation of the Stream. <br/><br/>
 * 
 * There are already many ready-to-use collectors in the java.util.stream.Collectors class. If there is a need to do any
 * exceptional stuff for advance data processing, then custom Collectors can be built using Collector.of(...) method.
 * </p>
 * 
 * @author tirthalp
 */
public class Ex05_CollectorUsage {

	public static void main(String[] args) {

		List<String> inputWords = Arrays.asList("apple", "red", "bike", "book", "", "phone", "laptop", "hello", "age", "bottle", "", "", "phone", "age");
		List<String> outputNonEmptyWords = new ArrayList<>();
		
		// ---> Populate list of non empty words from list of input words
		
		// WRONG Approach
		inputWords.stream()
				  //.parallel()						  // Cannot use parallel, as ArrayList is not thread safe
				  .filter(s -> !s.isEmpty())
				  .forEach(outputNonEmptyWords::add); // adding elements to external list - This is evil 
		
		outputNonEmptyWords.clear();
		// CORRECT Approach
		outputNonEmptyWords = inputWords.stream()
										.parallel()						// Awesome, Collector pattern works magically with parallel
										.filter(s -> !s.isEmpty())
										.collect(Collectors.toList());	// Usage of Collectors class to return a list of output elements
		System.out.println("List of non empty words: " + outputNonEmptyWords);
		
		// ---> Find a longest word from natural sorted stream of words
		Optional<String> longestWord = outputNonEmptyWords.stream()
														  .sorted()
						   						   		  .collect(Collectors.maxBy(Comparator.comparing(String::length)));
		System.out.println("Longest Word: " + longestWord);
		
		// ---> Find a shortest word from natural sorted stream of words
		Optional<String> shortestWord = outputNonEmptyWords.stream()
														   .sorted()
						   						   		   .collect(Collectors.minBy(Comparator.comparing(String::length)));
		System.out.println("Shortest Word: " + shortestWord);
		
		// ---> Getting non-duplicate words separated by ":"
		String wordsByComma = outputNonEmptyWords.stream()
												 .distinct()
												 .collect(Collectors.joining(" ; "));
		System.out.println("Words separated by comma: " + wordsByComma);
		
		// ---> Collecting words in Set (distinct data, no duplicate)
   		Set<String> wordsSet = outputNonEmptyWords.stream()
   											      .collect(Collectors.toSet()); 
   		System.out.println("Set of words: "+ wordsSet);
   		
   		// ---> Collecting data in TreeSet (distinct data, no duplicate, ordered)
   		TreeSet<String> wordsTreeSet = outputNonEmptyWords.stream()
				      									  .collect(Collectors.toCollection(() -> new TreeSet<>())); 
   		System.out.println("TreeSet of words: "+ wordsTreeSet);
   		
   		// ---> Collecting data in a Map
   		
   		// Map<Is word greater than Three?, List of words>
   		Map<Boolean, List<String>> wordsEqualToThreeMap = outputNonEmptyWords.stream()
   																	  		 .collect(
   																	  				 Collectors.partitioningBy(word -> word.toString().length() == 3)
   																	  		 );
   		System.out.println("Map containing words partitioning between equal to 3 & all other: " + wordsEqualToThreeMap);
   		
   		// Map<Length, List of words of the given length>
   		Map<Integer, List<String>> wordsBySizeMap = outputNonEmptyWords.stream()
					  													.collect(
					  															Collectors.groupingBy(String::length)
					  													);   		
   		System.out.println("Map containing words grouping by length: " + wordsBySizeMap);
   		
   		// Map<Length, Total number of words of the given length>
   		Map<Integer, Long> wordsCountBySizeMap = outputNonEmptyWords.stream()   																	
   																	.collect(
   																			Collectors.groupingBy(
   																					String::length, 
   																					Collectors.counting() // the << downstream >> collector
   																			)
   																	);   																	
		System.out.println("Map containing words grouping by length: " + wordsCountBySizeMap);
		
		// Map<Length, List of words in upper case for the given length>
   		Map<Integer, List<String>> uppercaseWordsBySizeMap = outputNonEmptyWords.stream()
   																				.collect(
   																						Collectors.groupingBy(
   																								String::length, 
   																								Collectors.mapping(
   																										String::toUpperCase, 
   																										Collectors.toList()
   																								)
   																						)   																						
   																				);
   		System.out.println("Map containing uppercase words grouping by length: " + uppercaseWordsBySizeMap);
   		
   		// ---> Collecting in an Immutable Map
   		Map<Integer, List<String>> wordsBySizeUnmodifiableMap = outputNonEmptyWords.stream()
																				   .collect(
																						Collectors.collectingAndThen(
																								Collectors.groupingBy(String::length), 
																								Collections::unmodifiableMap
																						)																						
																					);
   		System.out.println("Unmodifiable Map containing words grouping by length: " + wordsBySizeUnmodifiableMap);
   		try {
   			wordsBySizeUnmodifiableMap.put(10, Arrays.asList("abcdefghij"));
   		} catch(UnsupportedOperationException e) {
   			System.out.println("--- Oops, cannot perform put operation on unmodifiable map: " + e);
   		}
   		
   		// ---> Grouping, mapping and collecting in a TreeSet
   		// Map<Length, TreeSet of distinct and ordered words in upper case for the given length>
   		Map<Integer, TreeSet<String>> uppercaseDistinctOrderedWordsBySizeMap = outputNonEmptyWords.stream()
																								.collect(
																										Collectors.groupingBy(
																												String::length, 
																												Collectors.mapping(
																														String::toUpperCase, 
																														Collectors.toCollection(() -> new TreeSet<>())
																												)
																										)   																						
																								);
   		System.out.println("Map containing distinct and ordered words in uppercase grouping by length: " + uppercaseDistinctOrderedWordsBySizeMap);
   		
   	    // TreeMap<Length, TreeSet of distinct and ordered words in upper case for the given length>
   		TreeMap<Integer, TreeSet<String>> uppercaseDistinctOrderedWordsBySizeTreeMap = outputNonEmptyWords.stream()
																										  .collect(
																													Collectors.groupingBy(
																															String::length,
																															() -> new TreeMap<>(),
																															Collectors.mapping(
																																	String::toUpperCase, 
																																	Collectors.toCollection(() -> new TreeSet<>())
																															)
																													)   																						
																										  );
   		System.out.println("TreeMap containing distinct and ordered words in uppercase grouping by length: " + uppercaseDistinctOrderedWordsBySizeTreeMap);   		
	}
}

