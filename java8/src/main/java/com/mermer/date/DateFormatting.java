package com.mermer.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateFormatting {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(now.format(MMddyyyy));
		
		
		LocalDate parse = LocalDate.parse("04/19/1987", MMddyyyy);
		System.out.println(parse);
		
		Date date = new Date();
		Instant instant = date.toInstant();
		Date newDate = Date.from(instant);
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		LocalDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDateTime();
		
		ZonedDateTime zonedDateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault())
				;
		ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
		
		TimeZone timeZone = TimeZone.getTimeZone(zoneId);
		
	}
}
