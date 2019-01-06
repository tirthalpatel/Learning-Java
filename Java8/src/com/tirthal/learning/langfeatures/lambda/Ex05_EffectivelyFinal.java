package com.tirthal.learning.langfeatures.lambda;

/**
 * What is Effectively Final variable of Java 8?
 * 
 * Java 8 has introduced a new concept called "effectively final" variable. A non-final local variable or method
 * parameter whose value is never changed after initialization is known as effectively final.
 * 
 * @author tirthalp
 */
public class Ex05_EffectivelyFinal {

	public static void main(String... args) {

		// --- Prior to Java 8 vs in Java 8
		// Till Java 7, you cannot use a non-final local variable inside an anonymous class, but from Java 8 you can.
		String nonFinal = "I am non final local variable";
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("*** Using non-final local variable inside anonymous class in Java");
				System.out.println("Value of non-final variable is : " + nonFinal);

				// Uncommenting below line gives compile time error - must be final or effective final
				// nonFinal = "Can I change non-final variable inside anonymous class";
			}
		};
		Thread t = new Thread(r);
		t.start();

		// Effective final with Lambda
		String effectiveFinal = "I am non final local variable";
		r = () -> {
			System.out.println("*** Using non-final local variable with Lambda in Java");
			System.out.println("Value of effectively variable is : " + effectiveFinal);
		};
		t = new Thread(r);
		t.start();

		// Another example of effective final in Java 8
		for(int i=1; i<=5; i++) {
			
			// The counter variable is effectively final, b'cas its value is never changed after initialization
			int counter = i;
			
			r = () -> {							
				// Uncommenting below line gives compile time error - must be final or effective final
				// System.out.println("Value of effectively variable is : " + i);
								
				System.out.println("Value of effectively variable is : " + counter);
			};
			
			// Uncommenting below line gives compile time error again - must be final or effective final
			// counter = 0;
			
			t = new Thread(r);
			t.start();
		}
	}
}
