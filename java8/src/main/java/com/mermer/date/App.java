package com.mermer.date;

import java.util.Date;

public class App {

	public static void main(String[] args) throws InterruptedException {
		Date date = new Date(); // 근본적으로 타임스템프
		//Calendar calendar = new GregorianCalendar();
		//SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(date);
		long time = date.getTime();
		
		
		System.out.println(time);//epoch 타임
		
		Thread.sleep(1000 * 3);
		Date after3seconds = new Date();
		System.out.println(after3seconds);
		
		after3seconds.setTime(time);
		System.out.println(after3seconds);
		
		//객체의 상태를 바꿀 수 있음 - mutable.. - 멀티스레드 환경에서 안전하게 쓰기 어렵다
		
	}
	
}
