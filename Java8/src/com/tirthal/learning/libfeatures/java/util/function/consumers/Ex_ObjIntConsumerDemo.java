package com.tirthal.learning.libfeatures.java.util.function.consumers;

import java.util.function.ObjIntConsumer;

// java.util.function.ObjIntConsumer accepts an object-valued and a int-valued argument, enables the developer to perform some operation and returns nothing

/**
* Sample code to demo syntax of ObjIntConsumer functional interface usage in Java 8
* 
* @see https://docs.oracle.com/javase/8/docs/api/java/util/function/ObjIntConsumer.html
* @author tirthalp
*
*/
public class Ex_ObjIntConsumerDemo {

	public static void main(String[] args) {		
		
		ObjIntConsumer<Integer> printMultiplication = (number, multiplicationFactor) -> System.out.printf("%d x %d = %d \n", number, multiplicationFactor, number * multiplicationFactor);
		printMultiplication.accept(10, 5);
		printMultiplication.accept(8, 9);			
	}

}
