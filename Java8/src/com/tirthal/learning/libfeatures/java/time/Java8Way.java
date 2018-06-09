package com.tirthal.learning.libfeatures.java.time;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Understanding usage of the new java.time package APIs in Java 8
 * 
 * Provides excellent support for the international ISO 8601 time standard that global businesses use and also supports
 * the frequently used Japanese, Minguo, Hijrah, and Thai Buddhist calendars.
 * 
 * Introduces a new java.time API with a fluent and familiar style that is easy to read and write.
 * 
 * Each of the new classes�for date, time, date and time combined, time zones, instants, duration, and clocks�has a
 * specific purpose and has explicitly defined behavior without side effects. New domain-driven design concepts such as:
 * 		- An Instant: is a point on time line 
 * 		- Duration: is amount of time between two instant 
 * 		- Period: is amount of time between two LocalDate 
 * 		- DateAdjuster and TemporalAdjusters: are useful to add or subtract amount of time to an Instant or LocalDate.
 * 
 * Immutable classes to simplify concurrency issues when used in multitasking environments.
 * 
 * @author tirthalp
 */
public class Java8Way {

	// Do you know? - Most these new classes are immutable like Instant, Duration, LocalDate, etc.
	
	public static void main(String[] args) throws InterruptedException {
		
		// New Concept: An Instant, which is a point on time line
		// Instant 0 is the January the 1st, 1970 at midnight GMT
		Instant start = Instant.now();	
		Thread.sleep(1000); // some long computation
		Instant end = Instant.now();
		System.out.printf("Start: %s & End: %s \n", start, end);
		
		// New Concept: Duration, which is amount of time between two instant
		Duration elapsed = Duration.between(start, end);
		System.out.println("Time elapsed in millis: " + elapsed.toMillis());

		// New Concept: LocalDate, LocalTime, LocalDateTime
		System.out.println("Local date of day:" + LocalDate.now());
		System.out.println("Local time of day:" + LocalTime.now());
		System.out.println("Local date-time of day:" + LocalDateTime.now());
		LocalTime morningAlarm = LocalTime.of(7, 30);
		LocalTime nightAlarm = morningAlarm.plusHours(15);
		System.out.printf("Morning alarm: %s & Night alarm: %s \n", morningAlarm, nightAlarm);
		
		// New Concept: Period, which is amount of time between two LocalDate
		LocalDate myBirthDate = LocalDate.of(1981, Month.AUGUST, 06);
		Period p = myBirthDate.until(LocalDate.now());
		System.out.printf("My age is: %s years \n", p.getYears());
		
		// New Concept: DateAdjuster and TemporalAdjusters, which are useful to add or subtract amount of time to an Instant or LocalDate
		LocalDate now = LocalDate.now();
		LocalDate nextMonday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.printf("Next Monday is on: %s \n", nextMonday);
		
		// New Concept: ZonedDateTime
		System.out.println("The set of available zone IDs all over the earth: " + ZoneId.getAvailableZoneIds());
		ZonedDateTime currentMeetingParis = ZonedDateTime.of(LocalDate.of(2017, Month.JANUARY, 20), 
															 LocalTime.of(11, 30), 
															 ZoneId.of("Europe/Paris"));
		ZonedDateTime nextMeetingParis = currentMeetingParis.plusMonths(1);		
		ZonedDateTime nextMeetingUS = nextMeetingParis.withZoneSameInstant(ZoneId.of("US/Central"));
		System.out.printf("%s - %s - %s \n", currentMeetingParis, nextMeetingParis, nextMeetingUS);
		
		// New DateTimeFormatter
		System.out.printf("%s vs. %s vs. %s \n", nextMeetingUS, 
												 DateTimeFormatter.ISO_DATE_TIME.format(nextMeetingUS), 
												 DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMeetingUS));
		
		// How to interoperate between Legacy & new Java 8 Date Time API?		
		Date date = Date.from(Instant.now()); 	// New Java 8 API -> Legacy
		Instant instant = date.toInstant();		// Legacy -> New Java 8 API
		System.out.println(date + " <-> " + instant);
	}

}
