package com.tirthal.learning.exercises.cmp;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	// Quick dirty way of keeping static sample data here
	public static final List<Person> PERSONS_LIST = new ArrayList<Person>();
	static {
		PERSONS_LIST.add(new Person("Tirthal", "Patel", 35));		
		PERSONS_LIST.add(new Person("Adam", "Jackson", 30));
		PERSONS_LIST.add(new Person("Kat", "Wilson", 35));
		PERSONS_LIST.add(new Person("Kat", "Harold", 35));
		PERSONS_LIST.add(new Person("Shail", "Sing", 50));
	}
	
	private String firstName;
	private String lastName;
	private int age;	
	
	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
}
