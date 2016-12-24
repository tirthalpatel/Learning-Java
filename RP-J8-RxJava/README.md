# Getting Started with Reactive Programming with Java 8 using RxJava

This project contains sample code snippet for getting hands dirty with RxJava (an API for asynchronous programming with observable streams). 

[RxJava](https://github.com/ReactiveX/RxJava/wiki) = Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.

## Project Setup Instructions

* Prerequisites: Java 8, Maven
* Just import this project in Eclipse Luna (or any other IDE supporting Java 8) as an "Existing Maven Project". If require, do necessary configuration to fix build path errors (e.g. setup JRE 1.8 Libraries).

## Learnings 

* Functional Reactive Concepts
	* [Functional Programming Concepts](https://github.com/tirthalpatel/Learning-Java/tree/master/RP-J8-RxJava/src/main/java/com/tirthal/learning/concepts) - Pure Functions, Functions as a First Class Citizen, High Order Functions.
	* [The Reactive Manifesto](http://www.reactivemanifesto.org/) - Reactive systems are: Message Driven, Scalable, Resilient, Responsive.
	* [Rx Marbles](http://rxmarbles.com/) - Interactive diagrams of Rx Observables.
	
* RxJava examples
	* ABC of [Obeservable](https://github.com/tirthalpatel/Learning-Java/blob/master/RP-J8-RxJava/src/main/java/com/tirthal/learning/rxjava/Ex01_ObservableBasic.java) and [Observer](https://github.com/tirthalpatel/Learning-Java/blob/master/RP-J8-RxJava/src/main/java/com/tirthal/learning/rxjava/Ex01_ObserverBasic.java)
	* Understanding [Observable's non-blocking vs. blocking behavior](https://github.com/tirthalpatel/Learning-Java/blob/master/RP-J8-RxJava/src/main/java/com/tirthal/learning/rxjava/Ex02_BlockingObservable.java)
	* [Error handling](https://github.com/tirthalpatel/Learning-Java/blob/master/RP-J8-RxJava/src/main/java/com/tirthal/learning/rxjava/Ex03_ErrorHandling.java.java)
	* Play with few [RxJava Operators](https://github.com/tirthalpatel/Learning-Java/blob/master/RP-J8-RxJava/src/main/java/com/tirthal/learning/rxjava/Ex04_Operators.java) / [ReactiveX operators](http://reactivex.io/documentation/operators.html#categorized)
	* Usage of [Subject](https://github.com/tirthalpatel/Learning-Java/blob/master/RP-J8-RxJava/src/main/java/com/tirthal/learning/rxjava/Ex05_SubjectTypes.java)
	
## Also See

* [Intro to RxJava](https://github.com/Froussios/Intro-To-RxJava)
* [Learn RxJava](https://github.com/jhusain/learnrxjava/)
* [RxJava 1 vs. RxJava 2: What's different in 2.0?](https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0)
* [Advanced Reactive Java](http://akarnokd.blogspot.in/)
* [Architecting Reactive Applications on AWS](http://www.slideshare.net/AmazonWebServices/arc206-architecting-reactive-applications-on-aws-aws-reinvent-2014)	