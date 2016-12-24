package com.tirthal.learning.rxjava;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

/**
 * Example code to understand Subject in RxJava
 * 
 * @author tirthalp
 *
 */
public class Ex05_SubjectTypes {

	public static void main(String[] args) {
		/*
		 * Subjects are an extension of the Observable that also implements the Observer interface. A Subject is a sort
		 * of bridge or proxy that acts both as an Subscriber and as an Observable. Because it is a Subscriber, it can
		 * subscribe to one or more Observables, and because it is an Observable, it can pass through the items it
		 * observes by reemitting them, and it can also emit new items. There are a few different implementations of
		 * Subject such as PublishSubject, ReplaySubject, BehaviorSubject, AsyncSubject, etc.
		 */
		tryPublishSubject();
		tryReplaySubject();
		tryBehaviorSubject();
		tryAsyncSubject();
	}

	// When a value is pushed into a PublishSubject, the subject pushes it to every subscriber that is subscribed to it at that moment
	private static void tryPublishSubject() {
		Subject<Integer> s = PublishSubject.create();
		s.subscribe(new Ex01_ObserverBasic<Integer>("PublishSubjectTrial-Early")); 
		s.onNext(1);	// This will not be pushed to "PublishSubjectTrial-Late"
		s.subscribe(new Ex01_ObserverBasic<Integer>("PublishSubjectTrial-Late")); 
		s.onNext(2);
		s.onNext(3);
		s.onNext(4);
		s.onComplete();
		System.out.println("-------------");
	}

	// When a new subscription is made, the event sequence is replayed from the start via cache for the new subscriber
	private static void tryReplaySubject() {
		Subject<Integer> s = ReplaySubject.create();  
		s.subscribe(new Ex01_ObserverBasic<Integer>("TryReplaySubject-Early"));
		s.onNext(1);
		s.onNext(2);
		s.subscribe(new Ex01_ObserverBasic<Integer>("TryReplaySubject-Late")); 
		s.onNext(3);
		s.onComplete();
		System.out.println("-------------");
	}

	// BehaviorSubject only remembers the last value
	private static void tryBehaviorSubject() {
		Subject<Integer> s = BehaviorSubject.create();		
		s.onNext(1);
		s.subscribe(new Ex01_ObserverBasic<Integer>("TryBehaviorSubject-Early"));
		s.onNext(2);
		s.onNext(3);
		s.subscribe(new Ex01_ObserverBasic<Integer>("TryBehaviorSubject-Late")); 
		s.onNext(4);
		s.onComplete();
		System.out.println("-------------");
	}

	// AsyncSubject also caches the last value, but doesn't emit anything until the sequence completes
	private static void tryAsyncSubject() {
		Subject<Integer> s = AsyncSubject.create();
		s.subscribe(new Ex01_ObserverBasic<Integer>("TryAsyncSubject-Early"));
		s.onNext(1);
		s.onNext(2);
		s.onNext(3);
		s.subscribe(new Ex01_ObserverBasic<Integer>("TryAsyncSubject-Late"));
		s.onNext(4);
		s.onComplete();
		System.out.println("-------------");
	}
}
