package com.tirthal.learning.libfeatures.java.util.function.functions;

import java.util.Objects;
import java.util.function.BinaryOperator;

// java.util.function.BinaryOperator operates upon two operands of the same type, producing a result of the same type as the operands
// This is a specialization of BiFunction for the case where the operands and the result are all of the same type

/**
* Sample code to demo syntax of BinaryOperator functional interface usage in Java 8
* 
* @see https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html
* @author tirthalp
*
*/
public class Ex_BinaryOperatorDemo {

	// The input parameters and result are of the same type Integer
	private static BinaryOperator<Integer> F_ADD = (a, b) -> a + b;
	private static BinaryOperator<Integer> F_SUBSTRACT = (a, b) -> a - b;
	private static BinaryOperator<Integer> F_MULTIPLY = (a, b) -> a * b;
	private static BinaryOperator<Integer> F_DEVIDE = (a, b) -> a / b;
	
	private static Integer calculate(Integer n1, Integer n2, BinaryOperator<Integer> f) {
		
		Objects.requireNonNull(n1, "Oops, null parameter is not allowed");
		Objects.requireNonNull(n2, "Oops, null parameter is not allowed");
		Objects.requireNonNull(f, "Oops, null parameter is not allowed");
		
		return f.apply(n1, n2);	// invoke BinaryOperator function	
	}
	
	public static void main(String[] args) {		
		try {
			System.out.printf("%d + %d = %d \n", 15, 3, calculate(15, 3, Ex_BinaryOperatorDemo.F_ADD));
			System.out.printf("%d - %d = %d \n", 15, 3, calculate(15, 3, Ex_BinaryOperatorDemo.F_SUBSTRACT));
			System.out.printf("%d * %d = %d \n", 15, 3, calculate(15, 3, Ex_BinaryOperatorDemo.F_MULTIPLY));
			System.out.printf("%d / %d = %d \n", 15, 3, calculate(15, 3, Ex_BinaryOperatorDemo.F_DEVIDE));

			calculate(null, null, null);
		} catch (NullPointerException e) {
			System.out.print("Oops, null arguments are not allowed");
		}
	}
}
