package com.tirthal.learning.rxjava;

import io.reactivex.Observable;

/**
 * Example code to understand error handling in RxJava
 * 
 * @author tirthalp
 *
 */
public class Ex03_ErrorHandling {

	public static void main(String[] args) {
		
		// Creating Observable
		Observable<String> values = Observable.create(o -> {
		    o.onNext("Rx");
		    o.onNext("is");
		    o.onError(new Exception("adjective unknown"));
		});

		// Subscriber providing just onNext callback
		values.subscribe(System.out::println); 
		System.out.println("--------");
		
		// Subscriber providing both onNext and onError callbacks
		values.subscribe(System.out::println, System.out::println); 
		System.out.println("--------");
		
		// onErrorReturn: allows to ignore an error and emit one final value before terminating
		values
		    .onErrorReturn(e -> "Error: " + e.getMessage())
		    .subscribe(v -> System.out.println(v));
		System.out.println("--------");
		
		// onExceptionResumeNext: allows to resume a failed sequence with another sequence without showing error in the resulting observable
		values
		    .onErrorResumeNext(Observable.just("hard"))
		    .subscribe(System.out::println);
		System.out.println("--------");
		
		// retry: re-subscribes to the source and emits everything again from the start
		values
		    .retry(2)
		    .subscribe(System.out::println, System.out::println);
	}
}
