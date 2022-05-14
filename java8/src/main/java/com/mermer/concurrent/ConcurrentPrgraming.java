package com.mermer.concurrent;

public class ConcurrentPrgraming {

	public static void main(String[] args) {
		//동시성 프로그래밍 - thread의 순서는 보장되지 않는다
		
		MyThread myThread = new MyThread();
		myThread.start();
		
		System.out.println("Hello " + Thread.currentThread().getName());
		
		
		
		
		
	}
	
	//불편한 방법
	static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("Thread " + Thread.currentThread().getName());
		}
	}
}
