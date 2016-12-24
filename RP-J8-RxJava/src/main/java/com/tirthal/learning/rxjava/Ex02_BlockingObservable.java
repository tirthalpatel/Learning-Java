package com.tirthal.learning.rxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Example code to understand Observable's non-blocking vs. blocking approach
 * 
 * @author tirthalp
 *
 */
public class Ex02_BlockingObservable {

	public static void main(String[] args) throws InterruptedException {
		
		// Observable.create() usage		 
		tryDefaultBlockingObservable();				// Blocking by default		
		tryNonBlockingSchedulersNewThreadUsage();	// Can be changed to Non-blocking, if require
		
		Thread.sleep(100 * 30);
		print("******************************************");			
		print("******************************************");
		
		// Observable.interval() usage		
		tryDefaultNonBlockingObservable();	    	// Non-blocking by default		
		tryBlockingForEachUsage();					// Can be changed to Blocking, if require
		
		Thread.sleep(100 * 30); 
		print("******************************************");
		print("******************************************");
		print("End of Program");		
	}

	private static void tryDefaultBlockingObservable() {
		// ------- Observable.create: By default data is emitted in blocking manner
		print("(1) Creating an observable with default blocking behavior");
		Observable<Integer> values = Observable.create(o -> {	        
	        o.onNext(1);
	        o.onNext(2);
	        o.onNext(3);
	        o.onComplete();
	    });	    
	    
		print("(2) Subscribe to the ObservableSource and provide a callback to handle the items it emits");
		
		// Default blocking approach, so can't move to next statement without finishing work through current main thread
	    values.subscribe(i -> {
	    	print("Blocking manner: " + i);
	    });
	    
		print("(3) Subscribed, done!!!");								
		print("================================");
	}

	private static void tryNonBlockingSchedulersNewThreadUsage() {
		// ------- How to get data out of an observable in a non-blocking manner instead of default blocking manner?
		print("(1) Creating an observable with default blocking behavior, but will be transitioned to non-blocking manner");
		Observable<Integer> values = Observable.create(o -> {	        
	        o.onNext(1);
	        o.onNext(2);
	        o.onNext(3);
	        o.onComplete();
	    });
		
		print("(2) Asynchronously subscribe an Observer to the ObservableSource on the specified Scheduler");
		
		// Changing to non-blocking approach using Schedulers.newThread(), so moving to next statement without blocking current main thread 
		values.subscribeOn(Schedulers.newThread())
			  .subscribe(i -> {
				   print("Non-blocking manner: " + i);
			  });
		
		print("(3) Subscribed, done!!!");								
		print("================================");
	}

	private static void tryDefaultNonBlockingObservable() {
		// ------- Observable.interval: By default data is emitted in non-blocking manner
		print("(1) Creating an observable to emit sequence number at every 500 ms in default non-blocking manner");
		Observable<Long> values = Observable.interval(500, TimeUnit.MILLISECONDS);
		
		print("(2) Subscribe to the ObservableSource and receive notifications for first five elements");
		
		// Default non-blocking approach, so moving to next statement without blocking current main thread 
		values.take(5)			
			  .forEach(v -> print("Non-blocking manner: " + v.toString())); 
				
		print("(3) Subscribed, done!!!");								
		print("================================");
	}
	
	private static void tryBlockingForEachUsage() {
		// ------- How to get data out of an observable in a blocking manner instead of default non-blocking manner?
		print("(1) Creating an observable to emit sequence number at every 10 ms, but will be transitioned to blocking manner");
		Observable<Long> values = Observable.interval(10, TimeUnit.MILLISECONDS);
		
		print("(2) Subscribe to the ObservableSource and receive notifications for first five elements, but in blocking manner");
		
		// Changing to blocking approach, so can't move to next statement without finishing work through current main thread
		values.take(5)					  
			  .blockingForEach(v -> print("Blocking manner: " + v.toString())); 
		
		print("(3) Subscribed, done!!!");
		print("================================");
	}

	private static void print(String str) {
		StringBuffer sb = new StringBuffer();
		sb.append("Thread: ").append(Thread.currentThread().getName()).append(" ---> ");		
		sb.append(str);
		
		System.out.println(sb.toString());
	}	
}
