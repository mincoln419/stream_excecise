package com.example.demo;

public class Moim {

	int maxNumberOfAttendees;
	
	int numberOfEnrollment;
	
	public boolean isEnrollmentFull() {
		if(maxNumberOfAttendees == 0) {
			return false;
		}
		
		if(maxNumberOfAttendees >= numberOfEnrollment) {
			return false;
		}else return true;
		
	}
}
