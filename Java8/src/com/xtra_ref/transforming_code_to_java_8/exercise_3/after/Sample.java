package com.xtra_ref.transforming_code_to_java_8.exercise_3.after;

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

	// ------------ Java 8 transformation to make code transparent
	public boolean scheduleIfAvailable() {
		boolean open = isAvailable();
		if (open)
			schedule();
		return open;
	}
	// ------------ Java 8 transformation to make code transparent
}

public class Sample {
	public static void main(String[] args) {
		List<TimeSlot> timeSlots = Arrays.asList(new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot(),
				new TimeSlot(), new TimeSlot());

		// ...

		// ------------ Java 8 transformation to make code transparent
		System.out.println("TimeSlot is " + timeSlots.stream().filter(TimeSlot::scheduleIfAvailable).findFirst());
		// ------------ Java 8 transformation to make code transparent
	}
}