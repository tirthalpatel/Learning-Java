package com.tirthal.learning.langfeatures.generics;

// ------ Generic Interfaces for getting minimum and maximum value
interface MinMax<T extends Comparable<T>> {
	T min();

	T max();
}

// ------ MyClass implementing MinMax Generic interface
class MyClass<T extends Comparable<T>> implements MinMax<T> {
	T[] vals;

	MyClass(T[] o) {
		vals = o;
	}

	public T min() {
		T v = vals[0];

		for (int i = 1; i < vals.length; i++)
			if (vals[i].compareTo(v) < 0)
				v = vals[i];

		return v;
	}

	public T max() {
		T v = vals[0];

		for (int i = 1; i < vals.length; i++)
			if (vals[i].compareTo(v) > 0)
				v = vals[i];

		return v;
	}
}

/**
 * Test class to demo calling implementation of generic interface
 * 
 * @author tirthalp
 * 
 */
public class A12_GenericInterface {

	public static void main(String[] args) {
		Integer inums[] = {3, 6, 2, 8, 6};
		Character chs[] = {'A', 'r', 'V', 'w'};

		MyClass<Integer> iob = new MyClass<Integer>(inums);
		MyClass<Character> cob = new MyClass<Character>(chs);

		System.out.println("Max value in inums: " + iob.max());
		System.out.println("Min value in inums: " + iob.min());

		System.out.println("Max value in chs: " + cob.max());
		System.out.println("Min value in chs: " + cob.min());
	}

}
