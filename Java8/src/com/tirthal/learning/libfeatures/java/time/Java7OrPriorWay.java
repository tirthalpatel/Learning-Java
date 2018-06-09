package com.tirthal.learning.libfeatures.java.time;

import java.util.Calendar;
import java.util.Date;

/**
 * Sample code of the java.util.Date API in Java 7 or Prior = Legacy API
 * 
 * Existing classes (e.g. java.util.Date and SimpleDateFormatter) are mutable - not thread-safe and can lead to
 * potential concurrency issues.
 * 
 * Some of the date and time classes also exhibit quite poor API design. For example, years in java.util.Date start at
 * 1900, months start at 1, and days start at 0—not very intuitive.
 * 
 * These issues have led to the popularity of third-party date and time libraries, such as Joda-Time.
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
		cal.set(2016, 07, 06);				 	// January is 0, so August is 07 - example of poor design	
		Date aug6th2016 = cal.getTime();
		System.out.println(aug6th2016);
		
		// How to add 7 days to aug6th2016?
		cal.add(Calendar.DAY_OF_MONTH, 7);
		Date oneWeekLater = cal.getTime();
		System.out.println(oneWeekLater);
	}

}
