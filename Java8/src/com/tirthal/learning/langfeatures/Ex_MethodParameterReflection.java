package com.tirthal.learning.langfeatures;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * This is example class to demo new feature in reflection to support getting parameter names of method.
 * 
 * <p>
 * For this Java 8 has (1) java.lang.reflect.Executable.getParameters() method and java.lang.reflect.Parameter class (2)
 * javac -parameters compiler flag. That means, if the code is compiled by passing "-parameters" flag and then the
 * parameter names of methods can be returned using the reflection.
 * 
 * <p>
 * Important notes:
 * 
 * <p>
 * (1) The code has to be compiled using "-parameters" flag to get correct names of method parameters. If the code is
 * compiled without using "-parameters" flag, then API is synthesized to return parameter names as arg0, agr1, arg2,
 * ..., argN
 * 
 * <p>
 * (2) To test this in Eclipse, right click the project -> Go to Properties -> Java Compiler -> Enable
 * "Store information about method parameters (usable via reflection)" checkbox. Then, run this class as java
 * application.
 * 
 * @see <a href="https://docs.oracle.com/javase/tutorial/reflect/member/methodparameterreflection.html">Oracle Java Doc - Method Parameter Reflection</a>
 * @author tirthalp
 *
 */
public class Ex_MethodParameterReflection {

	public static void main(String[] args) {

		Method[] methods = HelloWorld.class.getMethods();

		for (Method method : methods) {

			// Restricting to hello() method, otherwise it would show inherited java.lang.Object class methods too
			if ("hello".equals(method.getName())) {
				System.out.print(method.getName() + "(");

				/*
				 * New in Java 8 to get parameter names of the method
				 * 
				 * For example - for hello() of HelloWorld class
				 * 
				 * If code is compiled using flag "-parameters", then output is ---> hello(java.lang.String firstName
				 * java.lang.String lastName int age)
				 * 
				 * If code is compiled without flag "-parameters", then output is ---> hello(java.lang.String arg0
				 * java.lang.String arg1 int arg2)
				 */
				Parameter[] parameters = method.getParameters();

				for (Parameter parameter : parameters) {
					System.out.print(parameter.getType().getName() + " " + parameter.getName() + " ");
				}
				System.out.println(")");
			}
		}
	}

}

// HelloWorld example
class HelloWorld {

	public void hello(String firstName, String lastName, int age) {
		System.out.println("Hello " + firstName + " " + lastName + ", are you " + age + " years old?");
	}

}