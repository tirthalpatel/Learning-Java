# Package java.util.function

This is a new package from Java 8. There are total of 43 Functional interfaces, which provide target types for lambda expressions and method references. 

Main categories: (1) Consumer (2) Supplier (3) Function (4) Predicate. Other functional interfaces for primitive types such as IntPredicate, IntFunction, IntToDoubleFunction, etc.  

Also refer [oracle documentation](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html).

## Description

Functional interfaces provide target types for lambda expressions and method references. Each functional interface has a single abstract method, called the functional method for that functional interface, to which the lambda expression's parameter and return types are matched or adapted. Functional interfaces can provide a target type in multiple contexts, such as assignment context, method invocation, or cast context:

     // Assignment context
     Predicate<String> p = String::isEmpty;

     // Method invocation context
     stream.filter(e -> e.getSize() > 10)...

     // Cast context
     stream.map((ToIntFunction) e -> e.getSize())...
 
The interfaces in this package are general purpose functional interfaces used by the JDK, and are available to be used by user code as well. While they do not identify a complete set of function shapes to which lambda expressions might be adapted, they provide enough to cover common requirements.

## Sample Code

* The Consumer: It consumes object as parameter of given type (one or two), and does not return anything.
	- [Consumer<T>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/consumers/Ex_ConsumerDemo.java): Represents an operation that accepts a single input argument and returns no result
	- [BiConsumer<T, U>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/consumers/Ex_BiConsumerDemo.java): Represents an operation that accepts two input arguments and returns no result
	- [IntConsumer](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/consumers/Ex_IntConsumerDemo.java): Represents an operation that accepts a single int-valued argument and returns no result.
	- [ObjIntConsumer<T>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/consumers/Ex_ObjIntConsumerDemo.java): Represents an operation that accepts an object-valued and a int-valued argument, and returns no result.
	
* The Supplier: It does not take parameter, and returns an object of given type.
	- [Supplier<T>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/suppliers/Ex_SupplierDemo.java): Represents a supplier of results.	

* The Function: It takes an object as parameter of given type (one or two), and returns another object of same or different type.
	- [Function<T,R>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/functions/Ex_FunctionDemo.java): Represents a function that accepts one argument and produces a result.
	- [BiFunction<T,U,R>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/functions/Ex_BiFunctionDemo.java): Represents a function that accepts two arguments and produces a result.
	- [BinaryOperator<T>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/functions/Ex_BinaryOperatorDemo.java): Represents an operation upon two operands of the same type, producing a result of the same type as the operands.
	
* The Predicate: It takes an object as parameter of given type (one or two), and returns a boolean.
	- [Predicate<T>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/predicates/Ex_PredicateDemo.java): Represents a predicate (boolean-valued function) of one argument.
	- [BiPredicate<T,U>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/predicates/Ex_BiPredicateDemo.java): Represents a predicate (boolean-valued function) of two arguments.

