package com.tirthal.learning.langfeatures.generics;

//---------------------------------------
// --- STEP 00 - HOW TO DEFINE GENERIC CLASS WITH UPPER BOUND?
// ---------------------------------------

/*
 * <? extends T> - It will allow All Types which are either "T" or extends T means subclass of T. 
 * 
 * For example, List<? extends Number> can hold List<Number> or List<Integer> 
 * 			ArrayList<? extends Number> numberList = new ArrayList<Number>(); 
 * 			numberList = new ArrayList<Integer>();
 * 			numberList = new ArrayList<Float>();
 * 
 * Type can be upper bounded by using <ABC extends XYZ>, which means that ABC type must be sub-class of XYZ.
 */

/**
 * I want compiler to make sure that this PaymentMachine class should only accept argument of <T> type which implements the "Payment" interface. Well,
 * this can be easily achieved using upper bounds in generic as shown here - PaymentMachine<T extends Payment>.
 * 
 * @author tirthalp
 * 
 * @param <T> T type of argument must be implementation of "Payment" interface
 */
class PaymentMachine<T extends Payment> {

	private T paymentType;

	PaymentMachine(T t) {
		paymentType = t;
	}

	public T getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(T paymentType) {
		this.paymentType = paymentType;
	}

	public void pay() {
		paymentType.pay();
	}
}

// Payment interface
interface Payment {
	public void pay();
}

// CreditCardPayment implements Payment interface
class CreditCardPayment implements Payment {
	public void pay() {
		System.out.println("Paid by credit card...");
	}
}

// CashPayment implements Payment interface
class CashPayment implements Payment {
	public void pay() {
		System.out.println("Paid by cash...");
	}
}

// BlahBlahPayment doesn't implement Payment interface
class BlahBlahPayment {
	public void pay() {
		System.out.println("blah blah...");
	}
}

// ---------------------------------------
// --- STEP 01 - USE GENERIC CLASS DECLARED WITH UPPER BOUND
// ---------------------------------------

/**
 * Test class for demo of upper bounds in Generic
 * 
 * @author tirthalp
 * 
 */
public class A09_UpperBounds {

	public static void main(String[] args) {

		// --- Try with something wrong to see compile time check
		// Bound mismatch: The type Object is not a valid substitute for the bounded parameter <T extends Payment> of the type PaymentMachine<T>
		// PaymentMachine<Object> wrong = new PaymentMachine<Object>(new String()); // --- uncomment this line to see compile time error

		// --- Only "Payment" type of argument is accepted by PaymentMachine
		PaymentMachine<Payment> pm = new PaymentMachine<Payment>(new CreditCardPayment());
		pm.pay();

		pm.setPaymentType(new CashPayment());
		pm.pay();

		// The method setPaymentType(Payment) in the type PaymentMachine<Payment> is not applicable for the arguments (BlahBlahPayment)
		// pm.setPaymentType(new BlahBlahPayment()); // --- uncomment this line to see compile time error
	}

}

// ---------------------------------------
// --- STEP 02 - WHAT IS MULTIPLE BOUNDS?
// ---------------------------------------

/*
 * A type variable with multiple bounds is a subtype of all the types listed in the bound. If one of the bounds is a class, it must be specified
 * first. For example:
 * 
 * Class A { ... } interface B { ... } interface C { ... }
 * 
 * class D <T extends A & B & C> { ... }
 */