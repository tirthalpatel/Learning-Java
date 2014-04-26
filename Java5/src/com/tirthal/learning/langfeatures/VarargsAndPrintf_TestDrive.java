package com.tirthal.learning.langfeatures;

//---------------------------------------
//--- STEP 00 - WHAT IS VARIABLE METHOD ARGUMENTS AND PRINTF? 
//---------------------------------------

///*
// * Java 1.5 - Language feature - Variable method arguments and printf
// * 
// * --- Caution --- (1) Ellipse can be used once in method parameter list. (2) Ellipse with type must be used in parameter list at the end of the
// * method. (3) Every call to varargs method require an anonymous array to be created and initialized which could affect performance in time
// * critical application. There is an alternative of varargs method to achieve better performance. suppose you have a variable argument
// * method sum(int... num) and its called with 2 parameters on 90% of time. In order to avoid array creation and initialization you can use method
// * overloading in Java to provide two versions of sum() which accept int instead of varargs. Here is an example of better performance alternative of
// * varargs for 90% of time - public int sum(int a); public int sum(int a, int b); public int sum(int... num); - Now 90% of time method without varargs
// * will be invoked and 10% of time method with variable argument will be invoked.
// */

//---------------------------------------
//--- STEP 00 - UNDERSTAND VARIABLE METHOD ARGUMENTS AND PRINTF BY EXAMPLE 
//---------------------------------------

/**
 * Test class for variable arguments and printf features
 * 
 * @author tirthalp
 * 
 */
public class VarargsAndPrintf_TestDrive {
	public static void main(String args[]) {
		// ------ variable arguments in Java 1.5
		sum("Final Total for 3 numbers", 1, 5, 15);
		System.out.println("--------------");
		sum("Final Total for 6 numbers", 100, 80, 60, 40, 20, 0);
	}

	// Note the change in the method signature. Instead of explicitly taking an
	// array of Integer objects, we inform the compiler that a variable number
	// of Integer objects will be passed using an ellipsis (...)
	public static void sum(String lable, Integer... numbers) {
		System.out.println("Number + Previous Sum = Sum");
		int mysum = 0;
		for (int i : numbers) {
			System.out.printf("%d + %d = ", i, mysum); // Note the printf instead of println
			mysum += i;
			System.out.printf("%d\n", mysum);
		}
		System.out.printf("%s = %d\n", lable, mysum);
	}
}
