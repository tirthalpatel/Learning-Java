package com.xtra_ref.transforming_code_to_java_8.exercise_1.after;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Sample {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		// ------------ Java 8 way ----------------------------------
		// Sequential ordered integer steam range from 0 to 9
		IntStream.range(0, 10)  
				.forEach(index -> 
						executorService.submit(() -> System.out.println("Running task " + index))); // Single Abstract Method Interfaces using Lambda
		// ---------------------------------------------------------- 
		
		System.out.println("Tasks started...");
		executorService.shutdown();
	}
}
