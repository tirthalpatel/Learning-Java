package com.tirthal.learning.rxjava;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Example code to understand Observer, which provides a mechanism for receiving push-based notifications.
 * 
 * @author tirthalp
 *
 */
public class Ex01_ObserverBasic<T> implements Observer<T> {

	private String name;
	
	public Ex01_ObserverBasic(String name) {
		this.name = name;
	}	
	
	// Notification sent by Observable, when observer is subscribed
	@Override
	public void onSubscribe(Disposable d) {			
		print("onSubscribe: resource disposed: " + d.isDisposed());
	}

	// Observable calls this method 0 or more times to provide a new item to observe
	@Override
	public void onNext(T value) {			
		print("onNext: " + value);
	}

	// Notifies the Observer that the Observable has experienced an error condition
	@Override
	public void onError(Throwable e) {
		print("onError: " + e);			
	}

	// Notifies the Observer that the Observable has finished sending push-based notifications
	@Override
	public void onComplete() {
		print("onComplete: Completed");			
	}	
	
	private void print(String str) {
		StringBuffer sb = new StringBuffer();
		sb.append("Thread: ").append(Thread.currentThread().getName()).append(" | ");
		sb.append("Observer Name: ").append(name).append(" | ");
		sb.append(str);
		
		System.out.println(sb.toString());
	}	
}