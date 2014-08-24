package com.tirthal.learning.langfeatures.lambda;

/**
 * This is simple single method interface
 * 
 * @author tirthalp
 */
interface Ex01_HelloWorld {
	void sayHello(String name);
}

/**
 * Hello world example to demo what is purpose of Lambda!
 * 
 * @author tirthalp
 */
public class Ex01_HelloWorldLambda {

	public static void main(String... args) {

		// --- Prior to Java 8 ---
		// HelloWorld interface implementation using anonymous class
		Ex01_HelloWorld hw1 = new Ex01_HelloWorld() {

			@Override
			public void sayHello(String name) {
				System.out.println("Hello " + name);
			}

		};

		hw1.sayHello("Tirthal");

		// --- In Java 8 ---
		// HelloWorld interface implementation using Lambda expression
		Ex01_HelloWorld hw2 = (String name) -> System.out.println("Hello " + name);

		hw2.sayHello("Tirthal");

		// --- Awesome! Did you observe the difference?
		// With Java 8 Lambda, you don't need to tell method name to compiler explicitly
		// Using Lambda, compiler would automatically apply input parameters and implementation for single method of interface
		// Also lines of code is reduced with Lambda
	}
}