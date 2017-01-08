package com.tirthal.learning.exercises.cmp;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Runnable: Before Java 8 code transformation into Java 8 way using Lambda and Stream usage 
 * 
 * @author tirthalp
 */
public class Ex01_Runnable {

	public static void main(String[] args) throws InterruptedException {		
		beforeJava8();		
		java8way();		
	}

	private static void beforeJava8() {
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {				
				for(int i=1; i<=5; i++) {
					System.out.println("Counter: " + i);
				}
			}
		};
				
		Executors.newSingleThreadExecutor().execute(r);		
	}

	private static void java8way() {
		Runnable r = () -> {
			IntStream.range(1, 6)
					 .forEach(e -> System.out.println("Counter: " + e));
		};	
		
		Executors.newSingleThreadExecutor().execute(r);
	}
}
