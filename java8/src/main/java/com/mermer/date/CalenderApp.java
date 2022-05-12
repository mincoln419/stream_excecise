package com.mermer.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalenderApp {

	
	public static void main(String[] args) {
		
		Calendar calender = new GregorianCalendar(1987, 4, 19);
		System.out.println(calender.getTime());
	}
}
