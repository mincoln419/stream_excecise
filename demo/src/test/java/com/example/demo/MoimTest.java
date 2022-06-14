package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class MoimTest {

	@Test
	void isFull() {
		Moim moim = new Moim();
		moim.maxNumberOfAttendees = 100;
		moim.numberOfEnrollment = 10;
		assertFalse(moim.isEnrollmentFull());
	}

}
