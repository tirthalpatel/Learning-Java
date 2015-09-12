package com.tirthal.learning.libfeatures.java.util.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

// java.util.function.BiConsumer accepts a single input parameter, enables the developer to perform some operation and returns nothing

/**
 * Sample code to demo syntax of BiConsumer functional interface usage in Java 8
 * 
 * @see com.tirthal.learning.libfeatures.java.util.function.Ex_ConsumerDemo
 * @see https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html
 * @author tirthalp
 *
 */
public class Ex_BiConsumerDemo {

	public static void main(String... args) {

		Map<Integer, String> employees = new HashMap<>();
		employees.put(1, "Williom");
		employees.put(2, "Ashley");
		employees.put(3, "Zubin");

		// What operation this BiConsumer does? --- Taking given two input parameter and just printing		
		BiConsumer<Integer, String> onlyPrint = (k, v) -> System.out.println("Id = " + k + ", Name = " + v);

		// What operation this BiConsumer does? --- Taking given two input parameter and printing in upper case
		BiConsumer<Integer, String> changeToUpperCaseAndPrint = (k, v) -> System.out.println("Id = " + k + ", Name = " + v.toUpperCase());

		// See it in action using default andThen() method of BiConsumer interface
		// Provide key and value parameters of map to the BiConsumer, then first perform action of "onlyPrint" followed by "changeToUpperCaseAndPrint"
		employees.forEach(onlyPrint.andThen(changeToUpperCaseAndPrint));
	}
}
