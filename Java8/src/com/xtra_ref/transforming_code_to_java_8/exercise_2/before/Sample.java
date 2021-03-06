package com.xtra_ref.transforming_code_to_java_8.exercise_2.before;

import java.util.*;

// Prior to Java 8 - Code for finding square root of first and last numbers of the first 100 prime numbers

public class Sample {

	public static void main(String[] args) {
		List<Double> sqrtOfFirst100Primes = new ArrayList<>();

		int index = 1;
		while (sqrtOfFirst100Primes.size() < 100) {
			if (isPrime(index)) {				
				sqrtOfFirst100Primes.add(Math.sqrt(index));
			}

			index++;
		}

		System.out.println(String.format("Computer %d values, first is %g, last is %g", sqrtOfFirst100Primes.size(),
				sqrtOfFirst100Primes.get(0), sqrtOfFirst100Primes.get(sqrtOfFirst100Primes.size() - 1)));
	}
	
	public static boolean isPrime(int number) {
		boolean divisble = false;

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				divisble = true;
				break;
			}
		}

		return number > 1 && !divisble;
	}
}
