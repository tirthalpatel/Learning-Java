package com.xtra_ref.transforming_code_to_java_8.exercise_5.after;

public class Person {
	private final String name;
	private final int age;

	public Person(String theName, int theAge) {
		name = theName;
		age = theAge;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return String.format("%s -- %d", name, age);
	}
	
	// ----- Java 8 code transformation - Removed Comparable implementation
}