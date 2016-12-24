package com.tirthal.learning.rxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;


/**
 * Example code to try few Operators in RxJava.
 * 
 * @see http://reactivex.io/documentation/operators.html#categorized
 * @author tirthalp
 *
 */
public class Ex04_Operators {

	public static void main(String[] args) throws InterruptedException {
		
		// ---> Creating Observables like just, range, defer, from, etc.
		// Operators that originate new Observables
		Observable<String> numberWords = Observable.just("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
		Observable<Integer> numberValues = Observable.range(1, 10);
		
		System.out.println("*************************");
		
		// ---> Transforming Observables like map, scan, flatMap, groupBy, window, etc.
		// Operators that transform items that are emitted by an Observable
		numberWords.map(String::toUpperCase) // map each String to Upper case
				   .scan((prev, next) -> prev + "-" + next)
				   .subscribe(new Ex01_ObserverBasic<String>("TryingTranformOperation"));

		// ---> Filtering Observables like first, skip, distinct, skip, filter, ignoreElements, etc.
		// Operators that selectively emit items from a source Observable
		numberValues.filter(e -> e%2==0)
					.takeLast(2)
					.subscribe(new Ex01_ObserverBasic<Integer>("FilterLastTwoEvenNumbers"));
		
		System.out.println("*************************");
				
		// ---> Combining Observables like zip, merge, etc.
		// Operators that work with multiple source Observables to create a single Observable
		Observable.zip(numberValues, numberWords, (a, b) -> a + "-" + b)
				  .subscribeOn(Schedulers.newThread())
				  .subscribe(new Ex01_ObserverBasic<String>("TryingZipOperation"));
		
		Thread.sleep(1000);
		System.out.println("*************************");
		
		// ---> Mathematical and Aggregate Operators like count, reduce, etc.
		// Operators that operate on the entire sequence of items emitted by an Observable
		numberValues.map(e -> e*10)
					.reduce((a, b) -> a + b)						
					.subscribe(e -> System.out.println("Thread: " + Thread.currentThread().getName() + " | " + e));		
		
		Thread.sleep(1000);
		System.out.println("*************************");
	}	
}
