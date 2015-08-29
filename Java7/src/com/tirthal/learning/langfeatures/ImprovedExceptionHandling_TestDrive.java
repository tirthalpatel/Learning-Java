package com.tirthal.learning.langfeatures;

// Project Coin Feature - Catching Multiple Exception Types and Rethrowing Exceptions with Improved Type Checking

/*
 * In Java 7 and later,
 *
 * Handling More Than One Type of Exception = a single catch block can handle more than one type of exception.
 * This feature can reduce code duplication and lessen the temptation to catch an overly broad exception.
 *
 * Rethrowing Exceptions with More Inclusive Type Checking = compiler performs more precise analysis of rethrown exceptions than earlier releases of Java SE.
 * This enables you to specify more specific exception types in the throws clause of a method declaration.
 */

/**
 * Test class for improved exceptional handling syntax
 *
 * @author tirthalp
 *
 */
@SuppressWarnings("serial")
public class ImprovedExceptionHandling_TestDrive {

	// Sample custom exception classes
	private static class FirstException extends Exception {	}
	private static class SecondException extends Exception { }

	public static void main(String[] args) throws Exception {

		// --------------- Handling More Than One Type of Exception ------------------------------

		// --- Prior to Java 7
		try {
			rethrowException("First");
		// Contains duplicate code in ex1 and ex2 catch blocks
		} catch (FirstException ex1) {
			System.out.println("Custom exception - " + ex1);
			throw ex1;
		} catch (SecondException ex2) {
			System.out.println("Custom exception - " + ex2);
			throw ex2;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		// --- In Java 7 and later
		// A single catch block can handle more than one type of exception
		try {
			rethrowException("First");
		// The catch clause specifies the types of exceptions that the block can handle, and each exception type is separated with a vertical bar (|).
		// If a catch block handles more than one exception type, then the catch parameter is implicitly final. In this example, the catch parameter "ex" is final and therefore you cannot assign any values to it within the catch block.
		} catch (FirstException | SecondException ex) {
			System.out.println("Custom exception - " + ex);
			throw ex;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	// --------------- Rethrowing Exceptions with More Inclusive Type Checking ---------------

	// --- Prior to Java 7
	/*
	 * In below method declaration, the try block could throw either FirstException or SecondException. Suppose you want to specify these exception types in the throws clause of the rethrowException method declaration.
	 * In releases prior to Java SE 7, you cannot do so. Because the exception parameter of the catch clause, e, is type Exception, and the catch block rethrows the exception parameter e,
	 * you can only specify the exception type Exception in the throws clause of the rethrowException method declaration.
	 */
	@SuppressWarnings("unused")
	private static void rethrowExceptionPriorToJava7(String exceptionName) throws Exception {
		try {
			if (exceptionName.equals("First")) {
				throw new FirstException();
			} else {
				throw new SecondException();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	// --- In Java 7 and later
	/*
	 * In Java SE 7, you can specify the exception types FirstException and SecondException in the throws clause in the rethrowException method declaration.
	 * The Java SE 7 compiler can determine that the exception thrown by the statement throw e must have come from the try block, and the only exceptions thrown by the try block can be FirstException and SecondException.
	 * Even though the exception parameter of the catch clause, e, is type Exception, the compiler can determine that it is an instance of either FirstException or SecondException.
	 */
	private static void rethrowException(String exceptionName) throws FirstException, SecondException {
		try {
			if (exceptionName.equals("First")) {
				throw new FirstException();
			} else {
				throw new SecondException();
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
