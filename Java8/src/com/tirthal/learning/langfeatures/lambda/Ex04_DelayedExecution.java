package com.tirthal.learning.langfeatures.lambda;

import java.time.LocalTime;
import java.util.logging.Logger;

/**
 * How to use Lambda expressions in terms of Delayed execution?
 * 
 * @author tirthalp
 */
public class Ex04_DelayedExecution {

	private static final Logger _log = Logger.getLogger(Ex04_DelayedExecution.class.getName());

	public static void main(String[] args) {

		// _log.finest() - see performance impact of traditional method call vs. lambda expression usage
		
		System.out.println("(1) Start of program: " + LocalTime.now().toString());
		
		/*
		 * Old traditional approach - performance impact!  
		 * Here, getSomeStatusData() is always executed, even if logger doesn't need value
		 */
		_log.finest(getSomeStatusData()); 

		System.out.println("(2) Just before usage of Lambda expression: " + LocalTime.now().toString());

		/* 
		 * Java 8 way - usage of Supplier<T> with lambda expression
		 * Pass a description of how to create the log message, not the actual message
		 * If the logger doesn't need the value, it doesn't invoke the Lambda
		 */
		_log.finest(() -> getSomeStatusData()); 
		
		System.out.println("(3) End of program: " + LocalTime.now().toString());
	}

	private static String getSomeStatusData() {

		// Assume this is bit time consuming operation
		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Approved";
	}
}