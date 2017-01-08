package com.tirthal.learning.libfeatures.java.util.cf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map: what's new for me in Java 8?
 * 
 * @author tirthalp
 */
public class Ex02_MapDemo {
	
	public static void main(String[] args) {
		
		Map<String, List<String>> country2states = createMapData();
		
		// On Map ---> boolean forEach(BiConsumer<? super K, ? super V> consumer) 
		country2states.forEach((k, v) -> System.out.print("Country:" + k + ", States:" + v + " | ")); 
		System.out.println();
		
		// New getOrDefault(): New version of get() method
		System.out.println("States for India:" + country2states.getOrDefault("India", Collections.emptyList()));
		System.out.println("States for Europe:" + country2states.getOrDefault("Europe", Collections.emptyList()));
		
		// New putIfAbsent(): New version of put() method
		country2states.putIfAbsent("India", Collections.emptyList());
		country2states.putIfAbsent("Europe", Arrays.asList("France", "Spain", "Switzerland"));
		System.out.println("Map of country to states:" + country2states);
		
		// New replace() and replaceAll() methods
		country2states.replace("India", Arrays.asList("Gujarat", "Maharashtra", "Goa", "Bihar", "Rajasthan"));
		System.out.println("Updated states for India:"+country2states.get("India"));
				
		// New compute() method - Also see, computeIfAbsent() and computeIfPresent() 
		country2states.compute("India", (k, v) -> {
			v.replaceAll(String::toUpperCase);			
			return v;
		});
		System.out.println("Updated states for India in Upper Case:"+country2states.get("India"));
		
		// New merge() method
		Map<String, List<String>> tempMap = new HashMap<>();
		tempMap.put("Canada", Collections.emptyList());
		tempMap.put("USA", Arrays.asList("New Jersey", "California"));
		
		tempMap.forEach((country, states) -> 
			country2states.merge(country, states, // if key doesn't exist, just add key-value in the map and ignore BiFunction
				(statesFromCountry2statesMap, statesFromTempMap) -> { // if key exists, what is merge logic? 	
					// statesFromCountry2statesMap.addAll(statesFromTempMap); // Oops, why getting java.lang.UnsupportedOperationException?
					// Manual logic, because addAll throws UnsupportedOperationException
					List<String> temp1 = new ArrayList<>(statesFromTempMap); 
					List<String> temp2 = new ArrayList<>(statesFromCountry2statesMap);
					temp2.removeIf(temp1::contains);				
					temp1.addAll(temp2);
					System.out.println("In BiFunction: " + country + "=" + temp1);
					return temp1;
				})
		);
						
		System.out.println("Map after merge operation: " + country2states);
	}

	private static Map<String, List<String>> createMapData() {
		
		Map<String, List<String>> m = new HashMap<>();
		m.put("India", Arrays.asList("Gujarat", "Maharashtra", "Goa"));
		m.put("USA", Arrays.asList("Arizona", "Florida", "Texas", "California"));
		m.put("Australia", Arrays.asList("Victoria", "Queensland", "Tasmania", "South Australia", "Western Australia"));
				
		return m;
	}
}
