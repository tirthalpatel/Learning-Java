package com.tirthal.learning.libfeatures.java.util.function.consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// java.util.function.Consumer accepts a single input parameter, enables the developer to perform some operation and returns nothing

/**
 * Sample code to demo syntax of Consumer functional interface usage in Java 8
 * 
 * @see https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html
 * @author tirthalp
 *
 */
public class Ex_ConsumerDemo {

	public static void main(String... args) {

		List<String> colors = Arrays.asList("red", "blue", "white");
		List<String> duplicateColor = new ArrayList<>();

		// ---> Example 1

		// What operation this consumer does? --- Taking given input parameter and just printing it
		Consumer<String> onlyPrinting = s -> System.out.println(s);
		// Above line is equivalent to this short syntax --- Consumer<String> onlyPrinting = System.out::println;

		// See Consumer usage in action
		onlyPrinting.accept("Hello World");
		
		colors.forEach(onlyPrinting); // Performs the given action for each element of the list

		// ---> Example 2

		// What operation this Consumer does? --- Taking given input parameter and adding it to "duplicateColor" list
		Consumer<String> addToList = duplicateColor::add;

		// See Consumer usage in action
		System.out.println(duplicateColor); // empty list
		colors.forEach(addToList); // Take each element from "colors" list and add to "duplicateColor" list
		System.out.println(duplicateColor); // "duplicateColor" list containing same elements of colors list

		// ---> Example 3

		/*
		 * Consumer's default andThen() returns a composed Consumer that performs, in sequence, this operation followed
		 * by the after operation. i.e., first performs operation of "onlyPrinting" consumer followed by "addToList"
		 * consumer.
		 */
		colors.forEach(onlyPrinting.andThen(addToList));
		System.out.println(duplicateColor);
	}
}
