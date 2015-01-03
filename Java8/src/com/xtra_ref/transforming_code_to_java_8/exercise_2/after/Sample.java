package com.xtra_ref.transforming_code_to_java_8.exercise_2.after;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// In Java 8 - Code for finding square root of first and last numbers of the first 100 prime numbers

public class Sample {
		
	public static boolean isPrime(int number) {
		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
	}

	public static void main(String[] args) {
		List<Double> sqrtOfFirst100Primes = Stream.iterate(1, e -> e + 1)	// Incremental stream iterator starting from number 1
													.filter(Sample::isPrime)	// Filter prime numbers for further processing 
													.map((Integer a) -> Math.sqrt(a)) // Map to find square root of the prime number
													.limit(100)							  // Stop once 100 prime numbers' square root is calculated 
													.collect(toList());							// Return those collected numbers as a list

		System.out.println(String.format("Computer %d values, first is %g, last is %g", sqrtOfFirst100Primes.size(),
				sqrtOfFirst100Primes.get(0), sqrtOfFirst100Primes.get(sqrtOfFirst100Primes.size() - 1)));
	}
}
