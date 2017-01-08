package com.tirthal.learning.libfeatures.java.util.function.suppliers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

// java.util.function.Supplier returns results without taking any input argument parameter

/**
* Sample code to demo syntax of Supplier functional interface usage in Java 8
* 
* @see https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html
* @author tirthalp
*
*/
public class Ex_SupplierDemo {

	public static void main(String[] args) {
		
		// No input parameter and returning List<String>
		Supplier<List<String>> colorsSupplier = () -> Arrays.asList("red", "blue", "black", "white");
		
		// Supplier, by own, doesn't represent result to be returned
		System.out.println(colorsSupplier);
		
		// Supplier returns result, when each time its get() method is invoked
		System.out.println("All colors:" + colorsSupplier.get());	
	}

}
