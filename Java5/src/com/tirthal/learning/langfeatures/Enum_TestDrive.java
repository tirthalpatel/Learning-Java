package com.tirthal.learning.langfeatures;

import java.util.EnumMap;

//---------------------------------------
//--- STEP 00 - WHAT IS ENUM? 
//---------------------------------------

///*
// * Java 1.5 - Language feature - Enum = This flexible object-oriented enumerated type facility allows you to create enumerated types with arbitrary
// * methods and fields. It provides all the benefits of the Typesafe Enum pattern without the verbosity and the error-proneness.
// * 
// * Two new collection classes EnumMap and EnumSet are added into collection package to support Java Enum. These classes are high performance
// * implementation of Map and Set interface in Java and we should use this whenever there is any opportunity.
// * 
// * --- Caution --- (1) Enum constants are implicitly static and final and you can not change there value once created. Enum in Java provides
// * type-safety and can be used inside switch statement like int variables. Since enum is a keyword you can not use as variable name and since its only
// * introduced in JDK 1.5 all your previous code which has enum as variable name will not work and needs to be re-factored. (2) You can not create
// * instance of enums by using new operator in Java because constructor of Enum in Java can only be private and Enums constants can only be created
// * inside Enums itself. (3) Instance of Enum in Java is created when any Enum constants are first called or referenced in code. (4) Enum in Java can
// * implement the interface and override any method like normal class It’s also worth noting that Enum in java implicitly implement
// * both Serializable and Comparable interface. (5) You can define abstract methods inside Enum in Java and can also provide different implementation
// * for different instances of enum in java.
// */

//---------------------------------------
//--- STEP 01 - HOW TO DEFINE ENUM? 
//---------------------------------------

/**
 * OrderStatus enum. Ideally this should be separate "OrderStatus.java" file with public declaration.
 * 
 * @author tirthalp
 * 
 */
enum OrderStatus {
	// Assign value of code and override isChangeable abstract method for each order status
	OPEN("O") {
		@Override
		public boolean isChangeable() {
			return true; // only open order can be changed
		}
	},
	SUBMITTED("S") {
		@Override
		public boolean isChangeable() {
			return false;
		}
	},
	CANCELLED("C") {
		@Override
		public boolean isChangeable() {
			return false;
		}
	},
	DELIEVERED("D") {
		@Override
		public boolean isChangeable() {
			return false;
		}
	};

	private String code;

	private OrderStatus(String code) {
		this.code = code;
	}

	// Is order changeble for given order status?
	// Allow to change only open order
	public abstract boolean isChangeable();

	// Override toString method
	@Override
	public String toString() {
		return super.toString(); // By default, it would return enum constant which you may override
	}
}

//---------------------------------------
//--- STEP 02 - UNDERSTAND USAGE OF ENUM BY EXAMPLE 
//---------------------------------------

/**
 * Test class for OrderStatus enum
 * 
 * @author tirthalp
 * 
 */
public class Enum_TestDrive {

	public static void main(String[] args) {
		OrderStatus openOder = OrderStatus.OPEN;

		// enum comparison
		if (openOder == OrderStatus.OPEN) {
			System.out.println("enum in java can be compared using ==");
		}
		if (openOder.equals(OrderStatus.OPEN)) {
			System.out.println("enum in java can be compared using equals()");
		}

		// check is it possible to change order?
		if (openOder.isChangeable())
			System.out.println("Order can be changed in open status and before submitting it");
		if (!OrderStatus.DELIEVERED.isChangeable())
			System.out.println("Order cannot be changed after order delivery");

		// print enum values
		for (OrderStatus ostatus : OrderStatus.values()) {
			System.out.println(ostatus); // this will call overrided toString() method
		}

		// Also this will call overrided toString() method
		System.out.println(OrderStatus.SUBMITTED);
		
		System.out.println("----");
		// --- Example of EnumMap - creating EnumMap in java with key as enum type
		EnumMap<OrderStatus, String> orderStatusMap = new EnumMap<OrderStatus, String>(OrderStatus.class); 
		orderStatusMap.put(OrderStatus.OPEN, "Open Order");
		orderStatusMap.put(OrderStatus.DELIEVERED, "Order Delivered");		
		orderStatusMap.put(OrderStatus.CANCELLED, "Order Cancelled");		
		orderStatusMap.put(OrderStatus.SUBMITTED, "Order Submitted");		
		
		System.out.println("Size of OrderStatus Enum Map = " + orderStatusMap.size());
		System.out.println("OrderStatus Map = " + orderStatusMap);
		System.out.println("OrderStatus.OPEN = " + orderStatusMap.get(OrderStatus.OPEN));
	}
}


