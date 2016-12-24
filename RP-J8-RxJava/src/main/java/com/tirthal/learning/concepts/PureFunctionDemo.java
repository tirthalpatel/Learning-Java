package com.tirthal.learning.concepts;

/**
 * Pure Functions [y = f(x)] = Always return the same result for a given set of input parameters
 * 
 * @author tirthalp
 *
 */
public class PureFunctionDemo {

	private int counter = 0;
	
	// I am pure function
	public int pureFunction(int x) {
		return x + x;
	}
	
	// I am not pure function - here, class or instance state can cause side effects, specifically multiple number of threads
	public int impureFunction(int x) {
		
		// Not in my control
		counter = (counter++ % 4);
		
		return x + x + counter;
	}
}
