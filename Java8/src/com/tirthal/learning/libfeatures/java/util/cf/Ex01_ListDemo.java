package com.tirthal.learning.libfeatures.java.util.cf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * List: what's new for me in Java 8?
 * 
 * @author tirthalp
 */
public class Ex01_ListDemo {

	public static void main(String[] args) {
		
		List<String> animals = new ArrayList<>(Arrays.asList("Elephant", "Dog", "Lion", "Tiger", "Cow"));
		
		// On Iterable ---> boolean forEach(Consumer<? super E> consumer) 
		animals.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		// On Collection ---> boolean removeIf(Predicate<? super E> filter)
		// Remove elements with length 3
		animals.removeIf(s -> s.length()==3); 		
		animals.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		// On List ---> boolean replaceAll(UnaryOperator<? super E> operator)
		animals.replaceAll(String::toUpperCase);			
		animals.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		// On List ---> boolean sort(Comparator<? super E> comparator)
		// sort by length
		animals.sort(Comparator.comparing(String::length)); 
		animals.forEach(s -> System.out.print(s + " "));
		System.out.println();
		// sort by length in reverse order
		animals.sort(Comparator.comparing(String::length).reversed()); 		
		animals.forEach(s -> System.out.print(s + " "));
	}
}
