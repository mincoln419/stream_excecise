package com.mermer.date;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationTest {

	public static void main(String[] args) {
		
		Instant now = Instant.now();
		Instant plus = now.plus(10, ChronoUnit.SECONDS);
		Duration duration = Duration.between(now, plus);
		System.out.println(duration.getSeconds());
	}
}
