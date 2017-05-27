package com.tirthal.learning.exercises.cmp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Comparator: Step by step code improvement in Java 8 way
 * 
 * @author tirthalp
 *
 */
public class Ex02_Comparator {	
	
	public static void main(String[] args) {		
		beforeJava8(Person.PERSONS_LIST);		
		java8way(Person.PERSONS_LIST);
	}

	// ---> STEP 1: Prior to Java 8 coding style
	private static void beforeJava8(List<Person> persons) {
		// Sort by age		
		Comparator<Person> cmpByAge = new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				
				return Integer.compare(p1.getAge(), p2.getAge());
			}
		};		
		Collections.sort(persons, cmpByAge);		
		System.out.println("Before Java 8 - sort by age:"+persons);
		
		// Sort by first name
		Comparator<Person> cmpByFirstName = new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				
				return p1.getFirstName().compareTo(p2.getFirstName());
			}
		};		
		Collections.sort(persons, cmpByFirstName);		
		System.out.println("Before Java 8 - sort by first name:"+persons);
	}
	
	private static void java8way(List<Person> persons) {
		
		// ---> STEP 2: Using Java 8 Lambda expression 
		
		// Sort by age	
		Comparator<Person> cmpByAge = (p1, p2) -> { return p1.getAge() - p2.getAge(); };
		Collections.sort(persons, cmpByAge);		
		System.out.println("Java 8 way - sort by age: "+persons);

		// Sort by first name
		Comparator<Person> cmpByFirstName = (p1, p2) -> { return p1.getFirstName().compareTo(p2.getFirstName()); };
		Collections.sort(persons, cmpByFirstName);		
		System.out.println("Java 8 way - sort by first name: "+persons);
		
		// ---> STEP 3: Further code improvement possible?
		
		// Yes, using Function 		
		Function<Person, Integer> f = p -> p.getAge(); 
		Collections.sort(persons, Comparator.comparing(f));
		System.out.println("Java 8 way of using function - sort by age: "+persons);
		
		// Rather, static method reference syntax looks awesome
		Collections.sort(persons, Comparator.comparing(Person::getFirstName));
		System.out.println("Java 8 way of using static method reference - sort by first name: "+persons);
		
		// --->  How to compare by age followed by first name followed by last name?
		
		// Well, usage of chaining pattern with Comparator.thenComparing 
		
		Collections.sort(persons, Comparator.comparing(Person::getAge)
											.thenComparing(Person::getFirstName)
											.thenComparing(Person::getLastName)); // chaining pattern 
		System.out.println("Java 8 way of using chaining pattern in Comparator - sort by age, first name and last name: "+persons);
	}		
}
