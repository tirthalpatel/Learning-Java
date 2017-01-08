package com.tirthal.learning.libfeatures.java.time;

import java.util.Calendar;
import java.util.Date;

/**
 * Sample code of the java.util.Date API in Java 7 or Prior = Legacy API
 * 
 * @author tirthalp
 */
public class Java7OrPriorWay {

	// Do you know? - Date class is mutable in Java 7 or prior
	
	public static void main(String[] args) {

		// Date and time of just now
		Date dt = new Date();
		System.out.println(dt);

		// How to create a date for 2016 / 08 / 06?
		Calendar cal = Calendar.getInstance(); 	// just now
		cal.set(2016, 07, 06);				 	// January is 0		
		Date aug6th2016 = cal.getTime();
		System.out.println(aug6th2016);
		
		// How to add 7 days to aug6th2016?
		cal.add(Calendar.DAY_OF_MONTH, 7);
		Date oneWeekLater = cal.getTime();
		System.out.println(oneWeekLater);
	}

}
