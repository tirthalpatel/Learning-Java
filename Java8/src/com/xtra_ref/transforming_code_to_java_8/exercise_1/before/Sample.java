package com.xtra_ref.transforming_code_to_java_8.exercise_1.before;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		// ------------ Prior to Java 8 way -------------
		for (int i = 0; i < 10; i++) {
			final int index = i;
			executorService.submit(new Runnable() {
				public void run() {
					System.out.println("Running task " + index);
				}
			});
		}
		// -------------------------------------------------- 

		System.out.println("Tasks started...");
		executorService.shutdown();
	}
}
