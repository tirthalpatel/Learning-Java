package com.tirthal.learning.langfeatures.lambda;

/**
 * This is functional interface (also referred as, single method interface = an interface with only one abstract method)
 * 
 * <p>A functional interface can be annotated using - @FunctionalInterface (Optional). It is just here for convenience, the
 * compiler can tell us whether the interface is functional or not!
 * 
 * @author tirthalp
 */
@FunctionalInterface
interface Ex03_HelloWorld {
	void sayHello(String name);

	/*
	 * If you have more than one method, then @FunctionalInterface would inform compiler to throw compile time error -
	 * "Invalid '@FunctionalInterface' annotation; Ex03_HelloWorld is not a functional interface"
	 */
	// void sayBye(String name); // Uncomment to see compile time error
}

/**
 * Demo of function interface implementation using Lambda expression
 * 
 * @author tirthalp
 */
public class Ex03_FunctionalInterface {

	public static void main(String[] args) {
		/*
		 * The type of Lambda expression is a function interface. For example: if you uncomment sayBye() method in the
		 * Ex03_HelloWorld interface, then it would not be functional interface anymore. And you would see this compile
		 * time error - "The target type of this expression must be a functional interface"
		 */
		Ex03_HelloWorld hw = (String name) -> System.out.println("Hello " + name);
		hw.sayHello("Tirthal");
	}

}
