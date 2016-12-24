# Lambda Expressions/Closures

## What is Lambda?

* Lambda expressions let you express instances of single-method classes more compactly. 
* Lambda is just another way of writing instances of anonymous classes to make them easier to write and read! 
* A Lambda, in general, is a function that expects and accepts input parameters and produce output results. So lambda can be put in a variable; and it can be taken as a method parameter, and can be returned by a method.
* Is a lambda expression an object? - A lambda is an object without an identity (not created the same way objects are created using "new", so it offers better performance compare to anonymous classes at JVM level).
* Benefits of lambda expressions include the following: Concise syntax; Method references and constructor references; Reduced runtime overhead compared to anonymous classes. 
* Basically, they are composed of an arguments section that can be empty, containing 0, 1 or more input parameters, an arrow (->) and a body that can be almost any kind of Java piece of code. These are valid examples in pseudo code:
	- () -> body statement; // no input parameter and just single line of body statement
	- (argument) -> { body }; // just one input parameter and more than one line of code in body
	- (argument1, argument2...) -> { body }; // more than one input parameter and more than one line of code in body


## Understand Lambda by Examples

* [What is purpose of Lambda by Hello World?](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/lambda/Ex01_HelloWorldLambda.java)
* [Understanding Syntaxes of writing Lambda Expression](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/lambda/Ex02_LambdaSyntaxes.java)
* [Usage of new @FunctionalInterface annotation](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/lambda/Ex03_FunctionalInterface.java)
* [How to use Lambda expressions in terms of Delayed execution?](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/lambda/Ex04_DelayedExecution.java)

## Further References

* http://www.oracle.com/technetwork/articles/java/lambda-1984522.html
* http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
* https://github.com/AdoptOpenJDK/lambda-tutorial
* Best practice: [Lambda expression should be glue code](http://blog.agiledeveloper.com/2015/06/lambdas-are-glue-code.html)
