# Package java.util.function

Functional interfaces provide target types for lambda expressions and method references. Also refer [oracle documentation](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html).

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

* [Consumer<T>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/Ex_ConsumerDemo.java) - Represents an operation that accepts a single input argument and returns no result
* [BiConsumer<T, U>](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function/Ex_BiConsumerDemo.java) - Represents an operation that accepts two input arguments and returns no result