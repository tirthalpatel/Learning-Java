package com.xtra_ref.transforming_code_to_java_8.exercise_3.before;

import java.util.*;

class TimeSlot {

	static Random random = new Random();

	public void schedule() {
		// ...
	}

	public boolean isAvailable() {
		// ...
		return random.nextBoolean();
	}
}

public class Sample {
	public static void main(String[] args) {
		List<TimeSlot> timeSlots = Arrays.asList(new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot(),
				new TimeSlot(), new TimeSlot());

		// ...

		// ------------ Prior to Java 8 way - using logic
		TimeSlot firstAvailableTimeSlot = null;
		for (TimeSlot timeSlot : timeSlots) {
			if (timeSlot.isAvailable()) {
				timeSlot.schedule();
				firstAvailableTimeSlot = timeSlot;
				break;
			}
		}

		System.out.println("TimeSlot is " + firstAvailableTimeSlot);
		// ------------ Prior to Java 8 way - using logic
	}
}