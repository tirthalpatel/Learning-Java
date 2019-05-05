# Java 9

This project contains sample code (along with easy to understand comments) to learn new features and enhancements in Java 9.

Related post is [here](https://tirthalpatel.blogspot.com/2019/05/java9-10-11-highlights-of-new-features-and-enhancements.html)

__Java 9 release date__: September 2017

## How to use?

Just import this project in Intellij / Eclipse as an "Existing Maven Project". If require, do necessary configuration to fix build path errors (e.g. JDK 9).

## Key New Changes in JDK 9 and New Language Features

* __[Jigsaw Project](https://github.com/tirthalpatel/Learning-Java/tree/master/Java9/src/main/java/com/tirthal/learning/langfeatures/jigsaw)__ = Modular JDK + Modular Java Source Code + Modular Run-time Images + Encapsulate Java Internal APIs + Java Platform Module System
    
* __[Milling Project Coin](https://github.com/tirthalpatel/Learning-Java/tree/master/Java9/src/main/java/com/tirthal/learning/langfeatures/mpc)__ = A few very small language changes
    
## Library Improvements and New APIs

* [Factory Methods for Immutable List, Set, Map and Map.Entry](https://github.com/tirthalpatel/Learning-Java/blob/master/Java9/src/main/java/com/tirthal/learning/libfeatures/misc/CollectionFactoryMethodsDemo.java) = Makes it easier to create instances of collections and maps with small numbers of elements
* [Stream API Improvements](https://github.com/tirthalpatel/Learning-Java/blob/master/Java9/src/main/java/com/tirthal/learning/libfeatures/misc/StreamApiImprovementsDemo.java) = Added new methods (dropWhile, takeWhile, iterate, ofNullable)
* [Optional Class Improvements](https://github.com/tirthalpatel/Learning-Java/blob/master/Java9/src/main/java/com/tirthal/learning/libfeatures/misc/OptionalImprovementsDemo.java) = Added new methods (stream, ifPresentOrElse, or)
* [Process API Updates](https://github.com/tirthalpatel/Learning-Java/blob/master/Java9/src/main/java/com/tirthal/learning/libfeatures/misc/ProcessApiImprovementDemo.java) = Improves the API for controlling and managing operating system processes 
* [Stack-Walking API](https://github.com/tirthalpatel/Learning-Java/blob/master/Java9/src/main/java/com/tirthal/learning/libfeatures/misc/StackWalkingDemo.java) = Provides a stack-walking API that allows easy filtering and lazy access to the information in stack traces

* Concurrency
    * [JEP 155: Concurrency Updates](http://openjdk.java.net/jeps/155) = Scalable updatable variables, cache-oriented enhancements to the ConcurrentHashMap API, ForkJoinPool improvements, and additional Lock and Future classes
    * [JEP 266: More Concurrency Updates](http://openjdk.java.net/jeps/266) = An interoperable publish-subscribe framework ([java.util.concurrent.Flow API](https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/Flow.html): interfaces added to JDK; Interoperability for reactive streams projects like RxJava, Akka Streams; HttpClient implements Publisher/Subscriber interfaces; Not meant as an end-user API) + enhancements to the CompletableFuture API 

* [Enhanced @Deprecation annotation](https://docs.oracle.com/javase/9/core/enhanced-deprecation1.htm) = Provides more information about deprecated API with additional two methods forRemoval and since, e.g. @Deprecated(since="9", forRemoval=true)

* New HTTP 2 Client API (incubator module in Java 9) =  Replacement for java.net.HTTPURLConnection, and supports HTTP/2 protocol and WebSocket features

## What's new for Tools, JVM...

#### Tools

* __[The Java Shell / JShell](https://github.com/tirthalpatel/Learning-Java/tree/master/Java9/src/main/java/com/tirthal/learning/tools/jshell)__ = Adds Read-Eval-Print Loop (REPL) functionality to the Java platform
* __[The Java Linker / jlink](https://github.com/tirthalpatel/Learning-Java/tree/master/Java9/src/main/java/com/tirthal/learning/tools/jlink)__ = Enables to link sets of modules (and their transitive dependencies) to create a run-time image
* __[The jdeprscan](https://docs.oracle.com/javase/9/tools/jdeprscan.htm)__ = A static analysis tool that scans a jar file (or some other aggregation of class files) for uses of deprecated API elements

#### Odds and Ends

* [JEP 223: New Version-String Scheme](http://openjdk.java.net/jeps/223) = Provides a simplified version-string format that helps to clearly distinguish major, minor, security, and patch update releases (i.e. $MAJOR.$MINOR.$SECURITY.$PATCH)
* [JEP 248: Make G1 the Default Garbage Collector](https://docs.oracle.com/javase/9/gctuning/garbage-first-garbage-collector.htm) = Makes Garbage-First (G1) the default garbage collector (GC) on 32-bit and 64-bit server configurations (because using a low-pause collector such as G1 provides a better overall experience, for most users, than a throughput-oriented collector such as the Parallel GC, which was previously the default)

## Also See

* [JDK 9 Documentation](https://www.oracle.com/technetwork/java/javase/9-relnotes-3622618.html)
* [Overview of What’s New in JDK 9](https://docs.oracle.com/javase/9/whatsnew/toc.htm)
* [Oracle JDK 9 Migration Guide](https://docs.oracle.com/javase/9/migrate/JSMIG.pdf)
* [Java 9 Features with Examples](https://www.journaldev.com/13121/java-9-features-with-examples)

## Disclaimer

The code snippet are mainly targeted for learning purpose, and not focused for producing production code quality.