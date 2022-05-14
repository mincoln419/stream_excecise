package com.mermer.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest {

	
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate thisYearBirthday = LocalDate.of(2023, Month.APRIL, 18);
		
		Period period = Period.between(today, thisYearBirthday);
		System.out.println(period.getMonths());
		
		Period until = today.until(thisYearBirthday);
		System.out.println(until.get(ChronoUnit.DAYS));
		
		
		
	}
}
