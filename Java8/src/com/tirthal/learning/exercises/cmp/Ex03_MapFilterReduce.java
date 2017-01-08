package com.tirthal.learning.exercises.cmp;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

/**
 * Simple Map / Filter / Reduce example: Java 7 vs. Java 8 way of writing code
 * 
 * @author tirthalp
 *
 */
public class Ex03_MapFilterReduce {

	public static void main(String[] args) {
		beforeJava8(Person.PERSONS_LIST);
		
		java8way(Person.PERSONS_LIST);
		java8way(Collections.emptyList());
		java8way(null);	// Oops, null not allowed
	}

	// Java 7 way to compute average of the age of people older than 30
	private static void beforeJava8(List<Person> personsList) {
		int sum=0, count=0; 
		double average=0.0;		
		for(Person p: personsList) {
			if(p.getAge() > 30) {
				sum += p.getAge();
				count++;
			}
		}			
		if(count>0)
			average = (double)sum / count;
		
		System.out.println("Java 7 way: Average of the age of people older than 30 = " + average);
	}

	private static void java8way(List<Person> personsList) {		
		
		Objects.requireNonNull(personsList);
		
		// Usage of Optional
		OptionalDouble average = personsList.stream()
											.filter(person -> person.getAge() > 30)	 	// Filter people with age older than 30
											.mapToInt(Person::getAge) 					// Map person to Integer
											.average();									// Reduce operation to calculate average									
		
		System.out.println("Java 8 way: Average of the age of people older than 30 = " + (average.isPresent() ? average.getAsDouble() : 0.0));
	}
}
