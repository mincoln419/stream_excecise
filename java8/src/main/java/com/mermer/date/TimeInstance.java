package com.mermer.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeInstance {

	
	public static void main(String[] args) {
		Instant instant = Instant.now();
		
		System.out.println(instant);// 기준시 - UTC = GMT = 그리니치 mean time
		System.out.println(instant.atZone(ZoneId.of("UTC")));
		
		//local 기준으로 보려면
		ZonedDateTime zonedDateTime =  instant.atZone(ZoneId.systemDefault());
		System.out.println(zonedDateTime);
		
		//=================================기계용 타임 end
		
		//Human용
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);//서버의 시간 정보를 사용하게 됨
		
		LocalDateTime birthday = 
				LocalDateTime.of(1987, Month.APRIL, 18, 0 , 0 , 0);
		System.out.println(birthday);
		
		ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println(nowInKorea);
		
		Instant nowInstant = Instant.now();
		nowInstant.atZone(ZoneId.of("Asia/Seoul"));
		System.out.println(nowInstant);
		
		
	}
}
