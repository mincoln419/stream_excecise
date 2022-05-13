package com.mermer.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalenderApp {

	
	public static void main(String[] args) {
		
		Calendar calender = new GregorianCalendar(1987, 4, 19); //month가 0부터 시작되면서 4 -> 5월임..
		System.out.println(calender.getTime());
		
		//joda-time 프로젝트의 계기가 됨.. -> java 표준이 됨: date-time api.. -> Localdatetime, localdate
		
		
	}
}
