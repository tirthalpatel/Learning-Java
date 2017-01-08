package com.tirthal.learning.libfeatures.java.util.function.consumers;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

// java.util.function.IntConsumer accepts a single int-valued argument, enables the developer to perform some operation and returns nothing

/**
* Sample code to demo syntax of IntConsumer functional interface usage in Java 8
* 
* @see https://docs.oracle.com/javase/8/docs/api/java/util/function/IntConsumer.html
* @author tirthalp
*
*/
public class Ex_IntConsumerDemo {

	public static void main(String... args) {
		
		// Taking int-valued argument and just printing its multiplication by 2
		IntConsumer printmultiplicationByTwo = i -> System.out.printf("%d x 2 = %d \n", i, i * 2);
		printmultiplicationByTwo.accept(10);
		printmultiplicationByTwo.accept(50);
		
		// Usage of IntConsumer function in forEach of IntStream
		IntStream.range(1, 6)
				 .forEach(printmultiplicationByTwo);
	}
}
