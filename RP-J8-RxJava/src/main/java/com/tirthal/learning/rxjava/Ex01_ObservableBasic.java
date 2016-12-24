package com.tirthal.learning.rxjava;

import io.reactivex.Observable;

/**
 * Example code to understand Obeservable.
 * 
 * @author tirthalp
 * 
 */
public class Ex01_ObservableBasic {

	public static void main(String[] args) throws InterruptedException {		
		
		/*
		 * In RxJava an object that implements the Observer interface subscribes to an object of the Observable class.
		 * Then that subscriber reacts to whatever item or sequence of items the Observable object emits. This pattern
		 * facilitates concurrent operations because it does not need to block while waiting for the Observable to emit
		 * objects, but instead it creates a sentry in the form of a subscriber that stands ready to react appropriately
		 * at whatever future time the Observable does so.
		 */
		
		// How to create Observable? See @ https://github.com/ReactiveX/RxJava/wiki/Creating-Observables
		
		// --- Example 1: Create Observable using "just" operator
		
		// (1) Create observable and emit sequence of items
		Observable<String> colors = Observable.just("red", "blue", "yellow");
		
		// (2) Observable sends push-based notifications to subscribed observers for reacting to those emitted items. See @ Ex01_ObserverBasic
		colors.subscribe(new Ex01_ObserverBasic<String>("First"));			
		colors.subscribe(new Ex01_ObserverBasic<String>("Second"));						
		
		// --- Example 2: Create Observable using "range" operator and filter odd numbers, then provide callback code to handle push-based notifications		
		Observable<Integer> oddNumbers = Observable.range(1, 10).filter(n -> n%2!=0); 		
		
		oddNumbers.subscribe(new Ex01_ObserverBasic<Integer>("Third"));		

		// Java 8 lambda syntax
		oddNumbers.subscribe(System.out::println, 						// onNext
							 System.out::println, 						// onError
							 () -> System.out.println("Completed")); 	// onComplete	
		
		// ---------------->>> IMPORTANT NOTE <<<---------------------		
		/*
		 * Because Rx is targeted at asynchronous systems and because Rx can naturally support multithreading, new Rx
		 * developers sometimes assume that Rx is multithreaded by default. It is important clarify before anything else
		 * that Rx is single-threaded by default.
		 * 
		 * Unless you specify otherwise, every call to onNext/onError/onCompleted executes the entire chain of operators
		 * synchronously, including the actions of the final subscriber.
		 * 
		 * Run this code and see single-threaded execution
		 */
	}	
}

